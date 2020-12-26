import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from './components/login/login.component';
import {HomeStudentComponent} from './components/home-student/home-student.component';
import {CoursServiceService} from './services/cours-service.service';
import {CoursesComponent} from './components/courses/courses.component';
import {HomeProfComponent} from "./components/home-prof/home-prof.component";

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'login', component: LoginComponent},
  {path: 'homestudent', component: HomeStudentComponent},
  {path: 'courses', component: CoursesComponent},
  {path:'homeprof',component:HomeProfComponent},
  {path:'',redirectTo:'/login',pathMatch:'full'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
