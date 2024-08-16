package com.biswa.dao;

import com.biswa.entity.User;

public interface UserDAO {
	public boolean UserRegister(User us);
	public User login(String email,String password);
}
