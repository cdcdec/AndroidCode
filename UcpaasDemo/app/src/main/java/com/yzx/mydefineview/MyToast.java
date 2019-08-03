package com.yzx.mydefineview;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class MyToast {


	public static void showLoginToast(Context context, String content) {

		Toast toast = Toast.makeText(context, content, Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 80);
		toast.show();
	}
	
	
}
