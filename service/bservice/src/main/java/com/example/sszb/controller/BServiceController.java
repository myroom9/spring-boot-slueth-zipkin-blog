package com.example.sszb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class BServiceController {
    @GetMapping(value = "/test")
    public String sleuthTest() {
        log.info("sleuth test");
        log.info("sleuth test2");
        log.info("sleuth test3");
        return "success";
    }
}
