package com.laiqian.takeaway;

import android.os.AsyncTask;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.f.b;
import com.laiqian.util.bd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;

public class ay extends AsyncTask<String, Void, String> {
  private HashMap<String, String> czV;
  
  private al.a dtL;
  
  private boolean dtM = false;
  
  public ay(HashMap<String, String> paramHashMap, al.a parama) {
    this.dtL = parama;
    this.czV = paramHashMap;
  }
  
  protected String A(String... paramVarArgs) {
    Log.i("onClick", "doInBackground ");
    str = paramVarArgs[0];
    Iterator iterator = this.czV.entrySet().iterator();
    ArrayList arrayList = new ArrayList();
    while (iterator.hasNext()) {
      Map.Entry entry = (Map.Entry)iterator.next();
      if (entry.getKey() != null)
        arrayList.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue())); 
    } 
    try {
      return b.cM(bd.d(str, arrayList));
    } catch (Exception str) {
      a.e(str);
      return "";
    } 
  }
  
  protected void bf(String paramString) { this.dtL.jI(paramString); }
  
  protected void onPreExecute() { super.onPreExecute(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */