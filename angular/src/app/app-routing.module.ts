import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserComponent } from './user/user.component';
import { CourseComponent } from './course/course.component';
import { LoginComponent } from './login/login.component';
const routes: Routes = [
  {path: '', redirectTo: "login",pathMatch:"full"},
  {path: 'login', component:LoginComponent },
  {path: 'user', component:UserComponent },
  {path: 'course', component:CourseComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
