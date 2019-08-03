package com.yzx.db;


/**
 * @Title OnDbChangeListener   
 * @Description  数据库改变监听类
 * @Company yunzhixun  
 * @author xhb
 * @date 2016-12-22 上午11:37:38
 */
public interface OnDbChangeListener {
	void onChange(String notifyId);
}
