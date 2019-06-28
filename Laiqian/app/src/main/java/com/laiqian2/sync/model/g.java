package com.laiqian.sync.model;

import android.os.Parcel;
import android.os.Parcelable;

final class g implements Parcelable.Creator {
  public SyncProgessMessage[] ko(int paramInt) { return new SyncProgessMessage[paramInt]; }
  
  public SyncProgessMessage s(Parcel paramParcel) {
    SyncProgessMessage syncProgessMessage = new SyncProgessMessage();
    syncProgessMessage.ow(paramParcel.readString());
    syncProgessMessage.km(paramParcel.readInt());
    syncProgessMessage.setResult(paramParcel.readInt());
    syncProgessMessage.kn(paramParcel.readInt());
    syncProgessMessage.setProgress(paramParcel.readInt());
    syncProgessMessage.setMessage(paramParcel.readString());
    return syncProgessMessage;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sync\model\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */