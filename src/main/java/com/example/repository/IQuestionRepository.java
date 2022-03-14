package com.example.repository;

import com.example.model.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IQuestionRepository extends CrudRepository<Question, Integer> {

    @Query("SELECT q FROM Question q WHERE q.author.id = :authorid")
    List<Question> getAllQuestionsByAuthorId(@Param("authorid") Integer authorid);

}
