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
import com.ty.foodapp_boot.FoodOrderApp.dto.User;
import com.ty.foodapp_boot.FoodOrderApp.service.UserService;
import com.ty.foodapp_boot.FoodOrderApp.util.ResponseStructure;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userservice;
	
	@PostMapping
	public ResponseStructure<User> saveUser(@RequestBody User user)
	{
		return userservice.saveUser(user);
	}
	
	@GetMapping
	public ResponseStructure<User> getUserById(@RequestParam int id)
	{
		return userservice.getUserById(id);
	}
	
	@PutMapping
	public ResponseStructure<User> updateUserById(@RequestBody User user,@RequestParam int id)
	{
		return userservice.updateUser(user, id);
	}
	
	@DeleteMapping
	public ResponseStructure<String> deleteUserById(@RequestParam int id) 
	{
		return userservice.deleteUserById(id);
	}
}
