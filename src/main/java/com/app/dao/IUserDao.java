package com.app.dao;

import org.springframework.web.bind.annotation.RequestMapping;

import com.app.model.User;

public interface IUserDao {
	public void saveUser(User user);
	public User findByUserName(String userName);

}
