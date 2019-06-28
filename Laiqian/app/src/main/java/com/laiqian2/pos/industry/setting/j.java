package com.laiqian.pos.industry.setting;

import android.util.Log;
import com.laiqian.basic.RootApplication;
import com.laiqian.sync.a.l;
import com.laiqian.sync.model.b;
import com.laiqian.util.logger.h;
import com.laiqian.util.p;
import io.reactivex.g.a;
import java.util.Map;

class j implements l {
  j(a parama) {}
  
  public void onSuccess() {
    Log.i("初始化缓存大小", "清除缓存时同步上传成功。。。");
    p.bO(this.csb.getContext());
    b.a(RootApplication.getLaiqianPreferenceManager().Tx(), a.aKh()).b(k.aEo).a(l.aEp, m.aEp);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\setting\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */