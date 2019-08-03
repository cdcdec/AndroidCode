package com.yzx.tools;

import java.util.List;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import com.yzx.db.domain.UserSetting;
import com.yzx.im_demo.IMBroadcastActivity;
import com.yzx.im_demo.IMMessageActivity;
import com.yzx.im_demo.MainApplication;
import com.yzx.im_demo.R;
import com.yzx.model.SortModel;
import com.yzxIM.IMManager;
import com.yzxIM.data.CategoryId;
import com.yzxIM.data.db.ChatMessage;
import com.yzxIM.data.db.ConversationInfo;
import com.yzxtcp.tools.CustomLog;

public class NotificationTools {

	private static int num = 0;
	private static Vibrator vibrator;
	private static long[] pattern = { 100, 400, 100, 400 }; // 停止 开启 停止 开启

	@RequiresApi(api = Build.VERSION_CODES.Q)
	public static void showNotification(UserSetting userSetting, ChatMessage msg) {
		if (isMessageActivity(MainApplication.getInstance())) {
			CustomLog.d("聊天页面正在显示，不需要通知");
			return;
		}
		if (userSetting.getMsgNotify() == 1 && userSetting.getMsgVoice() == 1) {
			Uri notifytone = RingtoneManager
					.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
			Ringtone r = RingtoneManager.getRingtone(
					MainApplication.getInstance(), notifytone);
			r.play();
		}
		if (userSetting.getMsgNotify() == 1 && userSetting.getMsgVitor() == 1) {
			if (null == vibrator) {
				vibrator = (Vibrator) MainApplication.getInstance()
						.getSystemService(Context.VIBRATOR_SERVICE);
			}
			vibrator.vibrate(pattern, -1);
		}

		if (userSetting.getMsgNotify() == 0
				|| !isBackground(MainApplication.getInstance())) {
			return;
		}

		NotificationCompat.Builder builder = new NotificationCompat.Builder(
				MainApplication.getInstance());
		builder.setSmallIcon(R.drawable.ic_launcher);
		builder.setDefaults(0);
		builder.setAutoCancel(true);
		builder.setContentTitle("新的消息");

		if (userSetting.getMsgNotify() == 1) {
			// notification.vibrate = pattern;
		}
		if (userSetting.getMsgVoice() == 1) {
			// notification.sound =
			// RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		}
		CharSequence contentTitle = "云之讯";
		CharSequence contentText = "";
		List<SortModel> sourceDateList = ContactTools.getSourceDateList();
		switch (msg.getMsgType()) {
		// 文本
		case MSG_DATA_TEXT:
			contentText = new String(msg.getSenderId()) + ": "
					+ msg.getContent();
			break;
		// 图片
		case MSG_DATA_IMAGE:
			contentText = new String(msg.getSenderId()) + ": 图片消息";
			for (SortModel model : sourceDateList) {
				if (model.getId().equals(new String(msg.getSenderId()))) {
					contentText = model.getName() + ": 图片消息";
					break;
				}
			}
			break;
		// 语音
		case MSG_DATA_VOICE:
			contentText = new String(msg.getSenderId()) + ": 语音消息";
			for (SortModel model : sourceDateList) {
				if (model.getId().equals(new String(msg.getSenderId()))) {
					contentText = model.getName() + ": 语音消息";
					break;
				}
			}
			break;
		case MSG_DATA_LOCALMAP:
			contentText = new String(msg.getSenderId()) + ": 地图消息";
			for (SortModel model : sourceDateList) {
				if (model.getId().equals(new String(msg.getSenderId()))) {
					contentText = model.getName() + ": 地图消息";
					break;
				}
			}
			break;
		case MSG_DATA_CUSTOMMSG:
			contentText = new String(msg.getSenderId()) + ": 自定义消息";
			for (SortModel model : sourceDateList) {
				if (model.getId().equals(new String(msg.getSenderId()))) {
					contentText = model.getName() + ": 自定义消息";
					break;
				}
			}
			break;
		}
		Intent notificationIntent = new Intent();
		try {
			if(IMManager.getInstance(null).getConversation(msg.getParentID()).getCategoryId() == CategoryId.BROADCAST){
				contentText = "您有一条新的广播消息";
				notificationIntent = new Intent(MainApplication.getInstance(),
						IMBroadcastActivity.class);
			}else{
				notificationIntent = new Intent(MainApplication.getInstance(),
						IMMessageActivity.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
			CustomLog.e(e.getMessage());
		}
		
		
		num++;
		if (num > 1) {
			contentText = "你有" + num + "条未读消息";
		}

		ConversationInfo info = IMManager.getInstance(
				MainApplication.getInstance()).getConversation(
				msg.getParentID());
		if (null == info) {
			CustomLog.e("Notification info is null");
			return;
		}
		builder.setContentText(contentText);
		notificationIntent.putExtra("conversation", info);
		notificationIntent.setAction(System.currentTimeMillis() + "");
		notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
				| Intent.FLAG_ACTIVITY_NEW_TASK);
		PendingIntent contentIntent = PendingIntent.getActivity(
				MainApplication.getInstance(), 0, notificationIntent, 0);
		builder.setContentIntent(contentIntent);
		MainApplication.nm.notify(1000, builder.build());
	}

	public static void clearUnreadNum() {
		num = 0;
	}

	/**
	 * @Description 是否是聊天页面
	 * @return
	 * @date 2015-12-18 上午10:06:02
	 * @author zhuqian
	 * @return boolean
	 */
	@RequiresApi(api = Build.VERSION_CODES.Q)
	public static boolean isMessageActivity(Context context) {
		ActivityManager manager = (ActivityManager) context
				.getSystemService(Context.ACTIVITY_SERVICE);
		List<RunningTaskInfo> runningTasks = manager.getRunningTasks(1);
		RunningTaskInfo cinfo = runningTasks.get(0);
		ComponentName component = cinfo.topActivity;
		String resumeClassName = component.getClassName();
		CustomLog.d("当前获取焦点的Activity class name ：" + resumeClassName);
		if (!TextUtils.isEmpty(resumeClassName)
				&& resumeClassName.equals("com.yzx.im_demo.IMMessageActivity")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isBackground(Context context) {
		ActivityManager activityManager = (ActivityManager) context
				.getSystemService(Context.ACTIVITY_SERVICE);
		List<RunningAppProcessInfo> appProcesses = activityManager
				.getRunningAppProcesses();
		for (RunningAppProcessInfo appProcess : appProcesses) {
			if (appProcess.processName.equals(context.getPackageName())) {

				if (appProcess.importance != RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
					CustomLog.d("处于后台" + appProcess.processName);
					return true;
				} else {
					CustomLog.d("处于前台" + appProcess.processName);
					return false;
				}
			}
		}
		return false;
	}
}
