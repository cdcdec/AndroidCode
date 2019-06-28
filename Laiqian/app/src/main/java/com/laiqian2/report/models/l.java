package com.laiqian.report.models;

import android.text.format.Time;
import com.laiqian.entity.z;

public class l extends z {
  public final long bTd;
  
  public final boolean daH;
  
  public final String daI;
  
  public final String daJ;
  
  public final String orderNo;
  
  public l(int paramInt, double paramDouble, String paramString1, long paramLong1, boolean paramBoolean, String paramString2, String paramString3, long paramLong2, String paramString4) {
    super(paramInt, paramDouble, paramString1, paramLong1);
    this.daH = paramBoolean;
    this.orderNo = paramString2;
    this.daI = paramString3;
    this.bTd = paramLong2;
    this.aTy = paramString4;
    Time time = new Time();
    time.set(paramLong2);
    this.daJ = time.format("%Y.%m.%d  %H:%M:%S");
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\models\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */