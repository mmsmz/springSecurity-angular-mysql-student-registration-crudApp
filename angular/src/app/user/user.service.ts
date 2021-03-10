import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http : HttpClient) { }

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
    let username = 'foo';
    let password = 'foo';
    const headers = new HttpHeaders({Authorization: 'Basic ' +btoa(username+":"+password)});
    return this.http.get("http://localhost:8087/getAllUsers", {headers});
  }

  // public getAlluser(){
  //   let username = 'foo';
  //   let password = 'foo';
  //   const headers = new HttpHeaders({Authorization: 'Basic ' +btoa(username+":"+password)});
  //   return  this.http.get("http://localhost:8087/getAllUsers", {headers});
  // }

  getUserById(data){
    debugger;
   // data.name="mg";
    return this.http.get("http://localhost:8087/getUserById?userId="+data.userId).pipe(
      map((res:any)=> res));
  }

  
  // getUserById(data){
  //   let username = 'foo';
  //   let password = 'foo';
  //   const headers = new HttpHeaders({Authorization: 'Basic ' +btoa(username+ ":" + password) });
  //   return  this.http.get("http://localhost:8087/getUserById?userId="+data.userId, {headers});
  // }

  deleteUser(userDeatails){
    return this.http.post("http://localhost:8087/deleteUser",userDeatails).pipe(
      map((res:any)=> res));
  }

}
