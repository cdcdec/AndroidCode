package com.laiqian.main.module.settlement;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jakewharton.b.b;
import com.jakewharton.rxbinding2.a.a;
import com.laiqian.ag;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.aa;
import com.laiqian.entity.aq;
import com.laiqian.entity.z;
import com.laiqian.main.a.b;
import com.laiqian.main.aq;
import com.laiqian.main.b.b;
import com.laiqian.main.b.c;
import com.laiqian.main.bb;
import com.laiqian.main.cr;
import com.laiqian.main.cs;
import com.laiqian.main.di;
import com.laiqian.main.module.settlement.pay.b;
import com.laiqian.main.module.settlement.pay.v;
import com.laiqian.member.e.e;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.pos.AliPayPreorderDetail;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.pos.model.a;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.usage.c;
import com.laiqian.print.usage.receipt.model.a;
import com.laiqian.ui.a.r;
import com.laiqian.util.n;
import io.reactivex.a.a;
import io.reactivex.g.a;
import io.reactivex.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PosActivitySettlementDialogSubmitOrderFragment extends Fragment {
  private a blP;
  
  ag blQ;
  
  PosActivitySettlementDialogFragment.a bnW;
  
  private ag bnX;
  
  private a bnY;
  
  private String bnZ;
  
  @Nullable
  private cs groupDialog;
  
  c payTypeItemViewSelected = c.bpu;
  
  private di settlementRunnable;
  
  public static PosActivitySettlementDialogSubmitOrderFragment Ov() { return new PosActivitySettlementDialogSubmitOrderFragment(); }
  
  private boolean Ow() {
    b b;
    if (!(b = ((b)this.blQ.bmT.bnr.getValue()).OT()).b(b))
      b.aJW = ((Double)this.blQ.bmT.bnt.getValue()).doubleValue(); 
    if (((!b.b(b) && b.aJW != 0.0D && b.aTv == 10001) || this.payTypeItemViewSelected.aTv == 10001) && !RootApplication.getLaiqianPreferenceManager().avT() && RootApplication.getLaiqianPreferenceManager().avs() == 1 && RootApplication.getLaiqianPreferenceManager().QV() == 1) {
      n.eP(2131625902);
      return true;
    } 
    return false;
  }
  
  private boolean Ox() {
    if (!((Boolean)this.blQ.bmT.bnD.getValue()).booleanValue() && !((Boolean)this.blQ.bmT.bnE.getValue()).booleanValue())
      return false; 
    if (Oy())
      return false; 
    b b = (cy)this.blQ.bmT.bnC.bnU.getValue();
    if (b.OF()) {
      n.o(b.ax(getActivity()));
      return true;
    } 
    if (b.OG()) {
      n.o(b.ay(getActivity()));
      return true;
    } 
    if (((Boolean)this.blQ.bmT.bnD.getValue()).booleanValue()) {
      b b1 = this.blQ.bmz;
    } else {
      b = this.blQ.bmT.bnt;
    } 
    String str = ((Double)b.getValue()).toString();
    a(str, (b)this.blQ.bmT.bnr.getValue(), ((Boolean)this.blQ.bmB.getValue()).booleanValue(), this.payTypeItemViewSelected);
    return true;
  }
  
  private cs Oz() {
    if (this.groupDialog == null)
      this.groupDialog = new cs(getActivity(), new ce(this)); 
    this.groupDialog.setCancelable(false);
    this.groupDialog.aa(((Double)this.blQ.bmz.getValue()).doubleValue());
    return this.groupDialog;
  }
  
  private void a(String paramString, b paramb, boolean paramBoolean, c paramc) { throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n"); }
  
  private boolean canSettlement() {
    v v = (v)this.blQ.bmT.bnC.bnP.getValue();
    if (v.Pd())
      return true; 
    if (!v.a(v))
      cr.a(getActivity(), v.Pb(), v.Pc()); 
    return false;
  }
  
  private void executeSettlementOfChainMember() { a.aKh().r(this.settlementRunnable); }
  
  private boolean handleCouponPaySubmit() {
    if (this.payTypeItemViewSelected.aTv == 10014) {
      if (isVerificationGroup()) {
        String str = this.groupDialog.xq();
        if (TextUtils.isEmpty(str)) {
          n.o("团购验证券对应的单号为空");
          return true;
        } 
        if (this.groupDialog.LI() > ((Double)this.blQ.bmG.getValue()).doubleValue()) {
          showAlertIfCouponAmoutBiggerThanPayableAmount();
          return true;
        } 
        settlement(str);
        return true;
      } 
      Oz();
      return true;
    } 
    return false;
  }
  
  private boolean handleReturnMode() {
    if (!((Boolean)this.blQ.bmB.getValue()).booleanValue()) {
      b b = new b(getContext());
      if (b.Pl()) {
        if (!handleVIPSubmit())
          settlement(null); 
      } else {
        b.a(new cb(this));
      } 
      return true;
    } 
    return false;
  }
  
  private boolean handleVIPSubmit() {
    aq aq;
    if (this.payTypeItemViewSelected.aTv == 10006 && !(aq = (aq)this.blQ.bmC.getValue()).a(aq) && aq.aWH.isOpen) {
      (new e(getActivity(), aq, new cc(this))).s(aq);
      return true;
    } 
    return false;
  }
  
  private boolean hasPendingOrder(bb parambb) {
    Iterator iterator = parambb.bbT.iterator();
    while (iterator.hasNext()) {
      if (((aa)iterator.next()).GN())
        return true; 
    } 
    return false;
  }
  
  private boolean isOnlinePayType(int paramInt) { return (paramInt == 10007 || paramInt == 10009); }
  
  private boolean isVerificationGroup() { return (this.bnY.leftViewLimit != null && this.bnY.leftViewLimit.getVisibility() == 0); }
  
  private b obtainPayTypeItemByPayTypeItemView(c paramc, double paramDouble) { return new b(paramc.aTv, paramDouble, paramc.aKu.getText().toString(), paramc.aTe); }
  
  private Object[] preSettlement(String paramString, boolean paramBoolean) {
    if (this.settlementRunnable != null)
      return null; 
    boolean bool1 = ((Boolean)this.blQ.bmB.getValue()).booleanValue();
    boolean bool2 = ((Boolean)this.blQ.bmA.getValue()).booleanValue();
    if (bool2) {
      if (((Double)this.blQ.beT.getValue()).doubleValue() > 100.0D) {
        n.eP(2131627260);
        return null;
      } 
    } else if (TextUtils.isEmpty(this.bnY.bof.getText().toString())) {
      n.eP(2131627258);
      return null;
    } 
    double d5 = ((Double)this.blQ.beT.getValue()).doubleValue();
    if (bool2 ? (d5 > 100.0D) : (d5 > 300.0D)) {
      int j;
      if (bool2) {
        j = 2131627466;
      } else {
        j = 2131627254;
      } 
      n.eP(j);
      return null;
    } 
    double d3 = 0.0D;
    if (d5 < 0.0D) {
      n.eP(2131627255);
      return null;
    } 
    double d4 = ((Double)this.blQ.beU.getValue()).doubleValue();
    double d2 = ((Double)this.blQ.bmz.getValue()).doubleValue();
    if (TextUtils.isEmpty(this.bnY.bog.getText().toString())) {
      n.eP(2131626368);
      return null;
    } 
    if (TextUtils.isEmpty(this.bnY.bod.getText().toString())) {
      n.eP(2131627252);
      return null;
    } 
    if (d2 >= 1.0E8D) {
      n.eP(2131626205);
      return null;
    } 
    if (d2 < 0.0D) {
      n.eP(2131626369);
      return null;
    } 
    double d1 = d2;
    if (d2 > d4)
      d1 = d4; 
    d2 = ((Double)this.blQ.bmH.getValue()).doubleValue();
    if (((Boolean)this.blQ.bmF.getValue()).booleanValue())
      d3 = d2; 
    double d6 = ((Double)this.blQ.bmT.bnt.getValue()).doubleValue();
    if (d4 - d1 - d6 - d3 > 1.0E-6D) {
      if (bool1) {
        n.eP(2131627252);
        return null;
      } 
      n.eP(2131627253);
      return null;
    } 
    aq aq1 = (aq)this.blQ.bmC.getValue();
    if ((null = aq1).a(aq1))
      null = null; 
    if (this.payTypeItemViewSelected.aTv == 10006 && null == null) {
      n.eP(2131627256);
      return null;
    } 
    null = this.blQ.blR.bea.beO.aoL();
    double d7 = ((Double)this.blQ.bmy.getValue()).doubleValue();
    int i = ((Integer)this.blQ.beb.getValue()).intValue();
    if (bool1) {
      Iterator iterator = null.iterator();
      for (d2 = 0.0D; iterator.hasNext(); d2 += d9 * d8) {
        double d8;
        aa aa = (aa)iterator.next();
        double d9 = aa.GK();
        if (aa.Gv()) {
          d8 = 1.0D;
        } else {
          d8 = d5 / 100.0D;
        } 
      } 
    } else {
      d2 = 0.0D;
    } 
    bb bb = new bb(bool1, null, d7, d5);
    bb.orderNo = paramString;
    bb.vipEntity = null;
    bb.bca = d3;
    bb.amountRounding = 0.0D;
    bb.bcf = i;
    bb.aTZ = ((Boolean)this.blQ.bmV.getValue()).booleanValue();
    bb.bcm = ((Boolean)this.blQ.bmX.getValue()).booleanValue();
    bb.bcn = ((Boolean)this.blQ.bmY.getValue()).booleanValue();
    bb.Y(d2);
    TableEntity tableEntity = (TableEntity)this.blQ.beg.getValue();
    if ((null = tableEntity).l(tableEntity))
      null = null; 
    if (null != null)
      bb.bch = b.a(null.Yb(), null.Ye(), null.Yf(), null.DP()); 
    if (d4 == 0.0D || d1 != 0.0D || !aq.a(null)) {
      if (this.payTypeItemViewSelected.aTv == 10014 && this.groupDialog != null) {
        d2 = this.groupDialog.LI();
        bb.bcb = d1 - d2;
        String str = this.groupDialog.LH();
        d1 = d2;
      } else {
        null = null;
      } 
      b b1 = obtainPayTypeItemByPayTypeItemView(this.payTypeItemViewSelected, d1);
      if (b1.aTv == 10001) {
        d1 = ((Double)this.blQ.bmT.bnt.getValue()).doubleValue();
        if (d1 > 0.0D)
          b1.aTw = d1; 
        bool1 = true;
      } else {
        bool1 = false;
      } 
      b1.aTy = null;
      bb.bbS.add(b1);
      bb.bbY += b1.aJW;
    } else {
      bool1 = false;
    } 
    b b = (b)this.blQ.bmT.bnr.getValue();
    bool2 = bool1;
    if (!b.c(b)) {
      bool2 = bool1;
      if (d6 != 0.0D) {
        bool2 = bool1;
        if (b.OS()) {
          z z = new z(b.OT(), d6);
          if (z.aTv == 10001) {
            bb.bbS.add(0, z);
            bool1 = true;
          } else {
            bb.bbS.add(z);
          } 
          bb.bbY += d6;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("添加了组合支付：");
          stringBuilder.append(d6);
          n.println(stringBuilder.toString());
          bool2 = bool1;
        } 
      } 
    } 
    if ((i == 7 || i == 14) && null != null) {
      bb.bbR = Long.valueOf(null.getID());
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(null.getID());
      stringBuilder.append("");
      bb.bbQ = stringBuilder.toString();
      bb.openTableName = (String)this.blQ.bni.getValue();
    } else if (((Boolean)this.blQ.bmZ.getValue()).booleanValue()) {
      null = new StringBuilder();
      null.append(this.blQ.bng.getValue());
      null.append("");
      String str = null.toString();
      if (str.length() > 0)
        bb.bbQ = str; 
    } 
    aq aq = (PendingFullOrderDetail)this.blQ.bej.getValue();
    if (paramBoolean) {
      if (c.bi(getContext()).ahV().size() != 0) {
        if (aq != null) {
          aq = new aq(getActivity(), bb, aq, true);
        } else if (hasPendingOrder(bb) && bb.bbQ != null) {
          a a1 = new a(getActivity());
          PendingFullOrderDetail pendingFullOrderDetail = a1.ks(bb.bbQ);
          a1.close();
          aq = new aq(getActivity(), bb, pendingFullOrderDetail, true);
        } else {
          aq = new aq(getActivity(), bb, true);
        } 
        aq.df(true);
        aq.start();
        n.eP(2131627422);
      } else {
        n.eP(2131628807);
      } 
    } else {
      this.settlementRunnable = new di(getActivity(), bb, bool2, new cd(this));
      if (aq != PendingFullOrderDetail.coB)
        this.settlementRunnable.setDeletedPendingOrder(aq); 
      executeSettlementOfChainMember();
    } 
    return new Object[] { bb, Boolean.valueOf(bool2) };
  }
  
  private void setVerificationGroup(boolean paramBoolean) {
    this.blQ.bmJ.accept(Boolean.valueOf(paramBoolean));
    if (paramBoolean) {
      if (this.bnY.leftViewLimit == null) {
        this.bnY.leftViewLimit.setFocusable(true);
        this.bnY.leftViewLimit.setFocusableInTouchMode(true);
        this.bnY.leftViewLimit.setOnKeyListener(new bz(this));
      } 
      this.bnY.leftViewLimit.setVisibility(0);
      this.bnY.leftViewLimit.requestFocus();
      this.bnY.submitButton.setText(2131626884);
      this.bnY.verificationCheckButton.setVisibility(0);
      return;
    } 
    if (this.bnY.verificationCheckButton.getVisibility() != 8)
      this.bnY.verificationCheckButton.setVisibility(8); 
    if (this.bnY.leftViewLimit != null)
      this.bnY.leftViewLimit.setVisibility(8); 
  }
  
  private void settlement(String paramString) {
    if (c.f(this.payTypeItemViewSelected))
      return; 
    preSettlement(paramString, false);
  }
  
  private void showAlertIfCouponAmoutBiggerThanPayableAmount() {
    r r = new r(getActivity(), new ca(this));
    r.setTitle(getActivity().getString(2131626722));
    r.s(getActivity().getString(2131627336));
    r.oZ(getActivity().getString(2131627337));
    r.t(getActivity().getString(2131626715));
    r.show();
  }
  
  public boolean Oy() { return TextUtils.isEmpty(this.bnZ) ^ true; }
  
  public ArrayList<PrintContent> a(Bitmap paramBitmap, AliPayPreorderDetail paramAliPayPreorderDetail) {
    a a1 = a.bo(RootApplication.zv());
    paramAliPayPreorderDetail.ceY = Bitmap.createScaledBitmap(paramBitmap, 360, 360, true);
    return a1.b(paramAliPayPreorderDetail);
  }
  
  public void b(PosActivitySettlementDialogFragment.a parama) { this.bnW = parama; }
  
  public void b(ag paramag) { this.blQ = paramag; }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.bnY = new a(this.bnW);
    return this.bnY.submitButton;
  }
  
  public void onStop() {
    super.onStop();
    this.blP.clear();
  }
  
  public void onViewCreated(View paramView, @Nullable Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    this.blP = new a();
    setVerificationGroup(false);
    this.blP.b(this.blQ.bmT.bnm.b(new bx(this)));
    this.blP.b(a.bu(this.bnY.boc).b(new cf(this)));
    this.blP.b(a.bu(this.bnY.bob).b(new cg(this)));
    this.blP.b(a.bu(this.bnY.submitButton).b(new ch(this)));
    this.blP.b(a.bu(this.bnY.verificationCheckButton).b(new ci(this)));
    this.blP.b(this.blQ.bmT.bnr.b(new cj(this)));
    this.blP.b(h.a(this.blQ.bmT.bnG, this.blQ.bmT.bnF, this.blQ.bmT.bnm, this.blQ.bmT.bnr, new ck(this)).aJk());
    this.blQ.bmK.b(new cl(this));
  }
  
  static class a {
    LinearLayout bob;
    
    LinearLayout boc;
    
    TextView bod;
    
    TextView boe;
    
    TextView bof;
    
    TextView bog;
    
    View leftViewLimit;
    
    TextView submitButton;
    
    View verificationCheckButton;
    
    public a(PosActivitySettlementDialogFragment.a param1a) {
      this.submitButton = param1a.submitButton;
      this.leftViewLimit = param1a.leftViewLimit;
      this.verificationCheckButton = param1a.verificationCheckButton;
      this.bob = param1a.blZ;
      this.boc = param1a.blY;
      this.bod = param1a.bmh;
      this.boe = param1a.etPaidOfSecond;
      this.bof = param1a.bma;
      this.bog = param1a.bmd;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\PosActivitySettlementDialogSubmitOrderFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */