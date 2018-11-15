package lk.ijse.absd.dto;

public class AdminLoginDTO {
    private String userName;
    private String password;

    public AdminLoginDTO() {
    }

    public AdminLoginDTO(String userName, String password) {
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
        return "AdminLoginDTO{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
