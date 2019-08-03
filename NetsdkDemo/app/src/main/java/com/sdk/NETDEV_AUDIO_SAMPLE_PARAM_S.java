package com.sdk;



public class NETDEV_AUDIO_SAMPLE_PARAM_S {
	public int dwChannels;                               /* 声道数，单声道为，立体声为*/
	public int dwSampleRate;                             /* 采样率*/
	public int enSampleFormat;                           /* 位宽,参考NETDEV_AUDIO_SAMPLE_FORMAT_E*/
	
	public class NETDEV_AUDIO_SAMPLE_FORMAT_E
	{
		public static final int NETDEV_AUDIO_SAMPLE_FMT_NONE = -1;
		public static final int NETDEV_AUDIO_SAMPLE_FMT_U8  = 0;            /* 无符号位整型*/
		public static final int NETDEV_AUDIO_SAMPLE_FMT_S16 = 1;            /* 有符号位整型*/
		public static final int NETDEV_AUDIO_SAMPLE_FMT_S32 = 2;            /* 有符号位整型*/
		public static final int NETDEV_AUDIO_SAMPLE_FMT_FLT = 3;            /* 浮点型*/
		public static final int NETDEV_AUDIO_SAMPLE_FMT_DBL = 4;             /* double型*/
	}
}
