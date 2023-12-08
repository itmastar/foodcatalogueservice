package com.tdemo.food.catalogue.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemDTO {

    private int id ;
    private String itemName;
    private String itemDescription;
    private boolean isVeg;
    private Number price;
    private Integer restaurantId;
    @Column(nullable = false,columnDefinition = "INT DEFAULT 0")
    private Integer quantity;
}
