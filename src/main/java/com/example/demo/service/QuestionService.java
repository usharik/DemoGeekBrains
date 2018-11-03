package com.example.demo.service;

import com.example.demo.representation.QuestionForList;
import com.example.demo.representation.SubmittedQuestion;

import java.util.List;

public interface QuestionService {

    List<QuestionForList> findAllQuestionsForList();

    void saveSubmittedQuestion(SubmittedQuestion submittedQuestion);
}
