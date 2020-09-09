package com.example.Mockitotesting.business;

import com.example.Mockitotesting.data.SomeDataService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SomeDataServiceMockTest  {

    @InjectMocks
    SomeBusinessImpl business = new SomeBusinessImpl();

    @Mock
    SomeDataService dataServiceMock;

        @Test
        void calculateSumUsingDataService_basic() {
            when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{1, 2, 3});
            assertEquals(6, business.calculateSumUsingDataService());
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

