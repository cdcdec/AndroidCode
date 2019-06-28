package com.laiqian.member.h;

import android.content.Context;
import android.database.Cursor;
import com.laiqian.entity.h;
import com.laiqian.member.model.a;
import com.orhanobut.logger.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class c {
  boolean bAX;
  
  double bBb = 0.0D;
  
  ArrayList<h> bjv = new ArrayList();
  
  public Context context;
  
  public c(Context paramContext) {
    this.context = paramContext;
    Rk();
  }
  
  private void a(double paramDouble, ArrayList<h> paramArrayList) {
    a a = new a(this.context);
    Cursor cursor = a.ai(paramDouble);
    a.close();
    if (cursor != null) {
      while (cursor.moveToNext()) {
        h h = new h();
        h.aSc = cursor.getDouble(1);
        h.aSd = cursor.getDouble(2);
        h.id = cursor.getString(3);
        h.aSe = cursor.getDouble(4);
        paramArrayList.add(h);
      } 
      cursor.close();
    } 
  }
  
  void Rk() {
    a a = new a(this.context);
    this.bAX = a.QM();
    a.close();
    this.bjv.clear();
  }
  
  public boolean Rl() { return this.bAX; }
  
  public void Rm() { this.bBb = 0.0D; }
  
  h aj(double paramDouble) {
    ArrayList arrayList = new ArrayList();
    for (byte b = 0; b < this.bjv.size(); b++) {
      if (paramDouble >= ((h)this.bjv.get(b)).aSc)
        arrayList.add(this.bjv.get(b)); 
    } 
    h h = null;
    if (arrayList.size() > 0) {
      Collections.sort(arrayList, new a(this));
      h = (h)arrayList.get(arrayList.size() - 1);
    } 
    return h;
  }
  
  public double ak(double paramDouble) {
    if (paramDouble <= 0.0D)
      return this.bBb; 
    this.bjv.clear();
    a(paramDouble, this.bjv);
    if (this.bjv == null || this.bjv.size() == 0)
      return this.bBb; 
    h h = aj(paramDouble);
    if (h != null) {
      boolean bool;
      if (paramDouble % h.aSc == 0.0D) {
        bool = true;
      } else {
        bool = false;
      } 
      Double double = Double.valueOf(paramDouble / h.aSc);
      long l = double.longValue();
      double d1 = this.bBb;
      double d2 = l;
      this.bBb = d1 + h.aSd * d2;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("isRemainder=");
      stringBuilder2.append(bool);
      stringBuilder2.append(" nearEntity.rechargeAmount=");
      stringBuilder2.append(h.aSc);
      stringBuilder2.append(" number1=");
      stringBuilder2.append(double);
      stringBuilder2.append(" totalGiftAmout=");
      stringBuilder2.append(this.bBb);
      stringBuilder2.append(" divisionInteger=");
      stringBuilder2.append(l);
      stringBuilder2.append(" rechargeAmount=");
      stringBuilder2.append(paramDouble);
      d.b(stringBuilder2.toString(), new Object[0]);
      if (bool)
        return this.bBb; 
      d1 = d2 * h.aSc;
      paramDouble -= d1;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("target=");
      stringBuilder1.append(paramDouble);
      stringBuilder1.append(" remainData=");
      stringBuilder1.append(d1);
      d.b(stringBuilder1.toString(), new Object[0]);
      if (paramDouble > 0.0D) {
        ak(paramDouble);
      } else {
        return this.bBb;
      } 
    } 
    return this.bBb;
  }
  
  public class a implements Comparator {
    public a(c this$0) {}
    
    public int compare(Object param1Object1, Object param1Object2) {
      param1Object1 = (h)param1Object1;
      param1Object2 = (h)param1Object2;
      return (param1Object1.aSc > param1Object2.aSc) ? 1 : ((param1Object1.aSc == param1Object2.aSc) ? 0 : ((param1Object1.aSc < param1Object2.aSc) ? -1 : 1));
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\h\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */