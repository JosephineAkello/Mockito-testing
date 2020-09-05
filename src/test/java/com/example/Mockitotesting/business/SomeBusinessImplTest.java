package com.example.Mockitotesting.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeBusinessImplTest {

    @Test
    void calculateSum_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResults = business.calculateSum(new int[]{1, 2, 3});
        int expectedResults = 6;
        assertEquals(expectedResults, actualResults);
    }
    @Test
    void calculateSum_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResults = business.calculateSum(new int[]{});
        int expectedResults = 0;
        assertEquals(expectedResults, actualResults);
    }
    @Test
    void calculateSum_onevalue() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResults = business.calculateSum(new int[]{5});
        int expectedResults = 5;
        assertEquals(expectedResults, actualResults);
    }
}
