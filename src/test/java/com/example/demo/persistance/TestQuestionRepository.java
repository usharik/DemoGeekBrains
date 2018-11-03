package com.example.demo.persistance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@SpringBootTest
public class TestQuestionRepository {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() {
        User authorOfQuestion = userRepository.save(new User("Author Of Question", "user1", "password1", dateOf(1985, 2, 23)));
        User authorOfAnswer = userRepository.save(new User("Author Of Answer", "user2", "password2", dateOf(1983, 9, 12)));

        Question expectedQuestion = new Question();
        expectedQuestion.setHeader("Question header");
        expectedQuestion.setText("Text of test question. Asking about something?");
        expectedQuestion.setCreationDate(now());
        expectedQuestion.setAuthor(authorOfQuestion);

        expectedQuestion = questionRepository.save(expectedQuestion);

        List<Answer> answers = Arrays.asList(new Answer("First answer", now(), authorOfAnswer, expectedQuestion),
                new Answer("Second answer", now(), authorOfAnswer, expectedQuestion),
                new Answer("Third answer", now(), authorOfAnswer, expectedQuestion));

        answerRepository.saveAll(answers);

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
