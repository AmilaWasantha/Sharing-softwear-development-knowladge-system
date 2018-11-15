import { Component, OnInit } from '@angular/core';
import {QuestionsCatogoryService} from "../../service/questions-catogory.service";
import {Questionscatogory} from "../../dtos/questionscatogory";
import {AdminService} from "../../service/admin.service";

@Component({
  selector: 'app-all-questions-catogory',
  templateUrl: './all-questions-catogory.component.html',
  styleUrls: ['./all-questions-catogory.component.css']
})
export class AllQuestionsCatogoryComponent implements OnInit {

  questionsCatogory: Array<Questionscatogory>=[];
  constructor(private questionsCatogoryService: QuestionsCatogoryService, private adminServie: AdminService) { }

  ngOnInit() {
    this.loadAllQuestionsCatogoryDetails();
  }

  loadAllQuestionsCatogoryDetails():void{
    this.questionsCatogoryService.getAllQuestionsCatogories().subscribe(
      (result)=>{
        this.questionsCatogory =result;
        console.log("onna okkoma awa : "+ this.questionsCatogory)
      }
    )
  }

  logout():void{
    this.adminServie.logout();
  }

  home():void{
    alert("Please Click Log Out Button And Confirm Your Log Out")
  }
}
