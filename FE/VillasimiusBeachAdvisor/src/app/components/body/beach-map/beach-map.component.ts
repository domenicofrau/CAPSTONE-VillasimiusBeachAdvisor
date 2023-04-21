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
      scrollwheel: false,
      disableDoubleClickZoom: true
    };

    this.map = new google.maps.Map(this.mapContainer.nativeElement, mapOptions);

    const marker = new google.maps.Marker({
      position: new google.maps.LatLng(this.lat, this.lng),
      map: this.map
    });
  }
}
