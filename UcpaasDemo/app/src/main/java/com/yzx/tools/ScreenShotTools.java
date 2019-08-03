package com.yzx.tools;

import java.io.FileOutputStream;
import java.io.IOException;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;



/**
* @Title ScreenShotTools 
* @Description 屏幕截图工具
* @Company yunzhixun
* @author zhuqian
* @date 2015-11-16 下午5:56:42 
*/
public class ScreenShotTools {

	/**
	 * 截图
	 * @param activity
	 * @return 图片对象
	 */
	public static Bitmap shot(Activity activity){
		View view = activity.getWindow().getDecorView();
		view.setDrawingCacheEnabled(true);
		view.buildDrawingCache();
		
		Bitmap b1 = view.getDrawingCache();
		
		//获取状态栏宽高
		Rect frame = new Rect();
		activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
		
		
		int statusBarHeight = frame.top;

		//获取屏幕宽高
		int width = activity.getWindowManager().getDefaultDisplay().getWidth();

		int height = activity.getWindowManager().getDefaultDisplay().getHeight();//去掉标题栏
		
		Bitmap b = Bitmap.createBitmap(b1, 0, statusBarHeight, width, height - statusBarHeight);

		view.destroyDrawingCache();

		return b;
	}
	
	private static void savePic(Bitmap bitmap,String strFileName){
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(strFileName);
			bitmap.compress(Bitmap.CompressFormat.PNG, 90, fos);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				fos.flush();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
