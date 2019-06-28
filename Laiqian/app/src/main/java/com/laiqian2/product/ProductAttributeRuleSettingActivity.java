package com.laiqian.product;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jakewharton.b.b;
import com.jakewharton.b.c;
import com.jakewharton.rxbinding2.a.a;
import com.jakewharton.rxbinding2.b.e;
import com.laiqian.product.a.a;
import com.laiqian.product.a.d;
import com.laiqian.product.a.i;
import com.laiqian.rx.a.b.a;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.container.aa;
import io.reactivex.a.a;
import io.reactivex.c.h;
import io.reactivex.h;

public class ProductAttributeRuleSettingActivity extends ActivityRoot {
  private final a bgv = new a();
  
  a cQA;
  
  private b cQB;
  
  aa titleBar;
  
  private void Mq() {
    h h1 = this.cQB.cQJ.d(new cd(this));
    h h2 = h1.d(a.aoF());
    this.bgv.b(h1.d(ajB()).b(e.d(this.cQA.cQD.cQH)));
    this.bgv.b(h2.d(ajB()).b(e.d(this.cQA.cQE.cQF)));
    this.bgv.b(h1.b(a.bv(this.cQA.cQD.aQx)));
    this.bgv.b(h2.b(a.bv(this.cQA.cQE.aQx)));
    this.bgv.b(this.cQB.beK.b(new ce(this)));
    this.bgv.b(this.cQB.cQK.b(new cf(this)));
  }
  
  public static Intent aQ(Context paramContext) { return new Intent(paramContext, ProductAttributeRuleSettingActivity.class); }
  
  private void ahr() { this.cQB.ajC(); }
  
  private b ajA() { return new b(getResources()); }
  
  private h<Boolean, Integer> ajB() { return new cg(this); }
  
  private void save() { this.cQB.save(); }
  
  private void setupViews() {
    this.titleBar.bri.setOnClickListener(new bz(this));
    this.titleBar.tvTitle.setText(2131624251);
    this.titleBar.brj.setVisibility(8);
    this.titleBar.brk.setText(2131629495);
    this.titleBar.brk.setVisibility(0);
    this.titleBar.brk.setOnClickListener(new ca(this));
    this.cQA.cQD.aQx.setOnClickListener(new cb(this));
    this.cQA.cQE.aQx.setOnClickListener(new cc(this));
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.cQA = a.n(getWindow());
    this.titleBar = aa.M(getActivity());
    this.cQB = ajA();
    setupViews();
    Mq();
    ahr();
  }
  
  protected void onDestroy() {
    this.bgv.clear();
    super.onDestroy();
  }
  
  private static class a {
    View aQG;
    
    b cQD;
    
    a cQE;
    
    public a(View param1View) {
      this.aQG = param1View;
      this.cQD = new b((LinearLayout)param1View.findViewById(2131297575));
      this.cQE = new a((LinearLayout)param1View.findViewById(2131297563));
    }
    
    public static a n(Window param1Window) {
      a a1 = t(param1Window.getLayoutInflater());
      param1Window.setContentView(a1.aQG);
      return a1;
    }
    
    public static a t(LayoutInflater param1LayoutInflater) { return new a(param1LayoutInflater.inflate(2131427404, null)); }
    
    static class a {
      LinearLayout aQx;
      
      TextView cQF;
      
      ImageView cQG;
      
      public a(LinearLayout param2LinearLayout) {
        this.aQx = param2LinearLayout;
        this.cQF = (TextView)param2LinearLayout.findViewById(2131299565);
        this.cQG = (ImageView)param2LinearLayout.findViewById(2131297369);
      }
    }
    
    static class b {
      LinearLayout aQx;
      
      TextView cQH;
      
      ImageView cQI;
      
      public b(LinearLayout param2LinearLayout) {
        this.aQx = param2LinearLayout;
        this.cQH = (TextView)param2LinearLayout.findViewById(2131299566);
        this.cQI = (ImageView)param2LinearLayout.findViewById(2131297377);
      }
    }
  }
  
  static class a {
    LinearLayout aQx;
    
    TextView cQF;
    
    ImageView cQG;
    
    public a(LinearLayout param1LinearLayout) {
      this.aQx = param1LinearLayout;
      this.cQF = (TextView)param1LinearLayout.findViewById(2131299565);
      this.cQG = (ImageView)param1LinearLayout.findViewById(2131297369);
    }
  }
  
  static class b {
    LinearLayout aQx;
    
    TextView cQH;
    
    ImageView cQI;
    
    public b(LinearLayout param1LinearLayout) {
      this.aQx = param1LinearLayout;
      this.cQH = (TextView)param1LinearLayout.findViewById(2131299566);
      this.cQI = (ImageView)param1LinearLayout.findViewById(2131297377);
    }
  }
  
  private static class b {
    private final Resources anu;
    
    c<String> beK;
    
    b<a> cQJ = b.wJ();
    
    c<Object> cQK = (this.beK = c.wO()).wO();
    
    b(Resources param1Resources) { this.anu = param1Resources; }
    
    void ajC() { (new d()).a(new d.a()).g(new ch(this)).b(this.cQJ); }
    
    void jk(int param1Int) {
      if (param1Int != ((a)this.cQJ.getValue()).getValue())
        this.cQJ.accept(new a(param1Int)); 
    }
    
    void save() { (new i()).a(new i.a((a)this.cQJ.getValue())).a(new ci(this), new cj(this)); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\ProductAttributeRuleSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */