import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AppService } from '../app.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})

export class UserComponent implements OnInit {
  contactForm: FormGroup;
  updateUserDetails: FormGroup;
  updateUser: boolean =false;
  userTable = [];
  UserObje = {};
  title = 'full-stack';
  registeredMessage: boolean = false;
  hideUserDetails: boolean=false;

  constructor(
    private fb: FormBuilder,
    private appService: AppService
    ) { }

  ngOnInit(): void {
    this.contactForm = this.fb.group({
        userId: ['', [Validators.required]],
        name: ['', [Validators.required]]
    });
    this.userDeatailsFn();

    this.appService.getAlluser().subscribe(res=>{
      this.userTable = res.data;
    })
  }

  closeIcone(){
    this.registeredMessage = false;
  }

  close(){
    this.hideUserDetails=true;
    window.location.reload();
  }

  userDeatailsFn(){
    this.updateUserDetails = this.fb.group({
      userId: ['', [Validators.required]],
      name: ['', [Validators.required]]
    });
  }

  UpdateUSer(td){
    this.updateUser = true;
    // this.UserObje = {
    //   userid : td.userid,
    //   username : td.name,
    // }
    debugger;
    this.updateUserDetails.controls['userId'].setValue(td.userId);
    this.updateUserDetails.controls['name'].setValue(td.name);
  }

  onUpdate(){
    if(this.updateUserDetails.value == ""){
      return;
    }else{
      debugger;
      this.appService.updateUser(this.updateUserDetails.value).subscribe(res=>{
        debugger;
        this.appService.getAlluser().subscribe(res=>{
          debugger;
          this.userTable = res.data;
        })
      })
    }
    window.location.reload();
  }

  submitFilter(){
    debugger;
    this.appService.getUserById(this.contactForm.value).subscribe(res=>{
      debugger;
      this.userTable = res.data;
    })
  }

  onSubmit() {
    if(this.contactForm.value == ""){
      return;
    }else{
      debugger
      if(this.contactForm.value.name!=""){
      this.appService.addUser(this.contactForm.value).subscribe(res=>{
        this.appService.getAlluser().subscribe(res=>{
          this.userTable = res.data;
        })
      })
    }
    else{
      debugger;
    this.appService.getUserById(this.contactForm.value).subscribe(res=>{
      debugger;
      this.userTable = res.data;
    })
    }
    }
  }

  delete(td){
    let user = {
      userId : td.userId,
      name : td.userId
    }
    this.appService.deleteUser(user).subscribe(res=>{
    
      this.appService.getAlluser().subscribe(res=>{
        this.userTable = res.data;
      })
    })
  }

}
