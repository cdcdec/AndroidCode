package com.laiqian.pos.model;

import android.content.Context;
import android.database.Cursor;
import com.laiqian.entity.u;
import com.laiqian.models.as;
import com.laiqian.util.by;
import java.util.ArrayList;

public class f extends as {
  public f(Context paramContext) {
    super(paramContext);
    gk(86);
  }
  
  private boolean h(String paramString, long paramLong) {
    if (paramString == null)
      return false; 
    if (paramLong > 0L) {
      k(paramString, paramLong);
    } else {
      ij(paramString);
    } 
    Cursor cursor = VM();
    if (cursor == null)
      return true; 
    boolean bool = cursor.moveToFirst();
    cursor.close();
    return bool;
  }
  
  public boolean O(long paramLong) {
    String str;
    bF(paramLong);
    am(this.bSR, this.bSU);
    boolean bool = delete();
    if (bool) {
      str = String.format(this.mContext.getString(2131627186), new Object[] { hQ("sFieldName") });
    } else {
      str = this.mContext.getString(2131629006);
    } 
    hP(str);
    return bool;
  }
  
  protected boolean QL() {
    boolean bool;
    if (UA()) {
      bool = Wc();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.mContext.getString(2131627214));
      stringBuilder.append(" ");
      stringBuilder.append(VZ());
      stringBuilder.append(" ");
      stringBuilder.append(this.mContext.getString(2131630144));
      hP(stringBuilder.toString());
    } else {
      bool = false;
    } 
    UD();
    return bool;
  }
  
  protected boolean UA() {
    if (h(Wa(), -1L)) {
      hP(this.mContext.getString(2131627507));
      return false;
    } 
    return true;
  }
  
  protected boolean UB() { return true; }
  
  protected boolean UD() { return true; }
  
  protected boolean UE() { return true; }
  
  public ArrayList<u> acN() {
    ArrayList arrayList = new ArrayList();
    hY("_id,sFieldName");
    ia(" sDefaultValue desc ");
    null = new StringBuilder();
    null.append(" nFieldType=86 and sIsActive='Y' and nShopID=");
    null.append(VC());
    hZ(null.toString());
    Cursor cursor = VM();
    while (cursor.moveToNext())
      arrayList.add(new u(by.parseLong(cursor.getString(0)), cursor.getString(1))); 
    cursor.close();
    return arrayList;
  }
  
  public ArrayList<u> acO() {
    ArrayList arrayList = new ArrayList();
    arrayList.add(u.FO());
    arrayList.add(u.FP());
    arrayList.addAll(acN());
    return arrayList;
  }
  
  public boolean bl(long paramLong) {
    bE(paramLong);
    boolean bool2 = UB();
    boolean bool1 = false;
    if (bool2) {
      String str;
      if (h(Wa(), paramLong)) {
        hP(this.mContext.getString(2131627507));
        return false;
      } 
      bE(paramLong);
      bool1 = update();
      if (bool1) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mContext.getString(2131627214));
        stringBuilder.append(" ");
        stringBuilder.append(VZ());
        stringBuilder.append(" ");
        stringBuilder.append(this.mContext.getString(2131630154));
        str = stringBuilder.toString();
      } else {
        null = new StringBuilder();
        null.append(this.mContext.getString(2131627214));
        null.append(" ");
        null.append(VZ());
        null.append(" ");
        null.append(this.mContext.getString(2131630155));
        str = null.toString();
      } 
      hP(str);
    } 
    UE();
    return bool1;
  }
  
  public Cursor cv(long paramLong) {
    String str1 = Wb();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramLong);
    stringBuilder1.append("");
    String str2 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramLong);
    stringBuilder2.append("");
    c(str1, new String[] { str2, stringBuilder2.toString() });
    return VM();
  }
  
  public String cw(long paramLong) {
    String str = "";
    if (paramLong <= 86003L)
      return u.al(paramLong); 
    hY("sFieldName");
    Cursor cursor = cv(paramLong);
    if (cursor.moveToFirst())
      str = cursor.getString(0); 
    cursor.close();
    return str;
  }
  
  public boolean kC(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append("");
    String str = stringBuilder.toString();
    am("_id", str);
    am("sFieldName", paramString);
    am("sFieldValue", str);
    am("nFieldType", "86");
    am("nStringID", "1");
    return QL();
  }
  
  public boolean v(long paramLong, String paramString) {
    am("sFieldName", paramString);
    return bl(paramLong);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\model\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */