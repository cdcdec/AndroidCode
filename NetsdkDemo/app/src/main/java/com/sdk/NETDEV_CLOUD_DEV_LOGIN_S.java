package com.sdk;
     /*�ƶ��豸��¼��Ϣ*/
public class NETDEV_CLOUD_DEV_LOGIN_S {
		public String szDeviceName;              /* Device name */
		public String szDevicePassword;          /* Device login password (optional) */
		public int dwT2UTimeout;                 /* P2P timeout (default: 15s) */
		public int dwConnectMode;                /* Connect Mode, 0:直连、打洞、转发；1：直连、打洞+转发；2：打洞；3：转发 */
}
