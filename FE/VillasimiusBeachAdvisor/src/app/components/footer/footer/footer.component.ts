import { Component, OnInit } from '@angular/core';
import { MeteoService } from 'src/app/services/meteo.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss']
})
export class FooterComponent implements OnInit {

  constructor(public meteoService:MeteoService) { }

  ngOnInit(): void {
  }

}
