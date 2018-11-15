package lk.ijse.absd.controller;

import lk.ijse.absd.dto.QuestionsCatogoryDTO;
import lk.ijse.absd.dto.QuestionsDTO;
import lk.ijse.absd.dto.UserDTO;
import lk.ijse.absd.entity.QuestionsCatogory;
import lk.ijse.absd.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.awt.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/questions")
public class QuestionsController {

    @Autowired
    private QuestionsService questionsService;

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveQuestions(@RequestBody QuestionsDTO questionsDTO){
        return questionsService.saveQuestions(questionsDTO);
    }

    @GetMapping(value ="mno/{questionsCatogory}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<QuestionsDTO>getAll(@PathVariable("questionsCatogory")String catogoryName){
        QuestionsCatogoryDTO questionsCatogory=new QuestionsCatogoryDTO();
        questionsCatogory.setCatogoryName(catogoryName);
       return questionsService.findAllByQuestionsCatogoryName(questionsCatogory);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public QuestionsDTO getQuestionsDetailsById(@PathVariable("id") int questionId){
        return questionsService.findQuestionsDetailsById(questionId);
    }


    @GetMapping(value ="mno/mnoo/{byUser}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<QuestionsDTO>getAllQuestionsByUserId(@PathVariable("byUser")String userNic){
        UserDTO userDTO=new UserDTO();
        userDTO.setNic(userNic);
        return questionsService.findQuestionsDetails(userDTO);
    }

    @GetMapping(value ="amila/{byUser}", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteUser(@PathVariable("byUser")String userNic){
        UserDTO userDTO=new UserDTO();
        userDTO.seteMail(userNic);
        return questionsService.deleteUser(userDTO);
    }

    @GetMapping(value ="mno/objectKey/{userNic}/{questionsCatogory}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<QuestionsDTO>getAllUserQuestions(@PathVariable("userNic")String userNic, @PathVariable("questionsCatogory")String catogoryName){
        QuestionsCatogoryDTO questionsCatogory=new QuestionsCatogoryDTO();
        questionsCatogory.setCatogoryName(catogoryName);

        UserDTO userDTO=new UserDTO();
        userDTO.setNic(userNic);
        return questionsService.findAllQuestionsByCatogoryNameAndUserNic(userDTO,questionsCatogory);
    }




}
