package com.example.Mockitotesting.service;

import java.util.List;

import com.example.Mockitotesting.data.ItemRepository;
import com.example.Mockitotesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemBusinessService {

    @Autowired
    private ItemRepository repository;

    public Item retrieveHadCodedItem() {
        return new Item(1,"Baaay", 10, 100);
    }

    public List<Item> retrieveAllItems(){
        List<Item> items = repository.findAll();
        for(Item item:items){
            item.setValue(item.getPrice() * item.getQuantity());
        }
       return repository.findAll();
    }

}
