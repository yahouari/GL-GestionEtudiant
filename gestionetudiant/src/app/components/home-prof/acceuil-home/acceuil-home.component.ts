import { Component, OnInit } from '@angular/core';
import {CoursServiceService} from "../../../services/cours-service.service";
import {LoginService} from "../../../services/login.service";

@Component({
  selector: 'app-acceuil-home',
  templateUrl: './acceuil-home.component.html',
  styleUrls: ['./acceuil-home.component.css','../../courses/courses.component.css']
})
export class AcceuilHomeComponent implements OnInit {

  constructor(private coursService:CoursServiceService,private login:LoginService) { }
courses;
  ngOnInit(): void {
    this.getCourses(this.login.loadToken().sub)
  }
getCourses(username)
{
  this.coursService.getCoursesFormateur(username).subscribe(data=>{
this.courses=data;
  },(error) => console.log(error),()=>{
    console.log(this.courses);
  })
}
  chooseRating(c):number
  {
    if(c.difficulte==="DIFFICILE")
    {
      return 3
    }
    if(c.difficulte==="FACILE")
    {
      return 1
    }
    if(c.difficulte==="MOYEN")
    {
      return 2
    }
  }
}
