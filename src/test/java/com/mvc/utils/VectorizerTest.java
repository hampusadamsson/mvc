package com.mvc.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Logger;

public class VectorizerTest {
    private final static Logger logger = Logger.getLogger(VectorizerTest.class.getName());

    @Test
    public void testLoadingEmbeddings(){
        long timeStart = System.currentTimeMillis();
        Vectorizer v = new Vectorizer(true);
        long execTime = System.currentTimeMillis() - timeStart;
        logger.info("Loaded embeddings in: " + execTime/1000f + " Sec");
        Assert.assertNotNull(v.getVectors());
    }


    @Test
    public void getVectorFromToken() {
        Vectorizer v = new Vectorizer(true);
        float[] vect = v.getVectorFromString("would");
        Assert.assertEquals(vect.length, 50);
    }

    @Test
    public void getTokenVectorFromDatabase() {
    }

    @Test
    public void getVectors() {
    }

    @Test
    public void setVectors() {
    }
}