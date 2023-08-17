package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Service.Serviceproduct;
import org.springframework.http.MediaType;
import com.example.demo.model.FoodItem;


@RestController
@RequestMapping(value = "/api/v1/products", produces = MediaType.APPLICATION_JSON_VALUE)

@CrossOrigin("*")
public class ProductController{
    @Autowired
    private Serviceproduct productService;

    @GetMapping("/search")
    public List<FoodItem> searchProducts(@RequestParam("query") String query){
        List<FoodItem> results =productService.searchProducts(query);
        return (results);
    
       
    }
}
  

