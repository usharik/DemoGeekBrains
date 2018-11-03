package com.example.demo.persistance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "QUESTION")
public class Question {

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "Question_Header", length = 1024, nullable = false)
    private String header;

    @Column(name = "Question_Text", length = 1024, nullable = false)
    private String text;

    @Temporal(TemporalType.DATE)
    @Column(name = "Creation_Date", nullable = false)
    private Date creationDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "Update_Date")
    private Date updateDate;

    @OneToOne
    private User author;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    public Question() {

    }

    public Question(String header, String text, Date creationDate, User author) {
        this.header = header;
        this.text = text;
        this.creationDate = creationDate;
        this.author = author;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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
}
