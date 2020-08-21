package com.wmf.homework.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParsingResultTest {

    @Test
    public void parsingTest() throws Exception {
        ParsingResult result = new ParsingResult("abbbbbbbbb","123");
        String combinedAlphabetAndNumber = result.getCombinedAlphabetAndNumber();

        ParsingResult result1 = result.divideCharacter(13);

        String remainder = result1.getRemainder();
        String share = result1.getShare();

        assertEquals("a1b2b3bbbbbbb",share);
        assertEquals("",remainder);
    }
}