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

    @RequestMapping(method = RequestMethod.GET, value = "/getAllFromUser")
    @ResponseBody
    public List<Question> getAllQuestionsByAuthorId(@RequestParam(name = "authorid") Integer id) {
        return questionService.getAllQuestionsByAuthorId(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get")
    @ResponseBody
    public Question getQuestionById(@RequestParam(name = "id") Integer id) {
        return questionService.getQuestionById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    @ResponseBody
    public String createQuestion(@RequestParam(name = "authorid") Integer authorid, @RequestBody Question question) {
        return questionService.createQuestion(authorid, question);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    @ResponseBody
    public String updateQuestion(@RequestBody Question question) {
        return questionService.updateQuestion(question);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    @ResponseBody
    public String deleteQuestion(@RequestParam(name = "id") Integer id) {
        return questionService.deleteQuestion(id);
    }


}
