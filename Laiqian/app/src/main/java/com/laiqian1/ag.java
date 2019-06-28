package com.laiqian;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.google.zxing.WriterException;
import com.laiqian.alipay.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.entity.n;
import com.laiqian.payment.R;
import com.laiqian.pos.industry.a;
import com.laiqian.print.c.l;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.model.e;
import com.laiqian.print.model.g;
import com.laiqian.print.usage.receipt.model.c;
import com.laiqian.ui.a.bc;
import com.laiqian.ui.a.d;
import com.laiqian.ui.a.r;
import com.laiqian.ui.edittext.a;
import com.laiqian.util.al;
import com.laiqian.util.av;
import com.laiqian.util.by;
import com.laiqian.util.n;
import com.zhuge.analysis.b.a;
import io.reactivex.h.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class ag extends d implements n {
  private Activity aAA;
  
  private long aAB;
  
  String aAC = null;
  
  private bj aAD;
  
  FrameLayout aAE;
  
  private AtomicBoolean aAF = new AtomicBoolean(false);
  
  private AtomicBoolean aAG = new AtomicBoolean(false);
  
  private AtomicBoolean aAH = new AtomicBoolean(false);
  
  private long aAI;
  
  a aAJ;
  
  String aAK;
  
  String aAL;
  
  SpannableString aAM;
  
  ArrayList<PrintContent> aAN;
  
  Bitmap aAO = null;
  
  private k aAQ;
  
  boolean aAR;
  
  private LinearLayout aAS;
  
  View.OnClickListener aAT = new aq(this);
  
  View.OnClickListener aAU = new au(this);
  
  View.OnClickListener aAV = new aw(this);
  
  View.OnClickListener aAW = new aj(this);
  
  View.OnClickListener aAX = new ak(this);
  
  TextView aAY;
  
  boolean aAZ;
  
  public a<Object> aAq = a.aKk();
  
  RelativeLayout aAr;
  
  TextView aAs;
  
  RelativeLayout aAt;
  
  LinearLayout aAu;
  
  RelativeLayout aAv;
  
  Button aAw;
  
  Button aAx;
  
  View aAy;
  
  TextView aAz;
  
  LinearLayout aBe;
  
  RelativeLayout aBf;
  
  RelativeLayout aBg;
  
  RelativeLayout aBh;
  
  View aBi;
  
  TextView aBj;
  
  View aBk;
  
  TextView aBl;
  
  TextView aBm;
  
  View aBn;
  
  View.OnClickListener aBo = new al(this);
  
  View.OnClickListener aBp = new av(this);
  
  private a aBt;
  
  LinearLayout azp;
  
  LinearLayout azq;
  
  LinearLayout azr;
  
  private a mScanGunKeyEventHelper;
  
  private n onlinePayEntity;
  
  Handler scanCodeHandle = new ai(this);
  
  public ag(Activity paramActivity, n paramn, a parama) {
    super(paramActivity, R.layout.dialog_online_pay);
    this.aAA = paramActivity;
    this.onlinePayEntity = paramn;
    this.aBt = parama;
    this.aAJ = new a();
    wR();
    setListeners();
    setCancelable(false);
    this.mScanGunKeyEventHelper = new a(new ap(this));
  }
  
  private boolean bi(String paramString) {
    Log.e("isSameOrderNo", this.onlinePayEntity.xq());
    Log.e("isSameOrderNo", this.aBt.xq());
    return (this.aBt != null && this.onlinePayEntity != null && this.onlinePayEntity.xq() != null && this.onlinePayEntity.xq().equals(paramString) && this.onlinePayEntity.xq().equals(this.aBt.xq()));
  }
  
  private boolean bj(String paramString) {
    if (this.onlinePayEntity.Fm() != null && n.e(new Object[] { this.onlinePayEntity.Fm().getText(), paramString }) != 0.0D) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("支付被终止，应该支付 ");
      stringBuilder.append(this.onlinePayEntity.Fm().getText());
      stringBuilder.append("，而实际将要支付 ");
      stringBuilder.append(paramString);
      stringBuilder.append("，请先回到收银界面后再重新结算");
      paramString = stringBuilder.toString();
      this.onlinePayEntity.getHandler().obtainMessage(987654, paramString).sendToTarget();
      cancel();
      return true;
    } 
    return false;
  }
  
  private boolean dG(int paramInt) { return (this.onlinePayEntity.Fo() == paramInt); }
  
  private void e(ArrayList<PrintContent> paramArrayList) {
    l l = l.ahn();
    g g = g.cGS;
    for (e e : c.bp(this.mActivity).al(paramArrayList)) {
      e.a(new an(this, l));
      g.print(e);
    } 
  }
  
  private void setListeners() {
    this.aBf.setOnClickListener(this.aBo);
    this.aBg.setOnClickListener(this.aBo);
    this.aBh.setOnClickListener(this.aBo);
    this.azp.setOnClickListener(this.aAV);
    this.aAS.setOnClickListener(new as(this));
  }
  
  private void wR() {
    this.aAS = (LinearLayout)findViewById(R.id.ll_open_camera);
    this.aAY = (TextView)findViewById(R.id.tv_title);
    this.aAE = (FrameLayout)findViewById(R.id.ll_content);
    this.aAr = (RelativeLayout)this.mView.findViewById(R.id.rl_title_l);
    this.aBe = (LinearLayout)this.mView.findViewById(R.id.rl_switch_l);
    this.aBj = (TextView)this.mView.findViewById(R.id.tv_barcode_title);
    this.aBk = this.mView.findViewById(R.id.tv_barcode_bottom);
    this.aBl = (TextView)this.mView.findViewById(R.id.tv_qrcode_title);
    this.aBn = this.mView.findViewById(R.id.tv_qrcode_bottom);
    this.azp = (LinearLayout)this.mView.findViewById(R.id.ll_close);
    this.aBh = (RelativeLayout)this.mView.findViewById(R.id.rl_account);
    this.aAy = this.mView.findViewById(R.id.v_account_icon);
    this.aBi = this.mView.findViewById(R.id.tv_account_bottom);
    this.aBm = (TextView)this.mView.findViewById(R.id.tv_account_title);
    this.aAv = (RelativeLayout)this.mView.findViewById(R.id.rl_account_prepare);
    this.aAz = (TextView)this.mView.findViewById(R.id.tv_account_amount);
    this.aBf = (RelativeLayout)this.mView.findViewById(R.id.rl_barcode);
    this.aBg = (RelativeLayout)this.mView.findViewById(R.id.rl_qrcode);
    this.aAt = (RelativeLayout)this.mView.findViewById(R.id.ll_barcode_prepare);
    this.aAu = (LinearLayout)this.mView.findViewById(R.id.ll_qrcode_prepare);
    this.azq = (LinearLayout)this.mView.findViewById(R.id.ll_processing);
    this.azr = (LinearLayout)this.mView.findViewById(R.id.ll_result);
    this.aAw = (Button)this.mView.findViewById(R.id.btn_left);
    this.aAx = (Button)this.mView.findViewById(R.id.btn_right);
    this.aBf = (RelativeLayout)this.mView.findViewById(R.id.rl_barcode);
    this.aBg = (RelativeLayout)this.mView.findViewById(R.id.rl_qrcode);
    this.aAt = (RelativeLayout)this.mView.findViewById(R.id.ll_barcode_prepare);
    this.aAu = (LinearLayout)this.mView.findViewById(R.id.ll_qrcode_prepare);
    this.azq = (LinearLayout)this.mView.findViewById(R.id.ll_processing);
    this.azr = (LinearLayout)this.mView.findViewById(R.id.ll_result);
    this.aAw = (Button)this.mView.findViewById(R.id.btn_left);
    this.aAx = (Button)this.mView.findViewById(R.id.btn_right);
    this.aAs = (TextView)this.mView.findViewById(R.id.tv_amount);
    if (a.zR().Ak()) {
      this.aBg.setVisibility(8);
      this.aBh.setVisibility(8);
      this.aBe.setVisibility(8);
    } 
    if (!"150001".equals(RootApplication.getLaiqianPreferenceManager().atp()))
      this.aBh.setVisibility(8); 
  }
  
  private void xd() { // Byte code:
    //   0: new com/laiqian/models/an
    //   3: dup
    //   4: aload_0
    //   5: getfield aAA : Landroid/app/Activity;
    //   8: invokespecial <init> : (Landroid/content/Context;)V
    //   11: astore_1
    //   12: aload_1
    //   13: invokevirtual Vu : ()Lcom/laiqian/models/an$c;
    //   16: astore_2
    //   17: aload_1
    //   18: invokevirtual close : ()V
    //   21: aload_2
    //   22: getfield aVs : Ljava/lang/String;
    //   25: astore_2
    //   26: aload_2
    //   27: ifnull -> 42
    //   30: aload_2
    //   31: astore_1
    //   32: ldc_w ''
    //   35: aload_2
    //   36: invokevirtual equals : (Ljava/lang/Object;)Z
    //   39: ifeq -> 53
    //   42: aload_0
    //   43: getfield aAA : Landroid/app/Activity;
    //   46: getstatic com/laiqian/payment/R$string.nus_noti_title : I
    //   49: invokevirtual getString : (I)Ljava/lang/String;
    //   52: astore_1
    //   53: new java/util/HashMap
    //   56: dup
    //   57: invokespecial <init> : ()V
    //   60: astore_2
    //   61: aload_2
    //   62: ldc_w 'out_trade_no'
    //   65: aload_0
    //   66: getfield onlinePayEntity : Lcom/laiqian/entity/n;
    //   69: invokevirtual xq : ()Ljava/lang/String;
    //   72: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   75: pop
    //   76: aload_2
    //   77: ldc_w 'auth_code'
    //   80: aload_0
    //   81: getfield aAC : Ljava/lang/String;
    //   84: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   87: pop
    //   88: aload_2
    //   89: ldc_w 'subject'
    //   92: aload_1
    //   93: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   96: pop
    //   97: aload_2
    //   98: ldc_w 'total_amount'
    //   101: aload_0
    //   102: getfield onlinePayEntity : Lcom/laiqian/entity/n;
    //   105: invokevirtual Fl : ()Ljava/lang/String;
    //   108: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   111: pop
    //   112: new com/laiqian/util/av
    //   115: dup
    //   116: aload_0
    //   117: getfield aAA : Landroid/app/Activity;
    //   120: invokespecial <init> : (Landroid/content/Context;)V
    //   123: astore_1
    //   124: aload_2
    //   125: ldc_w 'shop_id'
    //   128: aload_1
    //   129: invokevirtual Tx : ()Ljava/lang/String;
    //   132: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   135: pop
    //   136: aload_0
    //   137: getfield onlinePayEntity : Lcom/laiqian/entity/n;
    //   140: invokevirtual Fn : ()I
    //   143: iconst_1
    //   144: if_icmpne -> 200
    //   147: new java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial <init> : ()V
    //   154: astore_3
    //   155: aload_3
    //   156: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   159: invokevirtual avs : ()I
    //   162: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload_3
    //   167: ldc_w ''
    //   170: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload_2
    //   175: ldc_w 'pay_mode'
    //   178: aload_3
    //   179: invokevirtual toString : ()Ljava/lang/String;
    //   182: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   185: pop
    //   186: aload_2
    //   187: ldc_w 'business_type'
    //   190: ldc_w 'member'
    //   193: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   196: pop
    //   197: goto -> 211
    //   200: aload_2
    //   201: ldc_w 'business_type'
    //   204: ldc_w 'reception'
    //   207: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   210: pop
    //   211: aload_2
    //   212: invokestatic e : (Ljava/util/HashMap;)V
    //   215: aload_1
    //   216: invokevirtual close : ()V
    //   219: aload_0
    //   220: iconst_0
    //   221: invokevirtual dF : (I)V
    //   224: aload_0
    //   225: invokevirtual wW : ()Z
    //   228: ifne -> 249
    //   231: new com/laiqian/ar
    //   234: dup
    //   235: aload_0
    //   236: aload_2
    //   237: invokespecial <init> : (Lcom/laiqian/ag;Ljava/util/HashMap;)V
    //   240: astore_1
    //   241: invokestatic aKh : ()Lio/reactivex/m;
    //   244: aload_1
    //   245: invokevirtual r : (Ljava/lang/Runnable;)Lio/reactivex/a/b;
    //   248: pop
    //   249: return }
  
  private void xg() {
    int i;
    Activity activity = new StringBuilder();
    activity.append(this.onlinePayEntity.Fo());
    activity.append("");
    Log.e("支付类型：", activity.toString());
    this.aAR = false;
    if (this.onlinePayEntity.Fo() == 5L || this.onlinePayEntity.Fo() == 8L) {
      this.aAD = new bt(this.aAA, this, this.onlinePayEntity);
      this.aAK = a.cqM;
      this.aAL = a.cqP;
      this.aAZ = false;
    } else if (this.onlinePayEntity.Fo() == 1L || this.onlinePayEntity.Fo() == 0L) {
      this.aAD = new a(this.aAA, this, this.onlinePayEntity);
      this.aAK = a.cqE;
      this.aAL = a.cqG;
      this.aAZ = true;
    } else {
      xk();
    } 
    xh();
    TextView textView = this.aAY;
    if (this.aAZ) {
      Activity activity1 = this.aAA;
      i = R.string.pos_pay_Alipay;
    } else {
      activity = this.aAA;
      i = R.string.pos_pay_wechat;
    } 
    Resources resources2 = activity.getString(i);
    textView.setText(resources2);
    if (this.aAZ) {
      Resources resources = this.aAA.getResources();
      i = R.drawable.icon_alipay;
    } else {
      resources2 = this.aAA.getResources();
      i = R.drawable.icon_wechat;
    } 
    Drawable drawable2 = resources2.getDrawable(i);
    drawable2.setBounds(0, 0, 24, 24);
    this.aAY.setCompoundDrawables(drawable2, null, null, null);
    this.aAY.setCompoundDrawablePadding(8);
    Resources resources1 = new HashMap();
    resources1.put("out_trade_no", this.onlinePayEntity.xq());
    resources1.put("total_amount", this.onlinePayEntity.Fl());
    av av = new av(this.aAA);
    resources1.put("shop_id", av.Tx());
    resources1.put("pay_type", "bar_code");
    f.e(resources1);
    av.close();
    View view = this.aAy;
    if (this.aAZ) {
      Resources resources = this.aAA.getResources();
      i = R.drawable.icon_account_alipay_pay;
    } else {
      resources1 = this.aAA.getResources();
      i = R.drawable.icon_account_wechat_pay;
    } 
    Drawable drawable1 = resources1.getDrawable(i);
    view.setBackground(drawable1);
    this.aAQ = new k(this.aAA, this.onlinePayEntity.getHandler());
    this.aAM = by.b(String.format(this.aAA.getString(R.string.pay_amount), new Object[] { this.onlinePayEntity.Fl() }), this.onlinePayEntity.Fl(), 18, this.aAA.getResources().getColor(R.color.red_color_10500));
    this.aAs.setText(this.aAM);
    this.aAz.setText(this.aAM);
  }
  
  private void xh() {
    if (this.onlinePayEntity.Fn() == 2 && RootApplication.getLaiqianPreferenceManager().avZ())
      this.aBh.setVisibility(8); 
    if (this.onlinePayEntity.Fn() == 1 && RootApplication.getLaiqianPreferenceManager().avs() == 1 && RootApplication.getLaiqianPreferenceManager().avr() == 0)
      this.aBh.setVisibility(8); 
    if (this.onlinePayEntity.Fo() == 5L || this.onlinePayEntity.Fo() == 1L) {
      this.aBf.performClick();
      return;
    } 
    if (this.onlinePayEntity.Fo() == 8L || this.onlinePayEntity.Fo() == 0L) {
      this.aBg.performClick();
      return;
    } 
  }
  
  private boolean xj() {
    Log.e("isSameOrderNo", this.onlinePayEntity.xq());
    Log.e("isSameOrderNo", this.aBt.xq());
    return (this.aBt != null && this.onlinePayEntity != null && this.onlinePayEntity.xq() != null && this.onlinePayEntity.xq().equals(this.aBt.xq()));
  }
  
  private boolean xm() { return (this.onlinePayEntity.Fo() == 5L || this.onlinePayEntity.Fo() == 1L); }
  
  private boolean xn() { return (this.onlinePayEntity.Fo() == 8L || this.onlinePayEntity.Fo() == 0L); }
  
  private void xt() {
    super.show();
    xg();
  }
  
  private void xu() {
    String str2 = RootApplication.getLaiqianPreferenceManager().awi();
    String str3 = RootApplication.getLaiqianPreferenceManager().awh();
    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
      xt();
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.aAA.getString(R.string.pay_acccount_status_fail));
    stringBuilder.append(",");
    stringBuilder.append(this.aAA.getString(R.string.pos_report_export_mail_send_fail));
    String str1 = stringBuilder.toString();
    Toast.makeText(this.aAA, str1, 0).show();
    f.a(this.aAA, new am(this));
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("showResult | ");
    stringBuilder.append(paramInt2);
    stringBuilder.append(" | ");
    stringBuilder.append(this.onlinePayEntity.Fo());
    Log.d("OnlinePayDialog", stringBuilder.toString());
    if (!dG(paramInt2)) {
      Log.d("OnlinePayDialog", "不处理");
      return;
    } 
    this.aAt.setVisibility(8);
    this.aAv.setVisibility(8);
    this.aAu.setVisibility(8);
    this.azq.setVisibility(8);
    this.azr.setVisibility(0);
    this.azr.findViewById(R.id.tv_qrcode_warning).setVisibility(8);
    if (paramInt1 != -1) {
      if (paramInt1 != 4) {
        if (paramInt1 != 6) {
          if (paramInt1 != 10000) {
            if (paramInt1 != 20001) {
              if (paramInt1 != 40004) {
                switch (paramInt1) {
                  default:
                    switch (paramInt1) {
                      default:
                        return;
                      case 90001:
                        if (this.aBn.getVisibility() == 0) {
                          ((ImageView)this.azr.findViewById(R.id.v_result_icon)).setBackgroundResource(R.drawable.icon_error);
                          ((TextView)this.azr.findViewById(R.id.tv_result)).setText(R.string.create_qrcode_fail);
                          this.aAw.setOnClickListener(this.aAV);
                          this.aAw.setVisibility(0);
                          this.aAw.setText(R.string.lqj_cancel);
                          this.aAx.setVisibility(8);
                          this.aAI = System.currentTimeMillis();
                          return;
                        } 
                        this.aAD.stop();
                        xo();
                        return;
                      case 90000:
                        break;
                    } 
                    if (this.aBn.getVisibility() == 0) {
                      try {
                        this.aAO = al.B(paramString1, 250);
                        this.aBt.o(this.aAO);
                        if (!this.onlinePayEntity.Fk() && this.aAO != null && this.aAN != null && this.aAN.size() > 0)
                          e(this.aAN); 
                      } catch (WriterException paramString1) {
                        a.e(paramString1);
                      } 
                      ((TextView)this.azr.findViewById(R.id.tv_qrcode_warning)).setVisibility(0);
                      ((TextView)this.azr.findViewById(R.id.tv_qrcode_warning)).setText(String.format(this.aAA.getString(R.string.online_pay_warning), new Object[] { this.aAY.getText().toString() }));
                      ((ImageView)this.azr.findViewById(R.id.v_result_icon)).setBackground(new BitmapDrawable(this.aAO));
                      ((TextView)this.azr.findViewById(R.id.tv_result)).setText(this.aAM);
                      this.aAw.setText(R.string.lqj_cancel);
                      this.aAw.setOnClickListener(this.aAV);
                      this.aAw.setVisibility(0);
                      this.aAx.setText(R.string.pos_main_pay_finish_printqrcode);
                      this.aAx.setOnClickListener(this.aAX);
                      this.aAx.setVisibility(0);
                      this.aAI = System.currentTimeMillis();
                      return;
                    } 
                    this.aAD.stop();
                    xo();
                    return;
                  case 40001:
                  case 40002:
                    break;
                } 
                ((ImageView)this.azr.findViewById(R.id.v_result_icon)).setBackgroundResource(R.drawable.icon_warning);
                ((TextView)this.azr.findViewById(R.id.tv_result)).setText(paramString1);
                this.aAw.setOnClickListener(this.aAU);
                this.aAw.setText(R.string.money_did_not_receive);
                this.aAw.setVisibility(0);
                this.aAx.setVisibility(0);
                this.aAx.setOnClickListener(this.aBp);
                this.aAx.setText(R.string.money_has_been_received);
                this.aAx.setTextColor(this.aAA.getResources().getColor(R.color.red_color_10500));
                return;
              } 
              ((ImageView)this.azr.findViewById(R.id.v_result_icon)).setBackgroundResource(R.drawable.icon_error);
              ((TextView)this.azr.findViewById(R.id.tv_result)).setText(R.string.pos_alipay_pay_fails);
              this.aAw.setVisibility(8);
              this.aAx.setVisibility(0);
              this.aAx.setOnClickListener(this.aAU);
              this.aAx.setText(R.string.pay_retry);
              this.aAx.setTextColor(this.aAA.getResources().getColor(R.color.red_color_10500));
              return;
            } 
            ((ImageView)this.azr.findViewById(R.id.v_result_icon)).setBackgroundResource(R.drawable.icon_warning);
            ((TextView)this.azr.findViewById(R.id.tv_result)).setText(paramString1);
            this.aAw.setText(R.string.online_pay_auth);
            this.aAw.setOnClickListener(this.aAW);
            this.aAw.setVisibility(0);
            this.aAx.setVisibility(8);
            return;
          } 
          ((ImageView)this.azr.findViewById(R.id.v_result_icon)).setBackgroundResource(R.drawable.icon_success);
          ((TextView)this.azr.findViewById(R.id.tv_result)).setText(R.string.pos_alipay_pay_complete);
          this.aAw.setText(R.string.pos_product_dialog_sure);
          this.aAw.setOnClickListener(new ah(this, paramString2));
          this.aAx.setVisibility(8);
          confirm(paramString2);
          return;
        } 
        ((ImageView)this.azr.findViewById(R.id.v_result_icon)).setBackgroundResource(R.drawable.icon_warning);
        ((TextView)this.azr.findViewById(R.id.tv_result)).setText(R.string.pos_alipay_is_paid);
        this.aAw.setOnClickListener(this.aAU);
        this.aAw.setText(R.string.money_did_not_receive);
        this.aAw.setVisibility(0);
        this.aAx.setVisibility(0);
        this.aAx.setOnClickListener(this.aBp);
        this.aAx.setText(R.string.money_has_been_received);
        this.aAx.setTextColor(this.aAA.getResources().getColor(R.color.red_color_10500));
        n.o("我自定义的消息");
        return;
      } 
      ((ImageView)this.azr.findViewById(R.id.v_result_icon)).setBackgroundResource(R.drawable.icon_warning);
      ((TextView)this.azr.findViewById(R.id.tv_result)).setText(R.string.pos_alipay_is_paid);
      this.aAw.setOnClickListener(this.aAU);
      this.aAw.setText(R.string.money_did_not_receive);
      this.aAw.setVisibility(0);
      this.aAx.setVisibility(0);
      this.aAx.setOnClickListener(this.aBp);
      this.aAx.setText(R.string.money_has_been_received);
      this.aAx.setTextColor(this.aAA.getResources().getColor(R.color.red_color_10500));
      return;
    } 
    (new bc(this.aAA)).show();
    ((ImageView)this.azr.findViewById(R.id.v_result_icon)).setBackgroundResource(R.drawable.icon_warning);
    ((TextView)this.azr.findViewById(R.id.tv_result)).setText(R.string.pos_alipay_is_paid);
    this.aAw.setOnClickListener(this.aAU);
    this.aAw.setText(R.string.money_did_not_receive);
    this.aAw.setVisibility(0);
    this.aAx.setVisibility(0);
    this.aAx.setOnClickListener(this.aBp);
    this.aAx.setText(R.string.money_has_been_received);
    this.aAx.setTextColor(this.aAA.getResources().getColor(R.color.red_color_10500));
  }
  
  public void bg(String paramString) {
    this.aAJ.aBW = this.onlinePayEntity.xq();
    this.aAJ.aBY = paramString;
    this.aAJ.aBX = ((System.currentTimeMillis() - this.aAB) / 1000L);
    this.aAJ.xz();
  }
  
  public void bh(String paramString) {
    null = new r(this.aAA, 3, null);
    null.setTitle(this.aAA.getString(R.string.pos_dialog_title_error));
    null.s(paramString);
    null.pa(this.aAA.getString(R.string.pos_dialog_button_ok));
    null.show();
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("type", "支付之前");
      jSONObject.put("message", paramString);
    } catch (JSONException paramString) {
      a.e(paramString);
    } 
    a.aAU().a(this.aAA, "扫码支付错误", jSONObject);
  }
  
  public void br(boolean paramBoolean) { this.aAF.set(paramBoolean); }
  
  public void bs(boolean paramBoolean) { this.aAH.set(paramBoolean); }
  
  public void bt(boolean paramBoolean) { this.aAG.set(paramBoolean); }
  
  public void confirm(String paramString) {
    xk();
    if (this.aAD != null)
      this.aAD.stop(); 
    if (!this.aAR && bi(paramString)) {
      this.aAR = true;
      Message message = new Message();
      message.what = 1;
      message.obj = paramString;
      this.onlinePayEntity.getHandler().sendMessage(message);
    } 
  }
  
  public void d(ArrayList<PrintContent> paramArrayList) { this.aAN = paramArrayList; }
  
  public void dF(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("showProcess ");
    stringBuilder.append(paramInt);
    stringBuilder.append(" | ");
    stringBuilder.append(this.onlinePayEntity.Fo());
    Log.d("OnlinePayDialog", stringBuilder.toString());
    if ((xn() && paramInt == 1) || (xm() && paramInt == 0)) {
      switch (paramInt) {
        case 1:
          ((TextView)this.azq.findViewById(R.id.tv_process)).setText(R.string.creating_qrcode);
          break;
        case 0:
          ((TextView)this.azq.findViewById(R.id.tv_process)).setText(R.string.paying);
          break;
      } 
      this.aAt.setVisibility(8);
      this.aAv.setVisibility(8);
      this.aAu.setVisibility(8);
      this.azq.setVisibility(0);
      this.azr.setVisibility(8);
      this.aAw.setOnClickListener(this.aAV);
    } 
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    if (this.onlinePayEntity.Fo() != 8L && this.onlinePayEntity.Fo() != 0L)
      this.mScanGunKeyEventHelper.f(paramKeyEvent); 
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    this.aAE.setFocusable(true);
    this.aAE.setFocusableInTouchMode(true);
    this.aAE.requestFocus();
    this.aAE.requestFocusFromTouch();
    return true;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    this.aAE.setFocusable(true);
    this.aAE.setFocusableInTouchMode(true);
    this.aAE.requestFocus();
    this.aAE.requestFocusFromTouch();
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) { // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokespecial onWindowFocusChanged : (Z)V
    //   5: iload_1
    //   6: ifeq -> 289
    //   9: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   12: invokevirtual avS : ()Ljava/lang/String;
    //   15: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   18: ifne -> 289
    //   21: aload_0
    //   22: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   25: invokevirtual avS : ()Ljava/lang/String;
    //   28: putfield aAC : Ljava/lang/String;
    //   31: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   34: ldc_w ''
    //   37: invokevirtual rF : (Ljava/lang/String;)V
    //   40: new com/laiqian/models/an
    //   43: dup
    //   44: aload_0
    //   45: getfield aAA : Landroid/app/Activity;
    //   48: invokespecial <init> : (Landroid/content/Context;)V
    //   51: astore_2
    //   52: aload_2
    //   53: invokevirtual Vu : ()Lcom/laiqian/models/an$c;
    //   56: astore_3
    //   57: aload_2
    //   58: invokevirtual close : ()V
    //   61: aload_3
    //   62: getfield aVs : Ljava/lang/String;
    //   65: astore_3
    //   66: aload_3
    //   67: ifnull -> 82
    //   70: aload_3
    //   71: astore_2
    //   72: ldc_w ''
    //   75: aload_3
    //   76: invokevirtual equals : (Ljava/lang/Object;)Z
    //   79: ifeq -> 93
    //   82: aload_0
    //   83: getfield aAA : Landroid/app/Activity;
    //   86: getstatic com/laiqian/payment/R$string.nus_noti_title : I
    //   89: invokevirtual getString : (I)Ljava/lang/String;
    //   92: astore_2
    //   93: new java/util/HashMap
    //   96: dup
    //   97: invokespecial <init> : ()V
    //   100: astore_3
    //   101: aload_3
    //   102: ldc_w 'out_trade_no'
    //   105: aload_0
    //   106: getfield onlinePayEntity : Lcom/laiqian/entity/n;
    //   109: invokevirtual xq : ()Ljava/lang/String;
    //   112: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   115: pop
    //   116: aload_3
    //   117: ldc_w 'auth_code'
    //   120: aload_0
    //   121: getfield aAC : Ljava/lang/String;
    //   124: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   127: pop
    //   128: aload_3
    //   129: ldc_w 'subject'
    //   132: aload_2
    //   133: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   136: pop
    //   137: aload_3
    //   138: ldc_w 'total_amount'
    //   141: aload_0
    //   142: getfield onlinePayEntity : Lcom/laiqian/entity/n;
    //   145: invokevirtual Fl : ()Ljava/lang/String;
    //   148: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   151: pop
    //   152: new com/laiqian/util/av
    //   155: dup
    //   156: aload_0
    //   157: getfield aAA : Landroid/app/Activity;
    //   160: invokespecial <init> : (Landroid/content/Context;)V
    //   163: astore_2
    //   164: aload_3
    //   165: ldc_w 'shop_id'
    //   168: aload_2
    //   169: invokevirtual Tx : ()Ljava/lang/String;
    //   172: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   175: pop
    //   176: aload_0
    //   177: getfield onlinePayEntity : Lcom/laiqian/entity/n;
    //   180: invokevirtual Fn : ()I
    //   183: iconst_1
    //   184: if_icmpne -> 244
    //   187: new java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial <init> : ()V
    //   194: astore #4
    //   196: aload #4
    //   198: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   201: invokevirtual avs : ()I
    //   204: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload #4
    //   210: ldc_w ''
    //   213: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload_3
    //   218: ldc_w 'pay_mode'
    //   221: aload #4
    //   223: invokevirtual toString : ()Ljava/lang/String;
    //   226: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   229: pop
    //   230: aload_3
    //   231: ldc_w 'business_type'
    //   234: ldc_w 'member'
    //   237: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   240: pop
    //   241: goto -> 255
    //   244: aload_3
    //   245: ldc_w 'business_type'
    //   248: ldc_w 'reception'
    //   251: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   254: pop
    //   255: aload_2
    //   256: invokevirtual close : ()V
    //   259: aload_0
    //   260: iconst_0
    //   261: invokevirtual dF : (I)V
    //   264: aload_0
    //   265: invokevirtual wW : ()Z
    //   268: ifne -> 289
    //   271: new com/laiqian/at
    //   274: dup
    //   275: aload_0
    //   276: aload_3
    //   277: invokespecial <init> : (Lcom/laiqian/ag;Ljava/util/HashMap;)V
    //   280: astore_2
    //   281: invokestatic aKh : ()Lio/reactivex/m;
    //   284: aload_2
    //   285: invokevirtual r : (Ljava/lang/Runnable;)Lio/reactivex/a/b;
    //   288: pop
    //   289: return }
  
  public void show() {
    if (a.zR().Ak()) {
      xu();
      return;
    } 
    xt();
  }
  
  public void show(int paramInt) { show(); }
  
  public boolean wW() { return this.aAF.get(); }
  
  public boolean wX() { return this.aAG.get(); }
  
  public boolean wY() { return this.aAH.get(); }
  
  public void xi() {
    xk();
    if (this.aAD != null)
      this.aAD.stop(); 
    if (!this.aAR && xj()) {
      this.aAR = true;
      Message message = new Message();
      message.what = 2;
      this.onlinePayEntity.getHandler().sendMessage(message);
    } 
  }
  
  public void xk() {
    if (this.aAA instanceof Activity) {
      if (!this.aAA.isFinishing() && isShowing()) {
        dismiss();
        return;
      } 
    } else if (isShowing()) {
      dismiss();
    } 
  }
  
  public void xl() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("showQrcodePrepare | ");
    stringBuilder.append(this.onlinePayEntity.Fo());
    Log.d("OnlinePayDialog", stringBuilder.toString());
    this.aAO = null;
    this.aAt.setVisibility(8);
    this.aAv.setVisibility(8);
    this.aAu.setVisibility(0);
    this.azq.setVisibility(8);
    this.azr.setVisibility(8);
    this.aAw.setText(R.string.lqj_cancel);
    this.aAw.setVisibility(0);
    this.aAx.setVisibility(8);
  }
  
  public void xo() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("showBarcodePrepare | ");
    stringBuilder.append(this.onlinePayEntity.Fo());
    Log.d("OnlinePayDialog", stringBuilder.toString());
    this.aAt.setVisibility(0);
    this.aAv.setVisibility(8);
    this.aAu.setVisibility(8);
    this.azq.setVisibility(8);
    this.azr.setVisibility(8);
    this.aAw.setText(R.string.lqj_cancel);
    this.aAw.setOnClickListener(this.aAV);
    this.aAw.setVisibility(0);
    this.aAx.setVisibility(8);
  }
  
  public void xp() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("showAccountView | ");
    stringBuilder.append(this.onlinePayEntity.Fo());
    Log.d("OnlinePayDialog", stringBuilder.toString());
    this.aAv.setVisibility(0);
    this.aAt.setVisibility(8);
    this.aAu.setVisibility(8);
    this.azq.setVisibility(8);
    this.azr.setVisibility(8);
    this.aAw.setText(R.string.pos_confirm);
    this.aAw.setOnClickListener(this.aAT);
    this.aAw.setVisibility(0);
    this.aAx.setVisibility(8);
  }
  
  public static interface a {
    void a(long param1Long, boolean param1Boolean);
    
    void bk(String param1String);
    
    void bl(String param1String);
    
    void f(int param1Int, String param1String);
    
    void o(Bitmap param1Bitmap);
    
    String xq();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */