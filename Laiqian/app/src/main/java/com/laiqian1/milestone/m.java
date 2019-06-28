package com.laiqian.milestone;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

class m implements View.OnClickListener {
  m(orderOperationActivity paramorderOperationActivity) {}
  
  public void onClick(View paramView) {
    boolean bool;
    String str1 = ((EditText)this.bKO.findViewById(2131298256)).getText().toString().trim();
    String str3 = ((EditText)this.bKO.findViewById(2131298258)).getText().toString().trim();
    String str2 = ((EditText)this.bKO.findViewById(2131298245)).getText().toString().trim();
    if (str1 != "" && !str1.equals(null) && str1.length() > 0 && str3 != "" && !str3.equals(null) && str3.length() > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      double d1 = Double.parseDouble(str1);
      double d2 = Double.parseDouble(str3);
      if (d1 >= d2) {
        h h = new h(this.bKO);
        h.a(orderOperationActivity.Uc(), d1, d2, str2);
        TextView textView = (TextView)this.bKO.findViewById(2131298253);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d1 - d2);
        stringBuilder.append("");
        textView.setText(stringBuilder.toString());
        Context context = this.bKO.getApplicationContext();
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.bKO.getString(2131625995));
        stringBuilder.append(orderOperationActivity.Uc());
        stringBuilder.append(this.bKO.getString(2131625996));
        Toast.makeText(context, stringBuilder.toString(), 1000).show();
        h.close();
        this.bKO.setResult(-1);
        this.bKO.finish();
        return;
      } 
      if (orderOperationActivity.ci()) {
        str1 = this.bKO.getString(2131625947);
      } else {
        str1 = this.bKO.getString(2131625942);
      } 
      Toast.makeText(this.bKO.getApplicationContext(), str1, 1000).show();
      return;
    } 
    Toast.makeText(this.bKO.getApplicationContext(), ((TextView)this.bKO.findViewById(2131298250)).getText(), 1000).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\milestone\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */