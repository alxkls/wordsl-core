package com.alex.wordslcore.service;

import com.alex.wordslcore.model.WordsRecord;
import com.alex.wordslcore.repository.WordsRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordsLService {
    @Autowired
    WordsRecordRepository wordsRecordRepository;

    public String putNewRecord(String enWords){

        wordsRecordRepository.save(new WordsRecord(enWords,"translate",1));
        return enWords + " have been saved";
    }

}
