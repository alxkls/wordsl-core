package com.alex.wordslcore.controller;

import com.alex.wordslcore.service.WordsLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class WordsLController {
    @Autowired
    WordsLService wordsLService;

    @GetMapping("/greeting")
    public ResponseEntity<String> greeting(@RequestHeader("userId") String userId) {
        // code that uses the language variable
        return new ResponseEntity<String>(userId, HttpStatus.OK);
    }

    @PostMapping("/put/{wordsToBeTranslated}")
    public ResponseEntity<String> putNewRecordsPathVar(@PathVariable(name = "wordsToBeTranslated")String wordsToBeTranslated, @RequestHeader("userId") String userId){

        return new ResponseEntity<>(wordsLService.putNewRecord(wordsToBeTranslated, userId), HttpStatus.OK) ;
    }
    @PostMapping("/put")
    public ResponseEntity<String> putNewRecordsParam(@RequestParam(name = "wordsToBeTranslated", required = true) String wordsToBeTranslated, @RequestHeader("userId") String userId){

        return new ResponseEntity<>(wordsLService.putNewRecord(wordsToBeTranslated,userId), HttpStatus.OK) ;
    }

    @GetMapping("/getall")
    public ResponseEntity getAllRecords(@RequestHeader("userId") String userId){
        return new ResponseEntity(wordsLService.getAllRecords(userId) ,HttpStatus.OK) ;
    }

    @GetMapping("/getnew")
    public ResponseEntity getNewRecords(@RequestHeader("userId") String userId){
        //return wordsLService.getRecordsForExport();
        return new ResponseEntity(wordsLService.getRecordsForExport(userId), HttpStatus.OK);

    }

    @PostMapping("/clean")
    public ResponseEntity<String> cleanExported(@RequestHeader("userId") String userId){
        return new ResponseEntity<String>(wordsLService.cleanExported(userId), HttpStatus.OK);

    }


}
