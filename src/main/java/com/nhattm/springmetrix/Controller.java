package com.nhattm.springmetrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class Controller {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;


    @GetMapping(value = "/test")
    public String test() {
        Date date = new Date();
        System.out.println("Hello" + new Date());
        return date.toString();
    }

    @GetMapping(value = "/send")
    public String send() {
        Date date = new Date();
        kafkaTemplate.send("baeldung","hehe");

        return date.toString();
    }
}
