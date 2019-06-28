package com.laiqian.main.module.hardware.dualscreen;

import android.app.Activity;
import android.content.Intent;
import android.content.ServiceConnection;
import android.support.v4.app.Fragment;
import android.widget.ListView;
import com.jakewharton.b.b;
import com.jakewharton.rxbinding2.a.a;
import com.jakewharton.rxbinding2.b.e;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.entity.aq;
import com.laiqian.main.dl;
import com.laiqian.main.module.productcart.am;
import com.laiqian.print.dualscreen.DualScreenService;
import com.laiqian.print.dualscreen.o;
import com.laiqian.rx.a.b.a;
import com.laiqian.rx.b.a;
import com.laiqian.rx.util.a;
import com.laiqian.util.n;
import io.reactivex.a.a;
import io.reactivex.a.b;
import io.reactivex.h;

public class PosActivityDualscreenFragment extends Fragment {
  private boolean aZk = false;
  
  private DualScreenService aZl;
  
  private o aZm;
  
  private ServiceConnection aZn = new o(this);
  
  private final dl bfr;
  
  public final a bfw;
  
  private b bfx;
  
  public PosActivityDualscreenFragment(dl paramdl) {
    this.bfr = paramdl;
    this.bfw = new a(paramdl);
  }
  
  private void Kc() {
    getActivity().bindService(new Intent(getActivity(), DualScreenService.class), this.aZn, 1);
    this.aZk = true;
  }
  
  private void Kd() {
    if (this.aZk) {
      getActivity().unbindService(this.aZn);
      this.aZk = false;
    } 
  }
  
  private void Mp() {
    if (DualScreenService.bc(getActivity())) {
      getActivity().startService(new Intent(getActivity(), DualScreenService.class));
      Kc();
    } 
  }
  
  public b a(o paramo) {
    o.a a1 = paramo.cFI;
    a a2 = new a();
    a2.clear();
    a a3 = am.a(paramo.getContext(), this.bfr);
    a2.b(this.bfw.beN.b(a3));
    b b5 = this.bfw.beX;
    ListView listView = a1.bLC;
    listView.getClass();
    a2.b(b5.b(a.b(listView)));
    a2.b(this.bfw.bfG.d(a.d(getActivity(), true)).b(e.c(a1.buE)));
    h h4 = this.bfw.beT.d(a.d(getActivity(), true)).d(new b(this));
    a1.getClass();
    a2.b(h4.b(g.a(a1)));
    b b4 = this.bfw.bfJ;
    a1.getClass();
    a2.b(b4.b(h.a(a1)));
    h h3 = this.bfw.bfK.d(a.d(getActivity(), true));
    a1.getClass();
    a2.b(h3.b(i.a(a1)));
    b b3 = this.bfw.bfI;
    paramo.getClass();
    a2.b(b3.b(j.b(paramo)));
    b3 = this.bfw.bfN;
    a1.getClass();
    a2.b(b3.b(k.a(a1)));
    a2.b(this.bfw.bdM.b(new l(a1)));
    a2.b(this.bfw.bfP.d(m.beq).b(a.bv(a1.cFQ)));
    b3 = this.bfw.bfH;
    a1.getClass();
    a2.b(b3.b(n.a(a1)));
    h h2 = this.bfw.beV.d(a.d(getActivity(), true));
    a1.getClass();
    a2.b(h2.b(c.a(a1)));
    b b2 = this.bfw.bfO;
    paramo.getClass();
    a2.b(b2.b(d.b(paramo)));
    b b1 = this.bfw.bfL;
    a1.getClass();
    a2.b(b1.b(e.a(a1)));
    h h1 = this.bfw.bfM.d(a.d(getActivity(), true));
    a1.getClass();
    a2.b(h1.b(f.a(a1)));
    a1.bLC.setAdapter(a3);
    return a2;
  }
  
  public void onAttach(Activity paramActivity) {
    super.onAttach(paramActivity);
    Mp();
    this.bfw.Mq();
  }
  
  public void onDetach() {
    this.bfw.wK();
    Kd();
    super.onDetach();
  }
  
  public void onStart() {
    super.onStart();
    this.bfw.bfE.accept(Boolean.valueOf(CrashApplication.getLaiqianPreferenceManager().avz()));
    this.bfw.bfF.accept(Boolean.valueOf(CrashApplication.getLaiqianPreferenceManager().avG()));
  }
  
  public static class a {
    final b<aq> bdM;
    
    final a<am.a> beN;
    
    final b<Double> beT;
    
    final b<Double> beV;
    
    final b<Integer> beX = (this.bfP = (this.bfO = (this.bfN = (this.bfM = (this.bfL = (this.bfK = (this.beT = (this.bfJ = (this.bfI = (this.beV = (this.bfH = (this.bfG = (this.bfF = (this.bfE = b.ak(Boolean.FALSE)).ak(Boolean.FALSE)).ak(Double.valueOf(0.0D))).ak(Boolean.FALSE)).ak(Double.valueOf(0.0D))).ak(Boolean.FALSE)).ak(Boolean.FALSE)).ak(Double.valueOf(100.0D))).ak(Double.valueOf(0.0D))).ak(Boolean.FALSE)).ak(Double.valueOf(0.0D))).ak(Boolean.FALSE)).ak(Boolean.FALSE)).ak(a.bfT)).ak(Integer.valueOf(0));
    
    final b<Boolean> bfE;
    
    final b<Boolean> bfF;
    
    final b<Double> bfG;
    
    final b<Boolean> bfH;
    
    final b<Boolean> bfI;
    
    final b<Boolean> bfJ;
    
    final b<Double> bfK;
    
    final b<Boolean> bfL;
    
    final b<Double> bfM;
    
    final b<Boolean> bfN;
    
    final b<Boolean> bfO;
    
    final b<a> bfP;
    
    private final a bfQ = new a();
    
    private final dl bfr;
    
    a(dl param1dl) {
      this.bfr = param1dl;
      this.bdM = param1dl.bdM;
      this.beN = param1dl.bea.beN;
    }
    
    public void Mq() {
      this.bfQ.b(this.bfr.bea.beX.aJh().b(this.beX));
      this.bfQ.b(this.bfr.bea.beU.b(this.bfG));
      this.bfQ.b(this.bfr.bea.beV.d(q.beq).aJh().b(this.bfH));
      this.bfQ.b(this.bfr.bea.beV.b(this.beV));
      this.bfQ.b(this.bfr.bea.beT.b(this.beT));
      this.bfQ.b(this.bfr.bea.beT.d(r.beq).b(this.bfJ));
      this.bfQ.b(h.a(this.bfE, this.bfr.bea.beZ, s.bfR).aJh().b(this.bfI));
      this.bfQ.b(h.a(this.bfF, this.bfr.bdM, t.bfR).b(this.bfN));
      this.bfQ.b(this.bfr.bem.bex.b(new u(this)));
      this.bfQ.b(this.bfr.bem.bey.b(new v(this)));
      this.bfQ.b(this.bfr.bdS.d(w.beq).aJh().d(x.beq).b(this.bfP));
      this.bfQ.b(this.bfr.bdW.b(new y(this)));
    }
    
    public void wK() { this.bfQ.wK(); }
    
    enum a {
      bfT, bfU;
    }
  }
  
  enum a {
    bfT, bfU;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\hardware\dualscreen\PosActivityDualscreenFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */