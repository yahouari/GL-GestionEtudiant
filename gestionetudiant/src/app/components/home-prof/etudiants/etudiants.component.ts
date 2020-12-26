import { Component, OnInit } from '@angular/core';
import {InscriptionsService} from "../../../services/inscriptions.service";
import {CoursServiceService} from "../../../services/cours-service.service";
import {LoginService} from "../../../services/login.service";
import {PdfService} from "../../../services/pdf.service";


@Component({
  selector: 'app-etudiants',
  templateUrl: './etudiants.component.html',
  styleUrls: ['./etudiants.component.css']
})
export class EtudiantsComponent implements OnInit {

  constructor(private  inscriptionservice: InscriptionsService, private coursService: CoursServiceService, private login: LoginService,private pdfService: PdfService) {

  }
  i=0;
  coursesList: Cours[]=[];
  inscriptions;
  coursesName: string[] = [];
  courses;
  course;
  etudiants: string[] = [];
  c:Cours;

  ngOnInit(): void {
    this.getCourses(this.login.loadToken().sub)
  }

  getCourses(username) {
    this.coursService.getCoursesInsc(username).subscribe(data => {
      this.courses = data;


      // tslint:disable-next-line:no-console
    }, (error) => console.log(error), () => {
      console.log(this.courses)


    })
  }
  generatePdf(c) {
    this.pdfService.generatePdf(c);
  }

}
// tslint:disable-next-line:max-classes-per-file
class Cours
{
    nom:string;
    etudiants:string[]=[];
    inscriptions: number[]=[];
}
