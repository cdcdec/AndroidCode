package com.laiqian.member.select;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.laiqian.basic.RootApplication;
import com.laiqian.ui.listview.FormListView;
import com.laiqian.ui.listview.e;
import com.laiqian.util.by;
import com.laiqian.vip.R;
import java.util.List;
import java.util.Map;

class ad extends e {
  private a bAU;
  
  ad(y paramy, Context paramContext, List paramList, FormListView paramFormListView) { super(paramContext, paramList, paramFormListView); }
  
  private void fe(int paramInt) {
    Map map = (Map)this.aIG.get(paramInt);
    TextView textView = this.bAU.bvw;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Double.valueOf((String)map.get("fPoints")).intValue());
    stringBuilder.append("");
    textView.setText(stringBuilder.toString());
    this.bAU.aAs.setText(by.a(by.sd((String)map.get("fAmount")), 9999, y.a(this.bAT)));
    textView = this.bAU.bwu;
    stringBuilder = new StringBuilder();
    stringBuilder.append((String)map.get("sContactMobilePhone"));
    stringBuilder.append("");
    textView.setText(by.G(stringBuilder.toString(), 11));
    textView = this.bAU.bvD;
    stringBuilder = new StringBuilder();
    stringBuilder.append((String)map.get("sNumber"));
    stringBuilder.append("");
    textView.setText(by.I(stringBuilder.toString(), 11));
    this.bAU.aRl.setText(by.J((String)map.get("sName"), 12));
    this.bAU.bAn.setTag(Integer.valueOf(paramInt));
    this.bAU.bAQ.setTag(Integer.valueOf(paramInt));
    if (RootApplication.getLaiqianPreferenceManager().avL() == 1)
      this.bAU.bAn.setVisibility(8); 
  }
  
  private void setListeners() {
    this.bAU.bAn.setOnClickListener(new ae(this));
    this.bAU.bAQ.setOnClickListener(new af(this));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    if (paramView == null) {
      this.bAU = new a(this);
      paramView = ((LayoutInflater)y.b(this.bAT).getSystemService("layout_inflater")).inflate(R.layout.item_vip_lv_stroke, null);
      this.bAU.bvw = (TextView)paramView.findViewById(R.id.tv_points);
      this.bAU.aAs = (TextView)paramView.findViewById(R.id.tv_amount);
      this.bAU.bwu = (TextView)paramView.findViewById(R.id.tv_phone);
      this.bAU.bvD = (TextView)paramView.findViewById(R.id.tv_card_number);
      this.bAU.aRl = (TextView)paramView.findViewById(R.id.tv_name);
      this.bAU.bAn = (TextView)paramView.findViewById(R.id.tv_charge);
      this.bAU.bAQ = (TextView)paramView.findViewById(R.id.tv_detail);
      if (RootApplication.getLaiqianPreferenceManager().avL() != 0) {
        this.bAU.bAn.setVisibility(8);
        this.bAU.bAQ.setVisibility(8);
      } 
      paramView.setTag(this.bAU);
    } else {
      this.bAU = (a)paramView.getTag();
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
    
    a(ad this$0) {}
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\select\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */