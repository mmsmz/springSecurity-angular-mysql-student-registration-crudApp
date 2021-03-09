import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(private http: HttpClient) { }


  addUser(data){
    debugger;
    return this.http.post("http://localhost:8087/addUser",data).pipe(
      map((res:any)=> res));
  }

  updateUser(data){
    return this.http.post("http://localhost:8087/updateUser",data).pipe(
      map((res:any)=> res));
  }

  getAlluser(){
    return this.http.get("http://localhost:8087/getAllUsers").pipe(
      map((res:any)=> res));
  }

  getUserById(data){
    debugger;
   // data.name="mg";
    return this.http.get("http://localhost:8087/getUserById?userId="+data.userId).pipe(
      map((res:any)=> res));
  }

  deleteUser(userDeatails){
    return this.http.post("http://localhost:8087/deleteUser",userDeatails).pipe(
      map((res:any)=> res));
  }


}
