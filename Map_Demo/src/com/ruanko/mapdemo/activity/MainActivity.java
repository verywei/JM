package com.ruanko.mapdemo.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ruanko.mapdemo.activity.R;
import com.ruanko.mapdemo.util.Been;
import com.ruanko.mapdemo.util.HttpUtils;

public class MainActivity extends BasicActivity implements OnClickListener {
	EditText et_task_content;
	EditText et_task_money;
	RelativeLayout rl_address;
	TextView tv_task_address;
	Button bt_task_cancel;
	Button bt_task_send;
	Spinner s_type;
	@Override
	public void initView() {
		setContentView(R.layout.activity_main);
		et_task_content = (EditText) findViewById(R.id.et_task_content);
		et_task_money = (EditText) findViewById(R.id.et_task_money);
		rl_address = (RelativeLayout) findViewById(R.id.rl_address);
		bt_task_cancel = (Button) findViewById(R.id.bt_task_cancel);
		bt_task_send = (Button) findViewById(R.id.bt_task_send);
		tv_task_address = (TextView) findViewById(R.id.tv_task_address);
		s_type = (Spinner) findViewById(R.id.s_type);
	}

	@Override
	public void initDate() {
		List<String> list = new ArrayList<String>();
		list.add("类型1");
		list.add("类型2");
		list.add("类型3");
		ArrayAdapter adapter = new ArrayAdapter(this,
				android.R.layout.simple_spinner_item, list);
		s_type.setAdapter(adapter);
	}

	@Override
	public void initListener() {
		rl_address.setOnClickListener(this);
		bt_task_cancel.setOnClickListener(this);
		bt_task_send.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.rl_address:
			Intent intent = new Intent(this, SelectAddressActivity.class);
			startActivityForResult(intent, 0);
			break;
		case R.id.bt_task_cancel:
			finish();
			break;
		case R.id.bt_task_send:
			content = et_task_content.getText().toString();
			money = et_task_money.getText().toString();
			address = tv_task_address.getText().toString();
			type = s_type.getSelectedItemPosition() + 1 +"";
			if (TextUtils.isEmpty(content) || TextUtils.isEmpty(money)
					|| TextUtils.isEmpty(address)) {
				Toast.makeText(getApplicationContext(), "信息不能为空", 0).show();
				return;
			}
			try {
				int temp = Integer.valueOf(money);
				if (temp <= 0) {
					Toast.makeText(getApplicationContext(), "任务佣金必须大于0", 0)
							.show();
					return;
				}
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "任务佣金必须为数字格式", 0)
						.show();
				return;
			}
			System.out.println(type);
			// 将任务提交到服务器.
			sendTask();
			break;
		}
	}

	String content;
	String money;
	String address;
	String type;
	/**
	 * 将任务提交到服务器.
	 */
	private void sendTask() {
		// 创建hashmap的集合,用来携带参数
		final HashMap<String, String> paramsMap = new HashMap<String, String>();
		// 给hashmap赋值
		paramsMap.put("flag", "send");
		paramsMap.put("money", money);
		paramsMap.put("content", content);
		paramsMap.put("account", Been.account);
		paramsMap.put("address", address);
		paramsMap.put("type", type);
		// 开启子线程访问网络.
		new Thread() {
			@Override
			public void run() {
				new HttpUtils(MainActivity.this) {
					@Override
					public void successListener(final String result) {
						if("true".equals(result)) {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									Toast.makeText(getApplicationContext(), "发布成功", 0).show();
								}
							});
							
						}else {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									Toast.makeText(getApplicationContext(), "佣金不足", 0).show();
								}
							});
						}
					}

					@Override
					public void errorListener() {

					}
				}.doPost("Task", paramsMap);
			}
		}.start();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (resultCode) { // resultCode为回传的标记，我在B中回传的是RESULT_OK
		case RESULT_OK:
			if (data != null) {
				String address = data.getStringExtra("address");
				tv_task_address.setText(address);
			}
			break;

		}
	}
}
