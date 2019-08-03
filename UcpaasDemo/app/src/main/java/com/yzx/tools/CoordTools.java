package com.yzx.tools;

import com.baidu.mapapi.model.LatLng;

/**
 * @Title CoordTools
 * @Description 坐标转换工具
 * @Company yunzhixun
 * @author zhuqian
 * @date 2015-12-11 上午10:06:55
 */
public class CoordTools {
	public static double x_pi = 3.14159265358979324 * 3000.0 / 180.0;

	/**
	 * @Description 将百度坐标转换为火星坐标
	 * @param bd_lat
	 *            经度
	 * @param bd_lon
	 *            纬度
	 * @return 百度坐标
	 * @date 2015-12-11 上午10:45:43
	 * @author zhuqian
	 * @return LatLng
	 */
	public static LatLng bd_decrypt(double bd_lat, double bd_lon) {
		double x = bd_lon - 0.0065, y = bd_lat - 0.006;
		double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_pi);
		double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * x_pi);
		double gg_lon = z * Math.cos(theta);
		double gg_lat = z * Math.sin(theta);
		return new LatLng(gg_lat, gg_lon);
	}

	/**
	 * @Description 火星坐标转换为百度坐标
	 * @param gg_lat
	 *            经度
	 * @param gg_lon
	 *            纬度
	 * @return 百度坐标
	 * @date 2015-12-11 上午11:10:16
	 * @author zhuqian
	 * @return LatLng
	 */
	public static LatLng bd_encrypt(double gg_lat, double gg_lon) {
		double x = gg_lon, y = gg_lat;
		double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
		double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
		double bd_lon = z * Math.cos(theta) + 0.0065;
		double bd_lat = z * Math.sin(theta) + 0.006;
		return new LatLng(bd_lat, bd_lon);
	}
}
