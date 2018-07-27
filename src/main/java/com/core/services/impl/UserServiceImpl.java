package com.core.services.impl;

import com.core.entity.User;
import com.core.repositories.UserRepository;
import com.core.services.UserService;
import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final static Logger logger = Logger.getLogger(UserServiceImpl.class);

    private static final String SUBJECT_MAIL_REGISTRATION_CONFIRMATION = "Registration Confirmation";

    private static final String CHARSET_UTF8 = "UTF-8";

    @Autowired
    private VelocityEngine velocityEngine;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @PostConstruct
    private void createUsers(){
        for(int i = 0; i < 10; i++){
            User user = new User();
            user.setEmail("email"+i+"@g.com");
            user.setName("Name" + i);
            user.setPassword("Password" + i);
            userRepository.save(user);
        }
        logger.info("Count of users in data base: " + userRepository.findAll().size());
    }
}
