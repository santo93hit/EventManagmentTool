package com.varian.service;

import com.varian.domain.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
