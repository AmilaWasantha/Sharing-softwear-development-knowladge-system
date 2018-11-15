package repository;

import lk.ijse.absd.entity.Answer;
import lk.ijse.absd.entity.Questions;
import lk.ijse.absd.entity.QuestionsCatogory;
import lk.ijse.absd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer,Integer> {

    @Query("SELECT t FROM Answer t WHERE t.questions=:questionsId")
    List<Answer> getAllAnswersByQuestionsId(@Param("questionsId")Questions questionss);

    @Query("SELECT t FROM Answer t WHERE t.user=:userNic AND t.questionsCatogoryname=:questionsCatogory")
    List<Answer>getAllAnswersUniqueUserNic(@Param("userNic") User user, @Param("questionsCatogory")String catogory);

    @Query("SELECT t FROM Answer t WHERE t.questionsCatogoryname=:questionsCatogoryName")
    List<Answer> getAllAnswersByQuestionsCatogoryName(@Param("questionsCatogoryName")String catogoryName);

}
