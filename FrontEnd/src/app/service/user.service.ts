import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {User} from "../dtos/user";
import {Observable} from "rxjs";


export const MAIN_URL= 'http://localhost:8080';
const  URL="/api/v1/users";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient, private router: Router) { }

  save(user: User): Observable<boolean>{
    return this.http.put<boolean>(MAIN_URL + URL, user);
  }

  serchUser(email: string):Observable<User>{
    return this.http.get<User>(MAIN_URL + URL + "/"+ email);
  }

  findUserByNic(nic:string):Observable<User>{
    return this.http.get<User>(MAIN_URL+URL + "/" + nic);
  }

  updateUser(user: User):Observable<boolean>{
    return this.http.post<boolean>(MAIN_URL + URL, user);
  }

  getAllUsers():Observable<Array<User>>{
    return this.http.get<Array<User>>(MAIN_URL + URL);
  }
}
