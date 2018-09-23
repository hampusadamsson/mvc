package com.mvc.utils;

import org.junit.Assert;
import org.junit.Test;

import static com.mvc.utils.Tokenizer.splitTextIntoTokens;

public class TokenizerTest {

    @Test
    public void testSplitSentenceIntoTokens() {
        String sent = "this is a test";
        String[] res = {"this", "is", "a", "test"};
        String[] tokens = splitTextIntoTokens(sent);
        Assert.assertArrayEquals(tokens, res);
    }

    @Test
    public void testSplitDelimiters() {
        String sent = "this is a test. dot";
        String[] res = {"this", "is", "a", "test", "dot"};
        String[] tokens = splitTextIntoTokens(sent);
        Assert.assertArrayEquals(tokens, res);
    }

    @Test
    public void testSplitNumbers1() {
        String sent = "this is 123 a test. dot";
        String[] res = {"this", "is", "123", "a", "test", "dot"};
        String[] tokens = splitTextIntoTokens(sent);
        Assert.assertArrayEquals(tokens, res);
    }

    @Test
    public void testSplitNumbers2() {
        String sent = "this is 123abc a test. dot";
        String[] res = {"this", "is", "123abc", "a", "test", "dot"};
        String[] tokens = splitTextIntoTokens(sent);
        Assert.assertArrayEquals(tokens, res);
    }

    @Test
    public void testSplitNumbers3() {
        String sent = "this is! 123abc a test. dot";
        String[] res = {"this", "is", "123abc", "a", "test", "dot"};
        String[] tokens = splitTextIntoTokens(sent);
        Assert.assertArrayEquals(tokens, res);
    }

    @Test
    public void testGibberish() {
        String sent = ".... this !is! a!b .";
        String[] res = {"", "this", "is", "a", "b"};
        String[] tokens = splitTextIntoTokens(sent);
        Assert.assertArrayEquals(tokens, res);
    }

    @Test
    public void testEmpty() {
        String sent = "";
        String[] res = {""};
        String[] tokens = splitTextIntoTokens(sent);
        Assert.assertArrayEquals(tokens, res);
    }

    @Test
    public void testDot() {
        String sent = ".";
        String[] res = {};
        String[] tokens = splitTextIntoTokens(sent);
        Assert.assertArrayEquals(tokens, res);
    }

    @Test
    public void testSwedish() {
        String sent = "absödla and me";
        String[] res = {"abs", "dla", "and", "me"};
        String[] tokens = splitTextIntoTokens(sent);
        Assert.assertArrayEquals(tokens, res);
    }


    @Test
    public void getName() {
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
    public void getContainsNumbers() {
    }

    @Test
    public void setContainsNumbers() {
    }

    @Test
    public void checkAndSetCapitalization() {
    }

    @Test
    public void setIsCapitalized() {
    }
}