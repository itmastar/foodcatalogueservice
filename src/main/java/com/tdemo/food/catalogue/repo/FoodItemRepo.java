package com.tdemo.food.catalogue.repo;

import com.tdemo.food.catalogue.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemRepo extends JpaRepository<FoodItem,Integer> {
    List<FoodItem> findByrestaurantId(Integer restaurantId);
}
