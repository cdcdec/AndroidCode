package com.laiqian.opentable.common;

import android.os.AsyncTask;
import com.google.a.a.a.a.a.a;
import com.laiqian.network.i;
import com.laiqian.network.k;
import java.io.IOException;
import org.json.JSONException;

public class a extends AsyncTask<String, Integer, i> {
  public static int bYQ = 111;
  
  private t.a bYR;
  
  static  {
  
  }
  
  public a(t.a parama) { this.bYR = parama; }
  
  public void a(i parami) {
    try {
      this.bYR.d(parami);
      return;
    } catch (Exception parami) {
      a.e(parami);
      try {
        this.bYR.d(new i(false, false, ""));
        return;
      } catch (JSONException parami) {
        a.e(parami);
        return;
      } catch (m parami) {
        a.e(parami);
        return;
      } 
    } 
  }
  
  public void onPreExecute() {}
  
  public i w(String... paramVarArgs) {
    try {
      return (new k()).c(paramVarArgs[0], paramVarArgs[1], 1);
    } catch (IOException paramVarArgs) {
      a.e(paramVarArgs);
    } catch (Exception paramVarArgs) {
      a.e(paramVarArgs);
    } 
    return new i(false, bYQ, "");
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */