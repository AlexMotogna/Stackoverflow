package com.example.repository;

import com.example.model.Question;
import org.springframework.data.repository.CrudRepository;

public interface IQuestionRepository extends CrudRepository<Question, Integer> {
}
