package com.laiqian.member.e;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.content.AsyncTaskLoader;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.aq;
import com.laiqian.entity.as;
import com.laiqian.models.l;
import com.laiqian.online.OnlineSyncRequest;
import com.laiqian.online.f;
import com.laiqian.pos.industry.a;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.a.d;
import com.laiqian.util.au;
import com.laiqian.util.av;
import com.laiqian.util.bh;
import com.laiqian.util.n;
import com.laiqian.vip.R;
import com.orhanobut.logger.d;
import java.util.HashMap;

public class a extends d {
  private TextView aNl;
  
  private LinearLayout bxl;
  
  private EditText bxo;
  
  private LinearLayout byd;
  
  private LinearLayout bye;
  
  private EditText byf;
  
  private CheckBox byg;
  
  private as byh;
  
  private TextView byi;
  
  private TextView byj;
  
  private a byk;
  
  View.OnClickListener byl = new d(this);
  
  private Context context;
  
  private aq vipEntity;
  
  private bb waitingDialog;
  
  public a(Context paramContext) {
    super(paramContext, R.layout.dialog_vip_password_layout);
    this.context = paramContext;
    setupViews();
    setListeners();
  }
  
  private void setListeners() {
    this.byg.setOnCheckedChangeListener(new b(this));
    this.byi.setOnClickListener(new c(this));
    this.byj.setOnClickListener(this.byl);
  }
  
  private void setupViews() {
    this.byg = (CheckBox)this.mView.findViewById(R.id.checkbox_password);
    this.byd = (LinearLayout)this.mView.findViewById(R.id.ll_password_switch);
    this.bxl = (LinearLayout)this.mView.findViewById(R.id.ll_vip_password);
    this.bye = (LinearLayout)this.mView.findViewById(R.id.ll_confirm_password);
    this.byf = (EditText)findViewById(R.id.et_vip_password);
    this.bxo = (EditText)findViewById(R.id.et_confirm_password);
    this.aNl = (TextView)findViewById(R.id.title);
    this.byi = (TextView)findViewById(R.id.canal);
    this.byj = (TextView)findViewById(R.id.sure);
  }
  
  public void a(as paramas, long paramLong, String paramString1, String paramString2, int paramInt, a parama) {
    this.byh = paramas;
    show();
    boolean bool = TextUtils.isEmpty(this.byh.password);
    byte b = 0;
    if (!bool) {
      byte b1;
      this.byg.setChecked(this.byh.isOpen);
      LinearLayout linearLayout = this.bxl;
      if (this.byh.isOpen) {
        b1 = 0;
      } else {
        b1 = 8;
      } 
      linearLayout.setVisibility(b1);
      linearLayout = this.bye;
      if (this.byh.isOpen) {
        b1 = b;
      } else {
        b1 = 8;
      } 
      linearLayout.setVisibility(b1);
      this.aNl.setText(R.string.edit_password);
    } else {
      this.byg.setChecked(true);
      this.bxl.setVisibility(0);
      this.bye.setVisibility(0);
      this.aNl.setText(R.string.vip_password_title);
    } 
    this.byf.setText("");
    this.bxo.setText("");
    this.vipEntity = new aq();
    this.vipEntity.aSW = paramLong;
    this.vipEntity.aWn = paramString1;
    this.vipEntity.aTp = paramString2;
    this.vipEntity.aWC = paramInt;
    this.byk = parama;
    this.byf.requestFocus();
  }
  
  public void zL() {
    if (this.waitingDialog == null) {
      this.waitingDialog = new bb(this.context);
      this.waitingDialog.setCancelable(false);
    } 
    this.waitingDialog.show();
  }
  
  public void zM() {
    if (this.waitingDialog != null)
      this.waitingDialog.dismiss(); 
  }
  
  public static interface a {
    void a(as param1as);
  }
  
  class b extends AsyncTask<as, Object, Boolean> {
    as aWH;
    
    String btw;
    
    b(a this$0) {}
    
    protected Boolean a(as[] param1ArrayOfas) {
      HashMap hashMap;
      this.aWH = param1ArrayOfas[0];
      if (RootApplication.getLaiqianPreferenceManager().Wq()) {
        HashMap hashMap1 = new HashMap();
        hashMap = new StringBuilder();
        hashMap.append((a.h(this.bym)).aSW);
        hashMap.append("");
        hashMap1.put("_id", hashMap.toString());
        hashMap1.put("sNumber", (a.h(this.bym)).aWn);
        hashMap1.put("sContactMobilePhone", (a.h(this.bym)).aTp);
        hashMap1.put("sSpareField3", this.aWH.IX());
        hashMap1.put("nUserID", RootApplication.getLaiqianPreferenceManager().atm());
        hashMap = new StringBuilder();
        hashMap.append((a.h(this.bym)).aWC);
        hashMap.append("");
        hashMap1.put("shop_id", hashMap.toString());
        hashMap1.put("user_name", RootApplication.getLaiqianPreferenceManager().Ea());
        hashMap1.put("password", RootApplication.getLaiqianPreferenceManager().atr());
        hashMap1.put("auth_type", "0");
        hashMap1.put("version", "1");
        if (RootApplication.getLaiqianPreferenceManager().avl()) {
          String str1 = "0";
        } else {
          String str1;
          hashMap = "1";
        } 
        hashMap1.put("scope", hashMap);
        hashMap = bh.a(a.cqy, RootApplication.zv().getApplicationContext(), hashMap1);
        if (!TextUtils.isEmpty(hashMap)) {
          hashMap = au.qB(hashMap);
          if (hashMap.containsKey("result") && "TRUE".equals(String.valueOf(hashMap.get("result")))) {
            Log.e("vipedit", String.valueOf(hashMap.get("message")));
            return Boolean.valueOf(true);
          } 
          if (hashMap.containsKey("result") && "FALSE".equals(String.valueOf(hashMap.get("result")))) {
            this.btw = String.valueOf(hashMap.get("message"));
            return Boolean.valueOf(false);
          } 
          this.btw = a.g(this.bym).getString(R.string.save_settings_failed);
          return Boolean.valueOf(false);
        } 
        this.btw = a.g(this.bym).getString(R.string.save_settings_failed);
        return Boolean.valueOf(false);
      } 
      l l = null;
      try {
        l l1 = new l(a.g(this.bym));
        l = l1;
      } catch (Exception exception) {
        a.e(exception);
      } 
      String str = hashMap[0].IX();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append((a.h(this.bym)).aSW);
      stringBuilder.append("");
      l.ad(str, stringBuilder.toString());
      l.close();
      return Boolean.valueOf(true);
    }
    
    protected void b(Boolean param1Boolean) {
      this.bym.zM();
      if (param1Boolean.booleanValue()) {
        if (!RootApplication.getLaiqianPreferenceManager().Wq()) {
          a a1;
          Context context = (a1 = this.bym).g(this.bym);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append((a.h(this.bym)).aSW);
          stringBuilder.append("");
          (new a.c(a1, context, stringBuilder.toString())).forceLoad();
        } 
        a.a(this.bym, this.aWH);
        if (a.i(this.bym) != null)
          a.i(this.bym).a(this.aWH); 
        n.eP(R.string.set_password_success);
      } else {
        Toast.makeText(a.g(this.bym), this.btw, 0).show();
      } 
      this.bym.dismiss();
    }
    
    protected void onPreExecute() { this.bym.zL(); }
  }
  
  private class c extends AsyncTaskLoader<Boolean> {
    private String btz;
    
    public c(a this$0, Context param1Context, String param1String) {
      super(param1Context);
      this.btz = param1String;
    }
    
    public Boolean LN() {
      OnlineSyncRequest.a a1 = new OnlineSyncRequest.a();
      try {
        exception = new l(getContext());
      } catch (Exception exception) {
        a.e(exception);
        exception = null;
      } 
      a1.a(exception.hd(this.btz), 2);
      exception.close();
      null = new av(getContext());
      a1.iM(null.Ea());
      a1.iN(null.atr());
      a1.bV(Long.parseLong(null.Tx()));
      null.close();
      f = f.bXQ;
      try {
        f.a(a1.Xj());
        return Boolean.valueOf(true);
      } catch (Exception f) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("请求实时同步失败");
        stringBuilder.append(f.getMessage());
        d.b(stringBuilder.toString(), new Object[0]);
        a.e(f);
        return Boolean.valueOf(false);
      } 
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */