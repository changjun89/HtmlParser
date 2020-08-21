package com.wmf.homework.util;

import java.util.regex.Pattern;

public class TextParser {

    public static final String EXTRACT_NUMBER_ALPHABET_REGEX = "^[a-zA-Z0-9]*$";
    public static final String EXTRACT_NUMBER_REGEX = "^[0-9]*$";
    public static final String EXTRACT_ALPHABET_REGEX = "^[a-zA-Z]*$";

    public static String extractNumberAndAlphabet(String text) {
        return extractByRegex(text,EXTRACT_NUMBER_ALPHABET_REGEX);
    }

    public static String extractNumber(String text) {
        return extractByRegex(text,EXTRACT_NUMBER_REGEX);
    }

    public static String extractAlphabet(String text) {
        return extractByRegex(text,EXTRACT_ALPHABET_REGEX);
    }

    private static String extractByRegex(String text,String regex) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = text.toCharArray();

        // 문자 배열에서 알파벳과 숫자만 추출
        for (char letter : chars) {
            boolean isMatches = Pattern.matches(regex, Character.toString(letter));
            if (isMatches) {
                stringBuilder.append(letter);
            }
        }
        return stringBuilder.toString();
    }
}
