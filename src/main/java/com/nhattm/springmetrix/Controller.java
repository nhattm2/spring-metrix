package com.nhattm.springmetrix;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

@RestController
public class Controller {

    @GetMapping(value = "/test")
    public String test() {
        Date date = new Date();
        System.out.println("test" + new Date());
        return date.toString();
    }

    @GetMapping(value = "/randSleep")
    public String randSleep() {
        int random = new Random().nextInt(100) + 100;
        try {
            Thread.sleep(random);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "sleep " + random;
    }

    @GetMapping(value = "/test1")
    public void test1() {
        Date date = new Date();
        for (int i = 0; i < 1000000; i++) {
            System.out.println("Test 1M: " + new Date());
        }
    }

    @GetMapping(value = "/test2")
    public void test2() {
        Date date = new Date();
        for (int i = 0; i < 1000000000; i++) {
            System.out.println("Test 1B: " + new Date());
        }
    }

    @GetMapping(value = "/test3")
    public void test3(@RequestParam(value = "sleep") int sleep) throws InterruptedException {
        Date date = new Date();
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(sleep);
            for (int j = 0; j < 1000; j++) {
                System.out.println("Test 1B: " + new Date());
            }
        }
    }

    @GetMapping(value = "/test4")
    public void test4(@RequestParam(value = "time") int time, @RequestParam(value = "sleep") int sleep) throws InterruptedException {
        Date date = new Date();
        for (int i = 0; i < time; i++) {
            Thread.sleep(sleep);
            System.out.println("Test 1B: " + new Date());
        }
    }
}
