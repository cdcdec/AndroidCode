package com.laiqian.report.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.laiqian.report.models.ac;
import com.laiqian.report.models.u;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TaxReport extends ReportRoot {
  private View ddJ;
  
  private TextView dem;
  
  private void AH() {
    this.ddJ = View.inflate(this, 2131427985, null);
    this.ddJ.findViewById(2131299098).setVisibility(8);
    this.ddJ.findViewById(2131299103).setVisibility(8);
    View view1 = this.ddJ.findViewById(2131299094);
    ((TextView)view1.findViewById(2131299095)).setText(2131627984);
    this.dem = (TextView)view1.findViewById(2131299093);
    this.bWY.addHeaderView(this.ddJ);
    view1 = View.inflate(this, 2131428007, null);
    View view2 = view1.findViewById(2131298724);
    view2.setBackgroundResource(2131231815);
    view2.setEnabled(false);
    this.bWY.addHeaderView(view1);
    this.bWY.setAdapter(new a(this, new ArrayList()));
    this.bWY.setEmptyView(findViewById(2131298220));
  }
  
  @NonNull
  protected u AI() { return new ac(this); }
  
  protected void AJ() {
    n.println("这里是showData()");
    b(null);
    aaQ();
    gE(true);
    (new ReportRoot.d(this, true)).aow().start();
  }
  
  protected void a(boolean paramBoolean, ArrayList<HashMap<String, String>> paramArrayList, int paramInt) { b(paramBoolean, paramArrayList, paramInt); }
  
  protected void b(double[] paramArrayOfDouble) {
    if (paramArrayOfDouble == null) {
      this.ddJ.setVisibility(8);
    } else {
      this.ddJ.setVisibility(0);
      this.dem.setText(n.a(Double.valueOf(paramArrayOfDouble[1]), true, true));
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("这里是设置总金额:");
    stringBuilder.append(Arrays.toString(paramArrayOfDouble));
    n.println(stringBuilder.toString());
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setTitleTextViewHideRightView(2131627980);
    jY(1);
    n(0, true);
    a(null, null, 0);
    AH();
    AJ();
  }
  
  class a extends ReportRoot.i {
    public a(TaxReport this$0, ArrayList<HashMap<String, String>> param1ArrayList) { super(this$0, param1ArrayList, 2131428007, new String[] { ac.bHV, ac.dcs, ac.dct }, new int[] { 2131298198, 2131296354, 2131296355 }); }
    
    public ReportRoot.i.a bJ(View param1View) { return new ReportRoot.i.a(this); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\TaxReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */