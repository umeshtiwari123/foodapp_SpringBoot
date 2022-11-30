package com.ty.foodapp_boot.FoodOrderApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.foodapp_boot.FoodOrderApp.dao.ProductDao;
import com.ty.foodapp_boot.FoodOrderApp.dto.Product;
import com.ty.foodapp_boot.FoodOrderApp.exception.NoSuchIdFoundException;
import com.ty.foodapp_boot.FoodOrderApp.exception.NoSuchIdPresentForUpdateException;
import com.ty.foodapp_boot.FoodOrderApp.util.ResponseStructure;

@Service
public class ProductService {

	@Autowired
	ProductDao productdao;
	
	public ResponseStructure<Product> saveProduct(Product product)
	{
		ResponseStructure<Product> responseStructure=new ResponseStructure<Product>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(productdao.saveProduct(product));
		return responseStructure;
	}
	
	public ResponseStructure<Product> getProductById(int id)
	{
		ResponseStructure<Product> responseStructure=new ResponseStructure<Product>();
		Product product2=productdao.getProductById(id);
		if(product2!=null)
		{
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Received");
		responseStructure.setData(productdao.getProductById(id));
		
		}
		else throw new NoSuchIdFoundException("Product Id Not Found");
		return responseStructure;
	}
	
	public ResponseStructure<String> deleteProductById(int id)
	{
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(productdao.deleteProductById(id));
		return responseStructure;
	}

	public ResponseStructure<Product> updateProduct(Product product,int id)
	{
		Product product2=productdao.getProductById(id);
		ResponseStructure<Product> responseStructure=new ResponseStructure<Product>();
		if(product2 !=null)
			{
			product2.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(productdao.updateProduct(product));
			}
		else	
		throw new NoSuchIdPresentForUpdateException("No ProductId found for Updation");
		return responseStructure;
	}
}
