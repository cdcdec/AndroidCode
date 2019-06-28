package com.laiqian.repair;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.google.a.a.a.a.a.a;
import com.laiqian.infrastructure.R;
import com.laiqian.pos.aa;
import com.laiqian.sync.a.g;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.a.bc;
import com.laiqian.ui.a.r;
import com.laiqian.ui.keybord.KeyBoardLinearlayout;
import com.laiqian.ui.keybord.d;
import com.laiqian.util.bd;
import com.laiqian.util.bs;
import java.util.ArrayList;

public class SelfRepairMain extends ActivityRoot {
  private static final String TAG = "SelfRepairMain";
  
  private g aZY = null;
  
  private bs aZe;
  
  r bCF;
  
  private final int cYf = 4;
  
  private final int cYg = 8;
  
  private final int cYh = 1;
  
  private final int cYi = -1;
  
  private EditText cYj;
  
  private View cYk;
  
  private View cYl;
  
  private View cYm;
  
  private String cYn;
  
  private String cYo;
  
  Handler handler = new m(this);
  
  private bb mWaitingDialog = null;
  
  private bc mWiFiDialog;
  
  static  {
  
  }
  
  private void RE() {
    this.bCF = new r(getActivity(), true, new l(this));
    this.bCF.oZ("取消");
    this.bCF.t("重试");
    this.bCF.setTitle(getString(R.string.pos_dialog_title_prompt));
    this.bCF.s("下载数据失败,请检查网络");
  }
  
  private boolean Rh() {
    this.handler.obtainMessage(6).sendToTarget();
    this.aZY.apy().gW(true);
    this.aZY.apy().ow("download_transaction");
    this.aZY.c(true, "t_bpartner", 0L, System.currentTimeMillis());
    this.aZY.c(false, "t_bpartner_chargedoc", 0L, System.currentTimeMillis());
    boolean bool = this.aZY.execute();
    if (!bool) {
      this.handler.obtainMessage(4).sendToTarget();
    } else {
      this.handler.obtainMessage(8).sendToTarget();
    } 
    String str = TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("在线会员改离线会员下载数据 success=");
    stringBuilder.append(bool);
    Log.i(str, stringBuilder.toString());
    return bool;
  }
  
  private void amf() {
    if (!checkNetwork())
      return; 
    aa aa = new aa(getActivity());
    aa.b(new k(this));
    aa.show();
  }
  
  private boolean checkNetwork() {
    boolean bool = bd.bH(this);
    if (!bool)
      (new bc(this)).show(); 
    return bool;
  }
  
  private void nf(String paramString) { (new a(this, null)).execute(new Void[0]); }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(R.layout.self_repair);
    setTitleTextViewHideRightView(R.string.pos_repair_self);
    this.cYj = (EditText)findViewById(R.id.keyword);
    this.aZY = new g(this);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((this.cYj.getLayoutParams()).width, -2);
    KeyBoardLinearlayout keyBoardLinearlayout = (KeyBoardLinearlayout)findViewById(R.id.myKeyBoard);
    this.aZe = new bs();
    EditText editText = this.cYj;
    bs bs1 = this.aZe;
    new d(this, new EditText[] { editText }, keyBoardLinearlayout, bs1, null, layoutParams);
    this.cYk = findViewById(R.id.repairNetworking);
    this.cYl = this.cYk.findViewById(R.id.repairNetworking_text);
    this.cYm = this.cYk.findViewById(R.id.repairNetworking_progress);
    this.cYk.setOnClickListener(new j(this));
    RE();
  }
  
  protected void onDestroy() {
    super.onDestroy();
    if (this.aZe != null)
      this.aZe.release(); 
  }
  
  private class a extends AsyncTask<Void, Void, Boolean> {
    boolean aGq = false;
    
    private a(SelfRepairMain this$0) {}
    
    private boolean checkNetwork() {
      if (!bd.bH(this.cYp)) {
        if (SelfRepairMain.h(this.cYp) == null) {
          SelfRepairMain.a(this.cYp, new bc(this.cYp));
          SelfRepairMain.h(this.cYp).setCancelable(false);
        } 
        SelfRepairMain.h(this.cYp).show();
        return false;
      } 
      return true;
    }
    
    protected void b(Boolean param1Boolean) {
      if (SelfRepairMain.g(this.cYp) != null)
        SelfRepairMain.g(this.cYp).cancel(); 
    }
    
    protected Boolean g(Void... param1VarArgs) { return this.aGq ? Boolean.valueOf(SelfRepairMain.i(this.cYp)) : Boolean.valueOf(false); }
    
    protected void onPreExecute() {
      this.aGq = checkNetwork();
      if (this.aGq) {
        if (SelfRepairMain.g(this.cYp) == null) {
          SelfRepairMain.a(this.cYp, new bb(this.cYp));
          SelfRepairMain.g(this.cYp).setCancelable(false);
        } 
        SelfRepairMain.g(this.cYp).show();
      } 
    }
  }
  
  private class b extends Thread {
    private String cYs;
    
    private b(SelfRepairMain this$0, String param1String) { this.cYs = param1String; }
    
    public void run() {
      SelfRepairMain.c(this.cYp, getName());
      super.run();
      try {
        ArrayList arrayList = b.ne(this.cYs);
        if (getName() == SelfRepairMain.f(this.cYp)) {
          if (this.cYp.isFinishing())
            return; 
          this.cYp.handler.obtainMessage(1, arrayList).sendToTarget();
          return;
        } 
        return;
      } catch (Exception exception) {
        a.e(exception);
        this.cYp.handler.obtainMessage(-1, exception.getMessage()).sendToTarget();
        return;
      } 
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repair\SelfRepairMain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */