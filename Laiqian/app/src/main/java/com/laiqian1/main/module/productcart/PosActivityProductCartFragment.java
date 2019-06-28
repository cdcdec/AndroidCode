package com.laiqian.main.module.productcart;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.assistne.icondottextview.IconDotTextView;
import com.jakewharton.rxbinding2.a.a;
import com.jakewharton.rxbinding2.b.a;
import com.jakewharton.rxbinding2.b.d;
import com.jakewharton.rxbinding2.b.e;
import com.laiqian.auth.cj;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.entity.aa;
import com.laiqian.main.dl;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.pos.hold.a;
import com.laiqian.rx.a.b.a;
import com.laiqian.rx.b.a;
import com.laiqian.rx.b.j;
import com.laiqian.util.by;
import com.laiqian.util.n;
import io.reactivex.a.a;
import io.reactivex.android.b.a;
import io.reactivex.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

public class PosActivityProductCartFragment extends Fragment {
  final dl bfr;
  
  a biV = new a();
  
  a<am.a> biX;
  
  a biY;
  
  d biZ;
  
  b bja;
  
  c bjb;
  
  public PosActivityProductCartFragment(dl paramdl) { this.bfr = paramdl; }
  
  private void Mq() {
    h h;
    this.biV.b((h = this.bfr.bdS.d(r.beq)).a(h, this.bfr.bdP, s.bfR).b(j.a(this.biY.bhx, this.biZ.aQx)));
    this.biV.b(this.bfr.bdS.d(t.beq).b(j.a(this.biY.bhx, this.bja.aQx)));
    this.biV.b(this.bfr.bdS.d(u.beq).b(j.a(this.biY.bhx, this.bjb.aQx)));
    this.biV.b(this.bfr.bea.beN.b(this.biX));
    this.biV.b(this.bfr.bea.beX.b(new c(this)));
    this.biV.b(h.a(this.bfr.bea.beU.d(new d(this)).d(a.d(getActivity(), true)), this.bfr.bea.beV.d(new e(this)), f.bfR).b(e.c(this.biY.bjh.bhN)));
    this.biV.b(this.bfr.bea.beW.b(new g(this)));
    h = d.a(this.biY.bhx).aJi().aKd();
    this.biV.b(h.d(new h(this)).b(this.bfr.bea.beW));
    this.biV.b(h.i(800L, TimeUnit.MILLISECONDS).c(a.aJo()).b(new i(this)));
    this.biV.b(this.bfr.bdT.b(new j(this)));
    this.biV.b(this.bfr.bdS.b(new k(this)));
    this.biV.b(this.bfr.bel.beJ.b(new w(this)));
  }
  
  private void a(aa paramaa, int paramInt1, int paramInt2) {
    aa aa1 = new aa(getActivity(), new x(this, paramInt1), new ArrayList());
    aa1.do((new cj(getActivity())).dP(90004));
    aa1.eZ(paramInt2);
    aa1.setOnDismissListener(new l(this));
    aa1.setOnShowListener(new n(aa1));
    aa1.a(this.biY.bhx.getSelectedView(), paramaa, String.valueOf(this.bfr.bea.beM));
  }
  
  private ArrayList<aa> g(Collection<aa> paramCollection) {
    ArrayList arrayList = new ArrayList();
    if (((Boolean)this.bfr.bdN.getValue()).booleanValue()) {
      for (aa aa : paramCollection) {
        aa.r(aa.akI());
        arrayList.add(aa);
      } 
    } else {
      arrayList.addAll(paramCollection);
    } 
    return arrayList;
  }
  
  private void setupViews() {
    this.biY.bjf.biv.setOnClickListener(new a(this));
    ListView listView = this.biY.bhx;
    listView.setEmptyView(this.biY.bhy);
    listView.setChoiceMode(1);
    listView.addHeaderView(View.inflate(getActivity(), 2131427731, null), null, false);
    this.biX = am.a(getActivity(), this.bfr);
    listView.setAdapter(this.biX);
    this.biZ = d.e(getLayoutInflater());
    this.biZ.aQx.setOnClickListener(new b(this));
    this.bja = b.c(getLayoutInflater());
    this.bja.bji.setOnClickListener(new m(this));
    this.bja.bjj.setOnClickListener(new o(this));
    this.bjb = c.d(getLayoutInflater());
    this.bjb.aQx.setOnClickListener(new p(this));
    a.bu(this.biY.bhK).b(new q(this));
  }
  
  private void wK() { this.biV.clear(); }
  
  public void onAttach(Activity paramActivity) {
    super.onAttach(paramActivity);
    this.biY = new a(paramActivity);
    setupViews();
  }
  
  public void onDetach() { super.onDetach(); }
  
  public void onStart() {
    super.onStart();
    this.bfr.bea.Mg();
    Mq();
  }
  
  public void onStop() {
    super.onStop();
    wK();
  }
  
  static class a {
    IconDotTextView bhK;
    
    ListView bhx;
    
    IconDotTextView bhy;
    
    a bjf;
    
    b bjg;
    
    c bjh;
    
    public a(Activity param1Activity) {
      this.bjf = new a(param1Activity.findViewById(2131298825));
      this.bjg = new b(param1Activity.findViewById(2131297862));
      this.bhx = (ListView)param1Activity.findViewById(2131298532);
      this.bhy = (IconDotTextView)param1Activity.findViewById(2131296482);
      this.bhK = (IconDotTextView)param1Activity.findViewById(2131298543);
      this.bjh = new c(param1Activity.findViewById(2131299440));
    }
    
    static final class a {
      RelativeLayout aQo;
      
      View bis;
      
      TextView biu;
      
      TextView biv;
      
      a(View param2View) {
        this.aQo = (RelativeLayout)param2View;
        this.bis = param2View.findViewById(2131298407);
        this.biu = (TextView)param2View.findViewById(2131298827);
        this.biv = (TextView)param2View.findViewById(2131298824);
      }
    }
    
    private static final class b {
      LinearLayout aQx;
      
      RecyclerView biw;
      
      b(View param2View) {
        this.aQx = (LinearLayout)param2View;
        this.biw = (RecyclerView)param2View.findViewById(2131298818);
      }
    }
    
    static final class c {
      LinearLayout aQx;
      
      TextView bhM;
      
      TextView bhN;
      
      c(View param2View) {
        this.aQx = (LinearLayout)param2View;
        this.bhM = (TextView)param2View.findViewById(2131299439);
        this.bhN = (TextView)param2View.findViewById(2131299436);
      }
    }
  }
  
  static final class a {
    RelativeLayout aQo;
    
    View bis;
    
    TextView biu;
    
    TextView biv;
    
    a(View param1View) {
      this.aQo = (RelativeLayout)param1View;
      this.bis = param1View.findViewById(2131298407);
      this.biu = (TextView)param1View.findViewById(2131298827);
      this.biv = (TextView)param1View.findViewById(2131298824);
    }
  }
  
  private static final class b {
    LinearLayout aQx;
    
    RecyclerView biw;
    
    b(View param1View) {
      this.aQx = (LinearLayout)param1View;
      this.biw = (RecyclerView)param1View.findViewById(2131298818);
    }
  }
  
  static final class c {
    LinearLayout aQx;
    
    TextView bhM;
    
    TextView bhN;
    
    c(View param1View) {
      this.aQx = (LinearLayout)param1View;
      this.bhM = (TextView)param1View.findViewById(2131299439);
      this.bhN = (TextView)param1View.findViewById(2131299436);
    }
  }
  
  private static final class b {
    LinearLayout aQx;
    
    LinearLayout bji;
    
    LinearLayout bjj;
    
    b(View param1View) {
      this.aQx = (LinearLayout)param1View;
      this.bji = (LinearLayout)param1View.findViewById(2131297870);
      this.bjj = (LinearLayout)param1View.findViewById(2131297871);
    }
    
    static b c(LayoutInflater param1LayoutInflater) { return new b(param1LayoutInflater.inflate(2131427812, null)); }
  }
  
  private static final class c {
    LinearLayout aQx;
    
    c(View param1View) { this.aQx = (LinearLayout)param1View; }
    
    static c d(LayoutInflater param1LayoutInflater) { return new c(param1LayoutInflater.inflate(2131427813, null)); }
  }
  
  private static final class d {
    LinearLayout aQx;
    
    a bjk;
    
    d(View param1View) {
      this.aQx = (LinearLayout)param1View;
      this.bjk = new a(param1View.findViewById(2131298395));
    }
    
    static d e(LayoutInflater param1LayoutInflater) { return new d(param1LayoutInflater.inflate(2131427830, null)); }
    
    static final class a {
      LinearLayout aQx;
      
      View bjl;
      
      TextView bjm;
      
      a(View param2View) {
        this.aQx = (LinearLayout)param2View;
        this.bjl = param2View.findViewById(2131298396);
        this.bjm = (TextView)param2View.findViewById(2131298397);
      }
    }
  }
  
  static final class a {
    LinearLayout aQx;
    
    View bjl;
    
    TextView bjm;
    
    a(View param1View) {
      this.aQx = (LinearLayout)param1View;
      this.bjl = param1View.findViewById(2131298396);
      this.bjm = (TextView)param1View.findViewById(2131298397);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\productcart\PosActivityProductCartFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */