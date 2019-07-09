package com.cdc.keyboard.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.cdc.keyboard.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * .class public Lcom/laiqian/db/a;
 * .super Landroid/database/sqlite/SQLiteOpenHelper;
 * .source "DatabaseHelper.java"
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private Context mContext = null;

    private static String aNG;

    private static Integer aND = Integer.valueOf(0);

    private static String dbPath;

    private SQLiteDatabase aNE = null;

    private boolean aNF = false;

    private String aNI = "";

    public DatabaseHelper(Context paramContext) {
        super(paramContext, "laiqian.db", null, 1);
        this.mContext = paramContext;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/data/data/");
        stringBuilder.append(this.mContext.getPackageName());
        stringBuilder.append("/");
        stringBuilder.append("laiqian.db");
        aNG = stringBuilder.toString();
        copyDb(aNG);
        aND = Integer.valueOf(0);
    }

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "laiqian.db", null, 1);


    }

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, "laiqian.db", null, 1, errorHandler);


    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private void init(Context context) {
        this.mContext = context;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/data/data/");
        stringBuilder.append(this.mContext.getPackageName());
        stringBuilder.append("/");
        stringBuilder.append("laiqian.db");
        dbPath = stringBuilder.toString();
        copyDb(dbPath);
    }

    /**
     * 将数据库文件从raw复制到data/data  下面  cq
     *
     * @param paramString
     */
    private void copyDb(String paramString) {
        File file = new File(paramString);
        if (!file.exists())
            try {
                file.createNewFile();
                InputStream inputStream = this.mContext.getResources().openRawResource(R.raw.laiqian);
                FileOutputStream fileOutputStream = new FileOutputStream(paramString);
                byte[] arrayOfByte = new byte[8192];
                while (true) {
                    int i = inputStream.read(arrayOfByte);
                    if (i > 0) {
                        fileOutputStream.write(arrayOfByte, 0, i);
                        continue;
                    }
                    break;
                }
                fileOutputStream.close();
                inputStream.close();
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public SQLiteDatabase getWritableDatabase() {
        return LaiqianConnection.aOw.Dk();
    }


}
