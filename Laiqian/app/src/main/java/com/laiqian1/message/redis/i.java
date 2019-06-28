package com.laiqian.message.redis;

import com.laiqian.basic.RootApplication;
import com.laiqian.util.av;
import com.laiqian.util.by;
import java.util.HashMap;
import org.json.JSONException;

public class i {
  public static String z(HashMap<String, Object> paramHashMap) throws JSONException {
    av av = new av(RootApplication.zv());
    String str1 = av.Ea();
    String str2 = av.atr();
    String str3 = av.Tx();
    av.close();
    return (new MessageRequestParameter.a()).gF(str1).gG(str2).aG(by.parseLong(str3)).y(paramHashMap).Tz().IX();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\message\redis\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */