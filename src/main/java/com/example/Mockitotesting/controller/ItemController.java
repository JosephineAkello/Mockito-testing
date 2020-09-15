package com.example.Mockitotesting.controller;

import com.example.Mockitotesting.model.Item;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class ItemController {

    @GetMapping("/dummy-item")
    public Item Dummy_items(){
        return new Item(1,"Baaay", 10, 100);
    }
}

