import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {map} from "rxjs/operators";
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  // BASE_PATH: 'http://localhost:8087'
  USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser';

  
    
   public username: String;
   public password: String;


// public username: String;
// public password: String;
  
  constructor(private http: HttpClient,
              private rout: Router) { }

  // public login(username:string, password:string){
  //   const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username+ ":" + password) });
  //   return  this.http.get("http://localhost:8087/", {headers, responseType: 'text' as 'json'});
  // }  

  authenticationService(username: String, password: String) {
    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username+ ":" + password) });
    
    return  this.http.get("http://localhost:8087/", {headers, responseType: 'text' as 'json'});
  }

   logout() {
    localStorage.removeItem("username");
    localStorage.removeItem("password");
    // this.username = null;
    // this.password = null;
    
    this.rout.navigateByUrl('/login');
    debugger
  }

  // getAlluser(username: String, password: String){
  //   // let username = 'admin';
  //   // let password = '123';
  //   const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username+":"+password)});
  //   return this.http.get("http://localhost:8087/getAllUsers", {headers});
  // }

  
  // logout() {
  //   localStorage.removeItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
  //   this.username = null;
  //   this.password = null;
  //   debugger
  // }

  isUserLoggedIn() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    if (user === null) return false
    return true
  }

  // createBasicAuthToken(username: String, password: String) {
  //   return 'Basic ' + window.btoa(username + ":" + password)
  // }

  
}