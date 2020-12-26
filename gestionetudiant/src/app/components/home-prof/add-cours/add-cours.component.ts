import { Component, OnInit } from '@angular/core';
import {MessageService} from "primeng/api";
import {FormControl, FormGroup} from "@angular/forms";
import {InscriptionsService} from "../../../services/inscriptions.service";
import {CoursServiceService} from "../../../services/cours-service.service";
import {Router} from "@angular/router";
import {LoginService} from "../../../services/login.service";
import {ThemesService} from "../../../services/themes.service";

@Component({
  selector: 'app-add-cours',
  templateUrl: './add-cours.component.html',
  styleUrls: ['./add-cours.component.css']
})
export class AddCoursComponent implements OnInit {
  public image : any;
  public file : any;
  selectedFile: File;
  public imagePath;
  imgURL: any;
  public message: string;
  userFile ;
  cours: any;
  user:any;
  errorMessage:string;
  theme;

  form = new FormGroup({
    nom: new FormControl(''),
    description: new FormControl(''),
    nombreDePlace:new FormControl(''),
    difficulte:new FormControl(''),
    photo :new FormControl(''),
    formateur:new FormControl(this.login.loadToken().sub),
    theme:new FormControl('')
  });

  uploadedFiles: any[] = [];
  difficulte: any;

  constructor(private courss:CoursServiceService,private router:Router,private messageService: MessageService,private login:LoginService,private themeService:ThemesService) {}

  onUpload(event) {
    for(let file of event.files) {
      console.log(file.name);
      this.uploadedFiles.push(file);
    }

    this.messageService.add({severity: 'info', summary: 'File Uploaded', detail: ''});
  }

  ngOnInit(): void {
    this.themeService.getThemes().subscribe(data=>{
      this.theme=data
    },(error => {
      console.log(error)
    }),()=>{
      console.log(this.theme);
    })
  }

  chooseRating(difficulte):string
  {

    // tslint:disable-next-line:triple-equals
    if(difficulte===3)
    {
      return "DIFFICILE"
    }
    if(difficulte===1)
    {
      return "FACILE"
    }
    if(difficulte===2)
    {
      return "MOYEN"
    }
  }

  saveCours(user) {
    console.log(user);
    this.courss.saveCourses(user)
      .subscribe(data =>{
          this.user = data;
          console.log(this.user);
          this.router.navigateByUrl('/homeprof');

        },
        err =>{
          this.errorMessage = err.error.message;
        })
      this.form.reset();
  }

  onSelectFile(event) {
    if (event.target.files.length > 0)
    {
      const file = event.target.files[0];
      this.userFile = file;
      // this.f['profile'].setValue(file);

      var mimeType = event.target.files[0].type;
      if (mimeType.match(/image\/*/) == null) {
        this.message = "Only images are supported.";
        return;
      }
      var reader = new FileReader();

      this.imagePath = file;
      reader.readAsDataURL(file);
      reader.onload = (_event) => {
        this.imgURL = reader.result;
      }
    }
  }
}
