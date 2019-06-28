package com.laiqian.member.setting.marketing;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.i.d;
import com.laiqian.member.cc;
import com.laiqian.member.setting.bc;
import com.laiqian.member.setting.marketing.a.a;
import com.laiqian.member.setting.sms.b;
import com.laiqian.member.setting.sms.i;
import com.laiqian.member.setting.sms.k;
import com.laiqian.models.an;
import com.laiqian.models.l;
import com.laiqian.network.i;
import com.laiqian.network.k;
import com.laiqian.pos.industry.a;
import com.laiqian.util.cl;
import org.greenrobot.eventbus.c;
import org.json.JSONException;
import org.json.JSONObject;

public class t {
  public static final String TAG = "t";
  
  k bES;
  
  private v bET;
  
  private Context mContext;
  
  static  {
  
  }
  
  public t(Context paramContext, v paramv) {
    this.mContext = paramContext;
    this.bET = paramv;
  }
  
  public String Ip() {
    an an = new an(this.mContext);
    an.c c = an.Vu();
    an.close();
    return c.aVs;
  }
  
  public void RY() { this.bET.fS(this.bES.bGd); }
  
  public int Su() { return this.bES.bGd; }
  
  public String Sv() {
    try {
      exception = new l(this.mContext);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    String str = exception.US();
    exception.close();
    return str;
  }
  
  public String a(long paramLong1, long paramLong2, int paramInt1, int paramInt2) {
    l l = new l(this.mContext);
    String str = l.a(paramLong1, paramLong2, paramInt1, paramInt2);
    l.close();
    return str;
  }
  
  public void a(b paramb) { (new b(this, null)).execute(new b[] { paramb }); }
  
  public String aZ(int paramInt1, int paramInt2) {
    l l = new l(this.mContext);
    String str = l.aZ(paramInt1, paramInt2);
    l.close();
    return str;
  }
  
  public String c(int paramInt, long paramLong1, long paramLong2) {
    l l = new l(this.mContext);
    String str = l.c(paramInt, paramLong1, paramLong2);
    l.close();
    return str;
  }
  
  public void fS(int paramInt) { this.bES.bGd = paramInt; }
  
  public String gb(String paramString) throws Exception {
    null = RootApplication.getLaiqianPreferenceManager().Tx();
    String str2 = RootApplication.getLaiqianPreferenceManager().Ea();
    String str3 = RootApplication.getLaiqianPreferenceManager().atr();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(RootApplication.getLaiqianPreferenceManager().avm());
    stringBuilder2.append("");
    cc cc = new cc(null, str2, str3, "0", "1", stringBuilder2.toString(), "0", "nConsumeTime desc ", "%%", "0", paramString);
    null = TAG;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("getOnlieMemberDifferentType ");
    stringBuilder1.append(cc.toString());
    Log.i(null, stringBuilder1.toString());
    String str1 = d.ac(cc);
    i i = (new k()).c(str1.toString(), a.cqu, 1);
    if (i.bUi) {
      StringBuilder stringBuilder = new StringBuilder();
      str = new JSONObject(i.message);
      if (i.message.contains(",")) {
        for (String str : str.optString("phones").split(",")) {
          if (cl.sg(str)) {
            stringBuilder.append(str);
            stringBuilder.append(",");
          } 
        } 
        return TextUtils.isEmpty(stringBuilder.toString()) ? "" : stringBuilder.substring(0, stringBuilder.toString().lastIndexOf(","));
      } 
      return str.optString("phones");
    } 
    return "";
  }
  
  public void init() { (new a(this, null)).execute(new Void[0]); }
  
  private class a extends AsyncTask<Void, Void, Boolean> {
    private a(t this$0) {}
    
    protected void b(Boolean param1Boolean) {
      t.a(this.bEU).initView();
      try {
        t.a(this.bEU).hideProgress();
      } catch (Exception exception) {}
      if (param1Boolean.booleanValue()) {
        t.a(this.bEU).zO();
        this.bEU.RY();
        return;
      } 
      t.a(this.bEU).Sl();
      this.bEU.bES = new k();
      this.bEU.RY();
    }
    
    protected Boolean g(Void... param1VarArgs) {
      bc bc = bc.RH();
      this.bEU.bES = bc.RU();
      t.a(this.bEU).Sf();
      return (this.bEU.bES == null) ? Boolean.valueOf(false) : Boolean.valueOf(true);
    }
    
    protected void onPreExecute() { t.a(this.bEU).Em(); }
  }
  
  private class b extends AsyncTask<b, Void, String> {
    private b(t this$0) {}
    
    protected String a(b... param1VarArgs) { return (new i(t.b(this.bEU))).a(t.b(this.bEU), param1VarArgs[0]); }
    
    protected void bf(String param1String) {
      t.a(this.bEU).Sn();
      if (param1String != null)
        try {
          JSONObject jSONObject = new JSONObject(param1String);
          int i = jSONObject.optInt("nSMSQuantityLeft");
          if (!jSONObject.optBoolean("result")) {
            t.a(this.bEU).Sk();
            return;
          } 
          c.aYt().cM(new a(i));
          t.a(this.bEU).Sj();
          return;
        } catch (JSONException param1String) {
          a.e(param1String);
          t.a(this.bEU).Sk();
          return;
        }  
      t.a(this.bEU).Sk();
    }
    
    protected void onPreExecute() { t.a(this.bEU).Sm(); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\marketing\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */