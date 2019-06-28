package com.laiqian.login.a;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.laiqian.pos.hardware.q;

class i implements View.OnClickListener {
  i(b paramb) {}
  
  public void onClick(View paramView) {
    Intent intent = b.b(this.aXX).getPackageManager().getLaunchIntentForPackage("com.softwinner.update");
    if (intent != null) {
      b.b(this.aXX).startActivity(intent);
      intent = new Intent("android.intent.action.VIEW");
      intent.setData(Uri.parse(q.clB));
      b.b(this.aXX).startActivity(intent);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */