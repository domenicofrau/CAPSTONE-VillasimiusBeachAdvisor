import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PreferitiService {

  private apiUrl = 'http://localhost:8080/api/preferiti/';
  preferitiChanged = new Subject<void>();

  constructor(private http: HttpClient, private as: AuthService) { }

  addLike(spiaggeId: number): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${this.as.token}`
    })
    return this.http.post<any>(this.apiUrl + spiaggeId, {}, { headers: headers }).pipe(
      tap(() => {
        this.preferitiChanged.next();
      })
    );
  }

  removeLike(spiaggeId: number): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${this.as.token}`
    })
    return this.http.delete<any>(this.apiUrl + spiaggeId, { headers: headers }).pipe(
      tap(() => {
        this.preferitiChanged.next();
      })
    );
  }

  listaPreferiti(): Observable<any>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${this.as.token}`
    })
    return this.http.get<any>(this.apiUrl + "all", { headers: headers });
  }
}
