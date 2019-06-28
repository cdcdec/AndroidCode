package com.laiqian.eleme;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class i {
  String[] aQT;
  
  ArrayList<j> aQU = new ArrayList();
  
  k aQV;
  
  Context context;
  
  public i(Context paramContext, k paramk) {
    this.aQV = paramk;
    this.context = paramContext;
  }
  
  public void Ep() { (new a(this)).execute(new Void[0]); }
  
  public void c(String[] paramArrayOfString, boolean paramBoolean) { (new c(this)).execute(new String[] { null, (new String[2][0] = l.f(paramArrayOfString)).valueOf(paramBoolean) }); }
  
  public void init() { (new b(this)).execute(new Void[0]); }
  
  class a extends AsyncTask<Void, Void, String> {
    a(i this$0) {}
    
    protected String b(Void... param1VarArgs) { return h.ag(this.aQW.context); }
    
    protected void bf(String param1String) {
      this.aQW.aQV.Eo();
      try {
        JSONObject jSONObject = new JSONObject(param1String);
        if (!TextUtils.isEmpty(jSONObject.optString("auth_url"))) {
          this.aQW.aQV.cK(jSONObject.optString("auth_url"));
          return;
        } 
        Toast.makeText(this.aQW.context, "获取授权网页失败", 0).show();
        return;
      } catch (JSONException param1String) {
        a.e(param1String);
        Toast.makeText(this.aQW.context, "获取授权网页失败", 0).show();
        return;
      } 
    }
    
    protected void onPreExecute() {
      this.aQW.aQV.Em();
      super.onPreExecute();
    }
  }
  
  class b extends AsyncTask<Void, Void, HashMap<String, Object>> {
    b(i this$0) {}
    
    protected HashMap<String, Object> d(Void... param1VarArgs) { return h.af(this.aQW.context); }
    
    protected void j(HashMap<String, Object> param1HashMap) {
      this.aQW.aQV.hideProgress();
      if (param1HashMap == null) {
        this.aQW.aQV.El();
        n.o("获取店铺信息失败");
        return;
      } 
      if (param1HashMap.containsKey("msg_no") && "10000".equals(String.valueOf(param1HashMap.get("msg_no"))))
        try {
          this.aQW.aQT = String.valueOf(param1HashMap.get("pushShops")).split(",");
          JSONArray jSONArray = new JSONArray(String.valueOf(param1HashMap.get("authorizedShops")));
          this.aQW.aQU = new ArrayList();
          for (byte b1 = 0; b1 < jSONArray.length(); b1++) {
            JSONObject jSONObject = new JSONObject(jSONArray.getString(b1));
            j j = new j();
            j.aQZ = jSONObject.optInt("isOpen");
            j.name = jSONObject.optString("name");
            j.id = jSONObject.optString("id");
            this.aQW.aQU.add(j);
          } 
          this.aQW.aQV.a(this.aQW.aQU, this.aQW.aQT);
          return;
        } catch (JSONException param1HashMap) {
          a.e(param1HashMap);
          n.o(this.aQW.context.getString(R.string.get_eleme_shop_fail));
          return;
        }  
      if (param1HashMap.containsKey("msg_no") && "40004".equals(String.valueOf(param1HashMap.get("msg_no")))) {
        String str = String.valueOf(param1HashMap.get("url"));
        this.aQW.aQV.cJ(str);
        return;
      } 
      n.o(this.aQW.context.getString(R.string.get_eleme_shop_fail));
    }
    
    protected void onPreExecute() {
      super.onPreExecute();
      this.aQW.aQV.Em();
    }
  }
  
  class c extends AsyncTask<String, String, Boolean> {
    String aQX;
    
    boolean aQY;
    
    c(i this$0) {}
    
    protected void b(Boolean param1Boolean) {
      if (param1Boolean.booleanValue()) {
        if (this.aQY) {
          this.aQW.aQV.a(this.aQW.aQU, this.aQX.split(","));
          return;
        } 
        this.aQW.aQV.b(this.aQX.split(","), true);
        return;
      } 
      if (this.aQY) {
        this.aQW.aQV.a(this.aQW.aQU, null);
      } else {
        this.aQW.aQV.b(this.aQX.split(","), false);
      } 
      Toast.makeText(this.aQW.context, "保存失败", 0).show();
    }
    
    protected Boolean e(String... param1VarArgs) {
      this.aQX = param1VarArgs[0];
      this.aQY = Boolean.valueOf(param1VarArgs[1]).booleanValue();
      return h.a(param1VarArgs[0], this.aQW.context);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\eleme\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */