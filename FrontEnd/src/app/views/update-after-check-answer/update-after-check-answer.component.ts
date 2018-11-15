import { Component, OnInit } from '@angular/core';
import {UserloginService} from "../../service/userlogin.service";
import {Answer} from "../../dtos/answer";
import {AnswerService} from "../../service/answer.service";
import {AdminService} from "../../service/admin.service";

@Component({
  selector: 'app-update-after-check-answer',
  templateUrl: './update-after-check-answer.component.html',
  styleUrls: ['./update-after-check-answer.component.css']
})
export class UpdateAfterCheckAnswerComponent implements OnInit {
  selectedAnswer: Answer=new Answer();

  constructor(private  adminLoginSerive: AdminService,private answerService:AnswerService) { }

  ngOnInit() {
    this.setAnswerDetails();
  }

  logOUt():void{
    this.adminLoginSerive.logout();
  }

  setAnswerDetails():void{
    this.selectedAnswer=this.answerService.selectedAnswerForCheck;
  }

  checkAnswers():void{
    this.answerService.updateAnswer(this.selectedAnswer).subscribe(
      (result)=>{
        if (result){
          alert("Answer has been Check successfully");
        }else{
          alert("Failed to Check the Answer");
        }
      }
    )
  }

  home():void{
    alert("Please Click Log Out Button And Confirm Your Log Out")
  }

}
