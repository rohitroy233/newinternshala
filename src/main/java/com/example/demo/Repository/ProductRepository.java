package com.example.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.FoodItem;


@Repository
public interface ProductRepository extends MongoRepository<FoodItem,String>{
    

}
