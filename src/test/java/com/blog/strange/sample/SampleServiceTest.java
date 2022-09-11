package com.blog.strange.sample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SampleServiceTest {

    @Autowired
    SampleService sampleService;

    @Test
    void sampleAll() throws Exception {
        System.out.println("test");
        for(Sample s : sampleService.findAllSample()){
            System.out.println("===");
            System.out.println(s.toString());
        }
    }

    @Test
    void sampleFindbyId() throws Exception {
        System.out.println("test");
        System.out.println(sampleService.findSampleDetail(2L).toString());

    }
}