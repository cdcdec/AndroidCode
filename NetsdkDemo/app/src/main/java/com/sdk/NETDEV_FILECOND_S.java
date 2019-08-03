package com.sdk;

public class NETDEV_FILECOND_S {
	public String    szFileName;                 /* Recording file name */
	public int   dwChannelID;                    /* Channel number */
	public int   dwFileType;                     /* Recording storage type, see enumeration #NETDEV_PLAN_STORE_TYPE_E */
	public int   dwStreamType;                   /* Stream type, see enumeration NETDEV_LIVE_STREAM_INDEX_E */
	public long   tBeginTime;                    /* Start time */
	public long   tEndTime;                      /* End time */
}
