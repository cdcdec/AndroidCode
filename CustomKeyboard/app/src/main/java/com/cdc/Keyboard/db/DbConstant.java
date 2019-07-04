package com.cdc.keyboard.db;

import com.cdc.keyboard.basic.RootApplication;

public class DbConstant {
    public static final String aOB;

    public static int aOC = 2011;

    public static long aOD = 1325347200000L;

    public static final String aOz;

    public static String YEAR="";
    public static String aOA="";


    static  {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/data/data/");
        stringBuilder.append(RootApplication.getApplication().getPackageName());
        stringBuilder.append("/laiqiandbs/");
        aOz = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(aOz);
        stringBuilder.append(YEAR);
        aOA = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("/data/data/");
        stringBuilder.append(RootApplication.getApplication().getPackageName());
        stringBuilder.append("/laiqian.db");
        aOB = stringBuilder.toString();
    }
}
