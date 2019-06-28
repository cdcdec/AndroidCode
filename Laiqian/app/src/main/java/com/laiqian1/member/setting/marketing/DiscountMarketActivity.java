package com.laiqian.member.setting.marketing;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Size;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.member.setting.marketing.a.a;
import com.laiqian.member.setting.sms.b;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.ui.a.ax;
import com.laiqian.ui.a.bc;
import com.laiqian.ui.a.r;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.container.h;
import com.laiqian.ui.container.m;
import com.laiqian.ui.s;
import com.laiqian.util.bd;
import com.laiqian.util.by;
import com.laiqian.util.n;
import com.laiqian.vip.R;
import java.util.Calendar;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;

public class DiscountMarketActivity extends ActivityRoot implements v {
  private static final String TAG = "DiscountMarketActivity";
  
  String Ze = "%Y年%m月%d日";
  
  String aVs;
  
  private String bEA;
  
  private String bEB;
  
  private String bEC;
  
  private a bEd;
  
  t bEe;
  
  String bEf;
  
  r bEg;
  
  r bEh;
  
  r bEi;
  
  private SmsReceiver bEj;
  
  private ac bEk;
  
  private String bEl;
  
  private String bEm;
  
  private String bEn;
  
  private String bEo;
  
  private int bEp;
  
  private int bEq = 0;
  
  private int bEr;
  
  private int bEs;
  
  private int bEt;
  
  private r bEu;
  
  private ax bEv;
  
  private ad bEw;
  
  private ax bEx;
  
  private ax bEy;
  
  private String bEz;
  
  private r baC;
  
  protected long[] bqs = { 0L, 0L };
  
  aa titleBar;
  
  static  {
  
  }
  
  private void Lk() {
    if (this.bEj == null)
      this.bEj = new SmsReceiver(this); 
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("SMS_CHARGE_RECEIVER");
    getActivity().registerReceiver(this.bEj, intentFilter);
  }
  
  private void Ll() {
    try {
      getActivity().unregisterReceiver(this.bEj);
      return;
    } catch (Exception exception) {
      a.e(exception);
      return;
    } 
  }
  
  private void RE() {
    this.bEk = new ac(this, this.bEq);
    this.baC = new r(this, true, null);
    this.baC.oZ("返回");
    this.baC.setTitle(getString(R.string.sms_warning));
    this.baC.s(q("自定义短信将在", "一个工作日内", "完成审核并发送，请耐心等待"));
    this.bEu = new r(this, 3, null);
    this.bEu.pa("重新编辑");
    this.bEu.setTitle(getString(R.string.sms_warning));
    SpannableStringBuilder spannableStringBuilder1 = f(getString(R.string.recipient_current_birthday), this.bEp);
    SpannableStringBuilder spannableStringBuilder2 = f(getString(R.string.recipient_all_memeber), this.bEt);
    SpannableStringBuilder spannableStringBuilder3 = f(getString(R.string.recipient_two_times_month), this.bEs);
    SpannableStringBuilder spannableStringBuilder4 = f(getString(R.string.recipient_none_consumption), this.bEr);
    CharSequence[] arrayOfCharSequence2 = { spannableStringBuilder2, spannableStringBuilder3, spannableStringBuilder4 };
    a a1 = new a(this);
    this.bEx = new ax(this, new CharSequence[][] { arrayOfCharSequence2 }, a1);
    l l = new l(this);
    this.bEy = new ax(this, new CharSequence[][] { { spannableStringBuilder1, spannableStringBuilder2, spannableStringBuilder3, spannableStringBuilder4 },  }, l);
    String str = getString(R.string.vip_birthday_promotion);
    CharSequence[] arrayOfCharSequence1 = { getString(R.string.vip_promotion_notice_type), str };
    m m = new m(this);
    this.bEv = new ax(this, new CharSequence[][] { arrayOfCharSequence1 }, m);
    this.bEw = new ad(this);
  }
  
  private void Sg() {
    if (!bd.bH(this)) {
      (new bc(this)).show();
      return;
    } 
    if (TextUtils.isEmpty(this.bEf)) {
      Ss();
      return;
    } 
    if (this.bEf.split(",").length * Integer.valueOf(this.bEz).intValue() < this.bEe.Su()) {
      So();
      return;
    } 
    Sr();
  }
  
  private void Sh() {
    if (this.bEq == 0) {
      if (this.bEx != null) {
        this.bEx.show();
        return;
      } 
    } else if (this.bEy != null) {
      this.bEy.show();
    } 
  }
  
  private void Si() {
    ((TextView)this.bEd.bEH.cAO.getView()).setText(R.string.vip_market_recipient);
    if (this.bEq == 0) {
      TextView textView1 = (TextView)this.bEd.bEH.dwP.getView();
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append(getString(R.string.recipient_all_memeber));
      stringBuilder3.append("  ");
      String str1 = getString(R.string.recipient_total);
      StringBuilder stringBuilder4 = new StringBuilder();
      stringBuilder4.append(this.bEt);
      stringBuilder4.append("");
      stringBuilder3.append(String.format(str1, new Object[] { stringBuilder4.toString() }));
      textView1.setText(stringBuilder3.toString());
      this.bEf = this.bEn;
      return;
    } 
    TextView textView = (TextView)this.bEd.bEH.dwP.getView();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(getString(R.string.recipient_current_month_birthday_memeber));
    stringBuilder1.append("  ");
    String str = getString(R.string.recipient_total);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.bEp);
    stringBuilder2.append("");
    stringBuilder1.append(String.format(str, new Object[] { stringBuilder2.toString() }));
    textView.setText(stringBuilder1.toString());
    this.bEf = this.bEo;
  }
  
  private void So() {
    if (this.bEg == null)
      this.bEg = new r(this, new i(this)); 
    this.bEg.s(String.format(getString(R.string.send_messages_to_vip), new Object[] { Integer.valueOf(this.bEf.split(",").length) }));
    this.bEg.setTitle(getString(R.string.pos_dialog_title_prompt));
    this.bEg.show();
  }
  
  private void Sp() {
    b b = new b();
    b.setMessage(this.bEA);
    b.gf(this.bEf);
    b.gg(this.bEB);
    b.gh(this.bEC);
    this.bEe.a(b);
  }
  
  private boolean Sq() {
    this.bEA = String.format(getString(R.string.vip_marketing_sms_template_no_sign), new Object[] { a.d(this.bEd).getText().toString(), this.aVs });
    this.bEB = a.a(this.bEd).getText().toString().trim();
    this.bEC = ((EditText)this.bEd.bEG.dwQ.getView()).getText().toString().trim();
    if (TextUtils.isEmpty(this.bEA)) {
      n.w(this, R.string.discount_sms_content_not_null);
      return true;
    } 
    if (TextUtils.isEmpty(this.bEC)) {
      n.w(this, R.string.discount_sms_title_not_null);
      return true;
    } 
    return false;
  }
  
  private void Sr() {
    if (this.bEh == null)
      this.bEh = new r(this, new j(this)); 
    this.bEh.s(getString(R.string.message_number_is_insufficient));
    this.bEh.setTitle(getString(R.string.pos_dialog_title_prompt));
    this.bEh.t(getString(R.string.button_to_buy));
    this.bEh.show();
  }
  
  private void Ss() {
    if (this.bEi == null)
      this.bEi = new r(this, new k(this)); 
    this.bEi.s(getString(R.string.no_member_data));
    this.bEi.setTitle(getString(R.string.pos_dialog_title_prompt));
    this.bEi.show();
  }
  
  @Size
  public static long[] aW(int paramInt1, int paramInt2) {
    Calendar calendar = Calendar.getInstance();
    int i = paramInt2 + 1;
    if (i == 12)
      i = 0; 
    calendar.set(paramInt1, i, 1, 0, 0, 0);
    calendar.setTimeInMillis(calendar.getTimeInMillis() - calendar.get(14) - 1L);
    long l = calendar.getTimeInMillis();
    calendar.set(paramInt1, paramInt2, 1, 0, 0, 0);
    return new long[] { calendar.getTimeInMillis() - calendar.get(14), l };
  }
  
  @NonNull
  private SpannableStringBuilder f(String paramString, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("   ");
    paramString = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(paramInt);
    stringBuilder.append(getString(R.string.recipient_));
    String str = stringBuilder.toString();
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
    spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.setting_text_color2)), paramString.length(), str.length(), 33);
    return spannableStringBuilder;
  }
  
  private void fP(int paramInt) {
    if (paramInt == 0) {
      this.bEq = 0;
      return;
    } 
    if (paramInt == 1)
      this.bEq = 1; 
  }
  
  private void fQ(int paramInt) {
    CharSequence charSequence1;
    fP(paramInt);
    paramInt = this.bEq;
    SpannableStringBuilder spannableStringBuilder = null;
    if (paramInt == 0) {
      spannableStringBuilder = ga(getString(R.string.vip_marketing_sms_content_template));
      charSequence3 = ga(getString(R.string.vip_promotion_notice));
      charSequence2 = ga(getString(R.string.vip_promotion_notice_type));
      charSequence1 = r(getString(R.string.vip_promotion_defalut_sign), getString(R.string.vip_marketing_sms_content_template), this.aVs);
    } else if (this.bEq == 1) {
      spannableStringBuilder = ga(getString(R.string.vip_birthday_wishes_sms_content_template));
      charSequence3 = ga(getString(R.string.vip_birthday_promotion));
      charSequence2 = ga(getString(R.string.vip_birthday_promotion));
      charSequence1 = r(getString(R.string.vip_promotion_defalut_sign), getString(R.string.vip_birthday_wishes_sms_content_template), this.aVs);
    } else {
      charSequence3 = null;
      charSequence2 = charSequence3;
      charSequence1 = charSequence2;
    } 
    this.bEd.bEE.setText(charSequence1);
    a.d(this.bEd).setText(spannableStringBuilder);
    ((EditText)this.bEd.bEG.dwQ.getView()).setText(charSequence3);
    a.a(this.bEd).setText(charSequence2);
    TextView textView = a.e(this.bEd);
    CharSequence charSequence2 = getString(R.string.vip_promotion_sms_length);
    CharSequence charSequence3 = new StringBuilder();
    charSequence3.append(charSequence1.toString().length());
    charSequence3.append("");
    textView.setText(String.format(charSequence2, new Object[] { charSequence3.toString() }));
    a.f(this.bEd).setText((this.bEz = String.valueOf((int)Math.ceil(charSequence1.toString().length() / 69.0D))).format(getString(R.string.vip_promotion_sms_amount), new Object[] { this.bEz }));
    Si();
  }
  
  private void fR(int paramInt) {
    if (this.bEq == 0) {
      if (paramInt == 0) {
        this.bEf = this.bEn;
        return;
      } 
      if (paramInt == 1) {
        this.bEf = this.bEm;
        return;
      } 
      if (paramInt == 2) {
        this.bEf = this.bEl;
        return;
      } 
    } else {
      if (paramInt == 0) {
        this.bEf = this.bEo;
        return;
      } 
      if (paramInt == 1) {
        this.bEf = this.bEn;
        return;
      } 
      if (paramInt == 2) {
        this.bEf = this.bEm;
        return;
      } 
      if (paramInt == 3)
        this.bEf = this.bEl; 
    } 
  }
  
  @NonNull
  private SpannableStringBuilder ga(String paramString) {
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(paramString);
    spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.vip_sms_brown)), 0, paramString.length(), 33);
    return spannableStringBuilder;
  }
  
  @Size
  public static long[] i(int paramInt1, int paramInt2, int paramInt3) {
    Calendar calendar = Calendar.getInstance();
    paramInt1 = calendar.get(2);
    paramInt3 = calendar.get(1);
    int i = paramInt1 - 1;
    long[] arrayOfLong = aW(paramInt3, paramInt1);
    paramInt2 = i;
    paramInt1 = paramInt3;
    if (i == -1) {
      paramInt2 = 11;
      paramInt1 = paramInt3 - 1;
    } 
    return new long[] { aW(paramInt1, paramInt2)[0], arrayOfLong[1] };
  }
  
  @NonNull
  private SpannableStringBuilder q(String paramString1, String paramString2, String paramString3) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString1);
    stringBuilder.append(paramString2);
    stringBuilder.append(paramString3);
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(stringBuilder.toString());
    spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.red_color_10500)), paramString1.length(), paramString1.length() + paramString2.length(), 33);
    return spannableStringBuilder;
  }
  
  private SpannableStringBuilder r(String paramString1, String paramString2, String paramString3) {
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.format(getString(R.string.vip_marketing_sms_template), new Object[] { paramString1, paramString2, paramString3 }));
    spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.color_sms_content)), paramString1.length() + 2, paramString1.length() + paramString2.length() + 4, 33);
    return spannableStringBuilder;
  }
  
  private void setListeners() {
    ((EditText)this.bEd.bEG.dwQ.getView()).setOnTouchListener(new n(this));
    this.bEw.a(new o(this));
    a.g(this.bEd).setOnClickListener(new p(this));
    this.bEu.a(new q(this));
    a.d(this.bEd).setOnClickListener(new r(this));
    this.bEk.a(new s(this));
    a.b(this.bEd).setOnClickListener(new b(this));
    ((ViewGroup)this.bEd.bEH.getView()).setOnClickListener(new c(this));
    this.bEd.bEK.setOnClickListener(new d(this));
    ((ViewGroup)this.bEd.bEF.getView()).setOnClickListener(new e(this));
    this.bEd.bqN.setOnClickListener(new f(this));
  }
  
  private void setupViews() {
    ViewGroup.LayoutParams layoutParams = ((TextView)this.bEd.bEF.cAO.getView()).getLayoutParams();
    layoutParams.width = 300;
    ((TextView)this.bEd.bEF.cAO.getView()).setLayoutParams(layoutParams);
    ((TextView)this.bEd.bEF.dwP.getView()).setText(R.string.vip_buy_sms);
    ((ViewGroup)this.bEd.bEF.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_only_click);
    a.b(this.bEd).setBackgroundResource(R.drawable.shape_rounded_rectangle_up_click);
    a.c(this.bEd).setText(R.string.vip_sms_type);
    ((ViewGroup)this.bEd.bEG.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_unupdown_click);
    ((EditText)this.bEd.bEG.dwQ.getView()).setTextColor(getResources().getColor(R.color.vip_sms_brown));
    ((EditText)this.bEd.bEG.dwQ.getView()).setBackgroundResource(R.drawable.selector_edit);
    ((TextView)this.bEd.bEG.cAO.getView()).setText(R.string.vip_promotion_sms_title);
    this.aVs = this.bEe.Ip();
    ((ViewGroup)this.bEd.bEH.getView()).setBackgroundResource(R.drawable.shape_rounded_rectangle_down_click);
    this.bEd.bEE.setMovementMethod(ScrollingMovementMethod.getInstance());
    fQ(0);
  }
  
  public void Em() {
    this.bEd.bzv.setVisibility(0);
    this.bEd.bEJ.setVisibility(8);
    this.bEd.bqN.setVisibility(8);
  }
  
  public void Sf() {
    try {
      int i;
      boolean bool = RootApplication.getLaiqianPreferenceManager().Wq();
      int k = 0;
      int j = 0;
      if (bool) {
        this.bEn = this.bEe.gb("");
        if (this.bEn.length() == 0) {
          i = 0;
        } else {
          int m;
          i = this.bEn.split(",").length;
        } 
        this.bEt = i;
        this.bEm = this.bEe.gb("1");
        if (this.bEm.length() == 0) {
          i = 0;
        } else {
          i = this.bEm.split(",").length;
        } 
        this.bEs = i;
        this.bEl = this.bEe.gb("2");
        if (this.bEl.length() == 0) {
          i = 0;
        } else {
          i = this.bEl.split(",").length;
        } 
        this.bEr = i;
        this.bEo = this.bEe.gb("3");
        if (this.bEo.length() == 0) {
          i = j;
        } else {
          i = this.bEo.split(",").length;
        } 
        this.bEp = i;
        return;
      } 
      Calendar calendar = Calendar.getInstance();
      String str2 = RootApplication.getLaiqianPreferenceManager().Tx();
      this.bEn = this.bEe.Sv();
      String str5 = TAG;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("initRecipient 所有的会员-->");
      stringBuilder2.append(this.bEn);
      Log.i(str5, stringBuilder2.toString());
      if (this.bEn.length() == 0) {
        i = 0;
      } else {
        i = this.bEn.split(",").length;
      } 
      this.bEt = i;
      long[] arrayOfLong2 = aW(calendar.get(1), calendar.get(2));
      this.bEm = this.bEe.a(arrayOfLong2[0], arrayOfLong2[1], 2, Integer.valueOf(str2).intValue());
      if (this.bEm.length() == 0) {
        i = 0;
      } else {
        i = this.bEm.split(",").length;
      } 
      this.bEs = i;
      String str4 = TAG;
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("initRecipient 近30天消费2次以上-->");
      stringBuilder2.append(this.bEm);
      Log.i(str4, stringBuilder2.toString());
      long[] arrayOfLong1 = i(calendar.get(1), calendar.get(2), 2);
      this.bEl = this.bEe.c(Integer.valueOf(str2).intValue(), arrayOfLong1[0], arrayOfLong1[1]);
      if (this.bEl.length() == 0) {
        i = 0;
      } else {
        i = this.bEl.split(",").length;
      } 
      this.bEr = i;
      String str3 = TAG;
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("initRecipient 近两个月未消费的-->");
      stringBuilder2.append(this.bEl);
      Log.i(str3, stringBuilder2.toString());
      this.bEo = this.bEe.aZ(calendar.get(2) + 1, Integer.valueOf(str2).intValue());
      if (this.bEo.length() == 0) {
        i = k;
      } else {
        i = this.bEo.split(",").length;
      } 
      this.bEp = i;
      String str1 = TAG;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("initRecipient 当月过生日的会员-->");
      stringBuilder1.append(this.bEo);
      Log.i(str1, stringBuilder1.toString());
      return;
    } catch (Exception exception) {
      a.e(exception);
      return;
    } 
  }
  
  public void Sj() {
    r r1 = new r(this, 3, new g(this));
    r1.setTitle(getString(R.string.sms_warning));
    r1.s(getString(R.string.vip_promotion_sms_send_success));
    r1.pa(getString(R.string.vip_promotion_sms_send_success_confirm));
    r1.show();
  }
  
  public void Sk() {
    r r1 = new r(this, true, new h(this));
    r1.setTitle(getString(R.string.sms_warning));
    r1.s(getString(R.string.vip_promotion_sms_send_faied));
    r1.oZ(getString(R.string.vip_promotion_sms_send_faied_return));
    r1.t(getString(R.string.vip_promotion_sms_send_faied_retry));
    r1.show();
  }
  
  public void Sl() {
    this.bEd.bqN.setVisibility(0);
    this.bEd.bzv.setVisibility(8);
    this.bEd.bEJ.setVisibility(8);
  }
  
  public void Sm() {
    this.bEd.bEK.setVisibility(8);
    this.bEd.bEI.setVisibility(0);
  }
  
  public void Sn() {
    this.bEd.bEK.setVisibility(0);
    this.bEd.bEI.setVisibility(8);
  }
  
  public void fS(int paramInt) {
    SpannableString spannableString = by.b(String.format(getResources().getString(R.string.vip_sms_quantity_left), new Object[] { Integer.valueOf(paramInt) }), String.valueOf(paramInt), 18, getResources().getColor(R.color.setting_text_color3));
    ((TextView)this.bEd.bEF.cAO.getView()).setText(spannableString);
  }
  
  public void hideProgress() {
    this.bEd.bzv.setVisibility(8);
    this.bEd.bEJ.setVisibility(0);
    this.bEd.bqN.setVisibility(8);
  }
  
  public void initView() {
    setupViews();
    Lk();
    RE();
    setListeners();
  }
  
  protected void onCreate(Bundle paramBundle) {
    getWindow().setSoftInputMode(3);
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.bEd = a.p(this);
    this.titleBar = aa.M(this);
    this.titleBar.tvTitle.setText(R.string.vip_sms_create);
    this.titleBar.brk.setVisibility(8);
    this.titleBar.brj.setVisibility(8);
    this.bEe = new t(this, this);
    this.bEe.init();
  }
  
  protected void onDestroy() {
    super.onDestroy();
    Ll();
  }
  
  protected void onResume() {
    super.onResume();
    if (!c.aYt().cK(this))
      c.aYt().cJ(this); 
  }
  
  protected void onStop() {
    super.onStop();
    if (c.aYt().cK(this))
      c.aYt().cL(this); 
  }
  
  @Subscribe(aYx = ThreadMode.MAIN)
  public void updateSMSQuantity(a parama) {
    fS(parama.Sz());
    this.bEe.fS(parama.Sz());
  }
  
  public void zO() {
    this.bEd.bqN.setVisibility(8);
    this.bEd.bzv.setVisibility(8);
    this.bEd.bEJ.setVisibility(0);
  }
  
  public class SmsReceiver extends BroadcastReceiver {
    public SmsReceiver(DiscountMarketActivity this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      int i = param1Intent.getIntExtra("SMS_QUANTITY_LEFT", 0);
      this.bED.fS(i);
      this.bED.bEe.fS(i);
    }
  }
  
  static class a extends ab<ViewGroup> {
    public static final int aCt = R.layout.activity_discount_market;
    
    public TextView bEE;
    
    public m bEF = new m(R.id.layout_sms);
    
    public h bEG = new h(R.id.layout_consume_limit);
    
    public m bEH = new m(R.id.layout_discount);
    
    public ProgressBarCircularIndeterminate bEI;
    
    public ViewGroup bEJ;
    
    public Button bEK;
    
    private final TextView bEL;
    
    private final TextView bEM;
    
    private final TextView bEN;
    
    private final Button bEO;
    
    private final View bEP;
    
    private TextView bEQ;
    
    private TextView bER;
    
    public ViewGroup bqN;
    
    public ViewGroup bzv;
    
    public a(int param1Int, View param1View) {
      super(param1Int);
      this.bEJ = (ViewGroup)s.z(param1View, R.id.llContent);
      this.bEI = (ProgressBarCircularIndeterminate)s.z(param1View, R.id.progress);
      this.bEE = (TextView)s.z(param1View, R.id.tv_sms_content);
      this.bqN = (ViewGroup)s.z(param1View, R.id.llRefresh);
      this.bzv = (ViewGroup)s.z(param1View, R.id.llProgress);
      this.bEK = (Button)s.z(param1View, R.id.btn_send);
      this.bEL = (TextView)s.z(param1View, R.id.tv_sms_length);
      this.bEM = (TextView)s.z(param1View, R.id.tv_sms_basic_content);
      this.bEN = (TextView)s.z(param1View, R.id.tv_sms_amount);
      this.bEO = (Button)s.z(param1View, R.id.bt_send_test);
      this.bEP = param1View.findViewById(R.id.layout_sms_type);
      this.bEQ = (TextView)this.bEP.findViewById(R.id.item_layout_tv_left);
      this.bER = (TextView)this.bEP.findViewById(R.id.item_layout_tv_center);
    }
    
    public static a p(Activity param1Activity) {
      View view = LayoutInflater.from(param1Activity).inflate(aCt, null);
      param1Activity.setContentView(view);
      a a1 = new a(16908290, view);
      a1.S(view);
      return a1;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\marketing\DiscountMarketActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */