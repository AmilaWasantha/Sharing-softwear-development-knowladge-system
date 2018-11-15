import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {Observable} from "rxjs";
import {Questions} from "../dtos/questions";
import {Questionscatogory} from "../dtos/questionscatogory";
import {map} from "rxjs/operators";

export const MAIN_URL= 'http://localhost:8080';
const  URL="/api/v1/questions";

@Injectable({
  providedIn: 'root'
})
export class QuestionsService {

  questionsDetails: Questions=new Questions();

  constructor(private http: HttpClient, private router: Router) { }

  saveQuestions(questions: Questions): Observable<boolean>{
    return this.http.put<boolean>(MAIN_URL + URL, questions);
  }

  searchAllQuestinsDetailsForQuestionsCatogory(questionsCatogory: string):Observable<Array<Questions>>{
    return this.http.get<Array<Questions>>(MAIN_URL + URL + "/mno"+ "/"+ questionsCatogory);
  }

  searchAllQuestionDetailsOfUniqueUser(userNic: string, questionsCatogory: string):Observable<Array<Questions>>{
    return this.http.get<Array<Questions>>(MAIN_URL + URL + "/mno" + "/objectKey" + "/" + userNic + "/" + questionsCatogory);
  }



  setQuestionsDetails(questions: Questions):void{
    this.questionsDetails.description=questions.description;
    this.questionsDetails.questionsId=questions.questionsId;
    this.questionsDetails.userName=questions.userName;
    this.questionsDetails.userDTO.eMail=questions.userDTO.eMail;

  }

  searchQuestionsDetailsByQuestionsId(questionsId: any):Observable<Questions>{
    return this.http.get<Questions>(MAIN_URL + URL + "/" + questionsId)

  }
}
