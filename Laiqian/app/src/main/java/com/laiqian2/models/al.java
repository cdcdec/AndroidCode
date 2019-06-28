package com.laiqian.models;

import android.content.Context;
import android.database.Cursor;
import java.util.HashMap;

public class al extends ak {
  public al() { this(null); }
  
  public al(Context paramContext) { super(paramContext); }
  
  public boolean UF() { return !!QL(); }
  
  public HashMap<String, Object> bB(long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("nShiftEndTime=");
    stringBuilder.append(paramLong);
    hZ(stringBuilder.toString());
    hY("nUserID,nShiftBeginTime,fImprest");
    Cursor cursor = VM();
    if (cursor.moveToFirst()) {
      HashMap hashMap = new HashMap();
      hashMap.put("nUserID", Long.valueOf(cursor.getLong(0)));
      hashMap.put("nShiftBeginTime", Long.valueOf(cursor.getLong(1)));
      hashMap.put("nShiftEndTime", Long.valueOf(paramLong));
      hashMap.put("fImprest", cursor.getString(2));
    } else {
      stringBuilder = null;
    } 
    cursor.close();
    return stringBuilder;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */