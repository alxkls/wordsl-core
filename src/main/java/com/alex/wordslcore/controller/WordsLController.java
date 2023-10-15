package com.alex.wordslcore.controller;

import com.alex.wordslcore.service.WordsLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WordsLController {
    @Autowired
    WordsLService wordsLService;

    @PostMapping("/put/{wordsToBeTranslated}")
    public String putNewRecordsPathVar(@PathVariable(name = "wordsToBeTranslated")String wordsToBeTranslated){

        return wordsLService.putNewRecord(wordsToBeTranslated);
    }
    @PostMapping("/put")
    public String putNewRecordsParam(@RequestParam(name = "wordsToBeTranslated", required = true) String wordsToBeTranslated){

        return wordsLService.putNewRecord(wordsToBeTranslated);
    }

    @GetMapping("/getall")
    public String getAllRecords(){
        return "all records";
    }

    @GetMapping("/getnew")
    public String getNewRecords(){
        return "new records";
    }


}
