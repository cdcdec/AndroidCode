package com.laiqian.main.module.producttype;

import android.app.Activity;
import android.arch.lifecycle.g;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.Fragment;
import android.widget.FrameLayout;
import com.assistne.icondottextview.IconDotTextView;
import com.cantrowitz.rxbroadcast.e;
import com.jakewharton.b.b;
import com.laiqian.main.ar;
import com.laiqian.main.dl;
import com.laiqian.main.fh;
import com.laiqian.models.ac;
import com.laiqian.rx.util.LifecycleAwareObserver;
import io.reactivex.a.a;
import java.util.ArrayList;

public class PosActivityProductTypeFragment extends Fragment {
  dl bfr;
  
  private a biV = new a();
  
  ar bll;
  
  a blm;
  
  b bln;
  
  public PosActivityProductTypeFragment(dl paramdl) {
    this.bfr = paramdl;
    this.bln = new b(paramdl);
  }
  
  private void Mq() {
    this.biV.b(this.bfr.bdS.b(new b(this)));
    this.biV.b(this.bln.bls.b(new c(this)));
    this.biV.b(this.bfr.bel.beH.b(new d(this)));
  }
  
  private void Oe() {
    ac ac = new ac(getActivity());
    ArrayList arrayList = ac.Vi();
    this.bfr.n(arrayList);
    ac.close();
  }
  
  private void setupViews() {
    this.bll = new ar(getActivity(), this.blm.blq, new e(this));
    this.blm.bhA.addView(this.bll.Lq());
  }
  
  private void wK() { this.biV.clear(); }
  
  public void Of() { this.bfr.bdI.accept(this.bfr.bdI.getValue()); }
  
  public void onAttach(Activity paramActivity) {
    super.onAttach(paramActivity);
    this.bln.Mq();
    this.blm = new a(paramActivity);
    setupViews();
    this.bll.dg(((fh.b)this.bfr.bdK.getValue()).bbI);
  }
  
  public void onDestroy() {
    super.onDestroy();
    this.bll.closeModel();
  }
  
  public void onDetach() {
    this.bln.wK();
    super.onDetach();
  }
  
  public void onStart() {
    boolean bool;
    super.onStart();
    Oe();
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("pos_activity_change_data_producttype_undiscount");
    intentFilter.addAction("pos_activity_change_data_producttype");
    intentFilter.addAction("pos_activity_change_data_all");
    e.a(getActivity(), intentFilter).c(LifecycleAwareObserver.a(getLifecycle(), g.a.ON_STOP, new a(this)));
    ar ar1 = this.bll;
    if (this.bfr.bec.getValue() == dl.b.beF) {
      bool = true;
    } else {
      bool = false;
    } 
    ar1.di(bool);
    this.bll.Lr();
    Mq();
  }
  
  public void onStop() {
    wK();
    super.onStop();
  }
  
  static class a {
    FrameLayout bhA;
    
    IconDotTextView blq;
    
    public a(Activity param1Activity) {
      this.bhA = (FrameLayout)param1Activity.findViewById(2131298609);
      this.blq = (IconDotTextView)param1Activity.findViewById(2131298601);
    }
  }
  
  static class b {
    final dl bfr;
    
    final a biV = new a();
    
    final b<Boolean> blr;
    
    final b<Boolean> bls = (this.blr = b.ak(Boolean.valueOf(false))).ak(Boolean.valueOf(false));
    
    b(dl param1dl) { this.bfr = param1dl; }
    
    public void Mq() { this.biV.b(this.bfr.bec.d(f.beq).b(this.bls)); }
    
    public void wK() { this.biV.clear(); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\producttype\PosActivityProductTypeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */