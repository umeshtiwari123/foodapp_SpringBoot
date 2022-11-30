package com.ty.foodapp_boot.FoodOrderApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.foodapp_boot.FoodOrderApp.dto.FoodOrder;
import com.ty.foodapp_boot.FoodOrderApp.service.FoodOrderService;
import com.ty.foodapp_boot.FoodOrderApp.util.ResponseStructure;

@RestController
@RequestMapping("foodorder")
public class FoodOrderController {

	@Autowired
	FoodOrderService foodorderservice;

	@PostMapping
	public ResponseStructure<FoodOrder> saveFoodOrder(@RequestBody FoodOrder foodorder)
	{
		return foodorderservice.saveFoodOrder(foodorder);
	}
	
	@GetMapping
	public ResponseStructure<FoodOrder> getFoodOrderById(@RequestParam int id)
	{
		return foodorderservice.getFoodOrderById(id);
	}
	
	@PutMapping
	public ResponseStructure<FoodOrder> updateFoodOrderById(@RequestBody FoodOrder foodorder,@RequestParam int id)
	{
		return foodorderservice.updateFoodOrder(foodorder, id);
	}
	
	@DeleteMapping
	public ResponseStructure<String> deleteFoodOrderById(@RequestParam int id) 
	{
		return foodorderservice.deleteFoodOrderById(id);
	}
	
}

