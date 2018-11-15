package lk.ijse.absd.service.impl;

import lk.ijse.absd.dto.UserDTO;
import lk.ijse.absd.entity.User;
import lk.ijse.absd.entity.UserLogin;
import lk.ijse.absd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import repository.UserLoginRepository;
import repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    UserLoginRepository userLoginRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveUsers(UserDTO userDTO) {

        UserLogin userLogin=new UserLogin();
        userLogin.setNic(userDTO.getNic());
        userLogin.setEmail(userDTO.geteMail());
        userLogin.setUserName(userDTO.getName());
        userLogin.setPassword(userDTO.getPassword());

        User user=new User();
        user.setNic(userDTO.getNic());
        user.setName(userDTO.getName());
        user.setAddress(userDTO.getAddress());
        user.seteMail(userDTO.geteMail());
        user.setTel(userDTO.getTel());
        user.setPassword(userDTO.getPassword());

        userRepository.save(user);
        userLoginRepository.save(userLogin);
        return true;


    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean updateUsers(UserDTO userDTO) {

        User user=new User();
        user.setNic(userDTO.getNic());
        user.seteMail(userDTO.geteMail());
        user.setAddress(userDTO.getAddress());
        user.setName(userDTO.getName());
        user.setTel(userDTO.getTel());
        user.setPassword(userDTO.getPassword());

        UserLogin userLogin=new UserLogin();
        userLogin.setNic(userDTO.getNic());
        userLogin.setEmail(userDTO.geteMail());
        userLogin.setUserName(userDTO.getName());
        userLogin.setPassword(userDTO.getPassword());

        if(userRepository.existsById(user.getNic())){
            userRepository.save(user);
        }

        if(userLoginRepository.existsById(userLogin.getNic())){
            userLoginRepository.save(userLogin);
        }
        return true;
    }



    @Override
    public UserDTO finduser(UserDTO userDTO) {
        User user=userRepository.findById(userDTO.getNic()).get();
        UserDTO userDTO1=new UserDTO();
        userDTO1.setNic(user.getNic());
        userDTO1.setTel(user.getTel());
        userDTO1.setPassword(user.getPassword());
        userDTO1.setAddress(user.getAddress());
        userDTO1.seteMail(user.geteMail());
        userDTO1.setName(user.getName());

        return userDTO1;
    }

    @Override
    public boolean deleteUser(UserDTO userDTO) {
        User user=new User();
        user.seteMail(userDTO.geteMail());

        userRepository.deleteUser(user);
        return true;
    }

    @Override
    public UserDTO finduserByNic(String userNic) {

        User user=userRepository.findById(userNic).get();
        UserDTO userDTO=new UserDTO();
        userDTO.setNic(user.getNic());
        userDTO.seteMail(user.geteMail());
        userDTO.setAddress(user.getAddress());
        userDTO.setName(user.getName());
        userDTO.setPassword(user.getPassword());
        userDTO.setTel(user.getTel());

        return userDTO;
    }

    @Override
    public List<UserDTO> getAllUers() {
        List<User>users=userRepository.findAll();

        List<UserDTO>userDTOS=new ArrayList<>();

        for (User user:users) {

            UserDTO userDTO=new UserDTO();
            userDTO.setNic(user.getNic());
            userDTO.setTel(user.getTel());
            userDTO.setAddress(user.getAddress());
            userDTO.setName(user.getName());
            userDTO.setPassword(user.getPassword());
            userDTO.seteMail(user.geteMail());

            userDTOS.add(userDTO);
        }
        return userDTOS;
    }
}
