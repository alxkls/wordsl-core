package com.alex.wordslcore.service;

import com.alex.wordslcore.handler.WordsLHandler;
import com.alex.wordslcore.model.WordsRecord;
import com.alex.wordslcore.repository.WordsRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WordsLService {
    @Autowired
    WordsRecordRepository wordsRecordRepository;

    @Autowired
    WordsLHandler handler;

    public String putNewRecord(String WordsToBeTranlate){

        String translate ="/";

        try {
            translate = handler.translate("en","ru", handler.separateWords(WordsToBeTranlate));
        } catch (IOException e) {
            //throw new RuntimeException(e);
        }

        wordsRecordRepository.save(new WordsRecord(WordsToBeTranlate,translate,1));
        return WordsToBeTranlate + " have been saved";
    }

    public ResponseEntity getAllRecords(){
        ResponseEntity responseEntity = new ResponseEntity("hello test",HttpStatusCode.valueOf(200));
        return responseEntity;
    }

}
