package com.example.controller;

import com.example.model.Answer;
import com.example.model.Question;
import com.example.model.User;
import com.example.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/answers")
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    @ResponseBody
    public List<Answer> getAllAnswers() {
        return answerService.getAllAnswers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get")
    @ResponseBody
    public Answer getAnswerById(@RequestParam(name = "id") Integer id) {
        return answerService.getAnswerById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAllFromQuestion")
    @ResponseBody
    public List<Answer> getAllAnswersByQuestionId(@RequestParam(name = "qid") Integer qid) {
        return answerService.getAllAnswersByQuestionId(qid);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    @ResponseBody
    public String createAnswer(@RequestParam(name = "authorid") Integer authorid, @RequestParam(name = "qid") Integer qid, @RequestBody Answer answer) {
        return answerService.createAnswer(authorid, qid, answer);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    @ResponseBody
    public String updateAnswer(@RequestBody Answer answer) {
        return answerService.updateAnswer(answer);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    @ResponseBody
    public String deleteAnswer(@RequestParam(name = "id") Integer id) {
        return answerService.deleteAnswer(id);
    }

}
