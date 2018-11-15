import { Component, OnInit } from '@angular/core';
import {AnswerService} from "../../service/answer.service";
import {Answer} from "../../dtos/answer";
import {UserloginService} from "../../service/userlogin.service";

@Component({
  selector: 'app-update-your-answers',
  templateUrl: './update-your-answers.component.html',
  styleUrls: ['./update-your-answers.component.css']
})
export class UpdateYourAnswersComponent implements OnInit {

  selectedAnswer: Answer=new Answer();

  constructor(private answerService:AnswerService, private userloginService: UserloginService) { }

  ngOnInit() {
    this.setAnswerDetails();
  }

  setAnswerDetails():void{
    this.selectedAnswer=this.answerService.answer;
  }

  logOut():void{
    this.userloginService.logoutByUserProfile();
  }

  updateAnswer():void{
    this.answerService.updateAnswer(this.selectedAnswer).subscribe(
      (result)=>{
        if (result){
          alert("Answer has been updated successfully");
        }else{
          alert("Failed to update the Answer");
        }
      }
    )
  }

  home():void{
    alert("Please Click Log Out Button And Confirm Your Log Out")
  }

}
