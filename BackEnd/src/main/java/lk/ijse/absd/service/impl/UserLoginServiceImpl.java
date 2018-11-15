package lk.ijse.absd.service.impl;

import lk.ijse.absd.dto.UserLoginDTO;
import lk.ijse.absd.entity.UserLogin;
import lk.ijse.absd.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import repository.UserLoginRepository;


@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserLoginServiceImpl implements UserLoginService {


    @Autowired
    UserLoginRepository userLoginRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean saveUser(UserLoginDTO userLoginDTO) {
        UserLogin userLogin=new UserLogin();
        userLogin.setUserName(userLoginDTO.getUserName());

        userLogin.setPassword(userLoginDTO.getPassword());


        userLoginRepository.save(userLogin);
        return true;
    }

    @Override
    public boolean canAthunticate(String userName,String nic,String email, String password) {
        boolean exists=userLoginRepository.existsById(nic);

        if(!exists){
            return false;
        }

        UserLogin userLogin=userLoginRepository.findById(nic).get();
        return  userLogin.getPassword().equals(password) && userLogin.getEmail().equals(email) && userLogin.getUserName().equals(userName);
    }

    @Override
    public boolean canAthunticateForManageProfile(String userName, String nic, String password) {

        boolean exists=userLoginRepository.existsById(nic);
        if(!exists){
            return false;
        }

        UserLogin userLogin=userLoginRepository.findById(nic).get();
        return userLogin.getUserName().equals(userName)&& userLogin.getPassword().equals(password);
    }
}
