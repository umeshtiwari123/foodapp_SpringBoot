package com.ty.foodapp_boot.FoodOrderApp.dao;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodapp_boot.FoodOrderApp.dto.Product;
import com.ty.foodapp_boot.FoodOrderApp.repo.ProductRepository;
@Repository
public class ProductDao {
	
	@Autowired
	ProductRepository productrepository;
	public Product saveProduct(Product product)
	{
		return productrepository.save(product);
	}
	
	public Product updateProduct(Product product)
	{
		return productrepository.save(product);
	}
	
	public Product getProductById(int id)
	{
		Optional<Product> optional=productrepository.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		else
			return null;
	}
	
	public String deleteProductById(int id)
	{
		productrepository.deleteById(id);
		return "deleted";
	}
}
