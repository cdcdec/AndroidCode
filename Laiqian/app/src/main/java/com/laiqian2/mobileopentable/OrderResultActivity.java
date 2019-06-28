package com.laiqian.mobileopentable;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.dcb.api.b.g;
import com.laiqian.dcb.api.b.j;
import com.laiqian.dcb.api.client.k;
import com.laiqian.opentable.R;
import com.laiqian.opentable.common.ah;
import com.laiqian.opentable.common.b;
import com.laiqian.ui.a.r;
import com.laiqian.ui.a.w;
import io.reactivex.g.a;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OrderResultActivity extends MobileActivityRoot {
  private View aZQ;
  
  View.OnClickListener azO = new c(this);
  
  private TextView bLV;
  
  private TextView bLW;
  
  private View bLX;
  
  private a bLY;
  
  private TextView bLZ;
  
  private ImageView bMa;
  
  ArrayList<Object> bMb;
  
  private String bMc = null;
  
  private int bMd = 1;
  
  ah bMe = new ah();
  
  boolean bMf = false;
  
  private g bMg;
  
  Handler bMh = new d(this);
  
  View.OnClickListener bMi = new e(this);
  
  private w bMj;
  
  private r bMk;
  
  private Handler uiHandler = new f(this);
  
  private void Em() {
    this.bLW.setVisibility(8);
    this.aZQ.setVisibility(0);
  }
  
  private void Ur() {
    Intent intent = new Intent();
    intent.setClass(this, PhoneOpenTableActivity.class);
    startActivity(intent);
    finish();
  }
  
  private void Us() {
    if (this.bMd == 1) {
      finish();
      return;
    } 
    if (this.bMd == 4) {
      setResult(-1);
      finish();
      return;
    } 
    finish();
  }
  
  private void Ut() {
    (new g(this)).close();
    a.aKg().r(new b(this));
  }
  
  private void Uv() {
    String str = "";
    int i = k.aPi;
    if (i != 4) {
      String str1;
      switch (i) {
        case 1:
          str = getString(R.string.pos_connected);
          this.bMa.setImageDrawable(getResources().getDrawable(R.drawable.click_order_able));
          Us();
          break;
        case 0:
          str1 = getString(R.string.pos_not_connected_t);
          this.bMa.setImageDrawable(getResources().getDrawable(R.drawable.click_order_enable));
          str = str1;
          if (b.XC()) {
            Uw();
            str = str1;
          } 
          break;
        case -1:
          str = getString(R.string.pos_connectting);
          this.bMa.setImageDrawable(getResources().getDrawable(R.drawable.click_order_enable));
          break;
      } 
    } else {
      str = getString(R.string.pos_account_does_not_match_t);
      this.bMa.setImageDrawable(getResources().getDrawable(R.drawable.click_order_notmatch));
    } 
    this.bLZ.setText(str);
  }
  
  private void Uw() {
    PrintStream printStream = System.out;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("弹出IPDialog");
    stringBuilder.append((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
    printStream.println(stringBuilder.toString());
    g g1 = new g(this);
    g1.oC();
    hideProgress();
    g1.close();
  }
  
  private void fY(int paramInt) {
    String str5;
    String str4;
    String str3;
    String str1 = "";
    String str2 = "";
    View.OnClickListener onClickListener = "";
    switch (paramInt) {
      case 4:
        str1 = getString(R.string.paying_done_notice);
        onClickListener = getString(R.string.paying_done_notice);
        str2 = getString(R.string.ui_titlebar_back);
        this.bMa.setImageDrawable(getResources().getDrawable(R.drawable.order_submit_success));
        a.aKh().r(new a(this));
        break;
      case 3:
        str3 = getString(R.string.billing);
        str4 = getString(R.string.connection_failure);
        str5 = getString(R.string.click_refresh);
        this.bMa.setImageDrawable(getResources().getDrawable(R.drawable.order_submit_fail));
        str1 = str4;
        str2 = str5;
        onClickListener = str3;
        if (b.XC()) {
          Uw();
          str1 = str4;
          str2 = str5;
          onClickListener = str3;
        } 
        break;
      case 2:
        onClickListener = getString(R.string.edit_menu_failure);
        str1 = getString(R.string.connection_failure);
        str2 = getString(R.string.click_refresh);
        this.bMa.setImageDrawable(getResources().getDrawable(R.drawable.order_submit_fail));
        break;
      case 1:
        str1 = getString(R.string.billing_success);
        str2 = getString(R.string.ui_titlebar_back);
        this.bMa.setImageDrawable(getResources().getDrawable(R.drawable.order_submit_success));
        onClickListener = str1;
        break;
    } 
    this.bLV.setText(onClickListener);
    View view = this.bLX;
    if (paramInt == 3 || paramInt == 2) {
      View.OnClickListener onClickListener1 = this.bMi;
    } else {
      onClickListener = this.azO;
    } 
    view.setOnClickListener(onClickListener);
    this.bLW.setText(str2);
    this.bLZ.setText(str1);
  }
  
  private void hideProgress() {
    this.bLW.setVisibility(0);
    this.aZQ.setVisibility(8);
  }
  
  public void Uu() {
    if (this.bMk == null)
      this.bMk = new r(this, new h(this)); 
    this.bMk.s(getString(R.string.your_account_in_another_mobile_phone));
    this.bMk.t(getString(R.string.pos_re_login));
    this.bMk.show();
  }
  
  public void initData() {
    try {
      Intent intent = getIntent();
      if (intent.hasExtra("sProductResultData"))
        this.bMb = (ArrayList)intent.getSerializableExtra("sProductResultData"); 
      if (intent.hasExtra("sProductResult"))
        this.bMd = intent.getIntExtra("sProductResult", 1); 
      if (intent.hasExtra("sProductResultDataID"))
        this.bMc = intent.getStringExtra("sProductResultDataID"); 
      fY(this.bMd);
      return;
    } catch (Exception exception) {
      a.e(exception);
      return;
    } 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(R.layout.ordertool_result);
    yR();
    yP();
    this.bMg = new g(this);
  }
  
  public void onDestroy() {
    if (this.bLY != null)
      unregisterReceiver(this.bLY); 
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4 && paramKeyEvent.getRepeatCount() == 0) {
      Us();
      return true;
    } 
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onResume() {
    initData();
    super.onResume();
  }
  
  public void s(String[] paramArrayOfString) {
    if (t.Uz())
      return; 
    if (this.bMj == null) {
      this.bMj = new w(this);
      g g1 = new g(this, paramArrayOfString);
      this.bMj.a(g1);
    } 
    this.bMj.C(paramArrayOfString);
    this.bMj.gn(0);
    this.bMj.setCancelable(false);
    this.bMj.show();
  }
  
  public void yP() { findViewById(R.id.ui_titlebar_left).setOnClickListener(this.azO); }
  
  public void yR() {
    this.bMg = new g(this);
    if (this.bLY == null) {
      this.bLY = new a(this);
      j.a(this, this.bLY, 2004);
    } 
    this.aZQ = findViewById(R.id.ivProgress);
    this.bLX = findViewById(R.id.rl_order_submit);
    this.bLV = (TextView)findViewById(R.id.ui_titlebar_txt);
    this.bLW = (TextView)findViewById(R.id.order_submit);
    this.bMa = (ImageView)findViewById(R.id.btn_click_order_icon);
    this.bLZ = (TextView)findViewById(R.id.btn_click_order_text);
  }
  
  class a extends BroadcastReceiver {
    a(OrderResultActivity this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      int i = param1Intent.getIntExtra("isSuccess", -1);
      int j = param1Intent.getIntExtra("method", 0);
      if (j == 1005) {
        OrderResultActivity.e(this.bMm);
        this.bMm.bMe.eD(true);
        this.bMm.bMe.XV();
        if (i == 2) {
          ArrayList arrayList = (ArrayList)param1Intent.getSerializableExtra("data");
          this.bMm.s((String[])arrayList.toArray(new String[arrayList.size()]));
          return;
        } 
        if (i == 3) {
          this.bMm.Uu();
          return;
        } 
        OrderResultActivity.g(this.bMm);
        return;
      } 
      if (j == 2002) {
        if (i == -1) {
          OrderResultActivity.a(this.bMm, 1);
          return;
        } 
        if (i == -2)
          return; 
        if (i == -3) {
          this.bMm.finish();
          return;
        } 
      } else if (j == 2007) {
        if (i == -1) {
          OrderResultActivity.a(this.bMm, 1);
          OrderResultActivity.h(this.bMm);
          return;
        } 
        if (i == -2)
          return; 
        if (i == -3)
          this.bMm.finish(); 
      } 
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\mobileopentable\OrderResultActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */