import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {Answer} from "../dtos/answer";
import {Observable} from "rxjs";
import {Questions} from "../dtos/questions";

export const MAIN_URL= 'http://localhost:8080';
const  URL="/api/v1/answers";

@Injectable({
  providedIn: 'root'
})
export class AnswerService {

  selectedAnswers: Array<Answer>=[];

  answer: Answer=new Answer();
  selectedAnswerForCheck: Answer=new Answer();

  constructor(private http: HttpClient, private router: Router) { }

  saveAnswer(answer: Answer):Observable<boolean>{
    return this.http.put<boolean>(MAIN_URL + URL,answer);
  }

  getAllAnswersByQuestionsId(questionsId: any):Observable<Array<Answer>>{
    return this.http.get<Array<Answer>>(MAIN_URL + URL + "/mno" + "/" + questionsId);
  }

  getAllAnswersUiqueUsers(userNic: string, catogoryName: string):Observable<Array<Answer>>{
    return this.http.get<Array<Answer>>(MAIN_URL + URL + "/mno" + "/objectKey" + "/" + userNic + "/" + catogoryName);
  }

  findAnswersDetailsByAnswerId(answerId: any):Observable<Answer>{
    return this.http.get<Answer>(MAIN_URL + URL + "/" + answerId);
  }

  updateAnswer(answer: Answer):Observable<boolean>{
    return this.http.post<boolean>( MAIN_URL + URL, answer);
  }

  getAllAnswersByQuestionsCatogoryName(catogoryName:string):Observable<Array<Answer>>{
    return this.http.get<Array<Answer>>(MAIN_URL + URL + "/catogoryName" + "/" + catogoryName);
  }
}
