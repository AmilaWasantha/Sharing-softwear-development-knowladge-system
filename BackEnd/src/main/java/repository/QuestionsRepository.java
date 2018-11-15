package repository;

import lk.ijse.absd.entity.Questions;
import lk.ijse.absd.entity.QuestionsCatogory;
import lk.ijse.absd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface QuestionsRepository extends JpaRepository<Questions,Integer> {



    @Query("SELECT t FROM Questions t WHERE t.questionsCatogory=:questionsCatogory")
     List<Questions> getAll(@Param("questionsCatogory")QuestionsCatogory catogory);

    @Query("SELECT t FROM Questions t WHERE t.user=:byUser")
    List<Questions> getQustions(@Param("byUser")User user);

    @Query("SELECT t FROM Questions t WHERE t.user=:userNic AND t.questionsCatogory=:questionsCatogory")
    List<Questions> getQustionss(@Param("userNic")User user,@Param("questionsCatogory")QuestionsCatogory catogory);

//    @Query("DELETE  FROM Questions t WHERE t.eMail=:byUser")
//    void deleteUser(@Param("byUser")User user);

        }
