package com.laiqian.member;

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

class ae extends e {
  private a buA;
  
  ae(MemberInfoActivity paramMemberInfoActivity, Context paramContext, List paramList, FormListView paramFormListView) { super(paramContext, paramList, paramFormListView); }
  
  private void fe(int paramInt) {
    StringBuilder stringBuilder1;
    Map map = (Map)this.aIG.get(paramInt);
    double d = by.parseDouble((String)map.get("points"));
    TextView textView3 = this.buA.buB;
    if (d > 0.0D) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("+");
      stringBuilder1.append(d);
    } else {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(d);
      stringBuilder1.append("");
    } 
    String str2 = stringBuilder1.toString();
    textView3.setText(str2);
    String str1 = this.buA.buC;
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append((String)map.get("fNewAmount"));
    stringBuilder3.append("");
    str1.setText(by.a(by.sd(stringBuilder3.toString()), 9999, this.buu));
    str1 = this.buA.buD;
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append((String)map.get("fOldAmount"));
    stringBuilder3.append("");
    str1.setText(by.a(by.sd(stringBuilder3.toString()), 9999, this.buu));
    TextView textView2 = this.buA.buE;
    if (n.u((CharSequence)map.get("fChargeAmount")) > 0.0D) {
      StringBuilder stringBuilder4 = new StringBuilder();
      stringBuilder4.append("+");
      StringBuilder stringBuilder5 = new StringBuilder();
      stringBuilder5.append((String)map.get("fChargeAmount"));
      stringBuilder5.append("");
      stringBuilder4.append(by.a(by.sd(stringBuilder5.toString()), 9999, this.buu));
      String str = stringBuilder4.toString();
    } else {
      null = new StringBuilder();
      null.append((String)map.get("fChargeAmount"));
      null.append("");
      str1 = by.a(by.sd(null.toString()), 9999, this.buu);
    } 
    textView2.setText(str1);
    if (this.buA.buE.getText().toString().contains("-")) {
      this.buA.buE.setTextColor(this.buu.getResources().getColor(R.color.green_color_10500));
    } else {
      this.buA.buE.setTextColor(this.buu.getResources().getColor(R.color.pos_red_blackground));
    } 
    this.buA.buF.setText(MemberInfoActivity.a(this.buu).o((String)map.get("nChargeType"), (String)map.get("nSpareField2"), (String)map.get("nSpareField3")));
    TextView textView1 = this.buA.bqc;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append((String)map.get("nOperationTime"));
    stringBuilder2.append("");
    textView1.setText(z.e(stringBuilder2.toString(), this.buu));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    if (paramView == null) {
      this.buA = new a(this);
      paramView = ((LayoutInflater)this.buu.getSystemService("layout_inflater")).inflate(R.layout.pos_member_report_listview_item, null);
      this.buA.buB = (TextView)paramView.findViewById(R.id.tvPoints);
      this.buA.buC = (TextView)paramView.findViewById(R.id.tvAfterAmount);
      this.buA.buD = (TextView)paramView.findViewById(R.id.tvBeforeAmount);
      this.buA.buE = (TextView)paramView.findViewById(R.id.tvAmount);
      this.buA.buF = (TextView)paramView.findViewById(R.id.tvTransactionType);
      this.buA.bqc = (TextView)paramView.findViewById(R.id.tvDate);
      this.buA.buG = paramView.findViewById(R.id.bg);
      paramView.setTag(this.buA);
    } else {
      this.buA = (a)paramView.getTag();
    } 
    fe(paramInt);
    this.buA.buG.setActivated(ck.mk(paramInt));
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
    
    a(ae this$0) {}
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */