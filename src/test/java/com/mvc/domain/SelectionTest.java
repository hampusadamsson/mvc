package com.mvc.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SelectionTest {

    public Selection mockSelection() {
        Selection s = new Selection();
        Token a = new Token();
        Token b = new Token();
        Token c = new Token();
        a.setVector(new float[]{1,1,1});
        b.setVector(new float[]{2,2,1});
        c.setVector(new float[]{3,1.5f,1});
        List<Token> t = new ArrayList<>();
        t.add(a);
        t.add(b);
        t.add(c);
        s.setSelection(t);
        return s;
    }

    @Test
    public void testGetAverageVector() {
        Selection s = mockSelection();
        float[] averageVector = s.getAverageVector();
        float[] correct = new float[]{2, 1.5f, 1};
        Assert.assertTrue(Arrays.equals(correct, averageVector));
    }

}