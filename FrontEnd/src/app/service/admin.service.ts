import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {Userlogin} from "../dtos/userlogin";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {Admin} from "../dtos/admin";

export const MAIN_URL= 'http://localhost:8080';
const  URL="/api/v1/adminLogins";

@Injectable({
  providedIn: 'root'
})

export class AdminService {

  constructor(private http: HttpClient, private router: Router ) { }

  login(admin: Admin): Observable<boolean>{
    return this.http.post<boolean>(MAIN_URL + URL, admin)
      .pipe(
        map((result)=>{
          sessionStorage.setItem("token", result+ "");
          if (result){
            this.router.navigate(['/adminDashboard']);
          }
          return result;
        })
      )
  }

   logout():void{
    sessionStorage.removeItem("token");
    this.router.navigate(['/LogOutAdminComponent'])
  }

  verifyAdminlogOut(admin: Admin): Observable<boolean>{
    return this.http.post<boolean>(MAIN_URL + URL, admin)
      .pipe(
        map((result)=>{
          if (result){
            if(confirm("Are You Sure, Do You Want Confirm Log Out ? ")){
              this.router.navigate(['/home']);
            }else{
              this.router.navigate(['/adminDashboard']);
            }
          }
          return result;
        })
      )
  }

}
