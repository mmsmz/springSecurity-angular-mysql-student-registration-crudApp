import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  
  constructor(private http: HttpClient) { }


  addCourse(data){
    debugger;
    return this.http.post("http://localhost:8087/addCourse",data).pipe(
      map((res:any)=> res));
  }

  updateCourse(data){
    return this.http.post("http://localhost:8087/updateCourse",data).pipe(
      map((res:any)=> res));
  }

  getAllCourses(){
    return this.http.get("http://localhost:8087/getAllCourses").pipe(
      map((res:any)=> res));
  }

  getCourseById(data){
    debugger;
   // data.name="mg";
    return this.http.get("http://localhost:8087/getCourseById?courseId="+data.courseId).pipe(
      map((res:any)=> res));
  }

  deleteCourse(courseDetails){
    return this.http.post("http://localhost:8087/deleteCourse",courseDetails).pipe(
      map((res:any)=> res));
  }


}
