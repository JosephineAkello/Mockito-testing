package com.example.Mockitotesting.business;

import com.example.Mockitotesting.data.SomeDataService;

public class SomeBusinessImpl {

    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public SomeBusinessImpl() {
    }

    public int calculateSum(int[] data){
        int sum = 0;
        for(int value:data){
            sum += value;
        }
        return sum;
    }

    public int calculateSumUsingDataService(){
        int sum = 0;
        int[] data = someDataService.retrieveAllData();
        for(int value:data){
            sum += value;
        }
        return sum;
    }
}
