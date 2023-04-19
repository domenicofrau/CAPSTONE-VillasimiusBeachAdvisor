import { Component, OnInit } from '@angular/core';
import { SpiaggeService } from "../../../services/spiagge.service";
import { MeteoService } from "../../../services/meteo.service";
import { Spiaggia } from '../../../interfaces/spiaggia.interface';

declare var google: any;

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {

  map: any;
  spiagge: Spiaggia[] = [];

  constructor(private spiaggeService: SpiaggeService, private meteoService: MeteoService) { }

  async ngOnInit(): Promise<void> {
    this.initMap();
    this.loadMarkers();
  }

  async initMap(): Promise<void> {
    const mapContainer = document.getElementById('map');
    const mapOptions = {
      center: new google.maps.LatLng(39.117889, 9.490248),
      zoom: 8,
      minZoom: 12.5,
      maxZoom: 16,
      zoomControl: true,
      fullscreenControl: true,
      mapTypeControl: false,
      streetViewControl: false,
      mapTypeId: google.maps.MapTypeId.TERRAIN,
      styles: [
        {
          featureType: "water",
          elementType: "geometry",
          stylers: [
            { color: "#193341" }
          ]
        },
        {
          featureType: "landscape",
          elementType: "geometry",
          stylers: [
            { color: "#E0DDCD" },
          ]
        },
        {
          featureType: "road",
          elementType: "geometry",
          stylers: [
            { color: "#F2F2F2" },
            { lightness: -37 }
          ]
        },
        {
          featureType: "poi",
          elementType: "geometry",
          stylers: [
            { color: "#E0DDCD" }
          ]
        },
        {
          featureType: "transit",
          elementType: "geometry",
          stylers: [
            { color: "#E0DDCD" }
          ]
        },
        {
          elementType: "labels.text.stroke",
          stylers: [
            { visibility: "on" },
            { color: "#3e606f" },
            { weight: 2 },
            { gamma: 0.84 }
          ]
        },
        {
          elementType: "labels.text.fill",
          stylers: [
            { color: "#ffffff" }
          ]
        },
        {
          featureType: "administrative",
          elementType: "geometry",
          stylers: [
            { weight: 0.6 },
            { color: "#E0DDCD" }
          ]
        },
        {
          elementType: "labels.icon",
          stylers: [
            { visibility: "off" }
          ]
        },
        {
          featureType: "poi.park",
          elementType: "geometry",
          stylers: [
            { color: "#E0DDCD" }
          ]
        }
      ]
    };
    this.map = new google.maps.Map(mapContainer, mapOptions);
    try {
      this.spiagge = await this.spiaggeService.getSpiagge();
    } catch (error) {
      console.error(error);
    }
  }

  async loadMarkers(): Promise<void> {
    const villasimiusCoordinates = { lat: 39.145193, lng: 9.535488 };
    const meteoData = await this.meteoService.getWeatherData(villasimiusCoordinates.lat, villasimiusCoordinates.lng).catch((error) => {
      console.error(error);
      return null;
    });

    if (meteoData !== null) {
      const spiagge = await this.spiaggeService.getSpiagge().catch((error) => {
        console.error(error);
        return [];
      });

      const windSpeed = meteoData.wind.speed;
      const windDirection = meteoData.wind.direction;

      for (let i = 0; i < spiagge.length; i++) {
        const spiaggia = spiagge[i];
        const condizione = this.spiaggeService.calcolaCondizioneSpiaggia(
          windSpeed,
          windDirection,
          spiaggia.pessimaDirezioneVento,
          spiaggia.ottimaDirezioneVento
        );
        spiaggia.condizione = condizione;
        this.addMarker(spiaggia);
      }
    }
  }

  addMarker(spiaggia: Spiaggia): void {
    const color = this.getColorByCondition(spiaggia.condizione);
    const icon = {
      path: google.maps.SymbolPath.CIRCLE,
      fillColor: color,
      fillOpacity: 1,
      strokeColor: color,
      strokeWeight: 1,
      scale: 8,
    };

    const marker = new google.maps.Marker({
      position: new google.maps.LatLng(spiaggia.latitudine, spiaggia.longitudine),
      map: this.map,
      title: spiaggia.nome,
    });

    marker.setIcon(icon);
  }

  getColorByCondition(condition: string): string {
    switch (condition) {
      case 'Ottimo, consigliato':
        return '#4ad568';
      case 'Condizioni buone':
        return '#4a99d5';
      case 'Vento non fastidioso':
        return '#d5b24a';
      case 'Al momento, sconsigliato':
        return '#d5634a';
      default:
        return '#000000';
    }
  }

}
