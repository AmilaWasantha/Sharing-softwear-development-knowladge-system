import { Component,ElementRef, OnInit } from '@angular/core';
import {UserService} from "../../service/user.service";
import {UserloginService} from "../../service/userlogin.service";
import {Userlogin} from "../../dtos/userlogin";
import {Questionscatogory} from "../../dtos/questionscatogory";
import {QuestionsCatogoryService} from "../../service/questions-catogory.service";
import {QuestionsService} from "../../service/questions.service";
import {Questions} from "../../dtos/questions";
import {User} from "../../dtos/user";

@Component({
  selector: 'app-make-questions',
  templateUrl: './make-questions.component.html',
  styleUrls: ['./make-questions.component.css']
})
export class MakeQuestionsComponent implements OnInit {

  questionsCatogoriy: Array<Questionscatogory>=[];
  userLogin: Userlogin=new Userlogin();
  selectedQuestionsCatogory : Questionscatogory=new Questionscatogory();
  selectedQuestions: Questions=new Questions();
  selectedUsers: User=new User();


  constructor(private userService: UserloginService,private questionsCatogoryService: QuestionsCatogoryService, private questionsService: QuestionsService,private elem: ElementRef) { }

  ngOnInit() {
    this.setUserdeta();
    this.getQuestionsCatogoryNames();
  }

  logout():void{
    this.userService.logout();
  }

  setUserdeta():void{
    this.userLogin.email=this.userService.selectedUser.email;
    this.userLogin.userName=this.userService.selectedUser.userName;
    this.userLogin.nic=this.userService.selectedUser.nic;

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

  saveQuestions():void{
    this.selectedUsers.nic=this.userLogin.nic;
    this.selectedQuestions.userEmail=this.userLogin.email;
    this.selectedQuestions.userDTO=this.selectedUsers;
    this.selectedQuestions.userName=this.userLogin.userName;
    this.selectedQuestions.questionsCatogoryDTO=this.selectedQuestionsCatogory;

    this.questionsService.saveQuestions(this.selectedQuestions).subscribe(
      (result)=>{
        if(result){
          alert("questions save successfully")
        }else{
          alert("somthing wrong")
        }
      }
    )
  }

  setCatogoryName():void{
    this.selectedQuestions.questionsCatogoryDTO.catogoryName=this.elem.nativeElement.querySelector('#comboQuestionsCatogory').value;
    console.log(this.selectedQuestions.questionsCatogoryDTO.catogoryName)
  }

  home():void{
    alert("Please Click Log Out Button And Confirm Your Log Out")
  }
}
