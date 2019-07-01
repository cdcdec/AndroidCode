package com.cdc.screen;

public class ScreenInfo {
    private float density;
    private int densityDpi;
    private int widthPixels;
    private int heightPixels;
    private float widthDpi;
    private float heightDpi;
    /**
     *状态栏高度 像素
     */
    private int ststusHeightPix;
    /**
     *状态栏高度 dp
     */
    private int statusHeightDp;


    public int getStstusHeightPix() {
        return ststusHeightPix;
    }

    public void setStstusHeightPix(int ststusHeightPix) {
        this.ststusHeightPix = ststusHeightPix;
    }

    public int getStatusHeightDp() {
        return statusHeightDp;
    }

    public void setStatusHeightDp(int statusHeightDp) {
        this.statusHeightDp = statusHeightDp;
    }

    /**
     *横竖屏
     */
    private String orientation;
    /**
     *Android系统版本号
     */
    private String systemVersion;
    /**
     *手机型号
     */
    private String systemModel;
    /**
     *手机厂商
     */
    private String deviceBrand;

    /**
     *设备制造商
     */
    private String  facturer;

    /**
     *整个产品的名称
     */
    private String product;

    /**
     *api level
     */
    private int sdkLevel;


    public float getDensity() {
        return density;
    }

    public void setDensity(float density) {
        this.density = density;
    }

    public int getDensityDpi() {
        return densityDpi;
    }

    public void setDensityDpi(int densityDpi) {
        this.densityDpi = densityDpi;
    }

    public int getWidthPixels() {
        return widthPixels;
    }

    public void setWidthPixels(int widthPixels) {
        this.widthPixels = widthPixels;
    }

    public int getHeightPixels() {
        return heightPixels;
    }

    public void setHeightPixels(int heightPixels) {
        this.heightPixels = heightPixels;
    }

    public float getWidthDpi() {
        return widthDpi;
    }

    public void setWidthDpi(float widthDpi) {
        this.widthDpi = widthDpi;
    }

    public float getHeightDpi() {
        return heightDpi;
    }

    public void setHeightDpi(float heightDpi) {
        this.heightDpi = heightDpi;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }

    public String getSystemModel() {
        return systemModel;
    }

    public void setSystemModel(String systemModel) {
        this.systemModel = systemModel;
    }

    public String getDeviceBrand() {
        return deviceBrand;
    }

    public void setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand;
    }

    public String getFacturer() {
        return facturer;
    }

    public void setFacturer(String facturer) {
        this.facturer = facturer;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getSdkLevel() {
        return sdkLevel;
    }

    public void setSdkLevel(int sdkLevel) {
        this.sdkLevel = sdkLevel;
    }

    @Override
    public String toString() {
        return "{" +
                "density:" + density +
                ", densityDpi:" + densityDpi +
                ", widthPixels:" + widthPixels +
                ", heightPixels:" + heightPixels +
                ", widthDpi:" + widthDpi +
                ", heightDpi:" + heightDpi +
                ", ststusHeightPix:" + ststusHeightPix +
                ", statusHeightDp:" + statusHeightDp +
                ", orientation:\"" + orientation + "\"" +
                ", systemVersion:\"" + systemVersion + "\"" +
                ", systemModel:\"" + systemModel + "\"" +
                ", deviceBrand:\"" + deviceBrand + "\"" +
                ", facturer:\"" + facturer + "\"" +
                ", product:\"" + product + "\"" +
                ", sdkLevel:" + sdkLevel +
                '}';
    }
}

