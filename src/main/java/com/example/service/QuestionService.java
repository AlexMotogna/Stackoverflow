package com.example.service;

import com.example.model.Question;
import com.example.model.User;
import com.example.repository.IQuestionRepository;
import com.example.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    IQuestionRepository iQuestionRepository;

    @Autowired
    IUserRepository iUserRepository;

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

    public Question getQuestionById(Integer id) {
        return iQuestionRepository.findById(id).orElse(null);
    }


}
