import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class InscriptionsService {
  private host='http://localhost:8085';
  private host1='http://localhost:8089';
  httpOptions = {headers: new HttpHeaders({
      Authorization: localStorage.getItem('token')
    })}
  constructor(private http:HttpClient) { }
  /*getInscriptions(user)
  {
    return this.http
  }*/
  register(user){
    return this.http.post(this.host + '/register', user);
  }
  inscrire(id,username)
  {
    return this.http.post(this.host1+'/saveInscription/'+id,{username:username})
  }
  findInsc(username)
  {
    return this.http.get(this.host1+'/findInscription/'+username,this.httpOptions)
  }
  findetudiant(id){
    return  this.http.get(this.host1+'/inscription/'+id)
  }
}
