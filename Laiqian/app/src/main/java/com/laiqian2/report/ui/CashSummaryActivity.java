package com.laiqian.report.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.format.Time;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;
import com.laiqian.auth.bb;
import com.laiqian.basic.RootApplication;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.milestone.c;
import com.laiqian.models.an;
import com.laiqian.models.bh;
import com.laiqian.print.b.g;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.usage.receipt.model.a;
import com.laiqian.print.util.e;
import com.laiqian.report.models.a;
import com.laiqian.report.models.b;
import com.laiqian.report.models.h;
import com.laiqian.report.models.t;
import com.laiqian.report.models.u;
import com.laiqian.util.ae;
import com.laiqian.util.bt;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class CashSummaryActivity extends ReportRoot {
  private g ddH;
  
  private b ddI;
  
  private View ddJ;
  
  private View ddK;
  
  private TextView ddL;
  
  private View ddM;
  
  private TextView ddN;
  
  private View ddO;
  
  private TextView ddP;
  
  private View ddQ;
  
  private TextView ddR;
  
  private TextView ddS;
  
  private TextView ddT;
  
  private TextView ddU;
  
  private void AH() {
    ViewGroup viewGroup = aof();
    this.ddJ = View.inflate(this, 2131427985, null);
    this.ddK = this.ddJ.findViewById(2131299103);
    this.ddL = (TextView)this.ddJ.findViewById(2131299102);
    this.ddS = (TextView)this.ddJ.findViewById(2131299104);
    this.ddS.setText(2131627797);
    this.ddM = this.ddJ.findViewById(2131299098);
    this.ddN = (TextView)this.ddM.findViewById(2131299097);
    this.ddR = (TextView)this.ddM.findViewById(2131299099);
    this.ddR.setText(2131624010);
    this.ddO = this.ddJ.findViewById(2131299094);
    this.ddP = (TextView)this.ddO.findViewById(2131299093);
    this.ddT = (TextView)this.ddO.findViewById(2131299095);
    this.ddU = (TextView)this.ddO.findViewById(2131299096);
    this.ddU.setVisibility(0);
    this.ddT.setText(2131624864);
    this.ddU.setText(getString(2131624866));
    viewGroup.addView(this.ddJ);
    View view = View.inflate(this, 2131427973, null);
    GridView gridView = (GridView)view.findViewById(2131297189);
    this.ddH = new g(this, gridView);
    gridView.setAdapter(this.ddH);
    gridView.setEmptyView(findViewById(2131298220));
    viewGroup.addView(view);
    findViewById(2131296481).setVisibility(8);
  }
  
  private void Kh() {
    String str1 = getString(2131630112);
    String str2 = getString(2131630111);
    String str3 = getString(2131630110);
    String str4 = getString(2131630102);
    String str5 = getString(2131630101);
    String str6 = getString(2131630100);
    bt.a a1;
    bt.a a2;
    bt.a a3;
    bt.a a4;
    bt.a a5;
    bt.a a6 = (a5 = (a4 = (a3 = (a2 = (a1 = bt.a.mj(getResources().getColor(2131099972))).mj(getResources().getColor(2131099898))).mj(getResources().getColor(2131099972))).mj(getResources().getColor(2131099972))).mj(getResources().getColor(2131099898))).mj(getResources().getColor(2131099972));
    (new c(this, bt.a("%s%s%s<br><br>%s%s%s", new String[] { str1, str2, str3, str4, str5, str6 }, new bt.a[] { a1, a2, a3, a4, a5, a6 }), '', 'ʊ', 2131231058)).showAsDropDown(this.ddQ, -ae.b(this, 40.0F), 0);
  }
  
  private void a(List<a> paramList, PrintContent.a parama, int[] paramArrayOfInt) { a(paramList, parama, paramArrayOfInt, new int[] { 0, 2 }, 0); }
  
  private void a(List<a> paramList, PrintContent.a parama, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt) {
    for (a a1 : paramList) {
      String str;
      if (a1.cZq) {
        int i;
        paramList = a1.amq();
        if (paramInt == 0) {
          i = paramInt;
        } else {
          i = paramInt + 1;
        } 
        a(paramList, parama, paramArrayOfInt1, paramArrayOfInt2, i);
        continue;
      } 
      if (a1.cZr) {
        StringBuilder stringBuilder1 = new StringBuilder();
        if (paramInt > 0) {
          str = "  ";
        } else {
          String str1;
          str = "";
        } 
        stringBuilder1.append(str);
        stringBuilder1.append(a1.Yx);
        e.b(parama, paramArrayOfInt1, paramArrayOfInt2, new String[] { stringBuilder1.toString(), n.pm(a1.cZl) }, 0);
        a(a1.amq(), parama, paramArrayOfInt1, paramArrayOfInt2, paramInt + 1);
        continue;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      if (paramInt > 0) {
        str = "  ";
      } else {
        str = "";
      } 
      stringBuilder.append(str);
      stringBuilder.append(a1.Yx);
      e.b(parama, paramArrayOfInt1, paramArrayOfInt2, new String[] { stringBuilder.toString(), n.pm(a1.cZl) }, 0);
    } 
  }
  
  private void ax(ArrayList<a> paramArrayList) {
    this.ddH.ay(paramArrayList);
    b(this.ddI.amw());
    if (((Integer)this.dgp.getValue()).intValue() == 2) {
      b(8, this.ddI.amC());
    } else {
      b(0, this.ddI.amC());
    } 
    if (paramArrayList.isEmpty()) {
      aoj();
      return;
    } 
    aoi();
  }
  
  protected void AG() {
    super.AG();
    jV(0);
    jW(0);
  }
  
  @NonNull
  protected u AI() {
    this.ddI = new b(this);
    return this.ddI;
  }
  
  protected void AJ() {
    String str;
    t.a a = (new t.a(this.bqs[0], this.bqs[1])).dh(this.bKe).jJ(((Integer)this.dgp.getValue()).intValue()).jK(((Integer)this.dgo.getValue()).intValue());
    if (this.dgE == null || this.dgE.FK() < 0L) {
      str = "";
    } else {
      null = new StringBuilder();
      null.append(this.dgE.FK());
      null.append("");
      str = null.toString();
    } 
    t t = a.np(str).anl();
    this.ddI.a(t);
    ArrayList arrayList = this.ddI.amy();
    this.ddI.jI(aom());
    ax(arrayList);
  }
  
  protected ArrayList<HashMap<String, String>> Te() { return this.ddI.aw(this.ddH.zJ()); }
  
  protected void anM() {
    this.ddI.jI(aom());
    ArrayList arrayList = this.ddI.amD();
    if (arrayList == null) {
      AJ();
      return;
    } 
    ax(arrayList);
  }
  
  protected PrintContent.a anN() {
    boolean bool;
    str = getString(2131626458);
    if (this.bKe > 0L) {
      String str;
      bh bh = new bh(CrashApplication.zv());
      null = new StringBuilder();
      null.append(this.bKe);
      null.append("");
      str = bh.iE(null.toString());
      bh.close();
    } 
    null = this.bqs;
    byte b2 = 0;
    long l1 = null[0];
    long l2 = this.bqs[1];
    long l3 = this.bKe;
    null = new StringBuilder();
    null.append(this.dgo.getValue());
    null.append("");
    null = null.toString();
    null = new StringBuilder();
    null.append(this.dgp.getValue());
    null.append("");
    null = null.toString();
    null = new StringBuilder();
    null.append(this.dgE.FK());
    null.append("");
    null = new bb.a(l1, l2, l3, str, 0.0D, Double.valueOf(0.0D), null, null, null, null.toString());
    str = getString(2131629262);
    null = this.ddI.gz(true);
    if (((Integer)this.dgp.getValue()).intValue() == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    null = new bb.d(str, null, bool);
    null = new h(CrashApplication.zv());
    t.a a1 = (new t.a(this.bqs[0], this.bqs[1])).dh(this.bKe).jJ(((Integer)this.dgp.getValue()).intValue()).jK(((Integer)this.dgo.getValue()).intValue());
    if (this.dgE == null || this.dgE.FK() < 0L) {
      str = "";
    } else {
      String str;
      null = new StringBuilder();
      null.append(this.dgE.FK());
      null.append("");
      str = null.toString();
    } 
    null.a(a1.np(str).anl());
    null = null.amI();
    null.close();
    null = this.ddI.amv();
    null = new bb(null, new bb.c(getString(2131629388), this.ddI.amA(), (new Double(null[1])).intValue(), (new Double(null[0])).intValue(), null[1]), null, new bb.b(getString(2131625737), this.ddI.amz()));
    PrintContent.a a = new PrintContent.a();
    g g1 = new g(a);
    g1.setWidth(a.bo(CrashApplication.zv()).aiL().getWidth());
    null = new an(RootApplication.zv());
    g1.lk((null.Vu()).aVs);
    null.close();
    g1.lk(getString(2131627778));
    g1.l('-');
    Time time = new Time();
    time.set((null.yj()).aet);
    String str2 = getString(2131627400);
    null = time.format(str2);
    time.set((null.yj()).end);
    String str1 = time.format(str2);
    g1.n(new int[] { 12, 20 });
    g1.x(new String[] { getString(2131627434), null });
    g1.x(new String[] { getString(2131627435), str1 });
    null = new StringBuilder();
    null.append(getString(2131624783));
    null.append(":");
    g1.x(new String[] { null.toString(), null.yj().yo() });
    null = new StringBuilder();
    null.append(getString(2131624835));
    null.append(":");
    g1.x(new String[] { null.toString(), null.yj().yn() });
    null = new StringBuilder();
    null.append(getString(2131629291));
    null.append(":");
    g1.x(new String[] { null.toString(), null.yj().yq() });
    null = new StringBuilder();
    null.append(getString(2131628071));
    null.append(":");
    g1.x(new String[] { null.toString(), (null.yj()).userName });
    g1.l('-');
    g1.lk(null.yl().getTitle());
    g1.l('-');
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = 17;
    arrayOfInt[1] = 15;
    arrayOfInt;
    a(null.yl().yw(), a, arrayOfInt);
    g1.l('-');
    g1.setSize(3);
    g1.n(new int[] { 15, 17 });
    g1.x(new String[] { getString(2131630098), n.a(null.yl().yx(), true, false) });
    g1.n(arrayOfInt);
    byte b1;
    for (b1 = 0; b1 < 3; b1++)
      g1.ll(""); 
    if (!null.yj().yp()) {
      g1.lk(null.yk().getTitle());
      g1.l('-');
      g1.setSize(0);
      g1.n(arrayOfInt);
      for (Pair pair : null.yk().yr()) {
        g1.x(new String[] { (String)pair.first, n.a(pair.second, true, false) });
      } 
      g1.l('-');
      g1.setSize(3);
      g1.n(arrayOfInt);
      g1.x(new String[] { getString(2131627431), n.a(Integer.valueOf(null.yk().yt()), false, false) });
      g1.x(new String[] { getString(2131629389), n.a(Integer.valueOf(null.yk().ys()), false, false) });
      g1.x(new String[] { getString(2131630099), n.a(Double.valueOf(null.yk().yu()), true, false) });
      g1.l('-');
      g1.x(new String[] { getString(2131630096), n.a(Double.valueOf(null.yk().yv()), true, false) });
      for (b1 = 0; b1 < 3; b1++)
        g1.ll(""); 
    } 
    g1.lk(null.ym().getTitle());
    g1.l('-');
    null = null.ym().yr();
    g1.setSize(0);
    g1.n(arrayOfInt);
    Iterator iterator = null.iterator();
    while (true) {
      b1 = b2;
      if (iterator.hasNext()) {
        Pair pair = (Pair)iterator.next();
        g1.x(new String[] { (String)pair.first, n.a(pair.second, true, false) });
        continue;
      } 
      break;
    } 
    while (b1 < 3) {
      a.ln("");
      b1++;
    } 
    return a;
  }
  
  protected void b(double[] paramArrayOfDouble) {
    if (paramArrayOfDouble == null) {
      this.ddJ.setVisibility(8);
      gG(false);
    } else {
      this.ddJ.setVisibility(0);
      this.ddL.setText(n.d(Double.valueOf(paramArrayOfDouble[0])));
      this.ddN.setText(n.d(Double.valueOf(paramArrayOfDouble[1])));
      this.ddP.setText(n.d(Double.valueOf(paramArrayOfDouble[2])));
      if (((Integer)this.dgp.getValue()).intValue() == 0) {
        this.ddM.setVisibility(8);
        this.ddO.setVisibility(0);
        this.ddK.setVisibility(0);
        TextView textView = this.ddT;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(getString(2131624864));
        stringBuilder1.append("+");
        stringBuilder1.append(getString(2131624776));
        textView.setText(stringBuilder1.toString());
        this.ddS.setText(2131627797);
        this.ddU.setVisibility(0);
        if (((Integer)this.dgo.getValue()).intValue() == 1) {
          this.ddU.setText(getString(2131624866));
        } else if (((Integer)this.dgo.getValue()).intValue() == 2) {
          this.ddU.setText(getString(2131624865));
        } else {
          this.ddU.setText(getString(2131624865));
        } 
      } else if (((Integer)this.dgp.getValue()).intValue() == 1) {
        this.ddM.setVisibility(0);
        this.ddO.setVisibility(0);
        this.ddK.setVisibility(0);
        this.ddU.setVisibility(0);
        this.ddU.setText(getString(2131624866));
        if (((Integer)this.dgo.getValue()).intValue() == 1) {
          TextView textView = this.ddT;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(getString(2131630376));
          stringBuilder1.append(getString(2131624864));
          textView.setText(stringBuilder1.toString());
        } else if (((Integer)this.dgo.getValue()).intValue() == 2) {
          TextView textView = this.ddT;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(getString(2131625898));
          stringBuilder1.append(getString(2131624864));
          textView.setText(stringBuilder1.toString());
          this.ddU.setVisibility(8);
        } else {
          this.ddT.setText(getString(2131624864));
        } 
        this.ddS.setText(2131627797);
      } else {
        this.ddM.setVisibility(8);
        this.ddO.setVisibility(0);
        this.ddT.setText(2131624780);
        this.ddU.setVisibility(8);
        this.ddK.setVisibility(0);
        this.ddS.setText(2131624784);
      } 
      gG(this.ddI.amx());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("这里是设置总金额:");
    stringBuilder.append(Arrays.toString(paramArrayOfDouble));
    n.println(stringBuilder.toString());
  }
  
  protected void cU(View paramView) {
    paramView = paramView.findViewById(2131297857);
    this.ddQ = paramView.findViewById(2131297351);
    paramView.setOnClickListener(new f(this));
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    AH();
    setTitleTextViewHideRightView(2131627778);
    n(0, true);
    jU(0);
    jS(0);
    jT(0);
    jY(1);
    a(new String[] { getString(2131627795), getString(2131628409) }, new int[] { 2, 1 }, 2);
  }
  
  protected void onDestroy() {
    super.onDestroy();
    if (this.ddI != null)
      this.ddI.clear(); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\CashSummaryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */