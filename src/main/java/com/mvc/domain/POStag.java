package com.mvc.domain;

public class POStag {
    private String posTag;
    private double probability;

    public POStag() {
    }

    public POStag(String posTag, double probability) {
        this.posTag = posTag;
        this.probability = probability;
    }

    public String getPosTag() {
        return posTag;
    }

    public void setPosTag(String posTag) {
        this.posTag = posTag;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }
}
