package org.epsi.service;

import java.util.List;
import java.util.Optional;

import org.epsi.entity.User;

public interface UserService {
	public List<User> getUsers();
	public Optional<User> findUserByUserName(String userName);
}
