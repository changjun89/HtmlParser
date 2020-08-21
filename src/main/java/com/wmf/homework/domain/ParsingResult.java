package com.wmf.homework.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ParsingResult {

    private String sortedAlphabet;
    private String sortedNumbers;
    public String combinedAlphabetAndNumber;
    public String share;
    public String remainder;

    public ParsingResult(String sortedAlphabet, String sortedNumbers) {
        this.sortedAlphabet = sortedAlphabet;
        this.sortedNumbers = sortedNumbers;
        this.combinedAlphabetAndNumber = combineNumberAndAlphabet();
    }

    private String combineNumberAndAlphabet() {
        StringBuilder builder = new StringBuilder();
        int alphabetLength = sortedAlphabet.length();
        int numbersLength = sortedNumbers.length();

        int minLength = Math.min(alphabetLength, numbersLength);

        for (int i = 0, length = minLength; i < length; i++) {
            builder.append(sortedAlphabet.charAt(i));
            builder.append(sortedNumbers.charAt(i));
        }
        builder.append(getOverCharacter());
        return builder.toString();
    }

    private String getOverCharacter() {
        int alphabetLength = sortedAlphabet.length();
        int numbersLength = sortedNumbers.length();
        if (alphabetLength > numbersLength) {
            return sortedAlphabet.substring(numbersLength, alphabetLength);
        }
        return sortedNumbers.substring(alphabetLength, numbersLength);
    }

    public ParsingResult divideCharacter(int divider) throws Exception {
        if (divider < 1) {
            throw new Exception("sdlfkj");
        }
        int textLength = combinedAlphabetAndNumber.length();
        int remainderLength = Math.floorMod(textLength, divider);
        int shareLength = textLength - remainderLength;

        share = combinedAlphabetAndNumber.substring(0, shareLength);
        remainder = combinedAlphabetAndNumber.substring(shareLength, textLength);

        return this;
    }
}
