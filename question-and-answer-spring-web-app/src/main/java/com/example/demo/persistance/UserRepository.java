package com.example.demo.persistance;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByFullName(String name);

    Optional<User> findByUsername(String name);

    Boolean existsByUsername(String username);

    List<User> findByDateOfBirthGreaterThan(LocalDateTime date);

    Boolean existsByFullName(String fullName);

}