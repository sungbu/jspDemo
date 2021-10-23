package net.hnjdzy.service;

import net.hnjdzy.dao.UserDao;
import net.hnjdzy.entity.User;

public class UserService {
	
	public boolean login(User user) {
		UserDao ud = new UserDao();
		return ud.getUserInfo(user);
	}

}
