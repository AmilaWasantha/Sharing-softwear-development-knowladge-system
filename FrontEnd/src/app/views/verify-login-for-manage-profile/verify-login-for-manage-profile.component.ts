import { Component, OnInit } from '@angular/core';
import {UserService} from "../../service/user.service";
import {UserloginService} from "../../service/userlogin.service";
import {Userlogin} from "../../dtos/userlogin";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-verify-login-for-manage-profile',
  templateUrl: './verify-login-for-manage-profile.component.html',
  styleUrls: ['./verify-login-for-manage-profile.component.css']
})
export class VerifyLoginForManageProfileComponent implements OnInit {

  Form=new FormGroup({
    password: new FormControl('',[Validators.required,Validators.minLength(6)]),
    userName: new FormControl('',[Validators.required,Validators.pattern('^[a-zA-Z]+$')]),
  })

  selectedUserLogin: Userlogin=new Userlogin();
  failed:boolean;

  constructor(private userService:UserloginService) { }

  ngOnInit() {
    this.setData();
  }

  logout():void{
    this.userService.logout();
  }

  setData():void{
    this.selectedUserLogin.nic=this.userService.selectedUser.nic;
    this.selectedUserLogin.email=this.userService.selectedUser.email;
  }

  login():void{
    this.userService.loginFormVerifyManageProfile(this.selectedUserLogin).subscribe(
      (result)=>{
        this.failed=!result;
      }
    )
  }

  home():void{
    alert("Please Click Log Out Button And Confirm Your Log Out")
  }

}
