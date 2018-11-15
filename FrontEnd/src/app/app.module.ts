import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AdminDashboardComponent } from './views/admin-dashboard/admin-dashboard.component';
import { HomeComponent } from './views/home/home.component';
import { UserDashboardComponent } from './views/user-dashboard/user-dashboard.component';
import { UserLoginComponent } from './views/user-login/user-login.component';
import { AdminLoginComponent } from './views/admin-login/admin-login.component';
import { CreateNewUserAccountComponent } from './views/create-new-user-account/create-new-user-account.component';
import { AppRoutingModule } from './app-routing.module';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {UserloginService} from "./service/userlogin.service";
import {AdminService} from "./service/admin.service";
import { MakeQuestionsCatogoryComponent } from './views/make-questions-catogory/make-questions-catogory.component';
import { UpdateQuestionsCatogoryComponent } from './views/update-questions-catogory/update-questions-catogory.component';
import { AllQuestionsCatogoryComponent } from './views/all-questions-catogory/all-questions-catogory.component';
import { MakeQuestionsComponent } from './views/make-questions/make-questions.component';
import { AllQuestionsComponent } from './views/all-questions/all-questions.component';
import { GivAnswerComponent } from './views/giv-answer/giv-answer.component';
import { VerifyLoginForManageProfileComponent } from './views/verify-login-for-manage-profile/verify-login-for-manage-profile.component';
import { ManageProfileComponent } from './views/manage-user-profile-dashboard/manage-profile.component';
import { ManageUserPersonalDetailsComponent } from './views/manage-user-personal-details/manage-user-personal-details.component';
import { ViewAllQuestionOfUniqueUserComponent } from './views/view-all-question-of-unique-user/view-all-question-of-unique-user.component';
import { ViewAllAnswerForUniqueUsersQuestionsComponent } from './views/view-all-answer-for-unique-users-questions/view-all-answer-for-unique-users-questions.component';
import { MgnageUsersUniqueAnswersComponent } from './views/mgnage-users-unique-answers/mgnage-users-unique-answers.component';
import { UpdateYourAnswersComponent } from './views/update-your-answers/update-your-answers.component';
import { ViewAllAnswersForCheckComponent } from './views/view-all-answers-for-check/view-all-answers-for-check.component';
import { UpdateAfterCheckAnswerComponent } from './views/update-after-check-answer/update-after-check-answer.component';
import { ViewAllUsersComponent } from './views/view-all-users/view-all-users.component';
import { LogOutByUserProfileComponent } from './views/log-out-by-user-profile/log-out-by-user-profile.component';
import { LogOutUserComponent } from './views/log-out-user/log-out-user.component';
import { LogOutAdminComponent } from './views/log-out-admin/log-out-admin.component';
import {QuestionsService} from "./service/questions.service";
import {QuestionsCatogoryService} from "./service/questions-catogory.service";
import {UserService} from "./service/user.service";
import {AnswerService} from "./service/answer.service";

@NgModule({
  declarations: [
    AppComponent,
    AdminDashboardComponent,
    HomeComponent,
    UserDashboardComponent,
    UserLoginComponent,
    AdminLoginComponent,
    CreateNewUserAccountComponent,
    MakeQuestionsCatogoryComponent,
    UpdateQuestionsCatogoryComponent,
    AllQuestionsCatogoryComponent,
    MakeQuestionsComponent,
    AllQuestionsComponent,
    GivAnswerComponent,
    VerifyLoginForManageProfileComponent,
    ManageProfileComponent,
    ManageUserPersonalDetailsComponent,
    ViewAllQuestionOfUniqueUserComponent,
    ViewAllAnswerForUniqueUsersQuestionsComponent,
    MgnageUsersUniqueAnswersComponent,
    UpdateYourAnswersComponent,
    ViewAllAnswersForCheckComponent,
    UpdateAfterCheckAnswerComponent,
    ViewAllUsersComponent,
    LogOutByUserProfileComponent,
    LogOutUserComponent,
    LogOutAdminComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule

  ],
  providers: [
    UserloginService,
    AdminService,
    QuestionsService,
    QuestionsCatogoryService,
    UserService,
    AnswerService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
