package com.productinventory.model;
public class Product
{
	private int productId;
	private String productName;
	private double quantity;
	private double price;
	private int supplierId;
	private String status;
	
	public Product(int productId,String productName,double quantity,double price,int supplierId,String status)
	{
		setProductId(productId);
		setProductName(productName);
		setQuantity(quantity);
		setPrice(price);
		setSupplierId(supplierId);
		setStatus(status);
	}
	public Product()
	{
		
	}
	
	public void setProductId(int productId)
	{
		this.productId=productId;
	}
	public void setProductName(String productName)
	{
		this.productName=productName;
	}
	public void setQuantity(double quantity)
	{
		this.quantity=quantity;
	}
	public void setPrice(double price)
	{
		this.price=price;
	}
	public void setSupplierId(int supplierId)
	{
		this.supplierId=supplierId;
	}
	public void setStatus(String status)
	{
		this.status=status;
	}

	public int getProductId()
	{
		return productId;
	}
	public String getProductName()
	{
		return productName;
	}
	public double getQuantity()
	{
		return quantity;
	}
	public double getPrice()
	{
		return price;
	}
	public int getSupplierId()
	{
		return supplierId;
	}
	public String getStatus()
	{
		return status;
	}
	
	@Override
	public String toString()
	{
		return "Product Name: "+productName+" Product Id: "+productId+" Quantity: "+quantity+" Price: "+price+" Status: "+status+" Supplier Id: "+supplierId;
	}
}