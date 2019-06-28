package com.laiqian.version;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.laiqian.basic.RootApplication;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.a.r;
import com.laiqian.util.n;

public class o {
  private r blT;
  
  @NonNull
  protected String dIt;
  
  private final double dIu;
  
  protected Activity mActivity;
  
  private Handler mHandler = new Handler();
  
  public o(Activity paramActivity, @NonNull String paramString, double paramDouble) {
    this.mActivity = paramActivity;
    this.dIt = paramString;
    if (paramDouble > 0.0D && paramDouble <= 1.0D) {
      this.dIu = paramDouble;
      return;
    } 
    this.dIu = 0.0D;
  }
  
  protected void k(Runnable paramRunnable) { Message.obtain(this.mHandler, paramRunnable).sendToTarget(); }
  
  protected class a implements Runnable {
    private String message;
    
    @Nullable
    private String url;
    
    private String versionName;
    
    public a(o this$0, String param1String1, String param1String2, @Nullable String param1String3) {
      this.versionName = param1String1;
      this.message = param1String2;
      this.url = param1String3;
    }
    
    private void JC() {
      if (bF(this.versionName, this.message))
        return; 
      o.a(this.dIv).arn().setText(this.dIv.mActivity.getString(R.string.pos_upgrade_install));
      o.a(this.dIv).arn().setOnClickListener(new p(this));
      o.a(this.dIv).show();
    }
    
    private void JF() {
      if (bF(this.versionName, this.message))
        return; 
      o.a(this.dIv).arn().setText(this.dIv.mActivity.getString(R.string.pos_upgrade_download));
      o.a(this.dIv).arn().setOnClickListener(new q(this));
      o.a(this.dIv).show();
    }
    
    private boolean bF(String param1String1, String param1String2) {
      if (o.a(this.dIv) == null) {
        o.a(this.dIv, new r(this.dIv.mActivity, null));
        if (o.b(this.dIv) != 0.0D)
          o.a(this.dIv).aW(o.b(this.dIv)); 
        o.a(this.dIv).setTitle(this.dIv.mActivity.getString(R.string.od_updateBtnTxt));
        o.a(this.dIv).setCancelable(true);
      } 
      r r = o.a(this.dIv);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("V");
      stringBuilder.append(param1String1);
      stringBuilder.append(this.dIv.mActivity.getString(R.string.pos_upgrade_new_feature));
      stringBuilder.append("\n");
      stringBuilder.append(param1String2);
      r.s(stringBuilder.toString());
      return false;
    }
    
    public void run() {
      boolean bool;
      if (this.message == null)
        return; 
      if (n.S(this.dIv.mActivity))
        return; 
      if (RootApplication.getLaiqianPreferenceManager().avL() == 2) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool)
        n.bJ(this.dIv.mActivity); 
      if (this.url == null) {
        JC();
      } else {
        JF();
      } 
      if (bool)
        n.bK(this.dIv.mActivity); 
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */