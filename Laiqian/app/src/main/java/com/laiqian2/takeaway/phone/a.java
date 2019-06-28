package com.laiqian.takeaway.phone;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.entity.y;
import com.laiqian.milestone.h;
import com.laiqian.models.l;
import com.laiqian.online.OnlineSyncRequest;
import com.laiqian.online.f;
import com.laiqian.util.av;
import com.orhanobut.logger.d;
import java.util.ArrayList;

public class a {
  private boolean btd;
  
  private Context context;
  
  private y duy;
  
  private b duz;
  
  public a(Context paramContext) { this.context = paramContext; }
  
  public a(Context paramContext, y paramy, boolean paramBoolean, b paramb) {
    this.context = paramContext;
    this.duy = paramy;
    this.btd = paramBoolean;
    this.duz = paramb;
  }
  
  private boolean aqG() {
    h h = new h(this.context);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.duy.aSW);
    stringBuilder1.append("");
    String str1 = stringBuilder1.toString();
    String str2 = this.duy.aTp;
    String str3 = this.duy.name;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.duy.aRw);
    stringBuilder2.append("");
    boolean bool = h.b(str1, str2, str3, stringBuilder2.toString(), this.duy.aRu, this.duy.address, this.duy.aTq, this.duy.birthday);
    h.close();
    return bool;
  }
  
  public void aZ(String paramString1, String paramString2) { (new a(this, this.context, paramString1, paramString2)).forceLoad(); }
  
  public void save() {
    if (!aqG())
      return; 
    Context context1 = this.context;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.duy.aSW);
    stringBuilder.append("");
    (new a(this, context1, stringBuilder.toString())).forceLoad();
    this.duz.aqH();
    Toast.makeText(this.context, this.context.getString(2131626332), 0).show();
  }
  
  private class a extends AsyncTaskLoader<Boolean> {
    private String btA;
    
    private String btz;
    
    public a(a this$0, Context param1Context, String param1String) {
      super(param1Context);
      this.btz = param1String;
    }
    
    public a(a this$0, Context param1Context, String param1String1, String param1String2) {
      super(param1Context);
      this.btz = param1String1;
      this.btA = param1String2;
    }
    
    public Boolean LN() {
      a1 = new OnlineSyncRequest.a();
      null = new l(getContext());
      ArrayList arrayList = null.hd(this.btz);
      if (a.a(this.duA)) {
        a1.a(arrayList, 3);
      } else {
        a1.a(arrayList, 2);
      } 
      null.close();
      null = new av(getContext());
      a1.iM(null.Ea());
      a1.iN(null.atr());
      a1.bV(Long.parseLong(null.Tx()));
      null.close();
      f f = f.bXQ;
      try {
        f.a(a1.Xj());
        return Boolean.valueOf(true);
      } catch (Exception a1) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("实时同步失败");
        stringBuilder.append(a1.getMessage());
        d.b(stringBuilder.toString(), new Object[0]);
        a.e(a1);
        return Boolean.valueOf(false);
      } 
    }
  }
  
  public static interface b {
    void aqH();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\phone\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */