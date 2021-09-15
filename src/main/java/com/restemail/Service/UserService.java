package com.restemail.Service;

import com.restemail.Entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User saveUser(User user);
}
