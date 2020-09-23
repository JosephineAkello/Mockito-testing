package com.example.Mockitotesting.business;

import java.util.Arrays;
import java.util.List;

import com.example.Mockitotesting.data.ItemRepository;
import com.example.Mockitotesting.data.SomeDataService;
import com.example.Mockitotesting.model.Item;
import com.example.Mockitotesting.service.ItemBusinessService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceTest {

    @InjectMocks
    private ItemBusinessService business;

    @Mock
    private ItemRepository repository;

        @Test
        public void retriveAllItems_basic() {
            when(repository.findAll()).thenReturn(
                    Arrays.asList(new Item(2, "Item2", 10,10),
                            new Item(3, "Item3", 20,30)));
            List<Item> items = business.retrieveAllItems();
            assertEquals(100, items.get(0).getValue());
            assertEquals(600, items.get(1).getValue());
        }

    }

