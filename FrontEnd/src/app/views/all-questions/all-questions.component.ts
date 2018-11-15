import {Component, ElementRef, OnInit} from '@angular/core';
import {QuestionsCatogoryService} from "../../service/questions-catogory.service";
import {Questionscatogory} from "../../dtos/questionscatogory";
import {Questions} from "../../dtos/questions";
import {QuestionsService} from "../../service/questions.service";
import {map} from "rxjs/operators";
import {Router} from "@angular/router";
import {UserloginService} from "../../service/userlogin.service";

@Component({
  selector: 'app-all-questions',
  templateUrl: './all-questions.component.html',
  styleUrls: ['./all-questions.component.css']
})
export class AllQuestionsComponent implements OnInit {

  questionsCatogoriy: Array<Questionscatogory>=[];
  allQuestions:Array<Questions>=[];
  selectedQuestionsCatogory : Questionscatogory=new Questionscatogory();
  setQuestionsDetails: Questions=new Questions();

  constructor(private questionsCatogoryService: QuestionsCatogoryService, private questionsService: QuestionsService,private elem: ElementRef,private router: Router, private userLoginSerive:UserloginService) { }

  ngOnInit() {
    this.getQuestionsCatogoryNames();
  }

  getQuestionsCatogoryNames():void{
    this.questionsCatogoryService.getAllQuestionsCatogories().subscribe(
      (result)=>{
        this.questionsCatogoriy=result;
        console.log(this.questionsCatogoriy)
      }
    )
  }

  searchAllQuestinsDetailsForQuestionsCatogory(event:any): void{
    this.questionsService.searchAllQuestinsDetailsForQuestionsCatogory(event.target.value).subscribe(
      (result)=>{
        this.allQuestions=result;
        console.log(this.allQuestions)
      }
    )
  }

  setQuestionsRowData(questions: Questions):void{
     this.questionsService.searchQuestionsDetailsByQuestionsId(questions.questionsId).subscribe(
       (result)=>{
         this.questionsService.questionsDetails.questionsId=questions.questionsId;
         this.questionsService.questionsDetails=result
         if (result){
           this.router.navigate(['/giveAnswer']);
         }
    }
     );


  }

  logOut():void{
    this.userLoginSerive.logout();
  }

  home():void{
    alert("Please Click Log Out Button And Confirm Your Log Out")
  }


}
