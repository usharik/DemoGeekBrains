package com.example.demo.service.security;

import com.example.demo.persistance.User;

public interface AuthenticationService {

    User getCurrentUser();

    boolean isLoggedIn();

    void autoLogin(String username, String password);
}
