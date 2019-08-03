package com.yzx.db;

import java.util.List;
/**
* @Title IDBManager 
* @Description 抽象数据库操作接口封装
* @Company yunzhixun
* @author zhuqian
* @date 2015-12-2 下午4:00:48 
*/
public interface IDBManager<T> {
	//获取所有
	List<T> getAll();
	
	//根据用户id获取
	T getById(String id);
	
	//根据用户id删除
	int deleteById(String id);
	
	//插入数据
	int insert(T t);
	
	int update(T t);
}
