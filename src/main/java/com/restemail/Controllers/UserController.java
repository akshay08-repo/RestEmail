package com.restemail.Controllers;

import com.restemail.Entity.User;
import com.restemail.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/")
    public String defaultPath(){
        return "Welcome Here";
    }
    @PostMapping(path= "/User")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
}
