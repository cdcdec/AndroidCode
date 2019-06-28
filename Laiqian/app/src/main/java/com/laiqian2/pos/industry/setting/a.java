package com.laiqian.pos.industry.setting;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.backup.ag;
import com.laiqian.basic.RootApplication;
import com.laiqian.db.multidatabase.b.a;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.milestone.h;
import com.laiqian.sync.a.g;
import com.laiqian.sync.c.a;
import com.laiqian.sync.model.SyncProgessMessage;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.ui.a.d;
import com.laiqian.util.am;
import com.laiqian.util.av;
import com.laiqian.util.bb;
import com.laiqian.util.n;
import com.laiqian.util.p;
import com.laiqian.util.s;
import hugo.weaving.DebugLog;
import io.reactivex.g.a;
import java.io.File;

public class a extends d {
  private View aDI;
  
  private String aGK = "";
  
  private View aJv;
  
  private TextView crU;
  
  private LinearLayout crV;
  
  private String crW;
  
  private TextView crX;
  
  private ProgressBarCircularIndeterminate crY;
  
  private ProgressBarCircularIndeterminate crZ;
  
  private Handler handler = new g(this);
  
  private Context mContext;
  
  private g syncManager;
  
  public a(Context paramContext) {
    super(paramContext, 2131427856);
    this.mContext = paramContext;
    wR();
    aaM();
    aaN();
  }
  
  @DebugLog
  private void aaN() {
    this.syncManager = new g(this.mContext);
    this.syncManager.a(new j(this));
    a.aKh().r(new b(this));
  }
  
  private void aaO() { a.aKh().r(new c(this)); }
  
  private void aaP() {
    if (p.py(this.aGK) < 1024.0D) {
      a.aKh().r(new d(this));
      return;
    } 
    Message message = new Message();
    message.what = 3;
    this.handler.sendMessage(message);
  }
  
  private void aaQ() {
    s.bR(this.mContext);
    boolean bool1 = ef(1);
    boolean bool2 = am.cE(a.aOz);
    b.Dr();
    if (bool1 && bool2) {
      Toast.makeText(this.mContext, this.mContext.getString(2131624830), 0).show();
    } else {
      Toast.makeText(this.mContext, this.mContext.getString(2131624829), 0).show();
    } 
    xk();
  }
  
  private void aaR() { a.aKh().r(new f(this)); }
  
  private void wR() {
    this.crV = (LinearLayout)findViewById(2131297462);
    this.crU = (TextView)this.mView.findViewById(2131299509);
    this.crX = (TextView)this.mView.findViewById(2131299695);
    this.crY = (ProgressBarCircularIndeterminate)this.mView.findViewById(2131297346);
    this.crZ = (ProgressBarCircularIndeterminate)this.mView.findViewById(2131297409);
    this.aDI = this.mView.findViewById(2131299105);
    this.aJv = this.mView.findViewById(2131296672);
  }
  
  private void xY() { a.aKh().r(new e(this)); }
  
  private void xk() {
    this.aJv.setEnabled(true);
    this.aJv.performClick();
  }
  
  public void aaM() {
    this.aJv.setOnClickListener(new h(this));
    this.aDI.setOnClickListener(new i(this));
  }
  
  public boolean ef(int paramInt) {
    av av = new av(this.mContext);
    if ((new h(this.mContext)).fX(paramInt)) {
      av.hy(true);
      av.close();
      bb.e("delete", "删除本地数据成功");
      return true;
    } 
    bb.e("delete", "删除本地数据失败");
    return false;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\setting\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */