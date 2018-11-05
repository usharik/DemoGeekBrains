package com.example.demo.persistance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@SpringBootTest
public class TestUserRepository {

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testNewUserCreate() throws ParseException {
        User user = new User();
        user.setFullName("Ivan Ivanovich Ivanov");
        user.setUsername("User1");
        user.setPassword("password1");
        user.setDateOfBirth(dateFormat.parse("1980-04-23"));
        User savedUser = userRepository.save(user);
        assertNotNull(savedUser.getId());

        User userFromRepository = userRepository.findById(savedUser.getId())
                .orElseThrow(() -> new IllegalStateException("Saved entity not found"));

        assertEquals(user.getFullName(), userFromRepository.getFullName());
        assertEquals(user.getDateOfBirth(), userFromRepository.getDateOfBirth());
    }
}
