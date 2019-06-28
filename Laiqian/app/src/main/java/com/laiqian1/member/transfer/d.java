package com.laiqian.member.transfer;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import com.laiqian.backup.ag;
import com.laiqian.c.a;
import com.laiqian.print.util.e;
import com.laiqian.sync.a.g;
import com.laiqian.sync.c.a;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.r;
import com.laiqian.ui.a.w;
import com.laiqian.util.n;
import com.laiqian.vip.R;
import io.reactivex.g.a;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

public class d {
  public static final String[] aNs = { "xls" };
  
  protected ArrayList<String> aGI = null;
  
  protected String aGK = "";
  
  private boolean aQY = false;
  
  private r bHl;
  
  private a bHm;
  
  protected String bHn = "";
  
  protected ArrayList<HashMap<String, Object>> bHo = null;
  
  w bHp;
  
  private int bHq = -1;
  
  private int bHr = -1;
  
  w.a bHs = new m(this);
  
  w.a bHt = new o(this);
  
  private Context context;
  
  Handler handler = new h(this);
  
  private ActivityRoot mActivity;
  
  private g syncManager;
  
  public d(a parama, ActivityRoot paramActivityRoot) {
    this.bHm = parama;
    this.context = paramActivityRoot;
    this.mActivity = paramActivityRoot;
    SY();
    this.bHl = new r(this.context);
  }
  
  private void SY() { this.syncManager = new g(this.context); }
  
  private void Ta() {
    r r1 = new r(this.mActivity, 3, new j(this));
    r1.pa(this.mActivity.getString(R.string.lqj_ok));
    r1.setTitle(this.mActivity.getString(R.string.sync_failed));
    r1.s(this.mActivity.getString(R.string.sync_again));
    if (!this.mActivity.getFinishStatus(this.mActivity))
      r1.show(); 
  }
  
  private void eg(boolean paramBoolean) { a.aKh().r(new g(this, paramBoolean)); }
  
  private void m(boolean paramBoolean1, boolean paramBoolean2) { e.i(new i(this, paramBoolean1, paramBoolean2)); }
  
  public void SZ() { a.aKh().r(new e(this)); }
  
  public void Tb() {
    this.bHm.SW();
    this.aGI = new ArrayList();
    this.aGI = n.a(this.mActivity, true);
    int i = this.aGI.size();
    byte b2 = 0;
    byte b1 = 0;
    if (i == 1) {
      this.aGK = (String)this.aGI.get(0);
      this.bHo = ag.a(this.aGK, aNs, true, true);
      PrintStream printStream = System.out;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("arrayFileList=");
      stringBuilder.append(this.bHo);
      printStream.println(stringBuilder.toString());
      if (this.bHo.size() == 1) {
        this.bHn = String.valueOf(((HashMap)this.bHo.get(0)).get("path"));
        this.bHm.gl(this.bHn);
      } else if (this.bHo.size() > 1) {
        String[] arrayOfString = new String[this.bHo.size()];
        while (b1 < this.bHo.size()) {
          arrayOfString[b1] = String.valueOf(((HashMap)this.bHo.get(b1)).get("name"));
          b1++;
        } 
        this.bHp = new w(this.context, arrayOfString, this.bHt);
        this.bHp.setWidth(500);
        this.bHp.gn(this.bHr);
        this.bHp.setOnCancelListener(new k(this));
        this.bHp.show();
      } else {
        this.bHm.gk(Environment.getExternalStorageDirectory().getAbsolutePath());
      } 
      printStream = System.out;
      stringBuilder = new StringBuilder();
      stringBuilder.append("sSelDevicePath=");
      stringBuilder.append(this.aGK);
      printStream.println(stringBuilder.toString());
      return;
    } 
    if (i >= 1) {
      String[] arrayOfString = new String[i];
      for (b1 = b2; b1 < this.aGI.size(); b1++)
        arrayOfString[b1] = (String)this.aGI.get(b1); 
      this.bHp = new w(this.context, arrayOfString, this.bHs);
      this.bHp.setWidth(500);
      this.bHp.gn(this.bHq);
      this.bHp.setOnCancelListener(new l(this));
      this.bHp.show();
      return;
    } 
    this.bHm.gk(this.context.getString(R.string.pos_product_insert_udisk));
  }
  
  public void l(Context paramContext, String paramString) {
    this.bHm.SX();
    a.aKh().r(new f(this, paramContext, paramString));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\transfer\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */