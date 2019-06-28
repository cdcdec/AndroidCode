package com.laiqian.meituan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.laiqian.ui.listview.FormListView;
import com.laiqian.ui.listview.e;
import com.laiqian.util.n;
import com.laiqian.util.z;
import java.util.List;
import java.util.Map;

class w extends e {
  private a bqS;
  
  w(MeituanPhoneNumberErrorsDocActivity paramMeituanPhoneNumberErrorsDocActivity, Context paramContext, List paramList, FormListView paramFormListView) { super(paramContext, paramList, paramFormListView); }
  
  private void fe(int paramInt) {
    Map map = (Map)this.aIG.get(paramInt);
    TextView textView = this.bqS.bqd;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(n.parseLong((String)map.get("nQuantity")));
    stringBuilder.append("");
    textView.setText(stringBuilder.toString());
    textView = this.bqS.bqW;
    stringBuilder = new StringBuilder();
    stringBuilder.append((String)map.get("nDateTime"));
    stringBuilder.append("");
    textView.setText(z.e(stringBuilder.toString(), this.bqT));
    this.bqS.bqX.setOnClickListener(new x(this, map));
    this.bqS.bqY.setOnClickListener(new y(this, map));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    if (paramView == null) {
      this.bqS = new a(this);
      paramView = ((LayoutInflater)this.bqT.getSystemService("layout_inflater")).inflate(R.layout.item_meituan_phone_number, null);
      this.bqS.bqd = (TextView)paramView.findViewById(R.id.tvOrderQty);
      this.bqS.bqW = (TextView)paramView.findViewById(R.id.tvTime);
      this.bqS.bqX = (Button)paramView.findViewById(R.id.btnDetail);
      this.bqS.bqY = (Button)paramView.findViewById(R.id.btnPrint);
      paramView.setTag(this.bqS);
    } else {
      this.bqS = (a)paramView.getTag();
    } 
    fe(paramInt);
    return paramView;
  }
  
  class a {
    TextView bqW;
    
    Button bqX;
    
    Button bqY;
    
    TextView bqd;
    
    a(w this$0) {}
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */