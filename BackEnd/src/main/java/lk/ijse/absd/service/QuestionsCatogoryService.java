package lk.ijse.absd.service;

import lk.ijse.absd.dto.QuestionsCatogoryDTO;

import java.util.List;

public interface QuestionsCatogoryService {

    public boolean saveQuestionsCatogory(QuestionsCatogoryDTO questionsCatogoryDTO);

    public List<QuestionsCatogoryDTO>getAllQuestionsCatogoryDetails();

    public QuestionsCatogoryDTO getQuestionsCatogories(String catogoryName);

    public boolean updateQuestionsCatogory(String questionsCatogoryName ,QuestionsCatogoryDTO questionsCatogoryDTO);
}
