package com.restemail.Service;

import com.restemail.Entity.Email;
import com.restemail.Entity.User;
import com.restemail.Respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
     JavaMailSender javaMailSender;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .get();
    }

    @Override
    public String deleteUserById(Long id) {
        User user = userRepository.findById(id)
                .get();
        if (user.getUserId() != null) {
            userRepository.deleteById(id);
            return "Success";
        } else
            return "Id does not exist";
    }

    @Override
    public User updateUserById(Long id, User user) {
        User userBean = userRepository.findById(id)
                .get();
        if (Objects.nonNull(userBean.getFname()) && !userBean.getFname()
                .isEmpty()) {
            userBean.setFname(user.getFname());
        }
        if (Objects.nonNull(userBean.getLname()) && !userBean.getLname()
                .isEmpty()) {
            userBean.setLname(user.getLname());
        }
        if (Objects.nonNull(userBean.getEmailId()) && !userBean.getEmailId()
                .isEmpty()) {
            userBean.setEmailId(user.getEmailId());
        }
        return userRepository.save(userBean);
    }

    @Override
    public String sendEmailById(Long id, Email email) {
        User user = userRepository.findById(id)
                .get();
        if (!user.getEmailId()
                .isEmpty()) {
System.out.println(email.getTo());
                sendSimpleEmail(email.getTo(),email.getTo(), email.getSubject(),email.getBody());
                return "Email-Sent to"+email.getTo().toString();
        }
        else
            return "No email id found for the current user";
    }

    public void sendSimpleEmail(String to, String from, String sub, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom(from);
        message.setSubject(sub);
        message.setText(body);
        javaMailSender.send(message);

    }

}
