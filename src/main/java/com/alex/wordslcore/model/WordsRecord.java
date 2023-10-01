package com.alex.wordslcore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class WordsRecord {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer Id;

    private String enWords;
    private String translateWords;
    private Integer userId;
    private boolean hasBeenExported;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getEnWords() {
        return enWords;
    }

    public void setEnWords(String enWords) {
        this.enWords = enWords;
    }

    public String getTranslateWords() {
        return translateWords;
    }

    public void setTranslateWords(String translateWords) {
        this.translateWords = translateWords;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public boolean isHasBeenExported() {
        return hasBeenExported;
    }

    public void setHasBeenExported(boolean hasBeenExported) {
        this.hasBeenExported = hasBeenExported;
    }

    public WordsRecord(String enWords, String translateWords, Integer userId) {
        this.enWords = enWords;
        this.translateWords = translateWords;
        this.userId = userId;
        this.hasBeenExported =false;
    }

    public WordsRecord() {
    }
}
