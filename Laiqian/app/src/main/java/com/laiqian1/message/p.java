package com.laiqian.message;

import android.os.AsyncTask;
import com.alibaba.a.a.a.c;
import com.alibaba.a.a.a.e;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;

public class p extends AsyncTask<String, Void, Void> {
  private h bIt;
  
  private p(h paramh) { this.bIt = paramh; }
  
  protected static p a(h paramh) { return new p(paramh); }
  
  protected Void o(String... paramVarArgs) {
    try {
      this.bIt.gq(paramVarArgs[1]);
      this.bIt.c(this.bIt.Tp(), m.Tw(), m.Tx(), paramVarArgs[0], m.getVersion());
      i.a a = RootApplication.zv().zB().gB("redis message");
      if (a != null)
        a.aL(new Object()); 
    } catch (c paramVarArgs) {
      a.e(paramVarArgs);
    } catch (e paramVarArgs) {
      a.e(paramVarArgs);
    } 
    return null;
  }
  
  protected void onPostExecute(Void paramVoid) { super.onPostExecute(paramVoid); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\message\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */