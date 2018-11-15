import { Component, OnInit } from '@angular/core';
import {Answer} from "../../dtos/answer";
import {AnswerService} from "../../service/answer.service";
import {UserloginService} from "../../service/userlogin.service";

@Component({
  selector: 'app-view-all-answer-for-unique-users-questions',
  templateUrl: './view-all-answer-for-unique-users-questions.component.html',
  styleUrls: ['./view-all-answer-for-unique-users-questions.component.css']
})
export class ViewAllAnswerForUniqueUsersQuestionsComponent implements OnInit {

  selectedAnswers: Array<Answer>=[];

  constructor(private answerService: AnswerService, private userLoginServie: UserloginService) { }

  ngOnInit() {
    this.setAnswersData();

  }
  setAnswersData():void{
    this.selectedAnswers=this.answerService.selectedAnswers;
  }

  logOut():void{
    this.userLoginServie.logoutByUserProfile();
  }

  home():void{
    alert("Please Click Log Out Button And Confirm Your Log Out")
  }

}
