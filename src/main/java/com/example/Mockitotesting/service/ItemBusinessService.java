package com.example.Mockitotesting.service;

import com.example.Mockitotesting.model.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemBusinessService {
    public Item retrieveHadCodedItem() {
        return new Item(1,"Baaay", 10, 100);
    }
}
