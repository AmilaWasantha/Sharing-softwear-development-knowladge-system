package lk.ijse.absd.dto;

public class UserLoginDTO {
    private String nic;
    private String email;
    private String userName;
    private String password;

    public UserLoginDTO() {
    }

    public UserLoginDTO(String nic, String email, String userName, String password) {
        this.setNic(nic);
        this.setEmail(email);
        this.setUserName(userName);
        this.setPassword(password);
    }


    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return "UserLoginDTO{" +
                "nic='" + nic + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
