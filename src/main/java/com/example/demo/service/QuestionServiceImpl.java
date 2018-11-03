package com.example.demo.service;

import com.example.demo.persistance.Question;
import com.example.demo.persistance.QuestionRepository;
import com.example.demo.representation.QuestionForList;
import com.example.demo.representation.SubmittedQuestion;
import com.example.demo.service.security.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final AuthenticationService authenticationService;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository, AuthenticationService authenticationService) {
        this.questionRepository = questionRepository;
        this.authenticationService = authenticationService;
    }

    @Override
    public List<QuestionForList> findAllQuestionsForList() {
        return questionRepository.findAllQuestionsForList();
    }

    @Override
    public void saveSubmittedQuestion(SubmittedQuestion submittedQuestion) {
        Question question = new Question();
        question.setHeader(submittedQuestion.getHeader());
        question.setText(submittedQuestion.getText());
        question.setCreationDate(Date.valueOf(LocalDate.now()));
        question.setAuthor(authenticationService.getCurrentUser());
        questionRepository.save(question);
    }
}
