package com.example.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class QuestionVoteId implements Serializable {

    @Column(name = "qid")
    private Integer qid;

    @Column(name = "userid")
    private Integer userid;

    public QuestionVoteId() {

    }

    public QuestionVoteId(Integer qid, Integer userid) {
        this.qid = qid;
        this.userid = userid;
    }

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
