package com.laiqian.product;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.jakewharton.b.b;
import com.jakewharton.b.c;
import com.jakewharton.rxbinding2.a.a;
import com.jakewharton.rxbinding2.b.e;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.d.a;
import com.laiqian.main.fg;
import com.laiqian.product.a.b;
import com.laiqian.product.a.e;
import com.laiqian.product.models.c;
import com.laiqian.product.models.f;
import com.laiqian.rx.a.b.a;
import com.laiqian.rx.b.a;
import com.laiqian.rx.util.a;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.container.z;
import com.laiqian.util.ae;
import hugo.weaving.DebugLog;
import io.reactivex.a.a;
import io.reactivex.a.b;
import io.reactivex.android.b.a;
import io.reactivex.c.c;
import io.reactivex.c.g;
import io.reactivex.c.h;
import io.reactivex.d.a;
import io.reactivex.g.a;
import io.reactivex.h;
import io.reactivex.k;
import io.reactivex.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@DebugLog
public class ProductAttributeActivity extends ActivityRoot {
  private static final String TAG = "ProductAttributeActivity";
  
  a bfQ = new a();
  
  z cPr;
  
  b cPs;
  
  a<d.a> cPt;
  
  a<d.a> cPu;
  
  a<d.a> cPv;
  
  d cPw;
  
  static  {
  
  }
  
  public static Intent a(Context paramContext, String paramString, long paramLong, Collection<c> paramCollection) {
    HashMap hashMap = new HashMap();
    for (c c : paramCollection)
      hashMap.put(Long.valueOf(c.id), Integer.valueOf(c.qty)); 
    return a(paramContext, paramString, paramLong, hashMap);
  }
  
  public static Intent a(Context paramContext, String paramString, long paramLong, HashMap<Long, Integer> paramHashMap) {
    Intent intent = new Intent(paramContext, ProductAttributeActivity.class);
    intent.putExtra("SELECT_MODE", true);
    intent.putExtra("PRODUCT_NAME", paramString);
    intent.putExtra("PRODUCT_TYPE_ID", paramLong);
    intent.putExtra("ATTRIBUTE_SELECTION", paramHashMap);
    return intent;
  }
  
  private g<Float> a(LinearLayout paramLinearLayout) { return new ab(paramLinearLayout); }
  
  private void a(d paramd) {
    this.bfQ.b(paramd.cQc.b(a.bw(this.cPs.cPG.aQo)));
    this.bfQ.b(paramd.cPZ.d(gm(true)).c(a.aJo()).b(this.cPt));
    this.bfQ.b(paramd.cQa.d(gm(false)).c(a.aJo()).b(this.cPu));
    this.bfQ.b(paramd.cQb.d(gm(false)).c(a.aJo()).b(this.cPv));
    this.bfQ.b(paramd.cQc.c(a.aJo()).b(new s(this)));
    this.bfQ.b(paramd.cQf.c(a.aJo()).b(a.bw(this.cPs.cPH.cPK.aQx)));
    this.bfQ.b(paramd.cQg.c(a.aJo()).b(a.bw(this.cPs.cPH.cPL.aQx)));
    this.bfQ.b(paramd.bfJ.c(a.aJo()).b(a.bw(this.cPs.cPH.cPM.aQx)));
    this.bfQ.b(h.a(paramd.cQf, paramd.cQg, paramd.bfJ, t.bes).c(a.aJo()).b(a.bw(this.cPs.cPH.aQx)));
    this.bfQ.b(h.a(paramd.cQf, paramd.cQg, paramd.bfJ, u.bes).c(a.aJo()).b(a(this.cPs.cPH.cPK.aQx)));
    this.bfQ.b(h.a(paramd.cQf, paramd.cQg, paramd.bfJ, v.bes).c(a.aJo()).b(a(this.cPs.cPH.cPL.aQx)));
    this.bfQ.b(h.a(paramd.cQf, paramd.cQg, paramd.bfJ, w.bes).c(a.aJo()).b(a(this.cPs.cPH.cPM.aQx)));
    this.bfQ.b(h.a(paramd.cQf, paramd.cQg, paramd.bfJ, x.bes).c(a.aJo()).b(b(this.cPs.cPH.cPK.cPO)));
    this.bfQ.b(h.a(paramd.cQf, paramd.cQg, paramd.bfJ, y.bes).c(a.aJo()).b(b(this.cPs.cPH.cPL.cPS)));
    this.bfQ.b(h.a(paramd.cQf, paramd.cQg, paramd.bfJ, z.bes).c(a.aJo()).b(b(this.cPs.cPH.cPM.cPQ)));
  }
  
  private void a(e parame) {
    bq bq = new bq(getActivity());
    bq.a(new ar(this));
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append((parame.akn()).id);
    stringBuilder1.append("");
    String str1 = stringBuilder1.toString();
    String str2 = (parame.akn()).name;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append((parame.akn()).aUH);
    stringBuilder2.append("");
    String str3 = stringBuilder2.toString();
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append((parame.akn()).value);
    stringBuilder3.append("");
    bq.e(str1, str2, str3, stringBuilder3.toString(), (parame.akn()).cUy);
  }
  
  private void ahr() { this.cPw.aju(); }
  
  private d ajq() {
    Intent intent = getIntent();
    if (intent.getBooleanExtra("SELECT_MODE", false)) {
      String str = intent.getStringExtra("PRODUCT_NAME");
      long l = intent.getLongExtra("PRODUCT_TYPE_ID", -1L);
      HashMap hashMap = (HashMap)intent.getSerializableExtra("ATTRIBUTE_SELECTION");
      return new d(new f(getActivity()), str, l, hashMap);
    } 
    return new d(new f(getActivity()));
  }
  
  private void ajr() {
    this.bfQ.b(this.cPw.cQd.b(e.c(this.cPr.dxH.dxM)));
    ((a)this.cPt.aoH()).a(new al(this));
    ((a)this.cPu.aoH()).a(new am(this));
    ((a)this.cPv.aoH()).a(new an(this));
  }
  
  private void ajs() {
    this.cPr.dxH.dxM.setText("属性");
    ((a)this.cPt.aoH()).a(new ao(this));
    ((a)this.cPu.aoH()).a(new ap(this));
    ((a)this.cPv.aoH()).a(new aq(this));
  }
  
  private g<Integer> b(GridView paramGridView) { return new ac(paramGridView); }
  
  private void gl(boolean paramBoolean) {
    if (paramBoolean) {
      ajr();
      return;
    } 
    ajs();
  }
  
  private h<List<e>, ArrayList<d.a>> gm(boolean paramBoolean) { return new r(paramBoolean); }
  
  private void setupViews() {
    this.cPr.dxH.dxM.setText(2131627455);
    this.cPr.dxH.aQx.setOnClickListener(new p(this));
    int i = ae.b(getActivity(), 12.0F);
    int j = ae.b(getActivity(), 20.0F);
    if ((fg.Ml()).bbI && a.AZ().BN()) {
      ImageView imageView1 = new ImageView(getActivity());
      imageView1.setImageDrawable(getResources().getDrawable(2131231381));
      imageView1.setPadding(j, i, j, i);
      imageView1.setBackgroundResource(2131230968);
      imageView1.setOnClickListener(new q(this));
      this.cPr.dxK.addView(imageView1);
    } 
    ImageView imageView = new ImageView(getActivity());
    imageView.setImageDrawable(getResources().getDrawable(2131231809));
    imageView.setPadding(j, i, j, i);
    imageView.setBackgroundResource(2131230968);
    imageView.setOnClickListener(new aa(this));
    this.cPr.dxK.addView(imageView);
    this.cPs.btS.setText(getString(2131627454));
    this.cPs.cPG.cPI.setText("清空选择");
    this.cPs.cPG.cPI.setOnClickListener(new ad(this));
    this.cPs.cPG.bNf.setText(2131624573);
    this.cPs.cPG.bNf.setOnClickListener(new ae(this));
    this.cPs.cPG.csp.setText(2131626593);
    this.cPs.cPG.csp.setOnClickListener(new af(this));
    this.cPs.cPG.cPJ.setText(2131625487);
    this.cPs.cPG.cPJ.setOnClickListener(new ag(this));
    this.cPs.cPH.cPK.cPN.setText(2131624248);
    this.cPs.cPH.cPM.cPP.setText(2131624252);
    this.cPs.cPH.cPL.cPR.setText(2131624254);
    this.cPt = new a(2131427696, ah.cPB, new a());
    this.cPs.cPH.cPK.cPO.setAdapter(this.cPt);
    this.cPu = new a(2131427696, ai.cPB, new a());
    this.cPs.cPH.cPL.cPS.setAdapter(this.cPu);
    this.cPv = new a(2131427696, aj.cPB, new a());
    this.cPs.cPH.cPM.cPQ.setAdapter(this.cPv);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.cPs = b.m(getWindow());
    this.cPr = z.q(getWindow());
    this.cPw = ajq();
    setupViews();
    ahr();
  }
  
  protected void onDestroy() {
    this.bfQ.clear();
    super.onDestroy();
  }
  
  protected void onPause() { super.onPause(); }
  
  protected void onResume() { super.onResume(); }
  
  protected void onStart() {
    super.onStart();
    a(this.cPw);
  }
  
  protected void onStop() {
    super.onStop();
    this.bfQ.clear();
  }
  
  private static class a extends Object implements a.c<d.a> {
    private a cPD = null;
    
    @NonNull
    @DebugLog
    public b a(a<ProductAttributeActivity.d.a> param1a, int param1Int, @NonNull View param1View1, View param1View2) {
      ProductAttributeActivity.d.a a1 = (ProductAttributeActivity.d.a)param1a.getItem(param1Int);
      ProductAttributeActivity.c c1 = new ProductAttributeActivity.c(param1View1);
      a a2 = new a();
      a2.b(a1.cQn.cUp.d(as.beq).c(a.aJo()).b(e.c(c1.cPU)));
      a2.b(a1.cQn.cUl.c(a.aJo()).b(e.c(c1.ccm)));
      a2.b(h.a(a1.cQn.cUm, a1.cQn.cUo, at.bfR).d(a.aJo()).b(e.c(c1.cvO)));
      a2.b(a1.cQn.cUp.d(au.beq).d(a.aJo()).b(a.u(c1.cPU, 4)));
      a2.b(h.a(a1.cQo, a1.cQn.cUp, av.bfR).c(a.aJo()).b(a.u(c1.cPT.aQx, 4)));
      a2.b(a.bu(c1.aQx).b(new aw(this, a1)));
      a2.b(a.bu(c1.cPT.cJE).b(new ax(this, a1)));
      a2.b(a.bu(c1.cPT.cJG).b(new ay(this, a1)));
      return a2;
    }
    
    public void a(a param1a) { this.cPD = param1a; }
    
    static interface a {
      void d(ProductAttributeActivity.d.a param2a);
      
      void e(ProductAttributeActivity.d.a param2a);
      
      void f(ProductAttributeActivity.d.a param2a);
    }
  }
  
  static interface a {
    void d(ProductAttributeActivity.d.a param1a);
    
    void e(ProductAttributeActivity.d.a param1a);
    
    void f(ProductAttributeActivity.d.a param1a);
  }
  
  private static final class b {
    RelativeLayout aQo;
    
    TextView btS;
    
    a cPG;
    
    b cPH;
    
    b(View param1View) {
      this.aQo = (RelativeLayout)param1View;
      this.cPG = new a(param1View.findViewById(2131297521));
      this.btS = (TextView)param1View.findViewById(2131299610);
      this.cPH = new b(param1View.findViewById(2131297542));
    }
    
    static b m(Window param1Window) {
      b b1 = s(LayoutInflater.from(param1Window.getContext()));
      param1Window.setContentView(b1.aQo);
      return b1;
    }
    
    static b s(LayoutInflater param1LayoutInflater) { return new b(param1LayoutInflater.inflate(2131427936, null)); }
    
    static final class a {
      RelativeLayout aQo;
      
      TextView bNf;
      
      TextView cPI;
      
      TextView cPJ;
      
      TextView csp;
      
      a(View param2View) {
        this.aQo = (RelativeLayout)param2View;
        this.cPI = (TextView)param2View.findViewById(2131299508);
        this.csp = (TextView)param2View.findViewById(2131299511);
        this.cPJ = (TextView)param2View.findViewById(2131299476);
        this.bNf = (TextView)param2View.findViewById(2131299494);
      }
    }
    
    static final class b {
      LinearLayout aQx;
      
      a cPK;
      
      c cPL;
      
      b cPM;
      
      b(View param2View) {
        this.aQx = (LinearLayout)param2View;
        this.cPK = new a(param2View.findViewById(2131297499));
        this.cPL = new c(param2View.findViewById(2131297702));
        this.cPM = new b(param2View.findViewById(2131297556));
      }
      
      static final class a {
        LinearLayout aQx;
        
        TextView cPN;
        
        GridView cPO;
        
        a(View param3View) {
          this.aQx = (LinearLayout)param3View;
          this.cPN = (TextView)param3View.findViewById(2131299468);
          this.cPO = (GridView)param3View.findViewById(2131297204);
        }
      }
      
      static final class b {
        LinearLayout aQx;
        
        TextView cPP;
        
        GridView cPQ;
        
        b(View param3View) {
          this.aQx = (LinearLayout)param3View;
          this.cPP = (TextView)param3View.findViewById(2131299529);
          this.cPQ = (GridView)param3View.findViewById(2131297205);
        }
      }
      
      static final class c {
        LinearLayout aQx;
        
        TextView cPR;
        
        GridView cPS;
        
        c(View param3View) {
          this.aQx = (LinearLayout)param3View;
          this.cPR = (TextView)param3View.findViewById(2131299771);
          this.cPS = (GridView)param3View.findViewById(2131297207);
        }
      }
    }
    
    static final class a {
      LinearLayout aQx;
      
      TextView cPN;
      
      GridView cPO;
      
      a(View param2View) {
        this.aQx = (LinearLayout)param2View;
        this.cPN = (TextView)param2View.findViewById(2131299468);
        this.cPO = (GridView)param2View.findViewById(2131297204);
      }
    }
    
    static final class b {
      LinearLayout aQx;
      
      TextView cPP;
      
      GridView cPQ;
      
      b(View param2View) {
        this.aQx = (LinearLayout)param2View;
        this.cPP = (TextView)param2View.findViewById(2131299529);
        this.cPQ = (GridView)param2View.findViewById(2131297205);
      }
    }
    
    static final class c {
      LinearLayout aQx;
      
      TextView cPR;
      
      GridView cPS;
      
      c(View param2View) {
        this.aQx = (LinearLayout)param2View;
        this.cPR = (TextView)param2View.findViewById(2131299771);
        this.cPS = (GridView)param2View.findViewById(2131297207);
      }
    }
  }
  
  static final class a {
    RelativeLayout aQo;
    
    TextView bNf;
    
    TextView cPI;
    
    TextView cPJ;
    
    TextView csp;
    
    a(View param1View) {
      this.aQo = (RelativeLayout)param1View;
      this.cPI = (TextView)param1View.findViewById(2131299508);
      this.csp = (TextView)param1View.findViewById(2131299511);
      this.cPJ = (TextView)param1View.findViewById(2131299476);
      this.bNf = (TextView)param1View.findViewById(2131299494);
    }
  }
  
  static final class b {
    LinearLayout aQx;
    
    a cPK;
    
    c cPL;
    
    b cPM;
    
    b(View param1View) {
      this.aQx = (LinearLayout)param1View;
      this.cPK = new a(param1View.findViewById(2131297499));
      this.cPL = new c(param1View.findViewById(2131297702));
      this.cPM = new b(param1View.findViewById(2131297556));
    }
    
    static final class a {
      LinearLayout aQx;
      
      TextView cPN;
      
      GridView cPO;
      
      a(View param3View) {
        this.aQx = (LinearLayout)param3View;
        this.cPN = (TextView)param3View.findViewById(2131299468);
        this.cPO = (GridView)param3View.findViewById(2131297204);
      }
    }
    
    static final class b {
      LinearLayout aQx;
      
      TextView cPP;
      
      GridView cPQ;
      
      b(View param3View) {
        this.aQx = (LinearLayout)param3View;
        this.cPP = (TextView)param3View.findViewById(2131299529);
        this.cPQ = (GridView)param3View.findViewById(2131297205);
      }
    }
    
    static final class c {
      LinearLayout aQx;
      
      TextView cPR;
      
      GridView cPS;
      
      c(View param3View) {
        this.aQx = (LinearLayout)param3View;
        this.cPR = (TextView)param3View.findViewById(2131299771);
        this.cPS = (GridView)param3View.findViewById(2131297207);
      }
    }
  }
  
  static final class a {
    LinearLayout aQx;
    
    TextView cPN;
    
    GridView cPO;
    
    a(View param1View) {
      this.aQx = (LinearLayout)param1View;
      this.cPN = (TextView)param1View.findViewById(2131299468);
      this.cPO = (GridView)param1View.findViewById(2131297204);
    }
  }
  
  static final class b {
    LinearLayout aQx;
    
    TextView cPP;
    
    GridView cPQ;
    
    b(View param1View) {
      this.aQx = (LinearLayout)param1View;
      this.cPP = (TextView)param1View.findViewById(2131299529);
      this.cPQ = (GridView)param1View.findViewById(2131297205);
    }
  }
  
  static final class c {
    LinearLayout aQx;
    
    TextView cPR;
    
    GridView cPS;
    
    c(View param1View) {
      this.aQx = (LinearLayout)param1View;
      this.cPR = (TextView)param1View.findViewById(2131299771);
      this.cPS = (GridView)param1View.findViewById(2131297207);
    }
  }
  
  private static final class c {
    LinearLayout aQx;
    
    a cPT;
    
    TextView cPU;
    
    TextView ccm;
    
    TextView cvO;
    
    c(View param1View) {
      this.aQx = (LinearLayout)param1View;
      this.cPT = new a(param1View.findViewById(2131297662));
      this.cPU = (TextView)param1View.findViewById(2131299685);
      this.cvO = (TextView)param1View.findViewById(2131299813);
      this.ccm = (TextView)param1View.findViewById(2131299605);
    }
    
    static final class a {
      LinearLayout aQx;
      
      ImageView cJE;
      
      ImageView cJG;
      
      a(View param2View) {
        this.aQx = (LinearLayout)param2View;
        this.cJE = (ImageView)param2View.findViewById(2131296643);
        this.cJG = (ImageView)param2View.findViewById(2131296636);
      }
    }
  }
  
  static final class a {
    LinearLayout aQx;
    
    ImageView cJE;
    
    ImageView cJG;
    
    a(View param1View) {
      this.aQx = (LinearLayout)param1View;
      this.cJE = (ImageView)param1View.findViewById(2131296643);
      this.cJG = (ImageView)param1View.findViewById(2131296636);
    }
  }
  
  @SuppressLint({"CheckResult"})
  static class d {
    final c<String> beK = c.wO();
    
    final b<Boolean> bfJ = (this.cQg = (this.cQf = (this.cQe = (this.cQd = b.wJ()).wJ()).ak(Boolean.FALSE)).ak(Boolean.FALSE)).ak(Boolean.FALSE);
    
    final a<c> cPV;
    
    final a<c> cPW;
    
    final a<c> cPX = (this.cPW = (this.cPV = a.aoI()).aoI()).aoI();
    
    final b<HashMap<Long, Integer>> cPY = b.ak(new HashMap());
    
    final a<e> cPZ;
    
    final a<e> cQa;
    
    final a<e> cQb = (this.cQa = (this.cPZ = a.aoI()).aoI()).aoI();
    
    final b<Boolean> cQc;
    
    final b<String> cQd;
    
    final b<Long> cQe;
    
    final b<Boolean> cQf;
    
    final b<Boolean> cQg;
    
    private final f cQh;
    
    private ConcurrentHashMap<Long, b> cQi = new ConcurrentHashMap();
    
    private c<List<c>, HashMap<Long, Integer>, ArrayList<e>> cQj = az.bfR;
    
    private g<Throwable> cQk = new ba(this);
    
    private h<b.b, ArrayList<c>> cQl = bi.beq;
    
    d(f param1f) {
      this.cQh = param1f;
      this.cQc = b.ak(Boolean.FALSE);
      init();
    }
    
    d(f param1f, String param1String, long param1Long, HashMap<Long, Integer> param1HashMap) {
      this.cQh = param1f;
      this.cQc = b.ak(Boolean.TRUE);
      this.cQd.accept(param1String);
      this.cQe.accept(Long.valueOf(param1Long));
      this.cPY.accept(param1HashMap);
      init();
    }
    
    private void a(a<e> param1a) {
      param1a.aoJ().c(a.aKh()).b(new bb(this));
      param1a.aoK().c(a.aKh()).b(new bc(this));
    }
    
    private void init() {
      this.cPV.d(new bm(this)).b(this.cPZ);
      this.cPW.d(new bn(this)).b(this.cQa);
      this.cPX.d(new bo(this)).b(this.cQb);
      this.cPY.b(new bp(this));
      a(this.cPZ);
      a(this.cQa);
      a(this.cQb);
      this.cPV.d(a.aoG()).d(a.aoF()).b(this.cQf);
      this.cPW.d(a.aoG()).d(a.aoF()).b(this.cQg);
      this.cPX.d(a.aoG()).d(a.aoF()).b(this.bfJ);
    }
    
    void ajt() {
      if (this.cPY.getValue() != null && ((HashMap)this.cPY.getValue()).size() != 0)
        this.cPY.accept(new HashMap()); 
    }
    
    void aju() {
      n n = new b(this.cQh);
      if (this.cQe.getValue() != null) {
        n = n.a(b.a.w(Collections.singleton(this.cQe.getValue())));
      } else {
        n = n.a(b.a.akl());
      } 
      a a1 = n.f(a.aKh()).aJf().c(bd.beq).aJi();
      a1.a(be.aEo).aJl().a(this.cPV, this.cQk);
      a1.a(bf.aEo).aJl().a(this.cPW, this.cQk);
      a1.a(bg.aEo).aJl().a(this.cPX, this.cQk);
      a1.aKc();
    }
    
    void ajv() {
      n n = new b(this.cQh);
      if (this.cQe.getValue() != null) {
        n = n.a(b.a.a(Collections.singleton(this.cQe.getValue()), Collections.singleton(Long.valueOf(0L))));
      } else {
        n = n.a(b.a.x(Collections.singleton(Long.valueOf(0L))));
      } 
      n.f(a.aKh()).g(this.cQl).a(this.cPV, this.cQk);
    }
    
    void ajw() {
      n n = new b(this.cQh);
      if (this.cQe.getValue() != null) {
        n = n.a(b.a.a(Collections.singleton(this.cQe.getValue()), Collections.singletonList(Long.valueOf(4L))));
      } else {
        n = n.a(b.a.x(Collections.singleton(Long.valueOf(4L))));
      } 
      n.f(a.aKh()).e(a.aKg()).g(this.cQl).a(this.cPW, this.cQk);
    }
    
    void ajx() {
      n n = new b(this.cQh);
      List list = Arrays.asList(new Long[] { null, null, (new Long[3][1] = (new Long[3][0] = Long.valueOf(3L)).valueOf(1L)).valueOf(2L) });
      if (this.cQe.getValue() != null) {
        n = n.a(b.a.a(Collections.singleton(this.cQe.getValue()), list));
      } else {
        n = n.a(b.a.x(list));
      } 
      n.f(a.aKh()).g(this.cQl).a(this.cPX, this.cQk);
    }
    
    void cE(long param1Long) {
      HashMap hashMap = (HashMap)this.cPY.getValue();
      if ((Integer)hashMap.remove(Long.valueOf(param1Long)) != null)
        this.cPY.accept(hashMap); 
    }
    
    static class a {
      e cQn;
      
      b<Boolean> cQo = b.wJ();
      
      public a(e param2e, boolean param2Boolean) {
        this.cQn = param2e;
        this.cQo.accept(Boolean.valueOf(param2Boolean));
      }
      
      public String toString() { return this.cQn.toString(); }
    }
  }
  
  static class a {
    e cQn;
    
    b<Boolean> cQo = b.wJ();
    
    public a(e param1e, boolean param1Boolean) {
      this.cQn = param1e;
      this.cQo.accept(Boolean.valueOf(param1Boolean));
    }
    
    public String toString() { return this.cQn.toString(); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\ProductAttributeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */