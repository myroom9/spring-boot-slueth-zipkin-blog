package com.example.sszb.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "target", url = "http://localhost:8081")
public interface TestFeign {
    @GetMapping(value = "/test")
    void sleuthTest();
}
