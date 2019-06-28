package com.laiqian.print.cardreader;

import android.content.Context;
import android.content.Intent;
import com.google.a.a.a.a.a.a;
import com.laiqian.util.av;
import java.util.ArrayList;
import java.util.Iterator;

public class am {
  private static am cES;
  
  private Context mContext;
  
  static  {
  
  }
  
  private am(Context paramContext) { this.mContext = paramContext; }
  
  public static am ba(Context paramContext) {
    if (cES == null)
      cES = new am(paramContext.getApplicationContext()); 
    return cES;
  }
  
  public ArrayList<ah> afs() {
    av = new av(this.mContext);
    Object object = av.qQ("CardReaderSelections");
    av.close();
    if (object != null) {
      try {
        ArrayList arrayList = (ArrayList)object;
      } catch (Exception av) {
        a.e(av);
        av = null;
      } 
      object = av;
      if (av == null)
        object = new ArrayList(); 
      return object;
    } 
    av = null;
  }
  
  public void ai(ArrayList<ah> paramArrayList) {
    if (paramArrayList == null)
      return; 
    av av = new av(this.mContext);
    av.h("CardReaderSelections", paramArrayList);
    av.close();
    this.mContext.sendBroadcast(new Intent("pos_activity_change_data_cardreader"));
  }
  
  public void e(ah paramah) {
    ArrayList arrayList = afs();
    String str = paramah.afr().getIdentifier();
    for (ah ah1 : arrayList) {
      if (str.equals(ah1.afr().getIdentifier())) {
        ah1.d(paramah);
        ai(arrayList);
        return;
      } 
    } 
    arrayList.add(paramah);
    ai(arrayList);
  }
  
  public void f(ah paramah) {
    ArrayList arrayList = afs();
    Iterator iterator = arrayList.iterator();
    while (iterator.hasNext()) {
      if (((ah)iterator.next()).afr().getIdentifier().equals(paramah.afr().getIdentifier()))
        iterator.remove(); 
    } 
    ai(arrayList);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\cardreader\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */