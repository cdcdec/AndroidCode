package com.laiqian.opentable.common.a;

import android.content.Context;
import com.laiqian.basic.RootApplication;
import com.laiqian.dcb.api.a.b;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.ordertool.c.a;
import com.laiqian.util.av;
import com.laiqian.util.by;

public class ac {
  a bZV;
  
  String bfo;
  
  private Context context;
  
  public ac(Context paramContext, a parama) {
    this.context = paramContext;
    this.bZV = parama;
    av av = RootApplication.getLaiqianPreferenceManager();
    this.bfo = av.Ea();
    av.close();
  }
  
  private void jq(String paramString) {
    if (!by.isNull(paramString))
      this.bZV.a(this.context, paramString, this.bfo, new b(), null); 
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4) { jq(b.a(paramLong, paramInt1, paramInt2, paramInt3, paramInt4)); }
  
  public void b(TableEntity paramTableEntity, int paramInt) { jq(b.e(paramTableEntity, paramInt)); }
  
  public void d(TableEntity paramTableEntity1, TableEntity paramTableEntity2, int paramInt) { jq(b.a(paramTableEntity1, paramTableEntity2, paramInt)); }
  
  public void jo(String paramString) { jq(paramString); }
  
  public void jp(String paramString) { jq(paramString); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\a\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */