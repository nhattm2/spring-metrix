package com.nhattm.springmetrix;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageApi {

    private final SimpleProducer simpleProducer;

    public MessageApi(SimpleProducer simpleProducer) {
        this.simpleProducer = simpleProducer;
    }

    @GetMapping("/message/{message}")
    public ResponseEntity<String> message(@PathVariable(value = "message") String message) {
        simpleProducer.send(message);
        return ResponseEntity.ok("Message received: " + message);
    }
}