package lk.ijse.absd.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdminLogin {
    @Id
    private String userName;
    private String password;

    public AdminLogin() {
    }

    public AdminLogin(String userName, String password) {
        this.setUserName(userName);
        this.setPassword(password);
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminLogin{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
