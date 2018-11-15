import { Component, OnInit } from '@angular/core';
import {UserService} from "../../service/user.service";
import {User} from "../../dtos/user";
import {FormControl, FormGroup, Validators} from "@angular/forms";


@Component({
  selector: 'app-create-new-user-account',
  templateUrl: './create-new-user-account.component.html',
  styleUrls: ['./create-new-user-account.component.css']
})
export class CreateNewUserAccountComponent implements OnInit {

  Form=new FormGroup({
    email: new FormControl('',[Validators.required, Validators.email]),
    password: new FormControl('',[Validators.required,Validators.minLength(6)]),
    userName: new FormControl('',[Validators.required,Validators.pattern('^[a-zA-Z]+$')]),
    // phoneNumber: new FormControl('', [Validators.required,Validators.pattern('[0-9]{9}')])
    phoneNumber: new FormControl('', [Validators.required,Validators.pattern('[0-9]{3}-[0-9]{7}')]),
    nicNumber: new FormControl('', [Validators.required,Validators.pattern('[0-9]{9}[v|V]$')])
  })
  selectedUsers : User =new User();
  constructor(private userService: UserService) { }

  ngOnInit() {
    this.setDate();
  }

  setDate():void{
    // let email="chamara@gmail.com";
    // this.selectedUsers.eMail=email;
    // this.search();
  }


  saveUsers(): void{
    this.userService.save(this.selectedUsers).subscribe(
      (result)=>{
        if (result){
          alert("User has been saved successfully");
        }else{
          alert("Failed to save the user");
        }
      }
    )
  }


  // search():void{
  //   this.userService.serchUser(this.selectedUsers.eMail).subscribe(
  //
  //   )
  // }


}
