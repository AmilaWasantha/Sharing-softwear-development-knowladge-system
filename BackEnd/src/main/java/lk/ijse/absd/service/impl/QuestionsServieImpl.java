package lk.ijse.absd.service.impl;

import lk.ijse.absd.dto.QuestionsCatogoryDTO;
import lk.ijse.absd.dto.QuestionsDTO;
import lk.ijse.absd.dto.UserDTO;
import lk.ijse.absd.entity.Questions;
import lk.ijse.absd.entity.QuestionsCatogory;
import lk.ijse.absd.entity.User;
import lk.ijse.absd.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import repository.QuestionsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class QuestionsServieImpl implements QuestionsService {

    @Autowired
    private QuestionsRepository questionsRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveQuestions(QuestionsDTO questionsDTO) {

        User user=new User();
        user.setNic(questionsDTO.getUserDTO().getNic());


        QuestionsCatogory questionsCatogory=new QuestionsCatogory();
        questionsCatogory.setCatogoryName(questionsDTO.getQuestionsCatogoryDTO().getCatogoryName());


        Questions questions=new Questions();
        questions.setDescription(questionsDTO.getDescription());
        questions.setUserName(questionsDTO.getUserName());
        questions.setQuestionsCatogory(questionsCatogory);
        questions.setUserEmail(questionsDTO.getUserEmail());
        questions.setUser(user);

        questionsRepository.save(questions);
        return true;


    }

    @Override
    public List<QuestionsDTO> findAllByQuestionsCatogoryName(QuestionsCatogoryDTO catogoryDTO) {

        QuestionsCatogory questionsCatogory=new QuestionsCatogory();
        questionsCatogory.setCatogoryName(catogoryDTO.getCatogoryName());

        List<Questions>questions=questionsRepository.getAll(questionsCatogory);
        System.out.println("fdddddddddddddddddddddddddddddddd"+questions);

        List<QuestionsDTO>questionsDTOS=new ArrayList<>();

        for (Questions questions1:questions) {

            UserDTO userDTO=new UserDTO();
            userDTO.setNic(questions1.getUser().getNic());

            QuestionsCatogoryDTO questionsCatogoryDTO=new QuestionsCatogoryDTO();
            questionsCatogoryDTO.setCatogoryName(questions1.getQuestionsCatogory().getCatogoryName());

            QuestionsDTO questionsDTO=new QuestionsDTO();
            questionsDTO.setQuestionsId(questions1.getQuestionsId());
            questionsDTO.setDescription(questions1.getDescription());
            questionsDTO.setUserName(questions1.getUserName());
            questionsDTO.setUserEmail(questions1.getUserEmail());
            questionsDTO.setUserDTO(userDTO);
            questionsDTO.setQuestionsCatogoryDTO(questionsCatogoryDTO);
            questionsDTOS.add(questionsDTO);

        }
        return questionsDTOS;

    }

    @Override
    public QuestionsDTO findQuestionsDetailsById(int id) {
        Questions questions=questionsRepository.findById(id).get();

        UserDTO userDTO=new UserDTO();
        userDTO.setNic(questions.getUser().getNic());

        QuestionsCatogoryDTO questionsCatogoryDTO=new QuestionsCatogoryDTO();
        questionsCatogoryDTO.setCatogoryName(questions.getQuestionsCatogory().getCatogoryName());

        QuestionsDTO questionsDTO=new QuestionsDTO();
        questionsDTO.setQuestionsId(questions.getQuestionsId());
        questionsDTO.setDescription(questions.getDescription());
        questionsDTO.setUserName(questions.getUserName());
        questionsDTO.setUserEmail(questions.getUserEmail());
        questionsDTO.setUserDTO(userDTO);
        questionsDTO.setQuestionsCatogoryDTO(questionsCatogoryDTO);

        return questionsDTO;

    }

    @Override
    public List<QuestionsDTO> findQuestionsDetails(UserDTO userDTO) {
        User user=new User();
        user.setNic(userDTO.getNic());

        List<Questions>questions=questionsRepository.getQustions(user);

        List<QuestionsDTO>questionsDTOS=new ArrayList<>();

        for (Questions questions1:questions) {
            UserDTO userDTO1=new UserDTO();
            userDTO.seteMail(questions1.getUser().geteMail());
            QuestionsDTO questionsDTO=new QuestionsDTO();
            questionsDTO.setUserDTO(userDTO);

            questionsDTOS.add(questionsDTO);


        }
        return questionsDTOS;
    }

    @Override
    public boolean deleteUser(UserDTO userDTO) {
        User user=new User();
        user.seteMail(userDTO.geteMail());

//        questionsRepository.deleteUser(user);
        return true;
    }

    @Override
    public List<QuestionsDTO> findAllQuestionsByCatogoryNameAndUserNic( UserDTO userDTO,QuestionsCatogoryDTO catogoryDTO) {

        User user=new User();
        user.setNic(userDTO.getNic());

        QuestionsCatogory questionsCatogory=new QuestionsCatogory();
        questionsCatogory.setCatogoryName(catogoryDTO.getCatogoryName());

        List<Questions>getQuestionsDetailsUniqUser=questionsRepository.getQustionss(user,questionsCatogory);

        List<QuestionsDTO>questionsDTOS=new ArrayList<>();

        for (Questions questions:getQuestionsDetailsUniqUser) {
            UserDTO userDTO1=new UserDTO();
            userDTO1.setNic(questions.getUser().getNic());

            QuestionsCatogoryDTO questionsCatogoryDTO=new QuestionsCatogoryDTO();
            questionsCatogoryDTO.setCatogoryName(questions.getQuestionsCatogory().getCatogoryName());

            QuestionsDTO questionsDTO=new QuestionsDTO();
            questionsDTO.setUserDTO(userDTO1);
            questionsDTO.setQuestionsCatogoryDTO(questionsCatogoryDTO);
            questionsDTO.setQuestionsId(questions.getQuestionsId());
            questionsDTO.setDescription(questions.getDescription());
            questionsDTO.setUserEmail(questions.getUserEmail());
            questionsDTO.setUserName(questions.getUserName());


            questionsDTOS.add(questionsDTO);
        }

        return questionsDTOS;
    }
}
