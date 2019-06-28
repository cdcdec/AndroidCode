package com.laiqian.backup;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashMap;

public class ParcelableArray implements Parcelable {
  public static final Parcelable.Creator<ParcelableArray> CREATOR = new ai();
  
  private ArrayList<HashMap<String, Object>> aID;
  
  public ParcelableArray() {}
  
  public ParcelableArray(ArrayList<HashMap<String, Object>> paramArrayList) { this.aID = paramArrayList; }
  
  public int describeContents() { return 0; }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\backup\ParcelableArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */