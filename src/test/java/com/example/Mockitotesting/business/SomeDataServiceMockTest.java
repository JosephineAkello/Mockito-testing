package com.example.Mockitotesting.business;

import com.example.Mockitotesting.data.SomeDataService;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SomeDataServiceMockTest  {

    SomeBusinessImpl business = new SomeBusinessImpl();
    SomeDataService dataServiceMock = mock(SomeDataService.class);


    @Before
    public void before(){
        business.setSomeDataService(dataServiceMock);
    }

        @Test
        void calculateSumUsingDataService_basic() {
            when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{1, 2, 3});
            int expectedResults = 6;
            assertEquals(expectedResults, business.calculateSumUsingDataService());
        }

        @Test
        void calculateSumUsingDataService_empty() {
            when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
            assertEquals(0, business.calculateSumUsingDataService());
        }

        @Test
        void calculateSumUsingDataService_onevalue() {
            when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{5});
            assertEquals(5, business.calculateSumUsingDataService());
        }
    }

