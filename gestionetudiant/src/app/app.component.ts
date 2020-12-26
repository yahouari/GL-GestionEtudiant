import {Component, OnInit} from '@angular/core';
import {PrimeNGConfig} from 'primeng/api';
import {LoginService} from "./services/login.service";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'gestionetudiant';
  token;
  constructor(private login:LoginService) {
    this.token=this.login.loadToken();
  }
  ngOnInit() {
    this.login.redirect()
  }

}
