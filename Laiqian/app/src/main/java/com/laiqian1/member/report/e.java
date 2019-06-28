package com.laiqian.member.report;

import android.content.Context;
import com.laiqian.vip.R;
import java.util.HashMap;
import java.util.Map;

public class e {
  Map<String, String> byZ;
  
  Map<String, String> bza;
  
  Context context;
  
  public e(Context paramContext) {
    this.context = paramContext;
    init();
    QU();
  }
  
  public void QU() {
    this.byZ = new HashMap();
    this.byZ.put("10001", this.context.getString(R.string.pos_child_type_cash));
    this.byZ.put("10002", this.context.getString(R.string.pos_child_type_bank));
    this.byZ.put("10006", this.context.getString(R.string.pos_child_type_member_consumption));
    this.byZ.put("10007", this.context.getString(R.string.pos_child_type_merchant_Alipay));
    this.byZ.put("10008", this.context.getString(R.string.pos_child_type_store_coupons));
    this.byZ.put("10009", this.context.getString(R.string.pos_child_type_merchant_WeChat));
    this.byZ.put("10010", this.context.getString(R.string.pos_child_type_meitua_golden_ticket));
    this.byZ.put("10011", this.context.getString(R.string.pos_child_type_public_comment_vouchers));
    this.byZ.put("10012", this.context.getString(R.string.pos_child_type_Wallet));
    this.byZ.put("10013", this.context.getString(R.string.pos_child_type_custom_pay));
  }
  
  public String fK(String paramString) { return (String)this.byZ.get(paramString); }
  
  public String fL(String paramString) { return (String)this.bza.get(paramString); }
  
  public void init() {
    this.bza = new HashMap();
    this.bza.put("0", this.context.getString(R.string.pos_vip_all_type_tltle));
    this.bza.put("370004", this.context.getString(R.string.pos_vip_charge_title));
    this.bza.put("370005", this.context.getString(R.string.pos_vip_consume_title));
    this.bza.put("370007", this.context.getString(R.string.pos_vip_change_amount_title));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\report\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */