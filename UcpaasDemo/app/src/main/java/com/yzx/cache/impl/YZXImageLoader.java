package com.yzx.cache.impl;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.os.Build;
import com.yzx.cache.MemoryCache;
import com.yzxtcp.tools.CustomLog;

/**
 * 图片获取工具
 * @author zhuqian
 *
 */
public class YZXImageLoader {
	private static YZXImageLoader mInstance;
	
	private MemoryCache memoryCache;
	
	private static int maxSize;
	public static YZXImageLoader newInstance(Context context){
		if (mInstance == null) {
			synchronized (YZXImageLoader.class) {
				if (mInstance == null) {
					mInstance = new YZXImageLoader(context);
				}
			}
		}
		return mInstance;
	}
	private YZXImageLoader(){
		
	}
	private YZXImageLoader(Context context){
		ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		int memoryClass = am.getMemoryClass();
		if (hasHoneycomb() && isLargeHeap(context)) {
			memoryClass = getLargeMemoryClass(am);
			CustomLog.d("memoryClass = "+memoryClass);
			maxSize = 1024 * 1024 * memoryClass / 8;
			CustomLog.d("sdk >= 11 max cache size = "+memoryCache);
		}else{
			 //获取应用程序的最大内存  
			maxSize = (int) (Runtime.getRuntime().maxMemory() / 6);  
			CustomLog.d("sdk < 11 max cache size = "+maxSize);
		}
		memoryCache = new LruMemoryCache(maxSize);
		
	}
	
	private static boolean hasHoneycomb() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
	}
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private static boolean isLargeHeap(Context context) {
		return (context.getApplicationInfo().flags & ApplicationInfo.FLAG_LARGE_HEAP) != 0;
	}
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private static int getLargeMemoryClass(ActivityManager am) {
		return am.getLargeMemoryClass();
	}
	
	public Bitmap get(String url){
		return memoryCache.get(url);
	}
	
	public boolean put(String url,Bitmap bit){
		return memoryCache.put(url, bit);
	}
}
