package com.example.demo.controller;

import com.example.demo.representation.SubmittedUser;
import com.example.demo.service.UserService;
import com.example.demo.service.UsernameAlreadyExistsException;
import com.example.demo.service.security.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;
    private final AuthenticationService authenticationService;

    @Autowired
    public UserController(UserService userService, AuthenticationService authenticationService) {
        this.userService = userService;
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registerNewUser(Model model) {
        model.addAttribute("submittedUser", new SubmittedUser());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registerNewUser(@ModelAttribute SubmittedUser submittedUser) {
        try {
            userService.createNewUser(submittedUser);
        } catch (UsernameAlreadyExistsException ex) {
            return buildResponseWithError(submittedUser,"Username already exists");
        } catch (Exception ex) {
            LOGGER.error("Exception", ex);
            return buildResponseWithError(submittedUser,"Unknown error");
        }
        authenticationService.autoLogin(submittedUser.getUsername(), submittedUser.getPassword());
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/login",  method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    private ModelAndView buildResponseWithError(SubmittedUser submittedUser, String errorMessage) {
        submittedUser.setPassword("");
        submittedUser.setError(true);
        submittedUser.setErrorMessage(errorMessage);
        return new ModelAndView("registration")
                .addObject("submittedUser", submittedUser);
    }

}
