package com.ruanko.service;

import com.ruanko.dao.UserDao;
import com.ruanko.model.User;

public class UserService {

	UserDao userDao;

	public UserService() {
		this.userDao = new UserDao();// ��ʼ��
	}

	public boolean register(User user) {

		if (userDao.check(user.getUsername()) == false) {
			// �û������ڣ����û���Ϣ�������ݿ�
			user.setImgUrl("images/bg1.jpg");
			return userDao.register(user);

		}
		return false;
	}

	public User login(String username, String password) {
		return userDao.login(username, password);
	}

}
