package com.laiqian.member;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.laiqian.entity.c;
import com.laiqian.ui.listview.FormListView;
import com.laiqian.ui.listview.e;
import com.laiqian.util.by;
import com.laiqian.util.ck;
import com.laiqian.util.n;
import com.laiqian.util.z;
import com.laiqian.vip.R;
import java.util.List;
import java.util.Map;

class ax extends e {
  private a bvv;
  
  ax(MemberListActivity paramMemberListActivity, Context paramContext, List paramList, FormListView paramFormListView) { super(paramContext, paramList, paramFormListView); }
  
  private void fe(int paramInt) {
    Map map = (Map)this.aIG.get(paramInt);
    MemberListActivity memberListActivity = this.bvv.bvw;
    Object object = new StringBuilder();
    object.append((int)Double.valueOf((String)map.get("fPoints")).doubleValue());
    object.append("");
    memberListActivity.setText(object.toString());
    this.bvv.bvx.setText(by.a(by.sd((String)map.get("fAmount")), 9999, this.bvu));
    TextView textView2 = this.bvv.bvy;
    if (n.bc(Double.valueOf((String)map.get("fSpareField1")).doubleValue())) {
      MemberListActivity memberListActivity1 = this.bvu;
      Integer integer = Integer.valueOf(0);
    } else {
      memberListActivity = this.bvu;
      object = map.get("fSpareField1");
    } 
    String str = n.b(memberListActivity, object, true, true);
    textView2.setText(str);
    TextView textView1 = this.bvv.bvz;
    object = new StringBuilder();
    object.append((String)map.get("nSpareField2"));
    object.append("");
    textView1.setText(object.toString());
    this.bvv.bvA.setText(z.bh((String)map.get("nConsumeTime"), this.bvu.getString(R.string.pos_pos_SimpleDateFormatDay)));
    this.bvv.bvB.setText(c.cN((String)map.get("sSpareField1")));
    textView1 = this.bvv.bvC;
    object = new StringBuilder();
    object.append((String)map.get("sContactMobilePhone"));
    object.append("");
    textView1.setText(by.G(object.toString(), 11));
    textView1 = this.bvv.bvD;
    object = new StringBuilder();
    object.append((String)map.get("sNumber"));
    object.append("");
    textView1.setText(by.I(object.toString(), 11));
    this.bvv.bvE.setText(by.J((String)map.get("sName"), 12));
    textView1 = this.bvv.bvF;
    object = new StringBuilder();
    object.append("");
    object.append(paramInt + 1);
    textView1.setText(object.toString());
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    if (paramView == null) {
      this.bvv = new a(this);
      paramView = ((LayoutInflater)this.bvu.getSystemService("layout_inflater")).inflate(R.layout.pos_member_listview_item, null);
      this.bvv.bvw = (TextView)paramView.findViewById(R.id.tv_points);
      this.bvv.bvx = (TextView)paramView.findViewById(R.id.tv_balance);
      this.bvv.bvy = (TextView)paramView.findViewById(R.id.tv_total_consume);
      this.bvv.bvz = (TextView)paramView.findViewById(R.id.tv_consume_times);
      this.bvv.bvA = (TextView)paramView.findViewById(R.id.tv_latest_consume);
      this.bvv.bvB = (TextView)paramView.findViewById(R.id.tv_birthday);
      this.bvv.bvC = (TextView)paramView.findViewById(R.id.tv_mobile_phone);
      this.bvv.bvD = (TextView)paramView.findViewById(R.id.tv_card_number);
      this.bvv.bvE = (TextView)paramView.findViewById(R.id.tv_member_name);
      this.bvv.bvF = (TextView)paramView.findViewById(R.id.tv_serial_number);
      this.bvv.buG = paramView.findViewById(R.id.bg);
      paramView.setTag(this.bvv);
    } else {
      this.bvv = (a)paramView.getTag();
    } 
    fe(paramInt);
    this.bvv.buG.setActivated(ck.ml(paramInt));
    return paramView;
  }
  
  class a {
    View buG;
    
    TextView bvA;
    
    TextView bvB;
    
    TextView bvC;
    
    TextView bvD;
    
    TextView bvE;
    
    TextView bvF;
    
    TextView bvw;
    
    TextView bvx;
    
    TextView bvy;
    
    TextView bvz;
    
    a(ax this$0) {}
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */