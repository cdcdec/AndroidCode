package com.yzx.im_demo;

import java.util.ArrayList;
import java.util.List;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener;
import com.baidu.mapapi.map.BaiduMap.SnapshotReadyCallback;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationConfiguration.LocationMode;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.baidu.mapapi.utils.CoordinateConverter;
import com.yzx.adapter.BaiduPoiAdapter;
import com.yzx.tools.BitmapTools;
import com.yzx.tools.CoordTools;
import com.yzxIM.data.db.ConversationInfo;
import com.yzxtcp.tools.CustomLog;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ZoomControls;

/**
 * @Title IMBaiduMapActivity
 * @Description 选择位置和显示地图Activity
 * @Company yunzhixun
 * @author zhuqian
 * @date 2015-11-18 下午12:24:22
 */
public class IMBaiduMapActivity extends Activity implements OnClickListener,
		OnItemClickListener {
	private static final String TAG = "IMBaiduMapActivity";
	private BaiduSDKReceiver sdkReceiver;

	private ImageButton imbtn_back;
	private Button send_location;
	private ListView bmap_listview;
	private MapView bmap_View;
	private ImageView bmap_local_myself, bmap_center_icon;
	private TextView search_poi;

	private final static String LATITUDE = "latitude";
	private final static String LONGITUDE = "longitude";
	private final static String ADDRESS = "address";
	private final static String NAME = "name";
	private final static String PATH = "path";

	private GeoCoder mSearch = null;

	private List<PoiInfo> poiInfos;

	private BaiduPoiAdapter mAdapter;
	private BaiduMap mBaiduMap;
	private PoiSearch mPoiSearch;

	private int preCheckedPosition = 0;// 点击的前一个位置

	private PoiInfo myselfLocation;// 自己位置

	private LatLng originalLL, currentLL;// 初始化时的经纬度和地图滑动时屏幕中央的经纬度
	private MapStatusUpdate myselfU;

	private boolean changeState = true;// 当滑动地图时再进行附近搜索
	private YZXLocationListener mLocationListener = new YZXLocationListener();

	private LocationClient mLocClient;// 定位
	private PoiInfo lastPoi = null;// 上一个位置
	
	private ConversationInfo info;
	private boolean isResult = false;//搜索结果
	
	private TextView tv_title;
	private static final int ANIMATEMAP = 200;
	private static final int ANIMALOCALTION = 202;
	private Handler mHandler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case ANIMATEMAP:
				myselfU = MapStatusUpdateFactory.newLatLngZoom((LatLng)msg.obj,
						16.0f);
				changeState = true;
				mBaiduMap.animateMapStatus(myselfU);
				break;
			case ANIMALOCALTION:
				myselfU = MapStatusUpdateFactory.newLatLngZoom((LatLng)msg.obj,
						16.0f);
				changeState = true;
				mBaiduMap.animateMapStatus(myselfU,1500);
				break;
			default:
				break;
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SDKInitializer.initialize(getApplicationContext());
		setContentView(R.layout.activity_baidu_map);

		info = (ConversationInfo) getIntent().getSerializableExtra("conversationinfo");
		initView();

		init();
		
	}

	private void initView() {
		imbtn_back = (ImageButton) findViewById(R.id.imbtn_back);
		send_location = (Button) findViewById(R.id.send_location);
		bmap_listview = (ListView) findViewById(R.id.bmap_listview);
		bmap_View = (MapView) findViewById(R.id.bmap_View);
		bmap_local_myself = (ImageView) findViewById(R.id.bmap_local_myself);
		bmap_center_icon = (ImageView) findViewById(R.id.bmap_center_icon);
		search_poi = (TextView) findViewById(R.id.search_poi);
		tv_title = (TextView) findViewById(R.id.tv_title);
		
		bmap_center_icon.setVisibility(View.GONE);

		send_location.setClickable(false);
		send_location.setTextColor(Color.WHITE);

		imbtn_back.setOnClickListener(this);
		send_location.setOnClickListener(this);
		
		send_location.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				Button view = (Button) v;
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					//按下的颜色
					view.setTextColor(Color.WHITE);
					break;
				case MotionEvent.ACTION_UP:
				case MotionEvent.ACTION_CANCEL:
					//正常的颜色
					view.setTextColor(getResources().getColor(R.color.more_operate_p));
				default:
					break;
				}
				return false;
			}
		});
	}

	private void init() {
		// 注册 SDK 广播监听者
		IntentFilter iFilter = new IntentFilter();
		iFilter.addAction(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR);
		iFilter.addAction(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR);
		sdkReceiver = new BaiduSDKReceiver();
		registerReceiver(sdkReceiver, iFilter);

		poiInfos = new ArrayList<PoiInfo>();
		mAdapter = new BaiduPoiAdapter(this, poiInfos,
				R.layout.adapter_baidumap_item);
		bmap_listview.setAdapter(mAdapter);

		mSearch = GeoCoder.newInstance();

		Intent intent = getIntent();
		
		LocationMode currentLMode = LocationMode.NORMAL;
		mBaiduMap = bmap_View.getMap();
		MapStatusUpdate msu = MapStatusUpdateFactory.zoomTo(16.0f);
		mBaiduMap.setMapStatus(msu);

		mPoiSearch = PoiSearch.newInstance();
		bmap_View.setLongClickable(true);

		// 隐藏百度logo ZoomControl
		int count = bmap_View.getChildCount();
		for (int i = 0; i < count; i++) {
			View child = bmap_View.getChildAt(i);
			if (child instanceof ImageView || child instanceof ZoomControls) {
				child.setVisibility(View.INVISIBLE);
			}
		}

		// 隐藏比例尺
		bmap_View.showScaleControl(false);
		if (!getIntent().hasExtra(LATITUDE)) {
			// 发送位置
//			bmap_View = new MapView(this, new BaiduMapOptions());
			mBaiduMap.setMyLocationConfigeration(new MyLocationConfiguration(
					currentLMode, true, null));
			mBaiduMap.setMyLocationEnabled(true);
			showMapWithLocation();
			setOnclick();
		} else {
			// 显示位置
			tv_title.setText("查看位置信息");
			double longtitude = intent.getDoubleExtra(LONGITUDE, 0);
			double latitude = intent.getDoubleExtra(LATITUDE, 0);
			
//			LatLng p = converLatLng(new LatLng(latitude, longtitude));
			//将火星坐标转换为百度坐标
			Log.i(TAG, "原来的火星坐标:latitude = "+latitude+"，longitude = "+longtitude);
			LatLng p = CoordTools.bd_encrypt(latitude, longtitude);
			Log.i(TAG, "查看百度坐标:latitude = "+p.latitude+"，longitude = "+p.longitude);
//			bmap_View = new MapView(this,
//					new BaiduMapOptions().mapStatus(new MapStatus.Builder()
//							.target(p).build()));
			mBaiduMap.setMyLocationConfigeration(new MyLocationConfiguration(
					currentLMode, true, null));
			mBaiduMap.setMyLocationEnabled(true);
			myselfU = MapStatusUpdateFactory.newLatLngZoom(p,1.0f);
			mBaiduMap.animateMapStatus(myselfU);
			
			setLocationListener();
			bmap_listview.setVisibility(View.GONE);
			bmap_center_icon.setVisibility(View.GONE);
			bmap_local_myself.setVisibility(View.GONE);
			search_poi.setVisibility(View.GONE);
			send_location.setVisibility(View.GONE);
			
			
//			showMap(latitude, longtitude, address.split("|")[1]);
		}
	}


	private void setOnclick() {
		mBaiduMap.setOnMapTouchListener(new BaiduMap.OnMapTouchListener() {
			@Override
			public void onTouch(MotionEvent arg0) {
				changeState = true;
			}
		});
		bmap_local_myself.setOnClickListener(this);
		bmap_listview.setOnItemClickListener(this);
		mPoiSearch
				.setOnGetPoiSearchResultListener(new YZXOnGetPoiSearchResultListener());
		mBaiduMap
				.setOnMapStatusChangeListener(new YZXOnMapStatusChangeListener());
		mSearch.setOnGetGeoCodeResultListener(new YZXGetGeoCoderResultListener());
		
	}

	@Override
	protected void onDestroy() {
		if (sdkReceiver != null) {
			unregisterReceiver(sdkReceiver);
			sdkReceiver = null;
		}
		if (mLocClient != null) {
			mLocClient.stop();
		}
		Log.i(TAG, "onDestroy");
		bmap_View.onDestroy();
		if(mHandler != null){
			mHandler.removeCallbacksAndMessages(null);
		}
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		bmap_View.onPause();
		super.onPause();
	}

	private class BaiduSDKReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			if (intent.getAction().equals(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR)) {
				Toast.makeText(IMBaiduMapActivity.this, "请检查key,baiduSDK认证错误!",
						0).show();
			} else if (intent.getAction().equals(
					SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR)) {
				Toast.makeText(IMBaiduMapActivity.this, "请检查当前网络链接!", 0).show();
			}
		}
	}

	private ProgressDialog progressDialog;

	private void showMapWithLocation() {
		String str1 = "正在刷新";
		progressDialog = new ProgressDialog(this);
		progressDialog.setCanceledOnTouchOutside(false);
		progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		progressDialog.setMessage(str1);
		progressDialog.setOnCancelListener(new OnCancelListener() {

			public void onCancel(DialogInterface arg0) {
				if (progressDialog.isShowing()) {
					progressDialog.dismiss();
				}
				finish();
			}
		});
		progressDialog.show();

		setLocationListener();
	}
	/**
	* @Description 设置位置监听
	* @date 2015-12-10 下午3:18:58 
	* @author zhuqian  
	* @return void
	 */
	private void setLocationListener() {
		mLocClient = new LocationClient(this);
		mLocClient.registerLocationListener(mLocationListener);
		LocationClientOption option = new LocationClientOption();
		option.setOpenGps(true);// 打开gps
		option.setCoorType("gcj02");
		option.setIsNeedAddress(true);
		option.setScanSpan(10000);
		mLocClient.setLocOption(option);
		mLocClient.start();
	}

	private class YZXLocationListener implements BDLocationListener {

		public void onReceiveLocation(BDLocation location) {
			if (location == null) {
				Log.i(TAG, "没有收到位置信息.....");
				return;
			}
			Log.i(TAG, "onReceiveLocation success");
			if (progressDialog != null && progressDialog.isShowing()) {
				progressDialog.dismiss();
			}
			//MainApplication.getInstance().targetId
			LatLng ll = new LatLng(location.getLatitude(),
					location.getLongitude());
			
			
			CoordinateConverter converter = new CoordinateConverter();// 坐标转换工具类
			converter.coord(ll);
			converter.from(CoordinateConverter.CoordType.COMMON);
			//将gps坐标转换为百度坐标
			LatLng converterLatLng = converter.convert();
			if(lastPoi != null){
				Log.i(TAG, "经度变化："+Math.abs(lastPoi.location.latitude-converterLatLng.latitude));
				Log.i(TAG, "纬度变化："+Math.abs(lastPoi.location.longitude-converterLatLng.longitude));
			}
			if (myselfLocation != null && Math.abs(myselfLocation.location.latitude-converterLatLng.latitude) <= 0.000001
					&& Math.abs(myselfLocation.location.longitude-converterLatLng.longitude) <= 0.000001) {
				Log.i(TAG, "位置变化很小，不做处理");
				myselfLocation.address = location.getAddrStr();
				myselfLocation.location = converterLatLng;
				myselfLocation.name = "[我的位置]";
				return;
			}

			lastPoi = new PoiInfo();
			mBaiduMap.clear();
			// 获取经纬度
			if (myselfLocation == null) {
				myselfLocation = new PoiInfo();
			}
			myselfLocation.address = location.getAddrStr();
			myselfLocation.location = converterLatLng;
			myselfLocation.name = "[我的位置]";
			
			
			lastPoi.location = converterLatLng;
			lastPoi.address = location.getAddrStr();
			lastPoi.name = "[我的位置]";
			//初始化当前和原始位置
			originalLL = converterLatLng;
			currentLL = converterLatLng;
			//发送位置
			if(!getIntent().hasExtra(LATITUDE)){
				bmap_center_icon.setVisibility(View.VISIBLE);
				addMarkerOptions(new LatLng(converterLatLng.latitude, converterLatLng.longitude), R.drawable.icon_yourself_lication);
				myselfU = MapStatusUpdateFactory.newLatLngZoom(converterLatLng,
						15.999f);
				mBaiduMap.animateMapStatus(myselfU);
				Message msg = mHandler.obtainMessage();
				msg.what = ANIMATEMAP;
				msg.obj = converterLatLng;
				//移动地图，放大
				changeState = false;
				mHandler.sendMessageDelayed(msg , 1000);
			}else{
				send_location.setVisibility(View.GONE);
				double longtitude = getIntent().getDoubleExtra(LONGITUDE, 0);
				double latitude = getIntent().getDoubleExtra(LATITUDE, 0);
				String address = getIntent().getStringExtra(ADDRESS);
				addMarkerOptions(new LatLng(converterLatLng.latitude, converterLatLng.longitude), R.drawable.icon_yourself_lication);
				View view = LayoutInflater.from(IMBaiduMapActivity.this).inflate(R.layout.baidumap_location_maker, null);
				LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
				view.setLayoutParams(lp);
				((TextView)view.findViewById(R.id.tv_location_address)).setText(address);
				LatLng p = converLatLng(new LatLng(latitude, longtitude));
				addMarkerOptions(p, BitmapTools.getBitmapFromView(view));
				
				Message msg = mHandler.obtainMessage();
				msg.what = ANIMALOCALTION;
				msg.obj = p;
				mHandler.sendMessageAtTime(msg, 1000);
			}
		}
	}
	/**添加覆盖物
	* @Description TODO	TODO
	* @date 2015-12-10 下午4:39:44 
	* @author zhuqian  
	* @return void
	 */
	private void addMarkerOptions(LatLng latLng,int res){
		//保存当前覆盖物
		OverlayOptions myselfOOA = new MarkerOptions()
			.position(latLng)
			.anchor(0.5f, 0.5f)
			.icon(BitmapDescriptorFactory
					.fromResource(res))
			.zIndex(4).draggable(false);
		mBaiduMap.addOverlay(myselfOOA);
	}
	
	/**添加覆盖物
	* @Description TODO	TODO
	* @date 2015-12-10 下午4:39:44 
	* @author zhuqian  
	* @return void
	 */
	private void addMarkerOptions(LatLng latLng,Bitmap bitmap){
		OverlayOptions myselfOOA = new MarkerOptions()
		.position(latLng)
		.icon(BitmapDescriptorFactory
				.fromBitmap(bitmap))
		.zIndex(4).draggable(false);
		mBaiduMap.addOverlay(myselfOOA);
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bmap_local_myself:
			if(myselfLocation != null){
				myselfU = MapStatusUpdateFactory.newLatLngZoom(myselfLocation.location,
						16.0f);
				changeState = true;
				mBaiduMap.animateMapStatus(myselfU,1500);
			}
			break;
		case R.id.imbtn_back:
			// 返回
			finish();
			break;
		case R.id.send_location:
			//截图
			//ScreenShotTools.shot(this);
			if(lastPoi == null || lastPoi.location == null || !isResult){
				CustomLog.e("没有定位到位置");
				Toast.makeText(IMBaiduMapActivity.this, "未搜索到结果", 0).show();
				return;
			}
			send_location.setClickable(false);
			send_location.setTextColor(Color.WHITE);
			//清除覆盖物再截图
			mBaiduMap.clear();
			mBaiduMap.snapshot(new SnapshotReadyCallback() {
				@Override
				public void onSnapshotReady(Bitmap bitmap) {
					if(bitmap != null){
						String path = BitmapTools.saveLocation(BitmapTools.getThumbnailLoctionBitmap(IMBaiduMapActivity.this, bitmap), info.getTargetId());
						// 发送
						Intent intent = getIntent();
						intent.putExtra(LATITUDE, lastPoi.location.latitude);
						intent.putExtra(LONGITUDE, lastPoi.location.longitude);
						intent.putExtra(ADDRESS, lastPoi.address);
						intent.putExtra(NAME, lastPoi.name);
						intent.putExtra(PATH, path);
						setResult(RESULT_OK, intent);
						finish();
					}else{
						Toast.makeText(IMBaiduMapActivity.this, "截图失败", 0).show();
					}
				}
			});
			break;
		default:
			break;
		}
	}

	/**
	 * 移动到相应的位置
	 */
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		if (preCheckedPosition != position) {
			mAdapter.setSelection(position);
			preCheckedPosition = position;
			changeState = false;
			PoiInfo info = poiInfos.get(position);
			LatLng llA = info.location;
			MapStatusUpdate u = MapStatusUpdateFactory
					.newLatLngZoom(llA, 16.0f);
			mBaiduMap.animateMapStatus(u, 1500);
			lastPoi = info;
			mAdapter.notifyDataSetChanged();
		}
	}

	private class YZXOnGetPoiSearchResultListener implements
			OnGetPoiSearchResultListener {
		@Override
		public void onGetPoiDetailResult(PoiDetailResult result) {

		}

		@Override
		public void onGetPoiResult(PoiResult result) {
			if (result != null && result.getAllPoi() != null) {
				Log.i(TAG, "onGetPoiResult success result size = "+result.getAllPoi().size());
				isResult = true;
				if(lastPoi == null){
					lastPoi = new PoiInfo();
				}
				poiInfos.addAll(result.getAllPoi());
				preCheckedPosition = 0;
				isSearchFinished = true;
				mAdapter.setSelection(0);
				refreshAdapter();
			} else {
				if(lastPoi == null || TextUtils.isEmpty(lastPoi.address)){
					search_poi.setText("未搜索到结果");
					send_location.setClickable(false);
					send_location.setTextColor(Color.WHITE);
					isResult = false;
				}else{
					preCheckedPosition = 0;
					isSearchFinished = true;
					isResult = true;
					mAdapter.setSelection(0);
					refreshAdapter();
				}
			}
		}
	}

	/**
	 * 
	 * @Title YZXOnMapStatusChangeListener
	 * @Description 位置变化监听
	 * @Company yunzhixun
	 * @author zhuqian
	 * @date 2015-11-18 下午7:37:00
	 */
	private class YZXOnMapStatusChangeListener implements
			OnMapStatusChangeListener {
		@Override
		public void onMapStatusChange(MapStatus mapStatus) {

		}

		@Override
		public void onMapStatusChangeFinish(MapStatus mapStatus) {
			Log.i(TAG, "onMapStatusChangeFinish success start search");
			currentLL = mapStatus.target;
			if(Math.abs(currentLL.latitude-originalLL.latitude) <= 0.000001
					&& Math.abs(currentLL.longitude-originalLL.longitude) <= 0.000001){
				//和初始位置差不多，隐藏按钮
				bmap_local_myself.setVisibility(View.GONE);
			}else{
				bmap_local_myself.setVisibility(View.VISIBLE);
			}
			if (changeState) {
				poiInfos.clear();
				showLoading();
				mAdapter.notifyDataSetChanged();
				// 反Geo搜索
				mSearch.reverseGeoCode(new ReverseGeoCodeOption()
						.location(currentLL));
				mPoiSearch.searchNearby(new PoiNearbySearchOption()
						.keyword("大厦").location(currentLL).radius(500).pageCapacity(9));
			}
		}

		@Override
		public void onMapStatusChangeStart(MapStatus mapStatus) {
			Log.i(TAG, "onMapStatusChangeStart");
			//不可发送
			if(changeState){
				send_location.setClickable(false);
				send_location.setTextColor(Color.WHITE);
			}
			if (changeState) {
				poiInfos.clear();
				showLoading();
			}
		}
	}

	/**
	 * @Title YZXGetGeoCoderResultListener
	 * @Description 反地理编码
	 * @Company yunzhixun
	 * @author zhuqian
	 * @date 2015-11-18 下午7:42:58
	 */
	private class YZXGetGeoCoderResultListener implements
			OnGetGeoCoderResultListener {

		@Override
		public void onGetGeoCodeResult(GeoCodeResult arg0) {

		}

		@Override
		public void onGetReverseGeoCodeResult(ReverseGeoCodeResult result) {
			if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR
					|| result.getAddress() == null
					|| result.getLocation() == null || lastPoi == null || lastPoi.location == null) {
				Log.i(TAG, "onGetReverseGeoCodeResult fail");
				return;
			}
			Log.i(TAG, "onGetReverseGeoCodeResult success : can send");
			send_location.setClickable(true);
			send_location.setTextColor(getResources().getColor(R.color.more_operate_p));
			lastPoi.address = result.getAddress();
			lastPoi.location = result.getLocation();
			lastPoi.name = "[我的位置]";
			poiInfos.add(lastPoi);
			preCheckedPosition = 0;
			mAdapter.setSelection(0);
			isGeoCoderFinished = true;
			refreshAdapter();
		}

	}

	private boolean isSearchFinished;
	private boolean isGeoCoderFinished;

	private void refreshAdapter() {
		if (isSearchFinished && isGeoCoderFinished) {
			showSearch();
			mAdapter.notifyDataSetChanged();
			isSearchFinished = false;
			isGeoCoderFinished = false;
		}
	}

	public void showLoading() {
		search_poi.setText("正在加载...");
		search_poi.setVisibility(View.VISIBLE);
		bmap_listview.setVisibility(View.GONE);
	}
	@Override
	protected void onResume() {
		bmap_View.onResume();
		super.onResume();
	}
	public void showSearch() {
		search_poi.setVisibility(View.GONE);
		bmap_listview.setVisibility(View.VISIBLE);
	}
	/**
	* @Description 将火星坐标转换为百度坐标
	* @return	百度坐标
	* @date 2015-12-11 上午9:42:34 
	* @author zhuqian  
	* @return LatLng
	 */
	private LatLng converLatLng(LatLng ll){
		CoordinateConverter converter = new CoordinateConverter();// 坐标转换工具类
		converter.coord(ll);
		converter.from(CoordinateConverter.CoordType.COMMON);
		//将gps坐标转换为百度坐标
		return converter.convert();
	}
}
