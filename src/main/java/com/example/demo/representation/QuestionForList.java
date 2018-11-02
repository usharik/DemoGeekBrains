package com.example.demo.representation;

import java.util.Date;

public class QuestionForList {

    private Long id;

    private String header;

    private Date creationDate;

    private Long authorId;

    private String authorName;

    private Long answerCount;

    public QuestionForList(Long id, String header, Date creationDate, Long authorId, String authorName, Long answerCount) {
        this.id = id;
        this.header = header;
        this.creationDate = creationDate;
        this.authorId = authorId;
        this.authorName = authorName;
        this.answerCount = answerCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Long getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(Long answerCount) {
        this.answerCount = answerCount;
    }
}
