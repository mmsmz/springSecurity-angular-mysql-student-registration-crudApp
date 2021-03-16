import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppService } from '../app.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username:string;
  password:string;
  message :any;
  
  errorMessage = 'Invalid Credentials';
  successMessage: string;
  invalidLogin = false;
  loginSuccess = false;

  constructor(private service : AppService,
              private router : Router) { }

  ngOnInit(): void {
  } 

  
  // doLogin(){

  //   let resp = this.service.login(this.username,this.password);
  //   debugger
  //   resp.subscribe(data=>{   
  //     this.router.navigate(["/user"]);
  //     return true;
  //   });
    
  // }


  doLogin() {
    debugger
    this.service.authenticationService(this.username, this.password).subscribe((result)=> {
      this.invalidLogin = false;debugger
      this.loginSuccess = true;
      
      this.successMessage = 'Login Successful.';
      localStorage.setItem('username',this.username);
      localStorage.setItem('password',this.password);
      if(result == "[ADMIN]"){
         debugger
       this.router.navigate(['/user']);
      }
      else if(result == "[USER]"){
        debugger
      this.router.navigate(['/course']);
      }
    }, () => {
      this.invalidLogin = true;
      this.loginSuccess = false;
    });      
  } 
  // use boolean as a default user 
  // subject rxjs

}
