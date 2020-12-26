import {Component, OnInit, ViewChild} from '@angular/core';
import { MenuItem } from 'primeng/api';
import {LoginService} from "../../services/login.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-home-prof',
  templateUrl: './home-prof.component.html',
  styleUrls: ['./home-prof.component.css']
})
export class HomeProfComponent implements OnInit {
  items: any;
  activeItem: MenuItem;
  @ViewChild('menuItems') menu: MenuItem[];


  constructor(private login:LoginService,private router:Router) {
    this.items = [
      {label: 'Acceuil', icon: 'pi pi-fw pi-home'},
      {label: 'Etudiant', icon: 'pi pi-fw pi-user'},
      {label: 'Ajouter un cours', icon: 'pi pi-fw pi-plus'}
    ];

    this.activeItem = this.items[0];
  }

  ngOnInit(): void {

    console.log(this.activeItem);
  }
  logout()
  {
    this.login.logout();
    this.login.redirect();
  }

  activeElement() {
    this.activeItem=this.menu['activeItem'];

  }
}
