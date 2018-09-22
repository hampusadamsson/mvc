package com.mvc.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Selection {
    private String name;

    private List<Token> selection;
    private int length;
    private String sentiment;
    private String topic;
    private String vector;

    public Selection() {
    }

    public float[] getAverageVector(){
        List<float[]> vectors = this.selection.stream().map(Token::getVector).collect(Collectors.toList());
        int vecLen = vectors.get(0).length;
        float[] averageVector = new float[vecLen];

        for (int i = 0; i < vecLen; i++) {
            int finalI = i;
            double avg = vectors.stream().map(v -> v[finalI]).mapToDouble(Float::doubleValue).average().orElse(Double.NaN);
            averageVector[i] = (float)avg;
        }
        return averageVector;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Token> getSelection() {
        return selection;
    }

    public void setSelection(List<Token> selection) {
        this.selection = selection;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getVector() {
        return vector;
    }

    public void setVector(String vector) {
        this.vector = vector;
    }

}

