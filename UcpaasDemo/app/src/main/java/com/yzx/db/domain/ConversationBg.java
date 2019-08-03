package com.yzx.db.domain;


/**
* @Title ConversationBg 
* @Description 会话背景domain
* @Company yunzhixun
* @author zhuqian
* @date 2015-12-2 下午2:44:24 
*/
public class ConversationBg {
	private String id;
	private String account;
	private String targetId;
	private String bgPath;
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
	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	public String getBgPath() {
		return bgPath;
	}
	public void setBgPath(String bgPath) {
		this.bgPath = bgPath;
	}
}
