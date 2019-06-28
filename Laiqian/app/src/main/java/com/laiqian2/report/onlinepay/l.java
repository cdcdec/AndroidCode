package com.laiqian.report.onlinepay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.laiqian.message.m;
import com.laiqian.ui.listview.FormListView;
import com.laiqian.ui.listview.e;
import com.laiqian.util.by;
import com.laiqian.util.ck;
import com.laiqian.util.n;
import com.laiqian.util.z;
import java.util.List;
import java.util.Map;

class l extends e {
  private a ddm;
  
  l(OnlinePayReportActivity paramOnlinePayReportActivity, Context paramContext, List paramList, FormListView paramFormListView) { super(paramContext, paramList, paramFormListView); }
  
  private void fe(int paramInt) {
    Map map = (Map)this.aIG.get(paramInt);
    TextView textView = this.ddm.ddo;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append((String)map.get("sOrderNo"));
    stringBuilder.append("");
    textView.setText(stringBuilder.toString());
    textView = this.ddm.buE;
    stringBuilder = new StringBuilder();
    stringBuilder.append((String)map.get("fAmount"));
    stringBuilder.append("");
    textView.setText(by.a(by.sd(stringBuilder.toString()), 9999, this.ddj, "2"));
    if (n.parseInt((String)map.get("nStatus")) == 1 || !m.Tw().equals(map.get("sSpareField1"))) {
      this.ddm.ddq.setText(2131626025);
    } else {
      this.ddm.ddq.setText(2131626024);
    } 
    this.ddm.ddp.setText(OnlinePayReportActivity.f(this.ddj).jN(n.parseInt((String)map.get("nPayType"))));
    this.ddm.cJj.setText(OnlinePayReportActivity.f(this.ddj).jO(n.parseInt((String)map.get("nStatus"))));
    this.ddm.cJj.setTextColor(this.ddj.getResources().getColor(OnlinePayReportActivity.f(this.ddj).jP(n.parseInt((String)map.get("nStatus")))));
    textView = this.ddm.bqc;
    stringBuilder = new StringBuilder();
    stringBuilder.append((String)map.get("nDateTime"));
    stringBuilder.append("");
    textView.setText(z.e(stringBuilder.toString(), this.ddj));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    if (paramView == null) {
      this.ddm = new a(this);
      paramView = ((LayoutInflater)this.ddj.getSystemService("layout_inflater")).inflate(2131427686, null);
      this.ddm.ddo = (TextView)paramView.findViewById(2131299369);
      this.ddm.ddp = (TextView)paramView.findViewById(2131299373);
      this.ddm.cJj = (TextView)paramView.findViewById(2131299431);
      this.ddm.buE = (TextView)paramView.findViewById(2131299296);
      this.ddm.ddq = (TextView)paramView.findViewById(2131299366);
      this.ddm.bqc = (TextView)paramView.findViewById(2131299312);
      this.ddm.buG = paramView.findViewById(2131296461);
      paramView.setTag(this.ddm);
    } else {
      this.ddm = (a)paramView.getTag();
    } 
    this.ddm.ddq.setOnClickListener(new m(this, paramInt));
    fe(paramInt);
    this.ddm.buG.setActivated(ck.mk(paramInt));
    return paramView;
  }
  
  class a {
    TextView bqc;
    
    TextView buE;
    
    View buG;
    
    TextView cJj;
    
    TextView ddo;
    
    TextView ddp;
    
    TextView ddq;
    
    a(l this$0) {}
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\onlinepay\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */