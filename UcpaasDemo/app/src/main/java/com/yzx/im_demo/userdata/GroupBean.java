package com.yzx.im_demo.userdata;

import java.util.List;

public class GroupBean {
	@Override
	public String toString() {
		return "GroupBean [groupicon=" + groupicon + ", groupID=" + groupID
				+ ", groupName=" + groupName + ", userLists=" + userLists + "]";
	}

	private String groupicon="";
	private String groupID="";
	private String groupName="";
	private List<UserList> userLists;

	public String getGroupicon() {
		return groupicon;
	}

	public void setGroupicon(String groupicon) {
		this.groupicon = groupicon;
	}

	public String getGroupID() {
		return groupID;
	}

	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}

	
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<UserList> getUserLists() {
		return userLists;
	}

	public void setUserLists(List<UserList> userLists) {
		this.userLists = userLists;
	}

}


