package com.laiqian.models;

import android.content.Context;
import android.database.Cursor;
import android.text.format.Time;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.infrastructure.R;
import com.laiqian.report.models.e;
import com.laiqian.report.models.u;
import com.laiqian.report.models.y;
import com.laiqian.util.av;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class aj extends al {
  public aj(Context paramContext) { super(paramContext); }
  
  private e a(long paramLong1, long paramLong2, long paramLong3, Time paramTime, String paramString, u paramu) {
    paramTime.set(paramLong2);
    String str2 = paramTime.format(paramString);
    String[] arrayOfString = str2.split(" ");
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(hT(paramu.nq(arrayOfString[0])));
    stringBuilder2.append(" ");
    stringBuilder2.append(arrayOfString[1]);
    String str3 = stringBuilder2.toString();
    if (paramLong2 > 0L && paramLong3 == 0L) {
      paramLong3 = System.currentTimeMillis();
      String str = this.mContext.getString(R.string.pos_report_fastSelect_shift_now);
    } else {
      arrayOfString = null;
    } 
    paramTime.set(paramLong3);
    paramString = paramTime.format(paramString);
    String str1 = arrayOfString;
    if (arrayOfString == null) {
      str1 = paramString.split(" ");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(hT(paramu.nq(str1[0])));
      stringBuilder.append(" ");
      stringBuilder.append(str1[1]);
      str1 = stringBuilder.toString();
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(str3);
    stringBuilder1.append("-");
    stringBuilder1.append(str1);
    str1 = stringBuilder1.toString();
    return new e(paramLong1, new long[] { paramLong2, paramLong3 }, new String[] { str2, paramString }, str1);
  }
  
  private void a(int paramInt, long[][] paramArrayOfLong, String[] paramArrayOfString, String[][] paramArrayOfString1, long paramLong1, long paramLong2, Time paramTime, String paramString, u paramu) {
    String str1;
    new long[2][0] = paramLong1;
    new long[2][1] = paramLong2;
    paramArrayOfLong[paramInt] = new long[2];
    paramTime.set(paramLong1);
    String str3 = paramTime.format(paramString);
    String[] arrayOfString = str3.split(" ");
    paramTime.set(paramLong2);
    String str2 = paramTime.format(paramString);
    if (paramInt == 0) {
      str1 = this.mContext.getString(R.string.pos_report_fastSelect_shift_now);
    } else {
      null = str2.split(" ");
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(hT(paramu.nq(null[0])));
      stringBuilder1.append(" ");
      stringBuilder1.append(null[1]);
      str1 = stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(hT(paramu.nq(arrayOfString[0])));
    stringBuilder.append(" ");
    stringBuilder.append(arrayOfString[1]);
    stringBuilder.append("-");
    stringBuilder.append(str1);
    paramArrayOfString[paramInt] = stringBuilder.toString();
    new String[2][0] = str3;
    new String[2][1] = str2;
    paramArrayOfString1[paramInt] = new String[2];
  }
  
  private String hT(String paramString) {
    if (paramString.charAt(0) < '0' || paramString.charAt(0) > '9') {
      if (paramString.length() == 2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramString.charAt(0));
        stringBuilder.append(" ");
        stringBuilder.append(paramString.charAt(1));
        return stringBuilder.toString();
      } 
      return paramString;
    } 
    paramString = paramString.replace("-", "");
    return (paramString.length() >= 8) ? paramString.substring(2) : paramString;
  }
  
  public ArrayList<e> hR(String paramString) {
    ArrayList arrayList = new ArrayList();
    hY("_id,nShiftBeginTime,nShiftEndTime");
    stringBuilder = new StringBuilder();
    stringBuilder.append("(nSpareField2 is null or nSpareField2 = 0) and (nDeletionFlag is null or nDeletionFlag<>1) and nShopID=");
    stringBuilder.append(VC());
    hZ(stringBuilder.toString());
    ia("nShiftEndTime DESC");
    Cursor cursor = VM();
    Time time = new Time();
    time.setToNow();
    long l = RootApplication.getLaiqianPreferenceManager().atP();
    try {
      y y = new y(this.mContext);
    } catch (Exception stringBuilder) {
      a.e(stringBuilder);
      stringBuilder = null;
    } 
    arrayList.add(a(l, l, 0L, time, paramString, stringBuilder));
    while (cursor.moveToNext())
      arrayList.add(a(cursor.getLong(0), cursor.getLong(1), cursor.getLong(2), time, paramString, stringBuilder)); 
    cursor.close();
    stringBuilder.close();
    return arrayList;
  }
  
  @Deprecated
  public Object[] hS(String paramString) {
    hY("nShiftBeginTime,nShiftEndTime");
    null = new StringBuilder();
    null.append("(nSpareField2 is null or nSpareField2 = 0) and (nDeletionFlag is null or nDeletionFlag<>1) and nShopID=");
    null.append(VC());
    hZ(null.toString());
    ia("nShiftEndTime DESC");
    Cursor cursor = VM();
    int i = cursor.getCount() + 1;
    String[] arrayOfString = new String[i];
    long[][] arrayOfLong = (long[][])Array.newInstance(long.class, new int[] { i, 2 });
    String[][] arrayOfString1 = (String[][])Array.newInstance(String.class, new int[] { i, 2 });
    Time time = new Time();
    time.setToNow();
    av = new av(this.mContext);
    long l = av.atP();
    av.close();
    try {
      y y = new y(this.mContext);
    } catch (Exception av) {
      a.e(av);
      av = null;
    } 
    a(0, arrayOfLong, arrayOfString, arrayOfString1, l, time.normalize(false), time, paramString, av);
    for (i = 1; cursor.moveToNext(); i++)
      a(i, arrayOfLong, arrayOfString, arrayOfString1, cursor.getLong(0), cursor.getLong(1), time, paramString, av); 
    cursor.close();
    av.close();
    return new Object[] { arrayOfString, arrayOfLong, arrayOfString1 };
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */