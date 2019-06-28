package com.laiqian.repair;

import android.content.pm.PackageManager;
import android.database.Cursor;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.models.as;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.util.n;
import java.util.Arrays;

public abstract class a extends f<e> {
  public a(ActivityRoot paramActivityRoot, e parame) { super(paramActivityRoot, parame); }
  
  private String a(int paramInt, as paramas, e parame, String[] paramArrayOfString) throws Throwable {
    if (paramInt < parame.cXU.length && parame.cXU[paramInt] != null) {
      String[] arrayOfString1;
      int i = 0;
      String[] arrayOfString2 = paramArrayOfString;
      if (paramArrayOfString == null) {
        int j = n.be(parame.cXU[paramInt], "?");
        arrayOfString2 = paramArrayOfString;
        if (j > 0) {
          paramArrayOfString = new String[j];
          byte b = 0;
          while (true) {
            arrayOfString2 = paramArrayOfString;
            if (b < j) {
              paramArrayOfString[b] = paramas.VC();
              b++;
              continue;
            } 
            break;
          } 
        } 
      } 
      if (paramInt >= parame.cXV.length || parame.cXV[paramInt] == null) {
        paramArrayOfString = parame.cXU[paramInt].split(";");
        int j = 0;
        for (paramInt = i; paramInt < paramArrayOfString.length; paramInt++) {
          String str = paramArrayOfString[paramInt];
          if (!str.trim().isEmpty()) {
            i = n.be(str, "?");
            if (arrayOfString2 == null) {
              parame = null;
            } else {
              arrayOfString1 = (String[])Arrays.copyOfRange(arrayOfString2, j, j + i);
            } 
            j += i;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(",参数：");
            stringBuilder.append(Arrays.toString(arrayOfString1));
            Log.i("修复执行的SQL语句：", stringBuilder.toString());
            paramas.Vq().execSQL(str, arrayOfString1);
          } 
        } 
        return null;
      } 
      null = new StringBuilder();
      null.append(arrayOfString1.cXU[paramInt]);
      null.append(",参数：");
      null.append(Arrays.toString(arrayOfString2));
      Log.i("查询的SQL语句：", null.toString());
      Cursor cursor = paramas.Vq().rawQuery(arrayOfString1.cXU[paramInt], arrayOfString2);
      while (cursor.moveToNext()) {
        arrayOfString2 = arrayOfString1.cXV[paramInt].split(",");
        String[] arrayOfString = new String[arrayOfString2.length];
        byte b;
        for (b = 0; b < arrayOfString.length; b++)
          arrayOfString[b] = cursor.getString(cursor.getColumnIndex(arrayOfString2[b])); 
        String str = a(paramInt + 1, paramas, arrayOfString1, arrayOfString);
        if (str != null) {
          cursor.close();
          return str;
        } 
      } 
      cursor.close();
      return null;
    } 
    return null;
  }
  
  protected boolean a(e parame) {
    PackageManager packageManager = this.mActivity.getPackageManager();
    try {
      if ((packageManager.getPackageInfo(this.mActivity.getPackageName(), 0)).versionCode < parame.versionCode) {
        n.a(this.mActivity, "请更新最新版本");
        return false;
      } 
      return true;
    } catch (android.content.pm.PackageManager.NameNotFoundException parame) {
      a.e(parame);
      return false;
    } 
  }
  
  protected String b(e parame) {
    String str;
    try {
      exception = new as(this.mActivity);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    exception.beginTransaction();
    try {
      str = a(0, exception, parame, null);
    } catch (Throwable parame) {
      a.e(parame);
      str = "执行失败";
    } 
    if (str == null && !this.mActivity.isFinishing())
      exception.setTransactionSuccessful(); 
    exception.endTransaction();
    exception.close();
    return str;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repair\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */