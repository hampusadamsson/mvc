package com.mvc.mvc;

import com.mvc.domain.Selection;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@RestController
public class ControllerMvc {


    @RequestMapping("/test")
    public String greeting() {
        return "hello world!";
    }


    @RequestMapping(value = "/analyze/{text}", method = GET)
    @ResponseBody
    public Selection random(@PathVariable("text") String text) {
        return new Selection(text);
    }
}