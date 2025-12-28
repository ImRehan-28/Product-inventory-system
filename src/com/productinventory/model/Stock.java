package com.productinventory.model;
import java.time.LocalDateTime; //Dao handles DB conversion

public class Stock 
{
	private double stockId;
	private int productId;
	private double availableQuantity;
	private double reservedQuantity;
	private LocalDateTime lastUpdated;
	
	public void setStockId(double stockId)
	{
		this.stockId=stockId;
	}
	public double getStockId()
	{
		return stockId;
	}
	
	public void setProductId(double stockId)
	{
		this.stockId=stockId;
	}
	public double getProductId()
	{
		return productId;
	}
	
	public void setavailableQuantity(double availableQuantity)
	{
		this.availableQuantity=availableQuantity;
	}
	public double getavailableQuantity()
	{
		return availableQuantity;
	}
	
	public void setreservedQuantity(double reservedQuantity)
	{
		this.reservedQuantity=reservedQuantity;
	}
	public double getreservedQuantity()
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
		return "StockId: "+stockId+" Product Id: "+productId+" Available Quantity: "+availableQuantity+"Reserved Quantity: "+reservedQuantity
				+"Last Updated Time: "+lastUpdated;
	}
}