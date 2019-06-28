package com.laiqian.rx.b;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.widget.EditText;
import com.jakewharton.b.b;
import com.laiqian.util.n;
import io.reactivex.a.b;
import io.reactivex.android.b.a;
import io.reactivex.c.g;
import io.reactivex.c.h;
import io.reactivex.g.a;
import io.reactivex.h;
import io.reactivex.h.a;
import java.util.concurrent.TimeUnit;

public class e {
  public static b a(EditText paramEditText, String paramString, b<Double> paramb) { return b(paramEditText, paramString).d(new a(null)).aJh().b(paramb); }
  
  public static h<String> b(EditText paramEditText, String paramString) {
    a a = a.aKk();
    if (paramString.contains(".")) {
      paramEditText.setText(n.pj(paramString));
    } else {
      paramEditText.setText(paramString);
    } 
    paramEditText.addTextChangedListener(new g(a));
    a.g(300L, TimeUnit.MILLISECONDS).a(new i()).aJh().e(new h()).d(a.aKh()).c(a.aJo());
    return a;
  }
  
  @CheckResult
  @NonNull
  public static g<? super CharSequence> h(@NonNull EditText paramEditText) { return new f(paramEditText); }
  
  private static class a extends Object implements h<String, Double> {
    private a() {}
    
    public Double fc(String param1String) throws Exception { return Double.valueOf(Double.parseDouble(param1String)); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\rx\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */