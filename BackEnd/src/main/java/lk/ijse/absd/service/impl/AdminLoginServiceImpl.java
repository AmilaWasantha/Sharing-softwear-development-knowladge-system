package lk.ijse.absd.service.impl;

import lk.ijse.absd.entity.AdminLogin;
import lk.ijse.absd.service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import repository.AdminLoginRepository;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AdminLoginServiceImpl implements AdminLoginService {

    @Autowired
    AdminLoginRepository adminLoginRepository;

    @Override
    public boolean athunticateAdmin(String userName, String password) {
        boolean exist=adminLoginRepository.existsById(userName);
        if(!exist){
            return false;
        }

        AdminLogin adminLogin=adminLoginRepository.findById(userName).get();
        return adminLogin.getPassword().equals(password);
    }
}
