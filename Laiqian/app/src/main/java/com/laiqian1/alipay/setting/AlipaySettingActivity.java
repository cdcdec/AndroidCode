package com.laiqian.alipay.setting;

import android.os.Bundle;
import android.widget.RelativeLayout;
import com.laiqian.payment.R;
import com.laiqian.ui.container.AbstractActivity;

public class AlipaySettingActivity extends AbstractActivity implements c {
  private b aCe = new b(R.id.linerlayout_alipay_content);
  
  private a aCf = new a(this, this);
  
  private void setListeners() {}
  
  private void wR() {
    ((RelativeLayout)this.aCe.aCu.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle);
    a(this.aCe.aCu.aCv, getString(R.string.pos_pay_type_alipay_barcode));
  }
  
  public void bu(boolean paramBoolean) {}
  
  public void bv(boolean paramBoolean) {}
  
  public void bw(boolean paramBoolean) {}
  
  public void bx(boolean paramBoolean) {}
  
  public void by(boolean paramBoolean) {}
  
  public void bz(boolean paramBoolean) {}
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(b.aCt);
    getWindow().setFeatureInt(7, R.layout.pos_title);
    setTitleTextViewHideRightView(R.string.mainmenu_alipay_setting);
    this.aCe.S(findViewById(this.aCe.getId()));
    wR();
    setListeners();
    this.aCf.initData();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\alipay\setting\AlipaySettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */