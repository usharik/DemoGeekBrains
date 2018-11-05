package com.example.demo.controller;

import com.example.demo.representation.SubmittedQuestion;
import com.example.demo.service.security.AuthenticationService;
import com.example.demo.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class QuestionListController {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionListController.class);

    private final QuestionService questionService;
    private final AuthenticationService authenticationService;

    @Autowired
    public QuestionListController(QuestionService questionService, AuthenticationService authenticationService) {
        this.questionService = questionService;
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String questionList(Model model) {
        model.addAttribute("questions", questionService.findAllQuestionsForList());
        model.addAttribute("user", authenticationService.getCurrentUser());
        return "index";
    }

    @RequestMapping(value = "/newquestion", method = RequestMethod.GET)
    public String newQuestionForm(Model model) {
        model.addAttribute("submittedQuestion", new SubmittedQuestion());
        model.addAttribute("user", authenticationService.getCurrentUser());
        return "newquestion";
    }

    @RequestMapping(value = "/newquestion", method = RequestMethod.POST)
    public String submitNewQuestion(@ModelAttribute SubmittedQuestion submittedQuestion) {
        questionService.saveSubmittedQuestion(submittedQuestion);
        return "redirect:/";
    }
}
