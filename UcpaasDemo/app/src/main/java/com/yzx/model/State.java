package com.yzx.model;

import android.content.Context;


/**
 * 状态描述
 * @author zhuqian
 */
public interface State {

	void action(Context context,String token);
}
