package com.example.demo.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.codec.language.Soundex;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.Repository.ProductRepository;
import com.example.demo.Service.Serviceproduct;
import com.example.demo.model.FoodItem;

@Service
public class productServiceImpl implements Serviceproduct{

    @Autowired
    private ProductRepository productrepo;

    @Override
    public List<FoodItem> searchProducts(String query) {
        
        Soundex soundex = new Soundex();
        String querySoundex = soundex.encode(query);

        List<FoodItem> allItems = productrepo.findAll();
        List<FoodItem> matchingItems = new ArrayList<>();

        for (FoodItem item : allItems) {
            String itemName = item.getName();
            String itemNameSoundex = soundex.encode(itemName);

            
            if (querySoundex.equals(itemNameSoundex) || isPartialMatch(query, itemName)) {
                matchingItems.add(item);
            }
        }

        return matchingItems;
    }
    public boolean searchProducts2(String query) {
       
            Soundex soundex = new Soundex();
            String querySoundex = soundex.encode(query);
        
            List<FoodItem> allItems = productrepo.findAll();
        
            for (FoodItem item : allItems) {
                String itemName = item.getName();
                String itemNameSoundex = soundex.encode(itemName);
        
                if (querySoundex.equals(itemNameSoundex) || isPartialMatch(query, itemName)) {
                    return true; 
                }
            }
        
            return false; 
        
    }
     private boolean isPartialMatch(String query, String itemName) {
        String[] queryWords = query.split("\\s+");

        StringBuilder regexPatternBuilder = new StringBuilder();
        for (String word : queryWords) {
            regexPatternBuilder.append("(?=.*").append(Pattern.quote(word)).append(")");
        }
        Pattern regexPattern = Pattern.compile(regexPatternBuilder.toString());

        return regexPattern.matcher(itemName).find() ;

    }
}