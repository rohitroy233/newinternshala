package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.FoodItem;

public interface Serviceproduct {
    List<FoodItem> searchProducts(String query);   
}
