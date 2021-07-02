package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.enums.ERole;
import com.example.demo.exceptions.UserExistException;
import com.example.demo.payload.request.SignupRequest;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JWTAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public static final Logger LOG = LoggerFactory.getLogger(JWTAuthenticationFilter.class);

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public User createUser(SignupRequest userIn){
        User user = new User();
        user.setName(userIn.getFirstname());
        user.setEmail(userIn.getEmail());
        user.setLastname(userIn.getLastname());
        user.setUsername(userIn.getUsername());
        user.setPassword(passwordEncoder.encode(userIn.getPassword()));
        user.getRole().add(ERole.ROLE_USER);

        try{
            LOG.info("Saving User {}", userIn.getEmail());
            return userRepository.save(user);
        }catch (Exception e){
            LOG.error("Error during registration. {} ", e.getMessage());
            throw  new UserExistException("The user "+ user.getUsername() + "already exists. Please check credentials");
        }

    }
}
