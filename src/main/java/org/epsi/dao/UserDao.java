package org.epsi.dao;

import java.util.List;

import org.epsi.entity.User;

public interface UserDao {
	public List<User> getUsers();
	
	//Evolution programme 2.0
	//public Optional<User findUserByUserName(String userName);
}
