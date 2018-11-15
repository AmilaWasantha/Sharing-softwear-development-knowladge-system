package repository;

import lk.ijse.absd.entity.Questions;
import lk.ijse.absd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository  extends JpaRepository<User, String> {

    @Query("DELETE  FROM User t WHERE t.eMail=:byUser")
    void deleteUser(@Param("byUser")User user);
}
