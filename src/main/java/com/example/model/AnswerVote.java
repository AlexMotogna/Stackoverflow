package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity(name = "AnswerVote")
@Table(name = "answer_vote")
public class AnswerVote {

    @EmbeddedId
    private AnswerVoteId id;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "aid", referencedColumnName = "id")
    @MapsId("aid")
    private Answer answer;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", referencedColumnName = "id")
    @MapsId("userid")
    private User user;

    @Column(name = "upvote")
    private Boolean upvote;

    public AnswerVote() {

    }

    public AnswerVote(AnswerVoteId id, Answer answer, User user, Boolean upvote) {
        this.id = id;
        this.answer = answer;
        this.user = user;
        this.upvote = upvote;
    }

    public AnswerVoteId getId() {
        return id;
    }

    public void setId(AnswerVoteId id) {
        this.id = id;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
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
