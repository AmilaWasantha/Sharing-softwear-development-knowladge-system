import { Component, OnInit } from '@angular/core';
import {UserloginService} from "../../service/userlogin.service";
import {AdminService} from "../../service/admin.service";

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  constructor(private adminService: AdminService ) { }

  ngOnInit() {
  }

  logout():void{
    this.adminService.logout();
  }

  home():void{
    alert("Please Click Log Out Button And Confirm Your Log Out")
  }
}
