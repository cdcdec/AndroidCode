package com.yzx.im_demo.adapter.domain;


/**
 * 透传数据
 * @author zhuqian
 */
public class TransData {

	public TransData(String data, String account) {
		this.data = data;
		this.account = account;
	}
	private String data;
	private String account;
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
}
