package org.epsi.service;

import java.util.List;

import org.epsi.entity.User;

public interface UserService {
	public List<User> getUsers();
	
	//Evolution programme 2.0
	//public Optional<User> findUserByUserName(String userName);
}
