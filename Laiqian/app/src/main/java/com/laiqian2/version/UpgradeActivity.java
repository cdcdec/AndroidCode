package com.laiqian.version;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.laiqian.c.a;
import com.laiqian.infrastructure.R;

public class UpgradeActivity extends Activity {
  private void awV() {
    cn(this);
    finish();
  }
  
  public static void cn(Context paramContext) {
    Intent intent = new Intent();
    if (a.zR().Ae() || a.zR().Ag() || a.zR().As() || a.zR().Ah() || a.zR().zY()) {
      intent.setClass(paramContext, com.laiqian.version.view.UpgradeAndEvaluationActivity.class);
    } else {
      intent.setClass(paramContext, UpgradeAndEvaluate.class);
    } 
    paramContext.startActivity(intent);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(R.layout.pos_downloader_after_login);
    awV();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\UpgradeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */