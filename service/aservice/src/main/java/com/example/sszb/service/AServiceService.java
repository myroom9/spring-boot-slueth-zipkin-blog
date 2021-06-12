package com.example.sszb.service;

import com.example.sszb.api.TestFeign;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AServiceService {
    private final TestFeign testFeign;

    public void testSleuth() {
        log.info("test2");
        testFeign.sleuthTest();
    }
}
