package com.yzx.db.domain;


/**
* @Title UserInfo 
* @Description 用户信息表
* @Company yunzhixun
* @author zhuqian
* @date 2015-12-2 下午12:27:42 
*/
public class UserInfo {
	
	public UserInfo(String account, String name, int loginStatus,
			int defaultLogin) {
		this.account = account;
		this.name = name;
		this.loginStatus = loginStatus;
		this.defaultLogin = defaultLogin;
	}
	public UserInfo(){
		
	}
	private String id;
	private String account;
	private String name;
	private String veriCode;//验证码
	//1表示登录状态，0表示为非登录状态
	private int loginStatus;
	//1表示该账号是默认登录账号，0表示非默认登录账号
	private int defaultLogin;
	public int getDefaultLogin() {
		return defaultLogin;
	}
	public void setDefaultLogin(int defaultLogin) {
		this.defaultLogin = defaultLogin;
	}
	public int getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getVeriCode() {
        return veriCode;
    }
    public void setVeriCode(String veriCode) {
        this.veriCode = veriCode;
    }
	
	
}
