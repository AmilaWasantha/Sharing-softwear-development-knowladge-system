package lk.ijse.absd.controller;

import lk.ijse.absd.dto.QuestionsCatogoryDTO;
import lk.ijse.absd.service.QuestionsCatogoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/qustionsCatogories")
public class QuestionsCatagoryController {

    @Autowired
    private QuestionsCatogoryService questionsCatogoryService;

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveQustionsCatagory(@RequestBody QuestionsCatogoryDTO questionsCatogoryDTO){
        return  questionsCatogoryService.saveQuestionsCatogory(questionsCatogoryDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<QuestionsCatogoryDTO>getAllQuestionCatogories(){
       return questionsCatogoryService.getAllQuestionsCatogoryDetails();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public QuestionsCatogoryDTO getQuestionsCatogories(@PathVariable("id")String questionsCatogoryName){
        return questionsCatogoryService.getQuestionsCatogories(questionsCatogoryName);
    }

    @PostMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateQuestionsCatogory(@PathVariable ("id") String questionCatogoryName, @RequestBody QuestionsCatogoryDTO questionsCatogoryDTO){
        return questionsCatogoryService.updateQuestionsCatogory(questionCatogoryName,questionsCatogoryDTO);
    }

}
