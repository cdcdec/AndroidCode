package com.laiqian.main;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListPopupWindow;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.auth.cj;
import com.laiqian.basic.RootApplication;
import com.laiqian.bi;
import com.laiqian.c.a;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.d.a;
import com.laiqian.entity.aa;
import com.laiqian.entity.aq;
import com.laiqian.entity.c;
import com.laiqian.entity.k;
import com.laiqian.entity.n;
import com.laiqian.entity.u;
import com.laiqian.entity.v;
import com.laiqian.entity.z;
import com.laiqian.g.a;
import com.laiqian.main.a.b;
import com.laiqian.main.b.a;
import com.laiqian.main.b.b;
import com.laiqian.main.b.c;
import com.laiqian.main.b.d;
import com.laiqian.main.b.e;
import com.laiqian.main.b.f;
import com.laiqian.main.module.hardware.weight.c;
import com.laiqian.member.a.n;
import com.laiqian.member.a.o;
import com.laiqian.member.e.e;
import com.laiqian.member.setting.bc;
import com.laiqian.models.f;
import com.laiqian.models.l;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.pos.AliPayPreorderDetail;
import com.laiqian.pos.AliPayPreorderDetail.PayType;
import com.laiqian.pos.PayTypeSpecific;
import com.laiqian.pos.bl;
import com.laiqian.pos.hardware.b;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.pos.model.a;
import com.laiqian.pos.model.f;
import com.laiqian.print.dualscreen.o;
import com.laiqian.print.usage.c;
import com.laiqian.product.dq;
import com.laiqian.product.models.c;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.DefensiveTextView;
import com.laiqian.ui.a.bc;
import com.laiqian.ui.a.d;
import com.laiqian.ui.a.g;
import com.laiqian.ui.a.r;
import com.laiqian.util.ar;
import com.laiqian.util.av;
import com.laiqian.util.bd;
import com.laiqian.util.bu;
import com.laiqian.util.by;
import com.laiqian.util.l;
import com.laiqian.util.logger.a;
import com.laiqian.util.m;
import com.laiqian.util.n;
import com.laiqian.util.p;
import io.reactivex.g.a;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.json.JSONException;

public class PosActivitySettlementDialog extends d implements a.a {
  private static final String ONLINE_PAY_TAG = "onlinePay";
  
  private static final String TAG = "PActivitySettlementD";
  
  private int DEFAULT_ONLINE_PAY_TYPE = -1;
  
  private f accountTableModel;
  
  private ActivityRoot activity;
  
  private double amountRounding;
  
  private double amountServiceCharge;
  
  private TextView bt_orderType;
  
  private View.OnClickListener clickFastAmount = new cj(this);
  
  private View.OnClickListener clickKeyboardNumber = new ci(this);
  
  private View.OnClickListener clickOtherPayTypeItem = new ch(this);
  
  private View.OnClickListener clickPayTypeItem = new cg(this);
  
  private String defaultOrderTypeName;
  
  PendingFullOrderDetail deletedOrder = null;
  
  private CheckBox deliveryCheck;
  
  private View delivery_l;
  
  @Nullable
  private o dualPresentation;
  
  private EditText etActual;
  
  private EditText etDiscount;
  
  private EditText etPaid;
  
  private TextView etPaidOfSecond;
  
  private TextView etPayableAmount;
  
  private EditText etTableNumbers;
  
  private TextView[] fastAmounts;
  
  private ArrayList<Integer> fastAmountsDefault;
  
  @Nullable
  private cs groupDialog;
  
  private boolean hasFocsByGradesWayLast;
  
  private boolean hasPointsDeduction;
  
  private boolean isAmountRounding;
  
  private boolean isDelivery = false;
  
  public boolean isDiscountConvertion;
  
  private boolean isEditPhoneOrder;
  
  private boolean isOpenMemberPrice;
  
  private boolean isSaleOrder = true;
  
  private boolean isShowCreditTooMuchDialog;
  
  private long keyTime = System.currentTimeMillis();
  
  private View kitchenPrint;
  
  private CheckBox kitchenPrintCheck;
  
  private View lTableNumbers;
  
  @Nullable
  private View leftViewLimit;
  
  private String mAfterNeglectSmallChangesAmount = "";
  
  private f mCallback;
  
  private View mRoundChanges;
  
  private Pair<Integer, String> mRulePair;
  
  private TextView mSmallChanges;
  
  private bc mWiFiDialog;
  
  private TextWatcher metPayableAmountTextWatcher = new bs(this);
  
  private String neglectSmallChanges;
  
  private View notOperableView;
  
  private View.OnFocusChangeListener onFocusChangeListener = new ck(this);
  
  bi onlinePayDialog;
  
  n onlinePayEntity;
  
  private String openTableName;
  
  private ArrayList<u> orderTypeEntities;
  
  private String orderTypeID;
  
  private c otherPayTypeItemView;
  
  private ViewGroup otherPayViewGroup;
  
  private PopupWindow otherPayWindow;
  
  private CheckBox pack_check;
  
  private View pack_l;
  
  private View paidOfSecond;
  
  c.a payItemViewSelected = new br(this);
  
  private long payMark;
  
  private ArrayList<c> payTypeItemViewList;
  
  private c payTypeItemViewSelected;
  
  private ArrayList<v> payTypeOther;
  
  private View pay_type_body1;
  
  private View pay_type_body2;
  
  private RelativeLayout pay_type_setting_l;
  
  private PendingFullOrderDetail.a phoneHeader;
  
  private double pointsDeductionAmount;
  
  private TextView points_deduction;
  
  private CheckBox points_deduction_check;
  
  private View points_deduction_l;
  
  private d posActivitySettlementPresenter;
  
  private TableEntity posTableEntity;
  
  private View prePrint;
  
  private ArrayList<aa> productData;
  
  private ArrayList<aa> productDeleteData;
  
  private View receiptPrint;
  
  private CheckBox receiptPrintCheck;
  
  private View rechargeButton;
  
  Handler scanCodeHandle = new ce(this);
  
  private String scanCodeOrderNo;
  
  @Nullable
  private g selectPaidSecondDialog;
  
  private final ArrayList<b> selectPaidSecondDialogItems = new ArrayList();
  
  @Nullable
  private di settlementRunnable;
  
  private String startShowingAmount;
  
  private TextView submitButton;
  
  private double sumAmountContainTaxOfAddPrice;
  
  private double sumAmountUnDiscount;
  
  private c telephoneEntity;
  
  private TextView tvActual;
  
  private TextView tvPaid;
  
  private TextView tvPaidOfSecond;
  
  private View tv_order_up;
  
  private TextView tv_table_numbers;
  
  private View vPayableAmount;
  
  private View vPreProgress;
  
  private View verificationCheckButton;
  
  private r vipBalanceInsufficientDialog;
  
  private aq vipEntity;
  
  private TextView vip_info_balance;
  
  private View vip_info_l;
  
  private TextView vip_info_name;
  
  private TextView vip_info_phone;
  
  private TextView vip_info_points;
  
  public PosActivitySettlementDialog(ActivityRoot paramActivityRoot, ArrayList<aa> paramArrayList1, ArrayList<aa> paramArrayList2, f paramf) {
    super(paramActivityRoot, 2131427832);
    if (!c.aYt().cK(this))
      c.aYt().cJ(this); 
    this.activity = paramActivityRoot;
    this.mCallback = paramf;
    this.isDiscountConvertion = paramActivityRoot.getResources().getBoolean(2131034121);
    this.payTypeOther = new ArrayList();
    this.accountTableModel = new f(paramActivityRoot);
    (getWindow().getAttributes()).width = (paramActivityRoot.getResources().getDisplayMetrics()).widthPixels;
    this.productData = paramArrayList1;
    this.productDeleteData = paramArrayList2;
    this.mView.findViewById(2131299250).setOnClickListener(new bf(this));
    this.posActivitySettlementPresenter = new d(this);
    initLeftView();
    initRightView();
    onChangeDecimalPoint();
    setVipEntity(null);
  }
  
  private void afterSelectedPayTypeAlipayWecharOther(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
    changePayType(paramInt, false);
    if (paramBoolean2) {
      this.etPaid.setText("");
      setPaidCanEdit(false);
      updateChangeOrPaidSecond(0.0D);
      return;
    } 
    this.etPaid.setText(n.a(this.mAfterNeglectSmallChangesAmount, true, false));
    if ((paramInt == 10007 || paramInt == 10009) && !canSettlement())
      return; 
    showScanCodeDialog(false);
    setPaidCanEdit(paramBoolean1);
    updateChangeOrPaidSecond(0.0D);
  }
  
  private double calculationActualAmountByDiscount(double paramDouble) { return (this.sumAmountContainTaxOfAddPrice - this.sumAmountUnDiscount) / 100.0D * paramDouble + this.sumAmountUnDiscount; }
  
  private void calculationPayableActualAndSet() {
    double d1 = getPointsDeductionDouble();
    double d2 = n.e(new Object[] { this.etActual.getText(), Double.valueOf(d1) });
    d1 = d2;
    if (d2 < 0.0D)
      d1 = 0.0D; 
    if (this.dualPresentation != null)
      this.dualPresentation.aF(getDualScreenDeductionAmount()); 
    d2 = d1;
    if (this.isAmountRounding) {
      d2 = d1;
      if (isShowPointsDeductionView()) {
        this.amountRounding = p.bg(d1);
        d2 = d1 + this.amountRounding;
      } 
    } 
    this.etPayableAmount.setText(n.ba(d2));
    if (this.dualPresentation != null)
      this.dualPresentation.aG(d2); 
  }
  
  private void calculationPointsDeductionAmount() {
    if (!isShowPointsDeductionView())
      return; 
    this.pointsDeductionAmount = n.aU(bc.RH().an(this.vipEntity.aWp));
    setPointsDeductionTextView(n.aU(this.etActual.getText()));
  }
  
  private boolean canOperate() { return (this.notOperableView.getVisibility() == 8); }
  
  private boolean canSettlement() {
    if (!isShowing()) {
      n.println("结算页面关闭了，但又点击了结算按钮");
      return false;
    } 
    if (a.zR().Ab() && isDeliveryOrder() && !this.pack_check.isChecked() && !this.deliveryCheck.isChecked() && getIsPhoneOrderType()) {
      n.o(getContext().getString(2131626264));
      return false;
    } 
    if (isUseChainMember() && !bd.bH(this.activity)) {
      showWIFINecessaryDialog();
      return false;
    } 
    if (this.payTypeItemViewSelected == null) {
      n.o("未知错误，没有选中支付类型");
      return false;
    } 
    if (this.payTypeItemViewSelected.aTv == 10001 && n.aU(this.etPaid.getText().toString().trim()) >= 1.0E8D) {
      n.eP(2131626205);
      return false;
    } 
    if (this.etDiscount.getText().length() == 0) {
      n.eP(2131627258);
      return false;
    } 
    double d1 = getDiscountValue();
    if (d1 > 300.0D) {
      n.eP(2131627254);
      return false;
    } 
    if (d1 < 0.0D) {
      n.eP(2131627255);
      return false;
    } 
    if (this.etActual.getText().length() == 0) {
      if (this.isSaleOrder) {
        n.eP(2131626368);
        return false;
      } 
      n.eP(2131626371);
      return false;
    } 
    if (!cr.a(getContext(), this.posActivitySettlementPresenter.Po(), this.vipEntity, this.etActual, this.etDiscount, this.startShowingAmount))
      return false; 
    b b = getPaidOfSecond();
    if (b != null) {
      if ((isSecondPayEqualsQRCodePay(b) || b.bpq) && (isFirstPayTypeEqualsQRPay(this.payTypeItemViewSelected) || isFirstPayEqualsBarcodePay(this.payTypeItemViewSelected))) {
        n.eP(2131626370);
        return false;
      } 
      if ((isSecondPayEqualsQRCodePay(b) || b.bpq || isFirstPayTypeEqualsQRPay(this.payTypeItemViewSelected) || isFirstPayEqualsBarcodePay(this.payTypeItemViewSelected)) && this.payTypeItemViewSelected.aTv == 10014) {
        n.eP(2131627334);
        return false;
      } 
    } 
    return true;
  }
  
  private void changePaidSecond(@Nullable b paramb, boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("这里是选择第二种支付方式:");
    stringBuilder.append(paramb);
    n.println(stringBuilder.toString());
    this.paidOfSecond.setTag(paramb);
    showAfterSecondPayTypeChanged(paramb, paramBoolean);
  }
  
  private void changePayType(int paramInt, boolean paramBoolean) { this.posActivitySettlementPresenter.m(paramInt, paramBoolean); }
  
  private void changePayTypeItemPayType(Message paramMessage) {
    if (a.zR().At()) {
      long l = paramMessage.arg1;
      TextView textView = new TextView(getContext());
      textView.setText(PayTypeSpecific.cn(l));
      this.payTypeItemViewSelected.aTe = l;
      this.payTypeItemViewSelected.aKu = textView;
      this.payTypeItemViewSelected.aTv = PayTypeSpecific.co(l);
    } 
  }
  
  @NonNull
  private View.OnClickListener clickSubmitButtonLsn() { return new bk(this); }
  
  private void executeSettlementOfChainMember() {
    this.vPreProgress.setVisibility(0);
    setCanOperate(false);
    a.aKh().r(this.settlementRunnable);
  }
  
  private String getActualAmountByDiscount(double paramDouble) {
    double d1 = calculationActualAmountByDiscount(paramDouble);
    paramDouble = d1;
    if (this.isAmountRounding) {
      paramDouble = d1;
      if (!isShowPointsDeductionView()) {
        this.amountRounding = p.bg(d1);
        paramDouble = d1 + this.amountRounding;
      } 
    } 
    return n.ba(paramDouble);
  }
  
  private double getAfterPointDeductionAmount() { return (n.e(new Object[] { this.etActual.getText(), Double.valueOf(getPointsDeductionDouble()) }) < 0.0D) ? 0.0D : n.e(new Object[] { this.etActual.getText(), Double.valueOf(getPointsDeductionDouble()) }); }
  
  @Nullable
  private TextView getAmountTextView() { return isFirstPayTypeEqualsQRPay(this.payTypeItemViewSelected) ? this.etPaid : (isSecondPayEqualsQRCodePay(getPaidOfSecond()) ? this.etPaidOfSecond : null); }
  
  private bb getCanceledSettementEntity(String paramString) {
    bb bb = getSettementEntity(paramString);
    if (bb == null)
      return null; 
    bb.bcr = true;
    return bb;
  }
  
  private long getChildPayTypeID(boolean paramBoolean) {
    long l = 0L;
    if (paramBoolean) {
      try {
        b b = (b)this.paidOfSecond.getTag();
        if (b != null)
          return b.aTx; 
      } catch (Exception exception) {
        a.e(exception);
        return 0L;
      } 
    } else {
      l = this.payTypeItemViewSelected.aTe;
    } 
    return l;
  }
  
  private double getDiscountByActualAmount(double paramDouble) { return (paramDouble - this.sumAmountUnDiscount) / (this.sumAmountContainTaxOfAddPrice - this.sumAmountUnDiscount) * 100.0D; }
  
  private double getDiscountNoVip() { return (isAllNotDiscount() || !this.isSaleOrder) ? 100.0D : a.AZ().Bn(); }
  
  private double getDiscountValue() {
    object = this.etDiscount.getTag();
    try {
      return ((Double)object).doubleValue();
    } catch (Throwable object) {
      n.println("获取折扣时出错了，这里不会进来");
      return n.aU(this.etDiscount.getText());
    } 
  }
  
  private double getDualScreenDeductionAmount() { return Math.abs(n.e(new Object[] { this.etActual.getText(), Double.valueOf(getAfterPointDeductionAmount()) })); }
  
  private double getGiveChangeAmount() { return (this.paidOfSecond.getVisibility() == 0 && getPaidOfSecond() == null) ? n.aU(this.etPaidOfSecond.getText()) : 0.0D; }
  
  private cs getGroupDialog() {
    if (this.groupDialog == null)
      this.groupDialog = new cs(this.activity, new bo(this)); 
    this.groupDialog.setCancelable(false);
    return this.groupDialog;
  }
  
  private boolean getIsPhoneOrderType() { return this.posActivitySettlementPresenter.Pp(); }
  
  private double getNeglectSmallChanges() {
    if (a.AZ().CC()) {
      String str = this.mSmallChanges.getText().toString().trim();
      return Double.parseDouble(str.substring(str.indexOf("(") + 1, str.lastIndexOf(")")));
    } 
    return 0.0D;
  }
  
  private Pair<Integer, String> getNeglectSmallChangesRule() {
    arrayOfString = getContext().getResources().getStringArray(2130903061);
    byte b = 2;
    String str = arrayOfString[2];
    try {
      k k = k.Fb();
      boolean bool = k.Fc();
      if (bool) {
        str = arrayOfString[1];
        b = 0;
      } else if (k.Fd()) {
        str = arrayOfString[2];
        b = 1;
      } else {
        bool = k.Fe();
        if (bool) {
          str = arrayOfString[3];
        } else {
          bool = k.Ff();
          if (bool) {
            str = arrayOfString[4];
            b = 3;
          } else {
            b = -1;
            str = arrayOfString[0];
          } 
        } 
      } 
    } catch (JSONException arrayOfString) {
      b = 1;
      a.e(arrayOfString);
    } 
    return new Pair(Integer.valueOf(b), str);
  }
  
  @Nullable
  private b getPaidOfSecond() { return (this.paidOfSecond.getVisibility() == 0) ? (b)this.paidOfSecond.getTag() : null; }
  
  private double getPaidOfSecondAmount() { return (getPaidOfSecond() != null) ? n.aU(this.etPaidOfSecond.getText()) : 0.0D; }
  
  private double getPointsDeductionDouble() { return (this.points_deduction_check.isChecked() && isShowPointsDeductionView()) ? this.pointsDeductionAmount : 0.0D; }
  
  private int getQRCodePayTypeID(b paramb) { return isFirstPayTypeEqualsQRPay(this.payTypeItemViewSelected) ? this.payTypeItemViewSelected.aTv : (isSecondPayEqualsQRCodePay(paramb) ? paramb.aTv : 0); }
  
  private String getQRcodeAmount(b paramb) { return isFirstPayTypeEqualsQRPay(this.payTypeItemViewSelected) ? this.etPaid.getText().toString() : ((paramb != null && isSecondPayEqualsQRCodePay(paramb)) ? this.etPaidOfSecond.getText().toString() : null); }
  
  @Nullable
  private bb getSettementEntity(String paramString) { // Byte code:
    //   0: aload_0
    //   1: getfield paidOfSecond : Landroid/view/View;
    //   4: invokevirtual getTag : ()Ljava/lang/Object;
    //   7: checkcast com/laiqian/main/b/b
    //   10: astore #20
    //   12: aload #20
    //   14: ifnull -> 52
    //   17: aload #20
    //   19: getfield aJW : D
    //   22: dconst_0
    //   23: dcmpl
    //   24: ifeq -> 52
    //   27: aload #20
    //   29: getfield aTv : I
    //   32: istore #16
    //   34: iload #16
    //   36: sipush #10001
    //   39: if_icmpeq -> 69
    //   42: goto -> 52
    //   45: astore #20
    //   47: aconst_null
    //   48: astore_1
    //   49: goto -> 1251
    //   52: aload_0
    //   53: getfield payTypeItemViewSelected : Lcom/laiqian/main/b/c;
    //   56: getfield aTv : I
    //   59: istore #16
    //   61: iload #16
    //   63: sipush #10001
    //   66: if_icmpne -> 106
    //   69: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   72: invokevirtual avT : ()Z
    //   75: ifne -> 106
    //   78: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   81: invokevirtual avs : ()I
    //   84: iconst_1
    //   85: if_icmpne -> 106
    //   88: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   91: invokevirtual QV : ()I
    //   94: iconst_1
    //   95: if_icmpne -> 106
    //   98: ldc_w 2131625902
    //   101: invokestatic eP : (I)V
    //   104: aconst_null
    //   105: areturn
    //   106: aload_0
    //   107: aload_1
    //   108: iconst_0
    //   109: invokespecial preSettlement : (Ljava/lang/String;Z)[Ljava/lang/Object;
    //   112: ifnonnull -> 117
    //   115: aconst_null
    //   116: areturn
    //   117: aload_0
    //   118: getfield settlementRunnable : Lcom/laiqian/main/di;
    //   121: ifnull -> 126
    //   124: aconst_null
    //   125: areturn
    //   126: aload_0
    //   127: getfield isDiscountConvertion : Z
    //   130: istore #17
    //   132: iload #17
    //   134: ifeq -> 168
    //   137: aload_0
    //   138: getfield etDiscount : Landroid/widget/EditText;
    //   141: invokevirtual getText : ()Landroid/text/Editable;
    //   144: invokevirtual toString : ()Ljava/lang/String;
    //   147: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Double;
    //   150: invokevirtual doubleValue : ()D
    //   153: ldc2_w 100.0
    //   156: dcmpl
    //   157: ifle -> 195
    //   160: ldc_w 2131627260
    //   163: invokestatic eP : (I)V
    //   166: aconst_null
    //   167: areturn
    //   168: aload_0
    //   169: getfield etDiscount : Landroid/widget/EditText;
    //   172: invokevirtual getText : ()Landroid/text/Editable;
    //   175: invokeinterface length : ()I
    //   180: istore #16
    //   182: iload #16
    //   184: ifne -> 195
    //   187: ldc_w 2131627258
    //   190: invokestatic eP : (I)V
    //   193: aconst_null
    //   194: areturn
    //   195: aload_0
    //   196: invokespecial getDiscountValue : ()D
    //   199: dstore_2
    //   200: aload_0
    //   201: getfield isDiscountConvertion : Z
    //   204: istore #17
    //   206: iload #17
    //   208: ifeq -> 222
    //   211: dload_2
    //   212: ldc2_w 100.0
    //   215: dcmpl
    //   216: ifle -> 252
    //   219: goto -> 230
    //   222: dload_2
    //   223: ldc2_w 300.0
    //   226: dcmpl
    //   227: ifle -> 252
    //   230: aload_0
    //   231: getfield isDiscountConvertion : Z
    //   234: ifeq -> 1258
    //   237: ldc_w 2131627466
    //   240: istore #16
    //   242: goto -> 245
    //   245: iload #16
    //   247: invokestatic eP : (I)V
    //   250: aconst_null
    //   251: areturn
    //   252: dload_2
    //   253: dconst_0
    //   254: dcmpg
    //   255: ifge -> 266
    //   258: ldc_w 2131627255
    //   261: invokestatic eP : (I)V
    //   264: aconst_null
    //   265: areturn
    //   266: aload_0
    //   267: getfield mAfterNeglectSmallChangesAmount : Ljava/lang/String;
    //   270: invokestatic aU : (Ljava/lang/Object;)D
    //   273: dstore #8
    //   275: aload_0
    //   276: getfield etPaid : Landroid/widget/EditText;
    //   279: invokevirtual getText : ()Landroid/text/Editable;
    //   282: invokestatic aU : (Ljava/lang/Object;)D
    //   285: dstore #4
    //   287: dload #4
    //   289: dconst_0
    //   290: dcmpg
    //   291: ifge -> 302
    //   294: ldc_w 2131626369
    //   297: invokestatic eP : (I)V
    //   300: aconst_null
    //   301: areturn
    //   302: dload #4
    //   304: dstore_2
    //   305: dload #4
    //   307: dload #8
    //   309: dcmpl
    //   310: ifle -> 316
    //   313: dload #8
    //   315: dstore_2
    //   316: aload_0
    //   317: invokespecial getPaidOfSecondAmount : ()D
    //   320: dstore #10
    //   322: dload #8
    //   324: dload_2
    //   325: dsub
    //   326: dload #10
    //   328: dsub
    //   329: ldc2_w 1.0E-6
    //   332: dcmpl
    //   333: ifle -> 359
    //   336: aload_0
    //   337: getfield isSaleOrder : Z
    //   340: ifeq -> 351
    //   343: ldc_w 2131627252
    //   346: invokestatic eP : (I)V
    //   349: aconst_null
    //   350: areturn
    //   351: ldc_w 2131627253
    //   354: invokestatic eP : (I)V
    //   357: aconst_null
    //   358: areturn
    //   359: aload_0
    //   360: getfield payTypeItemViewSelected : Lcom/laiqian/main/b/c;
    //   363: getfield aTv : I
    //   366: istore #16
    //   368: iload #16
    //   370: sipush #10006
    //   373: if_icmpne -> 391
    //   376: aload_0
    //   377: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   380: ifnonnull -> 391
    //   383: ldc_w 2131627256
    //   386: invokestatic eP : (I)V
    //   389: aconst_null
    //   390: areturn
    //   391: dload #8
    //   393: dconst_0
    //   394: dcmpg
    //   395: ifgt -> 420
    //   398: aload_0
    //   399: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   402: ifnull -> 420
    //   405: aload_0
    //   406: getfield etActual : Landroid/widget/EditText;
    //   409: invokevirtual getText : ()Landroid/text/Editable;
    //   412: invokestatic aU : (Ljava/lang/Object;)D
    //   415: dstore #4
    //   417: goto -> 426
    //   420: aload_0
    //   421: invokespecial getPointsDeductionDouble : ()D
    //   424: dstore #4
    //   426: aload_0
    //   427: dconst_0
    //   428: putfield amountServiceCharge : D
    //   431: aload_0
    //   432: getfield isSaleOrder : Z
    //   435: ifeq -> 521
    //   438: aload_0
    //   439: getfield productData : Ljava/util/ArrayList;
    //   442: invokevirtual iterator : ()Ljava/util/Iterator;
    //   445: astore #20
    //   447: aload #20
    //   449: invokeinterface hasNext : ()Z
    //   454: ifeq -> 521
    //   457: aload #20
    //   459: invokeinterface next : ()Ljava/lang/Object;
    //   464: checkcast com/laiqian/entity/aa
    //   467: astore #21
    //   469: aload_0
    //   470: getfield amountServiceCharge : D
    //   473: dstore #12
    //   475: aload #21
    //   477: invokevirtual GK : ()D
    //   480: dstore #14
    //   482: aload #21
    //   484: invokevirtual Gv : ()Z
    //   487: ifeq -> 496
    //   490: dconst_1
    //   491: dstore #6
    //   493: goto -> 506
    //   496: aload_0
    //   497: invokespecial getDiscountValue : ()D
    //   500: ldc2_w 100.0
    //   503: ddiv
    //   504: dstore #6
    //   506: aload_0
    //   507: dload #12
    //   509: dload #14
    //   511: dload #6
    //   513: dmul
    //   514: dadd
    //   515: putfield amountServiceCharge : D
    //   518: goto -> 447
    //   521: new com/laiqian/main/bb
    //   524: dup
    //   525: aload_0
    //   526: getfield isSaleOrder : Z
    //   529: aload_0
    //   530: getfield productData : Ljava/util/ArrayList;
    //   533: aload_0
    //   534: getfield sumAmountContainTaxOfAddPrice : D
    //   537: aload_0
    //   538: invokespecial getDiscountValue : ()D
    //   541: invokespecial <init> : (ZLjava/util/List;DD)V
    //   544: astore #21
    //   546: aload_0
    //   547: getfield isSaleOrder : Z
    //   550: ifne -> 1266
    //   553: iconst_3
    //   554: istore #16
    //   556: goto -> 559
    //   559: aload #21
    //   561: iload #16
    //   563: putfield bcp : I
    //   566: aload #21
    //   568: aload_1
    //   569: putfield orderNo : Ljava/lang/String;
    //   572: aload_0
    //   573: getfield posTableEntity : Lcom/laiqian/opentable/common/entity/TableEntity;
    //   576: ifnull -> 594
    //   579: aload_0
    //   580: getfield posTableEntity : Lcom/laiqian/opentable/common/entity/TableEntity;
    //   583: invokevirtual Yg : ()Lcom/laiqian/opentable/common/entity/c;
    //   586: invokevirtual DP : ()J
    //   589: lstore #18
    //   591: goto -> 599
    //   594: invokestatic currentTimeMillis : ()J
    //   597: lstore #18
    //   599: aload #21
    //   601: lload #18
    //   603: putfield bbP : J
    //   606: aload #21
    //   608: aload_0
    //   609: getfield vipEntity : Lcom/laiqian/entity/aq;
    //   612: putfield vipEntity : Lcom/laiqian/entity/aq;
    //   615: aload #21
    //   617: dload #4
    //   619: putfield bca : D
    //   622: aload #21
    //   624: aload_0
    //   625: getfield amountRounding : D
    //   628: putfield amountRounding : D
    //   631: aload #21
    //   633: aload_0
    //   634: getfield payMark : J
    //   637: putfield bcf : J
    //   640: aload #21
    //   642: aload_0
    //   643: getfield pack_check : Landroid/widget/CheckBox;
    //   646: invokevirtual isChecked : ()Z
    //   649: putfield aTZ : Z
    //   652: aload #21
    //   654: aload_0
    //   655: getfield receiptPrintCheck : Landroid/widget/CheckBox;
    //   658: invokevirtual isChecked : ()Z
    //   661: putfield bcm : Z
    //   664: aload #21
    //   666: aload_0
    //   667: getfield kitchenPrintCheck : Landroid/widget/CheckBox;
    //   670: invokevirtual isChecked : ()Z
    //   673: putfield bcn : Z
    //   676: aload #21
    //   678: aload_0
    //   679: getfield amountServiceCharge : D
    //   682: invokevirtual Y : (D)V
    //   685: aload_0
    //   686: getfield posTableEntity : Lcom/laiqian/opentable/common/entity/TableEntity;
    //   689: ifnull -> 731
    //   692: aload #21
    //   694: aload_0
    //   695: getfield posTableEntity : Lcom/laiqian/opentable/common/entity/TableEntity;
    //   698: invokevirtual Yg : ()Lcom/laiqian/opentable/common/entity/c;
    //   701: invokevirtual Ym : ()I
    //   704: aload_0
    //   705: getfield posTableEntity : Lcom/laiqian/opentable/common/entity/TableEntity;
    //   708: invokevirtual Ye : ()Ljava/lang/String;
    //   711: aload_0
    //   712: getfield posTableEntity : Lcom/laiqian/opentable/common/entity/TableEntity;
    //   715: invokevirtual Yf : ()Ljava/lang/String;
    //   718: aload_0
    //   719: getfield posTableEntity : Lcom/laiqian/opentable/common/entity/TableEntity;
    //   722: invokevirtual DP : ()J
    //   725: invokestatic a : (ILjava/lang/String;Ljava/lang/String;J)Ljava/lang/String;
    //   728: putfield bch : Ljava/lang/String;
    //   731: aload_0
    //   732: getfield groupDialog : Lcom/laiqian/main/cs;
    //   735: ifnull -> 1272
    //   738: aload_0
    //   739: getfield groupDialog : Lcom/laiqian/main/cs;
    //   742: invokevirtual LM : ()Ljava/util/ArrayList;
    //   745: ifnull -> 1272
    //   748: aload_0
    //   749: getfield groupDialog : Lcom/laiqian/main/cs;
    //   752: invokevirtual LM : ()Ljava/util/ArrayList;
    //   755: invokevirtual size : ()I
    //   758: ifle -> 1272
    //   761: aload #21
    //   763: new com/google/gson/k
    //   766: dup
    //   767: invokespecial <init> : ()V
    //   770: aload_0
    //   771: getfield groupDialog : Lcom/laiqian/main/cs;
    //   774: invokevirtual LM : ()Ljava/util/ArrayList;
    //   777: invokevirtual ac : (Ljava/lang/Object;)Ljava/lang/String;
    //   780: putfield headerText : Ljava/lang/String;
    //   783: goto -> 1272
    //   786: aload_0
    //   787: getfield payTypeItemViewSelected : Lcom/laiqian/main/b/c;
    //   790: getfield aTv : I
    //   793: sipush #10014
    //   796: if_icmpne -> 1288
    //   799: aload_0
    //   800: invokespecial getGroupDialog : ()Lcom/laiqian/main/cs;
    //   803: invokevirtual LI : ()D
    //   806: dstore #4
    //   808: aload #21
    //   810: dload_2
    //   811: dload #4
    //   813: dsub
    //   814: putfield bcb : D
    //   817: aload_0
    //   818: invokespecial getGroupDialog : ()Lcom/laiqian/main/cs;
    //   821: invokevirtual LH : ()Ljava/lang/String;
    //   824: astore_1
    //   825: dload #4
    //   827: dstore_2
    //   828: goto -> 831
    //   831: aload_0
    //   832: aload_0
    //   833: getfield payTypeItemViewSelected : Lcom/laiqian/main/b/c;
    //   836: dload_2
    //   837: invokespecial obtainPayTypeItemByPayTypeItemView : (Lcom/laiqian/main/b/c;D)Lcom/laiqian/main/b/b;
    //   840: astore #20
    //   842: aload #20
    //   844: getfield aTv : I
    //   847: sipush #10001
    //   850: if_icmpne -> 873
    //   853: aload_0
    //   854: invokespecial getGiveChangeAmount : ()D
    //   857: dstore_2
    //   858: dload_2
    //   859: dconst_0
    //   860: dcmpl
    //   861: ifle -> 910
    //   864: aload #20
    //   866: dload_2
    //   867: putfield aTw : D
    //   870: goto -> 910
    //   873: aload #20
    //   875: getfield aTv : I
    //   878: sipush #10007
    //   881: if_icmpne -> 1293
    //   884: aload #21
    //   886: iconst_1
    //   887: putfield bcs : Z
    //   890: goto -> 893
    //   893: aload #20
    //   895: getfield aTv : I
    //   898: sipush #10009
    //   901: if_icmpne -> 910
    //   904: aload #21
    //   906: iconst_1
    //   907: putfield bct : Z
    //   910: aload #20
    //   912: aload_1
    //   913: putfield aTy : Ljava/lang/String;
    //   916: aload #21
    //   918: getfield bbS : Ljava/util/ArrayList;
    //   921: aload #20
    //   923: invokevirtual add : (Ljava/lang/Object;)Z
    //   926: pop
    //   927: aload #21
    //   929: aload #21
    //   931: getfield bbY : D
    //   934: aload #20
    //   936: getfield aJW : D
    //   939: dadd
    //   940: putfield bbY : D
    //   943: aload_0
    //   944: invokespecial getPaidOfSecond : ()Lcom/laiqian/main/b/b;
    //   947: astore_1
    //   948: aload_1
    //   949: ifnull -> 1074
    //   952: new com/laiqian/entity/z
    //   955: dup
    //   956: aload_1
    //   957: dload #10
    //   959: invokespecial <init> : (Lcom/laiqian/entity/z;D)V
    //   962: astore_1
    //   963: aload_1
    //   964: getfield aTv : I
    //   967: sipush #10001
    //   970: if_icmpne -> 986
    //   973: aload #21
    //   975: getfield bbS : Ljava/util/ArrayList;
    //   978: iconst_0
    //   979: aload_1
    //   980: invokevirtual add : (ILjava/lang/Object;)V
    //   983: goto -> 1031
    //   986: aload_1
    //   987: getfield aTv : I
    //   990: sipush #10007
    //   993: if_icmpne -> 1296
    //   996: aload #21
    //   998: iconst_1
    //   999: putfield bcs : Z
    //   1002: goto -> 1005
    //   1005: aload_1
    //   1006: getfield aTv : I
    //   1009: sipush #10009
    //   1012: if_icmpne -> 1021
    //   1015: aload #21
    //   1017: iconst_1
    //   1018: putfield bct : Z
    //   1021: aload #21
    //   1023: getfield bbS : Ljava/util/ArrayList;
    //   1026: aload_1
    //   1027: invokevirtual add : (Ljava/lang/Object;)Z
    //   1030: pop
    //   1031: aload #21
    //   1033: aload #21
    //   1035: getfield bbY : D
    //   1038: dload #10
    //   1040: dadd
    //   1041: putfield bbY : D
    //   1044: new java/lang/StringBuilder
    //   1047: dup
    //   1048: invokespecial <init> : ()V
    //   1051: astore_1
    //   1052: aload_1
    //   1053: ldc_w '添加了组合支付：'
    //   1056: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: pop
    //   1060: aload_1
    //   1061: dload #10
    //   1063: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   1066: pop
    //   1067: aload_1
    //   1068: invokevirtual toString : ()Ljava/lang/String;
    //   1071: invokestatic println : (Ljava/lang/Object;)V
    //   1074: aload_0
    //   1075: getfield lTableNumbers : Landroid/view/View;
    //   1078: invokevirtual getVisibility : ()I
    //   1081: ifne -> 1208
    //   1084: aload_0
    //   1085: getfield etTableNumbers : Landroid/widget/EditText;
    //   1088: invokevirtual getText : ()Landroid/text/Editable;
    //   1091: invokevirtual toString : ()Ljava/lang/String;
    //   1094: astore_1
    //   1095: aload_1
    //   1096: invokevirtual length : ()I
    //   1099: ifle -> 1208
    //   1102: aload_0
    //   1103: getfield payMark : J
    //   1106: ldc2_w 7
    //   1109: lcmp
    //   1110: ifeq -> 1124
    //   1113: aload_0
    //   1114: getfield payMark : J
    //   1117: ldc2_w 14
    //   1120: lcmp
    //   1121: ifne -> 1202
    //   1124: aload_0
    //   1125: getfield posTableEntity : Lcom/laiqian/opentable/common/entity/TableEntity;
    //   1128: ifnull -> 1202
    //   1131: aload #21
    //   1133: aload_0
    //   1134: getfield posTableEntity : Lcom/laiqian/opentable/common/entity/TableEntity;
    //   1137: invokevirtual getID : ()J
    //   1140: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1143: putfield bbR : Ljava/lang/Long;
    //   1146: new java/lang/StringBuilder
    //   1149: dup
    //   1150: invokespecial <init> : ()V
    //   1153: astore_1
    //   1154: aload_1
    //   1155: aload_0
    //   1156: getfield posTableEntity : Lcom/laiqian/opentable/common/entity/TableEntity;
    //   1159: invokevirtual getID : ()J
    //   1162: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   1165: pop
    //   1166: aload_1
    //   1167: ldc ''
    //   1169: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1172: pop
    //   1173: aload #21
    //   1175: aload_1
    //   1176: invokevirtual toString : ()Ljava/lang/String;
    //   1179: putfield bbQ : Ljava/lang/String;
    //   1182: aload #21
    //   1184: aload_0
    //   1185: getfield openTableName : Ljava/lang/String;
    //   1188: putfield openTableName : Ljava/lang/String;
    //   1191: aload_0
    //   1192: getfield posTableEntity : Lcom/laiqian/opentable/common/entity/TableEntity;
    //   1195: invokevirtual Yd : ()Z
    //   1198: pop
    //   1199: goto -> 1208
    //   1202: aload #21
    //   1204: aload_1
    //   1205: putfield bbQ : Ljava/lang/String;
    //   1208: aload #21
    //   1210: astore_1
    //   1211: aload_0
    //   1212: getfield neglectSmallChanges : Ljava/lang/String;
    //   1215: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1218: ifne -> 1256
    //   1221: aload #21
    //   1223: aload_0
    //   1224: getfield neglectSmallChanges : Ljava/lang/String;
    //   1227: invokestatic pi : (Ljava/lang/String;)Ljava/lang/String;
    //   1230: invokestatic parseDouble : (Ljava/lang/String;)D
    //   1233: invokevirtual X : (D)V
    //   1236: aload #21
    //   1238: areturn
    //   1239: astore #20
    //   1241: aload #21
    //   1243: astore_1
    //   1244: goto -> 1251
    //   1247: astore #20
    //   1249: aconst_null
    //   1250: astore_1
    //   1251: aload #20
    //   1253: invokestatic e : (Ljava/lang/Throwable;)V
    //   1256: aload_1
    //   1257: areturn
    //   1258: ldc_w 2131627254
    //   1261: istore #16
    //   1263: goto -> 245
    //   1266: iconst_0
    //   1267: istore #16
    //   1269: goto -> 559
    //   1272: dload #8
    //   1274: dconst_0
    //   1275: dcmpl
    //   1276: ifeq -> 786
    //   1279: dload_2
    //   1280: dconst_0
    //   1281: dcmpl
    //   1282: ifeq -> 943
    //   1285: goto -> 786
    //   1288: aconst_null
    //   1289: astore_1
    //   1290: goto -> 831
    //   1293: goto -> 893
    //   1296: goto -> 1005
    // Exception table:
    //   from	to	target	type
    //   0	12	1247	java/lang/Exception
    //   17	34	45	java/lang/Exception
    //   52	61	1247	java/lang/Exception
    //   69	104	45	java/lang/Exception
    //   106	115	1247	java/lang/Exception
    //   117	124	1247	java/lang/Exception
    //   126	132	1247	java/lang/Exception
    //   137	166	45	java/lang/Exception
    //   168	182	1247	java/lang/Exception
    //   187	193	45	java/lang/Exception
    //   195	206	1247	java/lang/Exception
    //   230	237	45	java/lang/Exception
    //   245	250	45	java/lang/Exception
    //   258	264	45	java/lang/Exception
    //   266	287	1247	java/lang/Exception
    //   294	300	45	java/lang/Exception
    //   316	322	1247	java/lang/Exception
    //   336	349	45	java/lang/Exception
    //   351	357	45	java/lang/Exception
    //   359	368	1247	java/lang/Exception
    //   376	389	45	java/lang/Exception
    //   398	417	45	java/lang/Exception
    //   420	426	1247	java/lang/Exception
    //   426	447	1247	java/lang/Exception
    //   447	490	1247	java/lang/Exception
    //   496	506	1247	java/lang/Exception
    //   506	518	1247	java/lang/Exception
    //   521	546	1247	java/lang/Exception
    //   546	553	1239	java/lang/Exception
    //   559	591	1239	java/lang/Exception
    //   594	599	1239	java/lang/Exception
    //   599	731	1239	java/lang/Exception
    //   731	783	1239	java/lang/Exception
    //   786	825	1239	java/lang/Exception
    //   831	858	1239	java/lang/Exception
    //   864	870	1239	java/lang/Exception
    //   873	890	1239	java/lang/Exception
    //   893	910	1239	java/lang/Exception
    //   910	943	1239	java/lang/Exception
    //   943	948	1239	java/lang/Exception
    //   952	983	1239	java/lang/Exception
    //   986	1002	1239	java/lang/Exception
    //   1005	1021	1239	java/lang/Exception
    //   1021	1031	1239	java/lang/Exception
    //   1031	1074	1239	java/lang/Exception
    //   1074	1124	1239	java/lang/Exception
    //   1124	1199	1239	java/lang/Exception
    //   1202	1208	1239	java/lang/Exception
    //   1211	1236	1239	java/lang/Exception }
  
  private double getValueByString(String paramString) { return (paramString.length() > 0) ? n.aU(paramString) : 0.0D; }
  
  private double getVipDiscount() { return (this.vipEntity != null && a.AZ().Bx()) ? this.vipEntity.discount : a.AZ().Bn(); }
  
  private boolean handleCouponPaySubmit() {
    if (this.payTypeItemViewSelected.aTv == 10014) {
      if (isVerificationGroup()) {
        String str = getGroupDialog().xq();
        if (str == null) {
          n.o("团购验证券对应的单号为空");
          return true;
        } 
        if (getGroupDialog().LI() > n.u(this.mAfterNeglectSmallChangesAmount)) {
          showAlertIfCouponAmoutBiggerThanPayableAmount();
          return true;
        } 
        settlement(str);
        return true;
      } 
      verificationGroupFirst();
      return true;
    } 
    return false;
  }
  
  private boolean handleOnlinePaySubmit() {
    b b = getPaidOfSecond();
    boolean bool = this.posActivitySettlementPresenter.c(b);
    getQRCodePayTypeID(b);
    return showScanCodeDialog(bool);
  }
  
  private boolean handlePhoneOrderSubmit() {
    if (getIsPhoneOrderType()) {
      fh.a a1 = new fh.a(this.deliveryCheck.isChecked() ^ true, n.aU(this.etDiscount.getText()), getPaidOfSecond(), this.payTypeItemViewSelected, n.aU(this.etPaid.getText().toString().trim()), getPaidOfSecondAmount());
      if (this.isEditPhoneOrder) {
        fg.a(this.productDeleteData, this.productData, this.phoneHeader, a1);
        dismiss();
        this.mCallback.OD();
        return true;
      } 
      long l = System.currentTimeMillis();
      PendingFullOrderDetail pendingFullOrderDetail = fg.a(this.telephoneEntity, this.productData, a1);
      dismiss();
      this.mCallback.b(pendingFullOrderDetail, this.productData, l);
      return true;
    } 
    return false;
  }
  
  private boolean handleReturnMode() {
    if (!this.isSaleOrder) {
      b b = new b(this.activity);
      if (b.Pl()) {
        if (!handleVIPSubmit())
          settlement(null); 
      } else {
        b.a(new bl(this));
      } 
      return true;
    } 
    return false;
  }
  
  private boolean handleVIPSubmit() {
    if (this.payTypeItemViewSelected.aTv == 10006 && this.vipEntity.aWH.isOpen) {
      (new e(this.mActivity, this.vipEntity, new bm(this))).s(this.vipEntity);
      return true;
    } 
    return false;
  }
  
  private boolean hasDeliveryman() { return (this.phoneHeader.aVN > 0L); }
  
  private boolean hasPendingOrder(bb parambb) {
    Iterator iterator = parambb.bbT.iterator();
    while (iterator.hasNext()) {
      if (((aa)iterator.next()).GN())
        return true; 
    } 
    return false;
  }
  
  private void hideVipRechargeButton() { this.rechargeButton.setVisibility(4); }
  
  private void initActualAmoutView(View paramView) {
    paramView = paramView.findViewById(2131298678);
    this.tvActual = (TextView)paramView.findViewById(2131298679);
    this.etActual = (EditText)paramView.findViewById(2131298677);
    l.a(getWindow(), this.etActual);
    paramView.setOnClickListener(new cc(this));
    this.etActual.addTextChangedListener(new cl(this));
  }
  
  private void initCouponView(View paramView) {
    this.verificationCheckButton = paramView.findViewById(2131299970);
    this.verificationCheckButton.setOnClickListener(new bg(this));
  }
  
  private void initDiscountView(View paramView) {
    ViewGroup viewGroup = (ViewGroup)paramView.findViewById(2131296883);
    this.etDiscount = (EditText)viewGroup.findViewById(2131296881);
    l.a(getWindow(), this.etDiscount);
    viewGroup.setOnClickListener(new cm(this));
    this.etDiscount.addTextChangedListener(new cn(this));
  }
  
  private void initFastAmoutDefault() {
    this.fastAmountsDefault = new ArrayList();
    this.fastAmountsDefault.add(Integer.valueOf(10));
    this.fastAmountsDefault.add(Integer.valueOf(20));
    this.fastAmountsDefault.add(Integer.valueOf(50));
    this.fastAmountsDefault.add(Integer.valueOf(100));
  }
  
  private void initFirstPaidView(View paramView) {
    this.tvPaid = (TextView)paramView.findViewById(2131298342);
    this.etPaid = (EditText)paramView.findViewById(2131298343);
    l.a(getWindow(), this.etPaid);
    this.etPaid.setOnFocusChangeListener(this.onFocusChangeListener);
    this.tvPaid.setOnClickListener(new m.b(this.mActivity, this.etPaid, false));
    this.etPaid.addTextChangedListener(new bj(this));
  }
  
  private void initKeyboardView(View paramView) {
    ViewGroup viewGroup = (ViewGroup)paramView.findViewById(2131297424);
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
    initFastAmoutDefault();
  }
  
  private void initLeftView() {
    View view = this.mView.findViewById(2131297738);
    initDiscountView(view);
    initRoundAmount(view);
    initActualAmoutView(view);
    initPayableAmoutView(view);
    initPayTypeSettingView(view);
    initOtherPayViewGroup();
    initPayTypeListView(view);
    initTableNumberView(view);
    initMemberPointDeductionView(view);
    initPackViewAndDeliveryView(view);
    initOrderTypeView();
    initPrintView(view);
    initVIPView(view);
    this.posActivitySettlementPresenter.Pn();
  }
  
  private void initMemberPointDeductionView(View paramView) {
    this.points_deduction_l = paramView.findViewById(2131298423);
    this.points_deduction = (TextView)this.points_deduction_l.findViewById(2131298421);
    this.points_deduction_check = (CheckBox)this.points_deduction_l.findViewById(2131298422);
    this.points_deduction_l.setOnClickListener(new m.b(this.mActivity, this.points_deduction_check));
    this.points_deduction_check.setOnCheckedChangeListener(new bq(this));
    if (!a.AZ().BB())
      this.points_deduction_l.setVisibility(8); 
  }
  
  private void initMemberRechargeView(View paramView) {
    this.rechargeButton = paramView.findViewById(2131298681);
    this.rechargeButton.setOnClickListener(new bh(this));
  }
  
  private void initOrderTypeView() {
    this.bt_orderType = (TextView)this.lTableNumbers.findViewById(2131299625);
    this.tv_order_up = this.lTableNumbers.findViewById(2131299626);
  }
  
  private void initOtherPayViewGroup() {
    this.otherPayViewGroup = (ViewGroup)View.inflate(this.mActivity, 2131427836, null);
    this.otherPayWindow = new PopupWindow(this.otherPayViewGroup, -2, -2, true);
    this.otherPayWindow.setBackgroundDrawable(new ColorDrawable(false));
    this.otherPayWindow.setAnimationStyle(2131689689);
    this.otherPayWindow.setOutsideTouchable(true);
  }
  
  private void initPackViewAndDeliveryView(View paramView) {
    this.pack_l = paramView.findViewById(2131298339);
    this.pack_check = (CheckBox)this.pack_l.findViewById(2131298337);
    this.delivery_l = paramView.findViewById(2131298338);
    this.deliveryCheck = (CheckBox)this.delivery_l.findViewById(2131296864);
    if (a.zR().Ab()) {
      CheckBox checkBox1 = this.pack_check;
      d d2 = this.posActivitySettlementPresenter;
      d2.getClass();
      checkBox1.setOnCheckedChangeListener(new d.a(d2, this.mActivity, this.deliveryCheck));
    } else {
      this.pack_l.setOnClickListener(new m.b(this.mActivity, this.pack_check));
    } 
    CheckBox checkBox = this.deliveryCheck;
    d d1 = this.posActivitySettlementPresenter;
    d1.getClass();
    checkBox.setOnCheckedChangeListener(new d.a(d1, this.mActivity, this.pack_check));
  }
  
  private void initPayTypeItemViewList(ViewGroup paramViewGroup, int paramInt) {
    for (byte b = 0; b < paramViewGroup.getChildCount(); b++) {
      View view = paramViewGroup.getChildAt(b);
      if (b == 0 || paramInt == 0) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
        if (b == 0)
          marginLayoutParams.leftMargin = 0; 
        if (paramInt == 0)
          marginLayoutParams.topMargin = 0; 
      } 
      c c1 = new c(view, (TextView)view.findViewById(2131297257), (DefensiveTextView)view.findViewById(2131298198), this.clickPayTypeItem);
      this.payTypeItemViewList.add(c1);
    } 
  }
  
  private void initPayTypeListView(View paramView) {
    this.payTypeItemViewList = new ArrayList();
    initPayTypeItemViewList((ViewGroup)paramView.findViewById(2131298367), 0);
    initPayTypeItemViewList((ViewGroup)paramView.findViewById(2131298368), 1);
    setPayTypeItemView();
  }
  
  private void initPayTypeSettingView(View paramView) {
    this.pay_type_setting_l = (RelativeLayout)findViewById(2131298373);
    this.pay_type_body1 = findViewById(2131298367);
    this.pay_type_body2 = findViewById(2131298368);
    paramView = paramView.findViewById(2131298373).findViewById(2131298372);
    if (!"150001".equals(CrashApplication.getLaiqianPreferenceManager().atp())) {
      paramView.setVisibility(4);
      return;
    } 
    paramView.setOnClickListener(new m.c(this.activity, com.laiqian.pos.PayTypeSettingActivity.class));
  }
  
  private void initPayableAmoutView(View paramView) {
    this.vPayableAmount = paramView.findViewById(2131298377);
    this.etPayableAmount = (TextView)this.vPayableAmount.findViewById(2131298376);
  }
  
  private void initPrintView(View paramView) {
    this.kitchenPrint = paramView.findViewById(2131297438);
    this.kitchenPrintCheck = (CheckBox)this.kitchenPrint.findViewById(2131297437);
    this.kitchenPrint.setOnClickListener(new m.b(this.mActivity, this.kitchenPrintCheck));
    this.receiptPrint = paramView.findViewById(2131298676);
    this.receiptPrintCheck = (CheckBox)this.receiptPrint.findViewById(2131298675);
    this.receiptPrint.setOnClickListener(new m.b(this.mActivity, this.receiptPrintCheck));
  }
  
  private void initRightView() {
    View view1 = this.mView.findViewById(2131298744);
    View view2 = view1.findViewById(2131298743);
    initFirstPaidView(view2);
    initSecondPaidView(view2);
    changePaidSecond(null, false);
    initMemberRechargeView(view2);
    initVIPBalanceInsufficientDialog();
    initCouponView(view2);
    initKeyboardView(view1);
    this.submitButton = (TextView)view1.findViewById(2131299090);
    this.submitButton.setOnClickListener(clickSubmitButtonLsn());
    this.vPreProgress = view1.findViewById(2131297345);
    this.notOperableView = findViewById(2131300013);
    this.prePrint = findViewById(2131298465);
    this.prePrint.setOnClickListener(new cq(this));
  }
  
  private void initRoundAmount(View paramView) {
    this.mRoundChanges = paramView.findViewById(2131297942);
    this.mSmallChanges = (TextView)this.mRoundChanges.findViewById(2131298427);
    paramView = this.mRoundChanges.findViewById(2131298426);
    if ((new av(getContext())).avM()) {
      paramView.setOnClickListener(new bc(this));
      this.mSmallChanges.setOnClickListener(new bd(paramView));
    } 
  }
  
  private void initSecondPaidView(View paramView) {
    this.paidOfSecond = paramView.findViewById(2131297181);
    paramView = this.paidOfSecond.findViewById(2131297183);
    paramView.setOnClickListener(new bi(this));
    this.tvPaidOfSecond = (TextView)paramView.findViewById(2131297182);
    this.etPaidOfSecond = (TextView)this.paidOfSecond.findViewById(2131297184);
    if (a.zR().Ab())
      this.etPaidOfSecond.getPaint().setFakeBoldText(true); 
    this.posActivitySettlementPresenter.cr(this.paidOfSecond);
  }
  
  private void initTableNumberView(View paramView) {
    this.lTableNumbers = paramView.findViewById(2131299161);
    this.etTableNumbers = (EditText)this.lTableNumbers.findViewById(2131299160);
    this.tv_table_numbers = (TextView)this.lTableNumbers.findViewById(2131299715);
    l.a(getWindow(), this.etTableNumbers);
    this.etTableNumbers.setOnFocusChangeListener(this.onFocusChangeListener);
    this.lTableNumbers.setOnClickListener(new m.b(this.mActivity, this.etTableNumbers, false));
  }
  
  private void initVIPBalanceInsufficientDialog() {
    this.vipBalanceInsufficientDialog = new r(this.mActivity, 3, null);
    this.vipBalanceInsufficientDialog.setTitle(this.mActivity.getString(2131627480));
    this.vipBalanceInsufficientDialog.s(this.mActivity.getString(2131626989));
    this.vipBalanceInsufficientDialog.pa(this.mActivity.getString(2131626861));
  }
  
  private void initVIPView(View paramView) {
    this.vip_info_l = paramView.findViewById(2131299992);
    this.vip_info_l.findViewById(2131299990).setOnClickListener(new co(this));
    this.vip_info_name = (TextView)this.vip_info_l.findViewById(2131299998).findViewById(2131300000);
    this.vip_info_phone = (TextView)this.vip_info_l.findViewById(2131300002).findViewById(2131300004);
    this.vip_info_points = (TextView)this.vip_info_l.findViewById(2131300005).findViewById(2131300007);
    this.vip_info_balance = (TextView)this.vip_info_l.findViewById(2131299983).findViewById(2131299985);
  }
  
  private boolean isAllNotDiscount() { return n.bc(this.sumAmountContainTaxOfAddPrice - this.sumAmountUnDiscount); }
  
  private boolean isDeliveryOrder() { return this.posActivitySettlementPresenter.isDeliveryOrder(); }
  
  private boolean isFirstPayEqualsBarcodePay(c paramc) { return paramc.bpq; }
  
  private boolean isFirstPayTypeEqualsQRPay(c paramc) { return paramc.bpr; }
  
  private boolean isFirstPayTypeIsOnlinePayType() { return (isFirstPayEqualsBarcodePay(this.payTypeItemViewSelected) || isFirstPayTypeEqualsQRPay(this.payTypeItemViewSelected)); }
  
  private boolean isMemberBalanceNotEnough() {
    double d3 = n.aU(this.mAfterNeglectSmallChangesAmount);
    double d2 = Double.parseDouble(n.ba(this.vipEntity.aWo));
    double d1 = d2;
    if (CrashApplication.getLaiqianPreferenceManager().avZ())
      d1 = d2 - CrashApplication.getLaiqianPreferenceManager().avY(); 
    return (this.isSaleOrder && !a.AZ().Bu() && n.e(new Object[] { Double.valueOf(d3), Double.valueOf(d1) }) > 0.0D);
  }
  
  private boolean isMemberPaidCanEdit() { return (!a.AZ().Bu() && (!isMultipleShop() || CrashApplication.getLaiqianPreferenceManager().avV())); }
  
  private boolean isMultipleShop() { return CrashApplication.getLaiqianPreferenceManager().isMultipleShop(); }
  
  private boolean isNeedSetDiscountAfterVIPSelected() { return (getVipDiscount() != a.AZ().Bn() && this.isSaleOrder && !isAllNotDiscount()); }
  
  private boolean isNotOnlinePayType() { return (!isFirstPayTypeEqualsQRPay(this.payTypeItemViewSelected) && !isFirstPayEqualsBarcodePay(this.payTypeItemViewSelected) && this.payTypeItemViewSelected.aTv != 10014); }
  
  private boolean isOnlinePayType(int paramInt) { return (paramInt == 10007 || paramInt == 10009); }
  
  private boolean isOpenCashBox() {
    double d1 = n.aU(this.mAfterNeglectSmallChangesAmount);
    double d2 = n.aU(this.etPaid.getText());
    if (d2 <= d1)
      d1 = d2; 
    boolean bool = false;
    d2 = getPaidOfSecondAmount();
    if ((obtainPayTypeItemByPayTypeItemView(this.payTypeItemViewSelected, d1)).aTv == 10001)
      bool = true; 
    b b = getPaidOfSecond();
    return (b != null && (new z(b, d2)).aTv == 10001) ? true : bool;
  }
  
  private boolean isOpenTableOrScanOrderType(long paramLong) { return (paramLong == 7L || paramLong == 14L || paramLong == 14L); }
  
  private boolean isQRcodeValid(String paramString) { return (paramString != null); }
  
  private boolean isSecondPayEqualsQRCodePay(b paramb) { return (paramb != null && paramb.bpr); }
  
  private boolean isSecondPayTypeIsOnlinePayType() { return (getPaidOfSecond() != null && ((getPaidOfSecond()).bpq || isSecondPayEqualsQRCodePay(getPaidOfSecond()))); }
  
  private boolean isShowPointsDeductionView() { return (this.vipEntity != null && this.hasPointsDeduction && this.isSaleOrder); }
  
  private boolean isTableNumberLayoutVisible() { return (this.lTableNumbers.getVisibility() == 0); }
  
  private boolean isTableOrder(String paramString) { return (paramString == null); }
  
  private boolean isUseChainMember() { return (isMultipleShop() && this.vipEntity != null); }
  
  private boolean isVerificationGroup() { return (this.leftViewLimit != null && this.leftViewLimit.getVisibility() == 0); }
  
  private boolean mergeFirstPayAndSecondPay(@Nullable b paramb) {
    if (this.payTypeItemViewSelected != null && this.payTypeItemViewSelected.aTv == paramb.aTv)
      if (this.payTypeItemViewSelected.aTv == 10013) {
        if (this.payTypeItemViewSelected.aTe == paramb.aTx) {
          showMergedPaidView();
          return true;
        } 
      } else {
        showMergedPaidView();
        return true;
      }  
    return false;
  }
  
  private b obtainPayTypeItemByPayTypeEntity(v paramv) {
    long l;
    int i = paramv.aSX;
    String str = paramv.name;
    if (paramv.FQ()) {
      l = paramv.aSW;
    } else {
      l = 0L;
    } 
    return new b(i, 0.0D, str, l);
  }
  
  private b obtainPayTypeItemByPayTypeItemView(c paramc, double paramDouble) { return new b(paramc.aTv, paramDouble, paramc.aKu.getText().toString(), paramc.aTe); }
  
  private void popupRoundPopupWindow(TextView paramTextView, View paramView) {
    ListPopupWindow listPopupWindow = new ListPopupWindow(getContext());
    listPopupWindow.setAdapter(new a(this, getContext()));
    listPopupWindow.setWidth(160);
    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    listPopupWindow.setHorizontalOffset(paramView.getMeasuredWidth() + marginLayoutParams.rightMargin / 2);
    listPopupWindow.setVerticalOffset(-paramView.getMeasuredHeight());
    listPopupWindow.setOnItemClickListener(new be(this, listPopupWindow));
    listPopupWindow.setAnchorView(paramView);
    listPopupWindow.show();
  }
  
  private Object[] preSettlement(String paramString, boolean paramBoolean) {
    byte b1;
    if (this.settlementRunnable != null)
      return null; 
    if (this.isDiscountConvertion) {
      if (Double.valueOf(this.etDiscount.getText().toString()).doubleValue() > 100.0D) {
        n.eP(2131627260);
        return null;
      } 
    } else if (this.etDiscount.getText().length() == 0) {
      n.eP(2131627258);
      return null;
    } 
    double d1 = getDiscountValue();
    if (this.isDiscountConvertion ? (d1 > 100.0D) : (d1 > 300.0D)) {
      int j;
      if (this.isDiscountConvertion) {
        j = 2131627466;
      } else {
        j = 2131627254;
      } 
      n.eP(j);
      return null;
    } 
    if (d1 < 0.0D) {
      n.eP(2131627255);
      return null;
    } 
    double d3 = n.aU(this.mAfterNeglectSmallChangesAmount);
    double d2 = n.aU(this.etPaid.getText());
    if (d2 < 0.0D) {
      n.eP(2131626369);
      return null;
    } 
    d1 = d2;
    if (d2 > d3)
      d1 = d3; 
    double d4 = getPaidOfSecondAmount();
    if (d3 - d1 - d4 > 1.0E-6D) {
      if (this.isSaleOrder) {
        n.eP(2131627252);
        return null;
      } 
      n.eP(2131627253);
      return null;
    } 
    if (this.payTypeItemViewSelected.aTv == 10006 && this.vipEntity == null) {
      n.eP(2131627256);
      return null;
    } 
    if (d3 <= 0.0D) {
      d2 = n.aU(this.etActual.getText());
    } else {
      d2 = getPointsDeductionDouble();
    } 
    this.amountServiceCharge = 0.0D;
    if (this.isSaleOrder)
      for (aa aa : this.productData) {
        double d5;
        double d6 = this.amountServiceCharge;
        double d7 = aa.GK();
        if (aa.Gv()) {
          d5 = 1.0D;
        } else {
          d5 = getDiscountValue() / 100.0D;
        } 
        this.amountServiceCharge = d6 + d7 * d5;
      }  
    bb bb = new bb(this.isSaleOrder, this.productData, this.sumAmountContainTaxOfAddPrice, getDiscountValue());
    bb.orderNo = paramString;
    bb.vipEntity = this.vipEntity;
    bb.bca = d2;
    bb.amountRounding = this.amountRounding;
    bb.bcf = this.payMark;
    bb.aTZ = this.pack_check.isChecked();
    bb.bcm = this.receiptPrintCheck.isChecked();
    bb.bcn = this.kitchenPrintCheck.isChecked();
    bb.Y(this.amountServiceCharge);
    if (this.posTableEntity != null) {
      bb.bch = b.a(this.posTableEntity.Yb(), this.posTableEntity.Ye(), this.posTableEntity.Yf(), this.posTableEntity.DP());
      bb.bbP = this.posTableEntity.Yg().DP();
    } 
    if (d3 == 0.0D || d1 != 0.0D) {
      if (this.payTypeItemViewSelected.aTv == 10014) {
        d2 = getGroupDialog().LI();
        bb.bcb = d1 - d2;
        paramString = getGroupDialog().LH();
        d1 = d2;
      } else {
        paramString = null;
      } 
      b b2 = obtainPayTypeItemByPayTypeItemView(this.payTypeItemViewSelected, d1);
      if (b2.aTv == 10001) {
        d1 = getGiveChangeAmount();
        if (d1 > 0.0D)
          b2.aTw = d1; 
        b1 = 1;
      } else {
        b1 = 0;
      } 
      b2.aTy = paramString;
      bb.bbS.add(b2);
      bb.bbY += b2.aJW;
    } else {
      b1 = 0;
    } 
    b b = getPaidOfSecond();
    int i = b1;
    if (b != null) {
      z z = new z(b, d4);
      if (z.aTv == 10001) {
        bb.bbS.add(0, z);
        b1 = 1;
      } else {
        bb.bbS.add(z);
      } 
      bb.bbY += d4;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("添加了组合支付：");
      stringBuilder.append(d4);
      n.println(stringBuilder.toString());
      i = b1;
    } 
    if (this.lTableNumbers.getVisibility() == 0)
      if ((this.payMark == 7L || this.payMark == 14L) && this.posTableEntity != null) {
        bb.bbR = Long.valueOf(this.posTableEntity.getID());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.posTableEntity.getID());
        stringBuilder.append("");
        bb.bbQ = stringBuilder.toString();
        bb.openTableName = this.openTableName;
      } else {
        String str = this.etTableNumbers.getText().toString();
        if (str.length() > 0)
          bb.bbQ = str; 
      }  
    if (paramBoolean)
      if (c.bi(getContext()).ahV().size() != 0) {
        aq aq1;
        if (this.deletedOrder != null) {
          aq1 = new aq(this.activity, bb, this.deletedOrder, true);
        } else if (hasPendingOrder(bb) && bb.bbQ != null) {
          a a1 = new a(this.activity);
          PendingFullOrderDetail pendingFullOrderDetail = a1.ks(bb.bbQ);
          a1.close();
          aq1 = new aq(this.activity, bb, pendingFullOrderDetail, true);
        } else {
          aq1 = new aq(this.activity, bb, true);
        } 
        aq1.df(true);
        aq1.start();
        n.eP(2131627422);
      } else {
        n.eP(2131628807);
      }  
    return new Object[] { bb, Boolean.valueOf(i) };
  }
  
  private AliPayPreorderDetail prepareAlipayPreorder(@PayType int paramInt, String paramString) {
    AliPayPreorderDetail aliPayPreorderDetail = new AliPayPreorderDetail();
    aliPayPreorderDetail.bkf = new Date();
    aliPayPreorderDetail.ceZ = n.aU(paramString);
    aliPayPreorderDetail.aJW = n.aU(this.mAfterNeglectSmallChangesAmount);
    aliPayPreorderDetail.ceX = Double.valueOf(this.sumAmountContainTaxOfAddPrice - aliPayPreorderDetail.aJW);
    aliPayPreorderDetail.type = paramInt;
    aliPayPreorderDetail.bbS.add(obtainPayTypeItemByPayTypeItemView(this.payTypeItemViewSelected, n.aU(this.etPaid.getText().toString())));
    b b = getPaidOfSecond();
    if (b != null) {
      z z = new z(b, getPaidOfSecondAmount());
      aliPayPreorderDetail.bbS.add(z);
    } 
    if (isTableNumberLayoutVisible()) {
      String str = this.etTableNumbers.getText().toString();
      if (str.length() > 0)
        aliPayPreorderDetail.ceW = Long.valueOf(n.parseLong(str)); 
    } 
    aliPayPreorderDetail.ceV = CrashApplication.getLaiqianPreferenceManager().Ea();
    for (aa aa : this.productData) {
      HashMap hashMap = new HashMap();
      String str2 = aa.name;
      ArrayList arrayList = aa.GL();
      String str1 = str2;
      if (arrayList.size() != 0) {
        null = new StringBuilder();
        null.append(str2);
        null.append("[");
        null.append(c.a(null, arrayList));
        null.append("]");
        str1 = null.toString();
      } 
      hashMap.put("sProductName", str1);
      hashMap.put("nProductQty", n.e(aa.Gw(), 3));
      hashMap.put("fPrice", n.ba(aa.GA()));
      hashMap.put("fAmount", n.ba(aa.AO()));
      hashMap.put("fOriginalPrice", n.ba(aa.GA()));
      aliPayPreorderDetail.bJf.add(hashMap);
    } 
    aliPayPreorderDetail.ceY = null;
    return aliPayPreorderDetail;
  }
  
  private void prepareWholePage(String paramString, long paramLong, boolean paramBoolean) {
    toggleDiscountAndActualAmountValueAndEditStatus();
    setVerificationGroup(false);
    showEvakoLayouts();
    showPackCheckBox();
    showTableNumber(paramString, paramLong, paramBoolean);
    setPaidCanEdit(true);
    this.etPaid.requestFocus();
    b.ckg.aak();
    toggleBarcodeProgress(8);
    setCanOperate(true);
  }
  
  private boolean refreshPointsDeductionView() {
    if (isShowPointsDeductionView()) {
      this.points_deduction_l.setVisibility(0);
      this.points_deduction_check.setChecked(false);
      this.vPayableAmount.setVisibility(0);
      return true;
    } 
    this.points_deduction_l.setVisibility(8);
    this.points_deduction_check.setChecked(false);
    this.vPayableAmount.setVisibility(8);
    return false;
  }
  
  private void registerEtPayableAmount() {
    this.etPayableAmount.removeTextChangedListener(this.metPayableAmountTextWatcher);
    this.etPayableAmount.addTextChangedListener(this.metPayableAmountTextWatcher);
  }
  
  private void resetFirstPayTypeItem(long paramLong) {
    int i = this.payTypeItemViewSelected.aTv;
    byte b2 = 0;
    byte b1 = 0;
    if (i == 10007) {
      long l = paramLong;
      if (paramLong < 0L) {
        paramLong = getAliPay(this.payTypeItemViewSelected.aTe);
        l = paramLong;
        if (paramLong < 0L)
          return; 
      } 
      c c1 = this.payTypeItemViewSelected;
      if (l == 1L) {
        b = 1;
      } else {
        b = 0;
      } 
      c1.bpq = b;
      c1 = this.payTypeItemViewSelected;
      byte b = b1;
      if (l == 0L)
        b = 1; 
      c1.bpr = b;
      this.payTypeItemViewSelected.aTe = l;
      return;
    } 
    if (this.payTypeItemViewSelected.aTv == 10009) {
      long l = paramLong;
      if (paramLong < 0L) {
        paramLong = getWechat(this.payTypeItemViewSelected.aTe);
        l = paramLong;
        if (paramLong < 0L)
          return; 
      } 
      c c1 = this.payTypeItemViewSelected;
      if (l == 5L) {
        b = 1;
      } else {
        b = 0;
      } 
      c1.bpq = b;
      c1 = this.payTypeItemViewSelected;
      byte b = b2;
      if (l == 8L)
        b = 1; 
      c1.bpr = b;
      this.payTypeItemViewSelected.aTe = l;
    } 
  }
  
  private void resetPayTypeItemView(boolean paramBoolean) {
    if (paramBoolean) {
      resetSecondPayTypeItemView(this.DEFAULT_ONLINE_PAY_TYPE);
      return;
    } 
    resetFirstPayTypeItemView(this.DEFAULT_ONLINE_PAY_TYPE);
  }
  
  private void resetSecondPayTypeItem(long paramLong) {
    b b = (b)this.paidOfSecond.getTag();
    byte b2 = 0;
    if (paramLong == 5L) {
      b1 = 1;
    } else {
      b1 = 0;
    } 
    b.bpq = b1;
    byte b1 = b2;
    if (paramLong == 8L)
      b1 = 1; 
    b.bpr = b1;
    b.aTx = paramLong;
    this.paidOfSecond.setTag(b);
  }
  
  private <T> void safeAddListItem(List<T> paramList, T paramT) {
    if (paramList != null && paramT != null)
      paramList.add(paramT); 
  }
  
  private void selectedOtherPayTypeValue(v paramv) {
    if (this.otherPayTypeItemView == null) {
      n.println("其他支付的按钮View=null，这里不会进来");
      return;
    } 
    if (paramv.FQ()) {
      this.otherPayTypeItemView.a(paramv.aTa, paramv.name, paramv.aSW);
      return;
    } 
    this.otherPayTypeItemView.a(paramv.aSX, paramv.aTb, paramv.name, 0L, 2131626884, this.mActivity.getString(2131627266));
  }
  
  private void selectedOtherPayTypeValueInitial() {
    if (this.otherPayTypeItemView == null) {
      n.println("没有其他支付");
      return;
    } 
    if (this.payTypeOther.size() == 1) {
      selectedOtherPayTypeValue((v)this.payTypeOther.get(0));
      return;
    } 
    this.otherPayTypeItemView.a(10013, 2131231336, this.mActivity.getString(2131626893), 0L, 2131626884, "");
  }
  
  private void selectedVipTypeView() {
    changePayType(10006, true);
    setDiscountAndAmoutForVIP();
    if (isMemberBalanceNotEnough()) {
      setEtPaidVipBalance();
      showVipBalanceInsufficientDialog();
      showVipRechargeButton();
      setPaidCanEdit(isMemberPaidCanEdit());
      return;
    } 
    setEtPaidPayableAmount();
    hideVipRechargeButton();
    setPaidCanEdit(isMemberPaidCanEdit());
  }
  
  private void setAmountValue(boolean paramBoolean1, boolean paramBoolean2) {
    if (!isShowing())
      return; 
    if ((this.isOpenMemberPrice && paramBoolean1) || paramBoolean2)
      updateSumAmount(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("这里是setAmountValue时，折扣：");
    stringBuilder.append(getDiscountValue());
    stringBuilder.append(",isChangeVip:");
    stringBuilder.append(paramBoolean1);
    stringBuilder.append(",这里的折扣，很可能是错误的");
    n.println(stringBuilder.toString());
    if (this.etDiscount.requestFocus()) {
      setDiscountTextViewValue(getDiscountValue());
      this.etActual.setText(getActualAmountByDiscount(getDiscountValue()));
    } else {
      this.etActual.setText(getActualAmountByDiscount(getDiscountValue()));
    } 
    if (isUseChainMember()) {
      setCanEditDiscountActual(false);
    } else {
      setDiscountIsEditable();
    } 
    if (paramBoolean2)
      ((PosActivity)this.activity).eP(this.orderTypeID); 
  }
  
  private void setCanEditDiscountActual(boolean paramBoolean) {
    this.etDiscount.setFocusableInTouchMode(paramBoolean);
    this.etActual.setFocusableInTouchMode(paramBoolean);
    this.etDiscount.clearFocus();
    this.etActual.clearFocus();
  }
  
  private void setDiscountIsEditable() { setCanEditDiscountActual(isAllNotDiscount() ^ true); }
  
  private void setDiscountTextViewValue(double paramDouble) {
    double d1;
    this.etDiscount.setTag(Double.valueOf(paramDouble));
    EditText editText = this.etDiscount;
    if (this.isDiscountConvertion) {
      d1 = 100.0D - paramDouble;
    } else {
      d1 = paramDouble;
    } 
    editText.setText(n.ba(d1));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("设置了折扣setDiscountTextViewValue：");
    stringBuilder.append(paramDouble);
    n.println(stringBuilder.toString());
  }
  
  private void setEtActualAndEtDiscountEnable(boolean paramBoolean) {
    this.etActual.setEnabled(paramBoolean);
    this.etActual.setTextIsSelectable(paramBoolean);
    this.etDiscount.setEnabled(paramBoolean);
    this.etDiscount.setTextIsSelectable(paramBoolean);
  }
  
  private void setEtActualTextViewValue(boolean paramBoolean) {
    if (!paramBoolean)
      this.etActual.setText(getActualAmountByDiscount(getDiscountValue())); 
  }
  
  private void setEtPaidPayableAmount() { this.etPaid.setText(n.a(this.mAfterNeglectSmallChangesAmount, true, false)); }
  
  private void setEtPaidVipBalance() {
    String str = n.ba(this.vipEntity.aWo);
    if (this.vipEntity.aWo < 0.0D) {
      this.etPaid.setText("0");
      return;
    } 
    this.etPaid.setText(str);
  }
  
  private void setFastAmount(double paramDouble) {
    ArrayList arrayList2 = n.be(paramDouble);
    ArrayList arrayList1 = arrayList2;
    if (arrayList2 == null)
      arrayList1 = this.fastAmountsDefault; 
    for (byte b = 0; b < this.fastAmounts.length; b++) {
      TextView textView = this.fastAmounts[b];
      if (b < arrayList1.size()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(arrayList1.get(b));
        stringBuilder.append("");
        textView.setText(stringBuilder.toString());
      } else {
        textView.setText("");
      } 
    } 
  }
  
  private void setFocusOnTableNumberEditTextOrPaidEditText() {
    if (CrashApplication.getLaiqianPreferenceManager().atH()) {
      this.etTableNumbers.requestFocus();
      return;
    } 
    n.j(this.etPaid);
  }
  
  private void setNeglectSmallChanges(String paramString) {
    TextView textView;
    if (a.AZ().CC() && this.mRulePair != null) {
      double d1 = Double.parseDouble(paramString);
      double d2 = k.a(Double.valueOf(d1), ((Integer)this.mRulePair.first).intValue());
      null = new StringBuilder();
      null.append(n.a(Double.valueOf(d2 - d1), true, false));
      null.append("");
      this.neglectSmallChanges = null.toString();
      textView = this.mSmallChanges;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("<font color=\"#999999\">");
      stringBuilder.append((String)this.mRulePair.second);
      stringBuilder.append("(</font><font color=\"#984d10\">");
      stringBuilder.append(this.neglectSmallChanges);
      stringBuilder.append("</font><font color=\"#999999\">)</font>");
      textView.setText(Html.fromHtml(stringBuilder.toString()));
      showAfterPayableAmountChanged(String.valueOf(d2));
      return;
    } 
    this.neglectSmallChanges = "";
    showAfterPayableAmountChanged(textView);
  }
  
  private void setOtherPayViewGroupChild() {
    this.otherPayViewGroup.removeAllViews();
    int i = this.payTypeOther.size();
    View view = null;
    for (byte b = 0; b < i; b++) {
      LinearLayout linearLayout;
      if (b % 7 == 0) {
        if (b) {
          view = new View(this.mActivity);
          view.setBackgroundColor(this.mActivity.getResources().getColor(2131099824));
          this.otherPayViewGroup.addView(view, 1, -1);
        } 
        linearLayout = new LinearLayout(this.mActivity);
        linearLayout.setOrientation(1);
        this.otherPayViewGroup.addView(linearLayout);
      } 
      View view1 = View.inflate(this.mActivity, 2131427837, null);
      if (linearLayout == null) {
        n.println("设置其他支付的子项时出错，这里不会进来");
        return;
      } 
      v v = (v)this.payTypeOther.get(b);
      ((TextView)view1.findViewById(2131298198)).setText(v.name);
      TextView textView = (TextView)view1.findViewById(2131297257);
      if (v.FQ()) {
        textView.setTextColor(-1);
        String str = new GradientDrawable();
        str.setShape(1);
        str.setColor(v.aTa);
        textView.setBackgroundDrawable(str);
        if (v.name.isEmpty()) {
          String str1 = " ";
        } else {
          str = String.valueOf(v.name.charAt(0));
        } 
        textView.setText(str);
      } else {
        textView.setBackgroundResource(v.aTb);
      } 
      view1.setTag(v);
      view1.setOnClickListener(this.clickOtherPayTypeItem);
      linearLayout.addView(view1);
    } 
  }
  
  private void setPaidCanEdit(boolean paramBoolean) {
    this.etPaid.setFocusable(paramBoolean);
    this.etPaid.setFocusableInTouchMode(paramBoolean);
    if (paramBoolean) {
      n.j(this.etPaid);
      return;
    } 
    this.etActual.requestFocus();
  }
  
  private void setPayTypeAlipay(c paramc, boolean paramBoolean) {
    int k = a.AZ().Bo();
    int i = 2131626887;
    int j = 0;
    boolean bool = true;
    if (k == 0) {
      boolean bool1 = true;
    } else {
      boolean bool1;
      if (k == 1) {
        bool1 = false;
      } else {
        i = 2131626884;
        bool1 = false;
        bool = false;
      } 
      b b = obtainPayTypeItemByPayTypeItemView(paramc, 0.0D);
      b.bpq = bool;
      b.bpr = bool1;
      b.aTc = i;
      i = j;
      if (this.selectPaidSecondDialogItems.size() > -1) {
        i = j;
        if (paramBoolean) {
          this.selectPaidSecondDialogItems.add(this.selectPaidSecondDialogItems.size(), b);
          return;
        } 
      } 
      while (i < this.selectPaidSecondDialogItems.size()) {
        if (((b)this.selectPaidSecondDialogItems.get(i)).aTv == 10007) {
          this.selectPaidSecondDialogItems.set(i, b);
          return;
        } 
        i++;
      } 
      return;
    } 
    bool = false;
  }
  
  private void setPayTypeItemViewSelected(int paramInt) {
    Iterator iterator = this.payTypeItemViewList.iterator();
    while (iterator.hasNext())
      ((c)iterator.next()).a(paramInt, this.payTypeOther, this.payItemViewSelected); 
  }
  
  private void setPayTypeWechat(c paramc, boolean paramBoolean) {
    int k = a.AZ().Bq();
    int i = 2131626887;
    boolean bool = true;
    int j = 0;
    if (k == 8) {
      boolean bool1 = true;
    } else {
      boolean bool1;
      if (k == 5) {
        bool1 = false;
      } else {
        i = 2131626884;
        bool1 = false;
        bool = false;
      } 
      b b = obtainPayTypeItemByPayTypeItemView(paramc, 0.0D);
      b.bpq = bool;
      b.bpr = bool1;
      b.aTc = i;
      i = j;
      if (this.selectPaidSecondDialogItems.size() > -1) {
        i = j;
        if (paramBoolean) {
          this.selectPaidSecondDialogItems.add(this.selectPaidSecondDialogItems.size(), b);
          return;
        } 
      } 
      while (i < this.selectPaidSecondDialogItems.size()) {
        if (((b)this.selectPaidSecondDialogItems.get(i)).aTv == 10009) {
          this.selectPaidSecondDialogItems.set(i, b);
          return;
        } 
        i++;
      } 
      return;
    } 
    bool = false;
  }
  
  private void setPointsDeductionTextView(double paramDouble) {
    if (isShowPointsDeductionView())
      if (paramDouble < this.pointsDeductionAmount) {
        this.points_deduction.setText(n.ba(paramDouble));
      } else {
        this.points_deduction.setText(n.ba(this.pointsDeductionAmount));
      }  
    if (this.dualPresentation != null)
      this.dualPresentation.aF(getDualScreenDeductionAmount()); 
  }
  
  private void setVerificationGroup(boolean paramBoolean) {
    if (paramBoolean) {
      if (this.leftViewLimit == null) {
        this.leftViewLimit = findViewById(2131297739);
        this.leftViewLimit.setFocusable(true);
        this.leftViewLimit.setFocusableInTouchMode(true);
        this.leftViewLimit.setOnKeyListener(new bp(this));
      } 
      this.leftViewLimit.setVisibility(0);
      this.leftViewLimit.requestFocus();
      this.submitButton.setText(2131626884);
      this.verificationCheckButton.setVisibility(0);
      return;
    } 
    if (this.verificationCheckButton.getVisibility() != 8)
      this.verificationCheckButton.setVisibility(8); 
    if (this.leftViewLimit != null) {
      this.leftViewLimit.setVisibility(8);
      if (this.payTypeItemViewSelected.aTv == 10014)
        afterSelectedPayTypeAlipayWecharOther(10014, true, true); 
    } 
  }
  
  private void settlement(String paramString) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial getSettementEntity : (Ljava/lang/String;)Lcom/laiqian/main/bb;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnonnull -> 15
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: aload_0
    //   16: getfield settlementRunnable : Lcom/laiqian/main/di;
    //   19: astore_2
    //   20: aload_2
    //   21: ifnull -> 27
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_0
    //   28: new com/laiqian/main/di
    //   31: dup
    //   32: aload_0
    //   33: getfield activity : Lcom/laiqian/ui/ActivityRoot;
    //   36: aload_1
    //   37: aload_0
    //   38: invokespecial isOpenCashBox : ()Z
    //   41: new com/laiqian/main/cd
    //   44: dup
    //   45: aload_0
    //   46: invokespecial <init> : (Lcom/laiqian/main/PosActivitySettlementDialog;)V
    //   49: invokespecial <init> : (Landroid/content/Context;Lcom/laiqian/main/bb;ZLcom/laiqian/main/di$a;)V
    //   52: putfield settlementRunnable : Lcom/laiqian/main/di;
    //   55: aload_0
    //   56: getfield deletedOrder : Lcom/laiqian/pos/hold/PendingFullOrderDetail;
    //   59: ifnull -> 73
    //   62: aload_0
    //   63: getfield settlementRunnable : Lcom/laiqian/main/di;
    //   66: aload_0
    //   67: getfield deletedOrder : Lcom/laiqian/pos/hold/PendingFullOrderDetail;
    //   70: invokevirtual setDeletedPendingOrder : (Lcom/laiqian/pos/hold/PendingFullOrderDetail;)V
    //   73: aload_0
    //   74: invokespecial executeSettlementOfChainMember : ()V
    //   77: aload_0
    //   78: monitorexit
    //   79: return
    //   80: astore_1
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    // Exception table:
    //   from	to	target	type
    //   2	8	80	finally
    //   15	20	80	finally
    //   27	73	80	finally
    //   73	77	80	finally }
  
  private void settlement(boolean paramBoolean, b paramb) {
    if (!showScanCodeDialog(paramBoolean)) {
      boolean bool;
      String str;
      if (this.payTypeItemViewSelected.bpr) {
        str = this.etPaid.getText().toString();
        bool = this.payTypeItemViewSelected.aTv;
      } else if (str != null && str.bpr) {
        String str1 = this.etPaidOfSecond.getText().toString();
        bool = str.aTv;
        str = str1;
      } else {
        str = null;
        bool = false;
      } 
      if (str != null) {
        bd.bH(this.mActivity);
        this.scanCodeOrderNo = n.a(this.isSaleOrder, new Date());
        if (bool == '✗') {
          TextView textView;
          if (this.payTypeItemViewSelected.bpr) {
            textView = this.etPaid;
          } else if (getPaidOfSecond() != null && (getPaidOfSecond()).bpr) {
            textView = this.etPaidOfSecond;
          } else {
            return;
          } 
          showOnlinePayDialog(str, textView, false);
          return;
        } 
        if (bool == '✙') {
          TextView textView;
          if (this.payTypeItemViewSelected.bpr) {
            textView = this.etPaid;
          } else if (getPaidOfSecond() != null && (getPaidOfSecond()).bpr) {
            textView = this.etPaidOfSecond;
          } else {
            return;
          } 
          showOnlinePayDialog(str, textView, false);
          return;
        } 
        n.println("打印二维码的时候，不能判断是支付宝还是微信。这里不会进来");
        return;
      } 
      settlement(null);
    } 
  }
  
  private void settlementPreOnlineOrder(String paramString) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'PActivitySettlementD'
    //   4: ldc_w 'settlementPreOnlineOrder'
    //   7: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   10: pop
    //   11: new com/laiqian/models/be
    //   14: dup
    //   15: invokestatic zv : ()Lcom/laiqian/basic/RootApplication;
    //   18: invokespecial <init> : (Landroid/content/Context;)V
    //   21: astore_2
    //   22: aload_2
    //   23: aload_1
    //   24: invokestatic currentTimeMillis : ()J
    //   27: ldc2_w 120000
    //   30: lsub
    //   31: invokestatic currentTimeMillis : ()J
    //   34: invokevirtual d : (Ljava/lang/String;JJ)Lcom/laiqian/main/bb;
    //   37: astore_3
    //   38: aload_2
    //   39: invokevirtual close : ()V
    //   42: aload_3
    //   43: ifnonnull -> 49
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: new com/laiqian/main/di
    //   52: dup
    //   53: invokestatic zv : ()Lcom/laiqian/basic/RootApplication;
    //   56: aload_3
    //   57: iconst_0
    //   58: new com/laiqian/main/cf
    //   61: dup
    //   62: aload_0
    //   63: aload_1
    //   64: invokespecial <init> : (Lcom/laiqian/main/PosActivitySettlementDialog;Ljava/lang/String;)V
    //   67: invokespecial <init> : (Landroid/content/Context;Lcom/laiqian/main/bb;ZLcom/laiqian/main/di$a;)V
    //   70: astore_1
    //   71: invokestatic aKh : ()Lio/reactivex/m;
    //   74: aload_1
    //   75: invokevirtual r : (Ljava/lang/Runnable;)Lio/reactivex/a/b;
    //   78: pop
    //   79: aload_0
    //   80: monitorexit
    //   81: return
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    // Exception table:
    //   from	to	target	type
    //   2	42	82	finally
    //   49	79	82	finally }
  
  private void showAlertIfCouponAmoutBiggerThanPayableAmount() {
    r r1 = new r(this.mActivity, new bn(this));
    r1.setTitle(this.mActivity.getString(2131626722));
    r1.s(this.mActivity.getString(2131627336));
    r1.oZ(this.mActivity.getString(2131627337));
    r1.t(this.mActivity.getString(2131626715));
    r1.show();
  }
  
  private void showDeliveryCheckBox() {
    this.delivery_l.setVisibility(0);
    this.delivery_l.setEnabled(true);
    this.deliveryCheck.setEnabled(true);
  }
  
  private void showEvakoLayouts() {
    if (a.zR().Ab()) {
      showPrintCheckBox();
      this.tv_table_numbers.setVisibility(8);
      showOrderTypeLayout();
      showDeliveryCheckBox();
      if (getIsPhoneOrderType()) {
        this.bt_orderType.setText(2131628360);
        this.etTableNumbers.setEnabled(false);
        setIsDeliveryOrder(true);
        this.submitButton.setText(2131626896);
        this.bt_orderType.setClickable(false);
        if (this.isEditPhoneOrder) {
          this.deliveryCheck.setEnabled(false);
        } else {
          this.deliveryCheck.setChecked(true);
        } 
        if (this.isEditPhoneOrder)
          if (hasDeliveryman()) {
            this.pack_check.setChecked(true);
          } else {
            this.pack_check.setEnabled(false);
          }  
      } else if (this.posTableEntity == null) {
        String str;
        this.deliveryCheck.setChecked(false);
        this.submitButton.setText(2131626884);
        ArrayList arrayList = getOrderTypeEntities();
        TextView textView = this.bt_orderType;
        if (by.isNull(this.orderTypeID)) {
          str = this.defaultOrderTypeName;
        } else {
          str = fg.eW(this.orderTypeID);
        } 
        textView.setText(str);
        this.payMark = u.am(a.AZ().Co());
        this.bt_orderType.setOnClickListener(new bt(this, arrayList));
      } 
      this.kitchenPrintCheck.setChecked(true);
      this.receiptPrintCheck.setChecked(true);
    } 
  }
  
  private void showMergedPaidView() {
    setEtPaidPayableAmount();
    n.j(this.etPaid);
    if (this.selectPaidSecondDialogItems.size() > 0 && this.selectPaidSecondDialog != null) {
      b b = (b)this.selectPaidSecondDialogItems.get(0);
      this.tvPaidOfSecond.setText(b.AT());
      this.selectPaidSecondDialog.dn(b.AR());
      this.submitButton.setText(this.payTypeItemViewSelected.aTc);
    } 
  }
  
  private void showOnlineBarcodePayInDualPresentation(boolean paramBoolean) {
    if (this.dualPresentation != null) {
      if (this.payTypeItemViewSelected.aTe == 5L || (getPaidOfSecond() != null && (getPaidOfSecond()).aTx == 5L)) {
        this.dualPresentation.afP().fN(paramBoolean);
        return;
      } 
      if (this.payTypeItemViewSelected.aTe == 1L || (getPaidOfSecond() != null && (getPaidOfSecond()).aTx == 1L)) {
        this.dualPresentation.afP().fM(paramBoolean);
        return;
      } 
      if (!paramBoolean) {
        this.dualPresentation.afP().fM(paramBoolean);
        return;
      } 
    } 
  }
  
  private void showOnlinePayDialog(String paramString, TextView paramTextView, boolean paramBoolean) { throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n"); }
  
  private void showOrderTypeLayout() {
    this.bt_orderType.setVisibility(0);
    this.tv_order_up.setVisibility(0);
  }
  
  private void showOtherPayWindow(View paramView) {
    Rect rect = new Rect();
    paramView.getGlobalVisibleRect(rect);
    int i = rect.right;
    int j = rect.top;
    this.otherPayWindow.showAtLocation(paramView, 0, i + 5, j - 11);
  }
  
  private void showPackCheckBox() {
    byte b;
    View view = this.pack_l;
    if (a.AZ().Bk()) {
      b = 8;
    } else {
      b = 0;
    } 
    view.setVisibility(b);
    this.pack_check.setEnabled(true);
    this.pack_check.setChecked(false);
  }
  
  private void showPrintCheckBox() {
    this.kitchenPrint.setVisibility(0);
    this.receiptPrint.setVisibility(0);
  }
  
  private boolean showScanCodeDialog(boolean paramBoolean) {
    TextView textView;
    int i;
    resetPayTypeItemView(paramBoolean);
    if (isFirstPayTypeIsOnlinePayType()) {
      textView = this.etPaid;
      i = this.payTypeItemViewSelected.aTv;
    } else if (isSecondPayTypeIsOnlinePayType()) {
      textView = this.etPaidOfSecond;
      i = (getPaidOfSecond()).aTv;
    } else {
      return false;
    } 
    String str = textView.getText().toString().trim();
    double d1 = n.aU(str);
    if (d1 < 0.01D || d1 > 1.0E8D) {
      n.eP(2131626411);
      return true;
    } 
    this.scanCodeOrderNo = n.a(this.isSaleOrder, new Date());
    if (isOnlinePayType(i))
      showOnlinePayDialog(str, textView, paramBoolean); 
    return true;
  }
  
  private void showSecondPayName(@Nullable b paramb) {
    this.tvPaidOfSecond.setText(paramb.AT());
    if (this.selectPaidSecondDialog != null)
      this.selectPaidSecondDialog.dn(paramb.AR()); 
  }
  
  private void showSecondPayNameAsChange() { this.tvPaidOfSecond.setText(2131627280); }
  
  private void showTableNumber(String paramString, long paramLong, boolean paramBoolean) {
    this.etTableNumbers.setEnabled(true);
    if (RootApplication.getLaiqianPreferenceManager().isMultipleShop())
      this.etTableNumbers.setEnabled(RootApplication.getLaiqianPreferenceManager().avf()); 
    if (isTableOrder(paramString)) {
      this.etTableNumbers.setVisibility(0);
      this.tv_table_numbers.setText(this.mActivity.getString(2131626895));
      this.etTableNumbers.setText(String.valueOf(CrashApplication.getLaiqianPreferenceManager().avk()));
    } else {
      if (getIsPhoneOrderType()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("telephone.phone is:");
        stringBuilder.append(this.telephoneEntity.aTp);
        n.o(stringBuilder.toString());
        this.etTableNumbers.setText(this.telephoneEntity.aTp);
      } 
      if (isOpenTableOrScanOrderType(paramLong)) {
        this.etTableNumbers.setVisibility(8);
        b.a a1 = b.a(this.mActivity, null, Long.valueOf(Long.parseLong(paramString)), true, this.posTableEntity.Yg().Ym());
        if (this.posTableEntity != null && this.posTableEntity.Yg().Yl() != 0) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(a1.bZc);
          stringBuilder1.append("-");
          stringBuilder1.append(a1.bTe);
          stringBuilder1.append(".");
          stringBuilder1.append(getContext().getString(2131626009));
          stringBuilder1.append(this.posTableEntity.Yg().Yl());
          this.openTableName = stringBuilder1.toString();
        } else {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(a1.bZc);
          stringBuilder1.append("-");
          stringBuilder1.append(a1.bTe);
          this.openTableName = stringBuilder1.toString();
        } 
        TextView textView = this.tv_table_numbers;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mActivity.getString(2131628305));
        stringBuilder.append("  ");
        stringBuilder.append(this.openTableName);
        textView.setText(stringBuilder.toString());
      } else {
        this.pack_check.setChecked(paramBoolean);
        this.etTableNumbers.setVisibility(0);
        this.tv_table_numbers.setText(this.mActivity.getString(2131626895));
        this.etTableNumbers.setText(String.valueOf(paramString));
      } 
    } 
    toggleTableNumberEditText(paramString);
  }
  
  private void showVIP() {
    this.vip_info_l.setVisibility(0);
    this.vip_info_name.setText(this.vipEntity.name);
    this.vip_info_phone.setText(by.G(this.vipEntity.aTp, 999));
    this.vip_info_points.setText(String.valueOf(this.vipEntity.aWp));
    this.vip_info_balance.setText(n.b(null, Double.valueOf(this.vipEntity.aWo), true, true));
  }
  
  private void showVipBalanceInsufficientDialog() { addRunnableAfterShowDialog(new cb(this)); }
  
  private void showVipBalanceInsufficientDialogIfNecessary() {
    String str = getActualAmountByDiscount(getDiscountNoVip());
    if (this.vipEntity != null) {
      if (!isNeedSetDiscountAfterVIPSelected())
        this.etActual.setText(str); 
      if (a.zR().Ab() && this.telephoneEntity != null) {
        selectedCashView(str);
      } else {
        selectedVipTypeView();
      } 
      calculationPointsDeductionAmount();
      this.startShowingAmount = this.etActual.getText().toString().trim();
    } else {
      selectedCashView(str);
      this.startShowingAmount = this.etActual.getText().toString().trim();
    } 
    setFocusOnTableNumberEditTextOrPaidEditText();
  }
  
  private void showVipRechargeButton() { this.rechargeButton.setVisibility(0); }
  
  private void showWIFINecessaryDialog() {
    if (this.mWiFiDialog == null) {
      this.mWiFiDialog = new bc(this.activity);
      this.mWiFiDialog.setCancelable(false);
      this.mWiFiDialog.s(getContext().getString(2131630409));
    } 
    this.mWiFiDialog.show();
  }
  
  private void toggleDiscountAndActualAmountValueAndEditStatus() {
    setDiscountIsEditable();
    setDiscountTextViewValue(getDiscountNoVip());
    selectedCashView("0");
    this.startShowingAmount = this.etActual.getText().toString().trim();
    if ((this.posActivitySettlementPresenter.Po()).aEq && (this.posActivitySettlementPresenter.Po()).aEs == 1 && a.AZ().Bn() <= (this.posActivitySettlementPresenter.Po()).aEt)
      setCanEditDiscountActual(false); 
  }
  
  private void toggleTableNumberEditText(String paramString) {
    if (paramString != null) {
      if ("".equals(paramString))
        return; 
      this.etTableNumbers.setText(String.valueOf(paramString));
      byte b2 = 0;
      byte b1 = 0;
      while (true) {
        if (b1 < paramString.length()) {
          if (!Character.isDigit(paramString.charAt(b1))) {
            b1 = b2;
            break;
          } 
          b1++;
          continue;
        } 
        b1 = 1;
        break;
      } 
      if (b1 == 0) {
        this.etTableNumbers.setVisibility(4);
        TextView textView = this.tv_table_numbers;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mActivity.getString(2131626895));
        stringBuilder.append("  ");
        stringBuilder.append(paramString);
        textView.setText(stringBuilder.toString());
      } 
      return;
    } 
  }
  
  private void toggleVipPointSetting() { calculationPayableActualAndSet(); }
  
  private void updateChangeOrPaidSecond(double paramDouble) {
    if (paramDouble == 0.0D || (isUseChainMember() && !CrashApplication.getLaiqianPreferenceManager().avV())) {
      this.paidOfSecond.setVisibility(8);
    } else {
      this.paidOfSecond.setVisibility(0);
      this.etPaidOfSecond.setText(n.ba(paramDouble));
    } 
    if (this.dualPresentation != null) {
      if (getPaidOfSecond() == null) {
        this.dualPresentation.ae(paramDouble);
        return;
      } 
      this.dualPresentation.ae(0.0D);
    } 
  }
  
  private void updateSumAmount() {
    this.sumAmountContainTaxOfAddPrice = 0.0D;
    this.sumAmountUnDiscount = 0.0D;
    for (aa aa : this.productData) {
      if (this.isSaleOrder) {
        d1 = aa.j((new dq(this.mActivity)).gp(true));
      } else {
        d1 = 0.0D;
      } 
      double d1 = aa.GJ() + d1;
      if (aa.Gv())
        this.sumAmountUnDiscount += d1; 
      this.sumAmountContainTaxOfAddPrice += d1;
    } 
  }
  
  private void verificationGroupFirst() { getGroupDialog().aa(n.u(this.mAfterNeglectSmallChangesAmount)); }
  
  public void clearOrderType() {
    this.orderTypeEntities = null;
    this.defaultOrderTypeName = null;
  }
  
  public void closeModel() {
    if (this.accountTableModel != null)
      this.accountTableModel.close(); 
  }
  
  public void connectDualScreen(o paramo) {
    this.dualPresentation = paramo;
    this.dualPresentation.aF(getDualScreenDeductionAmount());
    try {
      this.dualPresentation.aG(Double.parseDouble(this.etActual.getText().toString()));
      this.dualPresentation.p(Double.parseDouble(this.etDiscount.getText().toString()));
      return;
    } catch (Exception paramo) {
      a.e(paramo);
      return;
    } 
  }
  
  public void disconnectDualScreen() { this.dualPresentation = null; }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    boolean bool;
    char c1 = paramKeyEvent.getNumber();
    long l = System.currentTimeMillis();
    if (l - this.keyTime < 80L) {
      bool = true;
    } else {
      bool = false;
    } 
    this.keyTime = l;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(String.format("action: %d,keyCode: %d，scanCode: %d ", new Object[] { Integer.valueOf(paramKeyEvent.getAction()), Integer.valueOf(paramKeyEvent.getKeyCode()), Integer.valueOf(paramKeyEvent.getScanCode()) }));
    stringBuilder.append(" ");
    stringBuilder.append(bool);
    Log.d("键盘按钮", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(l);
    stringBuilder.append("");
    Log.e("time", stringBuilder.toString());
    if (c1 >= '0' && c1 <= '9') {
      View view = getCurrentFocus();
      if (view != null && view instanceof EditText) {
        EditText editText = (EditText)view;
        if ("0".equals(editText.getText().toString())) {
          editText.setText(String.valueOf(c1));
          editText.setSelection(1);
          return true;
        } 
      } 
    } 
    if (n.lt(paramKeyEvent.getKeyCode())) {
      if (paramKeyEvent.getAction() == 1) {
        if (isVerificationGroup() && this.groupDialog != null)
          this.groupDialog.LL(); 
        if (canOperate() && !bool)
          n.performClick(this.submitButton); 
      } 
      return true;
    } 
    if (paramKeyEvent.getAction() == 0 && paramKeyEvent.getKeyCode() == 137)
      setPayTypeItemViewSelected(10007); 
    if (paramKeyEvent.getAction() == 0 && paramKeyEvent.getKeyCode() == 138)
      setPayTypeItemViewSelected(10009); 
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public long getAliPay(long paramLong) { return (paramLong == 2L && a.AZ().Bo() == 2) ? this.DEFAULT_ONLINE_PAY_TYPE : a.AZ().Bo(); }
  
  @Subscribe(aYx = ThreadMode.MAIN)
  public void getCurrentVipChargeInfo(a parama) { this.vipEntity = bl.b((new l(this.activity)).bk(this.vipEntity.aSW)); }
  
  public ArrayList<String> getOrderTypeEntities() {
    if (this.orderTypeEntities == null) {
      f f1 = new f(getContext());
      this.orderTypeEntities = f1.acO();
      this.defaultOrderTypeName = f1.cw(a.AZ().Co());
      f1.close();
    } 
    return u.i(this.orderTypeEntities);
  }
  
  public String getOrderTypeID() { return this.orderTypeID; }
  
  public aq getVipEntity() { return this.vipEntity; }
  
  public long getWechat(long paramLong) { return (paramLong == 7L && a.AZ().Bq() == 7) ? this.DEFAULT_ONLINE_PAY_TYPE : a.AZ().Bq(); }
  
  public void onBackPressed() {
    if (canOperate())
      if (isVerificationGroup()) {
        if (this.groupDialog != null) {
          this.groupDialog.LL();
          return;
        } 
      } else {
        super.onBackPressed();
      }  
  }
  
  public void onChangeDecimalPoint() {
    this.etDiscount.setFilters(ar.lw(99));
    this.etActual.setFilters(new InputFilter[] { ar.lw(99)[0], new e(true, 2, this.isAmountRounding, isShowPointsDeductionView()) });
    this.etPaid.setFilters(new InputFilter[] { ar.lw(99)[0], new e(false, 2, this.isAmountRounding, isShowPointsDeductionView()) });
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("结算界面设置了小数点位数：");
    stringBuilder.append(CrashApplication.aIQ);
    n.println(stringBuilder.toString());
  }
  
  protected void onStart() {
    super.onStart();
    if (this.etPayableAmount != null)
      this.etPayableAmount.postDelayed(new cp(this), 100L); 
    setHasPointsDeduction();
    setHasTableNumber();
    o o1 = o.afM();
    if (o1 != null)
      connectDualScreen(o1); 
  }
  
  protected void onStop() {
    super.onStop();
    disconnectDualScreen();
  }
  
  public void resetFirstPayTypeItemView(long paramLong) {
    if (this.payTypeItemViewSelected.aTv == 10007) {
      long l = paramLong;
      if (paramLong < 0L) {
        paramLong = getAliPay(this.payTypeItemViewSelected.aTe);
        l = paramLong;
        if (paramLong < 0L)
          return; 
      } 
      resetFirstPayTypeItem(l);
      return;
    } 
    if (this.payTypeItemViewSelected.aTv == 10009) {
      long l = paramLong;
      if (paramLong < 0L) {
        paramLong = getWechat(this.payTypeItemViewSelected.aTe);
        l = paramLong;
        if (paramLong < 0L)
          return; 
      } 
      resetFirstPayTypeItem(l);
    } 
  }
  
  public void resetNeglectSamllChangesVisibility() {
    if (a.AZ().CC()) {
      this.mRoundChanges.setVisibility(0);
      this.mRulePair = getNeglectSmallChangesRule();
      setNeglectSmallChanges(this.etPayableAmount.getText().toString().trim());
      return;
    } 
    this.mRoundChanges.setVisibility(8);
    showAfterPayableAmountChanged(this.etPayableAmount.getText().toString().trim());
  }
  
  public void resetSecondPayTypeItemView(long paramLong) {
    try {
      b b = (b)this.paidOfSecond.getTag();
      if (b != null) {
        int i = b.aTv;
        byte b2 = 0;
        byte b1 = 0;
        if (i == 10007) {
          long l = paramLong;
          if (paramLong < 0L) {
            paramLong = getAliPay(b.aTx);
            l = paramLong;
            if (paramLong < 0L)
              return; 
          } 
          b = (b)this.paidOfSecond.getTag();
          if (l == 1L) {
            b3 = 1;
          } else {
            b3 = 0;
          } 
          b.bpq = b3;
          byte b3 = b1;
          if (l == 0L)
            b3 = 1; 
          b.bpr = b3;
          b.aTx = l;
          return;
        } 
        if (b.aTv == 10009) {
          long l = paramLong;
          if (paramLong < 0L) {
            paramLong = getWechat(b.aTx);
            l = paramLong;
            if (paramLong < 0L)
              return; 
          } 
          b = (b)this.paidOfSecond.getTag();
          if (l == 5L) {
            b3 = 1;
          } else {
            b3 = 0;
          } 
          b.bpq = b3;
          byte b3 = b2;
          if (l == 8L)
            b3 = 1; 
          b.bpr = b3;
          b.aTx = l;
          return;
        } 
      } 
    } catch (Exception exception) {
      a.e(exception);
    } 
  }
  
  public void selectedCashView(String paramString) {
    this.etActual.setText(paramString);
    changePayType(10001, true);
    setDiscountAndAmoutForVIP();
    this.etPaid.setText(getActualAmountByDiscount(getDiscountValue()));
  }
  
  public void setCanOperate(boolean paramBoolean) {
    byte b;
    View view = this.notOperableView;
    if (paramBoolean) {
      b = 8;
    } else {
      b = 0;
    } 
    view.setVisibility(b);
  }
  
  public void setDeletedPendingOrder(PendingFullOrderDetail paramPendingFullOrderDetail) { this.deletedOrder = paramPendingFullOrderDetail; }
  
  public void setDiscountAndAmoutForVIP() {
    if (isNeedSetDiscountAfterVIPSelected()) {
      boolean bool = this.etDiscount.requestFocus();
      setDiscountTextViewValue(getVipDiscount());
      setEtActualTextViewValue(bool);
    } 
  }
  
  public void setHasPointsDeduction() {
    this.hasPointsDeduction = a.AZ().BB();
    refreshPointsDeductionView();
    calculationPointsDeductionAmount();
  }
  
  void setHasTableNumber() {
    byte b;
    View view = this.lTableNumbers;
    if (a.AZ().Bc() || a.AZ().Bk()) {
      b = 0;
    } else {
      b = 8;
    } 
    view.setVisibility(b);
  }
  
  public void setIsDeliveryOrder(boolean paramBoolean) { this.posActivitySettlementPresenter.dD(paramBoolean); }
  
  public void setIsOpenMemberPrice(boolean paramBoolean) { this.isOpenMemberPrice = paramBoolean; }
  
  public void setIsSaleOrder(boolean paramBoolean) {
    boolean bool;
    if (paramBoolean) {
      this.tvActual.setText(2131627268);
    } else {
      this.tvActual.setText(2131629478);
    } 
    if (this.isSaleOrder != paramBoolean) {
      bool = true;
    } else {
      bool = false;
    } 
    this.isSaleOrder = paramBoolean;
    if (bool) {
      refreshPointsDeductionView();
      setPayTypeItemView();
    } 
  }
  
  public void setOrderTypeID(String paramString) { this.orderTypeID = paramString; }
  
  public void setPayTypeCash() {
    setPayTypeItemViewSelected(10001);
    changePaidSecond(null, false);
    setFastAmount(n.aU(this.mAfterNeglectSmallChangesAmount));
    setPaidCanEdit(true);
    hideVipRechargeButton();
  }
  
  public void setPayTypeItemView() {
    null = new v.a(this.activity, this.isSaleOrder);
    ArrayList arrayList1 = new ArrayList();
    safeAddListItem(arrayList1, null.Gb());
    safeAddListItem(arrayList1, null.Gc());
    if (a.zR().At()) {
      safeAddListItem(arrayList1, null.Gd());
    } else {
      safeAddListItem(arrayList1, null.Ge());
      safeAddListItem(arrayList1, null.Gf());
    } 
    safeAddListItem(arrayList1, null.Gg());
    safeAddListItem(arrayList1, null.Gh());
    safeAddListItem(arrayList1, null.Gi());
    safeAddListItem(arrayList1, null.Gj());
    this.payTypeOther.clear();
    this.selectPaidSecondDialogItems.clear();
    bu bu = new bu(new a());
    f f1 = this.accountTableModel;
    int j = 0;
    ArrayList arrayList2 = f1.o(true, false);
    this.payTypeOther.addAll(arrayList2);
    int i = ((c)this.payTypeItemViewList.get(0)).aTv;
    int m = arrayList1.size() + this.payTypeOther.size();
    while (j < arrayList1.size()) {
      bu.rY(getClass().getSimpleName());
      int i2 = j + true;
      int i1 = j;
      if (m >= 9) {
        i1 = j;
        if (i2 >= 8)
          i1 = this.payTypeItemViewList.size() - 1; 
      } 
      v v = (v)arrayList1.get(i1);
      c c1 = (c)this.payTypeItemViewList.get(i1);
      if (m >= 9 && i2 >= 8) {
        this.payTypeOther.add(v);
      } else {
        if (v.aSX == 10001)
          this.payTypeItemViewSelected = c1; 
        j = v.aSX;
        if (j != 10001) {
          switch (j) {
            default:
              switch (j) {
                default:
                  break;
                case 10013:
                  c1.a(v.aTa, v.name, v.aSW);
                  break;
                case 10014:
                  break;
              } 
            case 10009:
              j = i;
              if (this.payTypeItemViewSelected != null) {
                j = i;
                if (this.payTypeItemViewSelected.aTv == c1.aTv)
                  j = c1.aTv; 
              } 
              setPayTypeWechat(c1, true);
              c1.a(v.aSX, v.aTb, v.name, v.aTe, v.aTc, v.aTd);
              i = j;
              break;
            case 10007:
              j = i;
              if (this.payTypeItemViewSelected != null) {
                j = i;
                if (this.payTypeItemViewSelected.aTv == c1.aTv)
                  j = c1.aTv; 
              } 
              setPayTypeAlipay(c1, true);
              c1.a(v.aSX, v.aTb, v.name, v.aTe, v.aTc, v.aTd);
              i = j;
              break;
            case 10006:
            case 10008:
            case 10010:
            case 10011:
              c1.a(v.aSX, v.aTb, v.name, 0L, v.aTc, v.aTd);
              break;
          } 
          switch (v.aSX) {
            default:
              this.selectPaidSecondDialogItems.add(obtainPayTypeItemByPayTypeItemView(c1, 0.0D));
              break;
            case 10006:
            case 10007:
            case 10009:
            case 10013:
            case 10014:
              break;
          } 
          c1.Pm();
          bu.rZ(getClass().getSimpleName());
        } else {
        
        } 
      } 
      j = i2;
    } 
    int k = j;
    if (this.isSaleOrder) {
      k = j;
      if (this.payTypeOther.size() > 0) {
        if (j == this.payTypeItemViewList.size()) {
          k = this.payTypeItemViewList.size() - 1;
        } else {
          k = j;
        } 
        this.otherPayTypeItemView = (c)this.payTypeItemViewList.get(k);
        if (this.payTypeOther.size() > 1) {
          this.otherPayTypeItemView.setOnClickListener(new by(this));
        } else {
          this.otherPayTypeItemView.Pm();
        } 
        for (v v : this.payTypeOther)
          this.selectPaidSecondDialogItems.add(obtainPayTypeItemByPayTypeEntity(v)); 
        selectedOtherPayTypeValueInitial();
        setOtherPayViewGroupChild();
        k = j;
        if (j != this.payTypeItemViewList.size())
          k = j + 1; 
      } 
    } 
    for (j = k; j < this.payTypeItemViewList.size(); j++) {
      byte b = 4;
      if (k > 4) {
        ((c)this.payTypeItemViewList.get(j)).view.setVisibility(4);
      } else {
        View view = ((c)this.payTypeItemViewList.get(j)).view;
        if (j >= 4)
          b = 8; 
        view.setVisibility(b);
      } 
    } 
    n.println("这里是结算界面，设置了支付类型View");
    if (isShowing()) {
      n.println("结算界面显示的时候，重新选中了选中项");
      changePayType(i, true);
    } 
  }
  
  public void setPayTypeNotCash(int paramInt, boolean paramBoolean) {
    setPayTypeItemViewSelected(paramInt);
    setFastAmount(0.0D);
    changePaidSecond((b)this.selectPaidSecondDialogItems.get(0), false);
    if (paramBoolean)
      showScanCodeDialog(false); 
    hideVipRechargeButton();
  }
  
  public void setProductData(ArrayList<aa> paramArrayList) { this.productData = paramArrayList; }
  
  public void setTelephoneEntity(c paramc, boolean paramBoolean, PendingFullOrderDetail.a parama, String paramString) {
    setVipEntity(paramc);
    this.orderTypeID = paramString;
    this.telephoneEntity = paramc;
    this.isEditPhoneOrder = paramBoolean;
    this.phoneHeader = parama;
  }
  
  public void setVipEntity(@Nullable aq paramaq) { this.posActivitySettlementPresenter.j(paramaq); }
  
  @Deprecated
  public void show() { super.show(); }
  
  public void show(String paramString, long paramLong, TableEntity paramTableEntity, boolean paramBoolean) {
    this.payMark = paramLong;
    this.posTableEntity = paramTableEntity;
    this.isAmountRounding = a.AZ().BK();
    this.amountRounding = 0.0D;
    this.isShowCreditTooMuchDialog = false;
    this.settlementRunnable = null;
    updateSumAmount();
    prepareWholePage(paramString, paramLong, paramBoolean);
    super.show();
    showVipBalanceInsufficientDialogIfNecessary();
    resetNeglectSamllChangesVisibility();
    registerEtPayableAmount();
  }
  
  public void showAfterActualAmountChanged(String paramString) {
    double d1 = getValueByString(paramString);
    if (getCurrentFocus() == this.etActual) {
      n.println("修改折后金额后，再修改折扣");
      setDiscountTextViewValue(getDiscountByActualAmount(d1));
      this.amountRounding = 0.0D;
    } 
    calculationPayableActualAndSet();
    setPointsDeductionTextView(d1);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("这里是设置了折后应收：");
    stringBuilder.append(paramString);
    n.println(stringBuilder.toString());
  }
  
  public void showAfterDiscountChanged(String paramString) {
    double d1 = getValueByString(paramString);
    if (getCurrentFocus() == this.etDiscount) {
      double d2;
      EditText editText = this.etDiscount;
      if (this.isDiscountConvertion) {
        d2 = 100.0D - d1;
      } else {
        d2 = d1;
      } 
      editText.setTag(Double.valueOf(d2));
      n.println("修改折后后，再修改折后金额");
      this.etActual.setText(getActualAmountByDiscount(getDiscountValue()));
    } 
    if (this.dualPresentation != null) {
      this.dualPresentation.p(d1);
      this.dualPresentation.aH(this.sumAmountContainTaxOfAddPrice - calculationActualAmountByDiscount(getDiscountValue()));
    } 
  }
  
  public void showAfterFirstPayTypeChanged() {}
  
  public void showAfterPaidChanged(String paramString) {
    int i = this.payTypeItemViewSelected.aTv;
    if (i != 10001) {
      if (i != 10013) {
        boolean bool;
        double d7;
        double d6;
        double d5;
        switch (i) {
          default:
            return;
          case 10007:
          case 10009:
            d5 = n.aU(this.etPaid.getText());
            d6 = n.aU(this.mAfterNeglectSmallChangesAmount);
            if (d6 == d5) {
              updateChangeOrPaidSecond(0.0D);
              return;
            } 
            if (d6 > d5) {
              updateChangeOrPaidSecond(d6 - d5);
              return;
            } 
            setEtPaidPayableAmount();
            n.j(this.etPaid);
            bool = this.isSaleOrder;
            i = 2131629624;
            if (bool) {
              if (this.payTypeItemViewSelected.aTv != 10007)
                i = 2131629631; 
              n.eP(i);
              return;
            } 
            if (this.payTypeItemViewSelected.aTv != 10007)
              i = 2131629632; 
            n.eP(i);
            return;
          case 10006:
            if (this.vipEntity == null)
              return; 
            d7 = n.aU(this.etPaid.getText());
            paramString = n.ba(this.vipEntity.aWo);
            d6 = n.aU(paramString);
            d5 = d6;
            if (CrashApplication.getLaiqianPreferenceManager().avZ()) {
              d5 = d6 - CrashApplication.getLaiqianPreferenceManager().avY();
              paramString = n.ba(d5);
            } 
            if (this.isSaleOrder && !a.AZ().Bu() && d7 - d5 > 1.0E-6D) {
              if (d5 <= 0.0D) {
                paramString = n.ba(0.0D);
                if (!paramString.equals(this.etPaid.getText().toString()))
                  this.etPaid.setText(paramString); 
                updateChangeOrPaidSecond(n.e(new Object[] { this.mAfterNeglectSmallChangesAmount }));
                return;
              } 
              this.etPaid.setText(paramString);
              return;
            } 
            d6 = n.aU(this.mAfterNeglectSmallChangesAmount);
            if (d6 == d7) {
              updateChangeOrPaidSecond(0.0D);
            } else if (d6 > d7) {
              updateChangeOrPaidSecond(d6 - d7);
            } else {
              setEtPaidPayableAmount();
              n.j(this.etPaid);
              if (this.isSaleOrder) {
                n.eP(2131626374);
              } else {
                n.eP(2131626375);
              } 
            } 
            if (!this.isShowCreditTooMuchDialog && a.AZ().Bu()) {
              d6 = a.AZ().Bv();
              if (d6 >= 0.0D && d7 - d5 > d6) {
                this.isShowCreditTooMuchDialog = true;
                addRunnableAfterShowDialog(new bv(this));
                return;
              } 
            } 
            return;
          case 10008:
          case 10010:
          case 10011:
            break;
        } 
      } 
      double d4 = n.e(new Object[] { this.mAfterNeglectSmallChangesAmount, this.etPaid.getText() });
      double d3 = d4;
      if (d4 < 0.0D)
        d3 = 0.0D; 
      updateChangeOrPaidSecond(d3);
      return;
    } 
    double d2 = n.e(new Object[] { this.etPaid.getText(), this.mAfterNeglectSmallChangesAmount });
    double d1 = d2;
    if (d2 < 0.0D)
      d1 = 0.0D; 
    updateChangeOrPaidSecond(d1);
  }
  
  public void showAfterPayableAmountChanged(String paramString) {
    if (this.payTypeItemViewSelected.aTv == 10014)
      return; 
    this.mAfterNeglectSmallChangesAmount = paramString;
    double d1 = getValueByString(this.mAfterNeglectSmallChangesAmount);
    if (this.payTypeItemViewSelected.aTv == 10001)
      setFastAmount(d1); 
    paramString = n.ba(d1);
    this.etPaid.setText(paramString);
    if (getCurrentFocus() == this.etPaid)
      n.j(this.etPaid); 
    b.ckg.c(Double.valueOf(Double.parseDouble(paramString)));
    if (a.AZ().BE())
      c.MD().ag(Double.parseDouble(paramString)); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("这里是设置了积分抵扣金额：");
    stringBuilder.append(this.mAfterNeglectSmallChangesAmount);
    n.println(stringBuilder.toString());
  }
  
  public void showAfterSecondPayTypeChanged(b paramb, boolean paramBoolean) {
    if (paramb == null) {
      showSecondPayNameAsChange();
      return;
    } 
    if (mergeFirstPayAndSecondPay(paramb))
      return; 
    showSecondPayName(paramb);
    if (isNotOnlinePayType()) {
      if (!getIsPhoneOrderType() && this.submitButton.getTag() == null)
        this.submitButton.setText(paramb.aTc); 
      showScanCodeDialog(paramBoolean);
    } 
  }
  
  public void showAfterSecondPayTypeClicked(View paramView) {
    if (this.paidOfSecond.getTag() == null)
      return; 
    if (this.selectPaidSecondDialog == null) {
      if (!(this.mActivity instanceof ActivityRoot)) {
        n.o("传入的Context必须是ActivityRoot类型");
        return;
      } 
      this.selectPaidSecondDialog = new g((ActivityRoot)this.mActivity, this.selectPaidSecondDialogItems, new bw(this));
      if (this.selectPaidSecondDialogItems.size() > 0)
        this.selectPaidSecondDialog.dn(((b)this.selectPaidSecondDialogItems.get(0)).AR()); 
    } 
    this.selectPaidSecondDialog.show();
  }
  
  public void showAfterVipRechargeButtonClicked(View paramView) {
    n n1;
    if (this.vipEntity == null) {
      n.println("结算界面，给会员充值时，会员为null。这里不会进来");
      return;
    } 
    if (RootApplication.getLaiqianPreferenceManager().avs() == 1 && RootApplication.getLaiqianPreferenceManager().avr() == 1 && RootApplication.getLaiqianPreferenceManager().QV() == 1) {
      n.eP(2131625990);
      return;
    } 
    if (CrashApplication.getLaiqianPreferenceManager().Wq()) {
      n1 = new o(this.activity, this.activity);
    } else {
      n1 = new n(this.activity, this.activity);
    } 
    n1.a(new bx(this));
    n1.n(this.vipEntity);
    n1.show();
  }
  
  public void showAfterVipSelected(@Nullable aq paramaq) {
    boolean bool;
    if ((this.vipEntity != null && paramaq == null) || (this.vipEntity == null && paramaq != null)) {
      bool = true;
    } else {
      bool = false;
    } 
    this.vipEntity = paramaq;
    n.println("这里是结算界面设置了会员信息");
    refreshPointsDeductionView();
    setAmountValue(bool, false);
    if (paramaq == null) {
      this.vip_info_l.setVisibility(8);
      if (this.payTypeItemViewSelected.aTv == 10006)
        changePayType(10001, true); 
      if (isMultipleShop()) {
        setCanEditDiscountActual(true);
        this.pay_type_setting_l.setVisibility(0);
        this.pay_type_body1.setVisibility(0);
        this.pay_type_body2.setVisibility(0);
      } 
    } else {
      showVIP();
      if (isMultipleShop() && !CrashApplication.getLaiqianPreferenceManager().avV()) {
        setCanEditDiscountActual(false);
        this.pay_type_setting_l.setVisibility(8);
        this.pay_type_body1.setVisibility(8);
        this.pay_type_body2.setVisibility(8);
      } 
      if (isShowing()) {
        selectedVipTypeView();
        calculationPointsDeductionAmount();
      } 
    } 
    String str = RootApplication.getLaiqianPreferenceManager().atp();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(cj.aGy);
    if (str.equals(stringBuilder.toString())) {
      if (paramaq != null && !(this.posActivitySettlementPresenter.Po()).aEr) {
        setEtActualAndEtDiscountEnable(false);
        return;
      } 
      if ((this.posActivitySettlementPresenter.Po()).aEq && (this.posActivitySettlementPresenter.Po()).aEs == 1 && paramaq != null && (this.posActivitySettlementPresenter.Po()).aEt >= paramaq.discount) {
        setEtActualAndEtDiscountEnable(false);
        return;
      } 
      setEtActualAndEtDiscountEnable(true);
    } 
  }
  
  public void showAlipayFailed() {}
  
  public void showAlipaySuccess() {}
  
  public void showFirstPayCouponButtonClicked() { getGroupDialog().LG(); }
  
  public void showIfFirstPayTypeWasOthersPay() {}
  
  public void showIfOpenTableMode() {}
  
  public void showIfPendingOrderMode() {}
  
  public void showIfPhoneOrderMode() {}
  
  public void showIfSalesReturn() {}
  
  public void showMonitorPayDialog(HashMap<String, Object> paramHashMap) {}
  
  public void showOrderTypeChanged() {}
  
  public void showPaidWasChanged() {}
  
  public void showScanCodeDialog() {}
  
  public void showSettlementFailed() {}
  
  public void showSettlementSuccess() {}
  
  public void showWechartPayFailed() {}
  
  public void showWechatPaySuccess() {}
  
  public void toggleBarcodeProgress(int paramInt) { this.vPreProgress.setVisibility(paramInt); }
  
  private class a extends BaseAdapter {
    private List<Pair<Integer, String>> list;
    
    private Context mContext;
    
    public a(PosActivitySettlementDialog this$0, Context param1Context) {
      this.mContext = param1Context;
      this.list = new ArrayList();
      arrayOfString = this.mContext.getResources().getStringArray(2130903061);
      this.list.add(new Pair(Integer.valueOf(-1), arrayOfString[0]));
      try {
        k.Fb();
        this.list.add(new Pair(Integer.valueOf(0), arrayOfString[1]));
        this.list.add(new Pair(Integer.valueOf(1), arrayOfString[2]));
        this.list.add(new Pair(Integer.valueOf(2), arrayOfString[3]));
        this.list.add(new Pair(Integer.valueOf(3), arrayOfString[4]));
        return;
      } catch (JSONException arrayOfString) {
        a.e(arrayOfString);
        return;
      } 
    }
    
    public Pair<Integer, String> eO(int param1Int) { return (Pair)this.list.get(param1Int); }
    
    public int getCount() { return this.list.size(); }
    
    public long getItemId(int param1Int) { return 0L; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      TextView textView = new TextView(this.mContext);
      textView.setBackgroundResource(2131231834);
      textView.setTextSize(16.0F);
      textView.setTextColor(Color.argb(255, 61, 61, 61));
      textView.setText((CharSequence)(eO(param1Int)).second);
      textView.setTag((eO(param1Int)).first);
      if (this.bcy.mRulePair.first == (eO(param1Int)).first)
        textView.setSelected(true); 
      if (param1Int == 0) {
        textView.setPadding(10, 10, 10, 5);
        return textView;
      } 
      if (param1Int == this.list.size() - 1) {
        textView.setPadding(10, 5, 10, 10);
        return textView;
      } 
      textView.setPadding(10, 5, 10, 5);
      return textView;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\PosActivitySettlementDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */