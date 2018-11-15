package lk.ijse.absd.controller;

import lk.ijse.absd.dto.QuestionsDTO;
import lk.ijse.absd.dto.UserDTO;
import lk.ijse.absd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveUser(@RequestBody UserDTO userDTO){
        return userService.saveUsers(userDTO);

    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateUser(@RequestBody UserDTO userDTO){
        return userService.updateUsers(userDTO);
    }

    @PostMapping(value = "/amila",produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO searchUser(@RequestBody UserDTO userDTO){
        return userService.finduser(userDTO);
    }

    @DeleteMapping(value ="/{byUser}", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteUser(@PathVariable("byUser")String userNic){
        UserDTO userDTO=new UserDTO();
        userDTO.seteMail(userNic);
        return userService.deleteUser(userDTO);
    }

    @GetMapping(value = "/{nic}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO getUserDetailsByNic(@PathVariable("nic") String nic){
        return userService.finduserByNic(nic);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO>getAllUsers(){
        return this.userService.getAllUers();
    }
}
