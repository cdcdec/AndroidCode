/**  
 * Project Name:Voice_Combine_IM_DEMO  
 * File Name:TelephoneUserInfo.java  
 * Package Name:com.yzx.db.domain  
 * Date:2015-12-14上午9:46:03  
 * Copyright (c) 2015, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package com.yzx.db.domain;  

import java.io.Serializable;

/**  
 * @Title TelephoneUserInfo   
 * @Description 音视频电话用户个人信息
 * @Company yunzhixun  
 * @author xhb
 * @date 2015-12-14 上午9:46:07  
 */
@SuppressWarnings("serial")
public class TelUsersInfo implements Serializable{
	private int id;
	private String gravator;	// 头像
	private String name;		// 昵称
	private String telephone;	// 电话号码
	private int dialFlag; 		// 呼入呼出标志，0：呼入；1：呼出；2:未接
	private String time;		// 最后一次拨打时间
	private int telMode;		// 拨打电话方式 1：代表语音通话,2:代表视频通话
	private String dialMessage;	// 拨打电话内容信息
	private String loginPhone;	// 当前登录的手机号码
	
	public String getLoginPhone() {
		return loginPhone;
	}

	public void setLoginPhone(String loginPhone) {
		this.loginPhone = loginPhone;
	}

	public void setTelListsInfo(TelListsInfo telListsInfo) {
		setGravator(telListsInfo.getGravator());
		setName(telListsInfo.getName());
		setDialFlag(telListsInfo.getDialFlag());
		setTime(telListsInfo.getTime());
		setTelMode(telListsInfo.getTelMode());
		setTelephone(telListsInfo.getTelephone());
		setLoginPhone(telListsInfo.getLoginPhone());
	}
	
	public int getDialFlag() {
		return dialFlag;
	}
	public void setDialFlag(int dialFlag) {
		this.dialFlag = dialFlag;
	}
	public int getTelMode() {
		return telMode;
	}
	public void setTelMode(int telMode) {
		this.telMode = telMode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGravator() {
		return gravator;
	}
	public void setGravator(String gravator) {
		this.gravator = gravator;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDialMessage() {
		return dialMessage;
	}
	public void setDialMessage(String dialMessage) {
		this.dialMessage = dialMessage;
	}
	
}
  
