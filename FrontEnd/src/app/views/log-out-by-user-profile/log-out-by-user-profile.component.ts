import { Component, OnInit } from '@angular/core';
import {UserloginService} from "../../service/userlogin.service";
import {Userlogin} from "../../dtos/userlogin";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-log-out-by-user-profile',
  templateUrl: './log-out-by-user-profile.component.html',
  styleUrls: ['./log-out-by-user-profile.component.css']
})
export class LogOutByUserProfileComponent implements OnInit {

  Form=new FormGroup({
    password: new FormControl('',[Validators.required,Validators.minLength(6)]),
    userName: new FormControl('',[Validators.required,Validators.pattern('^[a-zA-Z]+$')]),
    email: new FormControl('',[Validators.required, Validators.email]),
    nicNumber: new FormControl('', [Validators.required,Validators.pattern('[0-9]{9}[v|V]$')])
  })

  selectedUserLogin: Userlogin=new Userlogin();
  failed:boolean;

  constructor(private userService:UserloginService) { }

  ngOnInit() {
  }

  verifyLogOutInUserProfile():void{
    this.userService.verifyLogOutInUserProfile(this.selectedUserLogin).subscribe(
      (result)=>{

        this.failed=!result;


      }
    )
  }

  home():void{
    alert("Please Click Log Out Button And Confirm Your Log Out")
  }



}
