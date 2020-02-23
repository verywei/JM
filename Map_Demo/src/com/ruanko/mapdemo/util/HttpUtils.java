package com.ruanko.mapdemo.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

public abstract class HttpUtils {
	private HttpClient client = null;
	private Activity mActvity = null;

	/**
	 * 构造函数 初始化client 并设置网络连接参数
	 */
	public HttpUtils(Activity activity) {
		mActvity = activity;
		HttpParams params = new BasicHttpParams();
		ConnManagerParams.setTimeout(params, 1000);
		HttpConnectionParams.setConnectionTimeout(params, 3000);
		HttpConnectionParams.setSoTimeout(params, 5000);
		//初始化httpclient
		client = new DefaultHttpClient(params);
	}

	public final String SERVER_HOST = "http://192.168.18.105:8080/MapDemo/";

	/**
	 * 用Post方式访问服务器
	 * 
	 * @param url
	 * @param param
	 * @return
	 * @throws IOException
	 */
	public void doPost(String url ,Map<String, String> param) {
		// 初始化POST方法
		// String url = SERVER_HOST + postUrl;
		HttpPost request = new HttpPost(SERVER_HOST+url);

		// 初始化<form>表单数据
		List<BasicNameValuePair> paramsList = new ArrayList<BasicNameValuePair>();
		for (String key : param.keySet()) {
			String value = param.get(key);
			Log.d("HttpUtils.POST", "[PARAM key=\"" + key + "\" value=\""
					+ value + "\"]");
			// 添加参数
			paramsList.add(new BasicNameValuePair(key, value));
		}
		try {
			UrlEncodedFormEntity

			form = new UrlEncodedFormEntity(paramsList, HTTP.UTF_8);

			request.setEntity(form);

			// 执行POST请求
			HttpResponse httpResponse = client.execute(request);

			// 获取响应码
			int ret = httpResponse.getStatusLine().getStatusCode();
			// 当响应吗为HttpStatus.SC_OK，即200时，表示成功
			if (ret == HttpStatus.SC_OK) {
				// 获取响应结果
				String content = EntityUtils.toString(httpResponse.getEntity(),
						HTTP.UTF_8);
				Log.d("HttpUtils.POST", content);
				successListener(content);
			} else {
				String msg = "网络连接异常:" + ret;
				Log.d("HttpUtils.POST", msg);
				errorListener();
			}
		} catch (IOException e) {
			mActvity.runOnUiThread(new Runnable() {
				@Override
				public void run() {
					Toast.makeText(mActvity, "请检查网络", Toast.LENGTH_SHORT)
							.show();
				}
			});
			errorListener();
			e.printStackTrace();
		}

	}
	/**
	 * 请求成功的回调
	 * @param result
	 */
	public abstract void successListener(String result);
	/**
	 * 请求出错的回调
	 */
	public abstract void errorListener();

}