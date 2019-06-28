package com.laiqian.opentable.common;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.util.av;
import com.laiqian.util.bh;
import java.util.HashMap;
import org.json.JSONObject;

public class ag extends AsyncTask<Void, Void, Boolean> {
  a bZp;
  
  public boolean XU() {
    av av = new av(RootApplication.zv());
    str1 = av.Ea();
    String str2 = av.atr();
    String str3 = av.Tx();
    av.close();
    HashMap hashMap = new HashMap();
    hashMap.put("user_name", str1);
    hashMap.put("password", str2);
    hashMap.put("auth_type", "0");
    hashMap.put("shop_id", str3);
    hashMap.put("version", "1");
    hashMap.put("lqk_config", a.AZ().BM());
    str1 = bh.a(RootUrlParameter.clO, RootApplication.zv(), hashMap);
    if (!TextUtils.isEmpty(str1))
      try {
        boolean bool = "true".equals((new JSONObject(str1)).optString("result", "false"));
        return bool;
      } catch (Exception str1) {
        return false;
      }  
    return false;
  }
  
  public void a(a parama) { this.bZp = parama; }
  
  protected void b(Boolean paramBoolean) {
    if (this.bZp != null)
      this.bZp.db(paramBoolean.booleanValue()); 
  }
  
  protected Boolean g(Void... paramVarArgs) { return XU() ? Boolean.valueOf(true) : Boolean.valueOf(false); }
  
  protected void onPreExecute() {}
  
  public static interface a {
    void db(boolean param1Boolean);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */