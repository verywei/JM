package com.ruanko.mapdemo.activity;

import android.app.Activity;

public abstract class BasicActivity extends Activity {
	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// 初始化控件
		initView();
		// 初始化数据
		initDate();
		// 初始化监听
		initListener();
	}

	/**
	 * 初始化控件
	 */
	public abstract void initView();

	/**
	 * 初始化数据
	 */
	public abstract void initDate();

	/**
	 * 初始化监听
	 */
	public abstract void initListener();

}
