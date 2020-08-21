package com.wmf.homework.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextParserTest {

    @Test
    public void testExtractNumberAndAlphabet() {
        String expectedResult = "1cA5B";
        String result = TextParser.extractNumberAndAlphabet("1가c나A다5B라");

        assertEquals(expectedResult,result);
    }

    @Test
    public void testExtractNumber() {
        String expectedResult = "15";
        String result = TextParser.extractNumber("1가c나A다5B라");

        assertEquals(expectedResult,result);
    }

    @Test
    public void testExtractAlphabet() {
        String expectedResult = "cAB";
        String result = TextParser.extractAlphabet("1가c나A다5B라");

        assertEquals(expectedResult,result);
    }

    @Test
    public void shouldEmptyStringWhenNoContainsAlphabetAndNumber() {
        String expectedResult = "";
        String result = TextParser.extractNumberAndAlphabet("가나다라마");

        assertEquals(expectedResult,result);
    }
}