package com.laiqian.product;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.laiqian.c.a;
import com.laiqian.main.d;
import com.laiqian.product.models.g;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.g;
import com.laiqian.ui.a.r;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.container.f;
import com.laiqian.ui.container.h;
import com.laiqian.ui.layout.CheckBoxLayoutInMainSetting;
import com.laiqian.ui.s;
import com.laiqian.util.ar;
import com.laiqian.util.by;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ProductTaxRuleEditActivity extends ActivityRoot implements ee {
  private ArrayList<HashMap<String, String>> bjv;
  
  private boolean cSA;
  
  private int cSB;
  
  private g cSC;
  
  private String cSD = "";
  
  private String cSE = "";
  
  View.OnClickListener cSF = new ed(this);
  
  private ArrayList<d> cSe;
  
  private final int cSl = 1;
  
  private final int cSm = 2;
  
  private final int cSn = 3;
  
  private final int cSo = 4;
  
  private dq cSp;
  
  private long cSq;
  
  private long[] cSr;
  
  private long[] cSs;
  
  private long[] cSt;
  
  private long[] cSu;
  
  private long[] cSv;
  
  private int cSw;
  
  a cSx;
  
  private int cSy;
  
  private double cSz;
  
  private String mName;
  
  aa titleBar;
  
  private void ZQ() {
    this.titleBar.tvTitle.setText(getString(2131627624));
    this.titleBar.brj.setText(getString(2131629495));
    this.titleBar.brk.setVisibility(8);
    ((TextView)this.cSx.cSJ.cAO.getView()).setText(getString(2131627621));
    ((ViewGroup)this.cSx.cSJ.getView()).setBackgroundResource(2130772057);
    ((EditText)this.cSx.cSJ.dwQ.getView()).requestFocus();
    ((TextView)this.cSx.cSK.cAO.getView()).setText(getString(2131627625));
    ((TextView)this.cSx.cSK.cAT.getView()).setTextColor(getResources().getColor(2131099938));
    ((TextView)this.cSx.cSK.cAT.getView()).setText("%");
    ((EditText)this.cSx.cSK.dwQ.getView()).setInputType(8194);
    ((EditText)this.cSx.cSK.dwQ.getView()).setFilters(ar.bE(3, 1));
    ((ViewGroup)this.cSx.cSK.getView()).setBackgroundResource(2130772051);
  }
  
  private void a(int paramInt, long[] paramArrayOfLong) {
    Intent intent = new Intent(this, ProductList.class);
    intent.putExtra("productIDs", paramArrayOfLong);
    intent.putExtra("isTax", true);
    intent.putExtra("hasMealSet", true);
    startActivityForResult(intent, paramInt);
  }
  
  private boolean ajY() { return (this.cSy != Integer.parseInt(akb()) || !this.mName.equals(getName()) || this.cSz - Double.valueOf(akc()).doubleValue() != 0.0D || this.cSA || this.cSB != this.cSw); }
  
  private boolean ajZ() { return (!this.cSE.equals(this.cSD) || !this.cSx.cSS.isChecked()); }
  
  private void aka() {
    String str = Arrays.toString(this.cSr);
    null = Arrays.toString(this.cSt);
    null = new StringBuilder();
    long[] arrayOfLong2 = this.cSr;
    int i = arrayOfLong2.length;
    byte b2 = 0;
    byte b1;
    for (b1 = 0; b1 < i; b1++) {
      long l = arrayOfLong2[b1];
      if (!null.contains(String.valueOf(l))) {
        null.append(l);
        null.append(",");
      } 
    } 
    this.cSv = by.f(null);
    StringBuilder stringBuilder = new StringBuilder();
    long[] arrayOfLong1 = this.cSt;
    i = arrayOfLong1.length;
    for (b1 = b2; b1 < i; b1++) {
      long l = arrayOfLong1[b1];
      if (!str.contains(String.valueOf(l))) {
        stringBuilder.append(l);
        stringBuilder.append(",");
      } 
    } 
    this.cSu = by.f(stringBuilder);
    if (this.cSv.length > 0 || this.cSu.length > 0)
      this.cSA = true; 
  }
  
  private void ap(ArrayList<HashMap<String, String>> paramArrayList) {
    int i = paramArrayList.size();
    this.cSs = new long[i];
    for (byte b = 0; b < i; b++) {
      HashMap hashMap = (HashMap)paramArrayList.get(b);
      this.cSs[b] = Long.parseLong((String)hashMap.get("id"));
    } 
  }
  
  private void b(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt) {
    r r = new r(this, new ec(this, paramInt));
    r.setTitle(paramString1);
    r.s(paramString2);
    r.t(paramString3);
    r.oZ(paramString4);
    r.show();
  }
  
  private void jl(int paramInt) {
    if (this.bjv.size() == paramInt) {
      a.g(this.cSx).setText(getResources().getString(2131627613));
      return;
    } 
    a.g(this.cSx).setText(String.valueOf(paramInt));
  }
  
  private void setListeners() {
    this.cSq = getIntent().getLongExtra("taxid", -1L);
    this.cSp = new dq(this);
    this.cSe = this.cSp.ajV();
    if (this.cSq != -1L) {
      dq dq1 = this.cSp;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.cSq);
      stringBuilder.append("");
      this.cSD = dq1.mw(stringBuilder.toString());
      this.cSE = this.cSD;
    } 
    this.cSC = new g(this, this.cSe, new du(this));
    this.titleBar.bri.setOnClickListener(new dv(this));
    a.c(this.cSx).setOnClickListener(new dw(this));
    if (a.zR().Ab()) {
      a.d(this.cSx).setVisibility(0);
      a.d(this.cSx).setOnClickListener(new dy(this));
    } 
    this.bjv = (new g(this)).a(null, "", null, null, false);
    if (this.cSq != -1L) {
      this.titleBar.tvTitle.setText(2131627634);
      this.cSx.cSS.setFocusable(true);
      this.cSx.cSS.setFocusableInTouchMode(true);
      this.cSx.cSS.requestFocus();
      this.cSp.a(this.cSq, this);
      a.e(this.cSx).setVisibility(0);
      a.e(this.cSx).setOnClickListener(new dz(this));
      a.f(this.cSx).setOnClickListener(new ea(this));
    } else {
      my("0");
      gq(true);
      jn(0);
      ap(this.bjv);
      jl(this.bjv.size());
      mz(getResources().getString(2131627613));
      a.f(this.cSx).setOnClickListener(new eb(this));
    } 
    this.titleBar.brj.setOnClickListener(this.cSF);
  }
  
  public StringBuilder a(StringBuilder paramStringBuilder, String paramString) {
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    if (by.isNull(paramStringBuilder.toString())) {
      str = "";
    } else {
      str = ",";
    } 
    stringBuilder.append(str);
    stringBuilder.append(paramString);
    paramStringBuilder.append(stringBuilder.toString());
    return paramStringBuilder;
  }
  
  public String akb() { return this.cSx.cSS.isChecked() ? "0" : "1"; }
  
  public String akc() { return ((EditText)this.cSx.cSK.dwQ.getView()).getText().toString().trim(); }
  
  public String akd() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.cSw);
    stringBuilder.append("");
    return stringBuilder.toString();
  }
  
  public String getName() { return ((EditText)this.cSx.cSJ.dwQ.getView()).getText().toString().trim(); }
  
  public void gq(boolean paramBoolean) {
    if (paramBoolean) {
      this.cSy = 0;
    } else {
      this.cSy = 1;
    } 
    this.cSx.cSS.setChecked(paramBoolean);
  }
  
  public void i(long[] paramArrayOfLong) {
    dq dq1;
    String str1 = getName();
    if (by.isNull(str1)) {
      n.eP(2131627622);
      ((EditText)this.cSx.cSJ.dwQ.getView()).requestFocus();
      return;
    } 
    String str2 = akc();
    if (by.isNull(str2)) {
      n.eP(2131627627);
      ((EditText)this.cSx.cSK.dwQ.getView()).requestFocus();
      return;
    } 
    if (Double.valueOf(str2).doubleValue() < 0.0D || Double.valueOf(str2).doubleValue() > 300.0D) {
      n.eP(2131627628);
      ((EditText)this.cSx.cSK.dwQ.getView()).requestFocus();
      return;
    } 
    if (this.cSq != -1L) {
      if (ajY() || ajZ()) {
        if (this.cSp.mx(str1) && !this.mName.equals(getName())) {
          n.eP(2131627623);
          ((EditText)this.cSx.cSJ.dwQ.getView()).requestFocus();
          return;
        } 
        if (ajY())
          this.cSp.a(this.cSq, this.cSu, this.cSv, this); 
        if (ajZ()) {
          dq1 = this.cSp;
          str1 = this.cSD;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(this.cSq);
          stringBuilder.append("");
          dq1.f(str1, stringBuilder.toString(), false);
        } 
      } 
      setResult(-1, getIntent());
      finish();
      return;
    } 
    if (this.cSp.mx(str1)) {
      n.o(getResources().getString(2131627623));
      ((EditText)this.cSx.cSJ.dwQ.getView()).requestFocus();
      return;
    } 
    this.cSp.a(dq1, this.cSD, this);
    setResult(-1, getIntent());
    finish();
  }
  
  public void jm(int paramInt) {
    if (this.bjv.size() == paramInt) {
      a.g(this.cSx).setText(getResources().getString(2131627613));
      return;
    } 
    a.g(this.cSx).setText(String.valueOf(paramInt));
  }
  
  public void jn(int paramInt) {
    this.cSB = paramInt;
    if (paramInt == 0) {
      this.cSw = 0;
      a.b(this.cSx).setText(getResources().getString(2131627630));
      return;
    } 
    this.cSw = 1;
    a.b(this.cSx).setText(getResources().getString(2131627631));
  }
  
  public void my(String paramString) {
    this.cSz = Double.parseDouble(paramString);
    ((EditText)this.cSx.cSK.dwQ.getView()).setText(paramString);
  }
  
  public void mz(String paramString) { a.a(this.cSx).setText(paramString); }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
      return; 
    if (paramInt1 == 1 || paramInt1 == 2) {
      long[] arrayOfLong = paramIntent.getLongArrayExtra("IDs");
      String[] arrayOfString = paramIntent.getStringArrayExtra("names");
      switch (paramInt1) {
        default:
          return;
        case 2:
          this.cSt = arrayOfLong;
          jl(this.cSt.length);
          aka();
          return;
        case 1:
          break;
      } 
      if (arrayOfLong != null && arrayOfString != null) {
        this.cSs = arrayOfLong;
        jl(this.cSs.length);
      } 
    } 
  }
  
  public void onBackPressed() {
    if (this.cSq != -1L && (ajY() || ajZ())) {
      b(getString(2131627735), getString(2131627733), getString(2131627734), getString(2131627732), 3);
      return;
    } 
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.cSx = a.F(this);
    this.titleBar = aa.M(this);
    ZQ();
    setListeners();
  }
  
  public void setName(String paramString) {
    this.mName = paramString;
    ((EditText)this.cSx.cSJ.dwQ.getView()).setText(paramString);
  }
  
  public static class a extends ab<ViewGroup> {
    public h cSJ = new h(2131297704);
    
    public f cSK = new f(2131297705);
    
    private TextView cSL;
    
    private TextView cSM;
    
    private TextView cSN;
    
    private View cSO;
    
    private View cSP;
    
    private View cSQ;
    
    private Button cSR;
    
    public CheckBoxLayoutInMainSetting cSS;
    
    public a(int param1Int, View param1View) {
      super(param1Int);
      this.cSS = (CheckBoxLayoutInMainSetting)s.z(param1View, 2131296744);
      this.cSL = (TextView)s.z(param1View, 2131299775);
      this.cSM = (TextView)s.z(param1View, 2131299777);
      this.cSN = (TextView)s.z(param1View, 2131299774);
      this.cSO = s.z(param1View, 2131298026);
      this.cSP = s.z(param1View, 2131298029);
      this.cSQ = s.z(param1View, 2131298027);
      this.cSR = (Button)s.z(param1View, 2131296538);
    }
    
    public static a F(Activity param1Activity) {
      View view = LayoutInflater.from(param1Activity).inflate(2131427962, null);
      param1Activity.setContentView(view);
      a a1 = new a(16908290, view);
      a1.S(view);
      return a1;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\ProductTaxRuleEditActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */