package com.laiqian.version.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.f.b;
import com.laiqian.infrastructure.R;
import com.laiqian.network.service.a;
import com.laiqian.pos.industry.a;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.listview.ScalableListView;
import com.laiqian.util.au;
import com.laiqian.util.av;
import com.laiqian.util.bb;
import com.laiqian.util.bd;
import com.laiqian.util.bh;
import com.laiqian.util.by;
import com.laiqian.util.ch;
import io.reactivex.g.a;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class LegacyUpgradeAndEvaluate extends ActivityRoot {
  Handler aIy = new i(this);
  
  View.OnClickListener aXN = new h(this);
  
  String aXP;
  
  String aXQ;
  
  Handler aXR = new j(this);
  
  View.OnClickListener aXS = new f(this);
  
  private View azH;
  
  View.OnClickListener azO = new c(this);
  
  private ScrollView bxr;
  
  private Button dHS;
  
  private LinearLayout dHT;
  
  private TextView dHU;
  
  private String dHY;
  
  private ArrayList<HashMap<String, String>> dIa;
  
  private TextView dIb;
  
  private ScalableListView dIc;
  
  private LinearLayout dId;
  
  private String dIe;
  
  String dIf;
  
  String dIg;
  
  private boolean dIi = false;
  
  View.OnClickListener dIj = new e(this);
  
  View.OnClickListener dIk = new g(this);
  
  Handler dIl = new k(this);
  
  Handler dIm = new l(this);
  
  Handler dIn = new d(this);
  
  a dJY;
  
  private boolean debug = true;
  
  int progress;
  
  private void JH() { a.aKh().r(new b(this)); }
  
  private void awW() {
    if (!bd.bH(this)) {
      if (ch.cb(this)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ch.cf(this));
        stringBuilder.append("");
        this.dIe = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(ch.cd(this));
        stringBuilder.append("");
        this.dIf = ch.H(this, stringBuilder.toString());
        awX();
        return;
      } 
      Toast.makeText(this, getString(R.string.pos_upgrade_network_err), 0).show();
      return;
    } 
    this.dHS.setVisibility(8);
    this.dHT.setVisibility(0);
    JH();
  }
  
  private void awX() {
    Message message = new Message();
    message.what = 5;
    this.dIl.sendMessage(message);
  }
  
  private void awY() {
    Message message = new Message();
    message.what = 1;
    this.dIl.sendMessage(message);
  }
  
  private void bE(String paramString1, String paramString2) {
    if (!this.dIi) {
      LinearLayout linearLayout = (LinearLayout)LayoutInflater.from(this).inflate(R.layout.pos_upgrade_listview_head, null);
      TextView textView = (TextView)linearLayout.findViewById(R.id.tvNewVersionName);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("V");
      stringBuilder.append(paramString2);
      stringBuilder.append(getString(R.string.pos_upgrade_new_feature));
      textView.setText(stringBuilder.toString());
      if (this.dIc != null)
        this.dIc.addHeaderView(linearLayout); 
      this.dIi = true;
    } 
    if (paramString1 != null) {
      null = paramString1.split("\n");
      ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.pos_upgrade_new_function_list_item, R.id.tvNewFunction, null);
      if (this.dIc != null)
        this.dIc.setAdapter(arrayAdapter); 
    } 
  }
  
  private void initData() {
    this.dHY = ch.ch(this);
    if (this.dHY != null) {
      this.dIa = (ArrayList)(new av(this)).qR(this.dHY);
      if (this.dIa != null && !"null".equals(this.dIa)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("currentVersionList=");
        stringBuilder.append(this.dIa);
        bb.ao(stringBuilder.toString());
        new b(this, this, this.dIa);
      } 
    } 
    ArrayList arrayList = ch.cj(this);
    if (arrayList != null)
      for (byte b = 0; b < arrayList.size(); b++) {
        HashMap hashMap = (HashMap)arrayList.get(b);
        LinearLayout linearLayout = (LinearLayout)LayoutInflater.from(this).inflate(R.layout.pos_upgrade_history_version, null);
        TextView textView = (TextView)linearLayout.findViewById(R.id.tvNewVersionName);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("V");
        stringBuilder2.append((String)hashMap.get("version"));
        stringBuilder2.append(getString(R.string.pos_upgrade_new_feature));
        textView.setText(stringBuilder2.toString());
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("hmVersionInfo=");
        stringBuilder1.append((String)hashMap.get("feature"));
        bb.ao(stringBuilder1.toString());
        String[] arrayOfString = ((String)hashMap.get("feature")).split("\n");
        ((ScalableListView)linearLayout.findViewById(R.id.lvHistoryVersion)).setAdapter(new ArrayAdapter(this, R.layout.pos_upgrade_new_function_list_item, R.id.tvNewFunction, arrayOfString));
      }  
  }
  
  private void wZ() {
    this.azH = findViewById(R.id.ui_titlebar_back_btn);
    this.azH.setOnClickListener(this.azO);
    ((Button)findViewById(R.id.ui_titlebar_help_btn)).setVisibility(8);
    ((TextView)findViewById(R.id.ui_titlebar_txt)).setText(getString(R.string.pos_upgrade_and_evaluate));
    this.dHS = (Button)findViewById(R.id.btnCheck);
    this.dHT = (LinearLayout)findViewById(R.id.llSearchNewVersion);
    this.bxr = (ScrollView)findViewById(R.id.scrollView);
    this.bxr.smoothScrollTo(0, 0);
    this.dIb = (TextView)findViewById(R.id.tvNewVersionName);
    this.dHU = (TextView)findViewById(R.id.tvNewVersionSize);
    this.dIc = (ScalableListView)findViewById(R.id.lvNewVersion);
    this.dId = (LinearLayout)findViewById(R.id.ll_new_version);
  }
  
  private void xa() { this.dHS.setOnClickListener(this.dIj); }
  
  public abstract int axn();
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(axn());
    getWindow().setFeatureInt(7, R.layout.ui_titlebar);
    wZ();
    xa();
    initData();
    this.dJY = new a(this, null);
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("android.intent.action.DOWNLOAD_RECEIVER");
    registerReceiver(this.dJY, intentFilter);
  }
  
  public void onDestroy() {
    bb.e("Activity", "Activity关闭了");
    if (!bd.bH(this)) {
      Intent intent = new Intent();
      intent.setAction("android.intent.action.CloseDownloadService");
      sendBroadcast(intent);
    } 
    if (this.dJY != null)
      unregisterReceiver(this.dJY); 
    super.onDestroy();
  }
  
  public void onResume() {
    if (!ch.L(this, "com.laiqian.network.service.DownloadApkService")) {
      a.close();
      this.dHT.setVisibility(8);
      this.dHS.setVisibility(0);
    } else {
      this.dIf = ch.H(this, ch.cg(this));
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(ch.cg(this));
      stringBuilder.append("");
      this.dIe = stringBuilder.toString();
      Message message = new Message();
      message.what = 3;
      this.dIl.sendMessage(message);
    } 
    super.onResume();
  }
  
  private class a extends BroadcastReceiver {
    private a(LegacyUpgradeAndEvaluate this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      Bundle bundle = param1Intent.getExtras();
      this.dKa.progress = bundle.getInt("progress");
      bundle.getBoolean("sDownloadStatus");
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Activity中的进度");
      stringBuilder1.append(this.dKa.progress);
      stringBuilder1.append("%");
      bb.ao(stringBuilder1.toString());
      if (this.dKa.progress == 100) {
        Message message = new Message();
        message.obj = "1";
        this.dKa.dIm.sendMessage(message);
        return;
      } 
      TextView textView = LegacyUpgradeAndEvaluate.a(this.dKa);
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("(");
      stringBuilder2.append(this.dKa.getString(R.string.pos_downloading));
      stringBuilder2.append(this.dKa.progress);
      stringBuilder2.append("%)");
      textView.setText(stringBuilder2.toString());
    }
  }
  
  class b extends BaseAdapter {
    private Context c;
    
    private List<HashMap<String, String>> dwq;
    
    public b(LegacyUpgradeAndEvaluate this$0, Context param1Context, ArrayList<HashMap<String, String>> param1ArrayList) {
      this.c = param1Context;
      this.dwq = param1ArrayList;
    }
    
    public int getCount() { return this.dwq.size(); }
    
    public Object getItem(int param1Int) { return this.dwq.get(param1Int); }
    
    public long getItemId(int param1Int) { return param1Int; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      param1View = LayoutInflater.from(this.c).inflate(R.layout.pos_upgrade_new_function_list_item, null);
      TextView textView = (TextView)param1View.findViewById(R.id.tvNewFunction);
      Button button1 = (Button)param1View.findViewById(R.id.btnGood);
      Button button2 = (Button)param1View.findViewById(R.id.btnBad);
      button1.setVisibility(0);
      button2.setVisibility(0);
      button2.setOnClickListener(new m(this, button2, button1, param1Int));
      button1.setOnClickListener(new n(this, button2, button1, param1Int));
      textView.setText((CharSequence)((HashMap)this.dwq.get(param1Int)).get("feature"));
      String str = (String)((HashMap)this.dwq.get(param1Int)).get("evaluate");
      if ("GOOD".equals(str)) {
        button2.setText(R.string.pos_upgrade_bad_evaluate);
        button2.setTextColor(this.dKa.getResources().getColor(R.color.black));
        button1.setText(R.string.pos_upgrade_ever_good_evaluate);
        button1.setTextColor(this.dKa.getResources().getColor(R.color.member_list_item_min));
        button1.setClickable(false);
        button2.setClickable(true);
        return param1View;
      } 
      if ("BAD".equals(str)) {
        button2.setText(R.string.pos_upgrade_ever_bad_evaluate);
        button2.setTextColor(this.dKa.getResources().getColor(R.color.member_list_item_min));
        button1.setText(R.string.pos_upgrade_good_evaluate);
        button1.setTextColor(this.dKa.getResources().getColor(R.color.black));
        button1.setClickable(true);
        button2.setClickable(false);
      } 
      return param1View;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\view\LegacyUpgradeAndEvaluate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */