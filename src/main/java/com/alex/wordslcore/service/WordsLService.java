package com.alex.wordslcore.service;

import com.alex.wordslcore.handler.WordsLHandler;
import com.alex.wordslcore.model.WordsLUser;
import com.alex.wordslcore.model.WordsRecord;
import com.alex.wordslcore.repository.WordsRecordRepository;
import com.alex.wordslcore.repository.WordsUserRepository;
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

    @Autowired
    WordsUserRepository wordsUserRepository;
    public String setLanguages(String origLan, String translateLan, String userId){

        if(!(handler.validateLanCode(origLan)&& handler.validateLanCode(translateLan))){
            return "lan code is not valid!";
        }
        List<WordsLUser> user = wordsUserRepository.findByUserId(userId);
        if (user.size()==0){
            wordsUserRepository.save(new WordsLUser(origLan,translateLan,userId));
        }else if(user.size() == 1){
            user.get(0).setOriginalLan(origLan);
            user.get(0).setTranslateLan(translateLan);
            wordsUserRepository.save(user.get(0));
        }else{
            return "looks like more than one instances of "+ userId+"/n  "+ user.toString();
        }
        return "langueges have been set";
    }
    public String getUserSettings(String userId){
        List<WordsLUser> user = wordsUserRepository.findByUserId(userId);

        if (user == null){
            return null;
        }else if(user.size() == 1){
            return user.get(0).toString();
        }else{
            return "something went wrong";
        }
    }

    public String putNewRecord(String wordsToBeTranlate, String userId){

        wordsToBeTranlate = handler.separateWords(wordsToBeTranlate,"_");
        String translate ="/";

        List<WordsLUser> user = wordsUserRepository.findByUserId(userId);

        if (user.size()==0){
            return "set user's languages first";
        }else if(user.size() != 1){
            return "looks like more than one instances of "+ userId+"/n  "+ user.toString();
        }

        try {
            translate = handler.translate(user.get(0).getOriginalLan(),user.get(0).getTranslateLan(), wordsToBeTranlate);
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
