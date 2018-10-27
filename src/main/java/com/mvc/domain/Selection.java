package com.mvc.domain;

import com.mvc.utils.POSSingleton;
import com.mvc.utils.VectorizerSingleton;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.mvc.utils.Tokenizer.splitTextIntoTokens;

public class Selection {
    private String name;
    private int length;
    private int sentenceLength;
    private String sentiment;
    private String topic;
    private double[] averageVector;
    private List<Token> selection;

    public Selection() {
    }

    public Selection(String selection) {
        String[] tokenStrings = splitTextIntoTokens(selection);
        this.setName(selection);
        this.setSelection(this.stringsToTokens(tokenStrings));
        this.setPosTags(tokenStrings);
        this.setAverageVector(this.getAverageVector());
        this.setSentenceLength(selection.length());
        this.setLength(tokenStrings.length);
    }

    private void setPosTags(String[] tokenStrings){
        List<POStag> posTagsFromTokens = POSSingleton.getInstance().getPosTagsFromTokens(tokenStrings);
        for (int i = 0; i < posTagsFromTokens.size(); i++) {
            this.getSelection().get(i).setPartOfSpeech(posTagsFromTokens.get(i));
        }
    }

    List<Token> stringsToTokens(String[] tokenStrings){
        return Arrays.stream(tokenStrings).map(Token::new).collect(Collectors.toList());
    }

    List<Token> getSimilarTokens(int nrTokensToReturn){
        double[] vec = this.getAverageVector();
        return VectorizerSingleton.getInstance().getMostSimilarStrings(vec, nrTokensToReturn);
    }

    public double[] getAverageVector(){
        List<double[]> vectors = this.selection.stream().filter(Token::hasVector).map(Token::getVector).collect(Collectors.toList());
        int vecLen = vectors.size()>0 ? vectors.get(0).length : 0;
        double[] averageVector = new double[vecLen];
        for (int i = 0; i < vecLen; i++) {
            int finalI = i;
            double avg = vectors.stream().map(v -> v[finalI]).mapToDouble(Double::doubleValue).average().orElse(Double.NaN);
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

    public void setAverageVector(double[] averageVector) {
        this.averageVector = averageVector;
    }

    public void print(){
        System.out.println(this.name);
        System.out.println("--------------------------");
        this.getSelection().forEach(Token::print);
    }

    public int getSentenceLength() {
        return sentenceLength;
    }

    public void setSentenceLength(int sentenceLength) {
        this.sentenceLength = sentenceLength;
    }
}

