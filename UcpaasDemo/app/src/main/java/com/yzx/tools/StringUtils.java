package com.yzx.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	public static boolean isEmpty(CharSequence str) {
		if (str == null || str.length() == 0)
			return true;
		else
			return false;
	}

	/**
	 * 匹配手机
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isPhoneNumber(String number){
/*		三大运营商号段： 在百度百科上查询结果
		中国移动号段：134、135、136、137、138、139、150、151、152、157、158、159、147、182、183、184、187、188、1705[1]  、178
		中国联通号段：130、131、132、145（145属于联通无线上网卡号段）、155、156、185、186 、176、1709[1]  、176
		中国电信号段：133 、153 、180 、181 、189、1700[1]  、177*/
		Pattern p = Pattern.compile("^((1[358][0-9])|(14[57])|(17[0678]))\\d{8}$");  
		Matcher m = p.matcher(number); 
		return m.matches();  
	}
}
