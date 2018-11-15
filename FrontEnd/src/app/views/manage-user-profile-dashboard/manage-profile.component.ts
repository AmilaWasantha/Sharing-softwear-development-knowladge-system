import { Component, OnInit } from '@angular/core';
import {UserloginService} from "../../service/userlogin.service";

@Component({
  selector: 'app-manage-profile',
  templateUrl: './manage-profile.component.html',
  styleUrls: ['./manage-profile.component.css']
})
export class ManageProfileComponent implements OnInit {

  constructor(private userLoginService: UserloginService) { }

  ngOnInit() {
  }

  logOUt():void{
    this.userLoginService.logoutByUserProfile();
  }

  home():void{
    alert("Please Click Log Out Button And Confirm Your Log Out")
  }

}
