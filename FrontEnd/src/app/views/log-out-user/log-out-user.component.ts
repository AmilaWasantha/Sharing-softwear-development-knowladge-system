import { Component, OnInit } from '@angular/core';
import {Userlogin} from "../../dtos/userlogin";
import {UserloginService} from "../../service/userlogin.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-log-out-user',
  templateUrl: './log-out-user.component.html',
  styleUrls: ['./log-out-user.component.css']
})
export class LogOutUserComponent implements OnInit {

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

  verifyLogOutUser():void{
    this.userService.verifyLogOutUser(this.selectedUserLogin).subscribe(
      (result)=>{

        this.failed=!result;


      }
    )
  }
  home():void{
    alert("Please Click Log Out Button And Confirm Your Log Out")
  }

}
