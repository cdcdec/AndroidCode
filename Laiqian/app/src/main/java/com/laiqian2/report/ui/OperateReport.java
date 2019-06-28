package com.laiqian.report.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import com.laiqian.report.models.k;
import com.laiqian.report.models.u;
import java.util.ArrayList;
import java.util.HashMap;

public class OperateReport extends ReportRoot {
  private void AH() {
    View view1 = View.inflate(this, 2131427731, null);
    view1.setClickable(true);
    this.bWY.addHeaderView(view1);
    view1 = View.inflate(this, 2131427990, null);
    View view2 = view1.findViewById(2131298724);
    view2.setBackgroundResource(2131231815);
    view2.setEnabled(false);
    this.bWY.addHeaderView(view1);
    this.bWY.setAdapter(new a(this, new ArrayList()));
    this.bWY.setEmptyView(findViewById(2131298220));
  }
  
  @NonNull
  protected u AI() { return new k(this); }
  
  protected void AJ() {
    if (getLaiqianPreferenceManager().atC())
      getLaiqianPreferenceManager().ht(false); 
    aaQ();
    gE(true);
    (new ReportRoot.d(this, true)).start();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setTitleTextViewHideRightView(2131627909);
    n(3, true);
    jY(1);
    AH();
    a(null, null, 0);
    AJ();
  }
  
  private class a extends ReportRoot.i {
    public a(OperateReport this$0, ArrayList<HashMap<String, String>> param1ArrayList) { super(this$0, param1ArrayList, 2131427990, new String[] { "day", k.bzY, k.dag, k.dah, k.daD, k.daE, k.daF }, new int[] { 2131296826, 2131296351, 2131296824, 2131296825, 2131296808, 2131296809, 2131296810 }); }
    
    public ReportRoot.i.a bJ(View param1View) { return new ReportRoot.i.a(this); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\OperateReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */