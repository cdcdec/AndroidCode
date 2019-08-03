package com.yzx.db.domain;


/**
* @Title UserSetting 
* @Description 用户设置domain
* @Company yunzhixun
* @author zhuqian
* @date 2015-12-2 下午2:35:01 
*/
public class UserSetting {

	@Override
	public String toString() {
		return "UserSetting [id=" + id + ", account=" + account
				+ ", msgNotify=" + msgNotify + ", msgVoice=" + msgVoice
				+ ", msgVitor=" + msgVitor + ", token=" + token
				+ ", asAddressAndPort=" + asAddressAndPort
				+ ", tcpAddressAndPort=" + tcpAddressAndPort + "]";
	}
	public UserSetting(String account, int msgNotify, int msgVoice,
			int msgVitor, String token) {
		this.account = account;
		this.msgNotify = msgNotify;
		this.msgVoice = msgVoice;
		this.msgVitor = msgVitor;
		this.token = token;
	}
	public UserSetting(){
		
	}
	private String id;
	private String account;
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
	public int getMsgNotify() {
		return msgNotify;
	}
	public void setMsgNotify(int msgNotify) {
		this.msgNotify = msgNotify;
	}
	public int getMsgVoice() {
		return msgVoice;
	}
	public void setMsgVoice(int msgVoice) {
		this.msgVoice = msgVoice;
	}
	public int getMsgVitor() {
		return msgVitor;
	}
	public void setMsgVitor(int msgVitor) {
		this.msgVitor = msgVitor;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getAsAddressAndPort() {
		return asAddressAndPort;
	}
	public void setAsAddressAndPort(String asAddressAndPort) {
		this.asAddressAndPort = asAddressAndPort;
	}
	public String getTcpAddressAndPort() {
		return tcpAddressAndPort;
	}
	public void setTcpAddressAndPort(String tcpAddressAndPort) {
		this.tcpAddressAndPort = tcpAddressAndPort;
	}
	//1表示开，0表示关
	private int msgNotify;
	private int msgVoice;
	private int msgVitor;
	
	private String token;
	private String asAddressAndPort;
	private String tcpAddressAndPort;
}
