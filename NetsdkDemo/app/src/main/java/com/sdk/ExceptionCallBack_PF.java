package com.sdk;
public class ExceptionCallBack_PF {
    /*
     * Callback function to receive alarm information
     * @param  iUserID              	ID User login ID
     * @param  iChannelID           	Channel number
     * @param  iAlarmType          	Alarm type
     * @param  tAlarmTime           	Alarm time
     * @param  strName              	Alarm source name
     * @param  iBufLen             	Length of structure for alarm information
     * @note*/
    public void exceptionCallBack(int iUserID, int iExceptionType, int iExceptionHandle) {

        if(iUserID == NetDEVSDK.lpUserID)
        {
            if(0x8001 == iExceptionType) {
                System.out.println("Android Report exception info , Exception Type :" + iExceptionType);
                AlarmCallBack_PF pfAlarmCallBack = new AlarmCallBack_PF();
                NetDEVSDK.NETDEV_Android_SetAlarmCallBack(NetDEVSDK.lpUserID, pfAlarmCallBack, 0);
            }
        }
    }
}
