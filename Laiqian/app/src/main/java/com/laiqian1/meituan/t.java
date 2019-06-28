package com.laiqian.meituan;

import android.app.Activity;
import android.widget.Button;
import com.google.a.a.a.a.a.a;
import com.laiqian.takeaway.bc;
import com.laiqian.ui.a.d;
import com.laiqian.util.n;
import org.json.JSONException;

public class t extends d {
  private Activity azD;
  
  Button azE;
  
  Button azF;
  
  public t(Activity paramActivity) {
    super(paramActivity, R.layout.dialog_meituan_phone_number_error);
    this.azD = paramActivity;
    wR();
    setListeners();
    setCancelable(false);
  }
  
  private void fn(String paramString) {
    bc bc = new bc(getContext());
    try {
      bc.z(paramString, false);
      return;
    } catch (JSONException paramString) {
      n.o("打印出错");
      a.e(paramString);
      return;
    } 
  }
  
  private void setListeners() {
    this.azF.setOnClickListener(new u(this));
    this.azE.setOnClickListener(new v(this));
  }
  
  private void wR() {
    this.azF = (Button)this.mView.findViewById(R.id.btn_cancel);
    this.azE = (Button)this.mView.findViewById(R.id.btn_confirm);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */