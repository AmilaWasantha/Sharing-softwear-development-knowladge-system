package repository;

import lk.ijse.absd.entity.QuestionsCatogory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionsCatagoryRepository extends JpaRepository<QuestionsCatogory,String> {

//    @Query("select '*' from questionscatogory")
////    List<QuestionsCatogory>getAll();


//    @Query("SELECT t FROM QuestionsCatogory t WHERE t.catogoryName = 'Spring'")
//    public List<QuestionsCatogory> getAll();


}