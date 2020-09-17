package com.example.Mockitotesting.spike;

import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse = "{\"id\": 1,\"name\":\"Baaay\",\"price\":10,\"quantity\":100}";

    @Test
    public void jsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws Exception{
        String expectedResults = "{\"id\": 1,\"name\":\"Baaay\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResults, actualResponse, true);
    }

    @Test
    public void jsonAssert_StrictFalse() throws Exception{
        String expectedResults = "{\"id\": 1,\"name\":\"Baaay\",\"price\":10}";
        JSONAssert.assertEquals(expectedResults, actualResponse, false);
    }
    @Test
    public void jsonAssert_WithoutEscapeCharacters() throws Exception{
        String expectedResults = "{id: 1,name:Baaay,price:10}";
        JSONAssert.assertEquals(expectedResults, actualResponse, false);
    }
}
