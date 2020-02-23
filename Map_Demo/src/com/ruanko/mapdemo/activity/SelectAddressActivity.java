package com.ruanko.mapdemo.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.ruanko.mapdemo.activity.R;

/**
 * 选择任务发布地址
 * 
 * @author tianzhi
 * 
 */
public class SelectAddressActivity extends BasicActivity implements
		OnClickListener {
	private Button bt_location;
	private Button bt_l_n;
	private Button bt_l_y;
	private EditText et_task_address;

	public LocationClient mLocationClient;
	public BDLocationListener myListener;
	protected BaiduMap baiduMap;
	protected MapView mapView;
	private BitmapDescriptor icon;
	@Override
	public void initView() {
		initSDK();
		setContentView(R.layout.activity_select_address);
		mapView = (MapView) findViewById(R.id.mapview);
		baiduMap = mapView.getMap();
		bt_location = (Button) findViewById(R.id.bt_location);
		et_task_address = (EditText) findViewById(R.id.et_task_address);
		bt_l_y = (Button) findViewById(R.id.bt_l_y);
		bt_l_n = (Button) findViewById(R.id.bt_l_n);

		locate();
	}

	private void locate() {
		mLocationClient = new LocationClient(getApplicationContext());
		mLocationClient.registerLocationListener(new MyLocationListener());

		LocationClientOption option = new LocationClientOption();
		option.setLocationMode(LocationMode.Hight_Accuracy);// 设置定位模式
		option.setCoorType("bd09ll");// 返回的定位结果是百度经纬度,默认值gcj02
		option.setScanSpan(5000);// 设置发起定位请求的间隔时间为5000ms
		option.setIsNeedAddress(true);// 返回的定位结果包含地址信息
		option.setNeedDeviceDirect(true);// 返回的定位结果包含手机机头的方向
		mLocationClient.setLocOption(option);
		baiduMap.setMyLocationEnabled(true);// 打开定位图层
		
		icon = BitmapDescriptorFactory
				.fromResource(R.drawable.ic_launcher);
		MyLocationConfiguration config = new MyLocationConfiguration(
				MyLocationConfiguration.LocationMode.COMPASS, true, icon);
		baiduMap.setMyLocationConfigeration(config);
	}

	class MyLocationListener implements BDLocationListener {

		@Override
		public void onReceiveLocation(BDLocation result) {
			//获取详细的地址
			String tempAddress = result.getAddrStr();
			System.out.println(tempAddress+"!");
			et_task_address.setText(tempAddress);
			MyLocationData dada = new MyLocationData.Builder()
					.latitude(result.getLatitude())// 设置纬度
					.longitude(result.getLongitude())// 设置经度
					.build();
			baiduMap.setMyLocationData(dada);// 显示定位信息 只有打开定位图层 才有效果
		}

	}

	private void initSDK() {
		// 初始化地图引擎
		SDKInitializer.initialize(getApplicationContext());
	}

	@Override
	protected void onStart() {
		//mLocationClient.start();// 开始定位
		super.onStart();
	}

	@Override
	protected void onPause() {
		mLocationClient.stop();// 停止定位
		super.onPause();
	}

	@Override
	public void initDate() {

	}

	@Override
	public void initListener() {
		bt_location.setOnClickListener(this);
		bt_l_y.setOnClickListener(this);
		bt_l_n.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_location:// 定位
			mLocationClient.start();// 开始定位
			break;

		case R.id.bt_l_y:// 确定
			String address = et_task_address.getText().toString();
			if (TextUtils.isEmpty(address)) {
				Toast.makeText(getApplicationContext(), "地址不能为空", 0).show();
				return;
			}
			Intent intent = new Intent();
			intent.putExtra("address", address);
			setResult(RESULT_OK, intent);
			finish();
			break;
		case R.id.bt_l_n:// 取消
			finish();
			break;
		}
	}

}
