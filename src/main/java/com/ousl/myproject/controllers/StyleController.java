package com.ousl.myproject.controllers;

import com.ousl.myproject.models.dto.StyleDto;
import com.ousl.myproject.models.requestResponse.Response;
import com.ousl.myproject.services.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/styles")
public class StyleController {
    @Autowired
    private StyleService styleService;

    @CrossOrigin(origins = "*")
    @GetMapping("/getAll")
    public Response getStylesList(){
        return this.styleService.getAllStyles();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/createStyle")
    public void createStyle(@RequestBody StyleDto[] styleDto){
        //this.styleService.createStyle(styleDto);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/deleteStyle")
    public Response deleteStyle(@RequestBody StyleDto styleDto){
        return this.styleService.deleteStyle(styleDto);
    }

}
