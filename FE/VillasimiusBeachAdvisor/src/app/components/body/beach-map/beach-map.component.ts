import { Component, OnInit, AfterViewInit, Input, ViewChild, ElementRef } from '@angular/core';


declare var google: any;

@Component({
  selector: 'app-beach-map',
  templateUrl: './beach-map.component.html',
  styleUrls: ['./beach-map.component.css']
})
export class BeachMapComponent implements OnInit, AfterViewInit {
  @Input() lat: number | undefined;
  @Input() lng: number | undefined;
  @ViewChild('mapContainer', { static: false }) mapContainer!: ElementRef;

  map: any;

  constructor() {}

  ngOnInit(): void {}

  ngAfterViewInit(): void {
    if (this.lat !== undefined && this.lng !== undefined) {
      this.initMap();
    }
  }

  initMap(): void {
    const mapOptions = {
      center: new google.maps.LatLng(this.lat, this.lng),
      zoom: 16,
      mapTypeId: google.maps.MapTypeId.SATELLITE,
      disableDefaultUI: true,
      draggable: true,
      zoomControl: false,
      scrollwheel: true,
      disableDoubleClickZoom: true,
      styles: [
        {
          featureType: 'all',
          elementType: 'labels.icon',
          stylers: [{ visibility: 'off' }]
        },
        {
          featureType: 'poi.business',
          elementType: 'all',
          stylers: [{ visibility: 'off' }]
        },
        {
          featureType: 'poi.medical',
          elementType: 'all',
          stylers: [{ visibility: 'off' }]
        },
        {
          featureType: 'poi.school',
          elementType: 'all',
          stylers: [{ visibility: 'off' }]
        },
        {
          featureType: 'poi.sports_complex',
          elementType: 'all',
          stylers: [{ visibility: 'off' }]
        }
      ]
    };

    this.map = new google.maps.Map(this.mapContainer.nativeElement, mapOptions);

    const marker = new google.maps.Marker({
      position: new google.maps.LatLng(this.lat, this.lng),
      map: this.map
    });

    // Remove the "Map data © Google" element from the map
    google.maps.event.addListenerOnce(this.map, 'idle', () => {
      const mapDataElement = this.mapContainer.nativeElement.querySelector('.gm-style > div > a');
      if (mapDataElement) {
        mapDataElement.style.display = 'none';
      }
    });
  }
}
