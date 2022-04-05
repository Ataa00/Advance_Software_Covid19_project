package Advance.example.Advance.controllers;

import Advance.example.Advance.Model.User;
import Advance.example.Advance.servieces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
@RestController
@RequestMapping(path = "api/v1/user")
public class UserControllers {
    private final UserService userService;
    @Autowired
    public UserControllers(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @GetMapping("/ByUserName/{userName}")
    public User getUserByUserName(@PathVariable String userName){
        return userService.getUserByUserName(userName);
    }
    @PostMapping("/addUser")
    public void addUser(@RequestBody User user){
        userService.addUser(user);

    }
    @DeleteMapping("/delete/{userName}")
    void deleteByUserName(@PathVariable String userName){
        userService.deleteByUserName(userName);
    }
    @PutMapping("/update/{userName}")
    void updateByUserName(@PathVariable String userName,
                          @RequestParam (required = false) String firstName,
                          @RequestParam (required = false) String lastName,
                          @RequestParam (required = false) String email,
                          @RequestParam (required = false) String password,
                          @RequestParam (required = false) String userName1,
                          @RequestParam (required = false) Integer role){
        userService.updateUser(userName,firstName,lastName,email,password,userName1,role);

    }
}
