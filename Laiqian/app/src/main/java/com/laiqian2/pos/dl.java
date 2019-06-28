package com.laiqian.pos;

import com.google.a.a.a.a.a.a;
import com.laiqian.sync.a;
import com.laiqian.util.bb;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.a.a;
import kotlin.jvm.a.b;
import kotlin.jvm.b.g;
import kotlin.k;

@Metadata
final class dl extends g implements a<k> {
  dl(b paramb) { super(0); }
  
  public final void aae() {
    try {
      long l = System.currentTimeMillis();
      File file = new File(dj.a(dj.ciW));
      if (file.exists()) {
        a.b(dj.a(dj.ciW, l), dj.b(dj.ciW, l), file);
        bb.f("SendBackupToOSS ", "发送成功");
        this.ciY.aw(Boolean.valueOf(true));
        return;
      } 
      bb.f("SendBackupToOSS ", "文件不存在");
      this.ciY.aw(Boolean.valueOf(false));
      return;
    } catch (Exception exception) {
      this.ciY.aw(Boolean.valueOf(false));
      a.e(exception);
      bb.f("SendBackupToOSS ", "发送异常");
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\dl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */