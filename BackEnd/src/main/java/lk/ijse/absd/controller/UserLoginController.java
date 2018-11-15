package lk.ijse.absd.controller;


import lk.ijse.absd.dto.UserLoginDTO;
import lk.ijse.absd.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/userlogins")
public class UserLoginController {
    @Autowired
    private UserLoginService service;


//    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public boolean saveUser(@RequestBody UserLoginDTO userLoginDTO){
//        return service.saveUser(userLoginDTO);
//    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean canAuthonticate(@RequestBody UserLoginDTO userLoginDTO){
        return service.canAthunticate(userLoginDTO.getUserName(),userLoginDTO.getNic(),userLoginDTO.getEmail(),userLoginDTO.getPassword());
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean canAuthonticateForVerifyManageProfile(@RequestBody UserLoginDTO userLoginDTO){
        return service.canAthunticateForManageProfile(userLoginDTO.getUserName(),userLoginDTO.getNic(),userLoginDTO.getPassword());
    }


    @PutMapping(value = "/mno",produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean canAthunticateForLogOut(@RequestBody UserLoginDTO userLoginDTO){
        return service.canAthunticateForManageProfile(userLoginDTO.getUserName(),userLoginDTO.getNic(),userLoginDTO.getPassword());
    }

}
