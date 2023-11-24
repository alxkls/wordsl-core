package com.alex.wordslcore.handler;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Component
public class WordsLHandler {
    public String translate(String langFrom, String langTo, String text) throws IOException {
        // INSERT YOU URL HERE
        String urlStr = "https://script.google.com/macros/s/AKfycbxUpXMB1EqEC8JXKWKm1iCitNP6cqlGvLtueTy4caK6B9KuDNyW1zVC8EJvqdbPQ-KFrg/exec" +
                "?q=" + URLEncoder.encode(text, "UTF-8") +
                "&target=" + langTo +
                "&source=" + langFrom;
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    public String separateWords(String userInput, String ... symbolToBeSpace){

        String words = userInput;
        for (String s :
                symbolToBeSpace) {
            words = words.replace(s," ");
        }
        return words.trim();
    }
    public boolean validateLanCode(String lanCode){
        String[] lanCodes = {"ru","uk","de","en"};
        for (var c :
                lanCodes) {
            if (c.equals(lanCode))
                return true;
        }
        return false;
    }
}
