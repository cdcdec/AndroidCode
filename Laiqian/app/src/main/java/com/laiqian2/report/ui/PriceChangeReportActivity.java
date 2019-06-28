package com.laiqian.report.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.laiqian.report.models.h;
import com.laiqian.report.models.u;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.HashMap;

public class PriceChangeReportActivity extends ReportRoot {
  private TextView bqm;
  
  private TextView dfB;
  
  private View view;
  
  private void AH() {
    this.view = View.inflate(this, 2131427985, null);
    this.bqm = (TextView)this.view.findViewById(2131299102);
    this.dfB = (TextView)this.view.findViewById(2131299093);
    ((TextView)this.view.findViewById(2131299104)).setText(2131629301);
    ((TextView)this.view.findViewById(2131299095)).setText(2131629297);
    this.bWY.addHeaderView(this.view);
    this.bWY.setAdapter(new a(this, new ArrayList()));
    this.bWY.setEmptyView(findViewById(2131298220));
  }
  
  @NonNull
  protected u AI() { return new h(this); }
  
  protected void AJ() {
    b(null);
    aaQ();
    gE(true);
    (new ReportRoot.d(this, true)).aow().start();
  }
  
  protected void a(boolean paramBoolean, ArrayList<HashMap<String, String>> paramArrayList, int paramInt) { b(paramBoolean, paramArrayList, paramInt); }
  
  protected void b(double[] paramArrayOfDouble) {
    if (paramArrayOfDouble == null) {
      this.view.setVisibility(8);
      return;
    } 
    this.view.setVisibility(0);
    this.bqm.setText(n.d(Double.valueOf(paramArrayOfDouble[0])));
    this.dfB.setText(n.d(Double.valueOf(paramArrayOfDouble[1])));
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setTitleTextViewHideRightView(2131629304);
    n(0, true);
    AH();
    a(null, null, 0);
    jY(1);
    AJ();
  }
  
  private class a extends ReportRoot.i {
    public a(PriceChangeReportActivity this$0, ArrayList<HashMap<String, String>> param1ArrayList) { super(this$0, param1ArrayList, 2131427996, new String[] { h.dam, h.daB, h.bzY }, new int[] { 2131299228, 2131298607, 2131296351 }); }
    
    protected boolean AK() { return true; }
    
    public void a(ReportRoot.i.a param1a, View param1View, HashMap<String, String> param1HashMap, int param1Int) {
      param1a = (a)param1a;
      boolean bool = param1HashMap.containsKey("hideLine");
      param1Int = 8;
      if (!bool) {
        param1a.dfD.setVisibility(0);
        param1View.setEnabled(true);
      } else {
        param1a.dfD.setVisibility(8);
        param1View.setEnabled(param1HashMap.containsKey("isGroup") ^ true);
      } 
      if (param1View.isEnabled()) {
        param1a.dfF.setVisibility(8);
      } else {
        param1a.dfF.setVisibility(0);
        param1a.dfF.setText(this.dfC.getString(2131627991, new Object[] { n.pi((String)param1HashMap.get("childCount")) }));
      } 
      TextView textView = param1a.dfE;
      if (!"0".equals(param1HashMap.get("tmp_change_price")))
        param1Int = 0; 
      textView.setVisibility(param1Int);
    }
    
    public ReportRoot.i.a bJ(View param1View) {
      View view = param1View.findViewById(2131297745);
      TextView textView = (TextView)param1View.findViewById(2131300036);
      textView.setText(2131629303);
      return new a(this, view, textView, (TextView)param1View.findViewById(2131296768));
    }
    
    protected void i(HashMap<String, String> param1HashMap) {
      Bundle bundle = new Bundle();
      bundle.putString("orderNo", (String)param1HashMap.get("orderNo"));
      bundle.putString("ORDERTIME", (String)param1HashMap.get("ORDERTIME"));
      bundle.putBoolean("bIsMemberRecord", false);
      n.a(this.dfC, TransactionDetails.class, bundle);
    }
    
    class a extends ReportRoot.i.a {
      View dfD;
      
      TextView dfE;
      
      TextView dfF;
      
      public a(PriceChangeReportActivity.a this$0, View param2View, TextView param2TextView1, TextView param2TextView2) {
        super(this$0);
        this.dfD = param2View;
        this.dfE = param2TextView1;
        this.dfF = param2TextView2;
      }
    }
  }
  
  class a extends ReportRoot.i.a {
    View dfD;
    
    TextView dfE;
    
    TextView dfF;
    
    public a(PriceChangeReportActivity this$0, View param1View, TextView param1TextView1, TextView param1TextView2) {
      super(this$0);
      this.dfD = param1View;
      this.dfE = param1TextView1;
      this.dfF = param1TextView2;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\PriceChangeReportActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */