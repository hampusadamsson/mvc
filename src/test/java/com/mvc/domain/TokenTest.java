package com.mvc.domain;

import org.junit.Assert;
import org.junit.Test;

public class TokenTest {

    @Test
    public void testCheckAndSetCapitalization() {
        String tmp = "Test";
        Token token = new Token();
        Boolean stringCapitalized = token.isStringCapitalized(tmp);
        Assert.assertTrue(stringCapitalized);
    }

    @Test
    public void testCheckAndSetCapitalization2() {
        String tmp = "test";
        Token token = new Token();
        Boolean stringCapitalized = token.isStringCapitalized(tmp);
        Assert.assertFalse(stringCapitalized);
    }

    @Test
    public void testCheckAndSetCapitalization3() {
        String tmp = "";
        Token token = new Token();
        Boolean stringCapitalized = token.isStringCapitalized(tmp);
        Assert.assertFalse(stringCapitalized);
    }


    @Test
    public void testCheckAndSetCapitalization4() {
        String tmp = "123";
        Token token = new Token();
        Boolean stringCapitalized = token.isStringCapitalized(tmp);
        Assert.assertFalse(stringCapitalized);
    }


    @Test
    public void checkIfNumberic1() {
        String tmp = "123";
        Token token = new Token();
        Boolean res = token.doesStringContainNumbers(tmp);
        Assert.assertTrue(res);
    }

    @Test
    public void checkIfNumberic2() {
        String tmp = "abc";
        Token token = new Token();
        Boolean res = token.doesStringContainNumbers(tmp);
        Assert.assertFalse(res);
    }

    @Test
    public void checkIfNumberic3() {
        String tmp = "abc12s";
        Token token = new Token();
        Boolean res = token.doesStringContainNumbers(tmp);
        Assert.assertTrue(res);
    }

    @Test
    public void checkIfNumbericEmpty() {
        String tmp = "";
        Token token = new Token();
        Boolean res = token.doesStringContainNumbers(tmp);
        Assert.assertFalse(res);
    }


    @Test
    public void setName() {
    }

    @Test
    public void getLength() {
    }

    @Test
    public void setLength() {
    }

    @Test
    public void getLemma() {
    }

    @Test
    public void setLemma() {
    }

    @Test
    public void getStem() {
    }

    @Test
    public void setStem() {
    }

    @Test
    public void getVector() {
    }

    @Test
    public void hasVector() {
    }

    @Test
    public void setVector() {
    }

    @Test
    public void getPartOfSpeech() {
    }

    @Test
    public void setPartOfSpeech() {
    }

    @Test
    public void print() {
    }

    @Test
    public void getIsCapitalized() {
    }

    @Test
    public void isStringCapitalized() {
    }

    @Test
    public void doesStringContainNumbers() {
    }

    @Test
    public void setIsCapitalized() {
    }

    @Test
    public void getContainsNumbers() {
    }

    @Test
    public void setContainsNumbers() {
    }
}