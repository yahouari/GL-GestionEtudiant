import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import { faUser, faLock } from '@fortawesome/free-solid-svg-icons';
import {LoginService} from "../../../services/login.service";
import {Router} from "@angular/router";
import {MessageService} from "primeng/api";
import {AnimationOptions} from "ngx-lottie";
import {AnimationItem} from "lottie-web";

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css','../login.component.css']
})
export class LoginFormComponent implements OnInit {
   error: string=null;

  constructor(private login:LoginService,private router:Router,private messageService: MessageService) { }

  ngOnInit(): void {
    this.login.redirect();
  }
  profileForm = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
  });
  profileForm1;
  faUser = faUser;
  faLock = faLock;
  optionsLogo: AnimationOptions = {
    path: '/assets/logo.json',
  };
  onLogin(user)
  {
      console.log(user)
    this.login.login(user).subscribe(resp=>{
      this.error=null;
      let jwt = resp.headers.get('Authorization');
      console.log(resp.headers.get('Authorization'));
      this.login.saveToken(jwt);


      this.login.redirect();

    },error =>
    {console.log(error);
    this.error="Mauvais mot de passe ou utilisateur";
    this.profileForm.reset(0);
    })
  }
  animationCreated(animationItem: AnimationItem): void {
    console.log(animationItem);
  }

}
