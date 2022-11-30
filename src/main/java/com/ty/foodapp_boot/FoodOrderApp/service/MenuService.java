package com.ty.foodapp_boot.FoodOrderApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.foodapp_boot.FoodOrderApp.dao.MenuDao;
import com.ty.foodapp_boot.FoodOrderApp.dto.Menu;
import com.ty.foodapp_boot.FoodOrderApp.exception.NoSuchIdFoundException;
import com.ty.foodapp_boot.FoodOrderApp.exception.NoSuchIdPresentForUpdateException;
import com.ty.foodapp_boot.FoodOrderApp.util.ResponseStructure;

@Service
public class MenuService {
	@Autowired
	MenuDao menudao;
	
	public ResponseStructure<Menu> saveMenu(Menu menu)
	{
		ResponseStructure<Menu> responseStructure=new ResponseStructure<Menu>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(menudao.saveMenu(menu));
		return responseStructure;
	}
	
	public ResponseStructure<Menu> getMenuById(int id)
	{
		ResponseStructure<Menu> responseStructure=new ResponseStructure<Menu>();
		Menu menu2=menudao.getMenuById(id);
		if(menu2!=null)
		{
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Received");
		responseStructure.setData(menudao.getMenuById(id));
		return responseStructure;
		}
		else throw new NoSuchIdFoundException("Menu Id Not Found");
	}
	
	public ResponseStructure<String> deleteMenuById(int id)
	{
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(menudao.deleteMenuById(id));
		return responseStructure;
	}

	public ResponseStructure<Menu> updateMenu(Menu menu,int id)
	{
		Menu menu2=menudao.getMenuById(id);
		ResponseStructure<Menu> responseStructure=new ResponseStructure<Menu>();
		if(menu2 !=null)
			{
			menu.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(menudao.updateMenu(menu));
			return responseStructure;
			
			}

		else	
		throw new NoSuchIdPresentForUpdateException("No Menu Id is found for Updation");
	}

}
