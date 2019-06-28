package com.laiqian.report.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.report.models.u;
import com.laiqian.report.models.x;
import com.laiqian.util.bd;
import com.laiqian.util.by;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.HashMap;

public class ReturnModeReport extends ReportRoot {
  private View dhe;
  
  private boolean dhf = "150001".equals(CrashApplication.getLaiqianPreferenceManager().atp());
  
  private TextView tvTableNumber;
  
  private void AH() {
    this.bWY.setAdapter(new a(this, new ArrayList()));
    View view = findViewById(2131298220);
    if (view instanceof ViewGroup) {
      ViewGroup viewGroup = (ViewGroup)view;
      View view1 = View.inflate(this, 2131427989, null);
      viewGroup.addView(view1);
      view1.findViewById(2131297074).setOnClickListener(new bz(this));
    } 
    this.bWY.setEmptyView(view);
  }
  
  private void aox() {
    View view = View.inflate(this, 2131428003, getTitleRightCustomize());
    this.dhe = view.findViewById(2131296773);
    this.dhe.setVisibility(8);
    this.dhe.setOnClickListener(new ca(this));
    this.tvTableNumber = (TextView)view.findViewById(2131299142);
    this.tvTableNumber.addTextChangedListener(new cb(this));
  }
  
  @NonNull
  protected u AI() {
    x x = new x(this);
    if (!this.dhf)
      x.anz(); 
    return x;
  }
  
  protected void AJ() {
    n.println("这里是showData()");
    aaQ();
    gE(true);
    (new ReportRoot.d(this, true)).start();
  }
  
  protected void a(u paramu) {
    super.a(paramu);
    String str = this.tvTableNumber.getText().toString().trim();
    ((x)paramu).nr(str);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setTitleTextViewHideRightView(2131628152);
    n(0, true);
    jY(3);
    AH();
    aox();
    a(null, null, 0);
    AJ();
  }
  
  class a extends ReportRoot.i {
    a(ReturnModeReport this$0, ArrayList<HashMap<String, String>> param1ArrayList) { super(this$0, param1ArrayList, 2131428002, new String[] { "tableNumber", "products", "dateTime", "accounts" }, new int[] { 2131299159, 2131298607, 2131296843, 2131298375 }); }
    
    protected boolean AK() { return true; }
    
    public ReportRoot.i.a bJ(View param1View) { return null; }
    
    protected void i(HashMap<String, String> param1HashMap) {
      super.i(param1HashMap);
      if (this.dhg.getLaiqianPreferenceManager().Wq() && !bd.bH(this.dhg) && by.parseLong((String)param1HashMap.get("partnerID")) > 0L) {
        n.eP(2131628452);
        return;
      } 
      Bundle bundle = new Bundle();
      bundle.putString("orderNo", (String)param1HashMap.get("orderNo"));
      bundle.putString("ORDERTIME", (String)param1HashMap.get("ORDERTIME"));
      n.a(this.dhg, OrderDetailsByReturn.class, bundle);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\ReturnModeReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */