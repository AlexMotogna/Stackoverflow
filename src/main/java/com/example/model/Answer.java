package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Timestamp;

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

    @JsonBackReference(value = "answer-user")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "authorid", referencedColumnName = "id")
    private User author;

    @JsonBackReference(value = "answer-question")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "qid", referencedColumnName = "id")
    private Question question;

    public Answer() {

    }

    public Answer(Integer id, String text, Timestamp creationtime, Integer score, User author, Question question) {
        this.id = id;
        this.text = text;
        this.creationtime = creationtime;
        this.score = score;
        this.author = author;
        this.question = question;
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
}
