package com.cdc.okhttp.httputils.okhttp1;

public class Data{
    private int ret;//返回接口状态码，其中：200成功，400非法请求，500服务器错误
    private int code;//操作码，1表示成功，其他都表示失败
    private String data;//加密以后的字符串
    private String key;//key值
    private String msg;//提示信息

    private String infoData;

    public String getInfoData() {
        return infoData;
    }
    public void setInfoData(String infoData) {
        this.infoData = infoData;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public String topString(){
        return "{" +
                "\"ret\":" + "\""+ret +"\""+
                ", \"code\":" +"\""+ code +"\""+
                ", \"data\":" + "\""+data +"\""+
                ", \"key\":" + "\""+key +"\""+
                ", \"msg\":" + "\""+msg +"\""+
                "}";
    }


    public String string() {
        return "{" +
                "\"ret\":" + "\""+ret +"\""+
                ", \"code\":" +"\""+ code +"\""+
                ", \"data\":" + "\""+data +"\""+
                ", \"key\":" + "\""+key +"\""+
                ", \"msg\":" + "\""+msg +"\""+
                ", \"info\":" + infoData +
                "}";
    }
}
