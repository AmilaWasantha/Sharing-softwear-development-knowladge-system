import { Component, OnInit } from '@angular/core';
import {UserService} from "../../service/user.service";
import {User} from "../../dtos/user";
import {AdminService} from "../../service/admin.service";

@Component({
  selector: 'app-view-all-users',
  templateUrl: './view-all-users.component.html',
  styleUrls: ['./view-all-users.component.css']
})
export class ViewAllUsersComponent implements OnInit {

  allUsers: Array<User>=[];

  constructor(private userService: UserService, private adminService:AdminService) { }

  ngOnInit() {
    this.getAllUsers();
  }

  getAllUsers():void{
    this.userService.getAllUsers().subscribe(
      (result)=>{
        this.allUsers=result;

      }
    )
  }

  home():void{
    alert("Please Click Log Out Button And Confirm Your Log Out")
  }

  logOut():void{
    this.adminService.logout();
  }
}
