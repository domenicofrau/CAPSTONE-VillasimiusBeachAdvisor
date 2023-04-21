import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable, Subject } from 'rxjs';
import jwt_decode, { JwtPayload } from 'jwt-decode';
import { map } from 'rxjs/operators';

export interface User {
  id: number;
  username: string;
  email: string;
  accessToken: string;
}

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private currentUserSubject: BehaviorSubject<User | null>;
  public currentUser: Observable<User | null>;
  public token: String = "";

  private authStatusSource = new Subject<boolean>();
  public authStatus$ = this.authStatusSource.asObservable();

  private apiUrl = 'http://localhost:8080/api/auth';

  constructor(private http: HttpClient) {
    const storedUser = localStorage.getItem('currentUser');
    this.currentUserSubject = new BehaviorSubject<User | null>(
      storedUser ? JSON.parse(storedUser) : null
    );
    this.currentUser = this.currentUserSubject.asObservable();
  }

  public get currentUserValue(): User | null {
    return this.currentUserSubject.value;
  }

  login(data: { username: string; password: string }): Observable<User> {
    return this.http.post<User>(`${this.apiUrl}/login`, data).pipe(
      map((user) => {
        if (user && user.accessToken) {
          localStorage.setItem('currentUser', JSON.stringify(user));
          this.token= user.accessToken;
          this.currentUserSubject.next(user);
          this.updateAuthStatus(true);
          window.location.reload;
        }
        return user;

      })
    );
  }

  logout(): void {
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);
    this.updateAuthStatus(false);
  }

  isAuthenticated(): boolean {
    const user = this.currentUserValue;
    if (user && user.accessToken) {
      try {
        const decodedToken = jwt_decode<JwtPayload>(user.accessToken);
        const expirationDate = new Date(decodedToken.exp! * 1000);
        return expirationDate > new Date();
      } catch (error) {
        console.error('Error decoding JWT:', error);
      }
    }
    return false;
  }

  updateAuthStatus(status: boolean): void {
    this.authStatusSource.next(status);
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    return !(user === null)
  }

  register(data: {
    name: string;
    surname: string;
    username: string;
    email: string;
    password: string;
    roles: string[];
  }): Observable<string> {
    return this.http.post<string>(`${this.apiUrl}/register`, data);
  }
}
