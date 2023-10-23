package com.alex.wordslcore.handler;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class WordsLHandlerTest {

    @Test
    public void testWordsSeparated(){
        assertEquals("some words separated", new WordsLHandler().separateWords("  some words separated"));
        assertEquals("some words separated", new WordsLHandler().separateWords("some-words-separated","-"));
        assertEquals("some words separated", new WordsLHandler().separateWords("some-words:separated_","-",":","_"));
    }

    //@Disabled
    @Test
    public void testTranslate() throws IOException {
        WordsLHandler wordsLHandler = new WordsLHandler();
        assertEquals("Небо", wordsLHandler.translate("en","ru","Sky"));
        assertEquals("стол", wordsLHandler.translate("en","ru","table"));
        assertEquals("Привіт", wordsLHandler.translate("en","uk","Hi"));
        assertEquals("Hallo", wordsLHandler.translate("en","de","Hello"));
        assertEquals("table", wordsLHandler.translate("uk","en","стіл"));

    }

    @Test
    public void testValidateCode(){
        assertTrue(new WordsLHandler().validateLanCode("ru"));
        assertFalse(new WordsLHandler().validateLanCode("rU"));
        assertFalse(new WordsLHandler().validateLanCode("qweqwe"));

    }
}