import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Userlogin} from "../dtos/userlogin";
import {Observable, pipe} from "rxjs";
import {promise} from "selenium-webdriver";
import {map} from "rxjs/operators";
import {Router} from "@angular/router";
import {User} from "../dtos/user";


export const MAIN_URL= 'http://localhost:8080';
 const  URL="/api/v1/userlogins";
 @Injectable()

 export class UserloginService {

   selectedUser: Userlogin =new Userlogin();

  constructor(private http: HttpClient, private router: Router) {
  }

  saveUser(user: Userlogin): Observable<boolean>{
    return this.http.put<boolean>(MAIN_URL + URL, user);
  }

  login(user: Userlogin): Observable<boolean>{
    return this.http.post<boolean>(MAIN_URL + URL, user)
      .pipe(
        map((result)=>{
          sessionStorage.setItem("token", result+ "");
          if (result){

            this.router.navigate(['/userDashBoard']);
          }
          return result;
        })
      )
  }

  logout():void{
    sessionStorage.removeItem("token");
    this.router.navigate(['/LogOutUserComponent']);
  }

  setUserDetails(user: Userlogin): void{
    this.selectedUser=user;
  }

   loginFormVerifyManageProfile(user: Userlogin): Observable<boolean>{
     return this.http.put<boolean>(MAIN_URL + URL, user)
       .pipe(
         map((result)=>{
           sessionStorage.setItem("token", result+ "");
           if (result){
             this.router.navigate(['/manageProfile']);
           }
           return result;
         })
       )
   }



   verifyLogOutInUserProfile(user: Userlogin): Observable<boolean>{
     return this.http.put<boolean>(MAIN_URL + URL  , user)
       .pipe(
         map((result)=>{
           if (result){
             if(confirm("Are You Sure, Do You Want Confirm Log Out ? ")){
               this.router.navigate(['/userDashBoard']);
             }else{
               this.router.navigate(['/manageProfile']);
             }
           }
           return result;
         })
       )
   }

   logoutByUserProfile():void{
     sessionStorage.removeItem("token");
     this.router.navigate(['/LogOutInThisUserProfileComponent']);
   }

   isAuthenticated(): boolean{
     if (sessionStorage.getItem("token")){
       return sessionStorage.getItem("token") == 'false' ? false: true;
     }
   }


   verifyLogOutUser(user: Userlogin): Observable<boolean>{
     return this.http.put<boolean>(MAIN_URL + URL  , user)
       .pipe(
         map((result)=>{
           if (result){
             if(confirm("Are You Sure, Do You Want Confirm Log Out ? ")){
               this.router.navigate(['/home']);
             }else{
               this.router.navigate(['/userDashBoard']);
             }
           }
           return result;
         })
       )
   }

}
