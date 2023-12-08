package com.tdemo.food.catalogue.mapper;

import com.tdemo.food.catalogue.dto.FoodItemDTO;
import com.tdemo.food.catalogue.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {
    FoodItemMapper INSTANCE= Mappers.getMapper(FoodItemMapper.class);
    FoodItemDTO foodItemToFoodItemDTO(FoodItem foodItem);
    FoodItem mapFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO);

}
