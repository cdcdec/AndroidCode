package com.laiqian.print;

import android.content.Context;
import com.a.a.b;
import com.google.a.a.a.a.a.a;
import com.laiqian.f.b;
import com.laiqian.network.t;
import com.laiqian.util.am;
import com.laiqian.util.bb;
import com.laiqian.util.bd;
import io.reactivex.g.a;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class m {
  private String cCF = null;
  
  private String cCG = "printer.json";
  
  Context context;
  
  public m(Context paramContext) {
    this.context = paramContext;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("/data/data/");
    stringBuilder.append(paramContext.getPackageName());
    stringBuilder.append("/");
    stringBuilder.append(this.cCG);
    this.cCF = stringBuilder.toString();
  }
  
  public void aes() { a.aKh().r(new n(this)); }
  
  public void aet() {
    b b = new b(this.context);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("printer/");
    stringBuilder2.append(this.cCG);
    boolean bool = b.f("91laiqian-apk", stringBuilder2.toString(), this.cCF);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("升级是否成功");
    stringBuilder1.append(bool);
    bb.e("printer.json", stringBuilder1.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */