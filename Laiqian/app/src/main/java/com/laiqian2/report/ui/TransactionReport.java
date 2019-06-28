package com.laiqian.report.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.laiqian.c.a;
import com.laiqian.d.a;
import com.laiqian.pos.model.a;
import com.laiqian.report.b.a;
import com.laiqian.report.models.aa;
import com.laiqian.report.models.ad;
import com.laiqian.report.models.e;
import com.laiqian.report.models.o;
import com.laiqian.report.models.u;
import com.laiqian.ui.a.aq;
import com.laiqian.ui.a.g;
import com.laiqian.util.by;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TransactionReport extends ReportRoot {
  private String dcX;
  
  private View ddJ;
  
  private View ddO;
  
  private TextView dek;
  
  private TextView del;
  
  private TextView dem;
  
  private TextView deo;
  
  private TextView dhp;
  
  @Nullable
  private aq<a> dhq;
  
  ad dhr;
  
  private View dhs;
  
  boolean isShow = true;
  
  private void AH() {
    View view;
    this.ddJ = (view = View.inflate(this, 2131427731, null)).inflate(this, 2131427985, null);
    this.dhs = this.ddJ.findViewById(2131299098);
    this.dhs.setVisibility(0);
    this.ddO = this.ddJ.findViewById(2131299094);
    this.dek = (TextView)this.ddJ.findViewById(2131299102);
    this.del = (TextView)this.ddJ.findViewById(2131299097);
    this.dem = (TextView)this.ddJ.findViewById(2131299093);
    ((TextView)this.ddJ.findViewById(2131299104)).setText(2131627913);
    ((TextView)this.ddJ.findViewById(2131299099)).setText(2131627912);
    ((TextView)this.ddJ.findViewById(2131299095)).setText(2131627603);
    this.bWY.addHeaderView(this.ddJ);
    this.bWY.addHeaderView(view);
    this.bWY.setAdapter(new b(this, new ArrayList()));
    this.bWY.setEmptyView(findViewById(2131298220));
  }
  
  private void a(a parama) {
    if (this.dhq == null)
      return; 
    boolean bool = false;
    a a1 = parama;
    if (parama == null) {
      parama = (a)this.dhq.kT(0);
      a1 = parama;
      if (parama == null) {
        n.o("订单来源的选择框异常");
        return;
      } 
    } 
    this.dcX = a1.value;
    this.dhp.setText(a1.AT());
    TextView textView = this.dhp;
    if (a1.AR() > 0L)
      bool = true; 
    textView.setSelected(bool);
    this.dhq.dn(a1.AR());
  }
  
  private void aoC() {
    this.deo = (new ReportRoot.a(this, 2131624990, new ch(this), true, false)).aov();
    String str = a.dg(getIntent().getLongExtra("orderType", -1L));
    TextView textView = this.deo;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append("");
    textView.setText(stringBuilder.toString());
    this.deo.setTextColor(getResources().getColor(2131099865));
    this.dhp = (new ReportRoot.a(this, 2131627199, new ci(this), true, false)).aov();
    this.dhp.setText(getIntent().getStringExtra("deliveryUserName"));
    this.dhp.setTextColor(getResources().getColor(2131099865));
  }
  
  private void aoD() {
    ArrayList arrayList = new ArrayList();
    arrayList.add(new a(this, -1, getString(2131628048), "", null));
    arrayList.add(new a(this, false, getString(2131628058), " 0,7,15", null));
    String str1 = "";
    if (getResources().getBoolean(2131034129))
      str1 = "3"; 
    String str2 = str1;
    if (getResources().getBoolean(2131034136)) {
      null = new StringBuilder();
      if (by.isNull(str1)) {
        str1 = "";
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str1);
        stringBuilder.append(",");
        str1 = stringBuilder.toString();
      } 
      null.append(str1);
      null.append(2);
      str2 = null.toString();
      arrayList.add(new a(this, true, getString(2131628061), "1", null));
    } 
    if (!a.zR().zU())
      arrayList.add(new a(this, true, getString(2131628057), "1", null)); 
    if (!by.isNull(str2)) {
      arrayList.add(new a(this, 2, getString(2131627171), str2, null));
      arrayList.add(new a(this, 14, getString(2131628059), "14", null));
    } 
    if (a.AZ().BT() && a.zR().zV())
      arrayList.add(new a(this, 5, getString(2131626265), "5,6", null)); 
    if (a.AZ().BT() && a.zR().zV())
      arrayList.add(new a(this, 8, getString(2131626527), "8", null)); 
    if (a.AZ().BT() && a.zR().zV())
      arrayList.add(new a(this, 9, getString(2131625572), "9", null)); 
    this.dhq = new g(this, arrayList, new cj(this));
    this.dhp = (new ReportRoot.a(this, 2131627053, new ck(this))).aov();
    a((a)arrayList.get(0));
  }
  
  protected void AC() {
    if (getResources().getBoolean(2131034127))
      super.AC(); 
  }
  
  protected void AD() { super.AD(); }
  
  @NonNull
  protected u AI() {
    this.dhr = new ad(this);
    return this.dhr;
  }
  
  protected void AJ() {
    n.println("这里是showData()");
    if (getLaiqianPreferenceManager().atC())
      getLaiqianPreferenceManager().ht(false); 
    b(null);
    aaQ();
    gE(true);
    if (getIntent().hasExtra("deliveryUserName") && this.isShow) {
      this.isShow = false;
      aa aa = (aa)getIntent().getSerializableExtra("StartEndDateEntity");
      gJ(aa.dcr);
      b((e)getIntent().getSerializableExtra("DateTimeItemOfSelectDialog"));
      a(aa);
    } 
    (new ReportRoot.d(this, true)).aow().start();
  }
  
  protected String Td() {
    String str = this.dhr.a(null, this.bqs[0], this.bqs[1], this.bKe, this.cPh, this.dgH, aor(), aos());
    this.dfV.b(this.bqs[0], this.bqs[1], getString(2131627842));
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
    if (this.cPh != null && this.cPh.length > 0) {
      str = "1";
    } else {
      str = "0";
    } 
    paramHashMap.put("hasProduct", str);
  }
  
  protected void a(u paramu) {
    super.a(paramu);
    ((ad)paramu).nv(this.dcX);
  }
  
  protected void a(boolean paramBoolean, ArrayList<HashMap<String, String>> paramArrayList, int paramInt) { b(paramBoolean, paramArrayList, paramInt); }
  
  protected ArrayList<HashMap<String, String>> aok() { return null; }
  
  protected void b(double[] paramArrayOfDouble) {
    if (paramArrayOfDouble == null) {
      this.ddJ.setVisibility(8);
    } else {
      this.ddJ.setVisibility(0);
      this.dek.setText(n.d(Double.valueOf(paramArrayOfDouble[0])));
      this.del.setText(n.d(Double.valueOf(paramArrayOfDouble[1])));
      if (paramArrayOfDouble[2] > 0.0D) {
        this.ddO.setVisibility(8);
        this.dem.setText(n.d(Double.valueOf(paramArrayOfDouble[2])));
      } else {
        this.ddO.setVisibility(8);
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("这里是设置总金额:");
    stringBuilder.append(Arrays.toString(paramArrayOfDouble));
    n.println(stringBuilder.toString());
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    n(0, true);
    AH();
    if (getIntent().hasExtra("deliveryUserName")) {
      aoC();
      a(null, null, 0);
      jY(0);
      String str = getIntent().getStringExtra("deliveryUserID");
      aop();
      nx(str);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(getIntent().getLongExtra("orderType", -1L));
      stringBuilder.append("");
      setOrderTypeID(stringBuilder.toString());
      setTitleTextViewHideRightView(2131627910);
    } else {
      setTitleTextViewHideRightView(2131628070);
      aoD();
      a(null, null, 0);
      jY(7);
    } 
    AJ();
  }
  
  protected void onDestroy() { super.onDestroy(); }
  
  private class a implements g.b {
    CharSequence cZi;
    
    int id;
    
    @Nullable
    String value;
    
    private a(TransactionReport this$0, int param1Int, CharSequence param1CharSequence, @Nullable String param1String) {
      this.id = param1Int;
      this.cZi = param1CharSequence;
      this.value = param1String;
    }
    
    public long AR() { return this.id; }
    
    public CharSequence AS() { return this.cZi; }
    
    public CharSequence AT() { return this.cZi; }
  }
  
  private class b extends ReportRoot.i {
    public b(TransactionReport this$0, ArrayList<HashMap<String, String>> param1ArrayList) { super(this$0, param1ArrayList, 2131428015, null, null); }
    
    protected boolean AK() { return true; }
    
    public void a(ReportRoot.i.a param1a, View param1View, HashMap<String, String> param1HashMap, int param1Int) {
      boolean bool = param1HashMap.containsKey("hideLine");
      param1Int = 8;
      if (!bool) {
        ((a)param1a).dfD.setVisibility(0);
        param1View.setEnabled(true);
      } else {
        ((a)param1a).dfD.setVisibility(8);
      } 
      if (!param1HashMap.containsKey("isGroup")) {
        View view;
        a a2 = (a)param1a;
        a2.dhC.setVisibility(0);
        a2.dhB.setVisibility(8);
        null = a2.dhw;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append((String)param1HashMap.get(ad.dam));
        stringBuilder2.append("");
        null.setText(stringBuilder2.toString());
        String str = (String)param1HashMap.get(ad.dcV);
        null = str;
        if (by.isNull(str))
          null = ""; 
        str = null;
        if (!TextUtils.isEmpty((CharSequence)param1HashMap.get("sourceCode"))) {
          str = null;
          if (Integer.parseInt((String)param1HashMap.get("sourceCode")) == 14) {
            null = new a(this.dht.getActivity());
            o o = null.t((String)param1HashMap.get("orderNo"), false);
            null.close();
            str = null;
            if (o != null) {
              str = null;
              if (TextUtils.isEmpty(o.openTableName)) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(this.dht.getString(2131628301));
                stringBuilder3.append(" ");
                stringBuilder3.append(o.openTableName);
                str = stringBuilder3.toString();
              } 
            } 
          } 
        } 
        a2.tvTableNumber.setText(str);
        a2.cjl.setTextColor(this.dht.getResources().getColor(2131099872));
        null = a2.cjl;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append((String)param1HashMap.get(ad.daB));
        stringBuilder1.append("");
        null.setText(stringBuilder1.toString());
        null = a2.dhx;
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append((String)param1HashMap.get(ad.bzY));
        stringBuilder1.append("");
        null.setText(stringBuilder1.toString());
        null = a2.dhw;
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append((String)param1HashMap.get(ad.dam));
        stringBuilder1.append("");
        null.setText(stringBuilder1.toString());
        view = a2.dhu;
        if ("1".equals(param1HashMap.get("sourceCode")))
          param1Int = 0; 
        view.setVisibility(param1Int);
        a2.dfD.setTag(param1HashMap);
        return;
      } 
      a a1 = (a)view;
      a1.dhB.setVisibility(0);
      a1.dhB.setEnabled(false);
      a1.dhB.setClickable(false);
      a1.dhC.setVisibility(8);
      TextView textView = a1.dhy;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append((String)param1HashMap.get(ad.dam));
      stringBuilder.append("");
      textView.setText(stringBuilder.toString());
      textView = a1.dhz;
      stringBuilder = new StringBuilder();
      stringBuilder.append((String)param1HashMap.get(ad.daB));
      stringBuilder.append("");
      textView.setText(stringBuilder.toString());
      textView = a1.dhA;
      stringBuilder = new StringBuilder();
      stringBuilder.append((String)param1HashMap.get(ad.bzY));
      stringBuilder.append("");
      textView.setText(stringBuilder.toString());
      if (a.zR().zX()) {
        a1.dfF.setText(this.dht.getString(2131627992, new Object[] { n.d(Double.valueOf(Double.parseDouble((String)param1HashMap.get("childCount")))), param1HashMap.get("preferentialAmount") }));
        return;
      } 
      a1.dfF.setText(this.dht.getString(2131627991, new Object[] { n.d(Double.valueOf(Double.parseDouble((String)param1HashMap.get("childCount")))) }));
    }
    
    public ReportRoot.i.a bJ(View param1View) {
      a a = new a(this, param1View.findViewById(2131297745), param1View.findViewById(2131300036), (TextView)param1View.findViewById(2131296768));
      a.dhy = (TextView)param1View.findViewById(2131299544);
      a.dhz = (TextView)param1View.findViewById(2131299545);
      a.dhA = (TextView)param1View.findViewById(2131299543);
      a.dhv = param1View.findViewById(2131297699);
      a.dhw = (TextView)param1View.findViewById(2131299800);
      a.tvTableNumber = (TextView)param1View.findViewById(2131299715);
      a.dhx = (TextView)param1View.findViewById(2131299650);
      a.cjl = (TextView)param1View.findViewById(2131299649);
      a.dhB = (LinearLayout)param1View.findViewById(2131298723);
      a.dhC = (RelativeLayout)param1View.findViewById(2131297985);
      return a;
    }
    
    protected void i(HashMap<String, String> param1HashMap) {
      if (param1HashMap.containsKey("isGroup"))
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("record:");
      stringBuilder.append(param1HashMap);
      n.println(stringBuilder.toString());
      Bundle bundle = new Bundle();
      bundle.putString("orderNo", (String)param1HashMap.get("orderNo"));
      bundle.putString("ORDERTIME", (String)param1HashMap.get("ORDERTIME"));
      n.a(this.dht, TransactionDetails.class, bundle);
    }
    
    class a extends ReportRoot.i.a {
      public TextView cjl;
      
      View dfD;
      
      TextView dfF;
      
      public TextView dhA;
      
      public LinearLayout dhB;
      
      public RelativeLayout dhC;
      
      View dhu;
      
      public View dhv;
      
      public TextView dhw;
      
      public TextView dhx;
      
      public TextView dhy;
      
      public TextView dhz;
      
      public TextView tvTableNumber;
      
      public a(TransactionReport.b this$0, View param2View1, View param2View2, TextView param2TextView) {
        super(this$0);
        this.dfD = param2View1;
        this.dhu = param2View2;
        this.dfF = param2TextView;
      }
    }
  }
  
  class a extends ReportRoot.i.a {
    public TextView cjl;
    
    View dfD;
    
    TextView dfF;
    
    public TextView dhA;
    
    public LinearLayout dhB;
    
    public RelativeLayout dhC;
    
    View dhu;
    
    public View dhv;
    
    public TextView dhw;
    
    public TextView dhx;
    
    public TextView dhy;
    
    public TextView dhz;
    
    public TextView tvTableNumber;
    
    public a(TransactionReport this$0, View param1View1, View param1View2, TextView param1TextView) {
      super(this$0);
      this.dfD = param1View1;
      this.dhu = param1View2;
      this.dfF = param1TextView;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\TransactionReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */