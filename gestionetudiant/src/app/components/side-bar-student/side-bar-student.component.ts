import {Component, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import { faUser, faLock, faBookOpen, faBook , faPlusCircle, faUserCircle } from '@fortawesome/free-solid-svg-icons';
import {LoginService} from '../../services/login.service';
import {EtudiantsService} from "../../services/etudiants.service";
import {AnimationOptions} from "ngx-lottie";
import {AnimationItem} from "lottie-web";
import {HttpClient} from "@angular/common/http";
import {InscriptionsService} from "../../services/inscriptions.service";
import {CoursServiceService} from "../../services/cours-service.service";
@Component({
  selector: 'app-side-bar-student',
  templateUrl: './side-bar-student.component.html',
  styleUrls: ['./side-bar-student.component.css', '../home-student/home-student.component.css']
})
export class SideBarStudentComponent implements OnInit,OnChanges {
  faBookOpen = faBookOpen;
  faBook = faBook ;
  faPlusCircle = faPlusCircle;
  faUserCircle=faUserCircle
  displayBasic: boolean;
  username:string;
  etudiant;
  @Input() inscriptions;
  @Input() courses;

  // tslint:disable-next-line:no-empty
  constructor(private login:LoginService,private etudiantService:EtudiantsService,private inscr:InscriptionsService,private cours:CoursServiceService) {

  }

  // tslint:disable-next-line:no-empty
  ngOnInit(): void {
    this.username=this.loadToken1();
    this.getEtudiant();

  }
  options: AnimationOptions = {
    path: '/assets/userr.json',
  };
  animationCreated(animationItem: AnimationItem): void {
    console.log(animationItem);
  }
  showBasicDialog() {
    this.displayBasic=true;

  }
  loadToken1()
  {
    let username:string=this.login.loadToken().sub
    return username

  }
  getEtudiant()
  {
    this.etudiantService.getEtudiant(this.loadToken1()).subscribe((etudiant)=>{
      this.etudiant=etudiant
      }
      ,(error => console.log(error)),()=>{});
  }
  logout()
  {
    this.login.logout();
    this.login.redirect();
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log("change");
  }

}
interface Etudiant
{
  nom:string,
  prenom:string,
  photo:any;
  cin:any;
  inscriptions:Array<number>,
  username:string,
  tel:number,
  roles:any,
  password:any,
  date:any,
  adresse:any
}
