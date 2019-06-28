package com.laiqian.member.setting.sms;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.text.SpannableString;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.member.setting.sms.a.a;
import com.laiqian.member.setting.sms.b.a;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.container.LayoutLeftTextRightLabelWithAddButton;
import com.laiqian.util.av;
import com.laiqian.util.by;
import com.laiqian.vip.R;
import java.util.ArrayList;
import java.util.List;

public class BuySmsActivity extends ActivityRoot {
  public TextView bFZ;
  
  public TextView[] bGa = new TextView[5];
  
  public TextView[] bGb = new TextView[5];
  
  public LinearLayout[] bGc = new LinearLayout[5];
  
  public int bGd;
  
  public ArrayList<j> bGe = new ArrayList();
  
  public c bGf;
  
  private SmsReceiver bGg;
  
  GridLayout bGh;
  
  private LayoutLeftTextRightLabelWithAddButton bGi;
  
  private List<a> bGj;
  
  private Double bGk;
  
  private Double bGl = (this.bGk = Double.valueOf(0.0D)).valueOf(0.0D);
  
  public TextView bwu;
  
  private void Lk() {
    if (this.bGg == null)
      this.bGg = new SmsReceiver(this); 
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("SMS_CHARGE_RECEIVER");
    registerReceiver(this.bGg, intentFilter);
  }
  
  private void Ll() {
    try {
      unregisterReceiver(this.bGg);
      return;
    } catch (Exception exception) {
      a.e(exception);
      return;
    } 
  }
  
  @TargetApi(21)
  private void RY() {
    null = (new av(this)).Ea();
    this.bwu.setText(null);
    null = getResources().getString(R.string.vip_sms_quantity_left);
    int i = this.bGd;
    byte b = 0;
    null = by.b(String.format(null, new Object[] { Integer.valueOf(i) }), String.valueOf(this.bGd), 18, getResources().getColor(R.color.red_color_10500));
    this.bFZ.setText(null);
    a a = new a();
    this.bGj = new ArrayList();
    List list = a.SU();
    while (b < Math.min(this.bGh.getChildCount(), list.size())) {
      a a1 = new a(this.bGh.getChildAt(b), this);
      a1.f(list, b);
      a1.setOnClickListener(new a(this, a.SU(), b));
      b++;
    } 
  }
  
  private void SK() {
    this.bGh = (GridLayout)findViewById(R.id.gv_package);
    this.bwu = (TextView)findViewById(R.id.tv_phone);
    findViewById(R.id.ll_phone).setBackgroundResource(R.drawable.shape_rounded_rectangle_up_click);
    this.bFZ = (TextView)findViewById(R.id.tv_sms_quantity_left);
    findViewById(R.id.ll_sms).setBackgroundResource(R.drawable.shape_rounded_rectangle_unupdown_click);
    this.bGi = (LayoutLeftTextRightLabelWithAddButton)findViewById(R.id.btn_add_coupon);
    this.bGi.a(new a(this));
  }
  
  public void h(Double paramDouble) { this.bGk = paramDouble; }
  
  public void i(Double paramDouble) { this.bGl = paramDouble; }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(R.layout.activity_buy_sms);
    getWindow().setFeatureInt(7, R.layout.ui_titlebar);
    Lk();
    this.bGd = getIntent().getIntExtra("SMS_QUANTITY_LEFT", 0);
    ((TextView)findViewById(R.id.ui_titlebar_txt)).setText(R.string.vip_buy_sms);
    findViewById(R.id.ui_titlebar_help_btn).setVisibility(8);
    SK();
    RY();
  }
  
  protected void onDestroy() {
    super.onDestroy();
    Ll();
  }
  
  public class SmsReceiver extends BroadcastReceiver {
    public SmsReceiver(BuySmsActivity this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      int i = param1Intent.getIntExtra("SMS_QUANTITY_LEFT", 0);
      SpannableString spannableString = by.b(String.format(this.bGm.getResources().getString(R.string.vip_sms_quantity_left), new Object[] { Integer.valueOf(i) }), String.valueOf(i), 18, this.bGm.getResources().getColor(R.color.red_color_10500));
      this.bGm.bFZ.setText(spannableString);
      if (this.bGm.bGf != null && this.bGm.bGf.isShowing())
        this.bGm.bGf.dismiss(); 
      BuySmsActivity.a(this.bGm).aqV();
    }
  }
  
  private class a implements View.OnClickListener {
    int index;
    
    private List<j> list;
    
    public a(BuySmsActivity this$0, List<j> param1List, int param1Int) {
      this.list = param1List;
      this.index = param1Int;
    }
    
    public void onClick(View param1View) {
      if (((j)this.list.get(this.index)).price < BuySmsActivity.b(this.bGm).doubleValue()) {
        RootApplication rootApplication;
        String str = (rootApplication = RootApplication.zv()).zv().getString(R.string.min_coupon_amount);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(BuySmsActivity.b(this.bGm));
        stringBuilder.append("");
        Toast.makeText(rootApplication, String.format(str, new Object[] { stringBuilder.toString() }), 0).show();
        return;
      } 
      this.bGm.bGf = new c(this.bGm.getActivity(), String.valueOf(((j)this.list.get(this.index)).price), String.valueOf(((j)this.list.get(this.index)).quantity), String.valueOf(BuySmsActivity.c(this.bGm)));
      this.bGm.bGf.setCanceledOnTouchOutside(false);
      this.bGm.bGf.show();
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\sms\BuySmsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */