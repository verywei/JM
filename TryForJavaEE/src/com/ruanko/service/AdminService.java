package com.ruanko.service;

import com.ruanko.dao.AdminDao;
import com.ruanko.model.Admin;

public class AdminService {
	AdminDao adminDao;

	public AdminService() {
		this.adminDao=new AdminDao();
	}
	
	public Admin login(String username, String password) {
		return adminDao.login(username, password);
	}

}
