package com.alex.wordslcore.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class WordsLController {

    @PostMapping("/put/{enWords}")
    public String putNewRecordPathVar(@PathVariable(name = "enWords")String enWords){

        return enWords + " have been saved";
    }
    @PostMapping("/put")
    public String putNewRecordParam(@RequestParam(name = "enWords", required = true) String enWords){

        return enWords + " have been saved";
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
