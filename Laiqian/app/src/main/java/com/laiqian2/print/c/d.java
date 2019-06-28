package com.laiqian.print.c;

import android.content.Context;
import com.laiqian.print.model.e;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class d implements c {
  private static d cIT;
  
  private ArrayList<a> cIU = new ArrayList();
  
  private b cIV = null;
  
  private Context mContext;
  
  static  {
  
  }
  
  private d(Context paramContext) {
    this.mContext = paramContext;
    ahk();
  }
  
  private void ahk() {}
  
  private void ahl() {}
  
  public static d bg(Context paramContext) {
    if (cIT == null)
      cIT = new d(paramContext.getApplicationContext()); 
    return cIT;
  }
  
  public void a(b paramb) { this.cIV = paramb; }
  
  public ArrayList<a> ahi() { return (ArrayList)this.cIU.clone(); }
  
  public void ahj() {
    for (a a : this.cIU) {
      if (a.getStatus() != 0 && a.getStatus() != 3) {
        null.remove();
        if (this.cIV != null)
          this.cIV.a(a); 
      } 
    } 
    ahl();
    ahk();
  }
  
  public int ahm() { return this.cIU.size(); }
  
  public void bq(int paramInt1, int paramInt2) {
    try {
      a a = (a)this.cIU.get(paramInt1);
      a.setStatus(paramInt2);
      ahl();
      return;
    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
      return;
    } 
  }
  
  public void c(a parama) {
    MobclickAgent.onEvent(this.mContext, "kitchen_print_fail_count");
    MobclickAgent.onEvent(this.mContext, "kitchen_print_fail_type", parama.aew().getTypeName());
    this.cIU.add(parama);
    ahl();
    if (this.cIV != null)
      this.cIV.b(parama); 
  }
  
  public void e(e parame) { parame.a(new e(this)); }
  
  public void p(Collection<e> paramCollection) {
    Iterator iterator = paramCollection.iterator();
    while (iterator.hasNext())
      e((e)iterator.next()); 
  }
  
  public void refresh() {
    ahl();
    ahk();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */