package com.laiqian.meituan;

import android.os.Bundle;
import com.laiqian.intro.IntroFragment2;
import com.laiqian.intro.appintro.AppIntro2;
import com.laiqian.util.n;

public class MeituanIntroActivity extends AppIntro2 {
  public void Jv() { finish(); }
  
  public void g(Bundle paramBundle) {
    b(IntroFragment2.b("", "", R.drawable.meituan_intro_one));
    b(IntroFragment2.b("", "", R.drawable.meituan_intro_two));
    b(IntroFragment2.b("", "", R.drawable.meituan_intro_three));
  }
  
  protected void onResume() {
    super.onResume();
    n.aL(this);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\MeituanIntroActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */