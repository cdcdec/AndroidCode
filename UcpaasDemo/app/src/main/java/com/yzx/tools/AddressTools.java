package com.yzx.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 网络地址判断工具
 * @author zhuqian
 *
 */
public class AddressTools {

	/**
	 * 是否是网络地址
	 * @param address 网络地址字符串
	 * @return true：匹配正确，false：匹配错误
	 */
	public static boolean isNetAddress(String address){
		Pattern pattern = Pattern.compile("^[[a-z0-9]{1,}//.]{1}[[a-z0-9]{1,}//.]{1,}[a-z0-9]{1,}$");
		Matcher matcher = pattern.matcher(address);
		if(matcher.matches()){
			//继续匹配
			pattern = Pattern.compile("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$");
			matcher = pattern.matcher(address);
			while(matcher.find()){
				if(Integer.parseInt(matcher.group(1)) > 255 || Integer.parseInt(matcher.group(2)) > 255
						|| Integer.parseInt(matcher.group(3)) > 255 || Integer.parseInt(matcher.group(4)) > 255){
					return false;
				}
			}
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 是否是Int类型的数字
	 * @param port 端口号
	 * @return true：匹配正确，false：匹配错误
	 */
	public static boolean isPort(String port){
		Pattern pattern = Pattern.compile("^[1-9]{1}[0-9]+$");
		Matcher matcher = pattern.matcher(port);
		return matcher.matches();
	}
}
