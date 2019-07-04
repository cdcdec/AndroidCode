package com.cdc.keyboard.util;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logs{

    private static final String TAG = "LQK";
    private static long time;

    public static void dE(long paramLong) {
        time = paramLong;
    }

    public static void e(String tag, Object paramObject) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(tag);
        stringBuilder1.append("[Logs.java]");
        String str = stringBuilder1.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(paramObject);
        stringBuilder2.append("      {");
        stringBuilder2.append(tag);
        stringBuilder2.append("}. The time is: ");
        stringBuilder2.append((new SimpleDateFormat("yyyy-MM-dd   hh:mm:ss")).format(new Date()));
        Log.e(str, stringBuilder2.toString());
    }

    public static void d(String tag, Object paramObject) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(tag);
        stringBuilder1.append("[Logs.java]");
        String str = stringBuilder1.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(paramObject);
        stringBuilder2.append("      {");
        stringBuilder2.append(tag);
        stringBuilder2.append("}. The time is: ");
        stringBuilder2.append((new SimpleDateFormat("yyyy-MM-dd   hh:mm:ss")).format(new Date()));
        Log.d(str, stringBuilder2.toString());
    }


    public static void E(Object paramObject) {
        e(TAG, paramObject);
    }

    public static void D(Object paramObject) {
        d(TAG, paramObject);
    }

    public static void eFile(String paramString1, String filePath) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramString1);
        stringBuilder.append("\n");
        paramString1 = stringBuilder.toString();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append("Create the file:");
                stringBuilder1.append(filePath);
                d(TAG, stringBuilder1.toString());
                if (!file.createNewFile())
                    e(TAG, "createNewFile failed.");
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(file.length());
            randomAccessFile.write(paramString1.getBytes());
            randomAccessFile.close();
            return;
        } catch (Exception e) {
            e(TAG, "Error on write File.");
            return;
        }
    }

    public static void fU(String paramString) { Log.e("_Sync", paramString); }

    public static void eTime(String tag, Object paramObject) {
        long l1 = System.currentTimeMillis();
        long l2 = time;
        time = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramObject);
        stringBuilder.append(". consumed miliseconds is: ");
        stringBuilder.append(l1 - l2);
        e(tag, stringBuilder.toString());
    }

    public static void eFile(String paramString) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        stringBuilder1.append("/logs.txt");
        String str1 = stringBuilder1.toString();
        Date date = new Date();
        String str2 = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(date);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str2);
        stringBuilder2.append(":");
        stringBuilder2.append(paramString);
        eFile(stringBuilder2.toString(), str1);
    }


}
