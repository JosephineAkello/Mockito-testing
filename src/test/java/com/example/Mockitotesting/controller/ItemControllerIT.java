package com.example.Mockitotesting.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() throws Exception{
        String response = this.restTemplate.getForObject(
                "/all-items-from-the-database", String.class);
        JSONAssert.assertEquals("[{id:1000},{id:1001},{id:1002}]",
                response, false);


    }
}
