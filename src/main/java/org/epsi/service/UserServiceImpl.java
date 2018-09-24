package org.epsi.service;

import java.util.List;

import org.epsi.dao.UserDao;
import org.epsi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Transactional(readOnly=true)
	public List<User> getUsers()
	{
		return userDao.getUsers();
	}

	//Evolution programme 2.0
	//???
//	@Transactional(readOnly=true)
//	public Optional<User> findUserByUserName(String userName) {
//		return userDao.findUserByUserName(userName);
//	}
}
