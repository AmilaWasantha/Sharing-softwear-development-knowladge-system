import { Component, OnInit } from '@angular/core';
import {UserloginService} from "../../service/userlogin.service";
import {QuestionsCatogoryService} from "../../service/questions-catogory.service";
import {Questionscatogory} from "../../dtos/questionscatogory";
import {Questions} from "../../dtos/questions";
import {QuestionsService} from "../../service/questions.service";
import {User} from "../../dtos/user";
import {Router} from "@angular/router";
import {AnswerService} from "../../service/answer.service";

@Component({
  selector: 'app-view-all-question-of-unique-user',
  templateUrl: './view-all-question-of-unique-user.component.html',
  styleUrls: ['./view-all-question-of-unique-user.component.css']
})
export class ViewAllQuestionOfUniqueUserComponent implements OnInit {

  questionsCatogoriy: Array<Questionscatogory>=[];
  allQuestions:Array<Questions>=[];
  selectedQuestionsCatogory : Questionscatogory=new Questionscatogory();
  selectedUser: User=new User();

  constructor(private userLoginServie: UserloginService, private questionsCatogoryService:QuestionsCatogoryService, private questionsService:QuestionsService,private router: Router, private  answerService: AnswerService) { }

  ngOnInit() {
    this.getQuestionsCatogoryNames();
    this.setUsrNic();

  }

  logOut():void{
    this.userLoginServie.logoutByUserProfile();
  }

  getQuestionsCatogoryNames():void{
    this.questionsCatogoryService.getAllQuestionsCatogories().subscribe(
      (result)=>{
        this.questionsCatogoriy=result;
        console.log(this.questionsCatogoriy)
      }
    )
  }

  searchAllQuestinsDetailsOfUniqueUsers(event:any): void{
    this.questionsService.searchAllQuestionDetailsOfUniqueUser(this.selectedUser.nic , event.target.value).subscribe(
      (result)=>{
        this.allQuestions=result;
        console.log(this.allQuestions)
      }
    )
  }


  setUsrNic():void{
    this.selectedUser.nic=this.userLoginServie.selectedUser.nic;
  }

  setAnswerDateToQuestions(questions: Questions):void{
    this.answerService.getAllAnswersByQuestionsId(questions.questionsId).subscribe(
      (result)=>{
        this.answerService.selectedAnswers=result;
        if (result){
          this.router.navigate(['/ViewAllAnswerForUniqueUsersQuestionsComponent']);
        }
      }
    );




  }

  home():void{
    alert("Please Click Log Out Button And Confirm Your Log Out")
  }

}
