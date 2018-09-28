package org.epsi.service;

import java.util.List;

import org.epsi.entity.User;

//Evolution programme 2.0

public interface UserService {
	public List<User> getUsers();
	

	//public Optional<User> findUserByUserName(String userName);
}
