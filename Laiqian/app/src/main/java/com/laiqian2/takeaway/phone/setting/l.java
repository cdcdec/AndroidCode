package com.laiqian.takeaway.phone.setting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.laiqian.ui.listview.FormListView;
import com.laiqian.ui.listview.e;
import com.laiqian.util.by;
import com.laiqian.util.ck;
import java.util.List;
import java.util.Map;

class l extends e {
  private a duV;
  
  l(PhoneListActivity paramPhoneListActivity, Context paramContext, List paramList, FormListView paramFormListView) { super(paramContext, paramList, paramFormListView); }
  
  private void fe(int paramInt) {
    PhoneListActivity phoneListActivity;
    Map map = (Map)this.aIG.get(paramInt);
    this.duV.duW.setText((CharSequence)map.get("sContactMobilePhone"));
    this.duV.duX.setText((CharSequence)map.get("sName"));
    TextView textView2 = this.duV.duY;
    if (by.isNull((String)map.get("nSpareField5"))) {
      phoneListActivity = "0";
    } else {
      String str1;
      phoneListActivity = (String)map.get("nSpareField5");
    } 
    if (Integer.valueOf(phoneListActivity).intValue() > 0) {
      PhoneListActivity phoneListActivity1 = this.duU;
      paramInt = 2131630023;
    } else {
      phoneListActivity = this.duU;
      paramInt = 2131630024;
    } 
    String str = phoneListActivity.getString(paramInt);
    textView2.setText(str);
    TextView textView1 = this.duV.duZ;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append((String)map.get("sField2"));
    stringBuilder.append(" ");
    stringBuilder.append((String)map.get("sAddress"));
    stringBuilder.append(" ");
    stringBuilder.append((String)map.get("sField3"));
    textView1.setText(stringBuilder.toString());
    this.duV.dva.setText((CharSequence)map.get("count"));
    this.duV.dvb.setText(by.a(by.sd((String)map.get("amount")), 9999, this.duU));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    if (paramView == null) {
      this.duV = new a(this);
      paramView = ((LayoutInflater)this.duU.getSystemService("layout_inflater")).inflate(2131428053, null);
      this.duV.duW = (TextView)paramView.findViewById(2131299793);
      this.duV.duX = (TextView)paramView.findViewById(2131299791);
      this.duV.duY = (TextView)paramView.findViewById(2131299788);
      this.duV.duZ = (TextView)paramView.findViewById(2131299781);
      this.duV.dva = (TextView)paramView.findViewById(2131299795);
      this.duV.dvb = (TextView)paramView.findViewById(2131299783);
      this.duV.buG = paramView.findViewById(2131296461);
      paramView.setTag(this.duV);
    } else {
      this.duV = (a)paramView.getTag();
    } 
    fe(paramInt);
    this.duV.buG.setActivated(ck.ml(paramInt));
    return paramView;
  }
  
  class a {
    View buG;
    
    TextView duW;
    
    TextView duX;
    
    TextView duY;
    
    TextView duZ;
    
    TextView dva;
    
    TextView dvb;
    
    a(l this$0) {}
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\phone\setting\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */