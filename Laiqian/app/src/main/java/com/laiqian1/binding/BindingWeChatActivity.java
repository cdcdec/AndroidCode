package com.laiqian.binding;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import com.laiqian.basic.RootApplication;
import com.laiqian.pos.dw;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.bb;
import com.laiqian.wallet.R;

public class BindingWeChatActivity extends ActivityRoot implements k {
  private ImageView aJj;
  
  private bb waitingDialog;
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(R.layout.bing_wechat_activity);
    setTitleTextView(R.string.pos_paytype_binding_wechar_title);
    this.aJj = (ImageView)findViewById(R.id.iv_qrcode);
    zN();
  }
  
  public void q(Drawable paramDrawable) { this.aJj.setImageDrawable(paramDrawable); }
  
  public void zN() {
    g g = new g(this, this);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(RootUrlParameter.cmp);
    stringBuilder.append("?shop_id=");
    stringBuilder.append(RootApplication.getLaiqianPreferenceManager().Tx());
    g.execute(new String[] { stringBuilder.toString(), dw.aR(this) });
  }
  
  public void zO() {
    if (this.waitingDialog != null)
      this.waitingDialog.dismiss(); 
  }
  
  public boolean zP() { return true; }
  
  public void zQ() {
    if (this.waitingDialog == null) {
      this.waitingDialog = new bb(this);
      this.waitingDialog.setCancelable(true);
    } 
    this.waitingDialog.show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\binding\BindingWeChatActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */