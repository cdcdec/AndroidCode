package com.laiqian.milestone;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

class s implements DialogInterface.OnClickListener {
  s(q paramq) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt) {
    h h = new h(this.bLx.bLw);
    h.aW(orderdetails.Ud());
    Context context = this.bLx.bLw.getApplicationContext();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.bLx.bLw.getString(2131625995));
    stringBuilder.append(orderdetails.Ud());
    stringBuilder.append(this.bLx.bLw.getString(2131625993));
    Toast.makeText(context, stringBuilder.toString(), 1000).show();
    h.close();
    this.bLx.bLw.finish();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\milestone\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */