
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { HomeStudentComponent } from './components/home-student/home-student.component';
import { SideBarStudentComponent } from './components/side-bar-student/side-bar-student.component';
import { TestComponentComponent } from './components/test-component/test-component.component';
import {HttpClientModule} from '@angular/common/http';
import {AccordionModule} from 'primeng/accordion';

import {MenuItemContent} from 'primeng/menu';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ButtonModule} from 'primeng/button';
import { RippleModule } from 'primeng/ripple';
import {RatingModule} from 'primeng/rating';
import { CoursesComponent } from './components/courses/courses.component';
import {MenubarModule} from 'primeng/menubar';
import {InputTextModule} from 'primeng/inputtext';
import {FieldsetModule} from 'primeng/fieldset';
import { HomeProfComponent } from './components/home-prof/home-prof.component';
import {TieredMenuModule} from 'primeng/tieredmenu';
import {MenuItem, MessageService} from 'primeng/api';
import {ListboxModule} from 'primeng/listbox';
import {TabMenuModule} from 'primeng/tabmenu';

import {PasswordModule} from 'primeng/password';
import { LoginFormComponent } from './components/login/login-form/login-form.component';
import { InscriptionFormComponent } from './components/login/inscription-form/inscription-form.component';
import {InputMaskModule} from 'primeng/inputmask';
import {SelectButtonModule} from 'primeng/selectbutton';
import {ToggleButtonModule} from 'primeng/togglebutton';
import {TriStateCheckboxModule} from 'primeng/tristatecheckbox';
import { AddCoursComponent } from './components/home-prof/add-cours/add-cours.component';
import {InputTextareaModule} from 'primeng/inputtextarea';
import {FileUploadModule} from 'primeng/fileupload';
import {CaptchaModule} from 'primeng/captcha';
import {ToastModule} from "primeng/toast";
import {MessagesModule} from 'primeng/messages';
import {MessageModule} from 'primeng/message';
import {SidebarModule} from 'primeng/sidebar';
import {CardModule} from 'primeng/card';
import { LottieModule } from 'ngx-lottie';
import player from 'lottie-web';
import {BlockUIModule} from 'primeng/blockui';
import {RadioButtonModule} from "primeng/radiobutton";
import { AcceuilHomeComponent } from './components/home-prof/acceuil-home/acceuil-home.component';
import { EtudiantsComponent } from './components/home-prof/etudiants/etudiants.component';
import { CommonModule } from '@angular/common';


export function playerFactory() {
  return player;
}
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeStudentComponent,
    SideBarStudentComponent,
    TestComponentComponent,
    CoursesComponent,
    HomeProfComponent,
    LoginFormComponent,
    InscriptionFormComponent,
    AddCoursComponent,
    AcceuilHomeComponent,
    EtudiantsComponent


  ],
  imports: [
    BrowserModule, ToggleButtonModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    FontAwesomeModule,
    HttpClientModule, AccordionModule, BrowserAnimationsModule, BrowserModule, ButtonModule, RippleModule, RatingModule,
    MenubarModule, InputTextModule, FieldsetModule, TieredMenuModule, ListboxModule, TabMenuModule, PasswordModule, InputMaskModule, SelectButtonModule, TriStateCheckboxModule,
    InputTextareaModule,
    FileUploadModule, CaptchaModule, ToastModule, MessageModule, MessagesModule, SidebarModule,
    LottieModule.forRoot({player: playerFactory}), CardModule, BlockUIModule, RadioButtonModule,CommonModule
  ],
  providers: [MessageService],
  bootstrap: [AppComponent]
})
export class AppModule { }
