package com.productinventory.model;
import java.time.LocalDateTime;

public class User {
	private int userId;
	private String username;
	private String password;
	private String role;
	private String email;
	private String status;
	private LocalDateTime createdAt;
	
	public void setUserId(int userId)
	{
		this.userId=userId;
	}
	public int getUserId()
	{
		return userId;
	}
	
	public void setUsername(String username)
	{
		this.username=username;
	}
	public String getUsername()
	{
		return username;
	}
	
	public void setPassword(String password)
	{
		this.password=password;
	}
	public String getPassword()
	{
		return password;
	}
	
	public void setRole(String role)
	{
		this.role=role;
	}
	public String getRole()
	{
		return role;
	}
	
	public void setEmail(String email)
	{
		this.email=email;
	}
	public String getEmail()
	{
		return email;
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
	
	public String toString()
	{
		return " User Id: "+userId+" UserName: "+username+" Role: "+role
				+" Email: "+email+" Status: "+status+" created At: "+createdAt;
	}
}