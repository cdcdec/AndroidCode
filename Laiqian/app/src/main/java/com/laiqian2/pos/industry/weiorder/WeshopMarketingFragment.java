package com.laiqian.pos.industry.weiorder;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.c.a;
import com.laiqian.d.a;
import com.laiqian.db.multidatabase.b.a;
import com.laiqian.models.z;
import com.laiqian.network.o;
import com.laiqian.product.dq;
import com.laiqian.product.models.o;
import com.laiqian.sync.a.a;
import com.laiqian.sync.a.f;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.a.g;
import com.laiqian.ui.a.r;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.container.e;
import com.laiqian.ui.container.f;
import com.laiqian.ui.container.g;
import com.laiqian.ui.container.l;
import com.laiqian.util.ar;
import com.laiqian.util.by;
import com.laiqian.util.n;
import io.reactivex.g.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.FutureTask;

public class WeshopMarketingFragment extends FragmentRoot implements g, go {
  private r bCE;
  
  private r bCF;
  
  private final int cgU = 2;
  
  private boolean chn;
  
  ArrayList<eh> ctj;
  
  private String cwA = "";
  
  private StringBuilder cwB;
  
  a cwv;
  
  gm cww;
  
  boolean cwx = true;
  
  private g cwy;
  
  private ArrayList<o> cwz;
  
  private boolean isDiscountConvertion;
  
  private Handler mHandler = new gc(this);
  
  private bb mWaitingDialog;
  
  aa titleBar;
  
  private void RD() {
    this.mHandler.obtainMessage(3).sendToTarget();
    try {
      o.WQ().a(new FutureTask(new gb(this), null));
      return;
    } catch (InterruptedException interruptedException) {
      a.e(interruptedException);
      return;
    } 
  }
  
  private StringBuffer a(String paramString, StringBuffer paramStringBuffer) {
    if (by.isNull(paramString)) {
      this.cwA = "";
      return paramStringBuffer;
    } 
    this.cwA = paramString;
    byte b1 = 0;
    byte b2;
    for (b2 = 0; b1 < this.cwz.size(); b2 = b) {
      paramString = this.cwA;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(((o)this.cwz.get(b1)).getId());
      stringBuilder.append("");
      byte b = b2;
      if (paramString.contains(stringBuilder.toString())) {
        if (b2)
          paramStringBuffer.append(","); 
        paramStringBuffer.append(((o)this.cwz.get(b1)).akZ());
        b = b2 + true;
      } 
      b1++;
    } 
    return paramStringBuffer;
  }
  
  private boolean abd() {
    String str = ((EditText)this.cwv.ctm.dwQ.getView()).getText().toString();
    if (TextUtils.isEmpty(str)) {
      Toast.makeText(getActivity(), getString(2131629975), 0).show();
      return false;
    } 
    if (n.u(str) < 0.0D) {
      Toast.makeText(getActivity(), getString(2131629975), 0).show();
      return false;
    } 
    this.cww.az(n.u(str));
    str = ((EditText)this.cwv.cwR.dwQ.getView()).getText().toString();
    if (TextUtils.isEmpty(str)) {
      Toast.makeText(getActivity(), getString(2131629971), 0).show();
      return false;
    } 
    if (n.u(str) < 0.0D) {
      Toast.makeText(getActivity(), getString(2131629971), 0).show();
      return false;
    } 
    this.cww.aD(n.u(str));
    str = ((EditText)this.cwv.cwQ.dwQ.getView()).getText().toString();
    if (TextUtils.isEmpty(str)) {
      Toast.makeText(getActivity(), getString(2131629973), 0).show();
      return false;
    } 
    if (n.u(str) < 0.0D) {
      Toast.makeText(getActivity(), getString(2131629973), 0).show();
      return false;
    } 
    this.cww.aE(n.u(str));
    str = ((EditText)this.cwv.cto.dwQ.getView()).getText().toString();
    if (TextUtils.isEmpty(str)) {
      Toast.makeText(getActivity(), getString(2131629976), 0).show();
      return false;
    } 
    double d = n.u(str);
    if (this.isDiscountConvertion ? (d < 0.0D || d >= 100.0D) : (d <= 0.0D || d > 100.0D)) {
      Toast.makeText(getActivity(), getString(2131629970), 0).show();
      return false;
    } 
    this.cww.p(d);
    if (!this.chn) {
      String str1 = ((EditText)this.cwv.cwT.dwQ.getView()).getText().toString();
      if (TextUtils.isEmpty(str)) {
        Toast.makeText(getActivity(), getString(2131629972), 0).show();
        return false;
      } 
      int i = n.parseInt(str1);
      if (this.isDiscountConvertion ? (i < 0 || i >= 100) : (i <= 0 || i > 100)) {
        Toast.makeText(getActivity(), getString(2131629969), 0).show();
        return false;
      } 
      this.cww.hi(i);
    } 
    this.cww.kc(this.cwA);
    return true;
  }
  
  private void acb() {
    this.cwz = (new dq(getActivity())).gp(true);
    this.cwA = a.AZ().BX();
  }
  
  private long[] acc() {
    byte b = 0;
    long[] arrayOfLong = new long[0];
    if (!by.isNull(this.cwA)) {
      String[] arrayOfString = acd().split(",");
      arrayOfLong = new long[arrayOfString.length];
      while (b < arrayOfString.length) {
        arrayOfLong[b] = Long.valueOf(arrayOfString[b]).longValue();
        b++;
      } 
    } 
    return arrayOfLong;
  }
  
  private String acd() {
    this.cwB = new StringBuilder();
    String[] arrayOfString = this.cwA.split(",");
    StringBuilder stringBuilder = new StringBuilder();
    for (byte b = 0; b < arrayOfString.length; b++) {
      byte b1 = 0;
      while (true) {
        if (b1 < this.cwz.size()) {
          String str = arrayOfString[b];
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(((o)this.cwz.get(b1)).getId());
          stringBuilder1.append("");
          if (str.equals(stringBuilder1.toString())) {
            b1 = 1;
            break;
          } 
          b1++;
          continue;
        } 
        b1 = 0;
        break;
      } 
      if (b1 == 0) {
        this.cwB = a(this.cwB, arrayOfString[b]);
      } else {
        stringBuilder = a(stringBuilder, arrayOfString[b]);
      } 
    } 
    return stringBuilder.toString();
  }
  
  private void setListeners() {
    this.bCE.a(new fr(this));
    this.bCF.a(new ge(this));
    ((CheckBox)this.cwv.cwN.dwV.getView()).setOnCheckedChangeListener(new gf(this));
    ((CheckBox)this.cwv.cwO.dwV.getView()).setOnCheckedChangeListener(new gg(this));
    ((CheckBox)this.cwv.cwM.dwV.getView()).setOnCheckedChangeListener(new gh(this));
    ((RelativeLayout)this.cwv.cwS.getView()).setOnClickListener(new gi(this));
    ((RelativeLayout)this.cwv.cwW.getView()).setOnClickListener(new gj(this));
    ((EditText)this.cwv.ctm.dwQ.getView()).addTextChangedListener(new gk(this));
    ((EditText)this.cwv.cwR.dwQ.getView()).addTextChangedListener(new gl(this));
    ((EditText)this.cwv.cwQ.dwQ.getView()).addTextChangedListener(new fs(this));
    ((EditText)this.cwv.cto.dwQ.getView()).addTextChangedListener(new ft(this));
    if (!this.chn)
      ((EditText)this.cwv.cwT.dwQ.getView()).setOnClickListener(new fu(this)); 
    ((ViewGroup)this.cwv.cwN.getView()).setOnClickListener(new fw(this));
    ((ViewGroup)this.cwv.cwM.getView()).setOnClickListener(new fx(this));
    ((LinearLayout)this.cwv.cwK.getView()).setOnClickListener(new fy(this));
    acb();
    if (this.cwz != null && this.cwz.size() > 0) {
      ((LinearLayout)this.cwv.cwU.getView()).setVisibility(0);
      ((LinearLayout)this.cwv.cwU.getView()).setBackgroundResource(2130772051);
      if (((ViewGroup)this.cwv.cwQ.getView()).getVisibility() == 0)
        ((ViewGroup)this.cwv.cwQ.getView()).setBackgroundResource(2130772055); 
    } else if (((ViewGroup)this.cwv.cwQ.getView()).getVisibility() == 0) {
      ((ViewGroup)this.cwv.cwQ.getView()).setBackgroundResource(2130772055);
    } 
    this.cwy = new g(getActivity(), this.cwz, new fz(this));
    ((LinearLayout)this.cwv.cwU.getView()).setOnClickListener(new ga(this));
  }
  
  private void setupViews() {
    this.mWaitingDialog = new bb(getActivity());
    this.mWaitingDialog.setCancelable(false);
    this.bCE = new r(getActivity(), true, null);
    this.bCE.oZ("取消");
    this.bCE.t("开启");
    this.bCE.setTitle(getString(2131626722));
    this.bCE.s(getString(2131626016));
    this.bCF = new r(getActivity(), true, null);
    this.bCF.oZ("取消");
    this.bCF.t("重试");
    this.bCF.setTitle(getString(2131626722));
    this.bCF.s("上传数据失败,请检查网络");
    ((TextView)this.cwv.csT.getView()).setText(getString(2131629983));
    ((TextView)this.cwv.cwG.getView()).setText(getString(2131629993));
    ((TextView)this.cwv.cwP.getView()).setText(getString(2131629963));
    ((TextView)this.cwv.cwM.cAO.getView()).setText(getString(2131630555));
    ((TextView)this.cwv.cwN.cAO.getView()).setText(getString(2131630549));
    ((TextView)this.cwv.cwO.cAO.getView()).setText(getString(2131630384));
    ((TextView)this.cwv.ctm.cAO.getView()).setText(2131630553);
    ((TextView)this.cwv.ctm.cAT.getView()).setText(2131624910);
    ((TextView)this.cwv.cwR.cAT.getView()).setText(2131624910);
    if (!getResources().getBoolean(2131034152))
      ((TextView)this.cwv.ctm.cAT.getView()).setText(""); 
    ((TextView)this.cwv.cwS.cAO.getView()).setText(getString(2131630550));
    ((TextView)this.cwv.cwW.cAO.getView()).setText(getString(2131630558));
    ((TextView)this.cwv.cto.cAO.getView()).setText(getString(2131629984));
    ((TextView)this.cwv.cto.cAT.getView()).setText("%");
    ((EditText)this.cwv.ctm.dwQ.getView()).setInputType(8194);
    ((EditText)this.cwv.cto.dwQ.getView()).setInputType(8194);
    ((EditText)this.cwv.cto.dwQ.getView()).setFilters(ar.bE(3, 2));
    if (!this.chn) {
      ((TextView)this.cwv.cwG.getView()).setVisibility(8);
      ((ViewGroup)this.cwv.cwM.getView()).setVisibility(8);
      ((ViewGroup)this.cwv.cwN.getView()).setVisibility(8);
      ((ViewGroup)this.cwv.cwO.getView()).setVisibility(8);
      ((ViewGroup)this.cwv.cwT.getView()).setVisibility(0);
      ((TextView)this.cwv.cwH.getView()).setVisibility(0);
      ((ViewGroup)this.cwv.cwQ.getView()).setVisibility(8);
      ((EditText)this.cwv.cwT.dwQ.getView()).setFocusable(false);
      ((EditText)this.cwv.cwT.dwQ.getView()).setFocusableInTouchMode(false);
      ((TextView)this.cwv.cwH.getView()).setText(getString(2131629993));
      ((TextView)this.cwv.cwT.cAO.getView()).setText(getString(2131629977));
      ((TextView)this.cwv.cwT.cAT.getView()).setText(getString(2131629978));
      ((EditText)this.cwv.cwT.dwQ.getView()).setInputType(8194);
      ((EditText)this.cwv.cwT.dwQ.getView()).setFilters(ar.bE(3, 2));
      ((ViewGroup)this.cwv.cwT.getView()).setBackgroundResource(2130772035);
    } else {
      ((TextView)this.cwv.cwG.getView()).setVisibility(0);
      ((ViewGroup)this.cwv.cwM.getView()).setVisibility(0);
      ((ViewGroup)this.cwv.cwN.getView()).setVisibility(0);
      ((ViewGroup)this.cwv.cwO.getView()).setVisibility(0);
      ((ViewGroup)this.cwv.cwT.getView()).setVisibility(0);
      ((TextView)this.cwv.cwQ.cAO.getView()).setText(2131630540);
      ((EditText)this.cwv.cwQ.dwQ.getView()).setInputType(8194);
      ((ViewGroup)this.cwv.cwQ.getView()).setBackgroundResource(2130772055);
      ((TextView)this.cwv.cwQ.cAT.getView()).setText(2131624910);
      ((TextView)this.cwv.cwQ.cAP.getView()).setText(2131625088);
      ((ViewGroup)this.cwv.cwT.getView()).setVisibility(8);
      ((TextView)this.cwv.cwH.getView()).setVisibility(8);
    } 
    ((TextView)this.cwv.cwR.cAO.getView()).setText(2131630539);
    ((EditText)this.cwv.cwR.dwQ.getView()).setInputType(8194);
    ((ViewGroup)this.cwv.cwM.getView()).setBackgroundResource(2131231855);
    ((ViewGroup)this.cwv.cwN.getView()).setBackgroundResource(2130772055);
    ((ViewGroup)this.cwv.cwO.getView()).setBackgroundResource(2130772051);
    ((ViewGroup)this.cwv.ctm.getView()).setBackgroundResource(2131231855);
    ((RelativeLayout)this.cwv.cwS.getView()).setBackgroundResource(2131231855);
    ((RelativeLayout)this.cwv.cwW.getView()).setBackgroundResource(2131231847);
    ((ViewGroup)this.cwv.cto.getView()).setBackgroundResource(2131231847);
    ((ViewGroup)this.cwv.cwR.getView()).setBackgroundResource(2130772055);
  }
  
  public boolean Az() { return (this.cww != null) ? this.cww.Az() : 0; }
  
  public void Em() {
    ((LinearLayout)this.cwv.cwK.getView()).setVisibility(8);
    ((ScrollView)this.cwv.cwJ.getView()).setVisibility(8);
    ((ProgressBarCircularIndeterminate)this.cwv.cwL.getView()).setVisibility(0);
  }
  
  public void RA() {
    if (this.titleBar != null) {
      this.titleBar.brk.setVisibility(0);
      this.titleBar.aNv.setVisibility(8);
    } 
  }
  
  public void Rz() {
    if (this.titleBar != null) {
      this.titleBar.brk.setVisibility(8);
      this.titleBar.aNv.setVisibility(0);
    } 
  }
  
  public void Sl() {
    ((LinearLayout)this.cwv.cwK.getView()).setVisibility(0);
    ((ScrollView)this.cwv.cwJ.getView()).setVisibility(8);
    ((ProgressBarCircularIndeterminate)this.cwv.cwL.getView()).setVisibility(8);
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
  
  public void a(aa paramaa) {
    this.titleBar = paramaa;
    if (abd()) {
      ace();
      this.cww.save();
    } 
  }
  
  public void aD(double paramDouble) {
    EditText editText = (EditText)this.cwv.cwR.dwQ.getView();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramDouble);
    stringBuilder.append("");
    editText.setText(stringBuilder.toString());
  }
  
  public void aE(double paramDouble) {
    EditText editText = (EditText)this.cwv.cwQ.dwQ.getView();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramDouble);
    stringBuilder.append("");
    editText.setText(stringBuilder.toString());
  }
  
  public void ace() {
    n.R(getActivity());
    ((LinearLayout)this.cwv.cwI.getView()).requestFocus();
    ((LinearLayout)this.cwv.cwI.getView()).requestFocusFromTouch();
  }
  
  public void af(ArrayList<eh> paramArrayList) {
    this.ctj = paramArrayList;
    ((TextView)this.cwv.cwS.dwP.getView()).setText(this.cww.ah(paramArrayList));
  }
  
  public void az(double paramDouble) {
    EditText editText = (EditText)this.cwv.ctm.dwQ.getView();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramDouble);
    stringBuilder.append("");
    editText.setText(stringBuilder.toString());
  }
  
  public void cE(boolean paramBoolean) { ((CheckBox)this.cwv.cwO.dwV.getView()).setChecked(paramBoolean); }
  
  public void cJ(boolean paramBoolean) { ((CheckBox)this.cwv.cwM.dwV.getView()).setChecked(paramBoolean); }
  
  public void ft(boolean paramBoolean) { ((CheckBox)this.cwv.cwN.dwV.getView()).setChecked(paramBoolean); }
  
  public void fu(boolean paramBoolean) {
    this.cwx = paramBoolean;
    if (this.chn) {
      byte b;
      ViewGroup viewGroup = (ViewGroup)this.cwv.cwM.getView();
      if (paramBoolean) {
        b = 0;
      } else {
        b = 8;
      } 
      viewGroup.setVisibility(b);
    } 
    if (paramBoolean) {
      ((ViewGroup)this.cwv.cwM.getView()).setBackgroundResource(2130772057);
      ((ViewGroup)this.cwv.cwN.getView()).setBackgroundResource(2130772051);
      return;
    } 
    ((ViewGroup)this.cwv.cwN.getView()).setBackgroundResource(2130772052);
  }
  
  public void hi(int paramInt) {
    EditText editText = (EditText)this.cwv.cwT.dwQ.getView();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    editText.setText(stringBuilder.toString());
  }
  
  public void hideProgress() {
    ((LinearLayout)this.cwv.cwK.getView()).setVisibility(0);
    ((ScrollView)this.cwv.cwJ.getView()).setVisibility(0);
    ((ProgressBarCircularIndeterminate)this.cwv.cwL.getView()).setVisibility(8);
  }
  
  public void hj(int paramInt) {
    if (paramInt == 0) {
      ((TextView)this.cwv.cwW.dwP.getView()).setText(2131630547);
      return;
    } 
    TextView textView = (TextView)this.cwv.cwW.dwP.getView();
    String str = getString(2131630557);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    textView.setText(String.format(str, new Object[] { stringBuilder.toString() }));
  }
  
  public void kc(String paramString) {
    StringBuffer stringBuffer = a(paramString, new StringBuffer());
    ((TextView)this.cwv.cwV.getView()).setText(stringBuffer.toString());
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      z z;
      StringBuffer stringBuffer;
      long[] arrayOfLong;
      switch (paramInt1) {
        default:
          return;
        case 2:
          arrayOfLong = paramIntent.getLongArrayExtra("IDs");
          stringBuffer = new StringBuffer();
          for (paramInt1 = 0; paramInt1 < arrayOfLong.length; paramInt1++) {
            if (paramInt1 == 0) {
              stringBuffer.append(arrayOfLong[paramInt1]);
            } else {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(",");
              stringBuilder.append(arrayOfLong[paramInt1]);
              stringBuffer.append(stringBuilder.toString());
            } 
          } 
          z = new z(getContext());
          z.hH(stringBuffer.toString());
          z.close();
          this.cww.h(arrayOfLong);
          hj(arrayOfLong.length);
          a.aKh().r(fq.baQ);
          return;
        case 1:
          break;
      } 
      ArrayList arrayList = (ArrayList)arrayOfLong.getSerializableExtra("couponList");
      this.cww.af(arrayList);
    } 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.cww = new gm(getActivity(), this);
    this.chn = getActivity().getResources().getBoolean(2131034123);
    this.isDiscountConvertion = getActivity().getResources().getBoolean(2131034121);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.cwv = a.p(this);
    setupViews();
    this.cww.init();
    setListeners();
    return this.cwv.getView();
  }
  
  public void p(double paramDouble) {
    EditText editText = (EditText)this.cwv.cto.dwQ.getView();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramDouble);
    stringBuilder.append("");
    editText.setText(stringBuilder.toString());
  }
  
  public void r(String paramString, boolean paramBoolean) {
    if (!n.bL(getActivity()))
      getResources().getBoolean(2131034125); 
    if (TextUtils.isEmpty(paramString) && !a.zR().Ab())
      this.cww.abh(); 
  }
  
  public void save() {
    if (abd())
      this.cww.save(); 
  }
  
  public void showError(String paramString) { Toast.makeText(getActivity(), paramString, 0).show(); }
  
  public void zO() {
    ((ScrollView)this.cwv.cwJ.getView()).setVisibility(0);
    ((LinearLayout)this.cwv.cwK.getView()).setVisibility(8);
    ((ProgressBarCircularIndeterminate)this.cwv.cwL.getView()).setVisibility(8);
  }
  
  public boolean zP() { return isAdded(); }
  
  public static class a extends ab<ViewGroup> {
    public ab<TextView> csT = new ab(2131299582);
    
    public f ctm = new f(2131297691);
    
    public f cto = new f(2131297725);
    
    public ab<TextView> cwG = new ab(2131299635);
    
    public ab<TextView> cwH = new ab(2131299523);
    
    public ab<LinearLayout> cwI = new ab(2131297905);
    
    public ab<ScrollView> cwJ = new ab(2131298899);
    
    public ab<LinearLayout> cwK = new ab(2131297982);
    
    public ab<ProgressBarCircularIndeterminate> cwL = new ab(2131297346);
    
    public l cwM = new l(2131297726);
    
    public l cwN = new l(2131297512);
    
    public l cwO = new l(2131297719);
    
    public ab<TextView> cwP = new ab(2131299524);
    
    public g cwQ = new g(2131297557);
    
    public f cwR = new f(2131297550);
    
    public e cwS = new e(2131297538);
    
    public f cwT = new f(2131297551);
    
    public ab<LinearLayout> cwU = new ab(2131298448);
    
    public ab<TextView> cwV = new ab(2131299780);
    
    public e cwW = new e(2131297558);
    
    public a(int param1Int) { super(param1Int); }
    
    public static a p(Fragment param1Fragment) {
      View view = LayoutInflater.from(param1Fragment.getActivity()).inflate(2131427626, null);
      a a1 = new a(16908290);
      a1.S(view);
      return a1;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\WeshopMarketingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */