package com.example.repository;

import com.example.model.AnswerVote;
import com.example.model.Question;
import org.springframework.data.repository.CrudRepository;

public interface IAnswerVoteRepository extends CrudRepository<AnswerVote, Integer> {
}
