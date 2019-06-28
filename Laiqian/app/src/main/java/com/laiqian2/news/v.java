package com.laiqian.news;

import android.os.AsyncTask;
import com.google.a.a.a.a.a.a;
import com.laiqian.network.i;
import com.laiqian.network.k;
import com.laiqian.opentable.common.m;
import java.io.IOException;
import org.json.JSONException;

public class v extends AsyncTask<String, Integer, i> {
  int bWU;
  
  private w.a bWV;
  
  public v(w.a parama) { this.bWV = parama; }
  
  public void a(i parami) {
    try {
      this.bWV.a(this.bWU, parami);
      return;
    } catch (Exception parami) {
      try {
        this.bWV.a(this.bWU, new i(false, false, ""));
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
  
  protected i w(String... paramVarArgs) {
    this.bWU = Integer.parseInt(paramVarArgs[0]);
    try {
      return (new k()).c(paramVarArgs[1], paramVarArgs[2], 0);
    } catch (IOException paramVarArgs) {
      a.e(paramVarArgs);
    } catch (Exception paramVarArgs) {
      a.e(paramVarArgs);
    } 
    return new i(false, false, "");
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\news\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */