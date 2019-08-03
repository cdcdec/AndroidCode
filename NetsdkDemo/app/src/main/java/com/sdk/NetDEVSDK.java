package com.sdk;

import java.util.ArrayList;

import com.sdk.AlarmCallBack_PF;

import android.view.Surface;


public class NetDEVSDK {
	static {
		System.loadLibrary("Curl");
		System.loadLibrary("RSA");
		System.loadLibrary("MP4");
		System.loadLibrary("MP2");
		System.loadLibrary("mXML");
		System.loadLibrary("NDRtmp");
		System.loadLibrary("CloudSDK");
		System.loadLibrary("RM_Module");
		System.loadLibrary("NDRender");
		System.loadLibrary("dspvideomjpeg");
		System.loadLibrary("NDPlayer");
		System.loadLibrary("Discovery");
        System.loadLibrary("NetDEVSDK");
        System.loadLibrary("NetDEVSDK_JNI");
    }
   
	//private OnNotifyListener mNotifyListener;
 	public static int lpUserID;       	/* User ID*/
	public static int gdwWinIndex;       	/* User ID*/
 	public static int glpcloudID;      	/* Cloud ID*/
	public static int lpDownloadID;      	/* Cloud ID*/
	public static String strDevName;
 	public static NETDEV_FINDDATA_S []m_astVodFile = new NETDEV_FINDDATA_S[1000];
 	
	/**
	 * @enum tagNETDEVAlarmTypeEn
	 * @brief  Alarm Type Enumeration definition
	 * @attention None
	 */
	public class NETDEV_ALARM_TYPE_E
	{
		public static final int NETDEV_ALARM_MOVE_DETECT                = 1;        /* 运动检测告警  Motion detection alarm */
		public static final int NETDEV_ALARM_MOVE_DETECT_RECOVER        = 2;        /* 运动检测告警恢复  Motion detection alarm recover */
		public static final int NETDEV_ALARM_VIDEO_LOST                 = 3;        /* 视频丢失告警  Video loss alarm */
		public static final int NETDEV_ALARM_VIDEO_LOST_RECOVER         = 4;        /* 视频丢失告警恢复  Video loss alarm recover */
		public static final int NETDEV_ALARM_VIDEO_TAMPER_DETECT        = 5;        /* 遮挡侦测告警  Tampering detection alarm */
		public static final int NETDEV_ALARM_VIDEO_TAMPER_RECOVER       = 6;        /* 遮挡侦测告警恢复  Tampering detection alarm recover */
		public static final int NETDEV_ALARM_INPUT_SWITCH               = 7;        /* 输入开关量告警  boolean input alarm */
		public static final int NETDEV_ALARM_INPUT_SWITCH_RECOVER       = 8;        /* 输入开关量告警恢复  Boolean input alarm recover */
		public static final int NETDEV_ALARM_TEMPERATURE_HIGH           = 9;        /* 高温告警  High temperature alarm */
		public static final int NETDEV_ALARM_TEMPERATURE_LOW            = 10;       /* 低温告警  Low temperature alarm */
		public static final int NETDEV_ALARM_TEMPERATURE_RECOVER        = 11;       /* 温度告警恢复  Temperature alarm recover */
		public static final int NETDEV_ALARM_AUDIO_DETECT               = 12;       /* 音频异常检测告警  Audio detection alarm */
		public static final int NETDEV_ALARM_AUDIO_DETECT_RECOVER       = 13;       /* 音频异常检测告警恢复  Audio detection alarm recover */

		public static final int NETDEV_ALARM_REPORT_DEV_ONLINE          = 201;       /* 设备上线告警 */
		public static final int NETDEV_ALARM_REPORT_DEV_OFFLINE         = 202;       /* 设备下线告警 */
		public static final int NETDEV_ALARM_REPORT_DEV_REBOOT          = 203;       /* 设备重启  Device restart */
		public static final int NETDEV_ALARM_REPORT_DEV_SERVICE_REBOOT  = 204;       /* 服务重启  Service restart */
		public static final int NETDEV_ALARM_REPORT_DEV_CHL_ONLINE      = 205;       /* 视频通道: 上线 */
		public static final int NETDEV_ALARM_REPORT_DEV_CHL_OFFLINE     = 206;       /* 视频通道: 下线 */
		public static final int NETDEV_ALARM_REPORT_DEV_DELETE_CHL      = 207;       /* 视频通道: 删除 */

		public static final int NETDEV_ALARM_NET_FAILED                 = 401;      /* 会话网络错误 Network error */
		public static final int NETDEV_ALARM_NET_TIMEOUT                = 402;      /* 会话网络超时 Network timeout */
		public static final int NETDEV_ALARM_SHAKE_FAILED               = 403;      /* 会话交互错误 Interaction error */
		public static final int NETDEV_ALARM_STREAMNUM_FULL             = 404;      /* 流数已经满 Stream full */
		public static final int NETDEV_ALARM_STREAM_THIRDSTOP           = 405;      /* 第三方停止流 Third party stream stopped */
		public static final int NETDEV_ALARM_FILE_END                   = 406;      /* 文件结束 File ended */
		public static final int NETDEV_ALARM_RTMP_CONNECT_FAIL          = 407;      /* RTMP连接失败 */
		public static final int NETDEV_ALARM_RTMP_INIT_FAIL             = 408;      /* RTMP初始化失败*/

		public static final int NETDEV_ALARM_DISK_ERROR                         = 601;      /* 设备磁盘错误  Disk error */
		public static final int NETDEV_ALARM_SYS_DISK_ERROR                     = 602;      /* 系统磁盘错误  Disk error */
		public static final int NETDEV_ALARM_DISK_ONLINE                        = 603;      /* 设备磁盘上线 Disk online */
		public static final int NETDEV_ALARM_SYS_DISK_ONLINE                    = 604;      /* 系统磁盘上线 Disk online */
		public static final int NETDEV_ALARM_DISK_OFFLINE                       = 605;      /* 设备磁盘离线 */
		public static final int NETDEV_ALARM_SYS_DISK_OFFLINE                   = 606;      /* 系统磁盘离线 */
		public static final int NETDEV_ALARM_DISK_ABNORMAL                      = 607;      /* 磁盘异常 Disk abnormal */
		public static final int NETDEV_ALARM_DISK_ABNORMAL_RECOVER              = 608;      /* 磁盘异常恢复 Disk abnormal recover */
		public static final int NETDEV_ALARM_DISK_STORAGE_WILL_FULL             = 609;      /* 磁盘存储空间即将满 Disk StorageGoingfull */
		public static final int NETDEV_ALARM_DISK_STORAGE_WILL_FULL_RECOVER     = 610;      /* 磁盘存储空间即将满恢复 Disk StorageGoingfull recover */
		public static final int NETDEV_ALARM_DISK_STORAGE_IS_FULL               = 611;      /* 设备存储空间满 StorageIsfull */
		public static final int NETDEV_ALARM_SYS_DISK_STORAGE_IS_FULL           = 612;      /* 系统存储空间满 StorageIsfull */
		public static final int NETDEV_ALARM_DISK_STORAGE_IS_FULL_RECOVER       = 613;      /* 存储空间满恢复 StorageIsfull recover */
		public static final int NETDEV_ALARM_DISK_RAID_DISABLED_RECOVER         = 614;      /* 阵列损坏恢复 RAIDDisabled recover */
		public static final int NETDEV_ALARM_DISK_RAID_DEGRADED                 = 615;      /* 设备阵列衰退 RAIDDegraded */
		public static final int NETDEV_ALARM_SYS_DISK_RAID_DEGRADED             = 616;      /* 系统阵列衰退 RAIDDegraded */
		public static final int NETDEV_ALARM_DISK_RAID_DISABLED                 = 617;      /* 设备阵列损坏 RAIDDisabled */
		public static final int NETDEV_ALARM_SYS_DISK_RAID_DISABLED             = 618;      /* 系统阵列损坏 RAIDDisabled */
		public static final int NETDEV_ALARM_DISK_RAID_DEGRADED_RECOVER         = 619;      /* 阵列衰退恢复 RAIDDegraded recover */
		public static final int NETDEV_ALARM_STOR_GO_FULL                       = 620;      /* 设备存储即将满告警 */
		public static final int NETDEV_ALARM_SYS_STOR_GO_FULL                   = 621;      /* 系统存储即将满告警 */
		public static final int NETDEV_ALARM_ARRAY_NORMAL                       = 622;      /* 设备阵列正常 */
		public static final int NETDEV_ALARM_SYS_ARRAY_NORMAL                   = 623;      /* 系统阵列正常 */
		public static final int NETDEV_ALARM_DISK_RAID_RECOVERED                = 624;      /* 阵列恢复正常 RAIDDegraded */
		public static final int NETDEV_ALARM_STOR_ERR                           = 625;      /* 设备存储错误  Storage error */
		public static final int NETDEV_ALARM_SYS_STOR_ERR                       = 626;      /* 系统存储错误  Storage error */
		public static final int NETDEV_ALARM_STOR_ERR_RECOVER                   = 627;      /* 存储错误恢复  Storage error recover */
		public static final int NETDEV_ALARM_STOR_DISOBEY_PLAN                  = 628;      /* 未按计划存储  Not stored as planned */
		public static final int NETDEV_ALARM_STOR_DISOBEY_PLAN_RECOVER          = 629;      /* 未按计划存储恢复  Not stored as planned recover */

		public static final int NETDEV_ALARM_BANDWITH_CHANGE                    = 801;      /* 设备出口带宽变更 */
		public static final int NETDEV_ALARM_VIDEOENCODER_CHANGE                = 802;      /* 设备码流配置变更告警 */
		public static final int NETDEV_ALARM_IP_CONFLICT                        = 803;      /* IP冲突异常告警 IP conflict exception alarm*/
		public static final int NETDEV_ALARM_IP_CONFLICT_CLEARED                = 804;      /* IP冲突异常告警恢复IP conflict exception alarm recovery */
		public static final int NETDEV_ALARM_NET_OFF                            = 805;      /* 网络断开异常告警 */
		public static final int NETDEV_ALARM_NET_RESUME_ON                      = 806;      /* 网络断开恢复告警 */

		public static final int NETDEV_ALARM_ILLEGAL_ACCESS                     = 1001;          /* 设备非法访问  Illegal access */
		public static final int NETDEV_ALARM_SYS_ILLEGAL_ACCESS                 = 1002;          /* 系统非法访问  Illegal access */
		public static final int NETDEV_ALARM_LINE_CROSS                         = 1003;          /* 越界告警  Line cross */
		public static final int NETDEV_ALARM_OBJECTS_INSIDE                     = 1004;          /* 区域入侵  Objects inside */
		public static final int NETDEV_ALARM_FACE_RECOGNIZE                     = 1005;          /* 人脸识别  Face recognize */
		public static final int NETDEV_ALARM_IMAGE_BLURRY                       = 1006;          /* 图像虚焦  Image blurry */
		public static final int NETDEV_ALARM_SCENE_CHANGE                       = 1007;          /* 场景变更  Scene change */
		public static final int NETDEV_ALARM_SMART_TRACK                        = 1008;          /* 智能跟踪  Smart track */
		public static final int NETDEV_ALARM_LOITERING_DETECTOR                 = 1009;          /* 徘徊检测  Loitering Detector */
		public static final int NETDEV_ALARM_BANDWIDTH_CHANGE                   = 1010;          /* 带宽变更  Bandwidth change */
		public static final int NETDEV_ALARM_ALLTIME_FLAG_END                   = 1011;          /* 无布防告警结束标记  End marker of alarm without arming schedule */
		public static final int NETDEV_ALARM_MEDIA_CONFIG_CHANGE                = 1012;          /* 编码参数变更 media configurationchanged */
		public static final int NETDEV_ALARM_REMAIN_ARTICLE                     = 1013;          /*物品遗留告警  Remain article*/
		public static final int NETDEV_ALARM_PEOPLE_GATHER                      = 1014;          /* 人员聚集告警 People gather alarm*/
		public static final int NETDEV_ALARM_ENTER_AREA                         = 1015;          /* 进入区域 Enter area*/
		public static final int NETDEV_ALARM_LEAVE_AREA                         = 1016;          /* 离开区域 Leave area*/
		public static final int NETDEV_ALARM_ARTICLE_MOVE                       = 1017;          /* 物品搬移 Article move*/
		public static final int NETDEV_ALARM_SMART_FACE_MATCH_LIST                  = 1018;       /* 人脸识别黑名单报警 */
		public static final int NETDEV_ALARM_SMART_FACE_MATCH_LIST_RECOVER          = 1019;       /* 人脸识别黑名单报警恢复 */
		public static final int NETDEV_ALARM_SMART_FACE_MISMATCH_LIST               = 1020;       /* 人脸识别不匹配报警 */
		public static final int NETDEV_ALARM_SMART_FACE_MISMATCH_LIST_RECOVER       = 1021;       /* 人脸识别不匹配报警恢复 */
		public static final int NETDEV_ALARM_SMART_VEHICLE_MATCH_LIST               = 1022;       /* 车辆识别匹配报警 */
		public static final int NETDEV_ALARM_SMART_VEHICLE_MATCH_LIST_RECOVER       = 1023;       /* 车辆识别匹配报警恢复 */
		public static final int NETDEV_ALARM_SMART_VEHICLE_MISMATCH_LIST            = 1024;       /* 车辆识别不匹配报警 */
		public static final int NETDEV_ALARM_SMART_VEHICLE_MISMATCH_LIST_RECOVER    = 1025;       /* 车辆识别不匹配报警回复 */
		public static final int NETDEV_ALARM_IMAGE_BLURRY_RECOVER               = 1026;         /* 图像虚焦告警恢复  Image blurry recover */
		public static final int NETDEV_ALARM_SMART_TRACK_RECOVER                = 1027;         /* 智能跟踪告警恢复  Smart track recover */
		public static final int NETDEV_ALARM_SMART_READ_ERROR_RATE              = 1028;         /* 底层数据读取错误率Error reding the underlying data */
		public static final int NETDEV_ALARM_SMART_SPIN_UP_TIME                 = 1029;         /* 主轴起旋时间  Rotation time of spindle */
		public static final int NETDEV_ALARM_SMART_START_STOP_COUNT             = 1030;         /* 启停计数 Rev. Stop counting*/
		public static final int NETDEV_ALARM_SMART_REALLOCATED_SECTOR_COUNT     = 1031;         /* 重映射扇区计数  Remap sector count*/
		public static final int NETDEV_ALARM_SMART_SEEK_ERROR_RATE              = 1032;         /* 寻道错误率 Trace error rate*/
		public static final int NETDEV_ALARM_SMART_POWER_ON_HOURS               = 1033;         /* 通电时间累计，出厂后通电的总时间，一般磁盘寿命三万小时 */
		public static final int NETDEV_ALARM_SMART_SPIN_RETRY_COUNT             = 1034;         /* 主轴起旋重试次数 */
		public static final int NETDEV_ALARM_SMART_CALIBRATION_RETRY_COUNT      = 1035;         /* 磁头校准重试计数 */
		public static final int NETDEV_ALARM_SMART_POWER_CYCLE_COUNT            = 1036;         /* 通电周期计数 */
		public static final int NETDEV_ALARM_SMART_POWEROFF_RETRACT_COUNT       = 1037;         /* 断电返回计数 */
		public static final int NETDEV_ALARM_SMART_LOAD_CYCLE_COUNT             = 1038;         /* 磁头加载计数 */
		public static final int NETDEV_ALARM_SMART_TEMPERATURE_CELSIUS          = 1039;         /* 温度 */
		public static final int NETDEV_ALARM_SMART_REALLOCATED_EVENT_COUNT      = 1040;         /* 重映射事件计数 */
		public static final int NETDEV_ALARM_SMART_CURRENT_PENDING_SECTOR       = 1041;         /* 当前待映射扇区计数 */
		public static final int NETDEV_ALARM_SMART_OFFLINE_UNCORRECTABLE        = 1042;         /* 脱机无法校正的扇区计数 */
		public static final int NETDEV_ALARM_SMART_UDMA_CRC_ERROR_COUNT         = 1043;         /* 奇偶校验错误率  */
		public static final int NETDEV_ALARM_SMART_MULTI_ZONE_ERROR_RATE        = 1044;         /* 多区域错误率 */
		public static final int NETDEV_ALARM_RESOLUTION_CHANGE                  = 1045;         /* 分辨率变更 */
		public static final int NETDEV_ALARM_MANUAL                             = 1401;         /* 手动告警 */
		public static final int NETDEV_ALARM_ALARMHOST_COMMON                   = 1402;         /* 报警点事件 */
		public static final int NETDEV_ALARM_DOORHOST_COMMON                    = 1403;         /* 门禁事件 */

    	/*  Cloud media view exception report 2793~2809 */
		public static final int NETDEV_ALARM_CLOUD_DOWNLOAD_FINISH              = 2793;         /* 下载完成 */
		public static final int NETDEV_ALARM_CLOUD_PARSE_DOMAIN_FAIL            = 2794;         /* 解析域名失败 */
		public static final int NETDEV_ALARM_CLOUD_CONNECT_FAIL                 = 2795;         /* 连接失败 */
		public static final int NETDEV_ALARM_CLOUD_CONNECT_TIMEOUT              = 2796;         /* 连接超时 */
		public static final int NETDEV_ALARM_CLOUD_DOWNLOAD_TIMEOUT             = 2797;         /* 下载超时 */
		public static final int NETDEV_ALARM_CLOUD_DOWNLOAD_FAIL                = 2798;         /* 下载失败 */
		public static final int NETDEV_ALARM_CLOUD_NETWORK_POOR                 = 2799;         /* 网络较差 */
		public static final int NETDEV_ALARM_CLOUD_PLAY_FINISH                  = 2800;         /* 播放完成 */
		public static final int NETDEV_ALARM_CLOUD_DISK_FULL                    = 2801;         /* 磁盘空间满 */
		public static final int NETDEV_ALARM_CLOUD_AUTH_FAIL                    = 2802;         /* 鉴权失败 */
		public static final int NETDEV_ALARM_CLOUD_CURRENT_TIME                 = 2803;         /* 当前播放时间，仅用于上报 */
		public static final int NETDEV_ALARM_CLOUD_PRIOR_DISK_FULL              = 2804;         /* 磁盘预值满 */
		public static final int NETDEV_ALARM_CLOUD_NODE_NOT_EXIST               = 2805;         /* 时间节点不存在 */
		public static final int NETDEV_ALARM_CLOUD_NO_CACHE_PATH                = 2806;         /* 未设置缓存路径 */
		public static final int NETDEV_ALARM_CLOUD_MSG_SEND_FAIL                = 2807;         /* 消息发送失败 */
		public static final int NETDEV_ALARM_CLOUD_TASK_CANCELLED               = 2808;         /* 任务已取消 */
		public static final int NETDEV_ALARM_CLOUD_TASK_STREAM_CONTINUE         = 2809;         /* 流继续播放 */
		
		public static final int NETDEV_ALARM_INVALID                            = 0xFFFF;      /* 无效值  Invalid value */
	}

	/**
	 * @enum tagNETDEVVodPlayStatus
	 * @brief Playback and download status Enumeration definition
	 * @attention None
	 */
	public class NETDEV_VOD_PLAY_STATUS_E{
		public static final int NETDEV_PLAY_STATUS_16_BACKWARD          = 0;            /*   Backward at 16x speed */
		public static final int NETDEV_PLAY_STATUS_8_BACKWARD           = 1;            /*   Backward at 8x speed */
		public static final int NETDEV_PLAY_STATUS_4_BACKWARD           = 2;            /*   Backward at 4x speed */
		public static final int NETDEV_PLAY_STATUS_2_BACKWARD           = 3;            /*   Backward at 2x speed */
		public static final int NETDEV_PLAY_STATUS_1_BACKWARD           = 4;            /*   Backward at normal speed */
		public static final int NETDEV_PLAY_STATUS_HALF_BACKWARD        = 5;            /*   Backward at 1/2 speed */
		public static final int NETDEV_PLAY_STATUS_QUARTER_BACKWARD     = 6;            /*   Backward at 1/4 speed */
		public static final int NETDEV_PLAY_STATUS_QUARTER_FORWARD      = 7;            /*   Play at 1/4 speed */
		public static final int NETDEV_PLAY_STATUS_HALF_FORWARD         = 8;            /*   Play at 1/2 speed */
		public static final int NETDEV_PLAY_STATUS_1_FORWARD            = 9;            /*   Forward at normal speed */
		public static final int NETDEV_PLAY_STATUS_2_FORWARD            = 10;           /*   Forward at 2x speed */
		public static final int NETDEV_PLAY_STATUS_4_FORWARD            = 11;           /*   Forward at 4x speed */
		public static final int NETDEV_PLAY_STATUS_8_FORWARD            = 12;           /*   Forward at 8x speed */
		public static final int NETDEV_PLAY_STATUS_16_FORWARD           = 13;           /*   Forward at 16x speed */
		public static final int NETDEV_PLAY_STATUS_2_FORWARD_IFRAME     = 14;           /* Forward at 2x speed(I frame) */
		public static final int NETDEV_PLAY_STATUS_4_FORWARD_IFRAME     = 15;           /*  Forward at 4x speed(I frame) */
		public static final int NETDEV_PLAY_STATUS_8_FORWARD_IFRAME     = 16;           /*  Forward at 8x speed(I frame) */
		public static final int NETDEV_PLAY_STATUS_16_FORWARD_IFRAME    = 17;           /*  Forward at 16x speed(I frame) */
		public static final int NETDEV_PLAY_STATUS_2_BACKWARD_IFRAME    = 18;           /*  Backward at 2x speed(I frame) */
		public static final int NETDEV_PLAY_STATUS_4_BACKWARD_IFRAME    = 19;           /*  Backward at 4x speed(I frame) */
		public static final int NETDEV_PLAY_STATUS_8_BACKWARD_IFRAME    = 20;           /*  Backward at 8x speed(I frame) */
		public static final int NETDEV_PLAY_STATUS_16_BACKWARD_IFRAME   = 21;           /* Backward at 16x speed(I frame) */
		public static final int NETDEV_PLAY_STATUS_INTELLIGENT_FORWARD  = 22;           /*  Intelligent forward */
		public static final int NETDEV_PLAY_STATUS_1_FRAME_FORWD        = 23;           /*   Forward at 1 frame speed */
		public static final int NETDEV_PLAY_STATUS_1_FRAME_BACK         = 24;           /*  Backward at 1 frame speed */

		public static final int NETDEV_PLAY_STATUS_40_FORWARD           = 25;           /*  Forward at 40x speed*/

		public static final int NETDEV_PLAY_STATUS_32_FORWARD_IFRAME    = 26;          /*  Forward at 32x speed(I frame)*/
		public static final int NETDEV_PLAY_STATUS_32_BACKWARD_IFRAME   = 27;           /*  Backward at 32x speed(I frame)*/
		public static final int NETDEV_PLAY_STATUS_64_FORWARD_IFRAME    = 28;           /*  Forward at 64x speed(I frame)*/
		public static final int NETDEV_PLAY_STATUS_64_BACKWARD_IFRAME   = 29;           /*  Backward at 64x speed(I frame)*/
		public static final int NETDEV_PLAY_STATUS_128_FORWARD_IFRAME   = 30;           /*  Forward at 128x speed(I frame)*/
		public static final int NETDEV_PLAY_STATUS_128_BACKWARD_IFRAME  = 31;           /*  Backward at 128x speed(I frame)*/
		public static final int NETDEV_PLAY_STATUS_256_FORWARD_IFRAME   = 32;           /* Forward at 256x speed(I frame)*/
		public static final int NETDEV_PLAY_STATUS_256_BACKWARD_IFRAME  = 33;           /* Backward at 256x speed(I frame)*/

		public static final int NETDEV_PLAY_STATUS_32_FORWARD           = 34;           /* Forward at 32x speed */
		public static final int NETDEV_PLAY_STATUS_32_BACKWARD          = 35;           /* Backward at 32x speed */
	}

 	/**
 	 * @enum tagNETDEVPlayControl
 	 * @brief Playback control commands Enumeration definition
 	 * @attention  None
 	 */
 	public class NETDEV_VOD_PLAY_CTRL_E{
 		public static final int NETDEV_PLAY_CTRL_PLAY           = 0;           	/* Play */
 		public static final int NETDEV_PLAY_CTRL_PAUSE          = 1;           	/* Pause */
 		public static final int NETDEV_PLAY_CTRL_RESUME         = 2;          	/* Resume */
 		public static final int NETDEV_PLAY_CTRL_GETPLAYTIME    = 3;           	/* Obtain playing time */
 		public static final int NETDEV_PLAY_CTRL_SETPLAYTIME    = 4;           	/* Configure playing time */
 		public static final int NETDEV_PLAY_CTRL_GETPLAYSPEED   = 5;          	/* Obtain playing speed */
 		public static final int NETDEV_PLAY_CTRL_SETPLAYSPEED   = 6;        	/* Configure playing speed */
 	}
 	
 	public class NETDEV_VOD_PTZ_CMD_E
 	{
 		public static final int NETDEV_PTZ_FOCUSNEAR_STOP       = 0x0201;       	/* Focus near stop */
 		public static final int NETDEV_PTZ_FOCUSNEAR            = 0x0202;       	/* Focus near */
 		public static final int NETDEV_PTZ_FOCUSFAR_STOP        = 0x0203;       	/* Focus far stop */
 		public static final int NETDEV_PTZ_FOCUSFAR             = 0x0204;       	/* Focus far */
 		public static final int NETDEV_PTZ_ZOOMTELE             = 0x0302;       	/* Zoom in */
 		public static final int NETDEV_PTZ_ZOOMWIDE             = 0x0304;       	/* Zoom out */
 		public static final int NETDEV_PTZ_TILTUP               = 0x0402;       	/* Tilt up */
 		public static final int NETDEV_PTZ_TILTDOWN             = 0x0404;       	/* ilt down */
 		public static final int NETDEV_PTZ_PANRIGHT             = 0x0502;       	/* Pan right */
 		public static final int NETDEV_PTZ_PANLEFT              = 0x0504;      		/* Pan left */
 		public static final int NETDEV_PTZ_LEFTUP               = 0x0702;       	/* Move up left */
 		public static final int NETDEV_PTZ_LEFTDOWN             = 0x0704;       	/* Move down left */
 		public static final int NETDEV_PTZ_RIGHTUP              = 0x0802;       	/* Move up right */
 		public static final int NETDEV_PTZ_RIGHTDOWN            = 0x0804;       	/* Move down right */
 		public static final int NETDEV_PTZ_ALLSTOP              = 0x0901;       	/* All-stop command word */
 	}

	public class NETDEV_TIME_ZONE_E
	{
		public static final int NETDEV_TIME_ZONE_W1200 = 0;              /* W12 */
		public static final int NETDEV_TIME_ZONE_W1100 = 1;              /* W11 */
		public static final int NETDEV_TIME_ZONE_W1000 = 2;              /* W10 */
		public static final int NETDEV_TIME_ZONE_W0900 = 3;              /* W9 */
		public static final int NETDEV_TIME_ZONE_W0800 = 4;              /* W8 */
		public static final int NETDEV_TIME_ZONE_W0700 = 5;              /* W7 */
		public static final int NETDEV_TIME_ZONE_W0600 = 6;              /* W6 */
		public static final int NETDEV_TIME_ZONE_W0500 = 7;              /* W5 */
		public static final int NETDEV_TIME_ZONE_W0430 = 8;              /* W4:30 */
		public static final int NETDEV_TIME_ZONE_W0400 = 9;              /* W4 */
		public static final int NETDEV_TIME_ZONE_W0330 = 10;             /* W3:30 */
		public static final int NETDEV_TIME_ZONE_W0300 = 11;             /* W3 */
		public static final int NETDEV_TIME_ZONE_W0200 = 12;             /* W2 */
		public static final int NETDEV_TIME_ZONE_W0100 = 13;             /* W1 */
		public static final int NETDEV_TIME_ZONE_0000  = 14;             /* W0 */
		public static final int NETDEV_TIME_ZONE_E0100 = 15;             /* E1 */
		public static final int NETDEV_TIME_ZONE_E0200 = 16;             /* E2 */
		public static final int NETDEV_TIME_ZONE_E0300 = 17;             /* E3 */
		public static final int NETDEV_TIME_ZONE_E0330 = 18;             /* E3:30 */
		public static final int NETDEV_TIME_ZONE_E0400 = 19;             /* E4 */
		public static final int NETDEV_TIME_ZONE_E0430 = 20;             /* E4:30 */
		public static final int NETDEV_TIME_ZONE_E0500 = 21;             /* E5 */
		public static final int NETDEV_TIME_ZONE_E0530 = 22;             /* E5:30 */
		public static final int NETDEV_TIME_ZONE_E0545 = 23;             /* E5:45 */
		public static final int NETDEV_TIME_ZONE_E0600 = 24;             /* E6 */
		public static final int NETDEV_TIME_ZONE_E0630 = 25;             /* E6:30 */
		public static final int NETDEV_TIME_ZONE_E0700 = 26;             /* E7 */
		public static final int NETDEV_TIME_ZONE_E0800 = 27;             /* E8 */
		public static final int NETDEV_TIME_ZONE_E0900 = 28;             /* E9 */
		public static final int NETDEV_TIME_ZONE_E0930 = 29;             /* E9:30 */
		public static final int NETDEV_TIME_ZONE_E1000 = 30;             /* E10 */
		public static final int NETDEV_TIME_ZONE_E1100 = 31;             /* E11 */
		public static final int NETDEV_TIME_ZONE_E1200 = 32;             /* E12 */
		public static final int NETDEV_TIME_ZONE_E1300 = 33;             /* E13 */
		public static final int NETDEV_TIME_ZONE_W0930 = 34;              /* W9:30 */
		public static final int NETDEV_TIME_ZONE_E0830 = 35;             /* E8:30 */
		public static final int NETDEV_TIME_ZONE_E0845 = 36;             /* E8:45 */
		public static final int NETDEV_TIME_ZONE_E1030 = 37;             /* E10:30 */
		public static final int NETDEV_TIME_ZONE_E1245 = 38;             /* E12:45 */
		public static final int NETDEV_TIME_ZONE_E1400 = 39;             /* E14 */

		public static final int NETDEV_TIME_ZONE_INVALID = 0xFF;         /* Invalid value */
	}
	
	/* Recording storage type */
	public class NETDEV_PLAN_STORE_TYPE_E
	{
		public static final int NETDEV_TYPE_STORE_TYPE_ALL                  = 0;            /* All */

		public static final int NETDEV_EVENT_STORE_TYPE_MOTIONDETECTION     = 4;            /*   Motion detection */
		public static final int NETDEV_EVENT_STORE_TYPE_DIGITALINPUT        = 5;            /*   Digital input */
		public static final int NETDEV_EVENT_STORE_TYPE_VIDEOLOSS           = 7;            /*   Video loss */

		public static final int NETDEV_TYPE_STORE_TYPE_INVALID              = 0xFF;         /*  Invalid value */
	}
 	
 	static AlarmCallBack_PF pfAlarmCallBack;
 	static ExceptionCallBack_PF pfExceptionCallBack;
	static DecodeAudioCallBack_PF pfDecodeAudioCallBack = null;

	/**
	* Callback function to receive alarm information
	* @param  iUserID              	User login ID
	* @param  iChannelID           	Channel number
	* @param  iAlarmType          	Alarm type
	* @param  tAlarmTime           	Alarm time
	* @param  strName              	Alarm source name
	* @param  dwIndex             	Length of structure for alarm information
	* @note*/
	/*public void alarmCallBack(int iUserID,int iChannelID, int iAlarmType, int tAlarmTime, String strName,int iBufLen) {
		pfAlarmCallBack.alarmCallBack(iUserID, iChannelID, iAlarmType, tAlarmTime, strName, iBufLen) ;
    }
 	
	public native int  NETDEV_SetAlarmCallBack(int iUserID, String strAlarmMessCallBack, int iUserData);
	public int  NETDEV_Android_SetAlarmCallBack(int iUserID, AlarmCallBack_PF strAlarmMessCallBack, int iUserData){
		pfAlarmCallBack = strAlarmMessCallBack;
		return NETDEV_SetAlarmCallBack(iUserID,"alarmCallBack",0);
	}*/

	public void alarmCallBack(int iUserID, int iAlarmSrcType, int iChannelID, int dwIndex, int iAlarmType, int tAlarmTime, String strName) {
		pfAlarmCallBack.alarmCallBack(iUserID, iAlarmSrcType, iChannelID, dwIndex, iAlarmType, tAlarmTime, strName) ;
	}

	public static native int  NETDEV_SetAlarmCallBackV2(int iUserID, String strAlarmMessCallBack, int iUserData);
	public static int  NETDEV_Android_SetAlarmCallBack(int iUserID, AlarmCallBack_PF strAlarmMessCallBack, int iUserData){
		pfAlarmCallBack = strAlarmMessCallBack;
		return NETDEV_SetAlarmCallBackV2(iUserID,"alarmCallBack",0);
	}

	public void exceptionCallBack(int iUserID,int iExceptionType,int iExceptionHandle) {
		pfExceptionCallBack.exceptionCallBack(iUserID, iExceptionType, iExceptionHandle) ;
	}

	public static native int  NETDEV_SetExceptionCallBack(String strExceptionCallBack, int iUserData);
	public static int  NETDEV_Android_SetExceptionCallBack(ExceptionCallBack_PF strExceptionCallBack, int iUserData){
		pfExceptionCallBack = strExceptionCallBack;
		return NETDEV_SetExceptionCallBack("exceptionCallBack",0);
	}
	
 	/**
 	* SDK initialization
 	* @return 1 means success, and any other value means failure.
 	* @note Thread not safe
 	*/
 	public  native int NETDEV_Init();
 	
 	/**
 	* DK uninitialization
 	* @return  1 means success, and any other value means failure.
 	* @note Thread not safe
 	*/
 	public static native int NETDEV_Cleanup();
 	
 	/**
 	*  User login
 	* @param   DevIP         IP Device IP
 	* @param   DevPort       Device server port
 	* @param   Username      Username
 	* @param   Password      Password
 	* @param oDeviceInfo oDeviceInfo   device information
 	* @return  Returned user login ID. 0 indicates failure, and other values indicate the user ID.
 	* @note
 	*/
	public static native int NETDEV_Login(String DevIP, int DevPort, String Username, String Password,NETDEV_DEVICE_INFO_S oDeviceInfo);

	public static native int NETDEV_LoginV2(int lpUerID, NETDEV_LOGIN_INFO_S oLoginInfo);

	public static native String NETDEV_GetStreamUrl(int lpUserID, int dwChannelID, int dwStreamType);

	public static native int NETDEV_FastRealPlayByUrl(int lpUerID, String StreamUrl, NETDEV_PREVIEWINFO_S oPreviewInfo, int dwWinIndex);

	public static native String NETDEV_GetReplayUrl(int lpUserID, int dwChannelID, int dwStreamType);

	public static native int NETDEV_FastPlayBackByUrl(int lpUerID, String StreamUrl, NETDEV_PLAYBACKCOND_S pstPlayBackInfo, int dwWinIndex);

    public static native int NETDEV_CaptureNoPreview(int lpUerID,int dwChannelID, int dwStreamType,String pszFileName,int dwCaptureMode);
	/**
	*  User logout
	* @param  lpUerID    用户登录User login ID
	* @return 1 means success, and any other value means failure.
	* @note
	*/
    public static native int NETDEV_Logout(int lpUerID);
    
    /**
    * Query channel capabilities
    * @param     lpUserID           User login ID
    * @param dwChlCount pdwChlCount        Number of channels
    * @return ArrayList    List of channel capabilities.
    * @note
    */
    public static native ArrayList<NETDEV_VIDEO_CHL_DETAIL_INFO_S> NETDEV_QueryVideoChlDetailList(int lpUserID, int dwChlCount);
    
    /**
    *   Get error code
    * @return Error codes
    */
    public static native int NETDEV_GetLastError();
    
    /**
    *  Modify image display ratio
    */
    public static native void NETDEV_SetRenderSurface(Surface view);
    
    /**
    * Start Live view
    * @param   lpUerID             User login ID
    * @param   oPreviewInfo       	see enumeration
    * @return  Returned user login ID. 0 indicates failure, and other values indicate the user ID.
    * @note
    */
    public  static native int NETDEV_RealPlay(int lpUerID,NETDEV_PREVIEWINFO_S oPreviewInfo, int dwWinIndex);
    
    /**
    *  Stop Live view
    * @param   lpPlayID     ID Preview ID
    * @return 1 means success, and any other value means failure.
    * @note  Stop the live view started by NETDEV_RealPlay
    */
    public  static native int NETDEV_StopRealPlay(int lpPlayID, int dwWinIndex);
    
    /**
    * Live view snapshot
    * @param   lpPlayID         Preview\playback handle
    * @param   pszFileName      File path to save images (including file name)
    * @param   dwCaptureMode    Image saving format, see #NETDEV_PICTURE_FORMAT_E
    * @return means success, and any other value means failure.
    * @note  File format suffix is not required in the file name
    */
    public static native int NETDEV_CapturePicture(int lpPlayID,String pszFileName,int dwCaptureMode);

	public static native int NETDEV_SaveRealData(int lpPlayID,String pszFileName,int dwFormat);
	public static native int NETDEV_StopSaveRealData(int lpPlayID);
	public static native int NETDEV_GetSystemTimeCfg(int lpUserID, NETDEV_TIME_S stDeviceTime);

	/***
	 * Set System Time
	 * @param  lpUserID
	 * @param stDeviceTime stDeviceTime
	 * @return
	 */
	public static native int NETDEV_SetSystemTimeCfg(int lpUserID, NETDEV_TIME_S stDeviceTime);

    /**
     * PTZ control operation (preview required)
     * @param   lpPlayID         Live preview handle
     * @param   dwPTZCommand         PTZ control commands, see #NETDEV_PTZ_E
     * @param   dwSpeed              Speed of PTZ control, which is configured according to the speed control value of different decoders. Value ranges from 1 to 9.
     * @return TRUE means success, and any other value means failure.
     * @note
     */
     public static native int NETDEV_PTZControl(int lpPlayID, int dwPTZCommand, int dwSpeed);
     
    /**
    * Get PTZ preset List 
    * @param   lpUserID         	User login ID
    * @param   dwChannelID       	Channel ID
    * @param dwPresetIDList dwPresetIDList       Preset ID list
    * @return TRUE means success, and any other value means failure.
    * @note
    */
    public static native int NETDEV_GetPTZPresetList(int lpUserID, int dwChannelID, int[] dwPresetIDList);
      
    /**
    * PTZ preset operation (preview required)  
    * @param   szPresetName         Live preview handle
    * @param   dwPTZPresetCmd 		Preset Control commond
    * @param   lpPlayID     	Preset name
    * @param   dwPresetID           Preset number (starting from 0). Up to 255 presets are supported.
    * @return TRUE means success, and any other value means failure.
    * @note
    */
    public static native int NETDEV_PTZPreset(int lpPlayID, int  dwPTZPresetCmd, String  szPresetName, int dwPresetID);

    /**
    * PTZ preset operation (preview not required)
    * @param   lpUserID             User login ID
    * @param   dwChannelID          Channel number
    * @param   dwPTZPresetCmd       PTZ preset operation commands, see NETDEV_PTZ_PRESETCMD_E
    * @param   szPresetName        Preset name
    * @param   dwPresetID           Preset number (starting from 0). Up to 255 presets are supported.
    * @return TRUE means success, and any other value means failure.
    * @note
    */
    public static native int NETDEV_PTZPreset_Other(int lpUserID, int dwChannelID, int  dwPTZPresetCmd, String szPresetName, int dwPresetID);

    /**
     * User login to cloud accounts
     * @param   CloudUrl       	Cloud server URL
     * @param   CloudUser       Cloud account name
     * @param   Cloudpassword   Cloud account password
     * @return  Returned user ID. 0 means failure, any other value is a user ID.
     * @note 
     */
     public static native int NETDEV_LoginCloud(String CloudUrl,String CloudUser,String Cloudpassword);
     
    /**
     * User login to cloud accounts with PresetAccountFlag
     * @param   UserName            Cloud server URL
     * @param   CloudSrvUrl           Cloud account name
     * @param   PassWord       Cloud account password
     * @param   PresetAccountFlag   Flag of using preset account
     * @return  Returned user ID. 0 means failure, any other value is a user ID.
     * @note Use for No Account,bPresetAccountFlag must be TRUE,pszUserName and pszPassWord must be non-null pointer pointing to empty string.
     */
    public static native int NETDEV_LoginCloudEx(String CloudSrvUrl, String UserName, String PassWord, int PresetAccountFlag);
    
    /**
    *  Cloud device login with dynamic password
    * @param   cloudDeviceInfo             Cloud account login ID
    * @param   CloudDevInfo         Cloud device login info
    * @param lpCloudID cloudDeviceInfo      device info
    * @return  Returned user ID. 0 means failure, any other value is a user ID.
    * @note 
        1、pCloudInfo 中szDevicePassword字段不需填写。The szDevicePassword field in pCloudInfo needs not to be filled in.
    */
    public static native int NETDEV_LoginByDynamic(int lpCloudID,NETDEV_CLOUD_DEV_LOGIN_S CloudDevInfo,NETDEV_DEVICE_INFO_S cloudDeviceInfo);
    
    /**
    * 云端设备登录 Cloud device login
    * @param   cloudDeviceInfo             Cloud account login ID
    * @param   CloudDevInfo         Cloud device login info
    * @param lpCloudID cloudDeviceInfo      device info
    * @return Returned user ID. 0 means failure, any other value is a user ID.
    * @note 
        1、The szDevicePassword field in pCloudInfo must be filled in.
    */
    public static native int NETDEV_LoginCloudDev(int lpCloudID,NETDEV_CLOUD_DEV_LOGIN_S CloudDevInfo,NETDEV_DEVICE_INFO_S cloudDeviceInfo);
    
    /**
    * Query device list under a cloud account
    * @param   lpCloudID            User login ID
    * @return  0 means failure, any other value will be used as parameter of functions including NETDEV_FindNextCloudDevInfo and NETDEV_FindCloseDevList.
    * @note  
    */
    public static native int NETDEV_FindCloudDevList(int lpCloudID);

	public static native int[] NETDEV_QuickSearch(int lUserID, int dwChannelID, NETDEV_MONTH_INFO_S oMonthInfo, NETDEV_MONTH_STATUS_S oMonthStatus);
    
    /**
    *   Obtain info about detected devices one by one
    * @param   clouddeviceinfo         Search handle
    * @param lpFindID pstDevInfo        Pointer to saved device info
    * @return  1 means success, and any other value means failure.
    * @note returned failure indicates the end of search.
    */
    public static native int NETDEV_FindNextCloudDevInfo(int lpFindID,NETDEV_CLOUD_DEV_INFO_S clouddeviceinfo);
    
    /**
    *  Stop search and release resource
    * @param  lpCloudID  File search handle
    * @return TRUE means success, and any other value means failure.
    * @note
    */
    public static native int  NETDEV_FindCloseCloudDevList(int lpCloudID);
    
    /**
    * Query recording files according to file type and time
    * @param   lpUserID      	User login ID
    * @param   pstFindCond  	Search condition
    * @return Recording search service number. 0 means failure. Other values are used as the handle parameters of functions like NETDEV_FindClose.
    * @note 
    */   
    public static native int NETDEV_FindFile(int lpUserID, NETDEV_FILECOND_S pstFindCond);
    
    /**
    * Obtain the information of found files one by one.
    * @param   lpFindHandle     File search handle
    * @param pstFindData pstFindData      Pointer to save file information
    * @return TRUE means success, and any other value means failure.
    * @note  A returned failure indicates the end of search.
    */
    public static native int NETDEV_FindNextFile(int lpFindHandle, NETDEV_FINDDATA_S pstFindData);

	public static native int NETDEV_SetPictureFluency(int lpUserID, int dwFluency);
    /**
    * Close file search and release resources
    * @param  lpFindHandle  File search handle
    * @return TRUE means success, and any other value means failure.
    * @note
    */
    public static native int NETDEV_FindClose(int lpFindHandle);
    
    /**
     * add a cloud device to a cloud account
     * @param   lpUserID             User login ID
     * @param   szDevRegisterCode    device register code
     * @param   szDevName           device name
     * @param stDevBase stDevBase           basic information of cloud device
     * @return TRUE means success, and any other value means failure.
     * @note  
     */
     public static native int NETDEV_AddCloudDevice(int lpUserID, String szDevRegisterCode,String szDevName,NETDEV_CLOUD_DEV_BASE_INFO_S stDevBase);
     
     /**
     * delete a cloud device under a cloud account
     * @param   lpUserID            User login ID
     * @param   szDevUserName       cloud device ID
     * @return TRUE means success, and any other value means failure.
     * @note  
     */
     public static native int NETDEV_DeleteCloudDevice(int lpUserID,String szDevUserName);
     
    /**
    * Play back recording by time. 
    * @param  lpUserID          User login ID
    * @param  pstPlayBackInfo   Pointer to playback-by-time structure, see LPNETDEV_PLAYBACKCOND_S
    * @return TRUE means success, and any other value means failure.
    * @note
    */
    public static native int NETDEV_PlayBackByTime(int lpUserID, NETDEV_PLAYBACKCOND_S pstPlayBackInfo, int dwWinIndex);
    
    /**
    * Stop playback service
    * @param  lpPlayHandle   Playback handle
    * @return TRUE means success, and any other value means failure.
    * @note
    */
    public static native int NETDEV_StopPlayBack(int lpPlayHandle, int dwWinIndex);
    
    /**
    * Control recording playback status.
    * @param   lpPlayHandle     Playback or download handle
    * @param   dwControlCode    Command for controlling recording playback status, see NETDEV_VOD_PLAY_CTRL_E
    * @param lpBuffer  lpBuffer     Pointer to input/output parameters. For playing speed, see NETDEV_VOD_PLAY_STATUS_E. The type of playing time: INT64.
    * @return TRUE means success, and any other value means failure.
    * @note When playing, pause or resume videos, set IpBuffer as NULL.
    */
    public static native int NETDEV_PlayBackControl(int lpPlayHandle, int dwControlCode, NETDEV_PLAYBACKCONTROL_S lpBuffer);
    
    /**
    * Download recordings by time
    * @param   lpUserID          	User login ID
    * @param   szSaveFileName   	Pointer to playback-by-time structure, see LPNETDEV_PLAYBACKCOND_S
    * @param   *pszSaveFileName    	Downloaded file save path on PC, must be an absolute path (including file name)
    * @param   dwFormat         	Recording file saving format
    * @return Download handle. 0 means failure. Other values are used as the handle parameters of functions like NETDEV_StopGetFile.
    * @note
    */
    public static native int NETDEV_DownloadFile(int lpUserID, NETDEV_PLAYBACKCOND_S lpBuffer, String szSaveFileName, int dwFormat);
    
    /**
    * Stop downloading recording files
    * @param   lpPlayHandle  Playback handle
    * @return TRUE means success, and any other value means failure.
    * @note
    */
    public static native int NETDEV_StopDownloadFile(int lpPlayHandle);
    
    /**
    * Get device basic info
    * @param   lpUserID          	User login ID
    * @param   dwChannelID          Channel ID
    * @param stDevinfo  stDevinfo           Device Info
    * @return TRUE means success, and any other value means failure.
    * @note
    */
    public static native int NETDEV_GetDeviceInfo(int lpUserID, int dwChannelID, NETDEV_DEVICE_BASICINFO_S stDevinfo);
        
    public static native int initialize();
    public static native int rendererRender(int dwWinIndex);
    public static native int setRendererViewport(int w, int h);
    public static native int initializeRenderer(int dwWinIndex);
	public static native int Scale(float scaleRatio, float x, float y, int dwWinIndex);

	/**
	 * SDK initialization
	 * @return 1 means success, and any other value means failure.
	 * @note ID must be unique
	 */
	public static native int NETDEV_SetClientID(String strClientID);
	
	public void DecodeAudioDataCallBack(int lpVoiceComHandle, byte[] voiceData, int length, int u32WaveFormat) 
    {
    	pfDecodeAudioCallBack.DecodeAudioDataCallBack(lpVoiceComHandle, voiceData, length, u32WaveFormat);
    }
	
    /**
    * Start input voice server
    * @param   lpUserID                 User login ID
    * @param   dwChannelID              Channel ID
    * @return TRUE means success, and any other value means failure.
    * @note
    */
    public static native int NETDEV_StartInputVoiceSrv(int lpUserID,int dwChannelID);
	public static int NETDEV_Android_StartInputVoiceSrv(int lpUserID,int dwChannelID)
	{
		pfDecodeAudioCallBack = new DecodeAudioCallBack_PF();
		return NETDEV_StartInputVoiceSrv(lpUserID,dwChannelID);
	}
    
    /**
    * Stop input voice server
    * @param   lpVoiceComHandle         Two-way audio handle
    * @return TRUE means success, and any other value means failure.
    * @note
    */
    public static native int NETDEV_StopInputVoiceSrv(int lpVoiceComHandle);
	public static int NETDEV_Android_StopInputVoiceSrv(int lpVoiceComHandle) {
		pfDecodeAudioCallBack.release();
		return NETDEV_StopInputVoiceSrv(lpVoiceComHandle);
	}
    
    /**
    * input voice Data
    * @param   lpVoiceComHandle         Two-way audio handle
    * @param   lpDataBuf         		Data buffer
    * @param   dwDataLen         		Data length
    * @param   stVoiceParam         	Voice param
    * @return TRUE means success, and any other value means failure.
    * @note
    */
    public static native int NETDEV_InputVoiceData(int lpVoiceComHandle,byte[] lpDataBuf,int dwDataLen,NETDEV_AUDIO_SAMPLE_PARAM_S stVoiceParam);
	
	/**
	* set T2U Payload
	* @param    dwT2UPayload         [101-1500] ，default: 1500
	* @return TRUE means success, and any other value means failure.
	*/
    public static native int NETDEV_SetT2UPayLoad(int dwT2UPayload);
    
     /**
     *    Report Mobie Info to Cloud
     * @param   lpUserID         User ID
     * @param   stMobileInfo    Mobile Info
     * @param   stCloudLimitInfo Limit Info
     * @return  1 means success, and any other value means failure.
     * @note 
     */
     public static native int  NETDEV_ReportMobileInfo(int lpUserID, NETDEV_CLOUD_MOBILE_INFO_S stMobileInfo, NETDEV_CLOUD_LIMIT_INFO_S stCloudLimitInfo);
     
     /**
     *    No Account info binding
     * @param   lpUserID         User ID
     * @param   stNoAccountInfo  No Account Info
     * @return  1 means success, and any other value means failure.
     * @note 
     */
    public static native int NETDEV_NoAccountBinding(int lpUserID, NETDEV_CLOUD_NOACCOUNT_INFO_S stNoAccountInfo);

    /**
     *    No Account info cancel binding
     * @param   lpUserID         User ID
     * @param   stNoAccountInfo  No Account Info
     * @return  1 means success, and any other value means failure.
     * @note szDeviceName is Not Required Using for Cancel Binding
     */
    public static native int NETDEV_NoAccountCancel(int lpUserID, NETDEV_CLOUD_NOACCOUNT_INFO_S stNoAccountInfo);
}

