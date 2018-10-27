package com.mvc.mvc;

import com.mvc.domain.Selection;
import com.mvc.domain.Token;
import com.mvc.utils.VectorizerSingleton;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@RestController
public class ControllerMvc {


    @CrossOrigin
    @RequestMapping(value = "/analyze/{text}", method = GET)
    @ResponseBody
    public Selection random(@PathVariable("text") String text) {
        return new Selection(text);
    }


    @CrossOrigin
    @RequestMapping(value = "/getSimilarTokens/{text}", method = GET)
    @ResponseBody
    public List<Token> getSimilarTokens(@PathVariable("text") String text) {
        double[] vectorFromString = VectorizerSingleton.getInstance().getVectorFromString(text);
        List<Token> mostSimilarStrings = new ArrayList<>();
        if(!Objects.isNull(vectorFromString)){
            mostSimilarStrings = VectorizerSingleton.getInstance().getMostSimilarStrings(vectorFromString, 10);
        }
        return mostSimilarStrings;
    }

}