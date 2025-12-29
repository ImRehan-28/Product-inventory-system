package com.productinventory.model;
import java.time.LocalDateTime; //Dao handles DB conversion

public class Stock 
{
	private int stockId;
	private int productId;
	private double availableQuantity;
	private double reservedQuantity;
	private LocalDateTime lastUpdated;
	
	public void setStockId(int stockId)
	{
		this.stockId=stockId;
	}
	public int getStockId()
	{
		return stockId;
	}
	
	public void setProductId(int productId)
	{
		this.productId=productId;
	}
	public int getProductId()
	{
		return productId;
	}
	
	public void setAvailableQuantity(double availableQuantity)
	{
		this.availableQuantity=availableQuantity;
	}
	public double getAvailableQuantity()
	{
		return availableQuantity;
	}
	
	public void setReservedQuantity(double reservedQuantity)
	{
		this.reservedQuantity=reservedQuantity;
	}
	public double getReservedQuantity()
	{
		return reservedQuantity;
	}
	
	public void setLastUpdated(LocalDateTime lastUpdated)
	{
	    this.lastUpdated = lastUpdated;
	}
	public LocalDateTime getLastUpdated()
	{
		return lastUpdated;
	}
	
	@Override
	public String toString()
	{
		return "StockId: "+stockId+" Product Id: "+productId+" Available Quantity: "+availableQuantity+" Reserved Quantity: "+reservedQuantity
				+" Last Updated Time: "+lastUpdated;
	}
}