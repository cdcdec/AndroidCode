package com.laiqian.login.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import com.laiqian.util.l;
import com.umeng.analytics.MobclickAgent;
import io.reactivex.c.a;
import io.reactivex.c.g;
import kotlin.Metadata;
import kotlin.e.g;
import kotlin.h;
import kotlin.jvm.b.f;

@Metadata
final class as implements View.OnClickListener {
  as(RegisterAccountActivity paramRegisterAccountActivity) {}
  
  public final void onClick(View paramView) {
    MobclickAgent.onEvent((Context)this.baj, "register_click_register_btn");
    this.baj.Em();
    l.Q((Activity)this.baj.getActivity());
    this.baj.Kl();
    AutoCompleteTextView autoCompleteTextView1 = this.baj.aZg.aZI;
    f.l(autoCompleteTextView1, "content.userPhoneEditText");
    String str1 = autoCompleteTextView1.getText().toString();
    if (str1 == null)
      throw new h("null cannot be cast to non-null type kotlin.CharSequence"); 
    str1 = g.trim((CharSequence)str1).toString();
    EditText editText1 = this.baj.aZg.aZK;
    f.l(editText1, "content.passwordEditText");
    String str3 = editText1.getText().toString();
    if (str3 == null)
      throw new h("null cannot be cast to non-null type kotlin.CharSequence"); 
    str3 = g.trim((CharSequence)str3).toString();
    if (TextUtils.isEmpty((CharSequence)str1) || TextUtils.isEmpty((CharSequence)str3)) {
      RegisterAccountActivity registerAccountActivity = this.baj;
      registerAccountActivity.eG(registerAccountActivity.getString(2131625462));
      registerAccountActivity.hideProgress();
      return;
    } 
    RegisterAccountActivityViewModel registerAccountActivityViewModel = RegisterAccountActivity.a(this.baj);
    AutoCompleteTextView autoCompleteTextView2 = this.baj.aZg.aZI;
    f.l(autoCompleteTextView2, "content.userPhoneEditText");
    String str2 = autoCompleteTextView2.getText().toString();
    EditText editText2 = this.baj.aZg.aZK;
    f.l(editText2, "content.passwordEditText");
    registerAccountActivityViewModel.G(str2, editText2.getText().toString()).a((a)new at(this)).a((g)new au(this), (g)new av(this));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\view\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */