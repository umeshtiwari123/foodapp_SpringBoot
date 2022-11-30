package com.ty.foodapp_boot.FoodOrderApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.foodapp_boot.FoodOrderApp.dao.FoodOrderDao;
import com.ty.foodapp_boot.FoodOrderApp.dto.FoodOrder;
import com.ty.foodapp_boot.FoodOrderApp.dto.Product;
import com.ty.foodapp_boot.FoodOrderApp.exception.NoSuchIdFoundException;
import com.ty.foodapp_boot.FoodOrderApp.exception.NoSuchIdPresentForUpdateException;
import com.ty.foodapp_boot.FoodOrderApp.util.ResponseStructure;

@Service
public class FoodOrderService {

	@Autowired
	FoodOrderDao foodorderdao;
	
	public ResponseStructure<FoodOrder> saveFoodOrder(FoodOrder foodorder)
	{
		ResponseStructure<FoodOrder> responseStructure=new ResponseStructure<FoodOrder>();
		List<Product> list=foodorder.getProducts();
		double totalcost=0;
		for(Product product :list)
		{
			totalcost+=(product.getPrice()*product.getQuantity());
		}
		totalcost+=totalcost*0.18;
		foodorder.setTotalCost(totalcost);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(foodorderdao.saveFoodOrder(foodorder));
		return responseStructure;
	}
	
	public ResponseStructure<FoodOrder> getFoodOrderById(int id)
	{
		ResponseStructure<FoodOrder> responseStructure=new ResponseStructure<FoodOrder>();
		FoodOrder food2=foodorderdao.getFoodOrderById(id);
		if(food2!=null)
		{
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Received");
		responseStructure.setData(foodorderdao.getFoodOrderById(id));
		}
		else throw new NoSuchIdFoundException("Food Order Id is Not Found");
	
		return responseStructure;
	}
	
	public ResponseStructure<String> deleteFoodOrderById(int id)
	{
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(foodorderdao.deleteFoodOrderById(id));
		return responseStructure;
	}

	public ResponseStructure<FoodOrder> updateFoodOrder(FoodOrder foodorder,int id)
	{
		FoodOrder food2=foodorderdao.getFoodOrderById(id);
		ResponseStructure<FoodOrder> responseStructure=new ResponseStructure<FoodOrder>();
		if(food2 !=null)
			{
			foodorder.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(foodorderdao.updateFoodOrder(foodorder));
			
			}
		else	
		throw new NoSuchIdPresentForUpdateException("No Food Order Id is found for Updation");
		return responseStructure;
	}
}
