import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { NavbarComponent } from '../../header/navbar/navbar.component';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.scss']
})
export class SigninComponent implements OnInit {
  @ViewChild('modalClose') modalClose!: ElementRef;
  @ViewChild('signupModal') signupModal!: any;


  isLogged = true;
  username: string = "";
  password: string = "";
  name: string = "";
  surname: string = "";

  constructor(
    private authService: AuthService,
    private navbarCmp: NavbarComponent,
    private modalService: NgbModal) { }

  ngOnInit(): void { }

  onSubmit(form: NgForm): void {
    this.authService.login(form.value).subscribe(
      (data) => {
        this.username = data.username;
        this.closeModal();
        this.navbarCmp.isAuthenticated=true;
      },
      (error) => {
        this.isLogged = false;
      }
    );
  }

  closeModal(): void {
    this.modalService.dismissAll();
  }

  openSignUpModal() {
    this.modalService.dismissAll(); // Chiude tutte le modali aperte

  }

  reloadPage() {
    window.location.reload();
  }
}
