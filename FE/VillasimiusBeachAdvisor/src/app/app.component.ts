import { Component } from '@angular/core';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {


  title = 'Beach-Advisor';
  controllo: boolean = false;

  constructor(private as: AuthService) { }

  ngOnInit(): void {
    if (localStorage.getItem("currentUser")) {
      const user = JSON.parse(localStorage.getItem("currentUser")!);
      this.as.token = user.accessToken;
    }
  }

}

