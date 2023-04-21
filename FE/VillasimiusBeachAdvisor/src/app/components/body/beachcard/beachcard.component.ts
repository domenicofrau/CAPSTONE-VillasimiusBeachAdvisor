import { Component, OnInit } from '@angular/core';
import { SpiaggeService } from '../../../services/spiagge.service';
import { AuthService } from 'src/app/services/auth.service';
import { PreferitiService } from 'src/app/services/preferiti.service';
import { switchMap } from 'rxjs/operators';
import { UpdateCardService } from 'src/app/services/update-card.service';
@Component({
  selector: 'app-beachcard',
  templateUrl: './beachcard.component.html',
  styleUrls: ['./beachcard.component.scss']
})
export class BeachcardComponent implements OnInit {
  spiagge: any[] = [];
  preferiti: any[] = [];
  selectedSpiaggia: any;
  screenWidth: number;
  map: any;

  constructor(
    private spiaggeService: SpiaggeService,
    public authService: AuthService,
    private preferitiService: PreferitiService,
    private updateCardService: UpdateCardService
  ) {
    this.screenWidth = window.innerWidth;
    window.addEventListener('resize', () => {
      this.screenWidth = window.innerWidth;
    });
  }

  ngOnInit(): void {
    this.spiaggeService.getSpiagge()
      .then(data => {
        this.spiagge = data;
      })
      .catch(error => {
        console.error('Errore nel recupero delle condizioni delle spiagge:', error);
      });

    this.ottieniPreferiti();

    this.updateCardService.cardUpdateRequested.subscribe(() => {
      this.ottieniPreferiti();
    });
  }
  aggiungiPreferiti(id: number) {
    this.preferitiService.addLike(id).pipe(
      switchMap(() => this.preferitiService.listaPreferiti())
    ).subscribe(data => {
      this.preferiti = data;
      this.updateCardService.requestCardUpdate();
    });
  }

  rimuoviPreferiti(id: number) {
    this.preferitiService.removeLike(id).pipe(
      switchMap(() => this.preferitiService.listaPreferiti())
    ).subscribe(data => {
      this.preferiti = data;
      this.updateCardService.requestCardUpdate();
    });
  }

  ottieniPreferiti() {
    this.preferitiService.listaPreferiti().subscribe(data => {
      this.preferiti = data;
    });
  }

  gestioneIcone(id: number): boolean {
    return this.preferiti.some(elem => elem.id == id);
  }

  truncateDescription(description: string, maxLength: number): string {
    if (description.length <= maxLength) {
      return description;
    }

    const lastSpaceIndex = description.substr(0, maxLength).lastIndexOf(' ');

    return `${description.slice(0, lastSpaceIndex)}...`;
  }

  onInfoClick(spiaggia: any) {
    this.selectedSpiaggia = spiaggia;
  }

  onCloseClick() {
    this.selectedSpiaggia = null;
  }

}
