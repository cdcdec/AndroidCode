package com.cdc.keyboard.db;

import android.database.sqlite.SQLiteDatabase;
import com.cdc.keyboard.basic.RootApplication;

/**
 * .class public final enum Lcom/laiqian/db/multidatabase/a/b;
 * .super Ljava/lang/Enum;
 * .source "LaiqianConnection.java"
 */
public enum LaiqianConnection{

    aOw("laiqian.db");
    private SQLiteDatabase aNE;

    private String aOx;

    LaiqianConnection(String paramString1) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/data/data/");
        stringBuilder.append(RootApplication.getApplication().getPackageName());
        stringBuilder.append("/");
        stringBuilder.append(paramString1);
        this.aOx = stringBuilder.toString();
        this.aNE = SQLiteDatabase.openOrCreateDatabase(this.aOx, null, new MyDatabaseErrorHandler());
        this.aNE.execSQL("PRAGMA synchronous=NORMAL");
    }

    public SQLiteDatabase Dk() {
        if (!this.aNE.isOpen()) {
            this.aNE = SQLiteDatabase.openOrCreateDatabase(this.aOx, null, new MyDatabaseErrorHandler());
            this.aNE.execSQL("PRAGMA synchronous=NORMAL");
        }
        return this.aNE;
    }

    public void e(SQLiteDatabase paramSQLiteDatabase) {
        this.aNE = paramSQLiteDatabase;
    }
}
