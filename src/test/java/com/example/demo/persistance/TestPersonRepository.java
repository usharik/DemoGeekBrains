package com.example.demo.persistance;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPersonRepository {

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private PersonRepository personRepository;

    @Before
    @After
    public void cleanRepository() {
        personRepository.deleteAll();
        assertEquals(0, personRepository.count());
    }

    @Test
    public void testNewPersonCreate() throws ParseException {
        Person person = new Person();
        person.setFullName("Ivan Ivanovich Ivanov");
        person.setDateOfBirth(dateFormat.parse("1980-04-23"));
        Person savedPerson = personRepository.save(person);
        assertNotNull(savedPerson.getId());

        Person personFromRepository = personRepository.findById(savedPerson.getId())
                .orElseThrow(() -> new IllegalStateException("Saved entity not found"));

        assertEquals(person.getFullName(), personFromRepository.getFullName());
        assertEquals(person.getDateOfBirth(), personFromRepository.getDateOfBirth());
    }
}
