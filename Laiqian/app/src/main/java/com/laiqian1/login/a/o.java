package com.laiqian.login.a;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;
import com.laiqian.pos.hardware.q;
import com.laiqian.util.bd;
import com.umeng.analytics.MobclickAgent;

class o implements View.OnClickListener {
  o(b paramb) {}
  
  public void onClick(View paramView) {
    MobclickAgent.onEvent(b.b(this.aXX), "update_ota", "in_login");
    if (!bd.bH(b.b(this.aXX))) {
      Toast.makeText(b.b(this.aXX), 2131628452, 0).show();
      return;
    } 
    b.a(this.aXX);
    b.c(this.aXX).dismiss();
    Intent intent = new Intent("com.laiqian.network.service.DownloadOtaService");
    intent.setPackage(b.b(this.aXX).getPackageName());
    intent.putExtra("sFileName", b.j(this.aXX));
    intent.putExtra("sVersion", b.k(this.aXX));
    intent.putExtra("sFileDir", b.l(this.aXX));
    intent.putExtra("bCloseService", false);
    b.b(this.aXX).startService(intent);
    intent = new Intent("android.intent.action.VIEW");
    intent.setData(Uri.parse(q.clB));
    b.b(this.aXX).startActivity(intent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\a\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */