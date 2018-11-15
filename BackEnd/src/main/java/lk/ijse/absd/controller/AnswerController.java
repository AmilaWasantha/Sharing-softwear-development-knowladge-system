package lk.ijse.absd.controller;

import lk.ijse.absd.dto.AnswerDTO;
import lk.ijse.absd.dto.QuestionsCatogoryDTO;
import lk.ijse.absd.dto.QuestionsDTO;
import lk.ijse.absd.dto.UserDTO;
import lk.ijse.absd.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/answers")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveAnswer(@RequestBody AnswerDTO answerDTO){
       return answerService.saveAnswer(answerDTO);
    }


    @GetMapping(value ="mno/{questionsId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AnswerDTO> getAllAnswersByQuestionsId(@PathVariable("questionsId")int  questionsId){
        QuestionsDTO questionsDTO=new QuestionsDTO();
        questionsDTO.setQuestionsId(questionsId);
        return answerService.getAllAnswersByQuestionsId(questionsDTO);
    }

    @GetMapping(value ="mno/objectKey/{userNic}/{questionsCatogory}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AnswerDTO>getAllAnswersUiqueUsers(@PathVariable("userNic")String userNic, @PathVariable("questionsCatogory")String catogoryName){

        UserDTO userDTO=new UserDTO();
        userDTO.setNic(userNic);
        return answerService.getAllAnswersUniqueUserNic(userDTO,catogoryName);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AnswerDTO getAnswerByAnswerId(@PathVariable("id")int answerId){
        return answerService.findAnswerByAnswerId(answerId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateAnswer(@RequestBody AnswerDTO answerDTO){
        return answerService.updateAnswer(answerDTO);
    }


    @GetMapping(value = "catogoryName/{questionsCatogoryName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AnswerDTO>getAllAnswersByQuestionsCatogoryName(@PathVariable("questionsCatogoryName")String catogoryName){
        return answerService.getAllAnswersByQuestionsCatogoryName(catogoryName);
    }

}
