package com.laiqian.member.report;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.laiqian.ui.listview.FormListView;
import com.laiqian.ui.listview.e;
import com.laiqian.util.by;
import com.laiqian.util.ck;
import com.laiqian.util.n;
import com.laiqian.util.z;
import com.laiqian.vip.R;
import java.util.List;
import java.util.Map;

class n extends e {
  private a bzG;
  
  n(VipReportActivity paramVipReportActivity, Context paramContext, List paramList, FormListView paramFormListView) { super(paramContext, paramList, paramFormListView); }
  
  private void fe(int paramInt) {
    StringBuilder stringBuilder1;
    Map map = (Map)this.aIG.get(paramInt);
    long l = n.parseLong((String)map.get("points"));
    TextView textView3 = this.bzG.buB;
    if (l > 0L) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("+");
      stringBuilder1.append(l);
    } else {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(l);
      stringBuilder1.append("");
    } 
    String str2 = stringBuilder1.toString();
    textView3.setText(str2);
    String str1 = this.bzG.buC;
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append((String)map.get("fNewAmount"));
    stringBuilder3.append("");
    str1.setText(by.a(by.sd(stringBuilder3.toString()), 9999, this.bzE, (String)map.get("sSpareField5")));
    str1 = this.bzG.buD;
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append((String)map.get("fOldAmount"));
    stringBuilder3.append("");
    str1.setText(by.a(by.sd(stringBuilder3.toString()), 9999, this.bzE, (String)map.get("sSpareField5")));
    TextView textView2 = this.bzG.buE;
    if (Double.valueOf((String)map.get("fChargeAmount")).doubleValue() > 0.0D) {
      StringBuilder stringBuilder4 = new StringBuilder();
      stringBuilder4.append("+");
      StringBuilder stringBuilder5 = new StringBuilder();
      stringBuilder5.append((String)map.get("fChargeAmount"));
      stringBuilder5.append("");
      stringBuilder4.append(by.a(by.sd(stringBuilder5.toString()), 9999, this.bzE, (String)map.get("sSpareField5")));
      String str = stringBuilder4.toString();
    } else {
      null = new StringBuilder();
      null.append((String)map.get("fChargeAmount"));
      null.append("");
      str1 = by.a(by.sd(null.toString()), 9999, this.bzE, (String)map.get("sSpareField5"));
    } 
    textView2.setText(str1);
    if (this.bzG.buE.getText().toString().contains("-")) {
      this.bzG.buE.setTextColor(this.bzE.getResources().getColor(R.color.green_color_10500));
    } else {
      this.bzG.buE.setTextColor(this.bzE.getResources().getColor(R.color.pos_red_blackground));
    } 
    this.bzG.buF.setText(VipReportActivity.j(this.bzE).o((String)map.get("nChargeType"), (String)map.get("nSpareField2"), (String)map.get("nSpareField3")));
    TextView textView1 = this.bzG.bqc;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append((String)map.get("nOperationTime"));
    stringBuilder2.append("");
    textView1.setText(z.e(stringBuilder2.toString(), this.bzE));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    if (paramView == null) {
      this.bzG = new a(this);
      paramView = ((LayoutInflater)this.bzE.getSystemService("layout_inflater")).inflate(R.layout.pos_member_report_listview_item_max, null);
      this.bzG.buB = (TextView)paramView.findViewById(R.id.tvPoints);
      this.bzG.buC = (TextView)paramView.findViewById(R.id.tvAfterAmount);
      this.bzG.buD = (TextView)paramView.findViewById(R.id.tvBeforeAmount);
      this.bzG.buE = (TextView)paramView.findViewById(R.id.tvAmount);
      this.bzG.buF = (TextView)paramView.findViewById(R.id.tvTransactionType);
      this.bzG.bqc = (TextView)paramView.findViewById(R.id.tvDate);
      this.bzG.buG = paramView.findViewById(R.id.bg);
      paramView.setTag(this.bzG);
    } else {
      this.bzG = (a)paramView.getTag();
    } 
    fe(paramInt);
    this.bzG.buG.setActivated(ck.mk(paramInt));
    return paramView;
  }
  
  class a {
    TextView bqc;
    
    TextView buB;
    
    TextView buC;
    
    TextView buD;
    
    TextView buE;
    
    TextView buF;
    
    View buG;
    
    a(n this$0) {}
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\report\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */