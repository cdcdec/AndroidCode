package com.laiqian.meituan;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.laiqian.meituan.a.d;
import com.laiqian.meituan.b.b;
import com.laiqian.meituan.c.c;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.listview.PosAutoListView;
import com.laiqian.ui.listview.l;
import com.laiqian.ui.s;
import com.laiqian.ui.webview.PosWebViewLinearLayout;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.HashMap;

public class MTSettingActivity extends ActivityRoot implements a {
  a bpD;
  
  h bpE;
  
  l bpF;
  
  d bpG;
  
  ArrayList<HashMap<String, Object>> bpH;
  
  ArrayList<HashMap<String, Object>> bpI;
  
  aa titleBar;
  
  private void Ek() {
    int i = Build.VERSION.SDK_INT;
    this.bpD.aQH.setWebViewClient(new c(this));
    this.bpD.bpL.setOnClickListener(new d(this));
    this.titleBar.brj.setOnClickListener(new e(this));
  }
  
  public void B(ArrayList<i> paramArrayList) {
    if (this.bpG == null) {
      this.bpG = new d(paramArrayList, this);
    } else {
      this.bpG.g(paramArrayList);
    } 
    this.bpD.aQK.setAdapter(this.bpG);
    n.c(this.bpD.aQK);
  }
  
  public void En() {
    String str = b.PF();
    Log.e("authUrl", str);
    this.bpD.aQH.setVisibility(0);
    this.bpD.aQJ.setVisibility(8);
    this.titleBar.brj.setVisibility(0);
    this.bpD.aQH.pf(str);
  }
  
  public void Eo() {
    this.bpD.aQH.setVisibility(8);
    this.titleBar.brj.setVisibility(8);
    this.bpD.aQJ.setVisibility(0);
  }
  
  public void b(String[] paramArrayOfString, boolean paramBoolean) {
    if (paramBoolean) {
      for (byte b = 0; b < this.bpH.size(); b++) {
        byte b1;
        for (b1 = 0; b1 < paramArrayOfString.length; b1++) {
          if (paramArrayOfString[b1].equals(String.valueOf(((HashMap)this.bpH.get(b)).get("app_poi_code"))))
            ((HashMap)this.bpH.get(b)).put("checked", Boolean.valueOf(true)); 
        } 
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("arrMTInfo:");
      stringBuilder.append(this.bpH.toString());
      Log.e("arrMTInfo", stringBuilder.toString());
      this.bpF.notifyDataSetChanged();
    } 
  }
  
  public void d(ArrayList<i> paramArrayList, String[] paramArrayOfString) {
    this.bpH = c.c(paramArrayList, paramArrayOfString);
    if (paramArrayList == null)
      return; 
    ArrayList arrayList = this.bpH;
    int i = R.layout.meituan_shops_item;
    int j = R.id.tvLable;
    int k = R.id.cb;
    this.bpF = new l(this, arrayList, i, new String[] { "name", "checked" }, new int[] { j, k }, false, false);
    this.bpD.bpK.setResultSize(paramArrayList.size());
    this.bpD.bpK.setAdapter(this.bpF);
    f f = new f(this);
    this.bpD.bpK.setOnItemClickListener(f);
    n.c(this.bpD.bpK);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.bpD = a.j(this);
    this.titleBar = aa.M(this);
    this.titleBar.tvTitle.setText(getString(R.string.meituan_title));
    this.titleBar.brj.setVisibility(8);
    this.titleBar.brj.setText(R.string.next_step);
    this.bpE = new h(this, this);
    Ek();
    this.bpE.init();
  }
  
  protected void onDestroy() {
    super.onDestroy();
    this.bpD.aQH.onDestroy();
  }
  
  public static class a {
    public static final int aCt = R.layout.activity_mt_setting;
    
    public View aQG;
    
    public PosWebViewLinearLayout aQH;
    
    public ViewGroup aQJ;
    
    public ListView aQK;
    
    public PosAutoListView bpK;
    
    public ViewGroup bpL;
    
    private Context context;
    
    public a(View param1View) {
      this.aQG = param1View;
      this.context = param1View.getContext();
      this.aQH = (PosWebViewLinearLayout)s.z(param1View, R.id.show_webview);
      this.aQJ = (ViewGroup)s.z(param1View, R.id.ll_setting);
      this.bpK = (PosAutoListView)s.z(param1View, R.id.lv_shop_pushable);
      this.bpL = (ViewGroup)s.z(param1View, R.id.ll_auth_admin);
      this.aQK = (ListView)s.z(param1View, R.id.lv_setting);
    }
    
    public static a j(Activity param1Activity) {
      View view = LayoutInflater.from(param1Activity).inflate(aCt, null);
      param1Activity.setContentView(view);
      return new a(view);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\MTSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */