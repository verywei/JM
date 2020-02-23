package com.ruanko.mapdemo.activity;

import java.util.HashMap;
import java.util.Map;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ruanko.mapdemo.activity.R;
import com.ruanko.mapdemo.util.HttpUtils;

/**
 * 注册界面
 * 
 * @author tianzhi
 * 
 */
public class RegisterActivity extends BasicActivity {
	private EditText et_account;// 账号的输入框
	private EditText et_password;// 密码的输入框
	private Button bt_register;// 注册按钮

	@Override
	public void initView() {
		setContentView(R.layout.activity_register);
		et_account = (EditText) findViewById(R.id.et_account);
		et_password = (EditText) findViewById(R.id.et_password);
		bt_register = (Button) findViewById(R.id.bt_register);

	}

	@Override
	public void initDate() {

	}

	@Override
	public void initListener() {
		// 给注册按钮设置点击事件
		bt_register.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 注册
				register();
			}

		});
	}

	/**
	 * 注册
	 */
	private void register() {
		// 获取界面输入的数据
		String userAccount = et_account.getText().toString();
		String userPassword = et_password.getText().toString();
		// 进行非空判断
		if (TextUtils.isEmpty(userAccount) || TextUtils.isEmpty(userPassword)) {
			Toast.makeText(getApplicationContext(), "请输入账户名，密码",
					Toast.LENGTH_LONG).show();
			return;
		}
		// 设置请求参数
		final Map<String, String> param = new HashMap<String, String>();
		param.put("flag", "register");
		param.put("account", userAccount);
		param.put("password", userPassword);
		// 开启线程,访问网络数据.
		new Thread() {
			@Override
			public void run() {

				new HttpUtils(RegisterActivity.this) {

					@Override
					public void successListener(final String result) {
						if (result.contains("true")) {// 返回ture,表示注册成功.
							// 提示注册信息
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									Toast.makeText(getApplicationContext(),
											"注册成功", Toast.LENGTH_SHORT).show();
								}
							});
							finish();// 注册成功,关闭注册界面
						}else {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									Toast.makeText(getApplicationContext(),
											"用户名已经存在", Toast.LENGTH_SHORT).show();
								}
							});
						}
					}

					@Override
					public void errorListener() {

					}
				}.doPost("User",param);

			}
		}.start();
	}
}