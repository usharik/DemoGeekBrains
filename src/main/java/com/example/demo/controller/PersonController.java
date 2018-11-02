package com.example.demo.controller;

import com.example.demo.persistance.Person;
import com.example.demo.persistance.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/v1/person")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Person createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @RequestMapping(value = "/{id}/id", method = RequestMethod.GET)
    public ResponseEntity<Person> getPersonById(@PathVariable("id") long id) {
        return personRepository.findById(id)
                .map(person -> new ResponseEntity<>(person, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Person> getAll() {
        return StreamSupport.stream(personRepository.findAll().spliterator(), true)
                .collect(Collectors.toList());
    }

}
