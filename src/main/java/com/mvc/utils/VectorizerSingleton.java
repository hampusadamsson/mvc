package com.mvc.utils;

import com.mvc.domain.Token;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static com.mvc.Config.Config.DEV_MODE;
import static com.mvc.Config.Config.PATH_TO_WORDEMBEDDINGS;
import static com.mvc.Config.Config.PATH_TO_WORDEMBEDDINGS_TEST;

public class VectorizerSingleton {
    private final static Logger logger = Logger.getLogger(VectorizerSingleton.class.getName());
    private static VectorizerSingleton instance = null;
    private Map<String, double[]> vectors;


    public static VectorizerSingleton getInstance() {
        if(instance == null) {
            instance = new VectorizerSingleton(DEV_MODE);
        }
        return instance;
    }


    private VectorizerSingleton(Boolean devMode) {
        if(devMode){
            this.initVectorizer(PATH_TO_WORDEMBEDDINGS);
        }else{
            this.initVectorizer(PATH_TO_WORDEMBEDDINGS_TEST);
        }
    }

    private void initVectorizer(String filePath) {
        this.vectors = new HashMap<>();
        Scanner scan = null;
        try {
            scan = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert scan != null;
        while(scan.hasNextLine()) {
            String curLine = scan.nextLine();
            String[] splitLine = curLine.split(" ");
            double[] vector = new double[splitLine.length-1];
            for (int j = 0; j < splitLine.length-1; j++) {
                vector[j] = Float.parseFloat(splitLine[j+1]);
            }
            String token = splitLine[0];
            vectors.put(token, vector);
        }
    }

    public double[] getVectorFromString(String token){
        double[] vec = this.vectors.get(token.toLowerCase());
        if (Objects.isNull(vec))
            logger.info("Token not in database: " + token);
        return vec;
    }


    public List<Token> getAllTokens() {
        return this.vectors.keySet().stream().map(key -> new Token(key, this.getVectorFromString(key))).collect(Collectors.toList());
    }

    public List<Token> getMostSimilarStrings(double[] vec, int nrToReturn){
        List<Token> collect = this.getAllTokens()
                .stream()
                .sorted(Comparator.comparing(t -> calculateDistanceEuclidean(vec, t.getVector())))
                //.sorted(Comparator.comparing(t -> new PearsonsCorrelation().correlation(vec, ((Token) t).getVector())).reversed())
                .collect(Collectors.toList());
        return collect.subList(0, nrToReturn);
    }

    public static double calculateDistanceEuclidean(double[] array1, double[] array2)
    {
        double Sum = 0.0;
        for(int i=0;i<array1.length;i++) {
            Sum = Sum + Math.pow((array1[i]-array2[i]),2.0);
        }
        return Math.sqrt(Sum);
    }

    public Map<String, double[]> getVectors() {
        return vectors;
    }

    public void setVectors(Map<String, double[]> vectors) {
        this.vectors = vectors;
    }


}
