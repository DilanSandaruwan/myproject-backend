package com.ousl.myproject.controllers;

import com.ousl.myproject.models.requestResponse.Response;
import com.ousl.myproject.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @CrossOrigin(origins = "*")
    @GetMapping("/getAll")
    public Response getItemList(){
        System.out.println("");
        return this.itemService.getItems();
    }
}
