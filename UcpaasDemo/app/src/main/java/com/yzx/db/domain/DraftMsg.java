package com.yzx.db.domain;


/**
* @Title DraftMsg 
* @Description 草稿domain
* @Company yunzhixun
* @author zhuqian
* @date 2015-12-2 下午2:46:08 
*/
public class DraftMsg {
	public DraftMsg(String account, String targetId, String draftMsg) {
		super();
		this.account = account;
		this.targetId = targetId;
		this.draftMsg = draftMsg;
	}
	
	public DraftMsg(){
		
	}
	private String id;
	private String account;
	private String targetId;
	private String draftMsg;
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
	public String getDraftMsg() {
		return draftMsg;
	}
	public void setDraftMsg(String draftMsg) {
		this.draftMsg = draftMsg;
	}
}
