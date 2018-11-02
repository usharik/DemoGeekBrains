package com.example.demo.service;

import com.example.demo.representation.QuestionForList;
import com.example.demo.representation.SubmitedQuestion;

import java.util.List;

public interface QuestionService {

    List<QuestionForList> findAllQuestionsForList();

    void saveSubmittedQuestion(SubmitedQuestion submitedQuestion);
}
