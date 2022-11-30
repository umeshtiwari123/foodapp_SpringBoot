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

import com.ty.foodapp_boot.FoodOrderApp.dto.Items;
import com.ty.foodapp_boot.FoodOrderApp.service.ItemsService;
import com.ty.foodapp_boot.FoodOrderApp.util.ResponseStructure;

@RestController
@RequestMapping("items")
public class ItemsController {

	@Autowired
	ItemsService itemservice;

	@PostMapping
	public ResponseStructure<Items> saveItems(@RequestBody Items item)
	{
		return itemservice.saveItem(item);
	}
	
	@GetMapping
	public ResponseStructure<Items> getItemsById(@RequestParam int id)
	{
		return itemservice.getItemById(id);
	}
	
	@PutMapping
	public ResponseStructure<Items> updateItemsById(@RequestBody Items item,@RequestParam int id)
	{
		return itemservice.updateItems(item, id);
	}
	
	@DeleteMapping
	public ResponseStructure<String> deleteItemsById(@RequestParam int id) 
	{
		return itemservice.deleteItemsById(id);
	}
	
}
