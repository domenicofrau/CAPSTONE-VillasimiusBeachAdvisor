import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UpdateCardService {
  cardUpdateRequested = new Subject<void>();

  constructor() { }

  requestCardUpdate() {
    this.cardUpdateRequested.next();
  }
}
