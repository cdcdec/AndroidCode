package com.yzx.db.domain; 

import java.io.Serializable;

/**  
 * @Title TelListsInfo   
 * @Description  创建电话消息表
 * @Company yunzhixun  
 * @author xhb
 * @date 2015-12-14 上午9:38:26  
 */
@SuppressWarnings("serial")
public class TelListsInfo implements Serializable{
	private int id;
	private String gravator;	// 头像
	private String name;		// 昵称
	private int dialFlag; 		// 呼入呼出标志，0：呼入；1：呼出；2:呼入未接；3：呼出未接
	private int telMode;		// 拨打电话方式 1：代表语音通话,2:代表视频通话
	private String time;		// 最后一次拨打时间
	private String telephone;	// 电话号码
	private String loginPhone;	// 当前用户登录的电话号码
	private int isTop;//是否置顶
	public int getIsTop() {
		return isTop;
	}
	public void setIsTop(int isTop) {
		this.isTop = isTop;
	}
	public String getLoginPhone() {
		return loginPhone;
	}
	public void setLoginPhone(String loginPhone) {
		this.loginPhone = loginPhone;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "TelListsInfo: gravator=" + getGravator()
				+ ", name=" + getName() + ", dialFlag=" + getDialFlag()
				+ ", telMode=" + getTelMode() + ", time=" + getTime()
				+ ", loginPhone-" + getLoginPhone();
	}
}
  
