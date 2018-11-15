import { Component, OnInit } from '@angular/core';
import {UserloginService} from "../../service/userlogin.service";
import {Questionscatogory} from "../../dtos/questionscatogory";
import {QuestionsCatogoryService} from "../../service/questions-catogory.service";
import {Answer} from "../../dtos/answer";
import {User} from "../../dtos/user";
import {AnswerService} from "../../service/answer.service";
import {Questions} from "../../dtos/questions";
import {Router} from "@angular/router";

@Component({
  selector: 'app-mgnage-users-unique-answers',
  templateUrl: './mgnage-users-unique-answers.component.html',
  styleUrls: ['./mgnage-users-unique-answers.component.css']
})
export class MgnageUsersUniqueAnswersComponent implements OnInit {

  questionsCatogoriy: Array<Questionscatogory>=[];
  allAnswers:Array<Answer>=[];
  selectedUser: User=new User();
  selectedQuestionsCatogory : Questionscatogory=new Questionscatogory();

  constructor(private  userloginServie:UserloginService, private questionsCatogoryService:QuestionsCatogoryService, private answerSerivce: AnswerService,private router: Router) { }

  ngOnInit() {
    this.getQuestionsCatogoryNames();
    this.setUserNic();
  }

  logOUt():void{
    this.userloginServie.logoutByUserProfile();
  }

  getQuestionsCatogoryNames():void{
    this.questionsCatogoryService.getAllQuestionsCatogories().subscribe(
      (result)=>{
        this.questionsCatogoriy=result;
        console.log(this.questionsCatogoriy)
      }
    )
  }




  getAllAnswersUiqueUsers(event:any): void{
    this.answerSerivce.getAllAnswersUiqueUsers(this.selectedUser.nic , event.target.value).subscribe(
      (result)=>{
        this.allAnswers=result;
        console.log(this.allAnswers)
      }
    )
  }

  setUserNic():void{
    this.selectedUser.nic=this.userloginServie.selectedUser.nic;
  }

  setAnswerDataToEditAnswer(answers: Answer):void {
    this.answerSerivce.findAnswersDetailsByAnswerId(answers.answerId).subscribe(
      (result) => {
        this.answerSerivce.answer = result;
        if (result) {
          this.router.navigate(['/UpdateYourAnswersComponent']);
        }
      }
    );
  }

  home():void{
    alert("Please Click Log Out Button And Confirm Your Log Out")
  }



}
