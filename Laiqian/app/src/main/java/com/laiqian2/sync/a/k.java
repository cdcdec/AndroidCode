package com.laiqian.sync.a;

import android.content.Context;
import com.laiqian.infrastructure.R;
import com.laiqian.message.m;
import com.laiqian.pos.industry.a;
import com.laiqian.util.av;
import com.laiqian.util.l;
import java.io.File;

public class k {
  private static j.a a(Context paramContext, j.a parama) {
    av av = new av(paramContext);
    parama.oe(av.Ea()).oh(av.atm()).oe(av.Ea()).of(av.atr()).oi(av.Tx()).om(l.dj(Long.parseLong(av.atm()))).ok(av.getVersion()).on(a.crg).ol(paramContext.getString(R.string.r_channelID)).gV(true).oo(a.crh).oj(m.Tw()).kk(m.getDeviceType());
    av.close();
    return parama;
  }
  
  public static j a(Context paramContext, File paramFile) {
    j.a a = new j.a();
    a(paramContext, a);
    a.kj(13).og(paramFile.getName());
    return a.apE();
  }
  
  public static j bv(Context paramContext) {
    j.a a = new j.a();
    a(paramContext, a);
    a.kj(15);
    return a.apE();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sync\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */