import { Component, OnInit } from '@angular/core';
import {MessageService, SelectItem} from "primeng/api";
import {LoginService} from "../../../services/login.service";
import {Router} from "@angular/router";
import {InscriptionsService} from "../../../services/inscriptions.service";
import {HttpClient} from "@angular/common/http";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-inscription-form',
  templateUrl: './inscription-form.component.html',
  styleUrls: ['./inscription-form.component.css']
})
export class InscriptionFormComponent implements OnInit {
  user:any;
  date: any;
  type: any;
  checked: boolean=false;
  errorMessage:string;


  form = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
    confirmedPassword:new FormControl(''),
    email:new FormControl(''),
    date:new FormControl(''),
    role:new FormControl(''),

  });

verify:boolean=false;

  constructor(private inscription:InscriptionsService,private router:Router,private messageService: MessageService) {

  }

  ngOnInit(): void {
  }
  onRegister(user) {
    console.log(user)
    this.inscription.register(user)
      .subscribe(data =>{
          this.user = data;
          /*// tslint:disable-next-line:no-console
          console.log(this.user);*/


        },
        err =>{
          this.errorMessage = err.error.message;
          console.log(this.errorMessage);
        },()=>
        {
          this.messageService.add({severity:'success', summary:'Success', detail: 'Utilisateur enregistré', sticky: true});
          this.form.reset();
        })
  }
  onConfirm(user) {
    this.onRegister(user);
    this.messageService.clear('c');
  }
  showConfirm() {
    this.messageService.clear();
    this.messageService.add({key: 'c', sticky: true, severity:'warn', summary:'Vous etes sur ?', detail:'Confirmer votre enregistement'});
  }
  onReject() {
    this.messageService.clear('c');
  }
  showResponse(event) {
    this.messageService.add({severity:'success', summary:'Success', detail: 'tu as verifié chekp avec success', sticky: true});
    this.verify=true
  }
checkpassword()
{
  return this.form.controls.confirmedPassword.valid && this.form.controls.confirmedPassword.value != this.form.controls.password.value;
}
  formValid() {
    if(!this.form.valid || !this.verify || this.checkpassword())
    {
      return true
    }else {
      return false;
    }
  }
}
