package com.example.demo.persistance;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findByFullNameLike(String name);

    List<Person> findByDateOfBirthGreaterThan(LocalDateTime date);

}