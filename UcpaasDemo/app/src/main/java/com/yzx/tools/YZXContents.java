package com.yzx.tools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/**
* @Title YZXContents 
* @Description 保存一些系统常量
* @Company yunzhixun
* @author zhuqian
* @date 2015-12-2 下午3:00:38 
*/
public class YZXContents {
	
	public static Context mContext;
	
	public static String pkgName = "com.yzx.im_demo";

	public static int getVersionCode() {
        int code = 1;
        if(mContext == null) {
            return code;
        }
        try {
            PackageInfo packageInfo = mContext.getPackageManager().getPackageInfo(
                    getPackageName(), 0);
            code = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return code;
    }
	
	public static String getPackageName() {
        return pkgName;
    }
	
	 /**
     * 设置上下文对象
     * @param context
     */
    public static void setContext(Context context) {
        mContext = context;
        pkgName = context.getPackageName();
    }
}
