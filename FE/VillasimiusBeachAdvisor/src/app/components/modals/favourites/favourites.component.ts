import { Component, OnInit,Output, EventEmitter } from '@angular/core';
import { PreferitiService } from '../../../services/preferiti.service';
import { switchMap } from 'rxjs/operators';
import { ChangeDetectorRef } from '@angular/core';
import { UpdateCardService } from 'src/app/services/update-card.service';

@Component({
  selector: 'app-favourites',
  templateUrl: './favourites.component.html',
  styleUrls: ['./favourites.component.scss']
})
export class FavouritesComponent implements OnInit {
  favourites: any[] = [];
  preferiti: any[] = [];
  selectedSpiaggia: any;

  @Output() modalClosed = new EventEmitter<void>();


  constructor(private preferitiService: PreferitiService, private cd: ChangeDetectorRef, private updateCardService: UpdateCardService) { }

  ngOnInit(): void {
    this.preferitiService.preferitiChanged.subscribe(() => {
      this.ottieniPreferiti();
    });
    this.loadFavourites();
    this.ottieniPreferiti();
  }

  loadFavourites(): void {
    this.preferitiService.listaPreferiti().subscribe(
      data => {
        this.favourites = data;
      },
      error => {
        console.log(error);
      }
    );
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

  gestioneIcone(id: number): boolean {
    return this.preferiti.some(elem => elem.id == id);
  }

  ottieniPreferiti() {
    this.preferitiService.listaPreferiti().subscribe(data => {
      this.favourites = data;
      this.preferiti = data;
      this.cd.detectChanges();
    });
  }

  modalHidden() {
    this.modalClosed.emit();
  }

  onCloseClick() {
    this.selectedSpiaggia = null;
  }

}
