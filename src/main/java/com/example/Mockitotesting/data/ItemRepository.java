package com.example.Mockitotesting.data;

import com.example.Mockitotesting.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item, Integer> {
}
