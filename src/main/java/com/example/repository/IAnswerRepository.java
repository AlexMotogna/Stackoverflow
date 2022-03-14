package com.example.repository;

import com.example.model.Answer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAnswerRepository extends CrudRepository<Answer, Integer> {

    @Query("SELECT a FROM Answer a WHERE a.question.id = :qid")
    List<Answer> getAllAnswersByQuestionId(@Param("qid") Integer qid);

}
