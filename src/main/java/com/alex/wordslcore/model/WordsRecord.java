package com.alex.wordslcore.model;

import jakarta.persistence.*;

@Entity
@Table(name = "recordsl")
public class WordsRecord {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer Id;

    private String originalWords;
    private String translateWords;
    private String userId;
    private boolean hasBeenExported;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getOriginalWords() {
        return originalWords;
    }

    public void setOriginalWords(String originalWords) {
        this.originalWords = originalWords;
    }

    public String getTranslateWords() {
        return translateWords;
    }

    public void setTranslateWords(String translateWords) {
        this.translateWords = translateWords;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isHasBeenExported() {
        return hasBeenExported;
    }

    public void setHasBeenExported(boolean hasBeenExported) {
        this.hasBeenExported = hasBeenExported;
    }

    public WordsRecord(String originalWords, String translateWords, String userId) {
        this.originalWords = originalWords;
        this.translateWords = translateWords;
        this.userId = userId;
        this.hasBeenExported =false;
    }

    public WordsRecord() {
    }

    @Override
    public String toString() {
        return originalWords +" : "+translateWords;
    }
}
