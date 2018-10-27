package com.mvc.Config;

public class Config {

    public static final Boolean DEV_MODE = true;

    public static final String LANGUAGE = "en";
    public static final String PATH_TO_WORDEMBEDDINGS = "/home/hades/IdeaProjects/AnnotatorService/AnnotatorService/src/main/resources/wordEmbeddings/glove.6B.50d.txt";
    public static final String PATH_TO_WORDEMBEDDINGS_TEST = "/home/hades/IdeaProjects/AnnotatorService/AnnotatorService/src/main/resources/wordEmbeddings/glove.6B.50d.TEST.txt";
    public static final String PATH_TO_POS_TAGGER = "/home/hades/IdeaProjects/AnnotatorService/AnnotatorService/src/main/resources/models/" + LANGUAGE + "/" + LANGUAGE + "-pos-maxent.bin";

}

