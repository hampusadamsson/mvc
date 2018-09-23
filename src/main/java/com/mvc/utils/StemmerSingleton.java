package com.mvc.utils;

import opennlp.tools.stemmer.PorterStemmer;

public class StemmerSingleton {
    private static StemmerSingleton ourInstance = new StemmerSingleton();
    private PorterStemmer stemmer = new PorterStemmer();

    public static StemmerSingleton getInstance() {
        return ourInstance;
    }

    private StemmerSingleton() {
    }

    public String stem(String token){
        return this.stemmer.stem(token);
    }
}
