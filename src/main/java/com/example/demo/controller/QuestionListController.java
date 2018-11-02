package com.example.demo.controller;

import com.example.demo.representation.SubmitedQuestion;
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

    @Autowired
    public QuestionListController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String questionList(Model model) {
        model.addAttribute("questions", questionService.findAllQuestionsForList());
        return "index";
    }

    @RequestMapping(value = "/newquestion", method = RequestMethod.GET)
    public String newQuestionForm(Model model) {
        model.addAttribute("submitedQuestion", new SubmitedQuestion());
        return "newquestion";
    }

    @RequestMapping(value = "/newquestion", method = RequestMethod.POST)
    public String submitNewQuestion(@ModelAttribute SubmitedQuestion submitedQuestion) {
        questionService.saveSubmittedQuestion(submitedQuestion);
        return "redirect:/";
    }
}
