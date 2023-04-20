import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Spiaggia } from '../interfaces/spiaggia.interface';
import { MeteoService } from './meteo.service';

@Injectable({
  providedIn: 'root',
})
export class SpiaggeService {
  constructor(private httpClient: HttpClient, private meteoService: MeteoService) { }

  async getSpiagge(): Promise<Spiaggia[]> {
    try {
      const spiaggeResponse: Spiaggia[] | undefined = await this.httpClient
        .get<Spiaggia[]>('http://localhost:8080/api/spiagge')
        .toPromise();

      if (!Array.isArray(spiaggeResponse)) {
        console.error('Errore nel recupero delle spiagge: dati non disponibili');
        return [];
      }

      const spiagge: Spiaggia[] = spiaggeResponse;
      const villasimiusLatitudine = 39.127560;
      const villasimiusLongitudine = 9.516038;

      const meteoData = await this.meteoService.getWeatherData(villasimiusLatitudine, villasimiusLongitudine);

      if (meteoData !== null) {
        const windDirection = meteoData.wind.direction;

        for (const spiaggia of spiagge) {
          const condizione = this.calcolaCondizioneSpiaggia(
            meteoData.wind.speed,
            windDirection,
            spiaggia.pessimaDirezioneVento,
            spiaggia.ottimaDirezioneVento
          );
          spiaggia.condizione = condizione;
        }
      }

      const sortedSpiagge = this.sortSpiagge(spiagge);
      return sortedSpiagge;
    } catch (error) {
      console.error('Errore nel recupero delle spiagge:', error);
      return [];
    }
  }

  calcolaCondizioneSpiaggia(windSpeed: number, windDirection: string, pessimaDirezioneVentoList: string[], ottimaDirezioneVentoList: string[]): string {
    const isOttima = ottimaDirezioneVentoList.includes(windDirection);
    const isPessima = pessimaDirezioneVentoList.includes(windDirection);

    if (isOttima) {
      return "Ottimo, consigliato";
      // } else if (isPessima) {
      //   return "Al momento, sconsigliato";
    } else {
      if (windSpeed > 8) {
        return "Al momento, sconsigliato";
      } else if (windSpeed >= 4 && windSpeed <= 8) {
        return "Vento non fastidioso";
      } else {
        return "Condizioni buone";
      }
    }
  }

  private sortSpiagge(spiagge: Spiaggia[]): Spiaggia[] {
    const order = [
      "Ottimo, consigliato",
      "Condizioni buone",
      "Vento non fastidioso",
      "Al momento, sconsigliato"
    ];

    const groupedSpiagge = this.groupSpiaggeByCondition(spiagge);

    for (const key in groupedSpiagge) {
      groupedSpiagge[key] = this.shuffleArray(groupedSpiagge[key]);
    }

    const sortedSpiagge: Spiaggia[] = [];

    for (const condition of order) {
      if (groupedSpiagge[condition]) {
        sortedSpiagge.push(...groupedSpiagge[condition]);
      }
    }

    return sortedSpiagge;
  }

  private groupSpiaggeByCondition(spiagge: Spiaggia[]): { [key: string]: Spiaggia[] } {
    const groupedSpiagge: { [key: string]: Spiaggia[] } = {};

    for (const spiaggia of spiagge) {
      if (!groupedSpiagge[spiaggia.condizione]) {
        groupedSpiagge[spiaggia.condizione] = [];
      }
      groupedSpiagge[spiaggia.condizione].push(spiaggia);
    }

    return groupedSpiagge;
  }

  private shuffleArray(array: any[]): any[] {
    for (let i = array.length - 1; i > 0; i--) {
      const j = Math.floor(Math.random() * (i + 1));
      [array[i], array[j]] = [array[j], array[i]];
    }
    return array;
  }

}
