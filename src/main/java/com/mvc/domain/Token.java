package com.mvc.domain;

import com.mvc.utils.StemmerSingleton;
import com.mvc.utils.VectorizerSingleton;

import java.util.regex.Pattern;

public class Token {
    private String name;
    private int length;
    private POStag partOfSpeech;
    private String lemma;
    private String stem;
    private Boolean isCapitalized;
    private Boolean containsNumbers;
    private double[] vector;

    public Token() {
    }

    public Token(String name) {
        this.setName(name);
        this.setVector(VectorizerSingleton.getInstance().getVectorFromString(name));
        this.setStem(StemmerSingleton.getInstance().stem(name));
        this.setLength(name.length());
        this.setIsCapitalized(isStringCapitalized(name));
        this.setContainsNumbers(doesStringContainNumbers(name));
    }

    public Token(String name, double[] vector) {
        this.setVector(vector);
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getLemma() {
        return lemma;
    }

    public void setLemma(String lemma) {
        this.lemma = lemma;
    }

    public String getStem() {
        return stem;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }

    public double[] getVector() {
        return vector;
    }

    public Boolean hasVector() {
        return this.vector != null;
    }

    public void setVector(double[] vector) {
        this.vector = vector;
    }

    public POStag getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(POStag partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public void print(){
        System.out.println(this.getName());
        System.out.println("\tStem: " + this.getStem());
        System.out.println("\tPOS:" + this.getPartOfSpeech().getPosTag() + "\t" + this.getPartOfSpeech().getProbability());
        System.out.println("\tVec: " + this.getVector());
    }

    public Boolean getIsCapitalized() {
        return isCapitalized;
    }

    public Boolean isStringCapitalized(String str) {
        return str.length() > 0 && Character.isUpperCase(str.charAt(0));
    }

    public Boolean doesStringContainNumbers(String str) {
        return Pattern.compile( "[0-9]" ).matcher(str).find();
    }


    public void setIsCapitalized(Boolean capitalized) {
        isCapitalized = capitalized;
    }

    public Boolean getContainsNumbers() {
        return containsNumbers;
    }

    public void setContainsNumbers(Boolean containsNumbers) {
        this.containsNumbers = containsNumbers;
    }
}
