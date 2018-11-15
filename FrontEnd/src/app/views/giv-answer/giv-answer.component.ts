import {Component, ElementRef, OnInit} from '@angular/core';
import {Questionscatogory} from "../../dtos/questionscatogory";
import {Questions} from "../../dtos/questions";
import {QuestionsCatogoryService} from "../../service/questions-catogory.service";
import {QuestionsService} from "../../service/questions.service";
import {UserloginService} from "../../service/userlogin.service";
import {Userlogin} from "../../dtos/userlogin";
import {Answer} from "../../dtos/answer";
import {AnswerService} from "../../service/answer.service";
import {User} from "../../dtos/user";

@Component({
  selector: 'app-giv-answer',
  templateUrl: './giv-answer.component.html',
  styleUrls: ['./giv-answer.component.css']
})
export class GivAnswerComponent implements OnInit {

  questionsCatogoriy: Array<Questionscatogory>=[];
  allQuestions:Array<Questions>=[];
  selectedQuestionsCatogory : Questionscatogory=new Questionscatogory();
  selectedAnswers:Answer= new Answer();
  selectedQuestions: Questions=new Questions();
  selectedUserLogin: Userlogin=new Userlogin();
  selectedUser: User=new User();


  constructor(private questionsCatogoryService: QuestionsCatogoryService, private questionsService: QuestionsService,private elem: ElementRef, private userLoginService: UserloginService, private answerService: AnswerService) { }

  ngOnInit() {

    this.setQuestionsDetails();

  }

  setQuestionsDetails():void{
    this.selectedQuestions=this.questionsService.questionsDetails;
    this.selectedUserLogin.email=this.userLoginService.selectedUser.email;
    this.selectedUserLogin.nic=this.userLoginService.selectedUser.nic;
    this.selectedUser.nic=this.userLoginService.selectedUser.nic;

  }

  setDetailsForSaveAnswer():void{
    this.selectedAnswers.questionsDTO=this.selectedQuestions;
    this.selectedAnswers.questionsDescription=this.selectedQuestions.description;
    this.selectedAnswers.questionsBy=this.selectedQuestions.userEmail;
    this.selectedAnswers.questionsCatogoryname=this.selectedQuestions.questionsCatogoryDTO.catogoryName;
    this.selectedAnswers.answerBy=this.selectedUserLogin.email;
    this.selectedAnswers.userDTO=this.selectedUser;
    this.saveAnswers();
  }


  saveAnswers(): void{
    this.answerService.saveAnswer(this.selectedAnswers).subscribe(
      (result)=>{
        if (result){
          alert("Answer has been save successfully");
        }else{
          alert("Failed to save the Answer");
        }
      }
    )
  }

  logOUt():void{
    this.userLoginService.logout();
  }

  home():void{
    alert("Please Click Log Out Button And Confirm Your Log Out")
  }



}
