package com.laiqian.print.cardreader;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.laiqian.print.o;
import com.laiqian.print.type.usb.a;
import com.laiqian.ui.a.w;
import com.laiqian.ui.container.AbstractActivity;

public class CardReaderEditActivity extends AbstractActivity implements aj {
  private BroadcastReceiver cDk = new d(this);
  
  private a cEn = new a(2131296798);
  
  private o cEo = new o(this, this);
  
  private void afb() {
    String str = getString(2131624596);
    m m = new m(this);
    w w = new w(this, new String[] { str }, m);
    w.setTitle(getString(2131627443));
    w.show();
  }
  
  private void afc() { this.cEo.delete(); }
  
  private void afd() {
    ai ai = this.cEo.afl();
    if (ai != null && ai.getCode() == 2) {
      afe();
      return;
    } 
    this.cEo.afi();
  }
  
  private void afe() { (new q(this)).show(); }
  
  private void aff() {
    if (!this.cEo.isConnected())
      this.cEo.connect(); 
  }
  
  private void setListeners() {
    ((RelativeLayout)this.cEn.getView()).setOnClickListener(new h(this));
    ((ViewGroup)this.cEn.cMe.getView()).setOnClickListener(new i(this));
    ((ViewGroup)this.cEn.cLZ.getView()).setOnClickListener(new j(this));
    ((Button)this.cEn.cMh.dwK.dwM.getView()).setOnClickListener(new k(this));
    ((Button)this.cEn.cMh.dwK.cNc.getView()).setOnClickListener(new l(this));
  }
  
  private void wR() {
    ((TextView)findViewById(2131299889)).setText(2131624594);
    findViewById(2131299879).setVisibility(8);
    findViewById(2131299878).setOnClickListener(new g(this));
    ((ViewGroup)this.cEn.cLZ.getView()).setBackgroundResource(2130772052);
    ((ViewGroup)this.cEn.cMa.getView()).setBackgroundResource(2130772056);
    ((ViewGroup)this.cEn.cMe.getView()).setBackgroundResource(2130772051);
    ((RelativeLayout)this.cEn.cMc.getView()).setVisibility(8);
    ((RelativeLayout)this.cEn.cMb.getView()).setVisibility(8);
    ((RelativeLayout)this.cEn.cMg.getView()).setVisibility(8);
    a(this.cEn.cLZ.cAO, getString(2131624595));
    a(this.cEn.cMa.cAO, getString(2131624592));
    a(this.cEn.cMe.cAO, getString(2131624590));
    a(this.cEn.cMh.dwK.cNc, getString(2131624591));
    ((TextView)this.cEn.cMe.cAP.getView()).setTextColor(getResources().getColorStateList(2131099682));
  }
  
  public void afg() { i(new f(this)); }
  
  public void b(ai paramai) { ((TextView)this.cEn.cLZ.cAP.getView()).setText(o.a(paramai)); }
  
  public void exit() { finish(); }
  
  public void fx(boolean paramBoolean) { i(new n(this, paramBoolean)); }
  
  public void kY(String paramString) { i(new e(this, paramString)); }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131427437);
    getWindow().setFeatureInt(7, 2131428168);
    this.cEn.S(findViewById(this.cEn.getId()));
    wR();
    setListeners();
    ah ah = (ah)getIntent().getSerializableExtra("selection");
    this.cEo.a(ah);
  }
  
  protected void onStart() {
    super.onStart();
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("com.laiqian.print.ACTION_USB_DEVICE_ATTACHED");
    intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
    intentFilter.addAction("com.laiqian.USB_PERMISSION");
    registerReceiver(this.cDk, intentFilter);
  }
  
  protected void onStop() {
    try {
      unregisterReceiver(this.cDk);
    } catch (Exception exception) {}
    super.onStop();
  }
  
  public void setMode(int paramInt) {
    ((TextView)this.cEn.cMe.cAP.getView()).setEnabled(false);
    ((EditText)this.cEn.cMa.dwQ.getView()).setEnabled(false);
  }
  
  public void setName(String paramString) {}
  
  public void setType(int paramInt) { ((EditText)this.cEn.cMa.dwQ.getView()).setText(o.hy(paramInt)); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\cardreader\CardReaderEditActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */