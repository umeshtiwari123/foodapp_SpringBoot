package com.ty.foodapp_boot.FoodOrderApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodapp_boot.FoodOrderApp.dto.Items;
import com.ty.foodapp_boot.FoodOrderApp.repo.ItemsRepository;

@Repository
public class ItemsDao {

	@Autowired
	ItemsRepository itemsrepository;
	
	public Items saveItems(Items items)
	{
		return itemsrepository.save(items);
	}
	
	public Items updateItems(Items items)
	{
		return itemsrepository.save(items);
	}
	
	public Items getItemsById(int id)
	{
		Optional<Items> optional=itemsrepository.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		else
			return null;
	}

	public String deleteItemsById(int id)
	{
		itemsrepository.deleteById(id);
		return "deleted";
	}
}
