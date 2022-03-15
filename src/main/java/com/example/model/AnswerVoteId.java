package com.example.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AnswerVoteId implements Serializable {

    @Column(name = "aid")
    private Integer aid;

    @Column(name = "userid")
    private Integer userid;

    public AnswerVoteId() {

    }

    public AnswerVoteId(Integer aid, Integer userid) {
        this.aid = aid;
        this.userid = userid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
