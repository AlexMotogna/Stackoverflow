package com.example.service;

import com.example.model.*;
import com.example.repository.IAnswerRepository;
import com.example.repository.IAnswerVoteRepository;
import com.example.repository.IQuestionRepository;
import com.example.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerService {

    @Autowired
    IAnswerRepository iAnswerRepository;

    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    IQuestionRepository iQuestionRepository;

    @Autowired
    IAnswerVoteRepository iAnswerVoteRepository;


    public List<Answer> getAllAnswers() {
        return (List<Answer>) iAnswerRepository.findAll();
    }

    public Answer getAnswerById(Integer id) {
        return iAnswerRepository.findById(id).orElse(null);
    }

    public List<Answer> getAllAnswersByQuestionId(Integer qid) {
        return iAnswerRepository.getAllAnswersByQuestionId(qid);
    }

    public String createAnswer(Integer authorid, Integer qid, Answer answer) {
        try {
            User user = iUserRepository.findById(authorid).orElse(null);
            Question question = iQuestionRepository.findById(qid).orElse(null);

            answer.setAuthor(user);
            answer.setQuestion(question);

            iAnswerRepository.save(answer);
            return "Creation success.";
        } catch (Exception e) {
            return "Creation failed.";
        }
    }

    public String updateAnswer(Answer answer) {
        try {
            Answer updatedAnswer = this.getAnswerById(answer.getId());

            updatedAnswer.setText(answer.getText());
            updatedAnswer.setScore(answer.getScore());

            iAnswerRepository.save(updatedAnswer);
            return "Update success.";
        } catch (Exception e) {
            return "Update failed.";
        }
    }

    public String deleteAnswer(Integer id) {
        try {
            iAnswerRepository.delete(this.getAnswerById(id));
            return "Delete success.";
        } catch (Exception e) {
            return "Delete failed.";
        }
    }

    public List<AnswerVote> getVotes(Integer id) {
        Answer answer = iAnswerRepository.findById(id).orElse(null);
        if (answer != null) {
            return answer.getVotes();
        } else {
            return new ArrayList<>();
        }
    }

    public String upvote(Integer aid, Integer userid, Boolean upvote) {
        Answer answer = iAnswerRepository.findById(aid).orElse(null);
        User user = iUserRepository.findById(userid).orElse(null);

        if (answer != null && user != null) {

            List<AnswerVote> answerVotes = (List<AnswerVote>) iAnswerVoteRepository.findAll();
            AnswerVote vote = answerVotes.stream()
                    .filter(v -> v.getId().getAid() == aid && v.getId().getUserid() == userid )
                    .findFirst().orElse(null);

            User answerAuthor = answer.getAuthor();

            int userPoints = 0, answerPoints = 0, authorPoints = 0;

            if (vote != null) {
                if (vote.getUpvote() == upvote) {
                    return "Already voted";
                } else {
                    if(upvote) {
                        authorPoints = 12;
                        answerPoints = 2;
                        userPoints = 1;
                    } else {
                        authorPoints = -12;
                        answerPoints = -2;
                        userPoints = -1;
                    }
                }
            } else {
                if(upvote) {
                    authorPoints = 10;
                    answerPoints = 1;
                } else {
                    authorPoints = -2;
                    answerPoints = -1;
                    userPoints = -1;
                }
            }

            answerAuthor.incrementScore(authorPoints);
            answer.incrementScore(answerPoints);
            user.incrementScore(userPoints);

            iUserRepository.save(user);
            iUserRepository.save(answerAuthor);
            iAnswerRepository.save(answer);

            AnswerVote newVote = new AnswerVote(
                    new AnswerVoteId(aid, userid),
                    answer,
                    user,
                    upvote
            );
            iAnswerVoteRepository.save(newVote);

            return "Success.";
        } else {
            return "Failed.";
        }
    }

}
