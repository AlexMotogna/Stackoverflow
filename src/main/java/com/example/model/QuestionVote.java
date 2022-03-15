package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity(name = "QuestionVote")
@Table(name = "question_vote")
public class QuestionVote {

    @EmbeddedId
    private QuestionVoteId id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "qid", referencedColumnName = "id")
    @MapsId("qid")
    private Question question;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", referencedColumnName = "id")
    @MapsId("userid")
    private User user;

    @Column(name = "upvote")
    private Boolean upvote;

    public QuestionVote() {

    }

    public QuestionVote(QuestionVoteId id, Question question, User user, Boolean upvote) {
        this.id = id;
        this.question = question;
        this.user = user;
        this.upvote = upvote;
    }

    public QuestionVoteId getId() {
        return id;
    }

    public void setId(QuestionVoteId id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getUpvote() {
        return upvote;
    }

    public void setUpvote(Boolean upvote) {
        this.upvote = upvote;
    }
}
