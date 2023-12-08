package com.tdemo.food.catalogue.controller;

import com.tdemo.food.catalogue.dto.FoodCataloguePage;
import com.tdemo.food.catalogue.dto.FoodItemDTO;
import com.tdemo.food.catalogue.service.FoodCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodCatalogue")
public class FoodCatalogueController {
    @Autowired
    private FoodCatalogueService foodCatalogueService;

    @PostMapping("/addFoodItem")
    public ResponseEntity<FoodItemDTO> saveFoodItem(@RequestBody FoodItemDTO foodItemDTO){
        FoodItemDTO savedFoodItemDTO=foodCatalogueService.saveFoodItem(foodItemDTO);
    return new ResponseEntity<>(savedFoodItemDTO, HttpStatus.CREATED);
    }

    @GetMapping("/fetchRestaurantandFoodItemsById/{restaurantId}")
    public ResponseEntity<FoodCataloguePage> fetchRestaurantandFoodItemsById(@PathVariable Integer restaurantId){
        FoodCataloguePage foodCataloguePage=foodCatalogueService.fetchRestaurantAndFoodItemsById(restaurantId);
        return new ResponseEntity<>(foodCataloguePage,HttpStatus.OK);
    }
}
