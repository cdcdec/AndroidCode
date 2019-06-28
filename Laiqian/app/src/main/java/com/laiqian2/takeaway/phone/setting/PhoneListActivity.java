package com.laiqian.takeaway.phone.setting;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.member.cb;
import com.laiqian.models.l;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.ui.listview.FormListView;
import com.laiqian.ui.listview.e;
import com.laiqian.util.ck;

public class PhoneListActivity extends ActivityRoot {
  ProgressBarCircularIndeterminate aNv;
  
  private e bqq;
  
  private View bud;
  
  AdapterView.OnItemClickListener but = new m(this);
  
  private cb bvf;
  
  private LinearLayout bvg;
  
  FormListView duR;
  
  private TextView duS;
  
  FormListView.b duT = new j(this);
  
  private void Pz() {
    Log.e("setupListViewItem", "setupListViewItem");
    this.aNv.setVisibility(0);
    l l = new l(this);
    String str = l.hk("sContactMobilePhone");
    String[] arrayOfString = l.hl(this.bvf.Qy());
    this.duR.initData();
    if (ck.mk(this.duR.getList().size())) {
      this.bud.setVisibility(8);
    } else {
      this.bud.setVisibility(0);
    } 
    if (this.bqq == null) {
      this.bqq = new l(this, this, this.duR.getList(), this.duR);
    } else {
      this.bqq.m(this.duR.getList());
    } 
    this.duR.setAdapter(this.bqq);
    this.duR.setData(this, str, arrayOfString, new String[] { 
          "sContactMobilePhone", "nSpareField5", "sField2", "sAddress", "sField3", "sName", "count", "amount", "sBPartnerTypeName", "sSpareField1", 
          "fAmount" });
    l.close();
  }
  
  private void Qi() {
    LinearLayout linearLayout = (LinearLayout)LayoutInflater.from(this).inflate(2131428054, null);
    this.duR.setHead(linearLayout);
  }
  
  private void initView() {
    this.duR = (FormListView)findViewById(2131298086);
    this.duS = (TextView)findViewById(2131299356);
    this.bvg = (LinearLayout)findViewById(2131297889);
    this.bud = findViewById(2131297047);
    this.aNv = (ProgressBarCircularIndeterminate)findViewById(2131298615);
  }
  
  private void xa() {
    CrashApplication.getLaiqianPreferenceManager().Wq();
    this.duR.setOnAfterLoadListener(new k(this));
    this.duR.setOnItemClickListener(this.but);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131427433);
    getWindow().setFeatureInt(7, 2131428156);
    initView();
    xa();
    this.bvf = new cb();
    Qi();
  }
  
  protected void onDestroy() { super.onDestroy(); }
  
  protected void onPause() {
    super.onPause();
    this.duR.closeDB();
  }
  
  protected void onResume() {
    super.onResume();
    Pz();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
      Pz(); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\phone\setting\PhoneListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */