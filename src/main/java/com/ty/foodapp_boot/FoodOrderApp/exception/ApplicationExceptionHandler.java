package com.ty.foodapp_boot.FoodOrderApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ty.foodapp_boot.FoodOrderApp.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(NoSuchIdFoundException.class)
	public  ResponseStructure<String> noSuchIdFoundHandler(NoSuchIdFoundException exception){
		
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("No ID Found");
		responseStructure.setData(exception.getMessage());
		return responseStructure;
	}
	
	
	@ExceptionHandler(NoSuchIdPresentForUpdateException.class)
	public  ResponseStructure<String> noSuchIdPresentForUpdateHandler(NoSuchIdPresentForUpdateException exception){
		
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("No Existing Id to be Updated");
		responseStructure.setData(exception.getMessage());
		return responseStructure;
	}
	
	
}
