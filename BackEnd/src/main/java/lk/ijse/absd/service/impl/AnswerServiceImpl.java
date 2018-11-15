package lk.ijse.absd.service.impl;

import lk.ijse.absd.dto.AnswerDTO;
import lk.ijse.absd.dto.QuestionsDTO;
import lk.ijse.absd.dto.UserDTO;
import lk.ijse.absd.entity.Answer;
import lk.ijse.absd.entity.Questions;
import lk.ijse.absd.entity.User;
import lk.ijse.absd.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import repository.AnswerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveAnswer(AnswerDTO answerDTO) {

        Questions questions=new Questions();
        questions.setQuestionsId(answerDTO.getQuestionsDTO().getQuestionsId());

        User user=new User();
        user.setNic(answerDTO.getUserDTO().getNic());

        Answer answer=new Answer();
        answer.setQuestions(questions);
        answer.setUser(user);
        answer.setAnswerBy(answerDTO.getAnswerBy());
        answer.setQuestionsCatogoryname(answerDTO.getQuestionsCatogoryname());
        answer.setStatus(answerDTO.getStatus());
        answer.setQuestionsDescription(answerDTO.getQuestionsDescription());
        answer.setQuestionsBy(answerDTO.getQuestionsBy());
        answer.setAnswerDescription(answerDTO.getAnswerDescription());

        answerRepository.save(answer);
        return true;


    }

    @Override
    public List<AnswerDTO> getAllAnswersByQuestionsId(QuestionsDTO questionsDTO) {

        Questions questions=new Questions();
        questions.setQuestionsId(questionsDTO.getQuestionsId());

        List<Answer>getAllAnswersByQuestionsId=answerRepository.getAllAnswersByQuestionsId(questions);

        List<AnswerDTO>answerDTOS=new ArrayList<>();

        for (Answer answer:getAllAnswersByQuestionsId) {

            QuestionsDTO questionsDTO1=new QuestionsDTO();
            questionsDTO1.setQuestionsId(answer.getQuestions().getQuestionsId());

            UserDTO userDTO=new UserDTO();
            userDTO.setNic(answer.getUser().getNic());

            AnswerDTO answerDTO=new AnswerDTO();
            answerDTO.setQuestionsDTO(questionsDTO1);
            answerDTO.setUserDTO(userDTO);

            answerDTO.setAnswerId(answer.getAnswerId());
            answerDTO.setAnswerBy(answer.getAnswerBy());
            answerDTO.setAnswerDescription(answer.getAnswerDescription());
            answerDTO.setQuestionsBy(answer.getQuestionsBy());
            answerDTO.setQuestionsCatogoryname(answer.getQuestionsCatogoryname());
            answerDTO.setQuestionsDescription(answer.getQuestionsDescription());
            answerDTO.setStatus(answer.getStatus());
            answerDTOS.add(answerDTO);

        }
        return answerDTOS;
    }

    @Override
    public List<AnswerDTO> getAllAnswersUniqueUserNic(UserDTO userDTO, String catogoryName) {

        User user=new User();
        user.setNic(userDTO.getNic());

        List<Answer>answers=answerRepository.getAllAnswersUniqueUserNic(user,catogoryName);

        List<AnswerDTO>answerDTOS=new ArrayList<>();

        for (Answer answer:answers) {
            UserDTO userDTO1=new UserDTO();
            userDTO1.setNic(answer.getUser().getNic());

            QuestionsDTO questionsDTO=new QuestionsDTO();
            questionsDTO.setQuestionsId(answer.getQuestions().getQuestionsId());

            AnswerDTO answerDTO=new AnswerDTO();
            answerDTO.setAnswerId(answer.getAnswerId());
            answerDTO.setAnswerBy(answer.getAnswerBy());
            answerDTO.setAnswerDescription(answer.getAnswerDescription());
            answerDTO.setQuestionsBy(answer.getQuestionsBy());
            answerDTO.setQuestionsCatogoryname(answer.getQuestionsCatogoryname());
            answerDTO.setQuestionsDescription(answer.getQuestionsDescription());
            answerDTO.setStatus(answer.getStatus());
            answerDTO.setQuestionsDTO(questionsDTO);
            answerDTO.setUserDTO(userDTO1);

            answerDTOS.add(answerDTO);
        }

        return answerDTOS;
    }

    @Override
    public AnswerDTO findAnswerByAnswerId(int answerId) {

        Answer answer=answerRepository.findById(answerId).get();

        QuestionsDTO questionsDTO=new QuestionsDTO();
        questionsDTO.setQuestionsId(answer.getQuestions().getQuestionsId());

        UserDTO userDTO=new UserDTO();
        userDTO.setNic(answer.getUser().getNic());

        AnswerDTO answerDTO=new AnswerDTO();
        answerDTO.setAnswerId(answer.getAnswerId());
        answerDTO.setAnswerBy(answer.getAnswerBy());
        answerDTO.setAnswerDescription(answer.getAnswerDescription());
        answerDTO.setQuestionsBy(answer.getQuestionsBy());
        answerDTO.setQuestionsCatogoryname(answer.getQuestionsCatogoryname());
        answerDTO.setQuestionsDescription(answer.getQuestionsDescription());
        answerDTO.setStatus(answer.getStatus());
        answerDTO.setQuestionsDTO(questionsDTO);
        answerDTO.setUserDTO(userDTO);

        return answerDTO;

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean updateAnswer(AnswerDTO answerDTO) {

        User user=new User();
        user.setNic(answerDTO.getUserDTO().getNic());

        Questions questions=new Questions();
        questions.setQuestionsId(answerDTO.getQuestionsDTO().getQuestionsId());

        Answer answer=new Answer();
        answer.setAnswerId(answerDTO.getAnswerId());
        answer.setAnswerBy(answerDTO.getAnswerBy());
        answer.setAnswerDescription(answerDTO.getAnswerDescription());
        answer.setQuestionsBy(answerDTO.getQuestionsBy());
        answer.setQuestionsCatogoryname(answerDTO.getQuestionsCatogoryname());
        answer.setQuestionsDescription(answerDTO.getQuestionsDescription());
        answer.setStatus(answerDTO.getStatus());
        answer.setQuestions(questions);
        answer.setUser(user);

        if(answerRepository.existsById(answer.getAnswerId())){
            answerRepository.save(answer);

        }
        return true;
    }

    @Override
    public List<AnswerDTO> getAllAnswersByQuestionsCatogoryName(String catogoryName) {

        List<Answer>answers=answerRepository.getAllAnswersByQuestionsCatogoryName(catogoryName);

        List<AnswerDTO>answerDTOS=new ArrayList<>();

        for (Answer answer:answers) {

            QuestionsDTO questionsDTO=new QuestionsDTO();
            questionsDTO.setQuestionsId(answer.getQuestions().getQuestionsId());

            UserDTO userDTO=new UserDTO();
            userDTO.setNic(answer.getUser().getNic());

            AnswerDTO answerDTO=new AnswerDTO();
            answerDTO.setAnswerId(answer.getAnswerId());
            answerDTO.setAnswerBy(answer.getAnswerBy());
            answerDTO.setAnswerDescription(answer.getAnswerDescription());
            answerDTO.setQuestionsBy(answer.getQuestionsBy());
            answerDTO.setQuestionsCatogoryname(answer.getQuestionsCatogoryname());
            answerDTO.setQuestionsDescription(answer.getQuestionsDescription());
            answerDTO.setStatus(answer.getStatus());
            answerDTO.setQuestionsDTO(questionsDTO);
            answerDTO.setUserDTO(userDTO);
            answerDTOS.add(answerDTO);
        }
        return answerDTOS;


    }
}
