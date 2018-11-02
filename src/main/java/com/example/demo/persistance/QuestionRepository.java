package com.example.demo.persistance;

import com.example.demo.representation.QuestionForList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {

    @Query("select distinct q from Question q left join fetch q.answers")
    List<Question> findAllQuestions();

    @Query("select new com.example.demo.representation.QuestionForList(q.id, q.header, q.creationDate, qa.id, qa.fullName, count(a.id)) " +
            " from Question q " +
            "inner join q.author qa " +
            " left join q.answers a " +
            "group by q.id, q.header, q.creationDate, qa.id, qa.fullName")
    List<QuestionForList> findAllQuestionsForList();

    @Query("select q from Question q left join fetch q.answers where q.id = :id")
    Optional<Question> findQuestionById(@Param("id") long id);
}
