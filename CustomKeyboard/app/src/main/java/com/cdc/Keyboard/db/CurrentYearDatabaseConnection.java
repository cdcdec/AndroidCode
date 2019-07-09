package com.cdc.keyboard.db;

/**
 * .class public final enum Lcom/laiqian/db/multidatabase/a/a;
 * .super Ljava/lang/Enum;
 * .source "CurrentYearDatabaseConnection.java"
 */
public class CurrentYearDatabaseConnection {
    public static enum MonthDb{
        January("january.db"),
        February("february.db"),
        March("march.db"),
        April("april.db"),
        May("may.db"),
        June("june.db"),
        July("july.db"),
        August("august.db"),
        Aeptember("september.db"),
        Actober("october.db"),
        November("november.db"),
        December("december.db");
        private String aOu;

        MonthDb(String paramString1) { this.aOu = paramString1; }

        public String getDatabaseName() { return this.aOu; }

    }
}
