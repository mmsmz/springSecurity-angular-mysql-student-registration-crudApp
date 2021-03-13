import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class AppService {

  public username: String;
  public password: String;
  
  
  constructor(private http: HttpClient) { }

  
  public login(username:string, password:string){
   
    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username+ ":" + password) });
    return  this.http.get("http://localhost:8087/", {headers, responseType: 'text' as 'json'});
  }  

  authenticationService(username: String, password: String) {
    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username+ ":" + password) });
    return  this.http.get("http://localhost:8087/", {headers, responseType: 'text' as 'json'});
  }

  // createBasicAuthToken(username: String, password: String) {
  //   return 'Basic ' + window.btoa(username + ":" + password)
  // }

  
}