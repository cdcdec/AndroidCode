package com.laiqian.entity;

import android.content.Context;
import android.support.annotation.Nullable;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.d.a;
import com.laiqian.infrastructure.R;
import com.laiqian.models.l;
import com.laiqian.ui.a.g;
import java.io.PrintStream;

public class v implements g.b {
  public static final v aTf = new v(0L, "", false, false);
  
  public long aSW;
  
  public int aSX;
  
  public boolean aSY;
  
  public boolean aSZ;
  
  public int aTa;
  
  public int aTb;
  
  public int aTc;
  
  public String aTd;
  
  public long aTe;
  
  public String name;
  
  public v(long paramLong, String paramString, int paramInt, boolean paramBoolean) {
    this.aSW = paramLong;
    this.name = paramString;
    this.aSX = paramInt;
    this.aSY = paramBoolean;
    this.aSZ = paramBoolean;
  }
  
  public static v FS() { return new v(14L, RootApplication.zv().getString(R.string.pos_paytype_other_coupon_mt), '✚', RootApplication.getLaiqianPreferenceManager().auK()); }
  
  public static v FT() { return new v(15L, RootApplication.zv().getString(R.string.pos_paytype_other_coupon_dzdp), '✛', RootApplication.getLaiqianPreferenceManager().auL()); }
  
  public static v FU() { return new v(12L, RootApplication.zv().getString(R.string.pos_paytype_other_coupon_dp), '✘', RootApplication.getLaiqianPreferenceManager().auM()); }
  
  public static v FV() { return new v(1L, RootApplication.zv().getString(R.string.pos_report_transaction_pay_mode_cash), '✑', RootApplication.getLaiqianPreferenceManager().auJ()); }
  
  public static v FW() { return new v(13L, RootApplication.zv().getString(R.string.pos_paytype_wechat), '✙', RootApplication.getLaiqianPreferenceManager().auI()); }
  
  public static v FX() { return new v(11L, RootApplication.zv().getString(R.string.pos_paytype_alipay), '✗', RootApplication.getLaiqianPreferenceManager().auG()); }
  
  public static v FY() { return new v(10L, RootApplication.zv().getString(R.string.pos_paytype_vip), '✖', RootApplication.getLaiqianPreferenceManager().auH()); }
  
  public static v FZ() { return new v(16L, RootApplication.zv().getString(R.string.pos_paytype_group), '✞', true); }
  
  public static boolean a(v paramv) { return (paramv.aSW == 0L); }
  
  public static String ao(long paramLong) {
    PrintStream printStream = System.out;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("current paytype is:");
    stringBuilder.append(paramLong);
    printStream.println(stringBuilder.toString());
    return (paramLong == 10001L) ? "Cash" : ((paramLong == 0L) ? "Cash" : ((paramLong == 10006L) ? "CashCard" : "Others"));
  }
  
  public static String ap(long paramLong) { return (paramLong == 10001L) ? RootApplication.zv().getString(R.string.pos_report_transaction_pay_mode_cash) : ((paramLong == 10006L) ? RootApplication.zv().getString(R.string.pos_paytype_vip) : ((paramLong == 10007L) ? RootApplication.zv().getString(R.string.pos_paytype_alipay) : ((paramLong == 10008L) ? RootApplication.zv().getString(R.string.pos_paytype_other_coupon_dp) : ((paramLong == 10009L) ? RootApplication.zv().getString(R.string.pos_paytype_wechat) : ((paramLong == 10010L) ? RootApplication.zv().getString(R.string.pos_paytype_other_coupon_mt) : ((paramLong == 10011L) ? RootApplication.zv().getString(R.string.pos_paytype_other_coupon_dzdp) : "")))))); }
  
  public long AR() { return (this.aSX == 10013) ? this.aSW : this.aSX; }
  
  public CharSequence AS() { return this.name; }
  
  public CharSequence AT() { return this.name; }
  
  public boolean FQ() { return (10013 == this.aSX); }
  
  public boolean FR() {
    this.aSZ ^= true;
    return this.aSZ;
  }
  
  public void Ga() {
    if (this.aSX == 10010) {
      RootApplication.getLaiqianPreferenceManager().hE(this.aSZ);
      return;
    } 
    if (this.aSX == 10011) {
      RootApplication.getLaiqianPreferenceManager().hF(this.aSZ);
      return;
    } 
    if (this.aSX == 10008)
      RootApplication.getLaiqianPreferenceManager().hG(this.aSZ); 
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("支付类型：");
    stringBuilder.append(this.aSX);
    stringBuilder.append(",具体类型：");
    stringBuilder.append(this.aSW);
    return stringBuilder.toString();
  }
  
  public boolean xB() { return (this.aSY != this.aSZ); }
  
  public static class a {
    private Context aTg;
    
    boolean aTh;
    
    private boolean aTi;
    
    private boolean aTj;
    
    private boolean aTk;
    
    private boolean isSaleOrder;
    
    public a(Context param1Context, boolean param1Boolean) {
      this.aTg = param1Context;
      this.isSaleOrder = param1Boolean;
      this.aTh = param1Context.getResources().getBoolean(R.bool.pos_switch_alipay);
      this.aTi = param1Context.getResources().getBoolean(R.bool.pos_switch_wechar);
      this.aTj = param1Context.getResources().getBoolean(R.bool.pos_switch_meituandazhongdianping);
      this.aTk = a.zR().At();
    }
    
    private String getString(int param1Int) { return this.aTg.getString(param1Int); }
    
    public v Gb() {
      String str;
      v v = v.FV();
      v.aTb = R.drawable.bg_cash_image;
      v.aTc = R.string.pos_main_pay_finish;
      if (this.isSaleOrder) {
        str = getString(R.string.pos_pay_amount_paid);
      } else {
        str = getString(R.string.sales_return_create_OrderReceivedLabel);
      } 
      v.aTd = str;
      return v;
    }
    
    @Nullable
    public v Gc() {
      v v = v.FY();
      v.aTb = R.drawable.bg_member_image;
      v.aTc = R.string.pos_main_pay_finish;
      boolean bool2 = RootApplication.getLaiqianPreferenceManager().isMultipleShop();
      boolean bool1 = bool2;
      if (!bool2) {
        l l = new l(this.aTg);
        if ((int)l.UT()[0] > 0) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        l.close();
      } 
      if (bool1) {
        int i;
        if (this.isSaleOrder) {
          i = R.string.pos_pay_member_pay;
        } else {
          i = R.string.pos_pay_balance_refund;
        } 
        v.aTd = getString(i);
        return v;
      } 
      return null;
    }
    
    @Nullable
    public v Gd() { return cK(false); }
    
    @Nullable
    public v Ge() { return cL(false); }
    
    @Nullable
    public v Gf() { return cM(false); }
    
    @Nullable
    public v Gg() {
      if (!this.isSaleOrder || !a.AZ().BJ() || a.zR().Af())
        return null; 
      v v = v.FZ();
      v.aTb = R.drawable.bg_group_image;
      v.aTc = R.string.pos_paytype_group_verification_click;
      v.aTd = getString(R.string.pos_paytype_group_amount);
      return v;
    }
    
    @Nullable
    public v Gh() {
      if (this.isSaleOrder) {
        if (!this.aTj)
          return null; 
        v v = v.FS();
        if (!v.aSZ)
          return null; 
        v.aTb = R.drawable.bg_mt_image;
        v.aTc = R.string.pos_main_pay_finish;
        v.aTd = getString(R.string.pos_pay_coupons_lable);
        return v;
      } 
      return null;
    }
    
    @Nullable
    public v Gi() {
      if (this.isSaleOrder) {
        if (!this.aTj)
          return null; 
        v v = v.FT();
        if (!v.aSZ)
          return null; 
        v.aTb = R.drawable.bg_dzdp_image;
        v.aTc = R.string.pos_main_pay_finish;
        v.aTd = getString(R.string.pos_pay_coupons_lable);
        return v;
      } 
      return null;
    }
    
    @Nullable
    public v Gj() {
      if (!this.isSaleOrder)
        return null; 
      v v = v.FU();
      if (!v.aSZ)
        return null; 
      v.aTb = R.drawable.bg_coupons_image;
      v.aTc = R.string.pos_main_pay_finish;
      v.aTd = getString(R.string.pos_pay_coupons_lable);
      return v;
    }
    
    @Nullable
    public v cK(boolean param1Boolean) {
      if (!this.aTk)
        return null; 
      if (!param1Boolean && !this.isSaleOrder)
        return null; 
      v v = v.FW();
      v.aTb = R.drawable.bg_fubei_image;
      v.aTe = a.AZ().Bq();
      v.aTd = getString(R.string.version_title_comprehensive);
      v.name = getString(R.string.version_title_comprehensive);
      if (v.aTe == 8L) {
        v.aTc = R.string.pos_main_pay_finish_scan_click;
        return v;
      } 
      if (v.aTe == 5L) {
        v.aTc = R.string.pos_main_pay_finish_scan_click;
        return v;
      } 
      v.aTc = R.string.pos_main_pay_finish;
      return v;
    }
    
    @Nullable
    public v cL(boolean param1Boolean) {
      long l;
      if (!this.aTh)
        return null; 
      if (!param1Boolean && !this.isSaleOrder)
        return null; 
      v v = v.FX();
      v.aTb = R.drawable.bg_alipay_image;
      if (param1Boolean) {
        l = 2L;
      } else {
        l = a.AZ().Bo();
      } 
      v.aTe = l;
      v.aTd = v.name;
      if (v.aTe == 0L) {
        v.aTc = R.string.pos_main_pay_finish_scan_click;
        return v;
      } 
      if (v.aTe == 1L) {
        v.aTc = R.string.pos_main_pay_finish_scan_click;
        return v;
      } 
      v.aTc = R.string.pos_main_pay_finish;
      return v;
    }
    
    @Nullable
    public v cM(boolean param1Boolean) {
      long l;
      if (!this.aTh)
        return null; 
      if (!param1Boolean && !this.isSaleOrder)
        return null; 
      v v = v.FW();
      v.aTb = R.drawable.bg_weixin_image;
      if (param1Boolean) {
        l = 7L;
      } else {
        l = a.AZ().Bq();
      } 
      v.aTe = l;
      v.aTd = v.name;
      if (v.aTe == 8L) {
        v.aTc = R.string.pos_main_pay_finish_scan_click;
        return v;
      } 
      if (v.aTe == 5L) {
        v.aTc = R.string.pos_main_pay_finish_scan_click;
        return v;
      } 
      v.aTc = R.string.pos_main_pay_finish;
      return v;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */