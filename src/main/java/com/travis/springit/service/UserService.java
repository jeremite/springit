package com.travis.springit.service;

import com.travis.springit.domain.User;
import com.travis.springit.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User user){
        return user;
    }
    public User save(User user){
        return userRepository.save(user);
    }

    @Transactional //save the try catch and rollback
    public void saveUsers(User... users){
        // begin transaction
        for(User user:users){
            logger.info("Saving Users: "+user.getEmail());
            userRepository.save(user);
        }
    }

/*    @Transactional(readOnly=true)
    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }*/
}
