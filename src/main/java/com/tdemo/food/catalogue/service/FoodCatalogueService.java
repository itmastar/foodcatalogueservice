package com.tdemo.food.catalogue.service;

import com.tdemo.food.catalogue.dto.FoodCataloguePage;
import com.tdemo.food.catalogue.dto.FoodItemDTO;
import com.tdemo.food.catalogue.dto.Restaurant;
import com.tdemo.food.catalogue.entity.FoodItem;
import com.tdemo.food.catalogue.mapper.FoodItemMapper;
import com.tdemo.food.catalogue.repo.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class FoodCatalogueService {
    @Autowired
    private FoodItemRepo foodItemRepo;
    @Autowired
    private RestTemplate restTemplate;

    public FoodItemDTO saveFoodItem(FoodItemDTO foodItemDTO) {
       FoodItem foodItem= foodItemRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDTO));
      return FoodItemMapper.INSTANCE.foodItemToFoodItemDTO(foodItem);
    }

    public FoodCataloguePage fetchRestaurantAndFoodItemsById(Integer restaurantId) {

        //food Item Lists
       List<FoodItem> foodItemList= fetchfoodItemsList(restaurantId);
        //Restaurant details
        Restaurant restaurant=fetchRestaurantDetailsFromRestaurantMS(restaurantId);

       return createFoodCataloguePage(foodItemList,restaurant);

    }

    private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {
      FoodCataloguePage foodCataloguePage=new FoodCataloguePage();
    foodCataloguePage.setFoodItemList(foodItemList);
    foodCataloguePage.setRestaurant(restaurant);
    return foodCataloguePage;
    }

    private Restaurant fetchRestaurantDetailsFromRestaurantMS(Integer restaurantId) {
       return  restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/fetchRestaurantById/" + restaurantId, Restaurant.class);
    }

    private List<FoodItem> fetchfoodItemsList(Integer restaurantId) {
       return foodItemRepo.findByrestaurantId(restaurantId);
    }
}
