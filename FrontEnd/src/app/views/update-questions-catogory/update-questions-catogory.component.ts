import { Component, OnInit } from '@angular/core';
import {QuestionsCatogoryService} from "../../service/questions-catogory.service";
import {Questionscatogory} from "../../dtos/questionscatogory";
import {AdminService} from "../../service/admin.service";

@Component({
  selector: 'app-update-questions-catogory',
  templateUrl: './update-questions-catogory.component.html',
  styleUrls: ['./update-questions-catogory.component.css']
})
export class UpdateQuestionsCatogoryComponent implements OnInit {

  questionsCatogoriy: Array<Questionscatogory>=[];
  selectedQuestionsCatogory : Questionscatogory=new Questionscatogory();

  constructor(private questionsCatogoryService: QuestionsCatogoryService, private adminService:AdminService) { }

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

  searchQuestionsCatogory(event:any): void{
    this.questionsCatogoryService.searchQuestionsCatogory(event.target.value).subscribe(
      (result)=>{
        this.selectedQuestionsCatogory=result;
        console.log(this.selectedQuestionsCatogory)
      }
    )
  }

  updateQuestionsCatogory():void{
    this.questionsCatogoryService.updateQuestionsCatogory(this.selectedQuestionsCatogory.catogoryName,this.selectedQuestionsCatogory).subscribe(
      (result)=>{
        if(result){
          alert("Questions Catogory Update Successfully");
          this.getQuestionsCatogoryNames();
        }else {
          alert("somthing worong");
        }
      }
    )
  }

  logOut():void{
    this.adminService.logout();
  }

  home():void{
    alert("Please Click Log Out Button And Confirm Your Log Out")
  }


}
