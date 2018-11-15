import { Component, OnInit } from '@angular/core';
import {AdminService} from "../../service/admin.service";
import {QuestionsCatogoryService} from "../../service/questions-catogory.service";
import {Questionscatogory} from "../../dtos/questionscatogory";

@Component({
  selector: 'app-make-questions-catogory',
  templateUrl: './make-questions-catogory.component.html',
  styleUrls: ['./make-questions-catogory.component.css']
})
export class MakeQuestionsCatogoryComponent implements OnInit {

  selectedQuestionsCatogory:Questionscatogory=new Questionscatogory();
  constructor(private adminService: AdminService, private questionsService: QuestionsCatogoryService) { }

  ngOnInit() {
  }

  logout(){
    this.adminService.logout();
  }

  saveQuestionsCatogory(): void{
    this.questionsService.save(this.selectedQuestionsCatogory).subscribe(
      (result)=>{
        if (result){
          alert("Questions Catogory has been saved successfully");
        }else{
          alert("Failed to save the QuestionsCatogory");
        }
      }
    )
  }

  home():void{
    alert("Please Click Log Out Button And Confirm Your Log Out")
  }


}
