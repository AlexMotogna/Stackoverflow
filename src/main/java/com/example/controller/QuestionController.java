package com.example.controller;

import com.example.model.Question;
import com.example.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    @ResponseBody
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get")
    @ResponseBody
    public Question getQuestionById(@RequestParam(name = "id") Integer id) {
        return questionService.getQuestionById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create/{authorid}")
    @ResponseBody
    public String createQuestion(@PathVariable Integer authorid, @RequestBody Question question) {
        return questionService.createQuestion(authorid, question);
    }

}
