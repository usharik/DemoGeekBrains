package com.example.demo.service;

import com.example.demo.persistance.User;
import com.example.demo.representation.SubmittedUser;

import java.util.Optional;

public interface UserService {

    Optional<User> findByUsername(String username);

    void createNewUser(SubmittedUser submittedUser);
}
