package lk.ijse.absd.service;

import lk.ijse.absd.dto.QuestionsCatogoryDTO;
import lk.ijse.absd.dto.QuestionsDTO;
import lk.ijse.absd.dto.UserDTO;
import lk.ijse.absd.entity.Questions;
import lk.ijse.absd.entity.QuestionsCatogory;

import java.util.List;

public interface QuestionsService {
    public boolean saveQuestions(QuestionsDTO QuestionsDTO);
    public List<QuestionsDTO>findAllByQuestionsCatogoryName(QuestionsCatogoryDTO catogory);
    public QuestionsDTO findQuestionsDetailsById(int id);

    public List<QuestionsDTO> findQuestionsDetails(UserDTO userDTO);

    public boolean deleteUser(UserDTO userDTO);

    public List<QuestionsDTO>findAllQuestionsByCatogoryNameAndUserNic( UserDTO userDTO,QuestionsCatogoryDTO catogoryDTO);


}
