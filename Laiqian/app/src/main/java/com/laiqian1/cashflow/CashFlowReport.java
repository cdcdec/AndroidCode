package com.laiqian.cashflow;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.laiqian.cashflow.a.c;
import com.laiqian.cashflow.a.e;
import com.laiqian.cashflow.b.b;
import com.laiqian.cashflow.b.c;
import com.laiqian.pos.industry.setting.n;
import com.laiqian.report.models.u;
import com.laiqian.report.ui.ReportRoot;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.a.bc;
import com.laiqian.ui.a.g;
import com.laiqian.util.bd;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CashFlowReport extends ReportRoot {
  private g<e> aJL;
  
  private g<c> aJM;
  
  private c aJN;
  
  private final int aJO = 111;
  
  private final int aJP = 112;
  
  private void AA() {
    ViewGroup viewGroup = getTitleRightCustomize();
    View view = View.inflate(this, 2131427979, null);
    view.findViewById(2131299266).setOnClickListener(new q(this));
    view.findViewById(2131299252).setOnClickListener(new r(this));
    view.findViewById(2131299251).setOnClickListener(new t(this, view));
    viewGroup.addView(view);
  }
  
  private void AE() {
    List list = c.AY();
    list.add(0, (new e.a(0L)).bL(getString(2131627764)).AV());
    this.aJL = new g(this, list, new w(this));
    TextView textView = (new ReportRoot.a(this, 2131627766, new x(this))).aov();
    this.aJL.b(textView, 0);
    this.aJN = new c(this);
    ReportRoot.a a = new ReportRoot.a(this, 2131627765, new y(this));
    AF();
    this.aJM.b(a.aov(), 0);
  }
  
  private void AF() {
    List list1 = this.aJN.bG("300002");
    List list2 = this.aJN.bG("300001");
    ArrayList arrayList = new ArrayList();
    arrayList.addAll(list1);
    arrayList.addAll(list2);
    null = (new c.a(0L)).bK(getString(2131627764)).AU();
    arrayList.add(0, null);
    list1.add(0, null);
    list2.add(0, null);
    ArrayList[] arrayOfArrayList = new ArrayList[3];
    arrayOfArrayList[0] = arrayList;
    arrayOfArrayList[1] = list1;
    arrayOfArrayList[2] = list2;
    if (this.aJM == null) {
      this.aJM = new g(this, arrayOfArrayList, new z(this));
      return;
    } 
    this.aJM.a(arrayOfArrayList);
  }
  
  private void AH() {
    this.dfW = new ReportRoot.j(this, 2131627773, new int[] { 2131627772, 2131627771 });
    this.dfW.p(new int[] { 0, 2131099768, 2131099865 });
    this.bWY.addHeaderView(this.dfW.getView());
    View view1 = View.inflate(this, 2131427978, null);
    view1.findViewById(2131297758).setVisibility(0);
    View view2 = view1.findViewById(2131297292);
    view2.setBackgroundResource(2131099932);
    TextView textView2 = (TextView)view2.findViewById(2131296842);
    textView2.setText(2131627768);
    textView2.setTextColor(getResources().getColor(2131099872));
    textView2 = (TextView)view2.findViewById(2131298198);
    textView2.setText(2131627769);
    textView2.setTextColor(getResources().getColor(2131099872));
    TextView textView1 = (TextView)view2.findViewById(2131296351);
    textView1.setText(2131627767);
    textView1.setTextColor(getResources().getColor(2131099872));
    this.bWY.addHeaderView(view1);
    this.bWY.setAdapter(new a(this, new ArrayList(), null));
    this.bWY.setEmptyView(findViewById(2131298220));
  }
  
  private boolean checkNetwork() {
    boolean bool = bd.bH(getActivity());
    if (!bool)
      (new bc(getActivity())).show(); 
    return bool;
  }
  
  private void sync() {
    if (!checkNetwork())
      return; 
    n n = new n(getActivity(), true);
    n.show();
    n.a(new v(this));
  }
  
  protected void AB() { super.AB(); }
  
  protected void AC() {}
  
  protected void AD() { this.bvO = new bb(this); }
  
  protected void AG() {
    this.aJL.kR(0);
    this.aJM.kR(0);
  }
  
  @NonNull
  protected u AI() { return new b(this); }
  
  protected void AJ() {
    b(null);
    aaQ();
    gE(true);
    (new ReportRoot.d(this, true)).aow().start();
  }
  
  protected void a(u paramu) {
    long l1;
    super.a(paramu);
    null = (e)this.aJL.arr();
    long l2 = 0L;
    if (null == null) {
      l1 = 0L;
    } else {
      l1 = null.getID();
    } 
    b b = (b)paramu;
    b.M(l1);
    c c1 = (c)this.aJM.arr();
    if (c1 == null) {
      l1 = l2;
    } else {
      l1 = c1.getID();
    } 
    b.N(l1);
  }
  
  protected void a(boolean paramBoolean, ArrayList<HashMap<String, String>> paramArrayList, int paramInt) { b(paramBoolean, paramArrayList, paramInt); }
  
  protected void b(double[] paramArrayOfDouble) {
    if (paramArrayOfDouble == null) {
      this.dfW.y(new String[0]);
    } else {
      this.dfW.y(new String[] { n.a(this, Double.valueOf(paramArrayOfDouble[0]), true, true), n.a(this, Double.valueOf(paramArrayOfDouble[1]), true, true), n.a(this, Double.valueOf(paramArrayOfDouble[2]), true, true) });
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("这里是设置总金额:");
    stringBuilder.append(Arrays.toString(paramArrayOfDouble));
    n.println(stringBuilder.toString());
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
      return; 
    switch (paramInt1) {
      default:
        return;
      case 112:
        AJ();
        return;
      case 111:
        break;
    } 
    AF();
    this.aJM.kR(0);
    AJ();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setTitleTextViewHideRightView(2131627763);
    n(3, false);
    jY(0);
    a(null, null, 0);
    AA();
    AE();
    AH();
    AJ();
  }
  
  protected void onDestroy() {
    super.onDestroy();
    if (this.aJN != null)
      this.aJN.close(); 
  }
  
  private class a extends ReportRoot.i {
    private a(CashFlowReport this$0, ArrayList<HashMap<String, String>> param1ArrayList) { super(this$0, param1ArrayList, 2131427978, new String[] { "dateTime", "name", "amount" }, new int[] { 2131296842, 2131298198, 2131296351 }); }
    
    protected boolean AK() { return true; }
    
    public ReportRoot.i.a bJ(View param1View) { return null; }
    
    protected void i(HashMap<String, String> param1HashMap) {
      long l = n.parseLong((String)param1HashMap.get("id"));
      if (l <= 0L) {
        n.o("交易记录ID为0");
        return;
      } 
      Intent intent = new Intent(this.aJQ, CashFlowDetailActivity.class);
      intent.putExtra("id", l);
      this.aJQ.startActivityForResult(intent, 112);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\cashflow\CashFlowReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */