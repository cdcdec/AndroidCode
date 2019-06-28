package com.laiqian.sync.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.milestone.h;
import com.laiqian.sync.a.e;
import com.laiqian.sync.a.g;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.bb;
import com.laiqian.util.bb;
import com.laiqian.util.bd;
import com.laiqian.util.z;
import com.umeng.analytics.MobclickAgent;
import java.util.Date;

public class SealData extends ActivityRoot {
  private LinearLayout aGN;
  
  private Button aGS;
  
  private String dpI = "T_ACCOUNTDOC,T_BPARTNER_CHARGEDOC,T_PRODUCTDOC";
  
  private String[] dpJ = null;
  
  private TextView dpK;
  
  private TextView dpL;
  
  private TextView dpM;
  
  private TextView dpN;
  
  private TextView dpO;
  
  private SeekBar dpP;
  
  private int dpQ = 0;
  
  private long dpR;
  
  private String dpS;
  
  private String dpT;
  
  private int dpU;
  
  private final String dpV = "yyyy-MM";
  
  private a dpW;
  
  private LinearLayout dpX;
  
  private LinearLayout dpY;
  
  private bb mWaitingDialog = null;
  
  private g syncManager;
  
  private void ZK() {
    IntentFilter intentFilter = new IntentFilter();
    this.dpW = new a(this, null);
    intentFilter.addAction("sSealDataSyncReceive");
    registerReceiver(this.dpW, intentFilter);
  }
  
  private void apP() {
    if (e.doo) {
      Toast.makeText(this, getString(2131629568), 0).show();
      return;
    } 
    kp(8);
    String str = this.dpM.getText().toString();
    bd.b(this, this.dpR, z.f(str, "yyyy-MM", 1), this.dpI);
  }
  
  private void gZ(boolean paramBoolean) {
    if (paramBoolean) {
      this.aGN.setVisibility(0);
      return;
    } 
    int i = this.dpU / 2;
    this.dpP.setMax(this.dpU);
    this.dpK.setText(this.dpS);
    this.dpL.setText(this.dpT);
    this.dpP.getViewTreeObserver().addOnGlobalLayoutListener(new d(this, i));
    this.aGN.setVisibility(8);
  }
  
  private void kp(int paramInt) {
    if (paramInt < 0) {
      if (paramInt != -2) {
        switch (paramInt) {
          case -4:
            Toast.makeText(this, getString(2131629567), 0).show();
            initData();
            bb.e("_Seal", "封账成功");
            break;
          case -5:
            Toast.makeText(this, getString(2131629562), 0).show();
            bb.e("_Seal", "删除失败，无法封账");
            break;
        } 
      } else {
        Toast.makeText(this, getString(2131629563), 0).show();
        bb.e("_Seal", "同步失败，无法封账");
      } 
      this.dpY.setVisibility(8);
      this.dpN.setVisibility(0);
      return;
    } 
    this.dpY.setVisibility(0);
    this.dpN.setVisibility(8);
    TextView textView = this.dpO;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("%");
    textView.setText(stringBuilder.toString());
  }
  
  private void kq(int paramInt) {
    if (this.dpQ <= 0)
      this.dpQ = this.dpP.getWidth() - 150; 
    String str = z.b(z.f(this.dpS, "yyyy-MM", paramInt), "yyyy-MM");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("滑动月份");
    stringBuilder.append(paramInt);
    stringBuilder.append("，值：");
    stringBuilder.append(str);
    bb.e("_Seal", stringBuilder.toString());
    this.dpM.setText(str);
    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)this.dpM.getLayoutParams();
    layoutParams.setMargins(this.dpQ * paramInt / this.dpU, 0, 0, 0);
    this.dpM.setLayoutParams(layoutParams);
  }
  
  public void initData() {
    this.syncManager = new g(this);
    this.syncManager.a(new e(this));
    xS().show();
    boolean bool2 = e.doo;
    boolean bool1 = false;
    if (bool2) {
      kp(Sync.dqi);
    } else {
      kp(0);
    } 
    if (this.dpJ == null)
      this.dpJ = this.dpI.split(","); 
    h h = new h(this);
    long l1 = h.q(this.dpJ);
    long l2 = h.r(this.dpJ);
    h.close();
    xS().cancel();
    if (l1 > 0L) {
      this.dpR = l1;
      this.dpS = z.b(this.dpR, "yyyy-MM");
      this.dpT = z.b(z.a(new Date(l2), "yyyy-MM", -1), "yyyy-MM");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("开始日期");
      stringBuilder.append(this.dpS);
      stringBuilder.append("，结束日期");
      stringBuilder.append(this.dpT);
      bb.e("_Seal", stringBuilder.toString());
      this.dpU = z.J(this.dpS, this.dpT, "yyyy-MM");
      stringBuilder = new StringBuilder();
      stringBuilder.append("间隔月份");
      stringBuilder.append(this.dpU);
      bb.e("_Seal", stringBuilder.toString());
      if (this.dpU < 2)
        bool1 = true; 
      gZ(bool1);
      return;
    } 
    gZ(true);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    MobclickAgent.onEvent(this, "SealData");
    requestWindowFeature(7);
    setContentView(2131428105);
    getWindow().setFeatureInt(7, 2131428168);
    yR();
    yP();
    ZK();
  }
  
  public void onDestroy() {
    if (this.dpW != null)
      unregisterReceiver(this.dpW); 
    super.onDestroy();
  }
  
  public void onResume() {
    super.onResume();
    initData();
  }
  
  public bb xS() {
    if (this.mWaitingDialog == null) {
      this.mWaitingDialog = new bb(this);
      this.mWaitingDialog.setCancelable(true);
    } 
    return this.mWaitingDialog;
  }
  
  public void yP() {
    this.dpX.setOnClickListener(new a(this));
    this.dpN.setOnClickListener(new b(this));
    this.dpP.setOnSeekBarChangeListener(new c(this));
  }
  
  public void yR() {
    this.aGN = (LinearLayout)findViewById(2131298974);
    this.dpY = (LinearLayout)findViewById(2131296286);
    this.dpX = (LinearLayout)findViewById(2131299878);
    this.aGS = (Button)findViewById(2131299879);
    this.dpP = (SeekBar)findViewById(2131298917);
    this.aGS.setVisibility(8);
    this.dpK = (TextView)findViewById(2131299430);
    this.dpL = (TextView)findViewById(2131299316);
    this.dpM = (TextView)findViewById(2131298918);
    this.dpN = (TextView)findViewById(2131296284);
    this.dpO = (TextView)findViewById(2131296285);
    ((TextView)findViewById(2131299889)).setText(getString(2131629906));
  }
  
  private class a extends BroadcastReceiver {
    private a(SealData this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) { SealData.a(this.dpZ, param1Intent.getIntExtra("sync", 999)); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sync\view\SealData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */