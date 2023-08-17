package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "foodItems")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FoodItem {
 
    private String name;
    private float price;
}
