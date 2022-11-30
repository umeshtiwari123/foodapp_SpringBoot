package com.ty.foodapp_boot.FoodOrderApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodapp_boot.FoodOrderApp.dto.FoodOrder;
import com.ty.foodapp_boot.FoodOrderApp.repo.FoodOrderRepository;

@Repository
public class FoodOrderDao {

	@Autowired
	FoodOrderRepository foodorderrepository;
	
	public FoodOrder saveFoodOrder(FoodOrder foodorder)
	{
		return foodorderrepository.save(foodorder);
	}
	
	public FoodOrder updateFoodOrder(FoodOrder foodorder)
	{
		return foodorderrepository.save(foodorder);
	}
	
	public FoodOrder getFoodOrderById(int id)
	{
		Optional<FoodOrder> optional=foodorderrepository.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		else
			return null;
	}

	public String deleteFoodOrderById(int id)
	{
		foodorderrepository.deleteById(id);
		return "deleted";
	}
}
