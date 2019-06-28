package com.laiqian.meituan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.laiqian.ui.ActivityRoot;
import java.util.ArrayList;
import java.util.HashMap;

public class MeituanPhoneNumberErrorOrdersDetailActivity extends ActivityRoot {
  private String bdr;
  
  private TextView bqc;
  
  private TextView bqd;
  
  private ListView bqe;
  
  private String bqf;
  
  private String[] bqg;
  
  private String[] bqh;
  
  private ArrayList<HashMap<String, String>> bqi = new ArrayList();
  
  private void wR() {
    ((TextView)findViewById(R.id.ui_titlebar_txt)).setText(R.string.phone_number_error_orders_detail_title);
    findViewById(R.id.ui_titlebar_help_btn).setVisibility(8);
    this.bqc = (TextView)findViewById(R.id.tvDate);
    TextView textView = this.bqc;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getString(R.string.phone_number_error_orders_find_time));
    stringBuilder.append(this.bdr);
    textView.setText(stringBuilder.toString());
    this.bqd = (TextView)findViewById(R.id.tvOrderQty);
    textView = this.bqd;
    stringBuilder = new StringBuilder();
    stringBuilder.append(getString(R.string.phone_number_error_orders_qty));
    stringBuilder.append(this.bqf);
    textView.setText(stringBuilder.toString());
    this.bqe = (ListView)findViewById(R.id.lvDetail);
    a a = new a(this, this.bqi);
    this.bqe.setAdapter(a);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(R.layout.activity_meituan_phone_number_error_orders_detail);
    getWindow().setFeatureInt(7, R.layout.ui_titlebar);
    paramBundle = getIntent().getExtras();
    this.bdr = paramBundle.getString("date");
    this.bqf = paramBundle.getString("nQuantity");
    this.bqg = paramBundle.getString("orders").split(",");
    this.bqh = paramBundle.getString("realPhoneNumbers").split(",");
    for (byte b = 0; b < this.bqg.length; b++) {
      HashMap hashMap = new HashMap();
      hashMap.put("orderId", this.bqg[b]);
      hashMap.put("realPhoneNumber", this.bqh[b]);
      this.bqi.add(hashMap);
    } 
    wR();
  }
  
  public class a extends BaseAdapter {
    private a bqj;
    
    private ArrayList<HashMap<String, String>> bqk;
    
    public a(MeituanPhoneNumberErrorOrdersDetailActivity this$0, ArrayList<HashMap<String, String>> param1ArrayList) { this.bqk = param1ArrayList; }
    
    public int getCount() { return this.bqk.size(); }
    
    public Object getItem(int param1Int) { return this.bqk.get(param1Int); }
    
    public long getItemId(int param1Int) { return param1Int; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      if (param1View == null) {
        this.bqj = new a(this);
        param1View = ((LayoutInflater)this.bql.getSystemService("layout_inflater")).inflate(R.layout.item_meituan_phone_number_detail, null);
        this.bqj.bqm = (TextView)param1View.findViewById(R.id.tvOrder);
        this.bqj.bqn = (TextView)param1View.findViewById(R.id.tvRealPhoneNumber);
        param1View.setTag(this.bqj);
      } else {
        this.bqj = (a)param1View.getTag();
      } 
      TextView textView = this.bqj.bqm;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(String.format(this.bql.getString(R.string.phone_number_order), new Object[] { Integer.valueOf(param1Int + 1) }));
      stringBuilder.append((String)((HashMap)this.bqk.get(param1Int)).get("orderId"));
      textView.setText(stringBuilder.toString());
      textView = this.bqj.bqn;
      stringBuilder = new StringBuilder();
      stringBuilder.append(this.bql.getString(R.string.real_phone_number));
      stringBuilder.append((String)((HashMap)this.bqk.get(param1Int)).get("realPhoneNumber"));
      textView.setText(stringBuilder.toString());
      return param1View;
    }
    
    class a {
      TextView bqm;
      
      TextView bqn;
      
      a(MeituanPhoneNumberErrorOrdersDetailActivity.a this$0) {}
    }
  }
  
  class a {
    TextView bqm;
    
    TextView bqn;
    
    a(MeituanPhoneNumberErrorOrdersDetailActivity this$0) {}
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\MeituanPhoneNumberErrorOrdersDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */