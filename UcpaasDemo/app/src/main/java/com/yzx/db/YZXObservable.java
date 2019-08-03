package com.yzx.db;

/**
 * @Title YZXObservable   
 * @Description  观察者接口
 * @Company yunzhixun  
 * @author xhb
 * @date 2016-12-22 上午11:16:43
 */
public interface YZXObservable<T> {

	/**
	 * @Description 添加监听
	 * @param observer	监听回调类
	 * @date 2016-12-22 上午11:38:30 
	 * @author xhb  
	 * @return void    返回类型
	 */
	void addObserver(T observer);
	
	/**
	 * @Description 移除监听
	 * @param observer	监听回调类
	 * @date 2016-12-22 上午11:39:28 
	 * @author xhb  
	 * @return void    返回类型
	 */
	void removeObserver(T observer);
	
	/**
	 * @Description 清除监听
	 * @date 2016-12-22 上午11:39:55 
	 * @author xhb  
	 * @return void    返回类型
	 */
	void clearObserver();
	
	/**
	 * @Description 通知观察者
	 * @param notifyId	通知id
	 * @date 2016-12-22 上午11:40:11 
	 * @author xhb  
	 * @return void    返回类型
	 */
	void notifyObserver(String notifyId);
}
