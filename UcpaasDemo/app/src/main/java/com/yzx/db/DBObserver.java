package com.yzx.db;

import java.util.ArrayList;
import java.util.List;


/**
 * @Title DBObserver   
 * @Description  数据库改变观察者
 * @Company yunzhixun  
 * @author xhb
 * @date 2016-12-22 上午11:35:35
 */
public class DBObserver implements YZXObservable<OnDbChangeListener> {
	private final List<OnDbChangeListener> observers = new ArrayList<OnDbChangeListener>();
	
	private static DBObserver dbObserver;
	
	public static DBObserver getInstance() {
		if(dbObserver == null) {
			synchronized (DBObserver.class) {
				if(dbObserver == null) {
					dbObserver = new DBObserver();
				}
			}
		}
		return dbObserver;
	}

	@Override
	public void addObserver(OnDbChangeListener observer) {
		if(observer == null) {
			throw new IllegalArgumentException("The addObserver is null");
		}
		synchronized (DBObserver.class) {
			if(!observers.contains(observer)) {
				observers.add(observer);
			}
		}
	}

	@Override
	public void removeObserver(OnDbChangeListener observer) {
		if(observer == null){
			throw new IllegalArgumentException("The addObserver is null");
		}
		synchronized (DBObserver.class) {
			observers.remove(observer);
		}
	}

	@Override
	public void clearObserver() {
		synchronized (DBObserver.class) {
			observers.clear();
		}
	}

	@Override
	public void notifyObserver(String notifyId) {
		synchronized (DBObserver.class) {
			for(int i=observers.size()-1; i>=0; i--) {
				if(observers.get(i) != null) {
					observers.get(i).onChange(notifyId);
				}
			}
		}
	}
}
