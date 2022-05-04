package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "text")
    private String text;

    @Column(name = "creationtime")
    private Timestamp creationtime;

    @Column(name = "score")
    private Integer score;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "authorid", referencedColumnName = "id")
    private User author;

    @JsonBackReference(value = "answer-question")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "qid", referencedColumnName = "id")
    private Question question;

    @OneToMany(mappedBy = "answer")
    private List<AnswerVote> votes = new ArrayList<>();

    public Answer() {

    }

    public Answer(Integer id, String text, Timestamp creationtime, Integer score, User author, Question question, List<AnswerVote> votes) {
        this.id = id;
        this.text = text;
        this.creationtime = creationtime;
        this.score = score;
        this.author = author;
        this.question = question;
        this.votes = votes;
    }

    public void incrementScore(int value) {
        this.score += value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Timestamp creationtime) {
        this.creationtime = creationtime;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<AnswerVote> getVotes() {
        return votes;
    }

    public void setVotes(List<AnswerVote> votes) {
        this.votes = votes;
    }

}
