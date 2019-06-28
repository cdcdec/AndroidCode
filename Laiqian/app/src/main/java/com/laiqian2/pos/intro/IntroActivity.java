package com.laiqian.pos.intro;

import android.content.Intent;
import android.os.Bundle;
import com.laiqian.c.a;
import com.laiqian.intro.IntroFragment2;
import com.laiqian.intro.appintro.AppIntro2;
import com.laiqian.util.n;

public class IntroActivity extends AppIntro2 {
  public void Jv() {
    startActivity(new Intent(this, com.laiqian.login.view.LoginActivity.class));
    finish();
  }
  
  public void g(Bundle paramBundle) {
    if (a.zR().Ae() || a.zR().Ah() || a.zR().As()) {
      b(IntroFragment2.b("", "", 2131231156));
      b(IntroFragment2.b("", "", 2131231157));
      b(IntroFragment2.b("", "", 2131231158));
      return;
    } 
    b(IntroFragment2.b("", "", 2131231156));
    b(IntroFragment2.b("", "", 2131231157));
  }
  
  protected void onResume() {
    super.onResume();
    n.aL(this);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\intro\IntroActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */