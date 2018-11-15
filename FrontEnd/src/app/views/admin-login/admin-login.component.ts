import { Component, OnInit } from '@angular/core';
import {AdminService} from "../../service/admin.service";
import {Admin} from "../../dtos/admin";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  Form=new FormGroup({
    password: new FormControl('',[Validators.required,Validators.minLength(6)]),
    userName: new FormControl('',[Validators.required,Validators.pattern('^[a-zA-Z]+$')]),
  })

  admin: Admin=new Admin();
  failed: boolean;

  constructor(private adminService: AdminService) { }

  ngOnInit() {
  }

  login():void{
    this.adminService.login(this.admin).subscribe(
      (result)=>{
        this.failed=!result;
      }


    )
  }


}
