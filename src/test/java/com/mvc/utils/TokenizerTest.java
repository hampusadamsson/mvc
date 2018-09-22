package com.mvc.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mvc.utils.Tokenizer.splitSentenceIntoTokens;
import static org.junit.Assert.*;

public class TokenizerTest {

    @Test
    public void testSplitSentenceIntoTokens() {
        String sent = "this is a test";
        String[] res = {"this", "is", "a", "test"};
        String[] tokens = splitSentenceIntoTokens(sent);
        Assert.assertArrayEquals(tokens, res);
    }

    @Test
    public void testSplitDelimiters() {
        String sent = "this is a test. dot";
        String[] res = {"this", "is", "a", "test", "dot"};
        String[] tokens = splitSentenceIntoTokens(sent);
        Assert.assertArrayEquals(tokens, res);
    }

    @Test
    public void testSplitNumbers1() {
        String sent = "this is 123 a test. dot";
        String[] res = {"this", "is", "123", "a", "test", "dot"};
        String[] tokens = splitSentenceIntoTokens(sent);
        Assert.assertArrayEquals(tokens, res);
    }

    @Test
    public void testSplitNumbers2() {
        String sent = "this is 123abc a test. dot";
        String[] res = {"this", "is", "123abc", "a", "test", "dot"};
        String[] tokens = splitSentenceIntoTokens(sent);
        Assert.assertArrayEquals(tokens, res);
    }

    @Test
    public void testSplitNumbers3() {
        String sent = "this is! 123abc a test. dot";
        String[] res = {"this", "is", "123abc", "a", "test", "dot"};
        String[] tokens = splitSentenceIntoTokens(sent);
        Assert.assertArrayEquals(tokens, res);
    }

    @Test
    public void testGibberish() {
        String sent = ".... this !is! a!b .";
        String[] res = {"", "this", "is", "a", "b"};
        String[] tokens = splitSentenceIntoTokens(sent);
        Assert.assertArrayEquals(tokens, res);
    }

    @Test
    public void testEmpty() {
        String sent = "";
        String[] res = {""};
        String[] tokens = splitSentenceIntoTokens(sent);
        Assert.assertArrayEquals(tokens, res);
    }

    @Test
    public void testDot() {
        String sent = ".";
        String[] res = {};
        String[] tokens = splitSentenceIntoTokens(sent);
        Assert.assertArrayEquals(tokens, res);
    }

    @Test
    public void testSwedish() {
        String sent = "absödla and me";
        String[] res = {"abs", "dla", "and", "me"};
        String[] tokens = splitSentenceIntoTokens(sent);
        Assert.assertArrayEquals(tokens, res);
    }


}