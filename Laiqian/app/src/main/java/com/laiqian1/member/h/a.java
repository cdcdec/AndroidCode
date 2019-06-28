package com.laiqian.member.h;

import android.content.Context;
import com.laiqian.entity.al;
import com.laiqian.entity.h;
import com.laiqian.promotion.c.a;
import com.laiqian.ui.a.g;
import java.util.ArrayList;

public class a {
  private a bAW;
  
  boolean bAX;
  
  private h bAY;
  
  private g bAZ;
  
  ArrayList<h> bjv = new ArrayList();
  
  public al bwL;
  
  public Context context;
  
  public a(Context paramContext) {
    this.context = paramContext;
    Rk();
  }
  
  private void a(double paramDouble, ArrayList<h> paramArrayList) {
    paramArrayList.clear();
    a a1 = new a(this.context);
    paramArrayList.addAll(a1.aS(paramDouble));
    a1.close();
  }
  
  private void a(Context paramContext, ArrayList<al> paramArrayList) {
    this.bAZ = new g(paramContext, paramArrayList, new b(this));
    this.bAZ.setCanceledOnTouchOutside(false);
    this.bAZ.show();
  }
  
  void Rk() {
    a a1 = new a(this.context);
    this.bAX = a1.alq();
    a1.close();
  }
  
  public boolean Rl() { return this.bAX; }
  
  public h a(Context paramContext, double paramDouble) {
    a(paramDouble, this.bjv);
    this.bAY = null;
    if (this.bjv.size() == 0) {
      if (this.bAW != null)
        this.bAW.a(null, this.bAY); 
    } else {
      h h1 = (h)this.bjv.get(0);
      if (h1 != null && !h1.equals(this.bAY)) {
        this.bAY = h1;
        ArrayList arrayList = h1.aSh;
        if (arrayList.size() == 0) {
          this.bwL = null;
          if (this.bAW != null)
            this.bAW.a(null, this.bAY); 
        } else if (arrayList.size() == 1) {
          this.bwL = (al)arrayList.get(0);
          if (this.bAW != null)
            this.bAW.a(this.bwL, this.bAY); 
        } else if (arrayList.size() > 1) {
          a(paramContext, arrayList);
        } 
      } 
    } 
    return this.bAY;
  }
  
  public void a(a parama) { this.bAW = parama; }
  
  public static interface a {
    void a(al param1al, h param1h);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\h\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */