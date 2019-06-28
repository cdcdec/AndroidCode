package com.laiqian.report.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.laiqian.report.models.r;
import com.laiqian.report.models.u;
import java.util.ArrayList;
import java.util.HashMap;

public class RawMaterialReportActivity extends ReportRoot {
  View dfM;
  
  private void AH() {
    View view1 = View.inflate(this, 2131428001, null);
    view1.setClickable(true);
    ar ar = new ar(this);
    this.dfM = view1.findViewById(2131299083);
    View view2 = view1.findViewById(2131298198);
    view2.setTag("productName");
    view2.setOnClickListener(ar);
    view2 = view1.findViewById(2131298828);
    view2.setTag("salesQty");
    view2.setOnClickListener(ar);
    view2 = view1.findViewById(2131297271);
    view2.setTag("inQty");
    view2.setOnClickListener(ar);
    view2 = view1.findViewById(2131298335);
    view2.setTag("outQty");
    view2.setOnClickListener(ar);
    view2 = view1.findViewById(2131296763);
    view2.setTag("checkQty");
    view2.setOnClickListener(ar);
    this.dfM.setTag("stockQty");
    this.dfM.setOnClickListener(ar);
    this.bWY.addHeaderView(view1);
    this.bWY.setAdapter(new a(this, new ArrayList()));
    this.bWY.setEmptyView(findViewById(2131298220));
  }
  
  @NonNull
  protected u AI() { return new r(this); }
  
  protected void AJ() {
    aaQ();
    gE(true);
    if (this.bqO == 0) {
      this.dfM.setVisibility(0);
    } else {
      this.dfM.setVisibility(8);
    } 
    (new ReportRoot.d(this, true)).start();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setTitleTextViewHideRightView(2131627585);
    n(0, true);
    jY(0);
    a(null, null, 0);
    AH();
    AJ();
  }
  
  private class a extends ReportRoot.i {
    public a(RawMaterialReportActivity this$0, ArrayList<HashMap<String, String>> param1ArrayList) { super(this$0, param1ArrayList, 2131428000, new String[] { "productName", "salesQty", "inQty", "outQty", "unitName" }, new int[] { 2131298198, 2131298828, 2131297271, 2131298335, 2131299899 }); }
    
    public void a(ReportRoot.i.a param1a, View param1View, HashMap<String, String> param1HashMap, int param1Int) {
      boolean bool;
      super.a(param1a, param1View, param1HashMap, param1Int);
      String str = (String)param1HashMap.get("checkQty");
      param1a = (a)param1a;
      TextView textView2 = param1a.dfO;
      textView2.setText(str);
      textView2.setSelected(str.startsWith("-"));
      if (param1Int % 2 != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      param1View.setEnabled(bool);
      TextView textView1 = param1a.dfP;
      View view = param1a.dfQ;
      if (this.dfN.bqO == 0) {
        textView1.setText((String)param1HashMap.get("stockQty"));
        textView1.setVisibility(0);
        view.setVisibility(0);
        return;
      } 
      textView1.setVisibility(8);
      view.setVisibility(8);
    }
    
    public ReportRoot.i.a bJ(View param1View) {
      param1View.setOnClickListener(null);
      param1View.setClickable(false);
      return new a(this, (TextView)param1View.findViewById(2131296763), (TextView)param1View.findViewById(2131299083), param1View.findViewById(2131299084));
    }
    
    class a extends ReportRoot.i.a {
      TextView dfO;
      
      TextView dfP;
      
      View dfQ;
      
      public a(RawMaterialReportActivity.a this$0, TextView param2TextView1, TextView param2TextView2, View param2View) {
        super(this$0);
        this.dfO = param2TextView1;
        this.dfP = param2TextView2;
        this.dfQ = param2View;
      }
    }
  }
  
  class a extends ReportRoot.i.a {
    TextView dfO;
    
    TextView dfP;
    
    View dfQ;
    
    public a(RawMaterialReportActivity this$0, TextView param1TextView1, TextView param1TextView2, View param1View) {
      super(this$0);
      this.dfO = param1TextView1;
      this.dfP = param1TextView2;
      this.dfQ = param1View;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\RawMaterialReportActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */