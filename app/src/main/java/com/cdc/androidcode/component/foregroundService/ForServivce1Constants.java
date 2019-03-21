package com.cdc.androidcode.component.foregroundService;

public class ForServivce1Constants {
    public static final int NOTIFICATION_ID_FOREGROUND_SERVICE = 8466503;

    public static class ACTION {
        public static final String MAIN_ACTION = "com.cdc.androidcode.action.forservice1.main";
        public static final String START_ACTION = "com.cdc.androidcode.action.forservice1.start";
        public static final String STOP_ACTION = "com.cdc.androidcode.action.forservice1.stop";
    }

    public static class STATE_SERVICE{
        public static final int CONNECTED = 10;
        public static final int NOT_CONNECTED = 0;
    }
}
