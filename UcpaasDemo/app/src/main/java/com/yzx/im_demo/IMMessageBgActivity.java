package com.yzx.im_demo;

import java.io.File;
import java.io.IOException;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.RelativeLayout;
import com.yzx.mydefineview.YzxTopBar;
import com.yzx.tools.BitmapTools;
import com.yzx.tools.ContentResolverUtils;
import com.yzxtcp.tools.CustomLog;

public class IMMessageBgActivity extends Activity {

	private YzxTopBar yzxTopBar;
	private RelativeLayout ib_back;
	private String path = "";
	
	@Override
	protected void onResume() {
		super.onResume();
	}
	//是否有dialog在当前Activity
	private boolean haveDialog = false;

	public void setHaveDialog(boolean haveDialog) {
		this.haveDialog = haveDialog;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_messagebg);
		initviews();
	}

	private void initviews() {
		yzxTopBar = (YzxTopBar) findViewById(R.id.yzx_topbar);
		yzxTopBar.setTitle("聊天背景");

		ib_back = (RelativeLayout) findViewById(R.id.imbtn_back);
		ib_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});

		findViewById(R.id.selectbg).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {
						startActivityForResult(new Intent(
								IMMessageBgActivity.this,
								IMSelectBgActivity.class), 2);
					}
				});
		findViewById(R.id.selectfromcamera).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {
						openImage(1);
					}
				});
		findViewById(R.id.selectfromnow).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {
						openImage(2);
					}
				});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(haveDialog){
			//已经踢线
			return;
		}
		if ((resultCode == Activity.RESULT_OK && requestCode == SELECT_PIC) || 
				(resultCode == Activity.RESULT_OK && requestCode == SELECT_PIC_KITKAT)) {
			Uri uri = data.getData();
			ContentResolver cr = this.getContentResolver();
			Cursor cursor = cr.query(uri, null, null, null, null);// 根据Uri从数据库中找
			int angle = 0;
			if (cursor != null && requestCode == SELECT_PIC) {
				cursor.moveToFirst();
				if(cursor.getColumnIndex("orientation") != -1){
					String orientation = cursor.getString(cursor.getColumnIndex("orientation"));// 获取旋转的角度
					if (orientation != null)
						angle = Integer.valueOf(orientation);
				}
				
			}
			CustomLog.e("RESULT_PATH:" + uri.toString());
			if(requestCode == SELECT_PIC){
				path = getFilePathFromUri(uri);
			}else{
				path = ContentResolverUtils.getPath(this, uri);
			}
			try {
				DisplayMetrics dm = new DisplayMetrics();
				getWindowManager().getDefaultDisplay().getMetrics(dm);
				path = BitmapTools.getNewPath(path, angle, dm.widthPixels,
						dm.heightPixels, "");
				if (path == null) {
					return;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(data == null){
				data = new Intent();
			}
			data.putExtra("background", path);
		} else if (requestCode == 101) {
			try {
				DisplayMetrics dm = new DisplayMetrics();
				getWindowManager().getDefaultDisplay().getMetrics(dm);
				
				int degree = BitmapTools.readImageDegree(path);
				path = BitmapTools.getNewPath(path, degree, dm.widthPixels,
						dm.heightPixels, "");
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(data == null){
				data = new Intent();
			}
			data.putExtra("background", path);
		} else if (requestCode == 2) {
			if(data != null && data.hasExtra("background")){
				path = data.getStringExtra("background");
			}
		}
		setResult(RESULT_OK,data);
		finish();
	}

	// 4.4以下手机选择图片返回码
	private static final int SELECT_PIC = 116;
	// 4.4以上手机选择图片返回码
	private static final int SELECT_PIC_KITKAT = 118;
	private static final String TAG = "IMMessageBgActivity";

	private void openImage(int code) {
		switch (code) {
		case 1:
			Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
			intent.addCategory(Intent.CATEGORY_OPENABLE);
			intent.setType("image/jpeg");
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
				startActivityForResult(intent, SELECT_PIC_KITKAT);
			} else {
				startActivityForResult(intent, SELECT_PIC);
			}
			break;
		case 2:
			path = "/sdcard/yunzhixun/image/yzx_image_"
					+ System.currentTimeMillis() + ".jpg";
			File file = new File(path);
			Intent intent2 = new Intent();
			intent2.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
			intent2.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
			startActivityForResult(intent2, 101);
			break;
		}
	}

	/**
	 * 根据Uri 获取文件实际路径
	 * 
	 * @param fileUrl
	 * @return
	 */
	public String getFilePathFromUri(Uri fileUrl) {
		String fileName = "";
		if (fileUrl != null) {
			if (fileUrl.getScheme().toString().compareTo("content") == 0) {
				Cursor cursor = getContentResolver().query(fileUrl, null, null,
						null, null);
				if (cursor != null && cursor.moveToFirst()) {
					if (cursor.getColumnIndex(MediaStore.Images.Media.DATA) > -1) {
						int column_index = cursor
								.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
						fileName = cursor.getString(column_index);
						if (!fileName.startsWith("/data")
								&& !fileName.startsWith("/storage")
								&& !fileName.startsWith("/mnt")) {
							fileName = "/mnt" + fileName;
						}
					}
					cursor.close();
				}
			} else if (fileUrl.getScheme().compareTo("file") == 0) {
				fileName = fileUrl.toString();
				fileName = fileUrl.toString().replace("file://", "");
				if (!fileName.startsWith("/storage")) {
					int index = fileName.indexOf("/sdcard");
					fileName = index == -1 ? fileName : fileName
							.substring(index);
					if (!fileName.startsWith("/mnt")) {
						fileName = "/mnt" + fileName;
					}
				}
			}
		}
		return fileName;
	}
	
	@Override
	protected void onDestroy() {
		Log.i(TAG, "onDestroy()");
		super.onDestroy();
	}
}
