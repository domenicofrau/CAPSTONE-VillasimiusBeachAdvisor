import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from '../../../services/auth.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {
  @ViewChild('modalClose') modalClose!: ElementRef;
  @ViewChild('signinModal') signinModal!: any;

  isLogged = true;
  passwordOk = true;
  username: string = "";
  password: string = "";
  name: string = "";
  surname: string = "";
  email: string = "";
  verifica: string = "";

  constructor(private authService: AuthService, private modalService: NgbModal) { }

  ngOnInit(): void {
  }

  onSubmit(form: NgForm) {
    if (form.valid) {
      if (this.password === this.verifica) {
        this.register();
        // Aggiungi qui il codice per gestire l'invio del form
      } else {
        this.passwordOk=false;
      }
    }
  }


  register() {
    const user = {
      name: this.name,
      surname: this.surname,
      username: this.username,
      email: this.email,
      password: this.password,
      roles: ['ROLE_USER']
    };

    this.authService.register(user).subscribe(
      response => {
      },
      error => {
        console.error(error);
      }
    );
  }

  closeModal(): void {
    this.modalService.dismissAll();
  }

}

