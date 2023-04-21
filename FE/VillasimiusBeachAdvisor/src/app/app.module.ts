import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgbModalModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { MapComponent } from './components/body/map/map.component';
import { NavbarComponent } from './components/header/navbar/navbar.component';
import { WeathercardComponent } from './components/body/weathercard/weathercard.component';
import { LogoutComponent } from './routes/logout/logout.component';
import { SigninComponent } from './components/modals/signin/signin.component';
import { SignupComponent } from './components/modals/signup/signup.component';
import { BeachcardComponent } from './components/body/beachcard/beachcard.component';

import { AuthService } from './services/auth.service';
import { ProfileComponent } from './components/modals/profile/profile.component';
import { FavouritesComponent } from './components/modals/favourites/favourites.component';
import { FooterComponent } from './components/footer/footer/footer.component';
import { BeachMapComponent } from './components/body/beach-map/beach-map.component';

@NgModule({
  declarations: [
    AppComponent,
    MapComponent,
    NavbarComponent,
    WeathercardComponent,
    LogoutComponent,
    SigninComponent,
    BeachcardComponent,
    SignupComponent,
    ProfileComponent,
    FavouritesComponent,
    FooterComponent,
    BeachMapComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    NgbModule,
    NgbModalModule,
  ],
  providers: [
    AuthService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
