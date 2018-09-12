package com.mvc.mvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerMvc {


    @RequestMapping("/test")
    public String greeting() {
        return "hello world!";
    }
}