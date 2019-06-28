package com.laiqian.member.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.LQKVersion;
import com.laiqian.basic.RootApplication;
import com.laiqian.bi;
import com.laiqian.c.a;
import com.laiqian.entity.al;
import com.laiqian.entity.aq;
import com.laiqian.entity.h;
import com.laiqian.entity.n;
import com.laiqian.g.a;
import com.laiqian.k.a;
import com.laiqian.member.f.a;
import com.laiqian.member.h.a;
import com.laiqian.member.h.c;
import com.laiqian.models.ah;
import com.laiqian.pos.PayTypeSpecific;
import com.laiqian.pos.aw;
import com.laiqian.pos.bm;
import com.laiqian.print.dualscreen.o;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.usage.receipt.model.c;
import com.laiqian.ui.a.bb;
import com.laiqian.util.ar;
import com.laiqian.util.au;
import com.laiqian.util.av;
import com.laiqian.util.by;
import com.laiqian.util.l;
import com.laiqian.util.n;
import com.laiqian.vip.R;
import com.zhuge.analysis.b.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.c;

public abstract class a extends aw {
  TextView aAs;
  
  private Context aTg;
  
  TextView bvD;
  
  TextView bvw;
  
  a bwA;
  
  private double bwB = -1.0D;
  
  private double bwC = -1.0D;
  
  private String bwD = "";
  
  private double bwE;
  
  private double bwF;
  
  protected a bwG;
  
  a bwH;
  
  c bwI;
  
  private TextView bwJ;
  
  public h bwK;
  
  public al bwL;
  
  TextWatcher bwM = new g(this);
  
  View.OnClickListener bwN = new c(this);
  
  View.OnFocusChangeListener bwO = new d(this);
  
  View.OnClickListener bwP = new e(this);
  
  private b bwQ;
  
  TextView bwu;
  
  EditText bwv;
  
  EditText bww;
  
  LinearLayout bwx;
  
  Button bwy;
  
  aq bwz;
  
  @Nullable
  private o dualPresentation;
  
  bi onlinePayDialog;
  
  n onlinePayEntity;
  
  Handler scanCodeHandle = new j(this);
  
  private String scanCodeOrderNo;
  
  private bb waitingDialog;
  
  public a(Context paramContext1, Context paramContext2) {
    super(paramContext1, R.style.dialog_fullscreen);
    this.aTg = paramContext2;
    View view = ((LayoutInflater)paramContext1.getSystemService("layout_inflater")).inflate(R.layout.dialog_vip_charge, null);
    this.bwG = new a(paramContext1, true, new b(this));
    if (RootApplication.getLaiqianPreferenceManager().QV() == 1) {
      this.bwB = RootApplication.getLaiqianPreferenceManager().avD();
      this.bwC = RootApplication.getLaiqianPreferenceManager().avE();
      this.bwD = RootApplication.getLaiqianPreferenceManager().avX();
    } 
    if (LQKVersion.zl() && !RootApplication.getLaiqianPreferenceManager().isMultipleShop()) {
      this.bwH = new a(paramContext1);
      this.bwH.a(new f(this, paramContext1));
    } else {
      this.bwI = new c(paramContext1);
    } 
    setContentView(view);
  }
  
  private void QA() {
    this.bww.setFilters(ar.lw(9999));
    InputFilter inputFilter = ar.lx(99);
    InputFilter.LengthFilter lengthFilter = new InputFilter.LengthFilter(10);
    this.bwv.setFilters(new InputFilter[] { inputFilter, lengthFilter });
  }
  
  private boolean QB() {
    if (l.pg(this.bvD.getText().toString().trim())) {
      Toast.makeText(this.mContext, this.mContext.getString(R.string.pos_member_charge_number_not_empty), 0).show();
      return false;
    } 
    if (l.pg(this.bwv.getText().toString().trim())) {
      Toast.makeText(this.mContext, this.mContext.getString(R.string.pos_member_charge_amount_can_not_be_empty), 0).show();
      this.bwv.requestFocus();
      return false;
    } 
    if (n.u(this.bwv.getText().toString().trim()) > 1.0E8D) {
      n.eP(R.string.pos_alipay_AMOUNT_IS_OUT_RANG);
      this.bwv.requestFocus();
      return false;
    } 
    if (n.u(this.bww.getText().toString().trim()) > 1.0E8D) {
      n.eP(R.string.pos_alipay_AMOUNT_IS_OUT_RANG);
      this.bww.requestFocus();
      return false;
    } 
    return !!fE(this.bwz.aWn);
  }
  
  private void QC() {
    if (RootApplication.getLaiqianPreferenceManager().QV() == 1) {
      this.bww.setText("0");
      dG(RootApplication.getLaiqianPreferenceManager().atj());
    } else {
      this.bww.setText("");
    } 
    this.bvD.setText("");
    this.aAs.setText("");
    this.bwu.setText("");
    this.bvw.setText("");
    this.bwv.setText("");
    if (this.bwz != null)
      this.bwz.aWy = 0.0D; 
  }
  
  private void a(String paramString, TextView paramTextView) { throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n"); }
  
  private void changePayTypeItemPayType(Message paramMessage) {
    if (a.zR().At()) {
      long l = paramMessage.arg1;
      (new TextView(getContext())).setText(PayTypeSpecific.cn(l));
      this.bwG.bys.aTe = l;
      this.bwG.byt = getContext().getString(PayTypeSpecific.cn(l));
      this.bwG.bys.aTv = PayTypeSpecific.co(l);
      a a1 = this.bwG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(PayTypeSpecific.co(l));
      stringBuilder.append("");
      a1.byv = stringBuilder.toString();
    } 
  }
  
  private void dH(boolean paramBoolean) {
    if (!paramBoolean)
      return; 
    String str = this.bwv.getText().toString().trim();
    if (TextUtils.isEmpty(str)) {
      n.eP(R.string.pos_alipay_AMOUNT_IS_OUT_RANG);
      return;
    } 
    if (n.u(str) < 0.01D || n.u(str) > 1.0E8D) {
      n.eP(R.string.pos_alipay_AMOUNT_IS_OUT_RANG);
      return;
    } 
    if (n.u(this.bww.getText().toString()) > 1.0E8D) {
      n.eP(R.string.pos_alipay_AMOUNT_IS_OUT_RANG);
      return;
    } 
    double d = n.aU(str);
    if (d < 0.01D || d > 1.0E8D) {
      n.eP(R.string.pos_alipay_AMOUNT_IS_OUT_RANG);
      return;
    } 
    this.scanCodeOrderNo = n.j(new Date());
    this.bwG.resetFirstPayTypeItemView(-1L);
    a(str, this.bwv);
  }
  
  @NonNull
  private aq getVipEntity() {
    double d1 = by.parseDouble(this.bwv.getText().toString().trim());
    double d2 = by.parseDouble(this.bww.getText().toString().trim());
    aq aq1 = new aq(this.bwz.aSW, this.bwz.aWn, this.bwz.name, this.bwz.aTp, this.bwz.aWo, this.bwz.discount, (int)this.bwz.aWp, this.bwz.aWC);
    aq1.aWy = aq1.aWo + d1 + d2;
    aq1.aWA = d1;
    aq1.aWB = d2;
    aq1.aWz = System.currentTimeMillis();
    return aq1;
  }
  
  private ArrayList<PrintContent> q(Bitmap paramBitmap) {
    String str;
    ArrayList arrayList = new ArrayList();
    c c1 = c.bp(this.mContext);
    double d = this.bwz.aWo;
    Double double1;
    Double double2 = (double1 = Double.valueOf(bm.o(this.bwv.getText().toString(), 2))).valueOf(bm.o(this.bww.getText().toString(), 2));
    if (n.bL(getContext())) {
      str = by.bv(this.bwz.name, "*");
    } else {
      str = this.bwz.name;
    } 
    arrayList.add(c1.a(new Date(System.currentTimeMillis()), str, by.bu(this.bwz.aTp, "****"), by.bu(this.bwz.aWn, "****"), Double.valueOf(d), double1, double2, Bitmap.createScaledBitmap(paramBitmap, 360, 360, true), this.bwG.byt));
    return arrayList;
  }
  
  private void showOnlineBarcodePayInDualPresentation(boolean paramBoolean) {
    o o1;
    if ((o1 = this.dualPresentation).afM() != null) {
      if (this.bwG.bys.aTe == 5L) {
        (o1 = this.dualPresentation).afM().afP().fN(paramBoolean);
        return;
      } 
      if (this.bwG.bys.aTe == 1L) {
        (o1 = this.dualPresentation).afM().afP().fM(paramBoolean);
        return;
      } 
      if (!paramBoolean)
        (o1 = this.dualPresentation).afM().afP().fM(paramBoolean); 
    } 
  }
  
  protected void QD() { dI(false); }
  
  protected abstract void QE();
  
  public void a(al paramal) { this.bwL = paramal; }
  
  public void a(h paramh) { this.bwK = paramh; }
  
  public void a(b paramb) { this.bwQ = paramb; }
  
  protected abstract boolean a(aq paramaq, String paramString1, String paramString2, boolean paramBoolean);
  
  public double ah(double paramDouble) {
    ArrayList arrayList = au.aW(this.bwD);
    double d1 = 0.0D;
    double d2 = d1;
    if (arrayList != null) {
      d2 = d1;
      if (arrayList.size() > 0) {
        byte b2;
        double d4;
        double d3;
        ArrayList arrayList1 = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean bool = false;
        byte b1;
        for (b1 = 0; b1 < arrayList.size(); b1++)
          arrayList1.add(Double.valueOf(n.u((CharSequence)((Map)arrayList.get(b1)).get("fChargeAmount")))); 
        Collections.sort(arrayList1, Collections.reverseOrder());
        b1 = 0;
        while (true) {
          d3 = d1;
          b2 = bool;
          d4 = paramDouble;
          if (b1 < arrayList1.size()) {
            for (b2 = 0; b2 < arrayList.size(); b2++) {
              if (((Double)arrayList1.get(b1)).doubleValue() == n.u((CharSequence)((Map)arrayList.get(b2)).get("fChargeAmount")))
                arrayList2.add(Double.valueOf(n.u((CharSequence)((Map)arrayList.get(b2)).get("fBonusAmount")))); 
            } 
            b1++;
            continue;
          } 
          break;
        } 
        while (true) {
          d2 = d3;
          if (b2 < arrayList1.size()) {
            d1 = d3;
            paramDouble = d4;
            if (d4 / ((Double)arrayList1.get(b2)).doubleValue() >= 1.0D) {
              d1 = d3 + (int)(d4 / ((Double)arrayList1.get(b2)).doubleValue()) * ((Double)arrayList2.get(b2)).doubleValue();
              paramDouble = d4 - (int)(d4 / ((Double)arrayList1.get(b2)).doubleValue()) * ((Double)arrayList1.get(b2)).doubleValue();
            } 
            b2++;
            d3 = d1;
            d4 = paramDouble;
            continue;
          } 
          break;
        } 
      } 
    } 
    return d2;
  }
  
  protected void ct(View paramView) {
    boolean bool;
    super.ct(paramView);
    this.bwx = (LinearLayout)this.oR.findViewById(R.id.title_l);
    this.bwu = (TextView)this.oR.findViewById(R.id.tv_phone);
    this.aAs = (TextView)this.oR.findViewById(R.id.tv_amount);
    this.bvw = (TextView)this.oR.findViewById(R.id.tv_points);
    this.bvD = (TextView)this.oR.findViewById(R.id.tv_card_number);
    this.bwv = (EditText)this.oR.findViewById(R.id.et_charge_amount);
    this.bww = (EditText)this.oR.findViewById(R.id.et_gift_amount);
    this.bwy = (Button)this.oR.findViewById(R.id.btn_submit);
    this.bwG.cu(paramView);
    QA();
    if (LQKVersion.zl() && !RootApplication.getLaiqianPreferenceManager().isMultipleShop()) {
      bool = this.bwH.Rl();
    } else {
      bool = this.bwI.Rl();
    } 
    String str = RootApplication.getLaiqianPreferenceManager().atp();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(ah.bRU);
    stringBuilder.append("");
    if (str.equals(stringBuilder.toString())) {
      dG(true);
    } else {
      if (!bool) {
        bool = true;
      } else {
        bool = false;
      } 
      dG(bool);
    } 
    if (RootApplication.getLaiqianPreferenceManager().QV() == 1)
      dG(RootApplication.getLaiqianPreferenceManager().atj()); 
    this.bwv.addTextChangedListener(this.bwM);
  }
  
  void dG(boolean paramBoolean) {
    this.bww.setEnabled(paramBoolean);
    this.bww.setFocusable(paramBoolean);
    this.bww.setClickable(paramBoolean);
    if (paramBoolean) {
      this.bww.setTextColor(this.mContext.getResources().getColor(R.color.setting_text_color3));
      return;
    } 
    this.bww.setTextColor(this.mContext.getResources().getColor(R.color.pos_text_black));
  }
  
  protected void dI(boolean paramBoolean) {
    if (this.bwA != null && this.bwA.getStatus() == AsyncTask.Status.RUNNING)
      return; 
    this.bwy.setClickable(false);
    this.bwE = 0.0D;
    try {
      this.bwE = Double.parseDouble(this.bwv.getText().toString().trim());
    } catch (NumberFormatException numberFormatException) {
      a.e(numberFormatException);
    } 
    this.bwF = 0.0D;
    str = this.bww.getText().toString().trim();
    if (str != null && !"".equals(str))
      try {
        this.bwF = Double.parseDouble(this.bww.getText().toString().trim());
      } catch (NumberFormatException str) {
        a.e(str);
      }  
    if (this.bwE == 0.0D && this.bwF == 0.0D) {
      Toast.makeText(this.mContext, this.mContext.getString(R.string.pos_charge_success), 0).show();
      dismiss();
      av av = new av(this.mContext);
      av.hA(true);
      av.close();
      initialData();
      dismiss();
      return;
    } 
    this.bwz.aWy = this.bwz.aWo + this.bwE + this.bwF;
    this.bwz.aWA = this.bwE;
    this.bwz.aWB = this.bwF;
    this.bwz.aWz = System.currentTimeMillis();
    this.bwA = new a(this, paramBoolean);
    this.bwA.execute(new aq[] { this.bwz });
  }
  
  protected abstract boolean fE(String paramString);
  
  protected void initialData() {
    super.initialData();
    QC();
  }
  
  public void l(String[] paramArrayOfString) {
    this.bwz = new aq();
    this.bwz.aSW = Long.valueOf(paramArrayOfString[0]).longValue();
    this.bwz.aWn = paramArrayOfString[1];
    this.bwz.aTp = paramArrayOfString[2];
    this.bwz.aWp = Double.valueOf(paramArrayOfString[3]).intValue();
    this.bwz.name = paramArrayOfString[5];
    this.bwz.aWo = 0.0D;
    if (paramArrayOfString[4] != null && !"".equals(paramArrayOfString[4]))
      this.bwz.aWo = Double.parseDouble(paramArrayOfString[4]); 
    if (paramArrayOfString[6] != null && !"".equals(paramArrayOfString[6]))
      this.bwz.aWC = Integer.parseInt(paramArrayOfString[6]); 
  }
  
  public void n(aq paramaq) { this.bwz = paramaq; }
  
  protected void o(aq paramaq) {
    this.mContext.sendBroadcast(new Intent("pos_activity_change_data_vip"));
    String str = new HashMap();
    str.put("赠送金额", Double.valueOf(this.bwF));
    str.put("充值金额", Double.valueOf(this.bwE));
    str.put("充值方式", "现金");
    str.put("会员手机号", paramaq.aTp);
    str.put("充值后余额", Double.valueOf(paramaq.aWy));
    a.aAU().c(this.mContext, "会员充值", str);
    c c1 = c.bp(this.mContext);
    double d1 = paramaq.aWo;
    double d2 = this.bwE;
    double d3 = this.bwF;
    if (n.bL(this.mContext)) {
      String str1 = by.bv(paramaq.name, "*");
    } else {
      str = paramaq.name;
    } 
    if (RootApplication.getLaiqianPreferenceManager().QV() == 1 && this.mContext.getString(R.string.pos_main_pay_payment_cash).equals(this.bwG.byt))
      this.bwG.byt = ""; 
    c1.e(c1.a(new Date(System.currentTimeMillis()), str, by.bu(paramaq.aTp, "****"), by.bu(paramaq.aWn, "****"), Double.valueOf(d1), Double.valueOf(d2), Double.valueOf(d3), null, this.bwG.byt));
    paramaq.aWo = paramaq.aWy;
    initialData();
    dismiss();
    av av = new av(this.mContext);
    av.hA(true);
    av.close();
    if (this.bwQ != null)
      this.bwQ.b(paramaq); 
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getRepeatCount() > 0)
      return false; 
    if (paramInt == 4 && paramKeyEvent.getRepeatCount() == 0) {
      this.bwx.performClick();
      return false;
    } 
    if (paramInt != 62)
      return false; 
    this.bwy.performClick();
    return false;
  }
  
  protected void onStart() {
    super.onStart();
    this.bvD.setText(by.H(this.bwz.aWn, 9999));
    this.bwu.setText(by.G(this.bwz.aTp, 9999));
    TextView textView = this.aAs;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.bwz.aWo);
    stringBuilder.append("");
    textView.setText(by.a(stringBuilder.toString(), 9999, this.mContext));
    this.bvw.setText(String.valueOf(this.bwz.aWp));
    this.bwv.requestFocus();
  }
  
  protected void showWaitingDialog(boolean paramBoolean) {
    if (paramBoolean) {
      if (this.waitingDialog == null) {
        this.waitingDialog = new bb(this.aTg);
        this.waitingDialog.setCancelable(false);
      } 
      if (!this.waitingDialog.isShowing()) {
        this.waitingDialog.show();
        return;
      } 
    } else if (this.waitingDialog != null) {
      this.waitingDialog.cancel();
    } 
  }
  
  protected void xU() {
    super.xU();
    null = getWindow();
    l.a(null, this.bwv);
    l.a(null, this.bww);
    this.bwy.setOnClickListener(this.bwP);
    this.bwx.setOnClickListener(this.bwN);
    this.bwv.setOnFocusChangeListener(this.bwO);
    this.bww.setOnFocusChangeListener(this.bwO);
    LinearLayout linearLayout = (LinearLayout)this.oR.findViewById(R.id.llPosMemberChargeAmount);
    RelativeLayout relativeLayout = (RelativeLayout)this.oR.findViewById(R.id.llPosMemberChargeGrantAmount);
    this.bwJ = (TextView)this.oR.findViewById(R.id.tv_charge_gift_product);
    TextView textView = this.bwJ;
    boolean bool = LQKVersion.zl();
    byte b2 = 8;
    if (bool && !RootApplication.getLaiqianPreferenceManager().isMultipleShop()) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    textView.setVisibility(b1);
    View view = this.oR.findViewById(R.id.tv_charge_gift_product_label);
    byte b1 = b2;
    if (LQKVersion.zl()) {
      b1 = b2;
      if (!RootApplication.getLaiqianPreferenceManager().isMultipleShop())
        b1 = 0; 
    } 
    view.setVisibility(b1);
    if (linearLayout != null)
      linearLayout.setOnClickListener(new k(this)); 
    if (relativeLayout != null)
      relativeLayout.setOnClickListener(new l(this)); 
    this.bwv.addTextChangedListener(new m(this));
  }
  
  class a extends AsyncTask<aq, Void, Object> {
    boolean bwU;
    
    public a(a this$0, boolean param1Boolean) { this.bwU = param1Boolean; }
    
    protected Object b(aq[] param1ArrayOfaq) { return Boolean.valueOf(this.bwR.a(param1ArrayOfaq[0], this.bwR.bwG.byv, this.bwR.bwG.byu, this.bwU)); }
    
    protected void onPostExecute(Object param1Object) {
      super.onPostExecute(param1Object);
      if (((Boolean)param1Object).booleanValue() == true) {
        c.aYt().cM(new a());
        a.p(this.bwR).sendBroadcast(new Intent("pos_activity_change_data_vip"));
        this.bwR.o(this.bwR.bwz);
        Toast.makeText(a.q(this.bwR), a.r(this.bwR).getString(R.string.pos_charge_success), 0).show();
        a.a(by.parseInt(this.bwR.bwG.byv), this.bwR.bwG.byu, a.s(this.bwR), "pos_vip_charge_click");
      } else {
        this.bwR.QE();
        this.bwR.bwy.setEnabled(true);
        this.bwR.bwy.setClickable(true);
        this.bwR.bwy.setFocusable(true);
      } 
      this.bwR.showWaitingDialog(false);
    }
    
    protected void onPreExecute() {
      super.onPreExecute();
      this.bwR.showWaitingDialog(true);
    }
  }
  
  public static interface b {
    void b(aq param1aq);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */