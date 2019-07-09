package com.cdc.keyboard.db;

import android.util.Log;

import java.io.File;
import java.util.Calendar;
import java.util.regex.Pattern;

/**
 * .class public Lcom/laiqian/db/multidatabase/d/b;
 * .super Ljava/lang/Object;
 * .source "DbUtil.java"
 */
public class DbUtil {
    private static final boolean DEBUG;

    private static final String TAG = "b";

    private static final Pattern aOK = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");

    static  {
        DEBUG = true;
    }

    public static int U(long paramLong) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(paramLong);
        return calendar.get(1);
    }

    public static String V(long paramLong) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(paramLong);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(calendar.get(1));
        stringBuilder.append("年");
        stringBuilder.append(calendar.get(2) + 1);
        stringBuilder.append("月");
        stringBuilder.append(calendar.get(5));
        stringBuilder.append("日");
        stringBuilder.append(calendar.get(11));
        stringBuilder.append("时");
        stringBuilder.append(calendar.get(12));
        stringBuilder.append("分");
        stringBuilder.append(calendar.get(13));
        stringBuilder.append("秒");
        stringBuilder.append(calendar.get(14));
        stringBuilder.append("毫秒");
        return stringBuilder.toString();
    }

    public static String aU(int paramInt1, int paramInt2) {
        String str = getMonth(paramInt1).getDatabaseName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str.substring(0, str.lastIndexOf(".")));
        stringBuilder.append(paramInt2);
        return stringBuilder.toString();
    }

    public static String aV(int paramInt1, int paramInt2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(DbConstant.aOz);
        stringBuilder.append(paramInt2);
        stringBuilder.append(File.separator);
        stringBuilder.append(getMonth(paramInt1).getDatabaseName());
        return stringBuilder.toString();
    }

    public static CurrentYearDatabaseConnection.MonthDb getMonth(int paramInt) {
        switch (paramInt) {
            default:
                return null;
            case 12:
                return CurrentYearDatabaseConnection.MonthDb.December;
            case 11:
                return CurrentYearDatabaseConnection.MonthDb.November;
            case 10:
                return CurrentYearDatabaseConnection.MonthDb.Actober;
            case 9:
                return CurrentYearDatabaseConnection.MonthDb.Aeptember;
            case 8:
                return CurrentYearDatabaseConnection.MonthDb.August;
            case 7:
                return CurrentYearDatabaseConnection.MonthDb.July;
            case 6:
                return CurrentYearDatabaseConnection.MonthDb.June;
            case 5:
                return CurrentYearDatabaseConnection.MonthDb.May;
            case 4:
                return CurrentYearDatabaseConnection.MonthDb.April;
            case 3:
                return CurrentYearDatabaseConnection.MonthDb.March;
            case 2:
                return CurrentYearDatabaseConnection.MonthDb.February;
            case 1:
                break;
        }
        return CurrentYearDatabaseConnection.MonthDb.January;
    }


    public static void ct(String paramString) {
        if (DEBUG)
            Log.i(TAG, paramString);
    }
}
