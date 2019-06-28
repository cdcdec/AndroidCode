package com.laiqian.promotion.d;

import android.os.AsyncTask;
import com.laiqian.entity.ac;
import com.laiqian.promotion.e.a.b;
import com.laiqian.promotion.e.c;
import com.laiqian.promotion.g.c;
import com.laiqian.ui.ActivityRoot;
import java.util.ArrayList;

public class c {
  private c cVP;
  
  private c cVQ;
  
  public c(ActivityRoot paramActivityRoot, c paramc) {
    this.cVQ = paramc;
    this.cVP = new b(paramActivityRoot);
  }
  
  public void alH() { (new a(this, null)).execute(new Void[0]); }
  
  private class a extends AsyncTask<Void, Void, ArrayList<ac>> {
    private a(c this$0) {}
    
    protected void au(ArrayList<ac> param1ArrayList) {
      boolean bool;
      if (param1ArrayList.size() > 0) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool) {
        c.a(this.cVR).av(param1ArrayList);
        c.a(this.cVR).gw(false);
        return;
      } 
      c.a(this.cVR).gw(true);
    }
    
    protected ArrayList<ac> i(Void... param1VarArgs) { return c.b(this.cVR).alp(); }
    
    protected void onPreExecute() { c.a(this.cVR).gw(true); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotion\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */