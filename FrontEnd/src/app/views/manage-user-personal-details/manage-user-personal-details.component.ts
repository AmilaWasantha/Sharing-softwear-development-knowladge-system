import { Component, OnInit } from '@angular/core';
import {UserloginService} from "../../service/userlogin.service";
import {User} from "../../dtos/user";
import {UserService} from "../../service/user.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-manage-user-personal-details',
  templateUrl: './manage-user-personal-details.component.html',
  styleUrls: ['./manage-user-personal-details.component.css']
})
export class ManageUserPersonalDetailsComponent implements OnInit {

  Form=new FormGroup({
    email: new FormControl('',[Validators.required, Validators.email]),
    // password: new FormControl('',[Validators.required,Validators.minLength(6)]),
    userName: new FormControl('',[Validators.required,Validators.pattern('^[a-zA-Z]+$')]),
    // phoneNumber: new FormControl('', [Validators.required,Validators.pattern('[0-9]{9}')])
    phoneNumber: new FormControl('', [Validators.required,Validators.pattern('[0-9]{3}-[0-9]{7}')]),
    nicNumber: new FormControl('', [Validators.required,Validators.pattern('[0-9]{9}[v|V]$')])
  })

  selectedUser: User=new User();

  constructor(private userLogoutService: UserloginService, private userService: UserService) { }

  ngOnInit() {
    this.setUserNic();
  }

  logOUt():void{
    this.userLogoutService.logoutByUserProfile();
  }

  setUserNic():void{
    this.selectedUser.nic=this.userLogoutService.selectedUser.nic;
    this.findUserByNic();
  }

  findUserByNic():void{
    this.userService.findUserByNic(this.selectedUser.nic).subscribe(
      (result)=>{
        this.selectedUser=result;
      }
    )
  }

  updateUser(): void{
    this.userService.updateUser(this.selectedUser).subscribe(
      (result)=>{
        if (result){
          alert("User has been updated successfully");
        }else{
          alert("Failed to update the user");
        }
      }
    )
  }

  home():void{
    alert("Please Click Log Out Button And Confirm Your Log Out")
  }

}
