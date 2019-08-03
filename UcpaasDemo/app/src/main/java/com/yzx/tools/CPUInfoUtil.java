package com.yzx.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Locale;

import com.yzxtcp.tools.CustomLog;

import android.text.TextUtils;
import android.util.Log;

public class CPUInfoUtil {
	/** The system property key of CPU arch type */
	private static final String CPU_ARCHITECTURE_KEY_64 = "ro.product.cpu.abilist64";
	private static final String PROC_CPU_INFO_PATH = "/proc/cpuinfo";

	/**
	 * @author zhangbin
	 * @2015-12-29
	 * @return
	 * @descript:判断CPU是否是64位
	 */
	public static boolean isCPU64Bit() {
		if (TextUtils.isEmpty(getSystemProperty(CPU_ARCHITECTURE_KEY_64, ""))) {
			if (isCPUInfo64()) {
				CustomLog.d("64bit cpu");
				return true;
			} else {
				CustomLog.d("32bit cpu");
				return false;
			}
		} else {
			CustomLog.d("64bit cpu");
			return true;
		}
	}

	/**
	 * @author zhangbin
	 * @2015-12-29
	 * @param key 属性KEY值
	 * @param defaultValue 默认值
	 * @return
	 * @descript:获取系统属性
	 */
	private static String getSystemProperty(String key, String defaultValue) {
		boolean LOGENABLE = true;
		String value = defaultValue;
		try {
			Class<?> clazz = Class.forName("android.os.SystemProperties");
			Method get = clazz.getMethod("get", String.class, String.class);
			value = (String) (get.invoke(clazz, key, ""));
		} catch (Exception e) {
			if (LOGENABLE) {
				Log.d("getSystemProperty",
						"key = " + key + ", error = " + e.getMessage());
			}
		}

		if (LOGENABLE) {
			Log.d("getSystemProperty", key + " = " + value);
		}
		return value;
	}

	/**
	 * @author zhangbin
	 * @2015-12-29
	 * @return
	 * @descript:判断CPU信息文件里是否包含arch64
	 */
	private static boolean isCPUInfo64() {
		File cpuInfo = new File(PROC_CPU_INFO_PATH);
		if (cpuInfo != null && cpuInfo.exists()) {
			InputStream inputStream = null;
			BufferedReader bufferedReader = null;
			try {
				inputStream = new FileInputStream(cpuInfo);
				bufferedReader = new BufferedReader(new InputStreamReader(
						inputStream), 512);
				String line = bufferedReader.readLine();
				if (line != null && line.length() > 0
						&& line.toLowerCase(Locale.US).contains("arch64")) {

					return true;
				}
			} catch (Throwable t) {

			} finally {
				try {
					if (bufferedReader != null) {
						bufferedReader.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				try {
					if (inputStream != null) {
						inputStream.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
}
