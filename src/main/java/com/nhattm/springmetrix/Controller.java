package com.nhattm.springmetrix;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class Controller {
    @GetMapping(value = "/test")
    public String test() {
        Date date = new Date();
        System.out.println("Hello" + new Date());
        return date.toString();
    }
}
