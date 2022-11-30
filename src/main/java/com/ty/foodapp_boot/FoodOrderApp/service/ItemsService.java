package com.ty.foodapp_boot.FoodOrderApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.foodapp_boot.FoodOrderApp.dao.ItemsDao;
import com.ty.foodapp_boot.FoodOrderApp.dto.Items;
import com.ty.foodapp_boot.FoodOrderApp.exception.NoSuchIdFoundException;
import com.ty.foodapp_boot.FoodOrderApp.exception.NoSuchIdPresentForUpdateException;
import com.ty.foodapp_boot.FoodOrderApp.util.ResponseStructure;

@Service
public class ItemsService {

	@Autowired
	ItemsDao itemsdao;
	
	public ResponseStructure<Items> saveItem(Items item)
	{
		ResponseStructure<Items> responseStructure=new ResponseStructure<Items>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(itemsdao.saveItems(item));
		return responseStructure;
	}
	
	public ResponseStructure<Items> getItemById(int id)
	{
		ResponseStructure<Items> responseStructure=new ResponseStructure<Items>();
		Items item2=itemsdao.getItemsById(id);
		if(item2!=null)
		{
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Received");
		responseStructure.setData(itemsdao.getItemsById(id));
		return responseStructure;
		}
		else throw new NoSuchIdFoundException("Items Id Not Found");
	}
	
	public ResponseStructure<String> deleteItemsById(int id)
	{
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(itemsdao.deleteItemsById(id));
		return responseStructure;
	}

	public ResponseStructure<Items> updateItems(Items item,int id)
	{
		Items item2=itemsdao.getItemsById(id);
		ResponseStructure<Items> responseStructure=new ResponseStructure<Items>();
		if(item2 !=null)
			{
			item.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(itemsdao.updateItems(item));
			return responseStructure;
			
			}

		else	
		throw new NoSuchIdPresentForUpdateException("No Item Id is found for Updation");
	}
}
