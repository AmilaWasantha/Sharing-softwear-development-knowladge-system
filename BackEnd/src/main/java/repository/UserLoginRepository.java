package repository;

import lk.ijse.absd.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoginRepository  extends JpaRepository<UserLogin, String> {
}
