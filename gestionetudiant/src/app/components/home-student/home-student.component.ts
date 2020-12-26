import { Component, OnInit } from '@angular/core';
import { faUser, faLock, faBookOpen, faBook , faPlusCircle, faUserCircle,faHome,faAlignJustify} from '@fortawesome/free-solid-svg-icons';
import {CoursServiceService} from '../../services/cours-service.service';
import {MenuItem, Message, MessageService, PrimeNGConfig} from 'primeng/api';
import {ButtonModule} from 'primeng/button';
import {Router} from '@angular/router';
import {LoginService} from '../../services/login.service';
import {AnimationOptions} from "ngx-lottie";
import {AnimationItem} from "lottie-web";
import {InscriptionsService} from "../../services/inscriptions.service";
@Component({
  selector: 'app-home-student',
  templateUrl: './home-student.component.html',
  styleUrls: ['./home-student.component.css']
})
export class HomeStudentComponent implements OnInit {
  faHome=faHome;
  faAlignJustify=faAlignJustify;
  courses=[];
  items: MenuItem[];
  message: Message;
  display: any;
  inscriptions;
  username;

  constructor(private coursService:CoursServiceService,private primengConfig: PrimeNGConfig,private router:Router,private login:LoginService,private messageService:MessageService,private inscr:InscriptionsService) { }
  ngOnInit() {

      this.message={severity:'success', summary:'Success', detail:'Bienvenue'};
      this.items = [
        {
          label: 'Acceuil',
          icon: 'pi pi-fw pi-home',
          items: [
            {
              label: 'New',
              icon: 'pi pi-fw pi-plus',
              items: [
                {
                  label: 'Bookmark',
                  icon: 'pi pi-fw pi-bookmark'
                },
                {
                  label: 'Video',
                  icon: 'pi pi-fw pi-video'
                },

              ]
            },
            {
              label: 'Delete',
              icon: 'pi pi-fw pi-trash'
            },
            {
              separator: true
            },
            {
              label: 'Export',
              icon: 'pi pi-fw pi-external-link'
            }
          ]
        }

      ];
      this.findInsc();

    }
  loadToken1()
  {
    let username:string=this.login.loadToken().sub
    return username

  }
  findInsc()
  {
    this.inscr.findInsc(this.loadToken1()).subscribe(data=>{
      this.inscriptions=data
    },(error) => {console.log(error)},()=>{
  this.inscriptions.forEach(insc=>{
    this.getCourses(insc.id);
  });console.log(this.inscriptions)

    })
  }
  getCourses(id)
  {
    this.coursService.getMyCourses(id).subscribe(data=>{
      this.courses.push(data);
    },error => console.log(error),()=>{
        console.log(this.courses);
    }

    )
  }

  }




