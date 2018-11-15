import { Injectable } from '@angular/core';
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {Questionscatogory} from "../dtos/questionscatogory";
import {Observable} from "rxjs";

export const MAIN_URL= "http://localhost:8080";
const  URL="/api/v1/qustionsCatogories";

@Injectable({
  providedIn: 'root'
})
export class QuestionsCatogoryService {

  constructor(private http: HttpClient, private router: Router) { }

  save(questionsCatogory: Questionscatogory): Observable<boolean>{
     return this.http.put<boolean>(MAIN_URL + URL, questionsCatogory);
  }

  getAllQuestionsCatogories():Observable<Array<Questionscatogory>>{
    return this.http.get<Array<Questionscatogory>>(MAIN_URL + URL);
  }

  searchQuestionsCatogory(id: string):Observable<Questionscatogory>{
    return this.http.get<Questionscatogory>(MAIN_URL + URL + "/"+ id);
  }

  updateQuestionsCatogory( id: string,questionsCatogory: Questionscatogory):Observable<boolean>{
    return this.http.post<boolean>(MAIN_URL + URL +"/"+ id ,questionsCatogory);
  }
}
