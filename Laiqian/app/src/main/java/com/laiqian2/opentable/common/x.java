package com.laiqian.opentable.common;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.jakewharton.b.c;
import com.laiqian.entity.s;
import com.laiqian.opentable.R;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.a.r;
import com.laiqian.util.n;
import io.reactivex.a.b;

public class x extends Dialog {
  private final int aJe = 60000;
  
  private t.f bMK;
  
  private ah bMe = new ah();
  
  private s bZk;
  
  private b bZl;
  
  private c<s> biD;
  
  private c<Boolean> biE;
  
  private Context context;
  
  private Handler handler;
  
  private bb mWaitingDialog = null;
  
  public x(@NonNull Context paramContext) {
    super(paramContext, R.style.pos_dialog);
    this.context = paramContext;
    setContentView(R.layout.resend_dialog);
    XS();
    findViewById(R.id.next_step).setOnClickListener(new z(this));
    findViewById(R.id.sure).setOnClickListener(new aa(this));
    findViewById(R.id.cancel).setOnClickListener(new ac(this));
  }
  
  private void Em() {
    if (this.mWaitingDialog == null) {
      this.mWaitingDialog = new bb(this.context);
      this.mWaitingDialog.setCancelable(false);
    } 
    this.mWaitingDialog.show();
  }
  
  private void XR() {
    if (b.c(this.bZk)) {
      n.eP(R.string.pos_main_pay_finish);
    } else {
      n.eP(R.string.diagnose_state_failed);
    } 
    dismiss();
  }
  
  private void XS() { this.handler = new ae(this, this.context.getMainLooper()); }
  
  private void XT() {
    r r = new r(this.context, new af(this));
    r.setTitle(this.context.getString(R.string.new_pos_confirm_title));
    r.s(this.context.getString(R.string.pos_open_table_settlement_message));
    r.t(this.context.getString(R.string.pos_quit_save_hint_dialog_cancel));
    r.oZ(this.context.getString(R.string.pos_confirm));
    r.show();
  }
  
  private void eC(boolean paramBoolean) {
    this.bMe.eD(true);
    (new Handler(Looper.getMainLooper())).postDelayed(new ad(this, paramBoolean), 2000L);
  }
  
  private void hideProgress() {
    if (this.mWaitingDialog != null)
      this.mWaitingDialog.dismiss(); 
    this.bMe.XV();
  }
  
  public void a(c<s> paramc1, c<Boolean> paramc2) {
    this.biD = paramc1;
    this.biE = paramc2;
    if (this.bZl != null)
      this.bZl.wK(); 
    this.bZl = this.biE.b(new y(this));
  }
  
  public void b(t.f paramf) { this.bMK = paramf; }
  
  public void d(@Nullable s params) {
    this.bZk = params;
    super.show();
  }
  
  public void show() { super.show(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */