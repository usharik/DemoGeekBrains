package com.example.demo.persistance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestQuestionRepository {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void test() {
        Person authorOfQuestion = personRepository.save(new Person("Author Of Question", dateOf(1985, 2, 23)));
        Person authorOfAnswer = personRepository.save(new Person("Author Of Answer", dateOf(1983, 9, 12)));

        Question expectedQuestion = new Question();
        expectedQuestion.setText("Text of test question. Asking about something?");
        expectedQuestion.setCreationDate(now());
        expectedQuestion.setAuthor(authorOfQuestion);

        expectedQuestion = questionRepository.save(expectedQuestion);

        List<Answer> answers = Arrays.asList(new Answer("First answer", now(), authorOfAnswer, expectedQuestion),
                new Answer("Second answer", now(), authorOfAnswer, expectedQuestion),
                new Answer("Third answer", now(), authorOfAnswer, expectedQuestion));

        answerRepository.saveAll(answers);

        assertNotNull(expectedQuestion);

        Question question = questionRepository.findQuestionById(expectedQuestion.getId())
                .orElseThrow(() -> new AssertionError("Can't get created question."));
        assertEquals(3, question.getAnswers().size());
    }

    private static Date now() {
        return Date.valueOf(LocalDate.now());
    }

    private static Date dateOf(int year, int month, int day) {
        return Date.valueOf(LocalDate.of(year, month, day));
    }
}
