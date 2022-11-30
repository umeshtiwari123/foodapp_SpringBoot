package com.ty.foodapp_boot.FoodOrderApp.exception;

public class NoSuchIdPresentForUpdateException extends RuntimeException {

private String message="No Such Id is Present to get Updated in the Database";
	
	public NoSuchIdPresentForUpdateException(String message) {
		this.message=message;
	}
	
	public NoSuchIdPresentForUpdateException() {
		
	}
	
	@Override
	public String getMessage()
	{
		return message;
	}
}
