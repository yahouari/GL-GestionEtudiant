import {ChangeDetectorRef, Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {CoursServiceService} from '../../services/cours-service.service';
import {MessageService, PrimeNGConfig, SelectItem} from 'primeng/api';
import {LoginService} from "../../services/login.service";
import {AnimationOptions} from "ngx-lottie";
import {AnimationItem} from "lottie-web";
import {InscriptionsService} from "../../services/inscriptions.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {

  constructor(private changeDetectorRef: ChangeDetectorRef,private coursService:CoursServiceService,private primengConfig: PrimeNGConfig,private login:LoginService,private messageService:MessageService,private inscrireService:InscriptionsService,private router:Router) {

    console.log("constructor");
  }
  courses;
  coursesSelected;
  username;
  nom;
  @Output() getCourse=new EventEmitter();
  prenom;
  courseFilter;
  @Input() inscriptions
  ngOnInit(): void {
    console.log("ngOnit")
    this.loadToken1();

    this.optionss = [{label: 'AI', value: 'AI'}, {label: 'Programmation', value: 'Programmation'},{label: 'Tous', value: 'Tous'}];
    this.primengConfig.ripple = true;
    this.getCourses();

  }

  optionss: SelectItem[];
  options: AnimationOptions = {
    path: '/assets/photo.json',
  };
  typeSelected: any="Tous";
  animationCreated(animationItem: AnimationItem): void {
    console.log(animationItem);
  }
  getCourses()
  {
    // tslint:disable-next-line:no-console
    return this.coursService.getCourses().subscribe(courses => {
        this.coursesSelected = courses;
        this.courses=courses;

    }
      // tslint:disable-next-line:no-console
      ,(error => console.log(error)),()=>{
        // tslint:disable-next-line:no-console
          this.refresh();

      });
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
  loadToken1()
  {
    this.username=this.login.loadToken().sub;
    console.log(this.username);

  }

  coursesFilter(typeSelected: any) {
    this.coursesSelected=[];
    console.log(typeSelected);
    this.courses.forEach(course=>{
      console.log(course.theme.nom)
      if(typeSelected=="Tous")
      {
        this.coursesSelected=this.courses;
        return
      }
      if(course.theme.nom==typeSelected)
      {

        this.coursesSelected.push(course);
      }
    })

    console.log(this.coursesSelected);

  }

  inscrire(id: any) {

    return this.inscrireService.inscrire(id,this.username).subscribe(data=>{
      console.log("je m'inscris");
      console.log(data);

    },error => console.log(error),()=>{
      this.messageService.add({severity:'success', summary: 'Vous avez été inscrit dans ce cours', detail: 'Le cours le voila '});
      this.router.navigateByUrl("/login");

      this.refresh();
      console.log("complete")
    });


  }
  filter(data)
  {
    console.log("Inscription from courses components");
    console.log(this.inscriptions)
    data.forEach(course=>{
    console.log(course);
        this.inscriptions.forEach(inscr=>{
          console.log(inscr);
          if(inscr.idCours==course.id){
            let index=data.indexOf(course);
            console.log("index fount = "+index);
            data.splice(index,1);
          }

      })
    })
    console.log("after filter")
    console.log(data);
    return data;
  }
  refresh()
  {
    console.log("getcours");
    console.log(this.courses)
    console.log("the  filter is starting");
    this.courses=this.filter(this.courses);
    console.log("courselect filter is starting")
    this.coursesSelected=this.filter(this.coursesSelected);
    console.log("end of getcourses");
  }

}
