package com.example.service;

import com.example.model.*;
import com.example.repository.IQuestionRepository;
import com.example.repository.IQuestionVoteRepository;
import com.example.repository.ITagRepository;
import com.example.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    IQuestionRepository iQuestionRepository;

    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    ITagRepository iTagRepository;

    @Autowired
    IQuestionVoteRepository iQuestionVoteRepository;

    public String createQuestion(Integer authorid, Question question) {
        try {
            User user = iUserRepository.findById(authorid).orElse(null);
            question.setAuthor(user);
            iQuestionRepository.save(question);
            return "Creation success.";
        } catch (Exception e) {
            return "Creation failed.";
        }
    }

    public List<Question> getAllQuestions() {
        return (List<Question>) iQuestionRepository.findAll();
    }

    public List<Question> getAllQuestionsByAuthorId(Integer authorid) {
        return iQuestionRepository.getAllQuestionsByAuthorId(authorid);
    }

    public Question getQuestionById(Integer id) {
        return iQuestionRepository.findById(id).orElse(null);
    }

    public String updateQuestion(Question question) {
        try {
            Question updatedQuestion = this.getQuestionById(question.getId());

            updatedQuestion.setTitle(question.getTitle());
            updatedQuestion.setText(question.getText());
            updatedQuestion.setScore(question.getScore());

            iQuestionRepository.save(updatedQuestion);

            return "Update success.";
        } catch (Exception e) {
            return "Update failed.";
        }
    }

    public String deleteQuestion(Integer id) {
        try {
            iQuestionRepository.delete(this.getQuestionById(id));
            return "Delete success.";
        } catch (Exception e) {
            return "Delete failed.";
        }
    }

    public String addTag(Integer qid, Integer tagid) {
        try {
            Question question = this.getQuestionById(qid);
            Tag tag = iTagRepository.findById(tagid).orElse(null);

            question.getTags().add(tag);

            iQuestionRepository.save(question);
            return "Success.";
        } catch (Exception e) {
            return "Failed.";
        }
    }

    public String removeTag(Integer qid, Integer tagid) {
        try {
            Question question = this.getQuestionById(qid);
            Tag tag = iTagRepository.findById(tagid).orElse(null);

            question.getTags().remove(tag);

            iQuestionRepository.save(question);
            return "Success.";
        } catch (Exception e) {
            return "Failed.";
        }
    }

    public List<QuestionVote> getVotes(Integer id) {
        Question question = iQuestionRepository.findById(id).orElse(null);
        if (question != null) {
            return question.getVotes();
        } else {
            return new ArrayList<>();
        }
    }

    public String upvote(Integer qid, Integer userid, Boolean upvote) {
        Question question = iQuestionRepository.findById(qid).orElse(null);
        User user = iUserRepository.findById(userid).orElse(null);

        if (question != null && user != null) {

            QuestionVote newVote = new QuestionVote(
                    new QuestionVoteId(qid, userid),
                    question,
                    user,
                    upvote
            );

            //TODO: point reward

            iQuestionVoteRepository.save(newVote);

            return "Success.";
        } else {
            return "Failed.";
        }
    }

}
