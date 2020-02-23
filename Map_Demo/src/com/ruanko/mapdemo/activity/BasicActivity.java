package com.ruanko.mapdemo.activity;

import android.app.Activity;

public abstract class BasicActivity extends Activity {
	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// ��ʼ���ؼ�
		initView();
		// ��ʼ������
		initDate();
		// ��ʼ������
		initListener();
	}

	/**
	 * ��ʼ���ؼ�
	 */
	public abstract void initView();

	/**
	 * ��ʼ������
	 */
	public abstract void initDate();

	/**
	 * ��ʼ������
	 */
	public abstract void initListener();

}
