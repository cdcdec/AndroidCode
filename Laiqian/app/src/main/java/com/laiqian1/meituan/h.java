package com.laiqian.meituan;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.laiqian.meituan.c.c;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class h {
  String[] aQT;
  
  a bpM;
  
  ArrayList<i> bpN;
  
  String bpO;
  
  String bpP;
  
  Context context;
  
  public h(Context paramContext, a parama) {
    this.bpM = parama;
    this.context = paramContext;
  }
  
  private void Pu() { (new a(this)).execute(new Void[0]); }
  
  public void a(String[] paramArrayOfString, String paramString, boolean paramBoolean) { (new c(this)).execute(new String[] { c.f(paramArrayOfString), (new String[3][1] = paramString).valueOf(paramBoolean) }); }
  
  public void fj(String paramString) { (new b(this)).execute(new String[] { paramString }); }
  
  public void fk(String paramString) { this.bpP = paramString; }
  
  public void init() { Pu(); }
  
  class a extends AsyncTask<Void, Void, HashMap<String, Object>> {
    a(h this$0) {}
    
    protected HashMap<String, Object> d(Void... param1VarArgs) { return g.az(this.bpQ.context); }
    
    protected void j(HashMap<String, Object> param1HashMap) {
      if (param1HashMap == null) {
        this.bpQ.bpM.En();
        return;
      } 
      if (!TextUtils.isEmpty(this.bpQ.bpP)) {
        this.bpQ.bpO = this.bpQ.bpP;
      } else {
        this.bpQ.bpO = String.valueOf(param1HashMap.get("token"));
      } 
      this.bpQ.aQT = String.valueOf(param1HashMap.get("sShopIds")).split(",");
      this.bpQ.fj(this.bpQ.bpO);
    }
  }
  
  class b extends AsyncTask<String, String, Integer> {
    b(h this$0) {}
    
    protected void e(Integer param1Integer) {
      if (param1Integer.intValue() == 1) {
        System.out.print(this.bpQ.bpN);
        Log.e("cacheShopList", this.bpQ.bpN.toString());
        if (this.bpQ.aQT == null) {
          this.bpQ.aQT = g.C(this.bpQ.bpN);
        } else {
          this.bpQ.bpM.d(this.bpQ.bpN, this.bpQ.aQT);
        } 
        this.bpQ.a(this.bpQ.aQT, this.bpQ.bpO, true);
        this.bpQ.bpM.B(this.bpQ.bpN);
        return;
      } 
      if (param1Integer.intValue() == 3) {
        Toast.makeText(this.bpQ.context, "暂无店铺", 0).show();
        return;
      } 
      if (param1Integer.intValue() == 4 || param1Integer.intValue() == 5) {
        Toast.makeText(this.bpQ.context, "系统出错,请联系客服", 0).show();
        return;
      } 
      if (param1Integer.intValue() == 2) {
        Toast.makeText(this.bpQ.context, "授权过期,请进入授权管理重新授权,", 0).show();
        return;
      } 
    }
    
    protected Integer i(String... param1VarArgs) {
      byte b1 = 0;
      str = g.b(param1VarArgs[0], this.bpQ.context);
      if (!TextUtils.isEmpty(str))
        try {
          this.bpQ.bpN = null;
          null = new JSONObject(str);
          if (null.has("error"))
            return "4001".equals(null.getJSONObject("error").getString("code")) ? Integer.valueOf(2) : Integer.valueOf(5); 
          JSONArray jSONArray = null.getJSONArray("data");
          if (jSONArray.length() > 0) {
            this.bpQ.bpN = new ArrayList();
            while (b1 < jSONArray.length()) {
              i i = new i();
              i.bpR = jSONArray.getJSONObject(b1).optString("app_poi_code");
              i.name = jSONArray.getJSONObject(b1).optString("name");
              i.bpS = jSONArray.getJSONObject(b1).optInt("open_level");
              i.bpT = jSONArray.getJSONObject(b1).optInt("is_online");
              this.bpQ.bpN.add(i);
              b1++;
            } 
            return Integer.valueOf(1);
          } 
          return Integer.valueOf(3);
        } catch (Exception str) {
          return Integer.valueOf(4);
        }  
      return Integer.valueOf(4);
    }
  }
  
  class c extends AsyncTask<String, String, Boolean> {
    String aQX;
    
    boolean aQY;
    
    c(h this$0) {}
    
    protected void b(Boolean param1Boolean) {
      if (param1Boolean.booleanValue()) {
        if (this.aQY) {
          this.bpQ.bpM.d(this.bpQ.bpN, this.aQX.split(","));
          return;
        } 
        this.bpQ.bpM.b(this.aQX.split(","), true);
        return;
      } 
      if (this.aQY) {
        this.bpQ.bpM.d(this.bpQ.bpN, null);
      } else {
        this.bpQ.bpM.b(this.aQX.split(","), false);
      } 
      Toast.makeText(this.bpQ.context, "保存失败", 0).show();
    }
    
    protected Boolean e(String... param1VarArgs) {
      this.aQX = param1VarArgs[0];
      this.aQY = Boolean.valueOf(param1VarArgs[2]).booleanValue();
      return g.a(param1VarArgs[0], param1VarArgs[1], this.bpQ.context);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */