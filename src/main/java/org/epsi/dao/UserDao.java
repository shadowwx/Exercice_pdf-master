package org.epsi.dao;

import java.util.List;
import java.util.Optional;

import org.epsi.entity.User;

public interface UserDao {
	public List<User> getUsers();
	public Optional<User> findUserByUserName(String userName);
}
