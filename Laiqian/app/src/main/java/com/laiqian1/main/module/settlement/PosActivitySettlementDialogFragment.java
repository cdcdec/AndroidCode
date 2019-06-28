package com.laiqian.main.module.settlement;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.Html;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jakewharton.rxbinding2.a.a;
import com.jakewharton.rxbinding2.b.e;
import com.laiqian.auth.au;
import com.laiqian.auth.cj;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.d.a;
import com.laiqian.entity.aq;
import com.laiqian.main.b.b;
import com.laiqian.main.dl;
import com.laiqian.main.module.settlement.pay.PosActivitySettlementDialogPayTypeFragment;
import com.laiqian.member.a.n;
import com.laiqian.member.a.o;
import com.laiqian.rx.b.e;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.bc;
import com.laiqian.ui.a.g;
import com.laiqian.ui.a.r;
import com.laiqian.util.by;
import com.laiqian.util.l;
import com.laiqian.util.m;
import com.laiqian.util.n;
import io.reactivex.a.a;
import io.reactivex.h;
import io.reactivex.h.a;
import java.util.List;

public class PosActivitySettlementDialogFragment extends DialogFragment {
  private a blO;
  
  private a blP;
  
  private ag blQ;
  
  private dl blR;
  
  boolean blS;
  
  r blT;
  
  g selectPaidSecondDialog;
  
  r vipBalanceInsufficientDialog;
  
  private void Oj() {
    if (this.blT != null && this.blT.isShowing())
      this.blT.dismiss(); 
    this.blT = new r(getActivity(), 3, null);
    this.blT.setTitle(getActivity().getString(2131627480));
    this.blT.s(getActivity().getString(2131625763));
    this.blT.pa(getActivity().getString(2131626861));
    this.blT.show();
  }
  
  private void Ok() {
    int i;
    this.blQ.bmT.bnC.bnM.accept(this.blQ.beU.getValue());
    TextView textView = this.blO.bmr;
    if (!((Boolean)this.blQ.bmB.getValue()).booleanValue()) {
      i = 2131629478;
    } else {
      i = 2131627287;
    } 
    textView.setText(i);
    this.blP.b(this.blQ.bmN.b(new s(this)));
    this.blP.b(this.blQ.beT.b(new t(this)));
  }
  
  private void Ol() { this.blQ.bmT.bnm.b(new u(this)); }
  
  private void a(Double paramDouble1, Double paramDouble2, cy paramcy, Boolean paramBoolean) {
    if (paramcy.OH()) {
      n.o(getContext().getString(2131626264));
      return;
    } 
    if (paramcy.OI()) {
      showWIFINecessaryDialog();
      return;
    } 
    if (paramcy.OJ() && paramDouble2.toString().length() == 0) {
      if (paramBoolean.booleanValue()) {
        n.eP(2131626368);
        return;
      } 
      n.eP(2131626371);
      return;
    } 
    if (paramcy.OF()) {
      n.eP(2131626370);
      return;
    } 
    if (paramcy.OG()) {
      n.eP(2131627334);
      return;
    } 
  }
  
  private void a(Integer paramInteger, boolean paramBoolean) {
    int i = paramInteger.intValue();
    if (i != 10001)
      if (i != 10009) {
        if (i != 10014) {
          switch (i) {
            case 10007:
              a.a(this.blO, false, paramBoolean);
              break;
          } 
        } else {
          a.a(this.blO, true, paramBoolean);
        } 
      } else {
        a.a(this.blO, false, paramBoolean);
      }  
    if (paramInteger.intValue() != 10006 && paramInteger.intValue() != 10014)
      a.c(this.blO, true); 
  }
  
  private void showVipBalanceInsufficientDialog() {
    if (this.vipBalanceInsufficientDialog != null && this.vipBalanceInsufficientDialog.isShowing())
      this.vipBalanceInsufficientDialog.dismiss(); 
    this.vipBalanceInsufficientDialog = new r(getActivity(), 3, null);
    this.vipBalanceInsufficientDialog.setTitle(getActivity().getString(2131627480));
    this.vipBalanceInsufficientDialog.s(getActivity().getString(2131626989));
    this.vipBalanceInsufficientDialog.pa(getActivity().getString(2131626861));
    if (getDialog().isShowing())
      this.vipBalanceInsufficientDialog.show(); 
  }
  
  private void showWIFINecessaryDialog() {
    bc bc = new bc(getActivity());
    bc.setCancelable(false);
    bc.s(getContext().getString(2131630409));
    bc.show();
  }
  
  public void Oh() {
    FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
    PosActivitySettlementDialogPayTypeFragment posActivitySettlementDialogPayTypeFragment = PosActivitySettlementDialogPayTypeFragment.h(new Bundle());
    posActivitySettlementDialogPayTypeFragment.setView(this.blO.bms);
    posActivitySettlementDialogPayTypeFragment.b(this.blQ);
    fragmentTransaction.add(posActivitySettlementDialogPayTypeFragment, "PosActivitySettlementDialogPayTypeFragment");
    PosActivitySettlementDialogSubmitOrderFragment posActivitySettlementDialogSubmitOrderFragment = PosActivitySettlementDialogSubmitOrderFragment.Ov();
    posActivitySettlementDialogSubmitOrderFragment.b(this.blQ);
    posActivitySettlementDialogSubmitOrderFragment.b(this.blO);
    fragmentTransaction.add(posActivitySettlementDialogSubmitOrderFragment, "PosActivitySettlementDialogSubmitOrderFragment");
    fragmentTransaction.commit();
  }
  
  public void Oi() {
    n n = (aq)this.blQ.bmC.getValue();
    aq aq;
    if ((aq = n).a(n))
      aq = null; 
    if (aq == null)
      return; 
    if (RootApplication.getLaiqianPreferenceManager().avr() == 1 && RootApplication.getLaiqianPreferenceManager().QV() == 1) {
      n.eP(2131625990);
      return;
    } 
    if (CrashApplication.getLaiqianPreferenceManager().Wq()) {
      o o = new o((ActivityRoot)getActivity(), (ActivityRoot)getActivity());
    } else {
      n = new n((ActivityRoot)getActivity(), (ActivityRoot)getActivity());
    } 
    n.n(aq);
    n.a(new r(this));
    n.show();
  }
  
  public void a(@Nullable aq paramaq, boolean paramBoolean, au paramau) {
    n.println("这里是结算界面设置了会员信息");
    if (aq.a(paramaq)) {
      this.blO.vip_info_l.setVisibility(8);
      if (paramBoolean)
        a.a(this.blO, true); 
    } else {
      this.blO.e(paramaq);
      if (paramBoolean)
        a.a(this.blO, false); 
    } 
    String str = RootApplication.getLaiqianPreferenceManager().atp();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(cj.aGy);
    if (str.equals(stringBuilder.toString())) {
      if (!aq.a(paramaq) && !paramau.aEr) {
        a.b(this.blO, false);
        return;
      } 
      if (paramau.aEq && paramau.aEs == 1 && !aq.a(paramaq) && paramau.aEt >= paramaq.discount) {
        a.b(this.blO, false);
        return;
      } 
      a.b(this.blO, true);
    } 
  }
  
  public void dismiss() {
    super.dismiss();
    Log.i("emery dialogFragment", "dismiss ...");
    this.blP.clear();
    this.blQ.blP.clear();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setStyle(1, 16973934);
    setShowsDialog(true);
    setCancelable(true);
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle) { return paramLayoutInflater.inflate(2131427832, null); }
  
  public void onResume() {
    super.onResume();
    Log.i("emery dialogFragment ", "on resume ...");
    Ol();
  }
  
  public void onStart() {
    super.onStart();
    this.blQ = new ag(this.blR, getActivity());
    this.blO = new a(getActivity(), getView(), getDialog());
    this.blP = new a();
    Oh();
    Ok();
    this.blP.b(a.bu(this.blO.blZ).aJk());
    this.blP.b(e.a(this.blO.bma, ((Double)this.blQ.beT.getValue()).toString(), this.blQ.beT));
    this.blP.b(this.blQ.beT.aJh().d(new a.b()).b(e.h(this.blO.bma)));
    this.blP.b(e.a(this.blO.bmd, ((Double)this.blQ.beU.getValue()).toString(), this.blQ.beU));
    this.blP.b(this.blQ.beU.aJh().d(new a.b()).b(e.h(this.blO.bmd)));
    this.blP.b(e.a(this.blO.bmh, ((Double)this.blQ.bmz.getValue()).toString(), this.blQ.bmz));
    this.blP.b(this.blQ.bmz.aJh().d(new a.b()).aJh().b(e.h(this.blO.bmh)));
    this.blP.b(this.blQ.bmz.aJh().d(new a.c(this.blQ.bmT.bnt)).b(a.a(getDialog(), this.blO.bmh, this.blO.bmi)));
    this.blP.b(this.blQ.bnf.b(new d(this)));
    this.blP.b(a.bu(this.blO.rechargeButton).b(new f(this)));
    this.blP.b(h.a(this.blQ.bmC, this.blQ.bmD, this.blQ.bmB, new w(this)).b(new q(this)));
    this.blP.b(cw.a(this.blO.bmm, false).b(this.blQ.bmF));
    this.blP.b(this.blQ.bmH.aJh().d(new a.b()).b(e.c(this.blO.bmp)));
    this.blP.b(h.a(this.blQ.beU, this.blQ.bmG, this.blQ.bmF, new x(this)).aJh().d(new a.b()).b(e.c(this.blO.bmo)));
    this.blP.b(a.bu(this.blO.bmt).b(new y(this)));
    this.blP.b(this.blQ.bmC.d(new aa(this)).b(new z(this)));
    this.blP.b(this.blQ.bmP.b(new ab(this)));
    this.blP.b(this.blQ.bmR.aJh().b(new ac(this)));
    this.blP.b(a.bu(this.blO.bmb).d(new a.d(this.blQ.bmN)).b(a.b(this.blO.bma)));
    this.blP.b(a.bu(this.blO.bmc).d(new a.d(this.blQ.bmN)).b(a.b(this.blO.bmd)));
    this.blP.b(a.bu(this.blO.bmq).b(new e(this)));
    this.blP.b(h.a(this.blQ.bmT.bnm, this.blQ.bmT.bnC.bnS, new g(this)).aJk());
    this.blP.b(this.blQ.bmT.bnu.b(new h(this)));
    this.blP.b(h.a(this.blQ.bmT.bnm, this.blQ.bmz, this.blQ.beU, this.blQ.bmT.bnq, this.blQ.bmF, this.blQ.bmT.bnr, new i(this)).aJk());
    this.blP.b(this.blO.Om().b(new j(this)));
    this.blP.b(a.bu(this.blO.bmv).b(new k(this)));
    this.blP.b(h.a(this.blQ.bmT.bnr, this.blQ.bmT.bnm, this.blQ.bmT.bnE, this.blQ.bmT.bnD, new l(this)).aJk());
    this.blP.b(h.a(this.blQ.beT, this.blQ.beU, this.blQ.bmT.bnC.bnU, this.blQ.bmB, new m(this)).aJk());
    this.blP.b(h.a(this.blQ.bmC, this.blQ.bmT.bnC.bnT, this.blQ.bmT.bnC.bnN, new n(this)).aJk());
    getDialog().setOnKeyListener(new o(this));
    this.blP.b(cw.a(this.blO.pack_check, false).b(this.blQ.bmV));
    this.blP.b(h.a(this.blQ.bni, this.blQ.bng, this.blQ.beb, this.blQ.bmV, this.blQ.bmC, new p(this)).aJk());
  }
  
  public void onStop() {
    super.onStop();
    Log.i("emery dialogFragment ", "on stop ...");
    this.blP.clear();
    this.blQ.blP.clear();
  }
  
  public void s(List<b> paramList) {
    if (this.selectPaidSecondDialog == null)
      this.selectPaidSecondDialog = new g(getActivity(), paramList, new v(this)); 
    this.selectPaidSecondDialog.dn(this.blO.Op());
    this.selectPaidSecondDialog.show();
  }
  
  public void show(FragmentManager paramFragmentManager, String paramString) { super.show(paramFragmentManager, paramString); }
  
  static class a {
    a<String> aAq = a.aKk();
    
    private LinearLayout blW;
    
    View blX;
    
    LinearLayout blY;
    
    LinearLayout blZ;
    
    EditText bma;
    
    LinearLayout bmb;
    
    LinearLayout bmc;
    
    EditText bmd;
    
    CheckBox bme;
    
    View bmf;
    
    EditText bmg;
    
    EditText bmh;
    
    TextView bmi;
    
    ViewGroup bmj;
    
    LinearLayout bmk;
    
    LinearLayout bml;
    
    CheckBox bmm;
    
    LinearLayout bmn;
    
    TextView bmo;
    
    TextView bmp;
    
    ImageView bmq;
    
    TextView bmr;
    
    LinearLayout bms;
    
    View bmt;
    
    View bmu;
    
    View bmv;
    
    TextView bt_orderType;
    
    private View.OnClickListener clickFastAmount = new ae(this);
    
    private View.OnClickListener clickKeyboardNumber = new af(this);
    
    CheckBox deliveryCheck;
    
    View delivery_l;
    
    TextView etPaidOfSecond;
    
    EditText etTableNumbers;
    
    TextView[] fastAmounts;
    
    View kitchenPrint;
    
    CheckBox kitchenPrintCheck;
    
    View lTableNumbers;
    
    View leftViewLimit;
    
    private Context mContext;
    
    Dialog mDialog;
    
    View notOperableView;
    
    private View.OnFocusChangeListener onFocusChangeListener = new ad(this);
    
    CheckBox pack_check;
    
    View pack_l;
    
    View receiptPrint;
    
    CheckBox receiptPrintCheck;
    
    View rechargeButton;
    
    TextView submitButton;
    
    TextView tvPaid;
    
    TextView tvPaidOfSecond;
    
    View tv_order_up;
    
    TextView tv_table_numbers;
    
    View vPreProgress;
    
    View verificationCheckButton;
    
    TextView vip_info_balance;
    
    View vip_info_l;
    
    TextView vip_info_name;
    
    TextView vip_info_phone;
    
    TextView vip_info_points;
    
    public a(Context param1Context, View param1View, Dialog param1Dialog) {
      this.mContext = param1Context;
      this.blX = param1View;
      this.mDialog = param1Dialog;
      this.bms = (LinearLayout)param1View.findViewById(2131298371);
      this.blY = (LinearLayout)param1View.findViewById(2131297185);
      this.bme = (CheckBox)param1View.findViewById(2131298337);
      this.bmf = param1View.findViewById(2131299626);
      this.bmg = (EditText)param1View.findViewById(2131299160);
      this.bmj = (ViewGroup)param1View.findViewById(2131297424);
      this.bmk = (LinearLayout)param1View.findViewById(2131297345);
      this.leftViewLimit = param1View.findViewById(2131297739);
      ci(param1View);
      cj(param1View);
    }
    
    private void Oq() {
      ViewGroup viewGroup = this.bmj;
      int j = viewGroup.getChildCount();
      this.fastAmounts = new TextView[j];
      for (int i = 0; i < j; i++) {
        ViewGroup viewGroup1 = (ViewGroup)viewGroup.getChildAt(i);
        for (byte b = 0; b < viewGroup1.getChildCount(); b++) {
          View view = viewGroup1.getChildAt(b);
          if (view.getTag() == null) {
            this.fastAmounts[j - i - 1] = (TextView)view;
            view.setOnClickListener(this.clickFastAmount);
          } else {
            view.setOnClickListener(this.clickKeyboardNumber);
          } 
        } 
      } 
    }
    
    private void a(double param1Double, boolean param1Boolean) {
      if (param1Double == 0.0D || param1Boolean) {
        this.blW.setVisibility(8);
        return;
      } 
      this.blW.setVisibility(0);
      this.etPaidOfSecond.setText(n.ba(param1Double));
    }
    
    private void a(EditText param1EditText, String param1String) {
      int i = param1EditText.getSelectionStart();
      int j = param1EditText.getSelectionEnd();
      Editable editable = param1EditText.getEditableText();
      if (i != j) {
        editable.replace(i, j, param1String);
      } else if (!editable.toString().contains(".") || editable.toString().substring(editable.toString().indexOf(".")).length() <= RootApplication.aIQ) {
        editable.insert(i, param1String);
      } 
      param1EditText.setSelection(param1EditText.getEditableText().length());
    }
    
    private void ci(View param1View) {
      param1View = param1View.findViewById(2131297738);
      initDiscountView(param1View);
      initActualAmoutView(param1View);
      initPayableAmoutView(param1View);
      initPayTypeSettingView(param1View);
      initTableNumberView(param1View);
      initMemberPointDeductionView(param1View);
      initPackViewAndDeliveryView(param1View);
      initOrderTypeView();
      initPrintView(param1View);
      initVIPView(param1View);
    }
    
    private void cj(View param1View) {
      View view = param1View.findViewById(2131298744).findViewById(2131298743);
      initFirstPaidView(view);
      initSecondPaidView(view);
      initMemberRechargeView(view);
      initCouponView(view);
      Oq();
      cm(param1View);
      cn(param1View);
      co(param1View);
      cp(param1View);
    }
    
    private void cm(View param1View) { this.submitButton = (TextView)param1View.findViewById(2131299090); }
    
    private void cn(View param1View) { this.vPreProgress = param1View.findViewById(2131297345); }
    
    private void co(View param1View) { this.notOperableView = param1View.findViewById(2131300013); }
    
    private void cp(View param1View) { this.blZ = (LinearLayout)param1View.findViewById(2131298465); }
    
    private void d(EditText param1EditText) {
      int k = param1EditText.getSelectionStart();
      int i = param1EditText.getSelectionEnd();
      Editable editable = param1EditText.getEditableText();
      if (k != i) {
        editable.delete(k, i);
        param1EditText.setSelection(k);
        return;
      } 
      param1EditText.setSelection(i);
      int j = 0;
      if (k == 0) {
        i = 0;
      } else {
        i = k - 1;
      } 
      editable.delete(i, k);
      i = k - 1;
      if (i < 0) {
        i = j;
      } else if (editable.toString().contains(".") && editable.toString().substring(editable.toString().indexOf(".")).length() == 1) {
        i = k - 2;
      } 
      param1EditText.setSelection(i);
    }
    
    private void initActualAmoutView(View param1View) {
      this.bmc = (LinearLayout)param1View.findViewById(2131298678);
      this.bmr = (TextView)this.bmc.findViewById(2131298679);
      this.bmd = (EditText)this.bmc.findViewById(2131298677);
      this.bmd.setTag("after_discount");
      c(this.bmd);
      l.a(this.mDialog.getWindow(), this.bmd);
    }
    
    private void initCouponView(View param1View) {
      this.verificationCheckButton = param1View.findViewById(2131299970);
      this.verificationCheckButton.setVisibility(8);
    }
    
    private void initDiscountView(View param1View) {
      this.bmb = (LinearLayout)param1View.findViewById(2131296883);
      this.bma = (EditText)param1View.findViewById(2131296881);
      this.bma.setTag("discount");
      l.a(this.mDialog.getWindow(), this.bma);
      c(this.bma);
    }
    
    private void initFirstPaidView(View param1View) {
      this.tvPaid = (TextView)param1View.findViewById(2131298342);
      this.bmh = (EditText)param1View.findViewById(2131298343);
      this.bmh.setTag("actual_receive");
      c(this.bmh);
      l.a(this.mDialog.getWindow(), this.bmh);
      this.bmh.setOnFocusChangeListener(this.onFocusChangeListener);
    }
    
    private void initMemberPointDeductionView(View param1View) {
      this.bmu = param1View.findViewById(2131298414);
      this.bml = (LinearLayout)param1View.findViewById(2131298423);
      this.bmp = (TextView)this.bml.findViewById(2131298421);
      this.bmm = (CheckBox)this.bml.findViewById(2131298422);
      this.bmm.setChecked(false);
    }
    
    private void initMemberRechargeView(View param1View) {
      this.rechargeButton = param1View.findViewById(2131298681);
      this.rechargeButton.setVisibility(8);
    }
    
    private void initOrderTypeView() {
      this.bt_orderType = (TextView)this.lTableNumbers.findViewById(2131299625);
      this.bt_orderType.setVisibility(8);
      this.tv_order_up = this.lTableNumbers.findViewById(2131299626);
      this.tv_order_up.setVisibility(8);
    }
    
    private void initPackViewAndDeliveryView(View param1View) {
      this.pack_l = param1View.findViewById(2131298339);
      this.pack_check = (CheckBox)this.pack_l.findViewById(2131298337);
      this.delivery_l = param1View.findViewById(2131298338);
      this.deliveryCheck = (CheckBox)this.delivery_l.findViewById(2131296864);
      if (a.zR().Ab())
        return; 
      this.pack_l.setOnClickListener(new m.b(this.mContext, this.pack_check));
    }
    
    private void initPayTypeSettingView(View param1View) {
      RelativeLayout relativeLayout = (RelativeLayout)param1View.findViewById(2131298373);
      LinearLayout linearLayout2 = (LinearLayout)param1View.findViewById(2131298367);
      LinearLayout linearLayout1 = (LinearLayout)param1View.findViewById(2131298368);
      this.bmq = (ImageView)relativeLayout.findViewById(2131298372);
    }
    
    private void initPayableAmoutView(View param1View) {
      this.bmn = (LinearLayout)param1View.findViewById(2131298377);
      this.bmo = (TextView)this.bmn.findViewById(2131298376);
    }
    
    private void initPrintView(View param1View) {
      this.kitchenPrint = param1View.findViewById(2131297438);
      this.kitchenPrintCheck = (CheckBox)this.kitchenPrint.findViewById(2131297437);
      this.kitchenPrint.setOnClickListener(new m.b(this.mContext, this.kitchenPrintCheck));
      this.receiptPrint = param1View.findViewById(2131298676);
      this.receiptPrintCheck = (CheckBox)this.receiptPrint.findViewById(2131298675);
      this.receiptPrint.setOnClickListener(new m.b(this.mContext, this.receiptPrintCheck));
    }
    
    private void initSecondPaidView(View param1View) {
      this.blW = (LinearLayout)param1View.findViewById(2131297181);
      this.bmv = param1View.findViewById(2131297183);
      this.tvPaidOfSecond = (TextView)this.bmv.findViewById(2131297182);
      this.etPaidOfSecond = (TextView)this.blW.findViewById(2131297184);
      if (a.zR().Ab())
        this.etPaidOfSecond.getPaint().setFakeBoldText(true); 
      this.blW.setVisibility(8);
    }
    
    private void initTableNumberView(View param1View) {
      this.lTableNumbers = param1View.findViewById(2131299161);
      this.etTableNumbers = (EditText)this.lTableNumbers.findViewById(2131299160);
      this.etTableNumbers.setTag("table_number");
      this.tv_table_numbers = (TextView)this.lTableNumbers.findViewById(2131299715);
      l.a(this.mDialog.getWindow(), this.etTableNumbers);
      this.etTableNumbers.setOnFocusChangeListener(this.onFocusChangeListener);
      param1View = this.lTableNumbers;
      Context context = this.mContext;
      EditText editText = this.etTableNumbers;
      byte b2 = 0;
      param1View.setOnClickListener(new m.b(context, editText, false));
      param1View = this.lTableNumbers;
      byte b1 = b2;
      if (!a.AZ().Bc())
        if (a.AZ().Bk()) {
          b1 = b2;
        } else {
          b1 = 8;
        }  
      param1View.setVisibility(b1);
    }
    
    private void initVIPView(View param1View) {
      this.vip_info_l = param1View.findViewById(2131299992);
      this.vip_info_l.setVisibility(8);
      this.bmt = this.vip_info_l.findViewById(2131299990);
      this.vip_info_name = (TextView)this.vip_info_l.findViewById(2131299998).findViewById(2131300000);
      this.vip_info_phone = (TextView)this.vip_info_l.findViewById(2131300002).findViewById(2131300004);
      this.vip_info_points = (TextView)this.vip_info_l.findViewById(2131300005).findViewById(2131300007);
      this.vip_info_balance = (TextView)this.vip_info_l.findViewById(2131299983).findViewById(2131299985);
    }
    
    private void l(boolean param1Boolean1, boolean param1Boolean2) {
      if (param1Boolean1)
        this.bmh.setText(""); 
      a(0.0D, param1Boolean2);
    }
    
    private void setCanEditDiscountActual(boolean param1Boolean) {}
    
    private void setEtActualAndEtDiscountEnable(boolean param1Boolean) {
      this.bmd.setEnabled(param1Boolean);
      this.bmd.setTextIsSelectable(param1Boolean);
      this.bma.setEnabled(param1Boolean);
      this.bma.setTextIsSelectable(param1Boolean);
    }
    
    private void setPaidCanEdit(boolean param1Boolean) {
      this.bmh.setFocusable(param1Boolean);
      this.bmh.setFocusableInTouchMode(param1Boolean);
    }
    
    private void showVipRechargeButton() { this.rechargeButton.setVisibility(0); }
    
    public h<String> Om() { return this.aAq; }
    
    public void On() { this.vip_info_l.setVisibility(8); }
    
    public void Oo() {
      this.etTableNumbers.setVisibility(0);
      this.tv_table_numbers.setText(2131626895);
      EditText editText = this.etTableNumbers;
      editText.setText(String.valueOf(RootApplication.zv().getLaiqianPreferenceManager().avk()));
    }
    
    public long Op() { return ((b)this.tvPaidOfSecond.getTag()).AR(); }
    
    public TextView[] Or() { return this.fastAmounts; }
    
    public void a(double param1Double1, double param1Double2, b param1b) {
      this.blW.setVisibility(0);
      a(param1b);
      this.etPaidOfSecond.setText(n.e(Double.valueOf(param1Double2)));
      this.bmv.setClickable(true);
      this.bmh.setText(n.e(Double.valueOf(param1Double1)));
    }
    
    public void a(b param1b) {
      String str;
      TextView textView = this.tvPaidOfSecond;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("<u>");
      if (b.b(param1b)) {
        str = "";
      } else {
        str = param1b.name;
      } 
      stringBuilder.append(str);
      stringBuilder.append("</u>");
      textView.setText(Html.fromHtml(stringBuilder.toString()));
      this.tvPaidOfSecond.setTag(param1b);
    }
    
    public void a(boolean param1Boolean, double param1Double) {
      if (param1Boolean) {
        this.blW.setVisibility(0);
        this.tvPaidOfSecond.setText(2131627280);
        this.etPaidOfSecond.setText(n.e(Double.valueOf(param1Double)));
        this.bmv.setClickable(false);
        return;
      } 
      this.blW.setVisibility(8);
      this.bmh.setText(n.e(Double.valueOf(param1Double)));
    }
    
    public void a(boolean param1Boolean, double param1Double, b param1b) {
      if (param1Boolean) {
        this.blW.setVisibility(0);
        a(param1b);
        this.etPaidOfSecond.setText(n.e(Double.valueOf(param1Double)));
        this.bmv.setClickable(true);
        return;
      } 
      this.blW.setVisibility(8);
      this.bmh.setText(n.e(Double.valueOf(param1Double)));
    }
    
    public void b(boolean param1Boolean, String param1String) {
      this.pack_check.setChecked(param1Boolean);
      this.etTableNumbers.setVisibility(0);
      this.tv_table_numbers.setText(2131626895);
      this.etTableNumbers.setText(String.valueOf(param1String));
    }
    
    public void c(EditText param1EditText) { n.a(param1EditText, 20, RootApplication.aIQ); }
    
    public boolean dispatchKeyEvent(KeyEvent param1KeyEvent) {
      View view = this.mDialog.getCurrentFocus();
      char c = param1KeyEvent.getNumber();
      if (Character.isDigit(c) || ".".equals(String.valueOf(c))) {
        if (view != null && view instanceof EditText) {
          a((EditText)view, String.valueOf(c));
          return true;
        } 
        return false;
      } 
      if (param1KeyEvent.getKeyCode() == 67 && view != null && view instanceof EditText) {
        d((EditText)view);
        return true;
      } 
      return false;
    }
    
    public void ds(boolean param1Boolean) {
      if (param1Boolean) {
        this.bmu.setVisibility(0);
        return;
      } 
      this.bmu.setVisibility(8);
    }
    
    public void e(aq param1aq) {
      this.vip_info_l.setVisibility(0);
      this.vip_info_name.setText(param1aq.name);
      this.vip_info_phone.setText(by.G(param1aq.aTp, 999));
      this.vip_info_points.setText(String.valueOf(param1aq.aWp));
      this.vip_info_balance.setText(n.b(null, Double.valueOf(param1aq.aWo), true, true));
    }
    
    public void f(aq param1aq) {
      if (!aq.a(param1aq))
        this.etTableNumbers.setText(param1aq.aTp); 
    }
    
    public void fd(String param1String) {
      this.etTableNumbers.setVisibility(8);
      TextView textView = this.tv_table_numbers;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.mContext.getString(2131628305));
      stringBuilder.append("  ");
      stringBuilder.append(param1String);
      textView.setText(stringBuilder.toString());
    }
    
    public void hideVipRechargeButton() { this.rechargeButton.setVisibility(4); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\PosActivitySettlementDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */