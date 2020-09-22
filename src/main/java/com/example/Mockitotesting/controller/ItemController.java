package com.example.Mockitotesting.controller;

import java.util.List;

import com.example.Mockitotesting.model.Item;
import com.example.Mockitotesting.service.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class ItemController {


    @Autowired
    private ItemBusinessService businessService;


    @GetMapping("/dummy-item")
    public Item Dummy_items(){

        return new Item(1,"Baaay", 10, 100);
    }

    @GetMapping("/item-fom-business-service")
    public Item ItemFromBusinessService(){
        return businessService.retrieveHadCodedItem();
    }

    @GetMapping("/all-items-from-the-database")
    public List<Item>  retrieveAllItems(){
        return businessService.retrieveAllItems();
    }
}

