package com.productinventory.dao;

import java.util.List;
import com.productinventory.model.User;

public interface UserDAO {
	
	boolean addUser(User user);
	boolean UpdateUser(User user);
	boolean deleteUser(int userId);
	User getUserId(int userId);
	List<User> getAllUsers();
}
