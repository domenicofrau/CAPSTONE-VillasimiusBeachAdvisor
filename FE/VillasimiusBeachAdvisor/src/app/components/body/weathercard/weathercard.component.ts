import { Component, OnInit } from '@angular/core';
import { MeteoService } from '../../../services/meteo.service';

@Component({
  selector: 'app-weathercard',
  templateUrl: './weathercard.component.html',
  styleUrls: ['./weathercard.component.scss']
})
export class WeathercardComponent implements OnInit {
  windSpeed: number = 0;
  temperature: number = 0;
  windDeg: number = 0;
  windDirection: string = "";
  description: string = "";
  humidity: number = 0;
  latitude: number = 39.117889;
  longitude: number = 9.490248;

  constructor(private meteoService: MeteoService) { }

  async ngOnInit() {
    const data = await this.meteoService.getWeatherData(this.latitude, this.longitude);
    if (data) {
      const wind = data.wind;
      this.windSpeed = Math.round(wind.speed * 3.6);
      this.temperature = Math.round((data.main.temp - 273.15) * 10) / 10;
      this.windDeg = wind.deg;
      this.description = data.weather[0].description;
      this.humidity = data.main.humidity;
      this.windDirection = this.meteoService.convertWindDirection(this.windDeg);
    }
  }
}


