import {Questions} from "./questions";
import {User} from "./user";

export class Answer {
  answerId: any;
  answerDescription: string;
  questionsDTO: Questions;
  questionsCatogoryname:string;
  questionsBy: string;
  questionsDescription: string;
  answerBy:string
  userDTO: User;
  status: string;
}
