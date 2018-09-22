package com.mvc.utils;

import java.util.StringTokenizer;

public class Tokenizer {
    private static final String REGEX = "[^\\w']+";

    static String[] splitSentenceIntoTokens(String sentence){
        return sentence.split(REGEX);
    }



}
