package com.laiqian.member.bill;

import android.content.Context;
import android.content.Intent;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.ui.webview.SimpleWebViewActivity;
import com.laiqian.util.bd;
import com.laiqian.util.n;
import com.laiqian.vip.R;
import org.json.JSONObject;

public class MemberBillActivity extends SimpleWebViewActivity {
  public static void start(Context paramContext, String paramString) {
    Intent intent = new Intent(paramContext, MemberBillActivity.class);
    intent.putExtra("member_id", paramString);
    paramContext.startActivity(intent);
  }
  
  protected String zG() { return getString(R.string.member_bill); }
  
  protected String zH() {
    str1 = getIntent().getStringExtra("member_id");
    String str2 = RootUrlParameter.ckG;
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("shop_id", RootApplication.getLaiqianPreferenceManager().Tx());
      jSONObject.put("bpartner_id", str1);
      if (n.bL(RootApplication.zv())) {
        str1 = "zh-CN";
      } else {
        str1 = "en";
      } 
      jSONObject.put("language", str1);
    } catch (Exception str1) {
      a.e(str1);
    } 
    return bd.b(str2, jSONObject);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\bill\MemberBillActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */