package com.productinventory.dao;

import java.util.List;
import com.productinventory.model.User;

public interface UserDAO {
	
	boolean addUser(User user);
	boolean updateUser(User user);
	boolean deleteUser(int userId);
	User getUserById(int userId);
	List<User> getAllUsers();
}