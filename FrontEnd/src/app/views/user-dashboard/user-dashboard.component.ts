import { Component, OnInit } from '@angular/core';
import {Userlogin} from "../../dtos/userlogin";
import {UserloginService} from "../../service/userlogin.service";

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {
  constructor(private userService: UserloginService) { }

  ngOnInit() {
  }

  logout():void{
    this.userService.logout();
  }

  home():void{
    alert("Please Click Log Out Button And Confirm Your Log Out")
  }
}
