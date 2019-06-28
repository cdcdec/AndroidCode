package com.laiqian.milestone;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.laiqian.util.l;

class w implements View.OnClickListener {
  w(user_changePassword paramuser_changePassword) {}
  
  public void onClick(View paramView) {
    h h = new h(this.bLU);
    user_changePassword.ej(true);
    user_changePassword.gU(((EditText)this.bLU.findViewById(2131299867)).getText().toString().trim());
    user_changePassword.gT(((EditText)this.bLU.findViewById(2131299863)).getText().toString().trim());
    String str = ((EditText)this.bLU.findViewById(2131299861)).getText().toString().trim();
    if (h.d(user_changePassword.Um(), user_changePassword.Un())) {
      if (user_changePassword.Ui().equals(str) && user_changePassword.Ui().length() > 0) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(user_changePassword.Uo());
        stringBuilder.append("");
        if ("150001".equals(stringBuilder.toString())) {
          h.a(user_changePassword.Up(), user_changePassword.Um(), user_changePassword.Ui());
        } else {
          h.e(user_changePassword.Um(), user_changePassword.Ui());
        } 
        String str1 = this.bLU.getString(2131630182);
        Toast.makeText(this.bLU.getApplicationContext(), str1, 1).show();
        if (!l.bH(this.bLU)) {
          this.bLU.finish();
          return;
        } 
      } else {
        str = this.bLU.getString(2131630167);
        Toast.makeText(this.bLU.getApplicationContext(), str, 1).show();
      } 
    } else {
      str = this.bLU.getString(2131630169);
      Toast.makeText(this.bLU.getApplicationContext(), str, 1).show();
    } 
    h.close();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\milestone\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */