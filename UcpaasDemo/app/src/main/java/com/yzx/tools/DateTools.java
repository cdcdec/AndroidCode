package com.yzx.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.text.TextUtils;
/**
* @Title DateTools 
* @Description 日期工具
* @Company yunzhixun
* @author zhuqian
* @date 2015-12-17 下午3:55:29 
*/
public class DateTools {

	/**
	* @Description 截取时间字符串
	* @param time 时间，是否需要时间后缀
	* @return	返回截取的字符串(如：今天12:00，昨天13:29，12-17 16:14)
	* @date 2015-12-17 下午4:13:16 
	* @author zhuqian  
	* @return String
	 */
	public static String formatDate(String time,boolean needTime){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		if(time==null ||"".equals(time)){
			return "";
		}
		Date date = null;
		try {
			date = format.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Calendar current = Calendar.getInstance();
		
		Calendar today = Calendar.getInstance();	//今天
		
		today.set(Calendar.YEAR, current.get(Calendar.YEAR));
		today.set(Calendar.MONTH, current.get(Calendar.MONTH));
		today.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH));
		//  Calendar.HOUR——12小时制的小时数 Calendar.HOUR_OF_DAY——24小时制的小时数
		today.set( Calendar.HOUR_OF_DAY, 0);
		today.set( Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);
		
		Calendar yesterday = Calendar.getInstance();	//昨天
		
		yesterday.set(Calendar.YEAR, current.get(Calendar.YEAR));
		yesterday.set(Calendar.MONTH, current.get(Calendar.MONTH));
		yesterday.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH)-1);
		yesterday.set( Calendar.HOUR_OF_DAY, 0);
		yesterday.set( Calendar.MINUTE, 0);
		yesterday.set(Calendar.SECOND, 0);
		
		current.setTime(date);
		
		if(current.after(today)){
			return "今天 "+time.split(" ")[1];
		}else if(current.before(today) && current.after(yesterday)){
			return "昨天 "+time.split(" ")[1];
		}else{
			int index = time.indexOf("-")+1;//"-"的索引
			int nIndex = time.indexOf(" ");//" "的索引
			
			Calendar oldYear = Calendar.getInstance();	//去年(今年的一月一日，00:00:00)之前
			
			oldYear.set(Calendar.YEAR, today.get(Calendar.YEAR));
			oldYear.set(Calendar.MONTH, 0);
			oldYear.set(Calendar.DAY_OF_MONTH,0);
			oldYear.set( Calendar.HOUR_OF_DAY, 23);
			oldYear.set( Calendar.MINUTE, 59);
			oldYear.set(Calendar.SECOND, 59);
			oldYear.set(Calendar.MILLISECOND, 59);
			
			
			if(needTime){
				if(current.after(oldYear)){
					return time.substring(index);
				}else{
					return time;
				}
			}else{
				if(current.after(oldYear)){
					return time.substring(index, nIndex);
				}else{
					return time.substring(0, nIndex);
				}
			}
		}
	}
	/**
	* @Description 获取消息时间格式字符串
	* @return	时间字符串
	* @date 2016-1-19 上午10:22:26 
	* @author zhuqian  
	* @return String
	 */
	public static String getMsgDate(String time,String oldIndexTime){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		if(time==null ||"".equals(time)){
			return "";
		}
		//是否大于四分钟
		boolean isOldfour = isMoreFourMinute(time,oldIndexTime);
		if(!isOldfour){
			//如果不大于四分钟直接返回
			return "";
		}
		Date date = null;
		try {
			date = format.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Calendar current = Calendar.getInstance();
		
		Calendar today = Calendar.getInstance();	//今天
		
		today.set(Calendar.YEAR, current.get(Calendar.YEAR));
		today.set(Calendar.MONTH, current.get(Calendar.MONTH));
		today.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH));
		//  Calendar.HOUR——12小时制的小时数 Calendar.HOUR_OF_DAY——24小时制的小时数
		today.set( Calendar.HOUR_OF_DAY, 0);
		today.set( Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);
		
		Calendar yesterday = Calendar.getInstance();	//昨天
		
		yesterday.set(Calendar.YEAR, current.get(Calendar.YEAR));
		yesterday.set(Calendar.MONTH, current.get(Calendar.MONTH));
		yesterday.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH)-1);
		yesterday.set( Calendar.HOUR_OF_DAY, 0);
		yesterday.set( Calendar.MINUTE, 0);
		yesterday.set(Calendar.SECOND, 0);
		current.setTime(date);
		
		if(current.after(today) || current.compareTo(today) == 0){
			return time.split(" ")[1];
		}else if(current.before(today) && current.after(yesterday)){
			return "昨天 "+time.split(" ")[1];
		}else{
			int index = time.indexOf("-")+1;//"-"的索引
			
			Calendar oldYear = Calendar.getInstance();	//去年(今年的一月一日，00:00:00)之前
			
			oldYear.set(Calendar.YEAR, today.get(Calendar.YEAR));
			oldYear.set(Calendar.MONTH, 0);
			oldYear.set(Calendar.DAY_OF_MONTH,0);
			oldYear.set( Calendar.HOUR_OF_DAY, 23);
			oldYear.set( Calendar.MINUTE, 59);
			oldYear.set(Calendar.SECOND, 59);
			oldYear.set(Calendar.MILLISECOND, 59);
			if(current.after(oldYear)){
				return time.substring(index);
			}else{
				return time;
			}
		}
	}
	/**
	* @Description 判断两个时间间隔是否大于4分钟
	* @return	true 表示大于，false表示小于
	* @date 2016-1-19 上午10:34:52 
	* @author zhuqian  
	* @return boolean
	 */
	private static boolean isMoreFourMinute(String curTime,String oldIndexTime){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		if(TextUtils.isEmpty(curTime) || TextUtils.isEmpty(oldIndexTime)){
			return true;
		}
		Date curDate = null;
		Date oldDate = null;
		try {
			curDate = format.parse(curTime);
			oldDate = format.parse(oldIndexTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//当前时间
		Calendar current = Calendar.getInstance();
		current.setTime(curDate);
		
		//四分钟前的时间
		Calendar currentOldFour = Calendar.getInstance();
		//计算四分钟之后的时间
		currentOldFour.set(Calendar.YEAR, current.get(Calendar.YEAR));
		currentOldFour.set(Calendar.MONTH, current.get(Calendar.MONTH));
		currentOldFour.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH));
		//  Calendar.HOUR——12小时制的小时数 Calendar.HOUR_OF_DAY——24小时制的小时数
		currentOldFour.set(Calendar.HOUR_OF_DAY, current.get(Calendar.HOUR_OF_DAY));
		currentOldFour.set(Calendar.MINUTE, current.get(Calendar.MINUTE) - 4);
		currentOldFour.set(Calendar.SECOND, 0);
		
		//需要对比的时间
		Calendar oldTime = Calendar.getInstance();
		oldTime.setTime(oldDate);
		//返回是否大于四分钟
		return currentOldFour.after(oldTime);
	}
}
