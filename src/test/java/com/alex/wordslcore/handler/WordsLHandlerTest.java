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
        assertEquals("Небо", new WordsLHandler().translate("en","ru","Sky"));
        assertEquals("стол", new WordsLHandler().translate("en","ru","table"));

    }
}