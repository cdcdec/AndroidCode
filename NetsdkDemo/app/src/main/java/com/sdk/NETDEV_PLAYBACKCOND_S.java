package com.sdk;

public class NETDEV_PLAYBACKCOND_S {
    public int   	dwChannelID;                /* Playback channel */
    public long   	tBeginTime;                 /* Playback start time */
    public long   	tEndTime;                   /* Playback end time */
    public int   	dwLinkMode;                 /* Transport protocol, see enumeration #NETDEV_PROTOCAL_E */
    public int  	hPlayWnd;                   /* Play window handle */
    public int   	dwFileType;                 /* Recording storage type, see enumeration #NETDEV_PLAN_STORE_TYPE_E */
    public int   	dwDownloadSpeed;            /* NETDEV_E_DOWNLOAD_SPEED_E */
    public int      dwPlaySpeed;                /* Playback speed, see enumeration #NETDEV_VOD_PLAY_STATUS_E*/
}
