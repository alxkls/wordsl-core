package com.alex.wordslcore.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usersl")
public class WordsLUser {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer Id;

    public WordsLUser(String originalLan, String translateLan, String userId) {
        this.originalLan = originalLan;
        this.translateLan = translateLan;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return
                "userId='" + userId + '\'' +
                ", originalLan='" + originalLan + '\'' +
                ", translateLan='" + translateLan + '\''
                ;
    }

    public WordsLUser() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getOriginalLan() {
        return originalLan;
    }

    public void setOriginalLan(String originalLan) {
        this.originalLan = originalLan;
    }

    public String getTranslateLan() {
        return translateLan;
    }

    public void setTranslateLan(String translateLan) {
        this.translateLan = translateLan;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private String originalLan;
    private String translateLan;
    private String userId;
}
