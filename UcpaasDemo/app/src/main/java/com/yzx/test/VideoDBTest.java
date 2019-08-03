/**  
 * Project Name:Voice_Combine_IM_DEMO  
 * File Name:VideoDBTest.java  
 * Package Name:com.yzx.test  
 * Date:2015-12-14上午11:41:41  
 * Copyright (c) 2015, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package com.yzx.test;  

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.yzx.db.TelListsInfoDBManager;
import com.yzx.db.domain.TelListsInfo;
import com.yzx.im_demo.MainApplication;
import com.yzx.tools.YZXContents;
import com.yzxtcp.tools.CustomLog;
/**  
 * @Title VideoDBTest   
 * @Description  视频数据库功能测试
 * @Company yunzhixun  
 * @author xhb
 * @date 2015-12-14 上午11:41:45
 *
 * AndroidTestCase
 */
public class VideoDBTest{
	
	/*public void insert() {
		TelListsInfo users = new TelListsInfo();
		users.setDialFlag(2);
		users.setGravator("www.baidu.com");
		users.setName("xhb");
		users.setTelMode(1);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String time = dateFormat.format(new Date());
		users.setTime(time);
		CustomLog.v("telephoneUserInfos:" + users.toString());
		MainApplication.mInstance = (MainApplication) getContext().getApplicationContext();// 设置应用程序上下文
		TelListsInfoDBManager.getInstance().insert(users);
	}
	
	public void query() {
		MainApplication.mInstance = (MainApplication) getContext().getApplicationContext();
		YZXContents.setContext(getContext().getApplicationContext());
		List<TelListsInfo> lists = TelListsInfoDBManager.getInstance().getAll();
		CustomLog.v("lists:" + lists.toString());
	}*/
}
  
