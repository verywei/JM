package com.ruanko.mapdemo.activity;

import java.util.HashMap;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ruanko.mapdemo.activity.R;
import com.ruanko.mapdemo.util.Been;
import com.ruanko.mapdemo.util.HttpUtils;

public class LoginActivity extends BasicActivity implements OnClickListener {
	private EditText et_account;// �˺�
	private EditText et_password;// ����
	private Button bt_login;// ��¼
	private Button bt_register;// ע��
	private SharedPreferences sp;
	private Editor edit;
	/**
	 * ���ü�����
	 */
	@Override
	public void initListener() {
		bt_login.setOnClickListener(this);
		bt_register.setOnClickListener(this);
	}
	/**
	 * ��ʼ������
	 */
	@Override
	public void initView() {
		setContentView(R.layout.activity_login);
		et_account = (EditText) findViewById(R.id.et_account);
		et_password = (EditText) findViewById(R.id.et_password);
		bt_login = (Button) findViewById(R.id.bt_login);
		bt_register = (Button) findViewById(R.id.bt_register);

	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.bt_login:
			// �����¼
			login();
			break;

		case R.id.bt_register:
			// ���ע��,��ת��ע�����.
			Intent intent = new Intent(LoginActivity.this,
					RegisterActivity.class);
			startActivity(intent);
			break;
		}
	}



	/**
	 * ��¼���߼��ж�
	 */
	private void login() {
		// ��ȡ������˺ź�����
		final String account = et_account.getText().toString().trim();
		String password = et_password.getText().toString().trim();
		if (TextUtils.isEmpty(account) || TextUtils.isEmpty(password)) {
			Toast.makeText(LoginActivity.this, "�˺Ż������벻��Ϊ��", Toast.LENGTH_SHORT)
					.show();
			return;
		}
		// ����hashmap�ļ���,����Я������
		final HashMap<String, String> paramsMap = new HashMap<String, String>();
		// ��hashmap��ֵ
		paramsMap.put("flag", "login");
		paramsMap.put("account", account);
		paramsMap.put("password", password);
		// �������̷߳�������.
		new Thread() {
			@Override
			public void run() {
				new HttpUtils(LoginActivity.this) {
					@Override
					public void successListener(final String result) {
						if (!result.contains("false") && !result.contains("-1")) {// ��½�ɹ��򿪸�������,���ҽ��û������浽sp��ȥ
							Intent intent = new Intent(LoginActivity.this,
									MainActivity.class);
							startActivity(intent);
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									Toast.makeText(getApplicationContext(),
											"��¼�ɹ�", Toast.LENGTH_SHORT).show();
								}
							});
							//���˺Ŵ���sp
							// ��¼�ɹ�,���˺�,�浽sp��.
							edit.putString("account", account);
							Been.account = account;
							edit.putString("id", result);
							Been.id = Integer.valueOf(result);
							edit.commit();
							finish();// �ر�����
						} else {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									Toast.makeText(getApplicationContext(),
											"��¼ʧ�ܣ��û���������", Toast.LENGTH_SHORT)
											.show();
								}
							});
						}
					}

					@Override
					public void errorListener() {

					}
				}.doPost("User", paramsMap);
			}
		}.start();

	}

	@Override
	public void initDate() {
		sp = getSharedPreferences("Login", MODE_PRIVATE);
		edit = sp.edit();
	}


}
