package com.ruanko.service;

import com.ruanko.dao.RandomValidateCodeDao;

public class RandomValidateCodeService {
	RandomValidateCodeDao random;
	public RandomValidateCodeService() {
		this.random = new RandomValidateCodeDao();
	}

}
