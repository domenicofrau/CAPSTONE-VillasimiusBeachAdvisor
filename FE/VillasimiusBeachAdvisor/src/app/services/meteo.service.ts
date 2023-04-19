import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { datiMeteo } from '../interfaces/datiMeteo.interface';

@Injectable({
  providedIn: 'root',
})
export class MeteoService {
  private API_LINK = 'http://api.openweathermap.org/data/2.5/weather';
  private APPID = '6b5113a3ee3a0578427cac338577119d';
  private meteoDataCache: Map<string, datiMeteo> = new Map();

  constructor(private httpClient: HttpClient) {}

  async getWeatherData(lat: number, lon: number): Promise<datiMeteo | null> {
    const cacheKey = `${lat}_${lon}`;

    if (this.meteoDataCache.has(cacheKey)) {
      return this.meteoDataCache.get(cacheKey) as datiMeteo;
    }

    try {
      const response = await this.httpClient
        .get<datiMeteo>(
          `${this.API_LINK}?lat=${lat}&lon=${lon}&appid=${this.APPID}`
        )
        .toPromise();

      if (!response) {
        return null;
      }

      response.wind.direction = this.convertWindDirection(response.wind.deg);
      this.meteoDataCache.set(cacheKey, response);
      return response;
    } catch (error) {
      console.error(error);
      return null;
    }
  }

  convertWindDirection(degree: number): string {
    let direction = "";
    if (degree >= 1 && degree <= 20) {
      direction = "TRAMONTANA";
    } else if (degree >= 21 && degree <= 69) {
      direction = "GRECALE";
    } else if (degree >= 70 && degree <= 109) {
      direction = "LEVANTE";
    } else if (degree >= 110 && degree <= 159) {
      direction = "SCIROCCO";
    } else if (degree >= 160 && degree <= 199) {
      direction = "OSTRO";
    } else if (degree >= 200 && degree <= 249) {
      direction = "LIBECCIO";
    } else if (degree >= 250 && degree <= 289) {
      direction = "PONENTE";
    } else if (degree >= 290 && degree <= 339) {
      direction = "MAESTRALE";
    } else if (degree >= 340 && degree <= 360) {
      direction = "TRAMONTANA";
    }

    return direction;
  }
}
