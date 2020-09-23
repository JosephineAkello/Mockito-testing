package com.example.Mockitotesting.business;

import java.util.Arrays;

import com.example.Mockitotesting.data.SomeDataService;

public class SomeBusinessImpl {

    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public SomeBusinessImpl() {
    }

    public int calculateSum(int[] data){
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
    }

    public int calculateSumUsingDataService(){
        int sum = 0;
        int[] data = someDataService.retrieveAllData();
        for(int value:data){
            sum += value;
        }
        return sum;

//        return Arrays.stream(someDataService.retrieveAllData())
//                .sum()
    }
}
