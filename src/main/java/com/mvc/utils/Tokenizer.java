package com.mvc.utils;

public class Tokenizer {
    private static final String REGEX = "[^\\w']+";

    public static String[] splitTextIntoTokens(String sentence){
        return sentence.split(REGEX);
    }

}
