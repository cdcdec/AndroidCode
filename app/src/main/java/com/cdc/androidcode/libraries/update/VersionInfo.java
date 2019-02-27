package com.cdc.androidcode.libraries.update;

import com.cdc.androidcode.R;
import sskj.lee.appupdatelibrary.BaseVersion;

public class VersionInfo extends BaseVersion {

    private String title;
    private String content;
    private String version_name;
    private String url;
    private boolean mustup;


    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setVersion_name(String version_name) {
        this.version_name = version_name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setMustup(boolean mustup) {
        this.mustup = mustup;
    }

//    @Override
//    public String getVersionName() {
//        return TextUtils.isEmpty(version_name) ? "default" : version_name;
//    }

    public void setViewStyle(int viewStyle) {
        view_style = viewStyle;
    }

    @Override
    public int getNotifyIcon() {
        return R.mipmap.ic_launcher;
    }

    @Override
    public boolean isMustUp() {
        return mustup;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public int getViewStyle() {
        return view_style;
    }
}
