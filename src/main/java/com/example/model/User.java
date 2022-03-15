package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "score")
    private Integer score;

    @Column(name = "admin")
    private Boolean admin;

    @Column(name = "banned")
    private Boolean banned;

    @OneToMany(mappedBy = "author")
    private List<Question> questions = new ArrayList<>();

    @OneToMany(mappedBy = "author")
    private List<Answer> answers = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<AnswerVote> answerVotes = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<AnswerVote> questionVotes = new ArrayList<>();

    public User() {

    }

    public User(Integer id, String username, String email, String password, Integer score, Boolean admin, Boolean banned, List<Question> questions, List<Answer> answers, List<AnswerVote> answerVotes, List<AnswerVote> questionVotes) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.score = score;
        this.admin = admin;
        this.banned = banned;
        this.questions = questions;
        this.answers = answers;
        this.answerVotes = answerVotes;
        this.questionVotes = questionVotes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Boolean getBanned() {
        return banned;
    }

    public void setBanned(Boolean banned) {
        this.banned = banned;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<AnswerVote> getAnswerVotes() {
        return answerVotes;
    }

    public void setAnswerVotes(List<AnswerVote> answerVotes) {
        this.answerVotes = answerVotes;
    }

    public List<AnswerVote> getQuestionVotes() {
        return questionVotes;
    }

    public void setQuestionVotes(List<AnswerVote> questionVotes) {
        this.questionVotes = questionVotes;
    }
}
