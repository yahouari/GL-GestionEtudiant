import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {LoginService} from "./login.service";

@Injectable({
  providedIn: 'root'
})
export class EtudiantsService {
  host="http://localhost:8085";
  httpOptions = {headers: new HttpHeaders({
      Authorization: localStorage.getItem('token')
    })}

  constructor(private http:HttpClient,private login:LoginService) { }
  getEtudiant(username)
  {
    return this.http.get(this.host+"/etudiant/"+username,this.httpOptions);

  }
}
