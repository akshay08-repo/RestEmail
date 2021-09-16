package com.restemail.Service;

import com.restemail.Entity.Email;
import com.restemail.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public User saveUser(User user);

    List<User> getUser();

    User getUserById(Long id);

    String deleteUserById(Long id);

    User updateUserById(Long id, User user);

    String sendEmailById(Long id, Email email);
}
