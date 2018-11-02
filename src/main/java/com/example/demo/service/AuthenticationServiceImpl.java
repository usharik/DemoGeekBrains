package com.example.demo.service;

import com.example.demo.persistance.Person;
import com.example.demo.persistance.PersonRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final PersonRepository personRepository;

    public AuthenticationServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person getCurrentUser() {
        if (!personRepository.existsByFullName("Default User")) {
            personRepository.save(new Person("Default User", Date.valueOf(LocalDate.now())));
        }
        return personRepository.findByFullName("Default User").get();
    }
}
