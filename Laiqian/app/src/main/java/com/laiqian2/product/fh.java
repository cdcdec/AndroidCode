package com.laiqian.product;

import android.os.AsyncTask;
import android.util.Log;
import com.laiqian.basic.RootApplication;
import com.laiqian.sync.a.g;

class fh extends AsyncTask<Void, Void, Void> {
  g aZY = null;
  
  fh(fa paramfa) {}
  
  protected Void doInBackground(Void... paramVarArgs) {
    this.aZY.apy().gW(true);
    this.aZY.a(true, "t_string", 0L, System.currentTimeMillis());
    boolean bool = this.aZY.execute();
    this.aZY.close();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" 修改类型后实时上传t_string success=");
    stringBuilder.append(bool);
    Log.i("ContentValues", stringBuilder.toString());
    return null;
  }
  
  protected void onPostExecute(Void paramVoid) {}
  
  protected void onPreExecute() {
    this.aZY = new g(RootApplication.zv());
    this.aZY.a(new fi(this));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\fh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */