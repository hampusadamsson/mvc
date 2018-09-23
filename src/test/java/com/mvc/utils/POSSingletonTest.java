package com.mvc.utils;

import com.mvc.domain.POStag;
import org.junit.Test;
import org.springframework.util.Assert;

import java.util.List;

import static com.mvc.utils.Tokenizer.splitTextIntoTokens;
import static org.junit.Assert.*;

public class POSSingletonTest {

    @Test
    public void getInstance() {
        POSSingleton instance = POSSingleton.getInstance();
        Assert.notNull(instance, "not null");
    }

    @Test
    public void getPosTagsFromTokens() {
        POSSingleton posTagger = POSSingleton.getInstance();
        String[] strings = {"hello", "my", "name", "is", "John"};
        List<POStag> tags = posTagger.getPosTagsFromTokens(strings);
        System.out.println("Tag\t:\tProb.\t:\tToken\n---------------------------------------------");
        for(int i=0;i<strings.length;i++){
            System.out.println(tags.get(i).getPosTag()+"\t:\t"+tags.get(i).getProbability()+"\t:\t"+strings[i]);
        }
    }

    @Test
    public void getPosTagsFromTokensWithTokenization() {
        POSSingleton posTagger = POSSingleton.getInstance();
        String[] strings = splitTextIntoTokens("this is a random test with multiple words and some loreum lorum Jakob ipusum s");
        List<POStag> tags = posTagger.getPosTagsFromTokens(strings);
        System.out.println("Tag\t:\tProb.\t:\tToken\n---------------------------------------------");
        for(int i=0;i<strings.length;i++){
            System.out.println(tags.get(i).getPosTag()+"\t:\t"+tags.get(i).getProbability()+"\t:\t"+strings[i]);
        }
    }
}