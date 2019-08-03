package com.sdk;

import android.annotation.SuppressLint;
import android.text.format.DateUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.example.netsdk_demo.CAlarmReport;

//import java.util.Vector;

class MapAlarmType
{
	MapAlarmType(int dwAlarmType, String strAlarmType)
	{
		this.dwAlarmType = dwAlarmType;
		this.strAlarmType = strAlarmType;
	}
	public int dwAlarmType = 0;
	public String strAlarmType = "";
}

public class AlarmCallBack_PF {

	MapAlarmType[] alarmTypeMap = {new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_MOVE_DETECT,"move detect"),
									new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_VIDEO_LOST,"video lost"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_VIDEO_TAMPER_DETECT,"video tamper detect"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_INPUT_SWITCH,"input switch"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_TEMPERATURE_HIGH,"temperature high"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_TEMPERATURE_LOW,"temperature low"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_AUDIO_DETECT,"audio detect"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_DISK_ABNORMAL,"disk abnormal"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_DISK_OFFLINE,"disk offline"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_DISK_ONLINE,"disk online"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_DISK_STORAGE_WILL_FULL,"disk storage will pull"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_DISK_STORAGE_IS_FULL,"disk storage is full"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_DISK_RAID_DISABLED,"disk raid disabled"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_DISK_RAID_DEGRADED,"disk raid degraded"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_DISK_RAID_RECOVERED,"disk raid recovered"),

			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_REPORT_DEV_ONLINE,"device online"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_REPORT_DEV_OFFLINE,"device offline"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_REPORT_DEV_REBOOT,"device reboot"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_REPORT_DEV_SERVICE_REBOOT,"device service reboot"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_REPORT_DEV_DELETE_CHL,"device delete chl"),

			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_NET_FAILED,"network failed"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_NET_TIMEOUT,"network timeout"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_SHAKE_FAILED,"shake failed"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_STREAMNUM_FULL,"stream num full"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_STREAM_THIRDSTOP,"stream third stop"),

			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_FILE_END,"file end"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_RTMP_CONNECT_FAIL,"rtmp connect fail"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_RTMP_INIT_FAIL,"rtmp init fail"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_STOR_ERR,"store error"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_STOR_DISOBEY_PLAN,"store error "),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_DISK_ERROR,"disk error"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_ILLEGAL_ACCESS,"illegal access"),

			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_LINE_CROSS,"line cross"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_OBJECTS_INSIDE,"inside"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_FACE_RECOGNIZE,"face recognize"),

			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_IMAGE_BLURRY,"image blurry"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_SCENE_CHANGE,"scene change"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_SMART_TRACK,"smart track"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_LOITERING_DETECTOR,"loitering detector"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_ALLTIME_FLAG_END,"all time falg end"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_MEDIA_CONFIG_CHANGE,"meida config change"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_REMAIN_ARTICLE,"remain article"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_PEOPLE_GATHER,"people gather"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_ENTER_AREA,"enter area"),

			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_LEAVE_AREA,"leave area"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_ARTICLE_MOVE,"article move"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_MOVE_DETECT_RECOVER,"move detect recover"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_VIDEO_LOST_RECOVER,"video lost recover"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_VIDEO_TAMPER_RECOVER,"video tamper recover"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_INPUT_SWITCH_RECOVER,"input switch recover"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_TEMPERATURE_RECOVER,"temperature recover"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_AUDIO_DETECT_RECOVER,"audio detect recover"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_DISK_ABNORMAL_RECOVER,"disk abnormal recover"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_DISK_STORAGE_WILL_FULL_RECOVER,"disk storage will full recover"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_DISK_STORAGE_IS_FULL_RECOVER,"disk storage is full recover"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_DISK_RAID_DISABLED_RECOVER,"disk raid disabled recover"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_DISK_RAID_DEGRADED_RECOVER,"disk raid degraded recover"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_STOR_ERR_RECOVER,"storage error recover"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_STOR_DISOBEY_PLAN_RECOVER,"storage disobey plan recover"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_IMAGE_BLURRY_RECOVER,"image blurry recover"),

			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_SMART_TRACK_RECOVER,"smart track recover"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_IP_CONFLICT,"ip conflict"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_IP_CONFLICT_CLEARED,"ip conflict cleared"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_SMART_READ_ERROR_RATE,"smart read error rate"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_SMART_SPIN_UP_TIME,"smart spin up time"),

			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_SMART_START_STOP_COUNT,"smart start stop count"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_SMART_REALLOCATED_SECTOR_COUNT,"smart reallocated sector count"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_SMART_SEEK_ERROR_RATE,"smart seek error rate"),

			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_SMART_POWER_ON_HOURS,"smart power on hours"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_SMART_SPIN_RETRY_COUNT,"smart spin retry count"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_SMART_CALIBRATION_RETRY_COUNT,"smart calibration replay count"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_SMART_POWER_CYCLE_COUNT,"smart power cycle count"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_SMART_POWEROFF_RETRACT_COUNT,"smart power off retract count"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_SMART_LOAD_CYCLE_COUNT,"smart load cycle count"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_SMART_TEMPERATURE_CELSIUS,"smart temperature celsius"),

			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_SMART_REALLOCATED_EVENT_COUNT,"smart reallocated event count"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_SMART_CURRENT_PENDING_SECTOR,"smart current pending sector"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_SMART_OFFLINE_UNCORRECTABLE,"smart offline uncorrectable"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_SMART_UDMA_CRC_ERROR_COUNT,"smart udma crc error count"),
			new MapAlarmType(NetDEVSDK.NETDEV_ALARM_TYPE_E.NETDEV_ALARM_SMART_MULTI_ZONE_ERROR_RATE,"smart multi zone error rate")
	};

	public static int mAlarmcnt = 0;
	//public static NETDEV_ALARMINFO_S[] mAlarmlist = new NETDEV_ALARMINFO_S[8];
	public static List<String> mAlarmlist = new ArrayList<String>();
	
	public static List<String> getData(int offset, int maxnumber)
    {
		//List<String> temp = new ArrayList<String>();
		return mAlarmlist;
    }
	

	/*
	 * Callback function to receive alarm information
	 * @param  iUserID              	ID User login ID
	 * @param  iChannelID           	Channel number
	 * @param  dwIndex                  index
	 * @param  iAlarmType          	Alarm type
	 * @param  tAlarmTime           	Alarm time
	 * @param  strName              	Alarm source name
	 * @param  iBufLen             	Length of structure for alarm information
	 * @note*/
	@SuppressLint("SimpleDateFormat")
	public void alarmCallBack(int iUserID, int iAlarmSrcType, int iChannelID, int dwIndex, int iAlarmType, int tAlarmTime, String strName) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long timeLong = Long.valueOf(tAlarmTime);
		String  strTime =  sdf.format(new Date(timeLong * 1000L));

		String strAlarmInfo = "";
		for (MapAlarmType st : alarmTypeMap) {
			if(iAlarmType == st.dwAlarmType)
			{
				strAlarmInfo = st.strAlarmType;
			}
		}

		if(strAlarmInfo == "")
		{
			return;
		}

		mAlarmlist.add(0, strTime + " \r\n ChannelID : " + iChannelID  + " : " + strAlarmInfo + " " + strName);
		//CAlarmReport.updateAlarmInfoPage();
		mAlarmcnt++;
		System.out.println("Android Report alarm info , iAlarmSrcType:" +  iAlarmSrcType + ", Time :" +  strTime + " UserID : " + iUserID + " , ChannelID : " + iChannelID +  " Index: " + dwIndex + ",AlarmType : " + strAlarmInfo);
	}
}
