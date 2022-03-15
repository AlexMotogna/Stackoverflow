package com.example.repository;

import com.example.model.QuestionVote;
import org.springframework.data.repository.CrudRepository;

public interface IQuestionVoteRepository extends CrudRepository<QuestionVote, Integer> {
}
