package com.sdk;


public class NETDEV_CLOUD_MOBILE_INFO_S {
    public String     szMobileModule;                     /* 终端型号 Module of Terminal */
    public String     szSystemType;                       /* 操作系统类型 System Type of Terminal,android|ios,small lette */
    public String     szSystemVersion;                    /* 操作系统版本 System Version of Terminal */
    public int        bDonotDisturb;                      /* 免打扰标志 Flag of Do Not Disturb */
    public int        bPushBuiltFlag;                     /* 推送连接建立标识 Flag of push connected,1 means Long Link*/
    public String     szAppName;                          /* App名称 App Name */
    public String     szAppLanguage;                      /* App语言环境 App Language. ex:en-us|zh-cn */
    public String     szAppVersion;                       /* App版本信息 App Version */
    public int        bIosEnvir;                          /* IOS的环境标志 environment of IOS, 1:Production 0:Development*/
}