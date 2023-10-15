package com.alex.wordslcore.service;

import com.alex.wordslcore.handler.WordsLHandler;
import com.alex.wordslcore.model.WordsRecord;
import com.alex.wordslcore.repository.WordsRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WordsLService {
    @Autowired
    WordsRecordRepository wordsRecordRepository;

    @Autowired
    WordsLHandler handler;

    public String putNewRecord(String wordsToBeTranlate){

        wordsToBeTranlate = handler.separateWords(wordsToBeTranlate,"_");
        String translate ="/";

        try {
            translate = handler.translate("en","ru", wordsToBeTranlate);
        } catch (IOException e) {
            //throw new RuntimeException(e);
        }

        wordsRecordRepository.save(new WordsRecord(wordsToBeTranlate,translate,1));
        return "'"+wordsToBeTranlate + "' have been saved";
    }

    public ResponseEntity getAllRecords(){

        ResponseEntity responseEntity = new ResponseEntity(wordsRecordRepository.findAll(),HttpStatusCode.valueOf(200));
        return responseEntity;
    }

    public ResponseEntity getRecordsForExport(){

        List recordsForExport = new ArrayList();

        for (var record :
                wordsRecordRepository.findAll()) {
            if (!record.isHasBeenExported()){
                recordsForExport.add(record.toString());
                record.setHasBeenExported(true);
                wordsRecordRepository.save(record);
            }
        }

        ResponseEntity responseEntity = new ResponseEntity(recordsForExport ,HttpStatusCode.valueOf(200));
        return responseEntity;
    }

    public String cleanExported(){
        for (WordsRecord record :
                wordsRecordRepository.findAll()) {
            if (record.isHasBeenExported())
                wordsRecordRepository.delete(record);
        }
        return "exported records have been removed";
    }

}
