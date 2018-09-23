package com.mvc.utils;

import com.mvc.domain.Token;
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.logging.Logger;

public class VectorizerSingletonTest {
    private final static Logger logger = Logger.getLogger(VectorizerSingletonTest.class.getName());

    @Test
    public void testLoadingEmbeddings(){
        long timeStart = System.currentTimeMillis();
        VectorizerSingleton v = VectorizerSingleton.getInstance();
        long execTime = System.currentTimeMillis() - timeStart;
        logger.info("Loaded embeddings in: " + execTime/1000f + " Sec");
        logger.info("Loaded embeddings: " + v.getVectors().keySet().size() + " tokens");
        Assert.assertNotNull(v.getVectors());
    }


    @Test
    public void getVectorFromString() {
        VectorizerSingleton v = VectorizerSingleton.getInstance();
        double[] vect = v.getVectorFromString("would");
        Assert.assertEquals(vect.length, 50);
    }

    @Test
    public void getVectorFromStringNULL() {
        VectorizerSingleton v = VectorizerSingleton.getInstance();
        double[] vect = v.getVectorFromString("randomnonexistingSTRING");
        Assert.assertNull(vect);
    }


    @Test
    public void testPearson() {
        double[] x = {1, 2, 4, 8};
        double[] y = {2, 4, 8, 3};
        double corr = new PearsonsCorrelation().correlation(y, x);
        System.out.println(corr);
    }

    @Test
    public void getVectors() {
    }


    @Test
    public void getAllTokensProfiling() {
        VectorizerSingleton v = VectorizerSingleton.getInstance();
        long timeStart = System.currentTimeMillis();
        v.getAllTokens();
        long execTime = System.currentTimeMillis() - timeStart;
        logger.info("Transformed vec/str into tokens: " + execTime/1000f + " Sec");
    }

    @Test
    public void getMostSimilarStrings() {
        VectorizerSingleton v = VectorizerSingleton.getInstance();
        double[] vect = v.getVectorFromString("capital");
        List<Token> mostSimilarTokens = v.getMostSimilarStrings(vect, 10);
        for (Token token : mostSimilarTokens) {
            System.out.println(token.getName());
        }
    }

    @Test
    public void computingTimeForSimilarityProfiling() {
        VectorizerSingleton v = VectorizerSingleton.getInstance();
        long timeStart = System.currentTimeMillis();
        double[] vect = v.getVectorFromString("where");
        v.getMostSimilarStrings(vect, 10);
        long execTime = System.currentTimeMillis() - timeStart;
        logger.info("Similarity comparison in: " + execTime/1000f + " Sec");
    }

}