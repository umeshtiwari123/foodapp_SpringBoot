package com.ty.foodapp_boot.FoodOrderApp.dao;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodapp_boot.FoodOrderApp.dto.Menu;
import com.ty.foodapp_boot.FoodOrderApp.repo.MenuRepository;

@Repository
public class MenuDao {

	@Autowired
	MenuRepository menurepository;
	
	public Menu saveMenu(Menu menu)
	{
		return menurepository.save(menu);
	}
	
	public Menu updateMenu(Menu menu)
	{
		return menurepository.save(menu);
	}
	
	public Menu getMenuById(int id)
	{
		Optional<Menu> optional=menurepository.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		else
			return null;
	}

	public String deleteMenuById(int id)
	{
		menurepository.deleteById(id);
		return "deleted";
	}
}
