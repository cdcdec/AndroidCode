package com.laiqian.main.module.settlement;

import android.arch.lifecycle.g;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.Fragment;
import com.cantrowitz.rxbroadcast.e;
import com.laiqian.entity.aa;
import com.laiqian.entity.aq;
import com.laiqian.entity.u;
import com.laiqian.main.PosActivitySettlementDialog;
import com.laiqian.main.dl;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.rx.util.LifecycleAwareObserver;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.util.ay;
import com.laiqian.util.by;
import io.reactivex.android.b.a;
import io.reactivex.c.g;
import java.util.ArrayList;

public class PosActivitySettlementFragment extends Fragment {
  private final dl bfr;
  
  private ay<PosActivitySettlementDialog> boh = new cu(this);
  
  public PosActivitySettlementFragment(dl paramdl) { this.bfr = paramdl; }
  
  private PosActivitySettlementDialog OA() { return new PosActivitySettlementDialog((ActivityRoot)getActivity(), new ArrayList(this.bfr.bea.beO.aoL()), new ArrayList(this.bfr.bea.beP.aoL()), new cv(this)); }
  
  private <T> LifecycleAwareObserver<T> a(g<T> paramg) { return LifecycleAwareObserver.a(getLifecycle(), g.a.ON_STOP, paramg); }
  
  public void Mq() {
    this.bfr.bem.beC.c(a.aJo()).c(a(new cn(this)));
    this.bfr.bem.beD.c(a(new co(this)));
    ((PosActivitySettlementDialog)this.boh.get()).setOnShowListener(new cp(this));
    ((PosActivitySettlementDialog)this.boh.get()).setOnDismissListener(new cq(this));
    this.bfr.bdM.c(a(new cr(this)));
    this.bfr.bdO.c(a(new cs(this)));
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("pos_activity_change_data_paytype");
    intentFilter.addAction("pos_activity_change_data_order_type");
    e.a(getActivity(), intentFilter).b(new ct(this));
    ((PosActivitySettlementDialog)this.boh.get()).onChangeDecimalPoint();
  }
  
  public void onDestroy() {
    super.onDestroy();
    if (this.boh.peek() != null)
      ((PosActivitySettlementDialog)this.boh.get()).closeModel(); 
  }
  
  public void onPause() { super.onPause(); }
  
  public void onResume() { super.onResume(); }
  
  public void onStart() {
    super.onStart();
    Mq();
  }
  
  public void onStop() {
    super.onStop();
    System.out.println();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\PosActivitySettlementFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */