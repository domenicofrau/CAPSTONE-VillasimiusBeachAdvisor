import { Component, OnDestroy, OnInit, ChangeDetectorRef, ViewChild } from '@angular/core';
import { AuthService } from '../../../services/auth.service';
import { Subscription } from 'rxjs';
import { PreferitiService } from 'src/app/services/preferiti.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit, OnDestroy {
  @ViewChild('profileModal') profileModal!: any;
  private authStatusSubscription!: Subscription;
  isAuthenticated = false;
  user = sessionStorage.getItem('username');
  preferiti: any[] = [];

  constructor(public authService: AuthService, private changeDetector: ChangeDetectorRef, private preferitiService: PreferitiService) { }

  ngOnInit(): void {
    this.isAuthenticated = this.authService.isAuthenticated();
    this.authStatusSubscription = this.authService.authStatus$.subscribe(
      (status) => {
        this.isAuthenticated = status;
        this.changeDetector.detectChanges();
      }
    );
    if (this.isAuthenticated == false) {
      this.preferitiService.preferitiChanged.subscribe(() => {
        this.ottieniPreferiti();
      });
    }
  }

  ngOnDestroy(): void {
    if (this.authStatusSubscription) {
      this.authStatusSubscription.unsubscribe();
    }
  }

  reloadPage() {
    window.location.reload();
  }

  logout() {
    this.authService.logout();
  }

  ottieniPreferiti() {
    this.preferitiService.listaPreferiti().subscribe(data => {
      this.preferiti = data;
    });
  }

}
