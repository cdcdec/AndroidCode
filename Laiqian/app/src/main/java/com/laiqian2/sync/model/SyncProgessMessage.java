package com.laiqian.sync.model;

import android.os.Parcel;
import android.os.Parcelable;

public class SyncProgessMessage implements Parcelable {
  public static int COMPLETE = 100;
  
  public static final Parcelable.Creator<SyncProgessMessage> CREATOR = new g();
  
  public static String PROGRESS = "PROGRESS";
  
  public static int START = 0;
  
  public static String bUD = "SERVICE_TYPE";
  
  public static String doX = "RESULT";
  
  public static String doY = "MESSAGE";
  
  public static int doZ = 8;
  
  public static boolean doo = false;
  
  public static int dpa = 58;
  
  public static int dpb = 78;
  
  public static int dpc = 88;
  
  public static int dpd = 98;
  
  private String doS;
  
  private int doT;
  
  private int doU;
  
  private int doV;
  
  private String doW;
  
  private int nProgress;
  
  public String adA() { return this.doS; }
  
  public boolean apG() { return doo; }
  
  public int apH() { return this.doU; }
  
  public int apI() { return this.doV; }
  
  public int describeContents() { return 0; }
  
  public void gW(boolean paramBoolean) { doo = paramBoolean; }
  
  public int getProgress() { return this.nProgress; }
  
  public void init() {
    this.doS = "";
    this.doT = 0;
    this.doU = 0;
    this.doV = 0;
    this.nProgress = START;
    this.doW = "";
  }
  
  public void km(int paramInt) { this.doT = paramInt; }
  
  public void kn(int paramInt) { this.doV = paramInt; }
  
  public void ow(String paramString) { this.doS = paramString; }
  
  public void setMessage(String paramString) { this.doW = paramString; }
  
  public void setProgress(int paramInt) { this.nProgress = paramInt; }
  
  public void setResult(int paramInt) { this.doU = paramInt; }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.doS);
    paramParcel.writeInt(this.doT);
    paramParcel.writeInt(this.doU);
    paramParcel.writeInt(this.doV);
    paramParcel.writeInt(this.nProgress);
    paramParcel.writeString(this.doW);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sync\model\SyncProgessMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */