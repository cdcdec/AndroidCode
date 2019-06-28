package com.laiqian.backup;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.m;
import com.laiqian.ui.a.p;
import com.laiqian.util.bb;
import com.laiqian.util.bd;
import com.laiqian.util.z;
import io.reactivex.g.a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class BackUpSystemHaltedActivity extends ActivityRoot {
  protected static ArrayList<HashMap<String, Object>> aIc;
  
  protected String aGK = "";
  
  private Dialog aGU;
  
  String aGX = "upTag";
  
  String aGY = "downTag";
  
  String aGZ = "roundTag";
  
  String aHa = "Tag";
  
  String aHb = "startTag";
  
  AdapterView.OnItemClickListener aHc = new z(this);
  
  private final int aHd = 1;
  
  Handler aHe = new ab(this);
  
  String aHf = null;
  
  String aHg = null;
  
  private m aHh;
  
  private HashMap<String, Object> aHi;
  
  private p aHj;
  
  a aId = null;
  
  protected TextView aIe;
  
  protected TextView aIf;
  
  protected ListView aIg;
  
  private LinearLayout aIh;
  
  TextView aIi;
  
  Button aIj;
  
  View.OnClickListener aIk = new ac(this);
  
  View.OnClickListener aIl = new ad(this);
  
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
  
  private void a(String paramString, File paramFile) {
    aa aa = new aa(this, paramString, paramFile);
    a.aKh().r(aa);
  }
  
  private void bC(String paramString) {
    this.aHi.put("text", paramString);
    this.aHj.notifyDataSetChanged();
  }
  
  private boolean bD(String paramString) {
    bb.e("systemHalted", paramString);
    if (aIc != null) {
      aIc.clear();
    } else {
      aIc = new ArrayList();
    } 
    ArrayList arrayList = a(ag.a(paramString, "aw_", ".log", true), paramString);
    if (arrayList != null)
      aIc.addAll(arrayList); 
    return (aIc.size() > 0);
  }
  
  private void e(String paramString, boolean paramBoolean) {
    this.aIh.setVisibility(0);
    this.aIf.setText(paramString);
    this.aIg.setVisibility(8);
    if (paramBoolean) {
      this.aIe.setVisibility(8);
      return;
    } 
    this.aIe.setVisibility(0);
  }
  
  private void initData() {
    this.aIi.setText(2131624400);
    if (ag.za()) {
      this.aGK = ag.yX();
      yS();
      return;
    } 
    Toast.makeText(this, 2131629914, 1).show();
    finish();
  }
  
  private void yS() {
    bD(this.aGK);
    if (aIc == null)
      return; 
    if (aIc.size() == 0) {
      e(getString(2131624399), true);
    } else {
      this.aIg.setVisibility(0);
      this.aIh.setVisibility(8);
    } 
    if (this.aId == null) {
      this.aId = new a(this);
      this.aIg.setAdapter(this.aId);
    } 
    this.aId.notifyDataSetChanged();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131427427);
    getWindow().setFeatureInt(7, 2131428168);
    yR();
  }
  
  protected void onResume() {
    initData();
    super.onResume();
  }
  
  protected void yR() {
    this.aIe = (TextView)findViewById(2131296262);
    this.aIf = (TextView)findViewById(2131298983);
    this.aIe.setOnClickListener(this.aIl);
    this.aIg = (ListView)findViewById(2131299138);
    findViewById(2131299878).setOnClickListener(this.aIk);
    this.aIj = (Button)findViewById(2131299879);
    this.aIj.setVisibility(8);
    this.aIh = (LinearLayout)findViewById(2131298974);
    this.aIi = (TextView)findViewById(2131299889);
  }
  
  class a extends BaseAdapter {
    a(BackUpSystemHaltedActivity this$0) {}
    
    public int getCount() { return (BackUpSystemHaltedActivity.aIc != null) ? BackUpSystemHaltedActivity.aIc.size() : 0; }
    
    public Object getItem(int param1Int) { return null; }
    
    public long getItemId(int param1Int) { return 0L; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      a a1 = new a(this);
      if (param1View == null) {
        param1View = LayoutInflater.from(this.aIm).inflate(2131428123, null);
        a1.aIp = (TextView)param1View.findViewById(2131299896);
        a1.aIq = (TextView)param1View.findViewById(2131299897);
        a1.aIr = (TextView)param1View.findViewById(2131299895);
        a1.aIs = (TextView)param1View.findViewById(2131296428);
        a1.aIt = (LinearLayout)param1View.findViewById(2131296427);
        a1.aIu = (LinearLayout)param1View.findViewById(2131296426);
        param1View.setTag(a1);
      } else {
        a1 = (a)param1View.getTag();
      } 
      if (((HashMap)BackUpSystemHaltedActivity.aIc.get(param1Int)).containsKey(this.aIm.aHb)) {
        a1.aIt.setVisibility(0);
        TextView textView = a1.aIs;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.aIm.getString(2131624358));
        stringBuilder.append(" ");
        stringBuilder.append(((HashMap)BackUpSystemHaltedActivity.aIc.get(param1Int)).get(this.aIm.aHb));
        textView.setText(stringBuilder.toString());
      } else {
        a1.aIt.setVisibility(8);
      } 
      a1.aIu.setOnClickListener(new BackUpSystemHaltedActivity.b(this.aIm, param1Int));
      LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)a1.aIu.getLayoutParams();
      if (((HashMap)BackUpSystemHaltedActivity.aIc.get(param1Int)).containsKey(this.aIm.aHa)) {
        String str = ((HashMap)BackUpSystemHaltedActivity.aIc.get(param1Int)).get(this.aIm.aHa).toString();
        if (str.equals(this.aIm.aGZ)) {
          a1.aIu.setBackgroundResource(2130772035);
          layoutParams.setMargins(0, 0, 0, 0);
        } else if (str.equals(this.aIm.aGY)) {
          a1.aIu.setBackgroundResource(2130772036);
          layoutParams.setMargins(0, 0, 0, 0);
        } else if (str.equals(this.aIm.aGX)) {
          a1.aIu.setBackgroundResource(2130772043);
          layoutParams.setMargins(0, 0, 0, -1);
          a1.aIu.setLayoutParams(layoutParams);
        } 
      } else {
        a1.aIu.setBackgroundResource(2130772039);
        layoutParams.setMargins(0, 0, 0, -1);
      } 
      a1.aIp.setText(z.bi(((HashMap)BackUpSystemHaltedActivity.aIc.get(param1Int)).get("time").toString(), this.aIm.getString(2131627405)));
      a1.aIq.setText(((HashMap)BackUpSystemHaltedActivity.aIc.get(param1Int)).get("name").toString());
      a1.aIr.setText(((HashMap)BackUpSystemHaltedActivity.aIc.get(param1Int)).get("size").toString());
      return param1View;
    }
    
    public class a {
      TextView aIp;
      
      TextView aIq;
      
      TextView aIr;
      
      TextView aIs;
      
      LinearLayout aIt;
      
      LinearLayout aIu;
      
      public a(BackUpSystemHaltedActivity.a this$0) {}
    }
  }
  
  public class a {
    TextView aIp;
    
    TextView aIq;
    
    TextView aIr;
    
    TextView aIs;
    
    LinearLayout aIt;
    
    LinearLayout aIu;
    
    public a(BackUpSystemHaltedActivity this$0) {}
  }
  
  class b implements View.OnClickListener {
    int arg2;
    
    public b(BackUpSystemHaltedActivity this$0, int param1Int) { this.arg2 = param1Int; }
    
    public void onClick(View param1View) {
      this.aIm.aHf = ((HashMap)BackUpSystemHaltedActivity.aIc.get(this.arg2)).get("name").toString();
      BackUpSystemHaltedActivity backUpSystemHaltedActivity = this.aIm;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(((HashMap)BackUpSystemHaltedActivity.aIc.get(this.arg2)).get("direct").toString());
      stringBuilder.append("/");
      backUpSystemHaltedActivity.aHg = stringBuilder.toString();
      if (BackUpSystemHaltedActivity.a(this.aIm) == null) {
        ArrayList arrayList = new ArrayList();
        BackUpSystemHaltedActivity.a(this.aIm, new HashMap());
        BackUpSystemHaltedActivity.b(this.aIm).put("name", this.aIm.getString(2131624397));
        if (bd.bH(this.aIm)) {
          BackUpSystemHaltedActivity.b(this.aIm).put("text", "");
        } else {
          BackUpSystemHaltedActivity.b(this.aIm).put("text", this.aIm.getString(2131626485));
        } 
        arrayList.add(BackUpSystemHaltedActivity.b(this.aIm));
        BackUpSystemHaltedActivity.a(this.aIm, new m(this.aIm, false));
        BackUpSystemHaltedActivity.a(this.aIm, new p(this.aIm.getBaseContext(), arrayList, 2131427854, new String[] { "name", "text" }, new int[] { 2131299035, 2131299034 }));
        BackUpSystemHaltedActivity.a(this.aIm).a(BackUpSystemHaltedActivity.c(this.aIm));
        BackUpSystemHaltedActivity.a(this.aIm).getListView().setOnItemClickListener(this.aIm.aHc);
        BackUpSystemHaltedActivity.a(this.aIm).setTitle(this.aIm.getString(2131624398));
      } 
      BackUpSystemHaltedActivity.a(this.aIm).show();
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\backup\BackUpSystemHaltedActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */