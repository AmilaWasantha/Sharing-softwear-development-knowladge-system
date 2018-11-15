package lk.ijse.absd.service;

import lk.ijse.absd.dto.UserDTO;

import java.util.List;

public interface UserService {
    public boolean saveUsers(UserDTO userDTO);
    public boolean updateUsers(UserDTO userDTO);
    public UserDTO finduser(UserDTO userDTO);
    public boolean deleteUser(UserDTO userDTO);
    public UserDTO finduserByNic(String userNic);
    public List<UserDTO>getAllUers();
}
