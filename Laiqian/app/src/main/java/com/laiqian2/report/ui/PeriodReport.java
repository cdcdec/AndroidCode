package com.laiqian.report.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.laiqian.report.models.n;
import com.laiqian.report.models.u;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PeriodReport extends ReportRoot {
  private View ddJ;
  
  private TextView dek;
  
  private TextView del;
  
  private TextView dem;
  
  private void AH() {
    this.ddJ = View.inflate(this, 2131427985, null);
    this.ddJ.findViewById(2131299098).setVisibility(0);
    this.dek = (TextView)this.ddJ.findViewById(2131299102);
    this.del = (TextView)this.ddJ.findViewById(2131299097);
    this.dem = (TextView)this.ddJ.findViewById(2131299093);
    ((TextView)this.ddJ.findViewById(2131299104)).setText(2131627913);
    ((TextView)this.ddJ.findViewById(2131299099)).setText(2131627915);
    ((TextView)this.ddJ.findViewById(2131299095)).setText(2131627912);
    this.bWY.addHeaderView(this.ddJ);
    this.bWY.setAdapter(new a(this, new ArrayList()));
    this.bWY.setEmptyView(findViewById(2131298220));
  }
  
  private boolean x(HashMap<String, String> paramHashMap) { return u.x(paramHashMap); }
  
  @NonNull
  protected u AI() { return new n(this); }
  
  protected void AJ() {
    n.println("这里是showData()");
    b(null);
    aaQ();
    gE(true);
    (new ReportRoot.d(this, true)).aow().start();
  }
  
  protected void a(boolean paramBoolean, ArrayList<HashMap<String, String>> paramArrayList, int paramInt) { b(paramBoolean, paramArrayList, paramInt); }
  
  protected boolean anD() {
    if (aom() == 2) {
      startActivityForResult(new Intent(this, PeriodProductReport.class), 11);
      return true;
    } 
    return super.anD();
  }
  
  protected void b(double[] paramArrayOfDouble) {
    if (paramArrayOfDouble == null) {
      this.ddJ.setVisibility(8);
    } else {
      this.ddJ.setVisibility(0);
      this.dek.setText(n.d(Double.valueOf(paramArrayOfDouble[0])));
      this.del.setText(n.d(Double.valueOf(paramArrayOfDouble[2])));
      this.dem.setText(n.d(Double.valueOf(paramArrayOfDouble[1])));
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("这里是设置总金额:");
    stringBuilder.append(Arrays.toString(paramArrayOfDouble));
    n.println(stringBuilder.toString());
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
      finish(); 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setTitleTextViewHideRightView(2131627927);
    n(0, true);
    jY(1);
    AH();
    a(getResources().getStringArray(2130903079), new int[] { 1, 2 }, 1);
    AJ();
  }
  
  private class a extends ReportRoot.i {
    public a(PeriodReport this$0, ArrayList<HashMap<String, String>> param1ArrayList) { super(this$0, param1ArrayList, 2131427991, null, null); }
    
    public void a(ReportRoot.i.a param1a, View param1View, HashMap<String, String> param1HashMap, int param1Int) {
      super.a(param1a, param1View, param1HashMap, param1Int);
      param1a = (a)param1a;
      if (PeriodReport.a(this.dfo, param1HashMap)) {
        param1a.dfp.setVisibility(0);
        param1a.dft.setVisibility(0);
        param1a.dfu.setVisibility(8);
        param1a.dfq.setText((CharSequence)param1HashMap.get("day"));
        param1a.dfr.setText((CharSequence)param1HashMap.get("week"));
        param1a.dfs.setText((CharSequence)param1HashMap.get("amount"));
        return;
      } 
      param1a.dfp.setVisibility(8);
      param1a.dft.setVisibility(8);
      param1a.dfu.setVisibility(0);
      param1a.dfv.setText((CharSequence)param1HashMap.get(n.dam));
      param1a.dfw.setText((CharSequence)param1HashMap.get(n.dag));
      param1a.dfx.setText((CharSequence)param1HashMap.get(n.daD));
      param1a.dfy.setText((CharSequence)param1HashMap.get(n.daP));
      param1a.dfz.setText((CharSequence)param1HashMap.get(n.bzY));
    }
    
    public ReportRoot.i.a bJ(View param1View) {
      View view1 = param1View.findViewById(2131297200);
      view1.setEnabled(false);
      TextView textView1 = (TextView)view1.findViewById(2131296847);
      TextView textView2 = (TextView)view1.findViewById(2131300026);
      TextView textView3 = (TextView)view1.findViewById(2131296362);
      View view2 = param1View.findViewById(2131297192);
      param1View = param1View.findViewById(2131298724);
      return new a(this, view1, textView1, textView2, textView3, view2, param1View, (TextView)param1View.findViewById(2131299228), (TextView)param1View.findViewById(2131298319), (TextView)param1View.findViewById(2131298606), (TextView)param1View.findViewById(2131298473), (TextView)param1View.findViewById(2131296351));
    }
    
    class a extends ReportRoot.i.a {
      View dfp;
      
      TextView dfq;
      
      TextView dfr;
      
      TextView dfs;
      
      View dft;
      
      View dfu;
      
      TextView dfv;
      
      TextView dfw;
      
      TextView dfx;
      
      TextView dfy;
      
      TextView dfz;
      
      public a(PeriodReport.a this$0, View param2View1, TextView param2TextView1, TextView param2TextView2, TextView param2TextView3, View param2View2, View param2View3, TextView param2TextView4, TextView param2TextView5, TextView param2TextView6, TextView param2TextView7, TextView param2TextView8) {
        super(this$0);
        this.dfp = param2View1;
        this.dfq = param2TextView1;
        this.dfr = param2TextView2;
        this.dfs = param2TextView3;
        this.dft = param2View2;
        this.dfu = param2View3;
        this.dfv = param2TextView4;
        this.dfw = param2TextView5;
        this.dfx = param2TextView6;
        this.dfy = param2TextView7;
        this.dfz = param2TextView8;
      }
    }
  }
  
  class a extends ReportRoot.i.a {
    View dfp;
    
    TextView dfq;
    
    TextView dfr;
    
    TextView dfs;
    
    View dft;
    
    View dfu;
    
    TextView dfv;
    
    TextView dfw;
    
    TextView dfx;
    
    TextView dfy;
    
    TextView dfz;
    
    public a(PeriodReport this$0, View param1View1, TextView param1TextView1, TextView param1TextView2, TextView param1TextView3, View param1View2, View param1View3, TextView param1TextView4, TextView param1TextView5, TextView param1TextView6, TextView param1TextView7, TextView param1TextView8) {
      super(this$0);
      this.dfp = param1View1;
      this.dfq = param1TextView1;
      this.dfr = param1TextView2;
      this.dfs = param1TextView3;
      this.dft = param1View2;
      this.dfu = param1View3;
      this.dfv = param1TextView4;
      this.dfw = param1TextView5;
      this.dfx = param1TextView6;
      this.dfy = param1TextView7;
      this.dfz = param1TextView8;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\PeriodReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */