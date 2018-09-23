package com.mvc.utils;

import com.mvc.domain.POStag;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static com.mvc.Config.Config.PATH_TO_POS_TAGGER;

public class POSSingleton {
    private static POSSingleton ourInstance = new POSSingleton();
    private POSTaggerME posTagger = null;

    public static POSSingleton getInstance() {
        return ourInstance;
    }

    private POSSingleton() {
        InputStream posModelIn = null;
        try {
            posModelIn = new FileInputStream(PATH_TO_POS_TAGGER);
            POSModel posModel = new POSModel(posModelIn);
            this.posTagger = new POSTaggerME(posModel);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<POStag> getPosTagsFromTokens(String[] tokens){
        String tags[] = posTagger.tag(tokens);
        double probs[] = posTagger.probs();
        List<POStag> ptag = new ArrayList<>();
        for (int i = 0; i < tags.length; i++) {
            ptag.add(new POStag(tags[i], probs[i]));
        }
        return ptag;
    }
}
