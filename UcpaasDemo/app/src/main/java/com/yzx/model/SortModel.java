package com.yzx.model;

import android.graphics.Bitmap;

public class SortModel {

	private String name; //用户名
	private String sortLetters; //起始字母
	private String id; // 账号
	private Bitmap bitmap;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSortLetters() {
		return sortLetters;
	}

	public void setSortLetters(String sortLetters) {
		this.sortLetters = sortLetters;
	}

	public Bitmap getBitmap() {
		return bitmap;
	}

	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

	public String getId() {
		return id.replace(" ", "");
	}

	public void setId(String id) {
		this.id = id;
	}
}
