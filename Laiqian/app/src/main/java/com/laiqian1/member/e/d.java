package com.laiqian.member.e;

import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.as;
import com.laiqian.util.bd;
import com.laiqian.util.n;
import com.laiqian.vip.R;

class d implements View.OnClickListener {
  d(a parama) {}
  
  public void onClick(View paramView) {
    as as = new as();
    if (a.c(this.bym).isChecked()) {
      String str1 = a.d(this.bym).getText().toString().trim();
      String str2 = a.e(this.bym).getText().toString().trim();
      if (TextUtils.isEmpty(str1)) {
        a.d(this.bym).requestFocus();
        n.eP(R.string.please_enter_a_six_digi_number);
        return;
      } 
      if (TextUtils.isEmpty(str2)) {
        a.e(this.bym).requestFocus();
        n.eP(R.string.please_enter_a_six_digi_number);
        return;
      } 
      if (str2.length() != 6) {
        a.e(this.bym).requestFocus();
        n.eP(R.string.please_enter_a_six_digi_number);
        return;
      } 
      if (str1.length() != 6) {
        a.d(this.bym).requestFocus();
        n.eP(R.string.please_enter_a_six_digi_number);
        return;
      } 
      if (!str1.equals(str2)) {
        a.d(this.bym).setText("");
        a.e(this.bym).requestFocus();
        n.eP(R.string.passwords_do_not_match);
        return;
      } 
      as.isOpen = a.c(this.bym).isChecked();
      as.password = a.e(this.bym).getText().toString().trim();
    } else {
      as.isOpen = a.c(this.bym).isChecked();
      as.password = (a.f(this.bym)).password;
    } 
    if (RootApplication.getLaiqianPreferenceManager().Wq() && !bd.bH(a.g(this.bym))) {
      Toast.makeText(a.g(this.bym), a.g(this.bym).getString(R.string.please_check_network), 0).show();
      return;
    } 
    (new a.b(this.bym)).execute(new as[] { as });
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\e\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */