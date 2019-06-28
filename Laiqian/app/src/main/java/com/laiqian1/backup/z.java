package com.laiqian.backup;

import android.view.View;
import android.widget.AdapterView;
import com.laiqian.ui.a.bb;
import com.laiqian.util.bd;
import java.io.File;
import java.util.Date;

class z implements AdapterView.OnItemClickListener {
  z(BackUpSystemHaltedActivity paramBackUpSystemHaltedActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    if (paramInt != 0)
      return; 
    if (!bd.bH(this.aIm))
      return; 
    if (BackUpSystemHaltedActivity.d(this.aIm) == null)
      BackUpSystemHaltedActivity.a(this.aIm, new bb(this.aIm)); 
    BackUpSystemHaltedActivity.d(this.aIm).show();
    BackUpSystemHaltedActivity backUpSystemHaltedActivity = this.aIm;
    String str2 = this.aIm.getLaiqianPreferenceManager().Ea();
    String str3 = this.aIm.getLaiqianPreferenceManager().auN();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.aIm.getLaiqianPreferenceManager().Tx());
    stringBuilder2.append("-");
    stringBuilder2.append((new Date()).getTime());
    String str1 = backUpSystemHaltedActivity.getString(2131628298, new Object[] { str2, str3, stringBuilder2.toString() });
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.aIm.aHg);
    stringBuilder1.append("/");
    stringBuilder1.append(this.aIm.aHf);
    File file = new File(stringBuilder1.toString());
    BackUpSystemHaltedActivity.a(this.aIm, str1, file);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\backup\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */