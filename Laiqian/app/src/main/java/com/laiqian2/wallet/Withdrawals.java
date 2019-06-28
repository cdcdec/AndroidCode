package com.laiqian.wallet;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.laiqian.basic.RootApplication;
import com.laiqian.f.b;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.util.ar;
import com.laiqian.util.av;
import com.laiqian.util.bd;
import com.laiqian.util.m;
import com.laiqian.util.n;
import org.json.JSONObject;

public class Withdrawals extends ActivityRoot {
  private final int SUCCESS = 1;
  
  private TextView aFy;
  
  private av aIP;
  
  private final int dKU = 3;
  
  private final int dKV = -3;
  
  private final int dKW = 2;
  
  private final int dKX = -2;
  
  private View dLA;
  
  private View dLB;
  
  private TextView dLC;
  
  private TextView dLD;
  
  private TextView dLE;
  
  private Button dLF;
  
  private final int dLG = -1;
  
  private TextView dLh;
  
  private TextView dLs;
  
  private TextView dLt;
  
  private EditText dLu;
  
  private View dLv;
  
  private View dLw;
  
  private View dLx;
  
  private TextView dLy;
  
  private String dLz;
  
  private Handler handler = new w(this);
  
  private void axD() { (new v(this)).start(); }
  
  private void axE() { (new p(this)).start(); }
  
  public static JSONObject bl(double paramDouble) throws Exception {
    byte b = 0;
    while (b < 2) {
      JSONObject jSONObject;
      String str2;
      try {
        String str3 = k.h(true, null);
        String str4 = RootApplication.zv().getLaiqianPreferenceManager().Tx();
        str2 = RootUrlParameter.cms;
        jSONObject = new JSONObject();
        jSONObject.put("shop_id", str4);
        jSONObject.put("user_name", RootApplication.getLaiqianPreferenceManager().Ea());
        jSONObject.put("password", RootApplication.getLaiqianPreferenceManager().auN());
        jSONObject.put("token", str3);
        jSONObject.put("amount", paramDouble);
        jSONObject.put("auth_type", 0);
        jSONObject.put("version", 1.0D);
        jSONObject.put("flavor", "");
        if (n.bL(RootApplication.zv().zv())) {
          str3 = "zh-CN";
          jSONObject.put("language", str3);
          return new JSONObject(b.cM(bd.c(str2, bd.u(jSONObject))));
        } 
      } catch (h h) {
        throw h;
      } catch (Exception exception) {
        if (b)
          throw exception; 
        b++;
        continue;
      } 
      String str1 = "en";
      jSONObject.put("language", str1);
      return new JSONObject(b.cM(bd.c(str2, bd.u(jSONObject))));
    } 
    throw new h("获取信息失败");
  }
  
  private void initData() {
    this.dLE.setText(this.aIP.auP());
    String str = this.aIP.auQ().replaceAll("(.{4})", "$1 ");
    this.dLC.setText(str);
    this.dLD.setText(this.aIP.auO());
    this.dLh.setText(this.aIP.auR());
  }
  
  private void su(String paramString) {
    this.dLu.setText(paramString);
    this.dLu.setSelection(this.dLu.length());
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(R.layout.pos_wallet_withdrawals);
    getWindow().setFeatureInt(7, R.layout.pos_title);
    setTitleTextView(R.string.pos_wallet_reflect);
    this.dLs = setTitleTextViewRight(R.string.pos_wallet_reflect_record, new m.c(this, (new Intent(this, WalletRecord.class)).putExtra("isTransaction", false)));
    this.aIP = new av(this);
    this.dLA = findViewById(R.id.binding_account_l);
    this.dLB = this.dLA.findViewById(R.id.binding_account);
    o o = new o(this);
    this.dLB.setOnClickListener(o);
    this.dLE = (TextView)findViewById(R.id.name);
    this.dLC = (TextView)findViewById(R.id.account);
    this.dLh = (TextView)findViewById(R.id.balance);
    this.dLD = (TextView)findViewById(R.id.account_bank);
    this.dLF = (Button)findViewById(R.id.pick_up_all);
    this.dLt = (TextView)findViewById(R.id.max);
    this.dLu = (EditText)findViewById(R.id.amount);
    this.dLu.addTextChangedListener(new q(this));
    this.dLu.setFilters(ar.bE(9999, 2));
    this.aFy = (TextView)findViewById(R.id.password);
    this.aFy.addTextChangedListener(new s(this));
    this.dLy = (TextView)findViewById(R.id.wallet_fail);
    this.dLv = findViewById(R.id.reflect);
    this.dLv.setEnabled(false);
    this.dLw = this.dLv.findViewById(R.id.reflect_stand);
    this.dLx = this.dLv.findViewById(R.id.reflectiong);
    this.dLv.setOnClickListener(new t(this));
    this.dLF.setOnClickListener(new u(this));
    findViewById(R.id.replace).setOnClickListener(o);
  }
  
  protected void onStart() {
    super.onStart();
    String[] arrayOfString = this.aIP.auS();
    if (arrayOfString[3] != null)
      "null".equals(arrayOfString[3]); 
    this.dLA.setVisibility(8);
    this.dLs.setVisibility(0);
    initData();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\wallet\Withdrawals.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */