package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @Column(name = "creationtime")
    private Timestamp creationtime;

    @Column(name = "score")
    private Integer score;

    @JsonBackReference(value = "question-user")
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "authorid", referencedColumnName = "id")
    private User author;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "question_tag",
            joinColumns = { @JoinColumn(name = "qid") },
            inverseJoinColumns = { @JoinColumn(name = "tagid") }
    )
    private List<Tag> tags = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "question")
    private List<QuestionVote> votes = new ArrayList<>();

    public Question() {

    }

    public Question(Integer id, String title, String text, Timestamp creationtime, Integer score, User author, List<Answer> answers, List<Tag> tags, List<QuestionVote> votes) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.creationtime = creationtime;
        this.score = score;
        this.author = author;
        this.answers = answers;
        this.tags = tags;
        this.votes = votes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<QuestionVote> getVotes() {
        return votes;
    }

    public void setVotes(List<QuestionVote> votes) {
        this.votes = votes;
    }
}
