package com.laiqian.milestone;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

class t implements View.OnClickListener {
  t(orderdetails paramorderdetails) {}
  
  public void onClick(View paramView) {
    String str1 = ((EditText)this.bLw.findViewById(2131298265)).getText().toString().trim();
    String str2 = ((EditText)this.bLw.findViewById(2131298264)).getText().toString().trim();
    String str3 = ((EditText)this.bLw.findViewById(2131298263)).getText().toString().trim();
    h h = new h(this.bLw);
    h.a(orderdetails.Ud(), str1, str2, str3);
    Context context = this.bLw.getApplicationContext();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.bLw.getString(2131625995));
    stringBuilder.append(orderdetails.Ud());
    stringBuilder.append(this.bLw.getString(2131625996));
    Toast.makeText(context, stringBuilder.toString(), 1000).show();
    h.close();
    this.bLw.finish();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\milestone\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */