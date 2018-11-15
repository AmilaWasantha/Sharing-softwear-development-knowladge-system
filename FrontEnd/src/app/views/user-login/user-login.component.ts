import { Component, OnInit } from '@angular/core';
import {Userlogin} from "../../dtos/userlogin";
import {UserloginService} from "../../service/userlogin.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  Form=new FormGroup({
    email: new FormControl('',[Validators.required, Validators.email]),
    password: new FormControl('',[Validators.required,Validators.minLength(6)]),
    userName: new FormControl('',[Validators.required,Validators.pattern('^[a-zA-Z]+$')]),
    // phoneNumber: new FormControl('', [Validators.required,Validators.pattern('[0-9]{9}')])
    // phoneNumber: new FormControl('', [Validators.required,Validators.pattern('[0-9]{3}-[0-9]{7}')]),
    nicNumber: new FormControl('', [Validators.required,Validators.pattern('[0-9]{9}[v|V]$')])
  })

  user: Userlogin=new Userlogin();
  failed: boolean;
  constructor(private userService: UserloginService) { }

  ngOnInit() {
  }

  login():void{
    this.setUsersData();
    this.userService.login(this.user).subscribe(
      (result)=>{
        this.failed=!result;
      }
    )
  }



  setUsersData():void{
    this.userService.setUserDetails(this.user);
  }





}
