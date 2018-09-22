package com.mvc.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Logger;

public class Vectorizer {
    private final static Logger logger = Logger.getLogger(Vectorizer.class.getName());
    private Map<String, float[]> vectors;

    Vectorizer() {
        this.initVectorizer("/home/hades/IdeaProjects/mvc/src/main/resources/glove.6B.50d.txt");
    }

    Vectorizer(Boolean devMode) {
        if(devMode){
            this.initVectorizer("/home/hades/IdeaProjects/mvc/src/main/resources/glove.6B.50d.TEST.txt");
        }else{
            this.initVectorizer("/home/hades/IdeaProjects/mvc/src/main/resources/glove.6B.50d.txt");
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
            float[] vector = new float[splitLine.length-1];
            for (int j = 0; j < splitLine.length-1; j++) {
                vector[j] = Float.parseFloat(splitLine[j+1]);
            }
            String token = splitLine[0];
            vectors.put(token, vector);
        }
    }

    public float[] getVectorFromString(String token){
        return this.vectors.get(token);
    }


    public Map<String, float[]> getVectors() {
        return vectors;
    }

    public void setVectors(Map<String, float[]> vectors) {
        this.vectors = vectors;
    }


}
