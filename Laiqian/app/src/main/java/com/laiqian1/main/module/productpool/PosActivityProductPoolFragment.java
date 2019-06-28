package com.laiqian.main.module.productpool;

import android.app.Activity;
import android.arch.lifecycle.g;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.cantrowitz.rxbroadcast.e;
import com.jakewharton.b.b;
import com.jakewharton.rxbinding2.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.d.a;
import com.laiqian.entity.aq;
import com.laiqian.main.dl;
import com.laiqian.main.fh;
import com.laiqian.product.ck;
import com.laiqian.product.eo;
import com.laiqian.product.k;
import com.laiqian.product.models.ProductTypeEntity;
import com.laiqian.product.models.a;
import com.laiqian.product.models.g;
import com.laiqian.product.models.h;
import com.laiqian.rx.b.a;
import com.laiqian.rx.util.LifecycleAwareObserver;
import com.laiqian.rx.util.a;
import com.laiqian.setting.a;
import com.laiqian.ui.a.aq;
import com.laiqian.ui.a.ax;
import com.laiqian.util.ay;
import com.laiqian.util.n;
import io.reactivex.a.a;
import io.reactivex.a.b;
import io.reactivex.android.b.a;
import io.reactivex.g.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PosActivityProductPoolFragment extends Fragment {
  dl bfr;
  
  private ay<eo> bhk = new j(this);
  
  a biV = new a();
  
  a<v.a> biX;
  
  a bkv;
  
  b bkw;
  
  p bkx;
  
  public PosActivityProductPoolFragment(dl paramdl) {
    this.bfr = paramdl;
    this.bkw = new b(getActivity(), paramdl);
  }
  
  private void Mq() {
    this.biV.b(this.bfr.bdI.d(new f(this)).d(new g(this)).d(a.aKh()).c(a.aJo()).b(this.bkw.beN));
    this.biV.b(this.bkw.beN.b(this.biX));
    this.biV.b(this.bkw.bfr.bdN.b(new h(this)));
    this.biV.b(this.bkw.bfr.bdU.aJh().b(new i(this)));
    this.biV.b(this.bkw.bkR.b(a.bw(this.bkv.bkE.bii)));
  }
  
  private void Oa() {
    if (this.bkx == null)
      this.bkx = new p(getActivity(), this.bkv.bkF.aQo, new n(this)); 
    this.bkx.show();
  }
  
  private boolean Ob() { return (this.bkx != null) ? this.bkx.Od() : 0; }
  
  private void a(ProductTypeEntity paramProductTypeEntity, h paramh) {
    CharSequence charSequence1 = getText(2131628330);
    CharSequence charSequence2 = getText(2131628179);
    CharSequence charSequence3 = getText(2131626524);
    String str = getString(2131629771);
    CharSequence[][] arrayOfCharSequence = new CharSequence[2][];
    new CharSequence[2][0] = charSequence2;
    new CharSequence[2][1] = str;
    arrayOfCharSequence[0] = new CharSequence[2];
    new CharSequence[2][0] = charSequence3;
    new CharSequence[2][1] = str;
    arrayOfCharSequence[1] = new CharSequence[2];
    Boolean bool = Boolean.valueOf(((fh.b)this.bkw.bfr.bdK.getValue()).bbI);
    FragmentActivity fragmentActivity = getActivity();
    if (bool.booleanValue())
      arrayOfCharSequence = new CharSequence[][] { { charSequence1, charSequence2, str }, { charSequence1, charSequence3, str } }; 
    ax ax = new ax(fragmentActivity, arrayOfCharSequence, new d(this, bool, paramh, paramProductTypeEntity));
    if (paramh.cUN) {
      ax.kS(0);
    } else {
      ax.kS(1);
    } 
    ax.aT(paramh);
  }
  
  private void addProductToSelectedList(h paramh) {
    if (paramh.cUN) {
      if (paramh instanceof a) {
        a a1 = (a)paramh;
        ArrayList arrayList = a1.b(new g(getActivity()));
        if (arrayList == null) {
          this.bkw.bfr.bea.c(paramh);
          return;
        } 
        if (arrayList.isEmpty()) {
          Toast.makeText(getActivity(), getString(2131627530), 0);
          return;
        } 
        if (!getActivity().isFinishing()) {
          ((eo)this.bhk.get()).a(a1, arrayList);
          return;
        } 
      } else {
        this.bkw.bfr.bea.c(paramh);
        if (paramh.akP()) {
          if (a.AZ().Q(getActivity()))
            (new a(getActivity())).show(); 
          this.bkw.bfr.aw(getActivity());
          return;
        } 
      } 
    } else {
      Toast.makeText(getActivity(), getString(2131628180), 0).show();
    } 
  }
  
  private void b(ProductTypeEntity paramProductTypeEntity, @Nullable h paramh) {
    String str1;
    ck ck = new ck(getActivity());
    ck.a(new m(this));
    ArrayList arrayList = new ArrayList();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(CrashApplication.getLaiqianPreferenceManager().Tx());
    stringBuilder.append("50001");
    long l = n.parseLong(stringBuilder.toString());
    for (String str : this.bkw.bfr.bdH.aoL()) {
      if (str == null || str.aSW == l)
        continue; 
      HashMap hashMap = new HashMap();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str.aSW);
      stringBuilder1.append("");
      hashMap.put("id", stringBuilder1.toString());
      hashMap.put("name", str.name);
      if (str.cVb) {
        String str3 = "1";
      } else {
        str = "0";
      } 
      hashMap.put("isQty", str);
      arrayList.add(hashMap);
    } 
    if (paramh == null) {
      null = new StringBuilder();
      null.append(paramProductTypeEntity.aSW);
      null.append("");
      str1 = null.toString();
      String str = paramProductTypeEntity.name;
      if (paramProductTypeEntity.cVb) {
        String str3 = "";
      } else {
        paramProductTypeEntity = null;
      } 
      ck.a(null, null, null, str1, str, paramProductTypeEntity, true, null, "", null, arrayList, false);
      return;
    } 
    l = paramProductTypeEntity.aSW;
    String str2 = paramProductTypeEntity.name;
    if (paramProductTypeEntity.cVb) {
      String str = String.valueOf(str1.bTj);
    } else {
      paramProductTypeEntity = null;
    } 
    ck.a(new ck.b(str1, String.valueOf(l), str2, paramProductTypeEntity, true, arrayList));
  }
  
  private void b(a parama) { (new k(getActivity(), new l(this))).e(parama); }
  
  private void setupViews() {
    this.biX = new a(v.bkc, v.NT(), new a(this));
    this.bkv.bkE.bii.setEmptyView(this.bkv.bkE.bij);
    this.bkv.bkE.bii.setOnItemClickListener(new b(this));
    this.bkv.bkE.bii.setOnItemLongClickListener(new c(this));
    this.bkv.bkE.bii.setAdapter(this.biX);
  }
  
  private void wK() { this.biV.clear(); }
  
  public void d(h paramh) {
    a.AZ().dV(1);
    g g = new g(getActivity());
    g.r(g.cO(paramh.AL()) + 1, String.valueOf(paramh.getID()));
    g.close();
    this.bfr.bel.beH.accept(new Object());
  }
  
  public void onAttach(Activity paramActivity) {
    super.onAttach(paramActivity);
    this.bkw.Mq();
    this.bkv = new a(paramActivity);
    setupViews();
  }
  
  public void onDetach() {
    this.bkw.wK();
    super.onDetach();
  }
  
  public void onStart() {
    super.onStart();
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("pos_activity_change_data_product");
    intentFilter.addAction("pos_activity_change_data_all");
    e.a(getActivity(), intentFilter).c(LifecycleAwareObserver.a(getLifecycle(), g.a.ON_STOP, new e(this)));
    Mq();
  }
  
  public void onStop() {
    wK();
    super.onStop();
  }
  
  static class a {
    a bkE;
    
    b bkF;
    
    a(Activity param1Activity) {
      this.bkE = new a(param1Activity.findViewById(2131298530));
      this.bkF = new b(param1Activity.findViewById(2131298590));
    }
    
    static final class a {
      RelativeLayout aQo;
      
      GridView bii;
      
      TextView bij;
      
      a(View param2View) {
        this.aQo = (RelativeLayout)param2View;
        this.bii = (GridView)param2View.findViewById(2131298528);
        this.bij = (TextView)param2View.findViewById(2131298531);
      }
    }
    
    static final class b {
      RelativeLayout aQo;
      
      b bkG;
      
      View bkH;
      
      c bkI;
      
      a bkJ;
      
      b(View param2View) {
        this.aQo = (RelativeLayout)param2View;
        this.bkG = new b(param2View.findViewById(2131298587));
        this.bkH = param2View.findViewById(2131298591);
        this.bkI = new c(param2View.findViewById(2131298589));
        this.bkJ = new a(param2View.findViewById(2131298581));
      }
      
      static final class a {
        FrameLayout bkK;
        
        ListView bkL;
        
        LinearLayout bkM;
        
        a(View param3View) {
          this.bkK = (FrameLayout)param3View;
          this.bkL = (ListView)param3View.findViewById(2131298580);
          this.bkM = (LinearLayout)param3View.findViewById(2131298582);
        }
      }
      
      static final class b {
        RelativeLayout aQo;
        
        EditText bkN;
        
        View bkO;
        
        TextView bkP;
        
        b(View param3View) {
          this.aQo = (RelativeLayout)param3View;
          this.bkN = (EditText)param3View.findViewById(2131298586);
          this.bkO = param3View.findViewById(2131298585);
          this.bkP = (TextView)param3View.findViewById(2131298583);
        }
      }
      
      static final class c {
        FrameLayout bkK;
        
        View bkQ;
        
        c(View param3View) {
          this.bkK = (FrameLayout)param3View;
          this.bkQ = param3View.findViewById(2131298588);
        }
      }
    }
    
    static final class a {
      FrameLayout bkK;
      
      ListView bkL;
      
      LinearLayout bkM;
      
      a(View param2View) {
        this.bkK = (FrameLayout)param2View;
        this.bkL = (ListView)param2View.findViewById(2131298580);
        this.bkM = (LinearLayout)param2View.findViewById(2131298582);
      }
    }
    
    static final class b {
      RelativeLayout aQo;
      
      EditText bkN;
      
      View bkO;
      
      TextView bkP;
      
      b(View param2View) {
        this.aQo = (RelativeLayout)param2View;
        this.bkN = (EditText)param2View.findViewById(2131298586);
        this.bkO = param2View.findViewById(2131298585);
        this.bkP = (TextView)param2View.findViewById(2131298583);
      }
    }
    
    static final class c {
      FrameLayout bkK;
      
      View bkQ;
      
      c(View param2View) {
        this.bkK = (FrameLayout)param2View;
        this.bkQ = param2View.findViewById(2131298588);
      }
    }
  }
  
  static final class a {
    RelativeLayout aQo;
    
    GridView bii;
    
    TextView bij;
    
    a(View param1View) {
      this.aQo = (RelativeLayout)param1View;
      this.bii = (GridView)param1View.findViewById(2131298528);
      this.bij = (TextView)param1View.findViewById(2131298531);
    }
  }
  
  static final class b {
    RelativeLayout aQo;
    
    b bkG;
    
    View bkH;
    
    c bkI;
    
    a bkJ;
    
    b(View param1View) {
      this.aQo = (RelativeLayout)param1View;
      this.bkG = new b(param1View.findViewById(2131298587));
      this.bkH = param1View.findViewById(2131298591);
      this.bkI = new c(param1View.findViewById(2131298589));
      this.bkJ = new a(param1View.findViewById(2131298581));
    }
    
    static final class a {
      FrameLayout bkK;
      
      ListView bkL;
      
      LinearLayout bkM;
      
      a(View param3View) {
        this.bkK = (FrameLayout)param3View;
        this.bkL = (ListView)param3View.findViewById(2131298580);
        this.bkM = (LinearLayout)param3View.findViewById(2131298582);
      }
    }
    
    static final class b {
      RelativeLayout aQo;
      
      EditText bkN;
      
      View bkO;
      
      TextView bkP;
      
      b(View param3View) {
        this.aQo = (RelativeLayout)param3View;
        this.bkN = (EditText)param3View.findViewById(2131298586);
        this.bkO = param3View.findViewById(2131298585);
        this.bkP = (TextView)param3View.findViewById(2131298583);
      }
    }
    
    static final class c {
      FrameLayout bkK;
      
      View bkQ;
      
      c(View param3View) {
        this.bkK = (FrameLayout)param3View;
        this.bkQ = param3View.findViewById(2131298588);
      }
    }
  }
  
  static final class a {
    FrameLayout bkK;
    
    ListView bkL;
    
    LinearLayout bkM;
    
    a(View param1View) {
      this.bkK = (FrameLayout)param1View;
      this.bkL = (ListView)param1View.findViewById(2131298580);
      this.bkM = (LinearLayout)param1View.findViewById(2131298582);
    }
  }
  
  static final class b {
    RelativeLayout aQo;
    
    EditText bkN;
    
    View bkO;
    
    TextView bkP;
    
    b(View param1View) {
      this.aQo = (RelativeLayout)param1View;
      this.bkN = (EditText)param1View.findViewById(2131298586);
      this.bkO = param1View.findViewById(2131298585);
      this.bkP = (TextView)param1View.findViewById(2131298583);
    }
  }
  
  static final class c {
    FrameLayout bkK;
    
    View bkQ;
    
    c(View param1View) {
      this.bkK = (FrameLayout)param1View;
      this.bkQ = param1View.findViewById(2131298588);
    }
  }
  
  static class b {
    public final a<v.a> beN = a.R(new ArrayList());
    
    public final b<Integer> beW;
    
    public final dl bfr;
    
    private a biV = new a();
    
    public final b<Boolean> bkR = (this.beW = b.ak(Integer.valueOf(-1))).ak(Boolean.valueOf(true));
    
    public b(Context param1Context, dl param1dl) { this.bfr = param1dl; }
    
    public void Mq() { this.biV.b(this.bfr.bec.d(o.beq).b(this.bkR)); }
    
    public void wK() { this.biV.clear(); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\productpool\PosActivityProductPoolFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */