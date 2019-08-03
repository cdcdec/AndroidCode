package com.sdk;
         /*�豸��Ϣ*/

public class NETDEV_LOGIN_INFO_S {
	public int LoginType;                    /* 0:本地登录; 1:动态密码登录; 2:支持第三方设备; 3:云设备登录; 4:无账号登录\*/

    /* ��̬�����¼�ֶ� */
    public int  lpUserID;                    /* 云端账户登录ID User login ID */
    public String szDeviceName;              /* Device name */
    public String szDevicePassword;          /* Device login password (optional) */
    public int dwT2UTimeout;                 /* P2P timeout (default: 15s) */
    public int dwConnectMode;                /* Connect Mode, 0:直连、打洞、转发；1：直连、打洞+转发；2：打洞；3：转发 */
	public String szRegisterCode;            /* Device Register Code */
    public String szDeviceSN;                /* Device SN */

    /* ���ص�¼�ֶ� */
    public String  mDevIP;                   /* 设备 Device IP */
    public String  mUserName;                /* 用户名 User Name */
    public String  mPassword;                /* 密码 Password */
    public int dwDevPort;                    /* 设备服务器端口 Device Server Port */
}
