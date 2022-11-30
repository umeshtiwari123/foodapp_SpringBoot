package com.ty.foodapp_boot.FoodOrderApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.foodapp_boot.FoodOrderApp.dao.UserDao;
import com.ty.foodapp_boot.FoodOrderApp.dto.User;
import com.ty.foodapp_boot.FoodOrderApp.exception.NoSuchIdFoundException;
import com.ty.foodapp_boot.FoodOrderApp.exception.NoSuchIdPresentForUpdateException;
import com.ty.foodapp_boot.FoodOrderApp.util.ResponseStructure;

@Service
public class UserService {

	@Autowired
	UserDao userdao;
	
	public ResponseStructure<User> saveUser(User user)
	{
		ResponseStructure<User> responseStructure=new ResponseStructure<User>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(userdao.saveUser(user));
		return responseStructure;
	}
	
	public ResponseStructure<User> getUserById(int id)
	{
		ResponseStructure<User> responseStructure=new ResponseStructure<User>();
		User user2=userdao.getUserById(id);
		if(user2!=null)
		{
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Received");
		responseStructure.setData(userdao.getUserById(id));
		
		}
		else throw new NoSuchIdFoundException("Id Not Found");
		return responseStructure;
	}
	
	public ResponseStructure<String> deleteUserById(int id)
	{
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(userdao.deleteUserById(id));
		return responseStructure;
	}

	public ResponseStructure<User> updateUser(User user,int id)
	{
		User user2=userdao.getUserById(id);
		ResponseStructure<User> responseStructure=new ResponseStructure<User>();
		if(user2 !=null)
			{
			user.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(userdao.saveUser(user));
			}
		else	
		throw new NoSuchIdPresentForUpdateException("No Mechanism found for Updation");
		return responseStructure;
	}
}
