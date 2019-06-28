package com.laiqian.repair;

import com.google.a.a.a.a.a.a;
import com.laiqian.basic.LQKVersion;
import com.laiqian.basic.RootApplication;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.util.bd;
import com.laiqian.util.n;
import java.util.ArrayList;
import org.json.JSONArray;

public class b extends a {
  public b(ActivityRoot paramActivityRoot, e parame) { super(paramActivityRoot, parame); }
  
  public static ArrayList<e> ne(String paramString) throws Exception {
    null = new StringBuilder();
    null.append(RootUrlParameter.clQ);
    null.append("?projectType=");
    null.append(LQKVersion.zn());
    null.append("&keyword=");
    null.append(paramString);
    null.append("&language=");
    null.append(n.bM(RootApplication.zv()));
    JSONArray jSONArray = new JSONArray(bd.rV(null.toString()));
    ArrayList arrayList = new ArrayList();
    for (byte b1 = 0; b1 < jSONArray.length(); b1++)
      arrayList.add(new e(jSONArray.getJSONObject(b1))); 
    return arrayList;
  }
  
  protected void a(e parame, boolean paramBoolean) { (new a(this, parame, paramBoolean, null)).start(); }
  
  private class a extends Thread {
    private e cXS;
    
    private boolean cyx;
    
    private a(b this$0, e param1e, boolean param1Boolean) {
      this.cXS = param1e;
      this.cyx = param1Boolean;
    }
    
    public void run() {
      super.run();
      StringBuilder stringBuilder1 = new StringBuilder(RootUrlParameter.clT);
      str = new StringBuilder();
      str.append("?id=");
      str.append(this.cXS.id);
      stringBuilder1.append(str.toString());
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("&suc=");
      if (this.cyx) {
        String str1 = "1";
      } else {
        str = "0";
      } 
      stringBuilder2.append(str);
      stringBuilder1.append(stringBuilder2.toString());
      try {
        str = bd.rV(stringBuilder1.toString());
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("执行完修复后，反馈给服务器之后的返回值：");
        stringBuilder1.append(str);
        n.println(stringBuilder1.toString());
        return;
      } catch (Exception str) {
        a.e(str);
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("执行完修复后，反馈给服务器时出错：");
        stringBuilder1.append(str.getMessage());
        n.println(stringBuilder1.toString());
        return;
      } 
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repair\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */