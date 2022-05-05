package com.example.controller;

import com.example.model.Answer;
import com.example.model.AnswerVote;
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

    @RequestMapping(method = RequestMethod.GET, value = "/getQuestion")
    @ResponseBody
    public Question getQuestion(@RequestParam(name = "id") Integer qid) {
        return answerService.getQuestionByAnswer(qid);
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

    @RequestMapping(method = RequestMethod.GET, value = "/votes")
    @ResponseBody
    public List<AnswerVote> getVotes(@RequestParam(name = "id") Integer id) {
        return answerService.getVotes(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/upvote")
    @ResponseBody
    public String voteAnswer(@RequestParam(name = "aid") Integer aid, @RequestParam(name = "userid") Integer userid, @RequestParam(name = "upvote") Boolean upvote) {
        return answerService.upvote(aid, userid, upvote);
    }

}
