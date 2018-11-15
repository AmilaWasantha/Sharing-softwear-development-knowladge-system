package lk.ijse.absd.controller;

import lk.ijse.absd.dto.AdminLoginDTO;
import lk.ijse.absd.service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/adminLogins")
public class AdminController {

    @Autowired
    AdminLoginService adminLoginService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean canAthunticate(@RequestBody AdminLoginDTO adminLoginDTO){
        return  adminLoginService.athunticateAdmin(adminLoginDTO.getUserName(),adminLoginDTO.getPassword());
    }
}
