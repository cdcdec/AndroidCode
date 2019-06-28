package com.laiqian.report.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.laiqian.report.models.u;
import com.laiqian.report.models.y;
import com.laiqian.util.av;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ShiftReport extends ReportRoot {
  private View ddJ;
  
  private TextView ddL;
  
  private TextView ddP;
  
  private TextView dhj;
  
  private TextView dhk;
  
  private void AH() {
    View view = View.inflate(this, 2131427985, null);
    this.ddJ = view.findViewById(2131299101);
    this.ddL = (TextView)this.ddJ.findViewById(2131299102);
    ((TextView)this.ddJ.findViewById(2131299104)).setText(2131627963);
    ((TextView)this.ddJ.findViewById(2131299095)).setText(2131630098);
    this.ddP = (TextView)this.ddJ.findViewById(2131299093);
    this.bWY.addHeaderView(view);
    view = View.inflate(this, 2131428006, null);
    view.setEnabled(false);
    this.dhj = (TextView)view.findViewById(2131299228);
    this.dhk = (TextView)view.findViewById(2131296351);
    q(null);
    this.bWY.addHeaderView(view);
    this.bWY.setAdapter(new a(this, new ArrayList()));
    this.bWY.setEmptyView(findViewById(2131298220));
  }
  
  private void aoB() {
    av av = new av(this);
    String str = av.atm();
    av.close();
    di(Long.parseLong(str));
  }
  
  private void q(CharSequence paramCharSequence) {
    if (paramCharSequence == null) {
      this.dhj.setText(2131627967);
      this.dhk.setVisibility(0);
      return;
    } 
    this.dhj.setText(paramCharSequence);
    this.dhk.setVisibility(8);
  }
  
  @NonNull
  protected u AI() { return new y(this); }
  
  protected void AJ() {
    n.println("这里是showData()");
    if (getLaiqianPreferenceManager().atC())
      getLaiqianPreferenceManager().ht(false); 
    b(null);
    aaQ();
    gE(true);
    (new ReportRoot.d(this, true)).aow().start();
    if (this.bKe > 0L) {
      q(aor());
      return;
    } 
    q(null);
  }
  
  protected String Td() {
    y y = new y(this);
    String str = y.a(null, this.bqs[0], this.bqs[1], this.bKe, this.cPh, this.dgH, aor(), null);
    this.dfV.b(this.bqs[0], this.bqs[1], getString(2131627841));
    y.close();
    return str;
  }
  
  protected void X(HashMap<String, String> paramHashMap) {
    String str;
    if (this.bKe > 0L) {
      str = "1";
    } else {
      str = "0";
    } 
    paramHashMap.put("hasUser", str);
  }
  
  protected void a(boolean paramBoolean, ArrayList<HashMap<String, String>> paramArrayList, int paramInt) { b(paramBoolean, paramArrayList, paramInt); }
  
  protected ArrayList<HashMap<String, String>> aok() { return this.dfV.anq(); }
  
  protected void b(double[] paramArrayOfDouble) {
    if (paramArrayOfDouble == null) {
      this.ddJ.setVisibility(4);
    } else {
      this.ddJ.setVisibility(0);
      this.ddL.setText(n.b(this, Double.valueOf(paramArrayOfDouble[0]), false));
      this.ddP.setText(n.a(this, Double.valueOf(paramArrayOfDouble[1]), true, true));
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("这里是设置总金额:");
    stringBuilder.append(Arrays.toString(paramArrayOfDouble));
    n.println(stringBuilder.toString());
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setTitleTextViewHideRightView(2131627959);
    n(3, false);
    AH();
    a(null, null, 0);
    jY(1);
    aoB();
    AJ();
  }
  
  private class a extends ReportRoot.i {
    public a(ShiftReport this$0, ArrayList<HashMap<String, String>> param1ArrayList) { super(this$0, param1ArrayList, 2131428006, new String[] { y.dci, y.dck }, new int[] { 2131299228, 2131296351 }); }
    
    protected boolean AK() { return true; }
    
    public ReportRoot.i.a bJ(View param1View) { return new ReportRoot.i.a(this); }
    
    protected void i(HashMap<String, String> param1HashMap) {
      long l = n.parseLong((String)param1HashMap.get("shiftEndTime"));
      if (l > 0L)
        this.dhl.startActivity((new Intent(this.dhl, ShiftDetails.class)).putExtra("shiftEndTime", l)); 
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\ShiftReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */