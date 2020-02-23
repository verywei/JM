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
 * ע�����
 * 
 * @author tianzhi
 * 
 */
public class RegisterActivity extends BasicActivity {
	private EditText et_account;// �˺ŵ������
	private EditText et_password;// ����������
	private Button bt_register;// ע�ᰴť

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
		// ��ע�ᰴť���õ���¼�
		bt_register.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// ע��
				register();
			}

		});
	}

	/**
	 * ע��
	 */
	private void register() {
		// ��ȡ�������������
		String userAccount = et_account.getText().toString();
		String userPassword = et_password.getText().toString();
		// ���зǿ��ж�
		if (TextUtils.isEmpty(userAccount) || TextUtils.isEmpty(userPassword)) {
			Toast.makeText(getApplicationContext(), "�������˻���������",
					Toast.LENGTH_LONG).show();
			return;
		}
		// �����������
		final Map<String, String> param = new HashMap<String, String>();
		param.put("flag", "register");
		param.put("account", userAccount);
		param.put("password", userPassword);
		// �����߳�,������������.
		new Thread() {
			@Override
			public void run() {

				new HttpUtils(RegisterActivity.this) {

					@Override
					public void successListener(final String result) {
						if (result.contains("true")) {// ����ture,��ʾע��ɹ�.
							// ��ʾע����Ϣ
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									Toast.makeText(getApplicationContext(),
											"ע��ɹ�", Toast.LENGTH_SHORT).show();
								}
							});
							finish();// ע��ɹ�,�ر�ע�����
						}else {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									Toast.makeText(getApplicationContext(),
											"�û����Ѿ�����", Toast.LENGTH_SHORT).show();
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