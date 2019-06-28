package com.laiqian.backup;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.ui.a.m;
import com.laiqian.ui.a.p;
import com.laiqian.ui.a.r;
import com.laiqian.util.am;
import com.laiqian.util.av;
import com.laiqian.util.bb;
import com.laiqian.util.bd;
import com.laiqian.util.n;
import com.laiqian.util.z;
import java.util.ArrayList;
import java.util.HashMap;

public class BackUpRootActivity extends ActivityRoot {
  protected static ArrayList<HashMap<String, Object>> aGD;
  
  r aCz = null;
  
  View.OnClickListener aDd = new b(this);
  
  a aGE = null;
  
  protected TextView aGF;
  
  protected TextView aGG;
  
  protected TextView aGH;
  
  protected ArrayList<HashMap<String, String>> aGI = null;
  
  protected Spinner aGJ;
  
  protected String aGK = "";
  
  protected String aGL = "laiqian";
  
  protected ListView aGM;
  
  private LinearLayout aGN;
  
  protected int aGO = 0;
  
  protected int aGP = 1;
  
  protected int aGQ = 2;
  
  TextView aGR;
  
  Button aGS;
  
  int aGT = 0;
  
  private Dialog aGU;
  
  private String aGV;
  
  private ProgressBarCircularIndeterminate aGW;
  
  String aGX = "upTag";
  
  String aGY = "downTag";
  
  String aGZ = "roundTag";
  
  String aHa = "Tag";
  
  String aHb = "startTag";
  
  AdapterView.OnItemClickListener aHc = new c(this);
  
  private final int aHd = 1;
  
  Handler aHe = new g(this);
  
  String aHf = null;
  
  String aHg = null;
  
  private m aHh;
  
  private HashMap<String, Object> aHi;
  
  private p aHj;
  
  ProgressDialog aHk = null;
  
  Handler aHl = new h(this);
  
  Handler aHm = new i(this);
  
  View.OnClickListener aHn = new k(this);
  
  Handler aHo = new l(this);
  
  View.OnClickListener aHp = new n(this);
  
  private BroadcastReceiver aqG;
  
  View.OnClickListener azO = new j(this);
  
  static  {
  
  }
  
  private ArrayList<HashMap<String, Object>> a(ArrayList<HashMap<String, Object>> paramArrayList, String paramString) {
    if (paramArrayList != null) {
      int i = paramArrayList.size();
      if (i > 0) {
        ((HashMap)paramArrayList.get(0)).put(this.aHb, paramString);
        if (i == 1) {
          ((HashMap)paramArrayList.get(0)).put(this.aHa, this.aGZ);
          return paramArrayList;
        } 
        if (i > 1) {
          ((HashMap)paramArrayList.get(0)).put(this.aHa, this.aGX);
          ((HashMap)paramArrayList.get(i - 1)).put(this.aHa, this.aGY);
        } 
      } 
    } 
    return paramArrayList;
  }
  
  private boolean bB(String paramString) {
    bb.e("mulu", paramString);
    if (aGD != null) {
      aGD.clear();
      aGD = null;
    } 
    am.bj("777", paramString);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("/");
    stringBuilder.append(this.aGL);
    String str = stringBuilder.toString();
    ag.x(str, ".temp");
    if (!getString(2131624364).equals(this.aGL)) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramString);
      stringBuilder1.append("/");
      stringBuilder1.append(getString(2131624364));
      paramString = stringBuilder1.toString();
      ag.x(paramString, ".temp");
      ArrayList arrayList1 = a(ag.a(paramString, ".lq", true), paramString);
      if (arrayList1 != null)
        aGD = arrayList1; 
    } 
    if (aGD == null)
      aGD = new ArrayList(); 
    ArrayList arrayList = a(ag.a(str, ".lq", true), str);
    if (arrayList != null)
      aGD.addAll(arrayList); 
    return (aGD != null);
  }
  
  private void bC(String paramString) {
    this.aHi.put("text", paramString);
    this.aHj.notifyDataSetChanged();
  }
  
  private void bC(boolean paramBoolean) {
    if (this.aHj != null) {
      String str;
      if (paramBoolean) {
        str = "";
      } else {
        str = getString(2131626485);
      } 
      bC(str);
    } 
  }
  
  private void e(String paramString, boolean paramBoolean) {
    this.aGN.setVisibility(0);
    this.aGH.setText(paramString);
    this.aGM.setVisibility(8);
    if (paramBoolean) {
      this.aGS.setVisibility(0);
      this.aGF.setVisibility(0);
      this.aGG.setVisibility(8);
      return;
    } 
    this.aGS.setVisibility(8);
    this.aGF.setVisibility(8);
    this.aGG.setVisibility(0);
  }
  
  private void initData() {
    if (this.aGO == this.aGP) {
      this.aGS.setText(2131624387);
      this.aGF.setVisibility(0);
      this.aGR.setText(2131624388);
      this.aGS.setVisibility(0);
      if (ag.za()) {
        this.aGK = ag.yX();
        yS();
        return;
      } 
      Toast.makeText(this, 2131624394, 1).show();
      finish();
      return;
    } 
    this.aGS.setText(2131624390);
    this.aGR.setText(2131624391);
    this.aGS.setVisibility(8);
    this.aGI = new ArrayList();
    this.aGI = ag.yZ();
    int i = this.aGI.size();
    if (i > 0) {
      this.aGM.setVisibility(0);
      this.aGF.setVisibility(0);
      this.aGG.setVisibility(8);
      this.aGN.setVisibility(8);
      this.aGK = (String)((HashMap)this.aGI.get(0)).get("path");
      if (i == 1) {
        this.aGJ.setVisibility(8);
      } else {
        this.aGJ.setVisibility(0);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, 17367048, ag.b(this.aGI, "name"));
        arrayAdapter.setDropDownViewResource(17367049);
        this.aGJ.setPrompt(getString(2131624402));
        this.aGJ.setAdapter(arrayAdapter);
        if (this.aGT != 0 && this.aGT < i)
          this.aGJ.setSelection(this.aGT); 
      } 
      yS();
      this.aGS.setVisibility(0);
      return;
    } 
    this.aGS.setVisibility(8);
    e(getString(2131624384), false);
  }
  
  private void yS() {
    bB(this.aGK);
    if (aGD == null)
      return; 
    if (aGD.size() == 0) {
      e(getString(2131624383), true);
    } else {
      this.aGM.setVisibility(0);
      this.aGN.setVisibility(8);
    } 
    if (this.aGE == null) {
      this.aGE = new a(this);
      this.aGM.setAdapter(this.aGE);
    } 
    this.aGE.notifyDataSetChanged();
  }
  
  private void yT() {
    r r1 = new r(this, 3, null);
    r1.setTitle(getString(2131624348));
    r1.s(getString(2131624346));
    r1.pa(getString(2131624347));
    if (!isFinishing()) {
      r1.show();
      return;
    } 
    n.o(getString(2131624346));
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 9) {
      setRequestedOrientation(6);
    } else {
      setRequestedOrientation(0);
    } 
    requestWindowFeature(7);
    setContentView(2131427474);
    getWindow().setFeatureInt(7, 2131428168);
    this.aqG = new NetworkConnectChangedReceiver(this);
    IntentFilter intentFilter = new IntentFilter("android.net.wifi.STATE_CHANGE");
    registerReceiver(this.aqG, intentFilter);
  }
  
  protected void onDestroy() {
    super.onDestroy();
    unregisterReceiver(this.aqG);
  }
  
  protected void onResume() {
    this.aGF.setClickable(true);
    initData();
    super.onResume();
  }
  
  protected void yP() {
    a a1 = new a(this);
    this.aGJ.setOnItemSelectedListener(a1);
  }
  
  protected void yQ() { ag.K(this); }
  
  protected void yR() {
    this.aGF = (TextView)findViewById(2131296257);
    this.aGW = (ProgressBarCircularIndeterminate)findViewById(2131296430);
    this.aGW.setBackgroundColor(-1);
    this.aGF.setOnClickListener(this.aHp);
    this.aGG = (TextView)findViewById(2131296262);
    this.aGH = (TextView)findViewById(2131298984);
    this.aGG.setOnClickListener(this.aHn);
    this.aGM = (ListView)findViewById(2131296429);
    findViewById(2131299878).setOnClickListener(this.azO);
    this.aGS = (Button)findViewById(2131299879);
    this.aGN = (LinearLayout)findViewById(2131298974);
    this.aGR = (TextView)findViewById(2131299889);
    this.aGJ = (Spinner)findViewById(2131296431);
    this.aGS.setOnClickListener(this.aDd);
    av av = new av(this);
    this.aGV = av.atp();
    av.close();
  }
  
  public class NetworkConnectChangedReceiver extends BroadcastReceiver {
    public NetworkConnectChangedReceiver(BackUpRootActivity this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      if ("android.net.wifi.STATE_CHANGE".equals(param1Intent.getAction())) {
        NetworkInfo networkInfo = (NetworkInfo)param1Intent.getParcelableExtra("networkInfo");
        if (networkInfo != null) {
          boolean bool = networkInfo.isConnected();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("是否有网络:");
          stringBuilder.append(bool);
          n.println(stringBuilder.toString());
          stringBuilder = new StringBuilder();
          stringBuilder.append("网络的详细状况:");
          stringBuilder.append(networkInfo.getDetailedState());
          n.println(stringBuilder.toString());
          BackUpRootActivity.a(this.aHq, bool);
        } 
      } 
    }
  }
  
  class a extends BaseAdapter {
    a(BackUpRootActivity this$0) {}
    
    public int getCount() { return (BackUpRootActivity.aGD != null) ? BackUpRootActivity.aGD.size() : 0; }
    
    public Object getItem(int param1Int) { return null; }
    
    public long getItemId(int param1Int) { return 0L; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      a a1 = new a(this);
      if (param1View == null) {
        param1View = LayoutInflater.from(this.aHq).inflate(2131428123, null);
        a1.aHv = (TextView)param1View.findViewById(2131299896);
        a1.aHw = (TextView)param1View.findViewById(2131299897);
        a1.aHx = (TextView)param1View.findViewById(2131299895);
        a1.aHy = (TextView)param1View.findViewById(2131296428);
        a1.aHz = (LinearLayout)param1View.findViewById(2131296427);
        a1.aHA = (LinearLayout)param1View.findViewById(2131296426);
        param1View.setTag(a1);
      } else {
        a1 = (a)param1View.getTag();
      } 
      if (((HashMap)BackUpRootActivity.aGD.get(param1Int)).containsKey(this.aHq.aHb)) {
        a1.aHz.setVisibility(0);
        TextView textView = a1.aHy;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.aHq.getString(2131624358));
        stringBuilder.append(" ");
        stringBuilder.append(((HashMap)BackUpRootActivity.aGD.get(param1Int)).get(this.aHq.aHb));
        textView.setText(stringBuilder.toString());
      } else {
        a1.aHz.setVisibility(8);
      } 
      a1.aHA.setOnClickListener(new BackUpRootActivity.b(this.aHq, param1Int));
      if (((HashMap)BackUpRootActivity.aGD.get(param1Int)).containsKey(this.aHq.aHa)) {
        String str = ((HashMap)BackUpRootActivity.aGD.get(param1Int)).get(this.aHq.aHa).toString();
        if (str.equals(this.aHq.aGZ)) {
          a1.aHA.setBackgroundResource(2131231798);
          ((LinearLayout.LayoutParams)a1.aHA.getLayoutParams()).setMargins(0, 0, 0, 0);
        } else if (str.equals(this.aHq.aGY)) {
          a1.aHA.setBackgroundResource(2131231799);
          ((LinearLayout.LayoutParams)a1.aHA.getLayoutParams()).setMargins(0, 0, 0, 0);
        } else if (str.equals(this.aHq.aGX)) {
          a1.aHA.setBackgroundResource(2131231802);
          LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)a1.aHA.getLayoutParams();
          layoutParams.setMargins(0, 0, 0, -1);
          a1.aHA.setLayoutParams(layoutParams);
        } 
      } else {
        a1.aHA.setBackgroundResource(2131231800);
        ((LinearLayout.LayoutParams)a1.aHA.getLayoutParams()).setMargins(0, 0, 0, -1);
      } 
      a1.aHv.setText(z.bi(((HashMap)BackUpRootActivity.aGD.get(param1Int)).get("time").toString(), this.aHq.getString(2131627405)));
      a1.aHw.setText(((HashMap)BackUpRootActivity.aGD.get(param1Int)).get("name").toString());
      a1.aHx.setText(((HashMap)BackUpRootActivity.aGD.get(param1Int)).get("size").toString());
      return param1View;
    }
    
    public class a {
      LinearLayout aHA;
      
      TextView aHv;
      
      TextView aHw;
      
      TextView aHx;
      
      TextView aHy;
      
      LinearLayout aHz;
      
      public a(BackUpRootActivity.a this$0) {}
    }
  }
  
  public class a {
    LinearLayout aHA;
    
    TextView aHv;
    
    TextView aHw;
    
    TextView aHx;
    
    TextView aHy;
    
    LinearLayout aHz;
    
    public a(BackUpRootActivity this$0) {}
  }
  
  class b implements View.OnClickListener {
    int arg2;
    
    public b(BackUpRootActivity this$0, int param1Int) { this.arg2 = param1Int; }
    
    public void onClick(View param1View) {
      this.aHq.aHf = ((HashMap)BackUpRootActivity.aGD.get(this.arg2)).get("name").toString();
      BackUpRootActivity backUpRootActivity = this.aHq;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(((HashMap)BackUpRootActivity.aGD.get(this.arg2)).get("direct").toString());
      stringBuilder.append("/");
      backUpRootActivity.aHg = stringBuilder.toString();
      if (BackUpRootActivity.b(this.aHq) == null) {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        hashMap.put("name", this.aHq.getString(2131624395));
        arrayList.add(hashMap);
        hashMap = new HashMap();
        hashMap.put("name", this.aHq.getString(2131624396));
        arrayList.add(hashMap);
        BackUpRootActivity.a(this.aHq, new HashMap());
        BackUpRootActivity.c(this.aHq).put("name", this.aHq.getString(2131624397));
        if (bd.bH(this.aHq)) {
          BackUpRootActivity.c(this.aHq).put("text", "");
        } else {
          BackUpRootActivity.c(this.aHq).put("text", this.aHq.getString(2131626485));
        } 
        arrayList.add(BackUpRootActivity.c(this.aHq));
        BackUpRootActivity.a(this.aHq, new m(this.aHq, false));
        BackUpRootActivity.a(this.aHq, new p(this.aHq.getBaseContext(), arrayList, 2131427854, new String[] { "name", "text" }, new int[] { 2131299035, 2131299034 }));
        BackUpRootActivity.b(this.aHq).a(BackUpRootActivity.d(this.aHq));
        BackUpRootActivity.b(this.aHq).getListView().setOnItemClickListener(this.aHq.aHc);
        BackUpRootActivity.b(this.aHq).setTitle(this.aHq.getString(2131624398));
      } 
      BackUpRootActivity.b(this.aHq).show();
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\backup\BackUpRootActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */