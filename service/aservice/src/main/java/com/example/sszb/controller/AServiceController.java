package com.example.sszb.controller;

import com.example.sszb.service.AServiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AServiceController {
    private final AServiceService aServiceService;

    @GetMapping(value = "/test")
    public String test() {
        log.info("test");
        aServiceService.testSleuth();

        return "success";
    }
}
