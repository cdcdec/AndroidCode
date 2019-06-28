package com.laiqian.member.select;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.laiqian.ui.listview.FormListView;
import com.laiqian.ui.listview.e;
import com.laiqian.util.by;
import com.laiqian.vip.R;
import java.util.List;
import java.util.Map;

class v extends e {
  private a bAO;
  
  v(r paramr, Context paramContext, List paramList, FormListView paramFormListView) { super(paramContext, paramList, paramFormListView); }
  
  private void fe(int paramInt) {
    Map map = (Map)this.aIG.get(paramInt);
    TextView textView2 = this.bAO.bvw;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Double.valueOf((String)map.get("fPoints")).intValue());
    stringBuilder.append("");
    textView2.setText(stringBuilder.toString());
    String str = by.a(by.sd((String)map.get("fAmount")), 9999, r.a(this.bAN));
    this.bAO.aAs.setText(str);
    TextView textView1 = this.bAO.bwu;
    stringBuilder = new StringBuilder();
    stringBuilder.append((String)map.get("sContactMobilePhone"));
    stringBuilder.append("");
    textView1.setText(by.G(stringBuilder.toString(), 11));
    textView1 = this.bAO.bvD;
    stringBuilder = new StringBuilder();
    stringBuilder.append((String)map.get("sNumber"));
    stringBuilder.append("");
    textView1.setText(by.I(stringBuilder.toString(), 11));
    this.bAO.aRl.setText(by.J((String)map.get("sName"), 12));
    this.bAO.bAn.setTag(Integer.valueOf(paramInt));
    this.bAO.bAQ.setTag(Integer.valueOf(paramInt));
  }
  
  private void setListeners() {
    this.bAO.bAn.setOnClickListener(new w(this));
    this.bAO.bAQ.setOnClickListener(new x(this));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    if (paramView == null) {
      this.bAO = new a(this);
      paramView = ((LayoutInflater)r.b(this.bAN).getSystemService("layout_inflater")).inflate(R.layout.item_vip_lv_stroke, null);
      this.bAO.bvw = (TextView)paramView.findViewById(R.id.tv_points);
      this.bAO.aAs = (TextView)paramView.findViewById(R.id.tv_amount);
      this.bAO.bwu = (TextView)paramView.findViewById(R.id.tv_phone);
      this.bAO.bvD = (TextView)paramView.findViewById(R.id.tv_card_number);
      this.bAO.aRl = (TextView)paramView.findViewById(R.id.tv_name);
      this.bAO.bAn = (TextView)paramView.findViewById(R.id.tv_charge);
      this.bAO.bAQ = (TextView)paramView.findViewById(R.id.tv_detail);
      paramView.setTag(this.bAO);
    } else {
      this.bAO = (a)paramView.getTag();
    } 
    fe(paramInt);
    setListeners();
    return paramView;
  }
  
  class a {
    TextView aAs;
    
    TextView aRl;
    
    TextView bAQ;
    
    TextView bAn;
    
    TextView bvD;
    
    TextView bvw;
    
    TextView bwu;
    
    a(v this$0) {}
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\select\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */