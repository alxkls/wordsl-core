package com.alex.wordslcore.handler;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("WordsLHandler should return")
class WordsLHandlerTest {

    @DisplayName("separated words")
    @Test
    public void testWordsSeparated(){
        assertEquals("some words separated", new WordsLHandler().separateWords("  some words separated"));
        assertEquals("some words separated", new WordsLHandler().separateWords("some-words-separated","-"));
        assertEquals("some words separated", new WordsLHandler().separateWords("some-words:separated_","-",":","_"));
    }

    @Disabled("for some reason does not work in maven")
    @DisplayName("translated words")
    @Test
    public void testTranslate() throws IOException {
        WordsLHandler wordsLHandler = new WordsLHandler();
        assertEquals("Небо", wordsLHandler.translate("en","ru","Sky"));
        assertEquals("стол", wordsLHandler.translate("en","ru","table"));
        assertEquals("Привіт", wordsLHandler.translate("en","uk","Hi"));
        assertEquals("Hallo", wordsLHandler.translate("en","de","Hello"));
        assertEquals("table", wordsLHandler.translate("uk","en","стіл"));

    }

    @DisplayName("validation of language code")
    @Test
    public void testValidateCode(){
        assertTrue(new WordsLHandler().validateLanCode("ru"));
        assertFalse(new WordsLHandler().validateLanCode("rU"));
        assertFalse(new WordsLHandler().validateLanCode("qweqwe"));

    }
}