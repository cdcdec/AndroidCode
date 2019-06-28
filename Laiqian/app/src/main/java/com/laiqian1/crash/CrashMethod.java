package com.laiqian.crash;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.crash.model.l;
import com.laiqian.crash.model.n;
import com.laiqian.milestone.h;
import com.laiqian.ui.a.r;
import com.laiqian.util.av;
import com.laiqian.util.n;
import com.laiqian.util.p;
import java.util.Locale;

public class CrashMethod extends Activity {
  private String YH;
  
  private String aMS;
  
  l aMT = new l();
  
  private void CG() {
    av av = new av(this);
    String str = av.atm();
    boolean bool = av.auw();
    av.close();
    h h = new h(this);
    Cursor cursor = h.gN(str);
    Class clazz = p.bP(getBaseContext());
    if (cursor == null || !cursor.moveToFirst() || !bool)
      clazz = com.laiqian.login.view.LoginActivity.class; 
    if (cursor != null)
      cursor.close(); 
    h.close();
    if (!n.bL(CrashApplication.zv()))
      Locale.setDefault(Locale.US); 
    Intent intent = new Intent(getBaseContext(), clazz);
    intent.setFlags(67108864);
    startActivity(intent);
    finish();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    this.YH = paramBundle.getString("path");
    this.aMS = paramBundle.getString("crashtime");
    if (this.YH.length() == 0 || this.YH.equals("")) {
      Toast.makeText(getBaseContext(), getString(2131624883), 1).show();
      CG();
      return;
    } 
    (new n(this, new g(this), this.YH, this.aMS)).start();
    r r = new r(this, 3, new h(this));
    r.setTitle(getString(2131624882));
    r.s(getString(2131624883));
    r.pa(getString(2131624887));
    r.show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\crash\CrashMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */