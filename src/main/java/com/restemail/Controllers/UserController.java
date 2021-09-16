package com.restemail.Controllers;

import com.restemail.Entity.Email;
import com.restemail.Entity.User;
import com.restemail.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping(path = "/User")
    public List<User> getUser(){
        return userService.getUser();
    }
    @GetMapping(path = "/User/{id}")
    public User getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }
    @DeleteMapping(path="/DeleteUser/{id}")
    public String deleteUserById(@PathVariable("id") Long id){
        return userService.deleteUserById(id);
    }
    @PutMapping(path= "/UpdateUser/{id}")
    public User updateUserById(@PathVariable("id")Long id,@RequestBody User user){
        return userService.updateUserById(id,user);
    }
    @PostMapping(path="/SendEmail/{id}")
    public String sendEmailById(@PathVariable("id") Long id, @RequestBody Email email){
        return userService.sendEmailById(id,email);
    }
}
