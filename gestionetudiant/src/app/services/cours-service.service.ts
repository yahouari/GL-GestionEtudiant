import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CoursServiceService {
  host="http://localhost:8083"
  httpOptions = {headers: new HttpHeaders({
      Authorization: localStorage.getItem('token')
    })}
  constructor(private http:HttpClient) { }

  getCourses()
  {
    return this.http.get(this.host+"/courses",this.httpOptions)
  }
  getMyCourses(id)
  {
    return this.http.get(this.host+"/cours/"+id,this.httpOptions)
  }
  saveCourses(user)
  {
    return this.http.post(this.host+'/saveCourse',user)
  }
  getCoursesFormateur(username)
  {
    return this.http.get(this.host+'/coursesFormateur/'+username,this.httpOptions)
  }
  getCoursesInsc(username)
  {
    return this.http.get(this.host+'/coursesInscriptions/'+username,this.httpOptions)
  }

}
