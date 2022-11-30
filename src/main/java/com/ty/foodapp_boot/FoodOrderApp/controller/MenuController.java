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

import com.ty.foodapp_boot.FoodOrderApp.dto.Menu;
import com.ty.foodapp_boot.FoodOrderApp.service.MenuService;
import com.ty.foodapp_boot.FoodOrderApp.util.ResponseStructure;

@RestController
@RequestMapping("menu")
public class MenuController {

	@Autowired
	private MenuService menuservice;

	@PostMapping
	public ResponseStructure<Menu> saveMenu(@RequestBody Menu menu)
	{
		return menuservice.saveMenu(menu);
	}
	
	@GetMapping
	public ResponseStructure<Menu> getMenuById(@RequestParam int id)
	{
		return menuservice.getMenuById(id);
	}
	
	@PutMapping
	public ResponseStructure<Menu> updateMenuById(@RequestBody Menu menu,@RequestParam int id)
	{
		return menuservice.updateMenu(menu, id);
	}
	
	@DeleteMapping
	public ResponseStructure<String> deleteMenuById(@RequestParam int id) 
	{
		return menuservice.deleteMenuById(id);
	}
	
}
