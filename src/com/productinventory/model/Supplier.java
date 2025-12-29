package com.productinventory.model;
import java.time.LocalDateTime; 
public class Supplier {
	private int supplierId;
	private String name;
	private String emailAddress;
	private Long phno;
	private String status;
	private LocalDateTime createdAt;
	
	public void setSupplierId(int supplierId)
	{
		this.supplierId=supplierId;
	}
	public int getSupplierId()
	{
		return supplierId;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	
	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress=emailAddress;
	}
	public String getEmailAddress()
	{
		return emailAddress;
	}
	
	public void setPhno(Long phno)
	{
		this.phno=phno;
	}
	public Long getPhno()
	{
		return phno;
	}
	
	public void setStatus(String status)
	{
		this.status=status;
	}
	public String getStatus()
	{
		return status;
	}
	
	public void setCreatedAt(LocalDateTime createdAt)
	{
		this.createdAt=createdAt;
	}
	public LocalDateTime getCreatedAt()
	{
		return createdAt;
	}
	@Override
	public String toString()
	{
		return "Supplier Id: "+supplierId+" Name: "+name+" Email Address: "+emailAddress+" Phone No: "+phno
				+" Status: "+status+" created At: "+createdAt;
	}
}