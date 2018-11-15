package lk.ijse.absd.service.impl;

import lk.ijse.absd.dto.QuestionsCatogoryDTO;
import lk.ijse.absd.entity.QuestionsCatogory;
import lk.ijse.absd.service.QuestionsCatogoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import repository.QuestionsCatagoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class QuestionsCatagoryServiceImpl implements QuestionsCatogoryService {
    @Autowired
    private QuestionsCatagoryRepository questionsCatagoryRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveQuestionsCatogory(QuestionsCatogoryDTO questionsCatogoryDTO) {

        QuestionsCatogory questionsCatogory=new QuestionsCatogory();
        questionsCatogory.setCatogoryName(questionsCatogoryDTO.getCatogoryName());
        questionsCatogory.setDescription(questionsCatogoryDTO.getDescription());
        questionsCatagoryRepository.save(questionsCatogory);
        return true;
    }

    @Override
    public List<QuestionsCatogoryDTO> getAllQuestionsCatogoryDetails() {
        List<QuestionsCatogory>questionsCatogories=questionsCatagoryRepository.findAll();

        List<QuestionsCatogoryDTO>questionsCatogoryDTOS=new ArrayList<>();

        for (QuestionsCatogory questionsCatogory:questionsCatogories) {
            QuestionsCatogoryDTO questionsCatogoryDTO=new QuestionsCatogoryDTO();
            questionsCatogoryDTO.setCatogoryName(questionsCatogory.getCatogoryName());
            questionsCatogoryDTO.setDescription(questionsCatogory.getDescription());
            questionsCatogoryDTOS.add(questionsCatogoryDTO);
        }
        return questionsCatogoryDTOS;
    }

    @Override
    public QuestionsCatogoryDTO getQuestionsCatogories(String catogoryName) {
        QuestionsCatogory questionsCatogory=questionsCatagoryRepository.findById(catogoryName).get();
        QuestionsCatogoryDTO questionsCatogoryDTO=new QuestionsCatogoryDTO();
        questionsCatogoryDTO.setCatogoryName(questionsCatogory.getCatogoryName());
        questionsCatogoryDTO.setDescription(questionsCatogory.getDescription());
        return questionsCatogoryDTO;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean updateQuestionsCatogory(String questionsCatogoryName ,QuestionsCatogoryDTO questionsCatogoryDTO) {

        if(!questionsCatogoryDTO.getCatogoryName().equals(questionsCatogoryName)){
            throw new RuntimeException("Questions Catogory Name Mismatched");
        }

        QuestionsCatogory questionsCatogory=new QuestionsCatogory();
        questionsCatogory.setCatogoryName(questionsCatogoryDTO.getCatogoryName());
        questionsCatogory.setDescription(questionsCatogoryDTO.getDescription());

        if(questionsCatagoryRepository.existsById(questionsCatogoryName)){
            questionsCatagoryRepository.save(questionsCatogory);
        }else {
            throw new RuntimeException("This Catogory Name is dose not exit");
        }

        return true;




    }
}
