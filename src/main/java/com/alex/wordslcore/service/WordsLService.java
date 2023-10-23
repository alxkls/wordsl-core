package com.alex.wordslcore.service;

import com.alex.wordslcore.handler.WordsLHandler;
import com.alex.wordslcore.model.WordsRecord;
import com.alex.wordslcore.repository.WordsRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public String putNewRecord(String wordsToBeTranlate, String userId){

        wordsToBeTranlate = handler.separateWords(wordsToBeTranlate,"_");
        String translate ="/";

        try {
            translate = handler.translate("en","ru", wordsToBeTranlate);
        } catch (IOException e) {
            //throw new RuntimeException(e);
        }

        wordsRecordRepository.save(new WordsRecord(wordsToBeTranlate,translate,userId));
        return "'"+wordsToBeTranlate + "' have been saved";
    }

    public Iterable getAllRecords(String userId){

        return wordsRecordRepository.findByUserId(userId);
    }

    public Iterable getRecordsForExport(String userId){

        List recordsForExport = new ArrayList();

        for (var record :
                wordsRecordRepository.findByUserId(userId)) {
            if (!record.isHasBeenExported()){
                recordsForExport.add(record.toString());
                record.setHasBeenExported(true);
                wordsRecordRepository.save(record);
            }
        }

        return recordsForExport;
    }

    public String cleanExported(String userId){
        for (WordsRecord record :
                wordsRecordRepository.findByUserId(userId)) {
            if (record.isHasBeenExported())
                wordsRecordRepository.delete(record);
        }
        return "exported records have been removed";
    }

}
