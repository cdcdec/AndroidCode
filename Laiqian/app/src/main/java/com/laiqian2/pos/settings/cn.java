package com.laiqian.pos.settings;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.laiqian.models.an;
import com.laiqian.pos.industry.b;
import com.laiqian.print.util.e;
import com.laiqian.util.au;
import com.laiqian.util.av;
import com.laiqian.util.bd;
import com.laiqian.util.bh;
import com.laiqian.util.by;
import io.reactivex.g.a;
import java.util.HashMap;
import org.json.JSONObject;

public class cn {
  private Message cBt = Message.obtain();
  
  private Context mContext;
  
  public cn(Context paramContext) { this.mContext = paramContext; }
  
  public void adD() { a.aKh().r(new co(this)); }
  
  public void c(Handler paramHandler) { a.aKh().r(new cp(this, paramHandler)); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */