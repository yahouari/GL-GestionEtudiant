import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {JwtHelperService} from '@auth0/angular-jwt';
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  jwtToken;
  host="http://localhost:8888"
  constructor(private http:HttpClient,private router:Router) { }
  login(data)
  {
    return this.http.post(this.host+"/login",data,{observe:'response'});
  }
  saveToken(jwtToken)
  {
    this.jwtToken=jwtToken;
    localStorage.setItem("token",jwtToken);

  }

  loadToken(){
    const helper=new JwtHelperService();
    const decodeToken=helper.decodeToken(localStorage.getItem('token'));
    this.jwtToken=decodeToken;

    return this.jwtToken;
  }
  logout(){
    localStorage.removeItem('token');
  }
  redirect()
  {
    if(!this.loadToken())
    {
      this.router.navigateByUrl("/login");
    }
    if(this.loadToken().roles[0]==="ETUDIANT")
    {
      console.log("redirect homestudent");
      this.router.navigateByUrl("/homestudent");
    }
    if(this.loadToken().roles[0]==="PROF")
    {
      console.log("redirect homeprof");
      this.router.navigateByUrl("/homeprof");
    }
  }
}
