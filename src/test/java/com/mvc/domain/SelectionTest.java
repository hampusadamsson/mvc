package com.mvc.domain;

import com.mvc.utils.VectorizerSingleton;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class SelectionTest {

    public Selection mockSelection() {
        Selection s = new Selection();
        Token a = new Token();
        Token b = new Token();
        Token c = new Token();
        a.setVector(new double[]{1,1,1});
        b.setVector(new double[]{2,2,1});
        c.setVector(new double[]{3,1.5f,1});
        List<Token> t = new ArrayList<>();
        t.add(a);
        t.add(b);
        t.add(c);
        s.setSelection(t);
        return s;
    }

    @Test
    public void testFull() {
        Selection s = new Selection("I'm running faster than anyone has ever done before");
        s.print();
    }

    @Test
    public void testStringsToVectors() {
        Selection s = new Selection();
        String[] inp = new String[]{"where", "."};
        List<Token> tokens = s.stringsToTokens(inp);
        Assert.assertNotNull(tokens.get(0));
        Assert.assertNotNull(tokens.get(1));
        Assert.assertNotNull(tokens.get(0).getName());
        Assert.assertNotNull(tokens.get(1).getName());
        Assert.assertNotNull(tokens.get(0).getVector());
        Assert.assertNotNull(tokens.get(1).getVector());
        Assert.assertEquals("where", tokens.get(0).getName());
        Assert.assertEquals(".", tokens.get(1).getName());
        Assert.assertEquals(".", tokens.get(1).getVector().length, 50);
    }

    @Test
    public void testTokenizeAndToVectors() {
        Selection s = new Selection("where low");
        List<Token> tokens = s.getSelection();
        Assert.assertNotNull(tokens.get(0));
        Assert.assertNotNull(tokens.get(1));
        Assert.assertNotNull(tokens.get(0).getName());
        Assert.assertNotNull(tokens.get(1).getName());
        Assert.assertNotNull(tokens.get(0).getVector());
        Assert.assertNotNull(tokens.get(1).getVector());
        Assert.assertEquals("where", tokens.get(0).getName());
        Assert.assertEquals("low", tokens.get(1).getName());
        Assert.assertEquals("low", tokens.get(1).getVector().length, 50);
    }

    @Test
    public void testTokenizeAndToVectorsAndAverageVector2tokens() {
        Selection s = new Selection("where low");
        for (int i = 0; i < s.getAverageVector().length; i++) {
            double avg = s.getAverageVector()[i];
            double v1 = s.getSelection().get(0).getVector()[i];
            double v2 = s.getSelection().get(1).getVector()[i];
            Assert.assertEquals(avg, (v1+v2)/2, 0.00001);
        }
    }

    @Test
    public void testTokenizeAndToVectorsAndAverageVector3tokens() {
        Selection s = new Selection("where low parliament");
        for (int i = 0; i < s.getAverageVector().length; i++) {
            double avg = s.getAverageVector()[i];
            double v1 = s.getSelection().get(0).getVector()[i];
            double v2 = s.getSelection().get(1).getVector()[i];
            double v3 = s.getSelection().get(2).getVector()[i];
            Assert.assertEquals(avg, (v1+v2+v3)/3, 0.00001);
        }
    }

    @Test
    public void testTokenizeAndToVectorsAndAverageVector3tokensAndGetSimilar() {
        Selection s = new Selection("monster frankeinstein dracula zombie");
        List<Token> similarTokens = s.getSimilarTokens(10);
        for(Token t : similarTokens){
            System.out.println(t.getName());
        }
    }


    @Test
    public void testGetAverageVector() {
        Selection s = mockSelection();
        double[] averageVector = s.getAverageVector();
        double[] correct = new double[]{2, 1.5d, 1};
        Assert.assertTrue(Arrays.equals(correct, averageVector));
    }

    @Test
    public void testGetAverageVectorWithEmptyVector() {
        Selection s = mockSelection();
        List<Token> selection = s.getSelection();
        selection.add(new Token());
        double[] averageVector = s.getAverageVector();
        double[] correct = new double[]{2, 1.5f, 1};
        Assert.assertTrue(Arrays.equals(correct, averageVector));
    }

    @Test
    public void testGetAverageVectorAllWrong() {
        Selection s = mockSelection();
        s.setSelection(new ArrayList<>());
        double[] averageVector = s.getAverageVector();
        double[] correct = new double[]{};
        Assert.assertTrue(Arrays.equals(correct, averageVector));
    }

    @Test
    public void testAverageVectorWithSimilarities() {
        Selection s = new Selection();
        List<Token> t = new ArrayList<>();
        VectorizerSingleton v = VectorizerSingleton.getInstance();
        t.add(new Token("where", v.getVectorFromString("where")));
        t.add(new Token(".", v.getVectorFromString(".")));
        s.setSelection(t);

        double[] averageVector = s.getAverageVector();
        List<Token> mostSimilarStrings = v.getMostSimilarStrings(averageVector, 3);
        for (Token similar : mostSimilarStrings) {
            System.out.println(similar.getName());
        }
    }


    @Test
    public void getAverageVector() {
    }

    @Test
    public void getName() {
    }

    @Test
    public void setName() {
    }

    @Test
    public void getSelection() {
    }

    @Test
    public void setSelection() {
    }

    @Test
    public void getLength() {
    }

    @Test
    public void setLength() {
    }

    @Test
    public void getSentiment() {
    }

    @Test
    public void setSentiment() {
    }

    @Test
    public void getTopic() {
    }

    @Test
    public void setTopic() {
    }

    @Test
    public void getVector() {
    }

    @Test
    public void setVector() {
    }
}