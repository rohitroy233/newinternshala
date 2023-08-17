package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Service.Serviceproduct;

import com.example.demo.model.FoodItem;


@RestController
@RequestMapping("/api/v1/products")
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
  

