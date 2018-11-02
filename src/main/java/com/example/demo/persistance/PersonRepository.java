package com.example.demo.persistance;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    Optional<Person> findByFullName(String name);

    List<Person> findByDateOfBirthGreaterThan(LocalDateTime date);

    Boolean existsByFullName(String fullName);

}