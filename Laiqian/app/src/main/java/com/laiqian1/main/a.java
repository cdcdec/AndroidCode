package com.laiqian.main;

import com.laiqian.message.m;
import kotlin.Metadata;
import kotlin.jvm.b.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
public final class a implements m.a {
  private static a bao;
  
  public static final a bap = new a();
  
  public void H(@Nullable String paramString1, @Nullable String paramString2) {
    if (paramString2 != null) {
      a a1 = bao;
      if (a1 != null)
        a1.eL(paramString2); 
    } 
  }
  
  public final void a(@NotNull a parama) {
    f.m(parama, "callBack");
    bao = parama;
  }
  
  @Metadata
  public static interface a {
    void eL(@NotNull String param1String);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */