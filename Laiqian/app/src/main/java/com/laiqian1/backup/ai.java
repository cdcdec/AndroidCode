package com.laiqian.backup;

import android.os.Parcel;
import android.os.Parcelable;

final class ai extends Object implements Parcelable.Creator<ParcelableArray> {
  public ParcelableArray[] dQ(int paramInt) { return new ParcelableArray[paramInt]; }
  
  public ParcelableArray q(Parcel paramParcel) { return new ParcelableArray(paramParcel.readArrayList(null)); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\backup\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */