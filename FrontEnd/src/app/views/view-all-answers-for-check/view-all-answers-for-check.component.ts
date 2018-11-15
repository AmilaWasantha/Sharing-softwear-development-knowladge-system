import { Component, OnInit } from '@angular/core';
import {UserloginService} from "../../service/userlogin.service";
import {QuestionsCatogoryService} from "../../service/questions-catogory.service";
import {Questionscatogory} from "../../dtos/questionscatogory";
import {Answer} from "../../dtos/answer";
import {AnswerService} from "../../service/answer.service";
import {Router} from "@angular/router";
import {AdminService} from "../../service/admin.service";

@Component({
  selector: 'app-view-all-answers-for-check',
  templateUrl: './view-all-answers-for-check.component.html',
  styleUrls: ['./view-all-answers-for-check.component.css']
})
export class ViewAllAnswersForCheckComponent implements OnInit {

  questionsCatogoriy: Array<Questionscatogory>=[];
  allAnswers:Array<Answer>=[];
  selectedQuestionsCatogory : Questionscatogory=new Questionscatogory();

  constructor(private userLoginService:UserloginService, private questionsCatogoryService:QuestionsCatogoryService, private answerService: AnswerService,private router: Router, private adminService:AdminService) { }

  ngOnInit() {
    this.getQuestionsCatogoryNames();
  }

  logout():void{
    this.adminService.logout();
  }

  getQuestionsCatogoryNames():void{
    this.questionsCatogoryService.getAllQuestionsCatogories().subscribe(
      (result)=>{
        this.questionsCatogoriy=result;
        console.log(this.questionsCatogoriy)
      }
    )
  }

  getAllAnswersByQuestionsCatogoryName(event:any): void{
    this.answerService.getAllAnswersByQuestionsCatogoryName(event.target.value).subscribe(
      (result)=>{
        this.allAnswers=result;
        console.log(this.allAnswers)
      }
    )
  }

  setAnswerDateForCheckAnswer(answers: Answer):void {
    this.answerService.findAnswersDetailsByAnswerId(answers.answerId).subscribe(
      (result) => {
        this.answerService.selectedAnswerForCheck = result;
        if (result) {
          this.router.navigate(['/UpdateAfterCheckAnswerComponent']);
        }
      }
    );
  }

  home():void{
    alert("Please Click Log Out Button And Confirm Your Log Out")
  }

}
