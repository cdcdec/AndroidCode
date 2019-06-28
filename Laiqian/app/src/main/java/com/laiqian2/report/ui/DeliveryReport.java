package com.laiqian.report.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.entity.ap;
import com.laiqian.report.b.b;
import com.laiqian.report.models.g;
import com.laiqian.report.models.u;
import com.laiqian.takeaway.am;
import com.laiqian.ui.a.aq;
import com.laiqian.ui.a.g;
import com.laiqian.util.by;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DeliveryReport extends ReportRoot {
  public static final String dep = CrashApplication.zv().getString(2131627820);
  
  private View ddJ;
  
  private TextView dek;
  
  private TextView del;
  
  private TextView dem;
  
  private TextView den;
  
  private TextView deo;
  
  @Nullable
  private aq<b> deq;
  
  aq<ap> der;
  
  g des;
  
  private void AH() {
    View view1 = View.inflate(this, 2131427731, null);
    view1.setClickable(true);
    this.ddJ = View.inflate(this, 2131427985, null);
    this.ddJ.findViewById(2131299098).setVisibility(8);
    this.dek = (TextView)this.ddJ.findViewById(2131299102);
    this.del = (TextView)this.ddJ.findViewById(2131299097);
    this.dem = (TextView)this.ddJ.findViewById(2131299093);
    this.del.setVisibility(8);
    ((TextView)this.ddJ.findViewById(2131299104)).setText(2131627913);
    ((TextView)this.ddJ.findViewById(2131299099)).setText(2131627915);
    ((TextView)this.ddJ.findViewById(2131299095)).setText(2131628041);
    this.bWY.addHeaderView(this.ddJ);
    this.bWY.addHeaderView(view1);
    view1 = View.inflate(this, 2131427980, null);
    View view2 = view1.findViewById(2131298724);
    view2.setBackgroundResource(2131231815);
    view2.setEnabled(false);
    this.bWY.addHeaderView(view1);
    this.bWY.setAdapter(new a(this, new ArrayList()));
    this.bWY.setEmptyView(findViewById(2131298220));
  }
  
  private void anO() {
    ArrayList arrayList = new ArrayList();
    arrayList.add(new b(-1L, getString(2131628048), ""));
    arrayList.add(new b(0L, getString(2131626109), "86003"));
    arrayList.add(new b(5L, getString(2131626084), "86003"));
    arrayList.add(new b(8L, getString(2131626067), "86003"));
    arrayList.add(new b(86004L, getString(2131626080), "86003"));
    arrayList.add(new b(9L, getString(2131626082), "86003"));
    this.deq = new g(this, arrayList, new m(this));
    this.deq.dn(5L);
    this.deo = (new ReportRoot.a(this, 2131624990, new n(this), false, true)).aov();
    this.deo.setText("Phone Order");
    this.deo.setTextColor(getResources().getColor(2131099865));
  }
  
  private void anP() {
    ArrayList arrayList = (new am(getActivity())).aqB();
    arrayList.add(0, new ap(-1L, "All", ""));
    this.der = new g(this, arrayList, new o(this));
    this.der.kR(0);
    this.den = (new ReportRoot.a(this, 2131624988, new p(this), false, true)).aov();
    this.den.setText("All");
    this.den.setTextColor(getResources().getColor(2131099865));
  }
  
  @NonNull
  protected u AI() {
    this.des = new g(this);
    return this.des;
  }
  
  protected void AJ() {
    if (getLaiqianPreferenceManager().atC())
      getLaiqianPreferenceManager().ht(false); 
    b(null);
    aaQ();
    gE(true);
    (new ReportRoot.d(this, true)).aow().start();
  }
  
  protected void a(boolean paramBoolean, ArrayList<HashMap<String, String>> paramArrayList, int paramInt) { b(paramBoolean, paramArrayList, paramInt); }
  
  protected boolean anQ() {
    boolean bool;
    long l = this.des.daw;
    this.des.getClass();
    if (l != -1L)
      return true; 
    if (this.bqs[1] - this.bqs[0] <= 86400000L) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool)
      return true; 
    Toast.makeText(this, dep, 1).show();
    return false;
  }
  
  protected void b(double[] paramArrayOfDouble) {
    if (paramArrayOfDouble == null) {
      this.ddJ.setVisibility(8);
    } else {
      this.ddJ.setVisibility(0);
      this.dek.setText(n.b(this, Double.valueOf(paramArrayOfDouble[0]), false));
      this.dem.setText(n.a(this, Double.valueOf(paramArrayOfDouble[1]), true, true));
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("这里是设置总金额:");
    stringBuilder.append(Arrays.toString(paramArrayOfDouble));
    n.println(stringBuilder.toString());
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setTitleTextViewHideRightView(2131624989);
    n(0, true);
    jY(0);
    anO();
    anP();
    AH();
    a(null, null, 0);
    AJ();
    this.bzp.setOnClickListener(new j(this));
    this.dgl.setOnClickListener(new k(this));
  }
  
  private class a extends ReportRoot.i {
    public a(DeliveryReport this$0, ArrayList<HashMap<String, String>> param1ArrayList) { super(this$0, param1ArrayList, 2131427980, new String[] { g.dae, g.daf, g.dag, g.dah }, new int[] { 2131296863, 2131296301, 2131296824, 2131296351 }); }
    
    protected boolean AK() { return true; }
    
    public ReportRoot.i.a bJ(View param1View) { return new ReportRoot.i.a(this); }
    
    protected void i(HashMap<String, String> param1HashMap) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("record:");
      stringBuilder.append(param1HashMap);
      n.println(stringBuilder.toString());
      try {
        if (by.parseInt((String)param1HashMap.get(g.dag)) > 0) {
          Intent intent = new Intent();
          intent.setClass(this.det, TransactionReport.class);
          intent.putExtra("deliveryUserID", (String)param1HashMap.get("userID"));
          intent.putExtra("deliveryUserName", (String)param1HashMap.get(g.dae));
          intent.putExtra("DateTimeItemOfSelectDialog", this.det.aon());
          intent.putExtra("StartEndDateEntity", this.det.aoo());
          intent.putExtra("orderType", this.det.des.dau);
          this.det.startActivity(intent);
          return;
        } 
      } catch (Exception param1HashMap) {
        a.e(param1HashMap);
      } 
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\DeliveryReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */