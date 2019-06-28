package com.laiqian.report.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import com.laiqian.report.models.q;
import com.laiqian.report.models.u;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductReport extends ReportRoot {
  private View[] buT;
  
  private TextView dfH;
  
  private View[] dfI;
  
  private View dfJ;
  
  private View dfK;
  
  private void AH() {
    View view = View.inflate(this, 2131427731, null);
    view.setClickable(true);
    this.bWY.addHeaderView(view);
    view = View.inflate(this, 2131427999, null);
    cs(view);
    this.bWY.addHeaderView(view);
    this.bWY.setAdapter(new a(this, new ArrayList()));
    this.bWY.setEmptyView(findViewById(2131298220));
  }
  
  public static void a(Context paramContext, boolean paramBoolean, long paramLong) {
    Intent intent = new Intent(paramContext, ProductReport.class);
    intent.putExtra("extra_shift", paramBoolean);
    intent.putExtra("extra_user", paramLong);
    paramContext.startActivity(intent);
  }
  
  private void cs(View paramView) {
    ao ao = new ao(this);
    ap ap = new ap(this);
    View view3 = paramView.findViewById(2131298202);
    this.dfH = (TextView)view3.findViewById(2131297452);
    View view1 = view3.findViewById(2131299029);
    view1.setTag(" order by t_product.sText ");
    View view2 = view3.findViewById(2131299028);
    view2.setTag(" order by t_product.sText desc");
    byte b = 0;
    this.dfI = new View[] { view1, view2 };
    this.dfH.setTag(this.dfI);
    this.dfH.setOnClickListener(ao);
    view3.setTag(this.dfH);
    view3.setOnClickListener(ap);
    View view4 = paramView.findViewById(2131298645);
    view3 = view4.findViewById(2131299029);
    view3.setTag(" order by qty ");
    this.dfK = view4.findViewById(2131299028);
    this.dfK.setTag(" order by qty desc ");
    View view5 = this.dfK;
    View view6 = view4.findViewById(2131297452);
    view6.setTag(new View[] { view3, view5 });
    view6.setOnClickListener(ao);
    view4.setTag(view6);
    view4.setOnClickListener(ap);
    paramView = paramView.findViewById(2131296358);
    view4 = paramView.findViewById(2131299029);
    view4.setTag(" order by amount ");
    this.dfJ = paramView.findViewById(2131299028);
    this.dfJ.setTag(" order by amount desc ");
    view5 = this.dfJ;
    view6 = paramView.findViewById(2131297452);
    view6.setTag(new View[] { view4, view5 });
    view6.setOnClickListener(ao);
    paramView.setTag(view6);
    paramView.setOnClickListener(ap);
    this.buT = new View[] { view1, view2, view3, this.dfK, view4, this.dfJ };
    aq aq = new aq(this);
    while (b < this.buT.length) {
      this.buT[b].setOnClickListener(aq);
      b++;
    } 
    this.dfV.nm((String)this.dfJ.getTag());
    this.dfJ.setSelected(true);
  }
  
  @NonNull
  protected u AI() { return new q(this); }
  
  protected void AJ() {
    n.println("这里是com.laiqian.report.ui.ProductReport.showData()");
    if (getLaiqianPreferenceManager().atC())
      getLaiqianPreferenceManager().ht(false); 
    aaQ();
    switch (aom()) {
      default:
        n.o("统计方式错误");
        return;
      case 3:
        this.dfH.setText(2131627932);
        this.dfH.setClickable(true);
        this.dfI[0].setVisibility(0);
        this.dfI[1].setVisibility(0);
        break;
      case 2:
        this.dfH.setText(2131627455);
        this.dfH.setClickable(false);
        this.dfI[0].setVisibility(8);
        this.dfI[1].setVisibility(8);
        break;
      case 1:
        this.dfH.setText(2131627938);
        this.dfH.setClickable(false);
        this.dfI[0].setVisibility(8);
        this.dfI[1].setVisibility(8);
        break;
      case 0:
        this.dfH.setText(2131627933);
        this.dfH.setClickable(true);
        this.dfI[0].setVisibility(0);
        this.dfI[1].setVisibility(0);
        break;
    } 
    gE(true);
    (new ReportRoot.d(this, true)).start();
  }
  
  protected void X(HashMap<String, String> paramHashMap) {
    if (aom() == 0) {
      paramHashMap.put("type", n.x(this, 2131627947));
      return;
    } 
    if (aom() == 3) {
      paramHashMap.put("type", n.x(this, 2131627939));
      return;
    } 
    if (aom() == 1) {
      paramHashMap.put("type", n.x(this, 2131627954));
      return;
    } 
    if (aom() == 2)
      paramHashMap.put("type", n.x(this, 2131627455)); 
  }
  
  protected void anM() {
    this.dfV.jI(aom());
    performClick(this.dfK);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setTitleTextViewHideRightView(2131627953);
    boolean bool = getIntent().getBooleanExtra("extra_shift", false);
    long l = getIntent().getLongExtra("extra_user", 0L);
    if (bool) {
      n(4, true);
    } else {
      n(0, true);
    } 
    jY(1);
    if (l != 0L)
      di(l); 
    AH();
    a(new String[] { getString(2131627947), getString(2131627954), getString(2131627463), getString(2131627939) }, new int[] { 0, 1, 2, 3 }, 0);
  }
  
  private class a extends ReportRoot.i {
    public a(ProductReport this$0, ArrayList<HashMap<String, String>> param1ArrayList) { super(this$0, param1ArrayList, 2131427998, new String[] { "name", q.dbm, q.dbn, q.bzY, q.dbo }, new int[] { 2131298198, 2131298641, 2131298646, 2131296351, 2131296360 }); }
    
    public ReportRoot.i.a bJ(View param1View) { return new ReportRoot.i.a(this); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\ProductReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */