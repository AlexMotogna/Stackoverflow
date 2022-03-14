package com.example.service;

import com.example.model.Answer;
import com.example.model.Question;
import com.example.model.User;
import com.example.repository.IAnswerRepository;
import com.example.repository.IQuestionRepository;
import com.example.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    @Autowired
    IAnswerRepository iAnswerRepository;

    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    IQuestionRepository iQuestionRepository;

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

}
