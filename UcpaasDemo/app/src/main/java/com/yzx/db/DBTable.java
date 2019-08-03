  
package com.yzx.db;  

/**
 * @Title DBColumn   
 * @Description  数据库表，字段描述
 * @Company yunzhixun  
 * @author xhb
 * @date 2016-9-8 下午2:59:48
 */
public interface DBTable {
	
	/**
	 * @Title BaseColumn   
	 * @Description  基础的表列字段
	 * @Company yunzhixun  
	 * @author xhb
	 * @date 2016-9-8 下午3:01:54
	 */
	public interface BaseColumn{
		String COLUMN_ID = "_id";
	}
	
	/**
	 * @Title TelListsInfo   
	 * @Description  音视频电话列表信息
	 * @Company yunzhixun  
	 * @author xhb
	 * @date 2016-9-8 下午8:07:57
	 */
	public interface TelListsInfo extends BaseColumn {
		String TABLE_NAME = "tel_lists_info";
		
		String COLUMN_GRAVATOR = "_gravator"; 		// 头像
		String COLUMN_NAME = "_name";				// 昵称		
		String COLUMN_DIALFLAG = "_dialflag";		// 呼入呼出标志
		String COLUMN_TELMODE = "_telmode"; 		// 电话方式
		String COLUMN_TIME = "_time";				// 时间
		String COLUMN_TELEPHONE = "_telephone";		// 电话号码
		String COLUMN_LOGINPHONE = "_loginphone";	// 当前登录的手机号码
		String COLUMN_ISTOP = "_istop";				// 是否置顶
		
		String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
				+ COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ COLUMN_GRAVATOR +" TEXT, "
				+ COLUMN_NAME +" TEXT, "
				+ COLUMN_DIALFLAG +" INTEGER, "
				+ COLUMN_TELMODE + " TEXT, "
				+ COLUMN_TIME + " TEXT, "
				+ COLUMN_TELEPHONE + " TEXT, "
				+ COLUMN_LOGINPHONE + " TEXT,"
				+ COLUMN_ISTOP + " TEXT"
				+")";
	}
	
	/**
	 * @Title TelUserInfo   
	 * @Description  音视频电话用户信息表
	 * @Company yunzhixun  
	 * @author xhb
	 * @date 2016-9-8 下午8:07:40
	 */
	public interface TelUserInfo extends BaseColumn {
		String TABLE_NAME = "tel_users_info";
		
		String COLUMN_GRAVATOR = "_gravator"; 		// 头像
		String COLUMN_NAME = "_name";				// 昵称	
		String COLUMN_TELEPHONE = "_telephone"; 	// 电话号码
		String COLUMN_DIALFLAG = "_dialflag"; 		// 呼入呼出标志
		String COLUMN_TIME = "_time";				// 时间
		String COLUMN_TELMODE = "_telmode"; 		// 电话方式
		String COLUMN_DIALMESSAGE = "_dialmessage";	// 呼叫信息	
		String COLUMN_LOGINPHONE = "_loginphone";	// 当前登录的手机号码
		
		String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
			+ COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ COLUMN_GRAVATOR +" TEXT, "
			+ COLUMN_NAME +" TEXT, "
			+ COLUMN_TELEPHONE + " TEXT, "
			+ COLUMN_DIALFLAG +" INTEGER, "
			+ COLUMN_TIME + " TEXT, "
			+ COLUMN_TELMODE + " INTEGER, "
			+ COLUMN_DIALMESSAGE +" TEXT, "
			+ COLUMN_LOGINPHONE + " TEXT"
			+")";
	}
	
	/**
	 * @Title UserInfo   
	 * @Description  用户表
	 * @Company yunzhixun  
	 * @author xhb
	 * @date 2016-9-8 下午8:07:07
	 */
	public interface UserInfo extends BaseColumn {
		String TABLE_NAME = "user";
	
		String COLUMN_ACCOUNT = "_account";
		String COLUMN_NAME = "_name";
		String COLUMN_VERICODE = "_veriCode";
		String COLUMN_LOGINSTATUS = "_loginStatus";
		String COLUMN_DEFAULTLOGIN = "_defaultLogin";
		
		String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
				+ COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ COLUMN_ACCOUNT +" TEXT, "
				+ COLUMN_NAME+" TEXT, "
				+ COLUMN_VERICODE + " TEXT,"
				+ COLUMN_LOGINSTATUS +" INTEGER DEFAULT 1, "
				+ COLUMN_DEFAULTLOGIN +" INTEGER DEFAULT 1"
				+")";
	}
	
	/**
	 * @Title UserSetting   
	 * @Description  用户设置表
	 * @Company yunzhixun  
	 * @author xhb
	 * @date 2016-9-8 下午8:06:50
	 */
	public interface UserSetting extends BaseColumn {
		String TABLE_NAME = "user_settings";
		
		String COLUMN_ACCOUNT = "_account";
		String COLUMN_MSGNOTIFY = "_msgNotify";
		String COLUMN_MSGVOICE = "_msgVoice";
		String COLUMN_MSGVITOR = "_msgVitor";
		String COLUMN_TOKEN = "_token";
		String COLUMN_ASADDRESSANDPORT = "_asAddressAndPort";
		String COLUMN_TCPADDRESSANDPORT = "_tcpAddressAndPort";
		
		String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
				+ COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ COLUMN_ACCOUNT +" TEXT, "
				+ COLUMN_ASADDRESSANDPORT +" TEXT, "
				+ COLUMN_TCPADDRESSANDPORT +" TEXT, "
				+ COLUMN_TOKEN +" TEXT, "
				+ COLUMN_MSGNOTIFY +" INTEGER DEFAULT 1, "
				+ COLUMN_MSGVITOR +" INTEGER DEFAULT 1, "
				+ COLUMN_MSGVOICE +" INTEGER DEFAULT 1"
				+")";
	}
	
	/**
	 * @Title ConversationBg   
	 * @Description  会话背景表
	 * @Company yunzhixun  
	 * @author xhb
	 * @date 2016-9-8 下午8:06:33
	 */
	public interface ConversationBg extends BaseColumn {
		String TABLE_NAME = "conversation_bg";
		
		String COLUMN_ACCOUNT = "_account";
		String COLUMN_TARGETID = "_targetId";
		String COLUMN_BGPATH = "_bgPath";
		
		String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
				+ COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ COLUMN_ACCOUNT +" TEXT, "
				+ COLUMN_TARGETID +" TEXT, "
				+ COLUMN_BGPATH +" TEXT"
				+")";
	}
	
	/**
	 * @Title DraftMsg   
	 * @Description  草稿表
	 * @Company yunzhixun  
	 * @author xhb
	 * @date 2016-9-8 下午8:05:55
	 */
	public interface DraftMsg extends BaseColumn {
		String TABLE_NAME = "draft_msg";
		
		String COLUMN_ACCOUNT = "_account";
		String COLUMN_TARGETID = "_targetId";
		String COLUMN_DRAFTMSG= "_draftMsg";
		
		String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
				+ COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ COLUMN_ACCOUNT +" TEXT, "
				+ COLUMN_TARGETID +" TEXT, "
				+ COLUMN_DRAFTMSG +" TEXT"
				+")";
	}
}
  
