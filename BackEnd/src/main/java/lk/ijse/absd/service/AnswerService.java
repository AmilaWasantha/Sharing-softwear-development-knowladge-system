package lk.ijse.absd.service;

import lk.ijse.absd.dto.AnswerDTO;
import lk.ijse.absd.dto.QuestionsDTO;
import lk.ijse.absd.dto.UserDTO;

import java.util.List;

public interface AnswerService {
    public boolean saveAnswer(AnswerDTO answerDTO);
    public List<AnswerDTO>getAllAnswersByQuestionsId(QuestionsDTO questionsDTO);
    public List<AnswerDTO>getAllAnswersUniqueUserNic(UserDTO userDTO, String catogoryName);
    public AnswerDTO findAnswerByAnswerId(int answerId);
    public boolean updateAnswer(AnswerDTO answerDTO);
    public List<AnswerDTO>getAllAnswersByQuestionsCatogoryName(String catogoryName);


}
