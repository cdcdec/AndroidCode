package com.laiqian.login.view;

import android.os.AsyncTask;
import android.util.Log;
import com.laiqian.sync.a.g;

class am extends AsyncTask<Void, Void, Void> {
  g aZY = null;
  
  am(LoginActivity.e parame) {}
  
  protected Void doInBackground(Void... paramVarArgs) {
    this.aZY.A(0L, System.currentTimeMillis());
    LoginActivity.h(this.aZX.aZD);
    Log.e("GetShopInfoTask", "2");
    return null;
  }
  
  protected void onPostExecute(Void paramVoid) { LoginActivity.f(this.aZX.aZD); }
  
  protected void onPreExecute() {
    this.aZY = new g(this.aZX.aZD.getActivity());
    this.aZY.a(new an(this));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\view\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */