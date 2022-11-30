package com.ty.foodapp_boot.FoodOrderApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodapp_boot.FoodOrderApp.dto.User;
import com.ty.foodapp_boot.FoodOrderApp.repo.UserRepository;

@Repository
public class UserDao {

	@Autowired
	UserRepository userrepository;
	
	public User saveUser(User user)
	{
		return userrepository.save(user);
	}
	public User updateUser(User user)
	{
		return userrepository.save(user);
	}
	
	public User getUserById(int id)
	{
		Optional<User> optional=userrepository.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		else
			return null;
	}

	public String deleteUserById(int id)
	{
		userrepository.deleteById(id);
		return "deleted";
	}
}
