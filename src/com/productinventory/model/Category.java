package com.productinventory.model;

public class Category {
	private int categoryId;
	private String categoryName;
	private String status;
	
	
	
	public void setCategoryId(int categoryId)
	{
		this.categoryId=categoryId;
	}
	public int getCategoryId()
	{
		return categoryId;
	}
	
	public void setCategoryName(String categoryName)
	{
		this.categoryName=categoryName;
	}
	public String getCategoryName()
	{
		return categoryName;
	}
	
	public void setStatus(String status)
	{
		this.status=status;
	}
	public String getStatus()
	{
		return status;
	}
	
	@Override
	public String toString()
	{
		return "CategoryId: "+categoryId+" Category Name: "+categoryName+" Status: "+status;
	}
}