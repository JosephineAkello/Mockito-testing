package com.example.Mockitotesting.controller;

import java.util.Arrays;

import com.example.Mockitotesting.model.Item;
import com.example.Mockitotesting.service.ItemBusinessService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)
class ItemControllerTest {


        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private ItemBusinessService businessService;

        @Test
        public void dummyItem_basic() throws Exception {
            RequestBuilder requestBuilder = MockMvcRequestBuilders
                    .get("/dummy-item")
                    .accept(MediaType.APPLICATION_JSON);
            MvcResult mvcResult = mockMvc.perform(requestBuilder)
                    .andExpect(status().isOk())
                    .andExpect(content().json(
                            "{\"id\": 1,\"name\":\"Baaay\",\"price\":10,\"quantity\":100}"))
                    .andReturn();

        }

    @Test
    public void item_FromBusinessSrvice() throws Exception {

            when(businessService.retrieveHadCodedItem()).thenReturn(
                    new Item(2, "Item2", 10,10));
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/item-fom-business-service")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{id:2,name:Item2,price:10,quantity:10}"))
                .andReturn();

    }
    @Test
    public void retrieveAllItems_basic() throws Exception {

        when(businessService.retrieveAllItems()).thenReturn(
                Arrays.asList(new Item(2, "Item2", 10,10),
               new Item(3, "Item3", 20,30)));
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/all-items-from-the-database")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "[{id:2,name:Item2,price:10,quantity:10},{id:3,name:Item3,price:20,quantity:30}]"))
                .andReturn();

    }
    }

