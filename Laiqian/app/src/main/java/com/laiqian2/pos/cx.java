package com.laiqian.pos;

import android.database.Cursor;
import android.os.AsyncTask;
import com.google.a.a.a.a.a.a;
import com.laiqian.models.x;
import java.util.ArrayList;
import java.util.List;

class cx extends AsyncTask<Void, Void, List<ReprintActivity.c>> {
  cx(ReprintActivity paramReprintActivity) {}
  
  protected void C(List<ReprintActivity.c> paramList) {
    super.onPostExecute(paramList);
    ReprintActivity.j(this.cik);
    if (paramList != null) {
      ReprintActivity.a(this.cik).addAll(paramList);
      ReprintActivity.a(this.cik).notifyDataSetChanged();
    } 
    ReprintActivity.a(this.cik, false);
  }
  
  protected List<ReprintActivity.c> h(Void... paramVarArgs) {
    x x = new x(this.cik.getActivity());
    try {
      Cursor cursor = x.a(ReprintActivity.c(this.cik), ReprintActivity.d(this.cik), ReprintActivity.f(this.cik), 30);
    } catch (Exception paramVarArgs) {
      a.e(paramVarArgs);
      paramVarArgs = null;
    } 
    ArrayList arrayList = ReprintActivity.a(this.cik, paramVarArgs);
    paramVarArgs.close();
    x.close();
    return arrayList;
  }
  
  protected void onPreExecute() {
    ReprintActivity.a(this.cik, true);
    super.onPreExecute();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\cx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */