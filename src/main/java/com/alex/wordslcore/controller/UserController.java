package com.alex.wordslcore.controller;

import com.alex.wordslcore.model.WordsLUser;
import com.alex.wordslcore.repository.WordsUserRepository;
import com.alex.wordslcore.service.WordsLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    WordsLService wordsLService;

    //@Autowired
    //WordsUserRepository wordsUserRepository;
    @PostMapping("/setlan")
    public ResponseEntity<String> setUserLan(@RequestParam(name = "origLan", required = true) String origLan,
                                                     @RequestParam(name = "translateLan", required = true) String translateLan,
                                                     @RequestHeader("userId") String userId){

        //wordsUserRepository.save(new WordsLUser(origLan,translateLan,userId));
        //return new ResponseEntity<String>("ok", HttpStatus.OK) ;
        return new ResponseEntity<String>(wordsLService.setLanguages(origLan,translateLan, userId), HttpStatus.OK) ;
    }
    @GetMapping("/getuser")
    public ResponseEntity<String> getUserSettings(@RequestHeader("userId") String userId){

        return new ResponseEntity<>(wordsLService.getUserSettings(userId), HttpStatus.OK) ;
    }
}
