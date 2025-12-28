package com.productinventory.model;
public class Product
{
	private int productId;
	private String productName;
	private int quantity;
	private double price;
	
	public void setProductId(int productId)
	{
		this.productId=productId;
	}
	
	public void setProductName()
	{
		this.productName=productName;
	}
	public void setQuantity()
	{
		this.quantity=quantity;
	}
	public void setPrice()
	{
		this.price=price;
	}
	
	public int getProductId()
	{
		return productId;
	}
	
	public String getProductName()
	{
		return productName;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public double getPrice()
	{
		return price;
	}
}
