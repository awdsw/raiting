package com.example.security1.entity;

import javax.persistence.*;
import java.util.Date;

/**Связывание вопроса и пользователя связующая таблица, которая хранит Id*/
@Entity
public class UserQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //связь с пользователем
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_Id", nullable = false)
    private AppUser appUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AppQuestion_Id", nullable = false)
    private AppQuestion appQuestion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Worker_Id", nullable = false)
    private AppUser workerId;

    //указыватся дата вопроса
    private Date dateOfRequest;

    //ответили на вопрос или нет, по умолчание false
    private Boolean isAnswered;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public AppQuestion getAppQuestion() {
        return appQuestion;
    }

    public void setAppQuestion(AppQuestion appQuestion) {
        this.appQuestion = appQuestion;
    }

    public Date getDateOfRequest() {
        return dateOfRequest;
    }

    public void setDateOfRequest(Date dateOfRequest) {
        this.dateOfRequest = dateOfRequest;
    }

    public Boolean getAnswered() {
        return isAnswered;
    }

    public void setAnswered(Boolean answered) {
        isAnswered = answered;
    }

    public AppUser getWorkerId() {
        return workerId;
    }

    public void setWorkerId(AppUser workerId) {
        this.workerId = workerId;
    }

    public UserQuestion() { }

    public UserQuestion(AppUser appUser, AppQuestion appQuestion, AppQuestion workerId, Date dateOfRequest, Boolean isAnswered) {
        this.appUser = appUser;
        this.appQuestion = appQuestion;
        this.workerId = null; //когда задаем вопрос, то он еще не отвечен
        this.dateOfRequest = dateOfRequest;
        this.isAnswered = isAnswered;
    }
}
