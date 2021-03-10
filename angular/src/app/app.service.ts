import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(private http: HttpClient) { }

  public login(username:string, password:string){
    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username+ ":" + password) });
    return  this.http.get("http://localhost:8087/", {headers, responseType: 'text' as 'json'});
  }  

  // public getAlluser(){
  //   let username = 'foo';
  //   let password = 'foo';
  //   const headers = new HttpHeaders({Authorization: 'Basic ' +btoa(username+ ":" +password) });
  //   return  this.http.get("http://localhost:8087/getAllUsers", {headers});
  // }


}
