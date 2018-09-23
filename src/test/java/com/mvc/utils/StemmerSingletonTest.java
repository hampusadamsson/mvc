package com.mvc.utils;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StemmerSingletonTest {

    @Test
    public void getInstance() {
        StemmerSingleton stemmer = StemmerSingleton.getInstance();
        String testing = stemmer.stem("testing");
        System.out.println(testing);
        Assert.assertEquals("test", testing);
    }

    @Test
    public void testStemSwedish() {
        StemmerSingleton stemmer = StemmerSingleton.getInstance();
        String testing = stemmer.stem("ärorika");
        System.out.println(testing);
}
}