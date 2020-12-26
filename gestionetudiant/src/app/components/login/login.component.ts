import {Component, OnInit, ViewChild} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {MenuItem} from "primeng/api";
import {LoginService} from "../../services/login.service";
import {Router} from "@angular/router";
import {AnimationOptions} from "ngx-lottie";
import {AnimationItem} from "lottie-web";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  items:any;
  activeItem: MenuItem;
  options: AnimationOptions = {
    path: '/assets/loginback.json',
  };

  @ViewChild('menuItems') menu: MenuItem[];
  constructor(private login:LoginService,private router:Router) {
    this.items = [
      {label: 'Authentification', icon: 'pi pi-fw pi-home'},
      {label: 'Inscription', icon: 'pi pi-fw pi-user'}
    ];

    this.activeItem = this.items[0];
  }
  profileForm = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
  });
  animationCreated(animationItem: AnimationItem): void {
    console.log(animationItem);
  }
  ngOnInit(): void {


  }

  activeElement() {
    this.activeItem=this.menu['activeItem'];

  }

}
