package com.laiqian.pos.settings;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.laiqian.print.usage.kitchen.a.a;
import com.laiqian.print.usage.kitchen.a.c;
import com.laiqian.product.models.l;
import com.laiqian.ui.ActivityRoot;
import java.util.ArrayList;
import java.util.HashMap;

@Deprecated
public class KitchenPrintSetting extends ActivityRoot {
  View.OnClickListener aDd = new x(this);
  
  private Button aGS;
  
  private View azH;
  
  View.OnClickListener azO = new w(this);
  
  private ListView bLC;
  
  private ArrayList<HashMap<String, String>> bqk;
  
  private ArrayList<String> czR = new ArrayList();
  
  private c czS = null;
  
  private a czT = null;
  
  private void initData() {
    this.czT = a.bm(this);
    this.czS = this.czT.aiC();
    if (this.czR == null)
      this.czR = new ArrayList(); 
    l l = new l(this);
    this.bqk = l.akT();
    l.close();
    a a1 = new a(this, this, this.bqk);
    this.bLC.setAdapter(a1);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131427872);
    getWindow().setFeatureInt(7, 2131428168);
    this.azH = findViewById(2131299878);
    this.azH.setOnClickListener(this.azO);
    this.aGS = (Button)findViewById(2131299879);
    this.aGS.setOnClickListener(this.aDd);
    this.aGS.setVisibility(8);
    ((TextView)findViewById(2131299889)).setText(2131628982);
    this.bLC = (ListView)findViewById(2131298072);
    initData();
  }
  
  public class a extends BaseAdapter {
    private ArrayList<HashMap<String, String>> bqk;
    
    private Context context;
    
    private HashMap<Integer, Boolean> czV;
    
    public a(KitchenPrintSetting this$0, Context param1Context, ArrayList<HashMap<String, String>> param1ArrayList) {
      this.context = param1Context;
      this.bqk = param1ArrayList;
      init();
    }
    
    private void init() {
      this.czV = new HashMap();
      for (byte b = 0; b < this.bqk.size(); b++) {
        if (KitchenPrintSetting.a(this.czU) != null) {
          if (KitchenPrintSetting.a(this.czU).contains(((HashMap)this.bqk.get(b)).get("_id"))) {
            this.czV.put(Integer.valueOf(b), Boolean.valueOf(false));
          } else {
            this.czV.put(Integer.valueOf(b), Boolean.valueOf(true));
          } 
        } else {
          this.czV.put(Integer.valueOf(b), Boolean.valueOf(true));
        } 
      } 
    }
    
    public int getCount() { return this.bqk.size(); }
    
    public Object getItem(int param1Int) { return this.bqk.get(param1Int); }
    
    public long getItemId(int param1Int) { return param1Int; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      a a1;
      if (param1View == null) {
        param1View = LayoutInflater.from(this.context).inflate(2131427873, null);
        a1 = new a(this);
        a1.czX = (TextView)param1View.findViewById(2131299408);
        a1.czY = (CheckBox)param1View.findViewById(2131298290);
        param1View.setTag(a1);
      } else {
        a1 = (a)param1View.getTag();
      } 
      a1.czX.setText((CharSequence)((HashMap)this.bqk.get(param1Int)).get("sFieldName"));
      a1.czY.setOnCheckedChangeListener(new y(this, param1Int));
      a1.czY.setChecked(((Boolean)this.czV.get(Integer.valueOf(param1Int))).booleanValue());
      return param1View;
    }
    
    public class a {
      TextView czX;
      
      CheckBox czY;
      
      public a(KitchenPrintSetting.a this$0) {}
    }
  }
  
  public class a {
    TextView czX;
    
    CheckBox czY;
    
    public a(KitchenPrintSetting this$0) {}
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\KitchenPrintSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */