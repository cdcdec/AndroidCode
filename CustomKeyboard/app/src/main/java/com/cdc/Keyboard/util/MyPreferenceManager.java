package com.cdc.keyboard.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;

/**
 * .class public Lcom/laiqian/util/av;
 * .super Ljava/lang/Object;
 * .source "LaiqianPreferenceManager.java"
 */
public class MyPreferenceManager {

    private SharedPreferences spSettings = null;
    private SharedPreferences spHttpCook = null;

    private Context mContext;

    public MyPreferenceManager(Context paramContext){
        if (paramContext == null)
            throw new IllegalArgumentException("context cannot be null");
        this.mContext = paramContext;
    }

    /**
     *
     * @return
     */
    public SharedPreferences getSpHttpCook() {
        if(this.spHttpCook==null){
            this.spHttpCook = this.mContext.getSharedPreferences("http_cook", 0);
        }
        return this.spHttpCook;
    }

    /**
     * 保存Cookie
     * @param stringHashSet
     */
    public void setttpCookie(HashSet<String> stringHashSet){

        this.getSpHttpCook().edit().putStringSet("cookie",stringHashSet);
    }

    /**
     * 获取Cookie
     * @return
     */
    public HashSet<String> getHttpCookie(){
        return (HashSet<String>) this.getSpHttpCook().getStringSet("cookie",new HashSet<String>());
    }


    public SharedPreferences getSpSettings() {
        if (this.spSettings == null)
            this.spSettings = this.mContext.getSharedPreferences("settings", 0);
        return this.spSettings;
    }

    /**
     * 保存账号
     * @param userPhone
     */
    public boolean saveUserPhone(String userPhone) {
        return this.getSpSettings().edit().putString("LoginPhones",userPhone).commit();
    }

    /**
     * 获取保存的账号
     */
    public String getUserPhone(){
        return this.getSpSettings().getString("LoginPhones","");
    }













}
