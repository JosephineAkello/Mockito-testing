package com.example.Mockitotesting.business;

import com.example.Mockitotesting.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SomeDataServiceStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{1, 2, 3};
    }

    class SomeDataServiceEmptyStub implements SomeDataService {
        @Override
        public int[] retrieveAllData() {
            return new int[]{};
        }

        class SomeDataServiceOneElementStub implements SomeDataService {

            @Override
            public int[] retrieveAllData() {
                return new int[]{5};
            }
        }
    }

    class SomeBusinessImplStubTest {

        @Test
        void calculateSumUsingDataService_basic() {
            SomeBusinessImpl business = new SomeBusinessImpl();
            business.setSomeDataService(new SomeDataServiceStub());
            int actualResults = business.calculateSumUsingDataService();
            int expectedResults = 6;
            assertEquals(expectedResults, actualResults);
        }

        @Test
        void calculateSumUsingDataService_empty() {
            SomeBusinessImpl business = new SomeBusinessImpl();
            business.setSomeDataService(new SomeDataServiceEmptyStub());
            int actualResults = business.calculateSumUsingDataService();
            int expectedResults = 0;
            assertEquals(expectedResults, actualResults);
        }

        @Test
        void calculateSumUsingDataService_onevalue() {
            SomeBusinessImpl business = new SomeBusinessImpl();
            business.setSomeDataService(new SomeDataServiceOneElementStub());
            int actualResults = business.calculateSumUsingDataService();
            int expectedResults = 5;
            assertEquals(expectedResults, actualResults);
        }
    }
}
