package lk.ijse.absd.service;

import lk.ijse.absd.dto.UserLoginDTO;

public interface UserLoginService {
    public boolean saveUser(UserLoginDTO userLoginDTO);
    public boolean canAthunticate(String userName,String nic,String email, String password);
    public boolean canAthunticateForManageProfile(String userName,String nic,String password);
}
