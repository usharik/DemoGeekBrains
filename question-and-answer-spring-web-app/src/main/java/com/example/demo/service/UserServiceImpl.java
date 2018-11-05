package com.example.demo.service;

import com.example.demo.persistance.User;
import com.example.demo.persistance.UserRepository;
import com.example.demo.representation.SubmittedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void createNewUser(SubmittedUser submittedUser) {
        if (userRepository.existsByUsername(submittedUser.getUsername())) {
            throw new UsernameAlreadyExistsException();
        }
        User user = new User();
        user.setDateOfBirth(submittedUser.getDateOfBirth());
        user.setUsername(submittedUser.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(submittedUser.getPassword()));
        user.setFullName(submittedUser.getFullName());
        user.setDateOfBirth(submittedUser.getDateOfBirth());
        userRepository.save(user);
    }
}
