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
	private EditText et_account;// 账号
	private EditText et_password;// 密码
	private Button bt_login;// 登录
	private Button bt_register;// 注册
	private SharedPreferences sp;
	private Editor edit;
	/**
	 * 设置监听器
	 */
	@Override
	public void initListener() {
		bt_login.setOnClickListener(this);
		bt_register.setOnClickListener(this);
	}
	/**
	 * 初始化布局
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
			// 点击登录
			login();
			break;

		case R.id.bt_register:
			// 点击注册,跳转到注册界面.
			Intent intent = new Intent(LoginActivity.this,
					RegisterActivity.class);
			startActivity(intent);
			break;
		}
	}



	/**
	 * 登录的逻辑判断
	 */
	private void login() {
		// 获取输入的账号和密码
		final String account = et_account.getText().toString().trim();
		String password = et_password.getText().toString().trim();
		if (TextUtils.isEmpty(account) || TextUtils.isEmpty(password)) {
			Toast.makeText(LoginActivity.this, "账号或者密码不能为空", Toast.LENGTH_SHORT)
					.show();
			return;
		}
		// 创建hashmap的集合,用来携带参数
		final HashMap<String, String> paramsMap = new HashMap<String, String>();
		// 给hashmap赋值
		paramsMap.put("flag", "login");
		paramsMap.put("account", account);
		paramsMap.put("password", password);
		// 开启子线程访问网络.
		new Thread() {
			@Override
			public void run() {
				new HttpUtils(LoginActivity.this) {
					@Override
					public void successListener(final String result) {
						if (!result.contains("false") && !result.contains("-1")) {// 登陆成功打开个人中心,并且将用户名保存到sp中去
							Intent intent = new Intent(LoginActivity.this,
									MainActivity.class);
							startActivity(intent);
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									Toast.makeText(getApplicationContext(),
											"登录成功", Toast.LENGTH_SHORT).show();
								}
							});
							//将账号存入sp
							// 登录成功,将账号,存到sp中.
							edit.putString("account", account);
							Been.account = account;
							edit.putString("id", result);
							Been.id = Integer.valueOf(result);
							edit.commit();
							finish();// 关闭自身
						} else {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									Toast.makeText(getApplicationContext(),
											"登录失败，用户名不存在", Toast.LENGTH_SHORT)
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
