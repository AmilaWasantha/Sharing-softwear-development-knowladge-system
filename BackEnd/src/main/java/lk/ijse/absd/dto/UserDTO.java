package lk.ijse.absd.dto;

public class UserDTO {
    private String nic;
    private String eMail;
    private String name;
    private String Address;
    private String tel;
    private String password;

    public UserDTO() {
    }

    public UserDTO(String nic, String eMail, String name, String address, String tel, String password) {
        this.setNic(nic);
        this.seteMail(eMail);
        this.setName(name);
        setAddress(address);
        this.setTel(tel);
        this.setPassword(password);
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "nic='" + nic + '\'' +
                ", eMail='" + eMail + '\'' +
                ", name='" + name + '\'' +
                ", Address='" + Address + '\'' +
                ", tel='" + tel + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
