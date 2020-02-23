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
	 * ���캯�� ��ʼ��client �������������Ӳ���
	 */
	public HttpUtils(Activity activity) {
		mActvity = activity;
		HttpParams params = new BasicHttpParams();
		ConnManagerParams.setTimeout(params, 1000);
		HttpConnectionParams.setConnectionTimeout(params, 3000);
		HttpConnectionParams.setSoTimeout(params, 5000);
		//��ʼ��httpclient
		client = new DefaultHttpClient(params);
	}

	public final String SERVER_HOST = "http://192.168.18.105:8080/MapDemo/";

	/**
	 * ��Post��ʽ���ʷ�����
	 * 
	 * @param url
	 * @param param
	 * @return
	 * @throws IOException
	 */
	public void doPost(String url ,Map<String, String> param) {
		// ��ʼ��POST����
		// String url = SERVER_HOST + postUrl;
		HttpPost request = new HttpPost(SERVER_HOST+url);

		// ��ʼ��<form>������
		List<BasicNameValuePair> paramsList = new ArrayList<BasicNameValuePair>();
		for (String key : param.keySet()) {
			String value = param.get(key);
			Log.d("HttpUtils.POST", "[PARAM key=\"" + key + "\" value=\""
					+ value + "\"]");
			// ��Ӳ���
			paramsList.add(new BasicNameValuePair(key, value));
		}
		try {
			UrlEncodedFormEntity

			form = new UrlEncodedFormEntity(paramsList, HTTP.UTF_8);

			request.setEntity(form);

			// ִ��POST����
			HttpResponse httpResponse = client.execute(request);

			// ��ȡ��Ӧ��
			int ret = httpResponse.getStatusLine().getStatusCode();
			// ����Ӧ��ΪHttpStatus.SC_OK����200ʱ����ʾ�ɹ�
			if (ret == HttpStatus.SC_OK) {
				// ��ȡ��Ӧ���
				String content = EntityUtils.toString(httpResponse.getEntity(),
						HTTP.UTF_8);
				Log.d("HttpUtils.POST", content);
				successListener(content);
			} else {
				String msg = "���������쳣:" + ret;
				Log.d("HttpUtils.POST", msg);
				errorListener();
			}
		} catch (IOException e) {
			mActvity.runOnUiThread(new Runnable() {
				@Override
				public void run() {
					Toast.makeText(mActvity, "��������", Toast.LENGTH_SHORT)
							.show();
				}
			});
			errorListener();
			e.printStackTrace();
		}

	}
	/**
	 * ����ɹ��Ļص�
	 * @param result
	 */
	public abstract void successListener(String result);
	/**
	 * �������Ļص�
	 */
	public abstract void errorListener();

}