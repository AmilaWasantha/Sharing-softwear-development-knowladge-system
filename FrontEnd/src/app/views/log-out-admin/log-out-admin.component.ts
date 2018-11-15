import { Component, OnInit } from '@angular/core';
import {AdminService} from "../../service/admin.service";
import {Admin} from "../../dtos/admin";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-log-out-admin',
  templateUrl: './log-out-admin.component.html',
  styleUrls: ['./log-out-admin.component.css']
})
export class LogOutAdminComponent implements OnInit {

  Form=new FormGroup({
    password: new FormControl('',[Validators.required,Validators.minLength(6)]),
    userName: new FormControl('',[Validators.required,Validators.pattern('^[a-zA-Z]+$')]),
  })

  selectedAdmin: Admin=new Admin();
  failed:boolean;

  constructor(private adminService:AdminService) { }

  ngOnInit() {
  }

  verifyLogoout():void{
    this.adminService.verifyAdminlogOut(this.selectedAdmin).subscribe(
      (result)=>{
        this.failed=!result;
      }
    )
  }
  home():void{
    alert("Please Click Log Out Button And Confirm Your Log Out")
  }

}
