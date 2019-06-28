package com.laiqian.print.printtype;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.laiqian.print.bm;
import com.laiqian.print.usage.e;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.r;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.h;
import com.laiqian.util.ae;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class PrintTypeSelectionsActivity extends ActivityRoot {
  private HashMap<bm, ArrayList<j>> cJs;
  
  private a cJt;
  
  private aa titleBar;
  
  public static Intent a(Context paramContext, Collection<e> paramCollection) {
    HashMap hashMap = new HashMap();
    for (e e : paramCollection)
      hashMap.put(e.ahZ(), new ArrayList(e.aia())); 
    return a(paramContext, hashMap);
  }
  
  public static Intent a(Context paramContext, HashMap<bm, ArrayList<j>> paramHashMap) {
    Intent intent = new Intent(paramContext, PrintTypeSelectionsActivity.class);
    intent.putExtra("USAGE_ORDER_SELECTIONS", paramHashMap);
    return intent;
  }
  
  private void a(bm parambm, TextView paramTextView, h paramh) {
    ArrayList arrayList = new ArrayList();
    if (this.cJs.containsKey(parambm))
      for (j j : (ArrayList)this.cJs.get(parambm)) {
        if (a(j))
          arrayList.add(j); 
      }  
    LayoutInflater layoutInflater = LayoutInflater.from(this);
    if (arrayList.size() > 0) {
      paramTextView.setVisibility(0);
      for (j j : arrayList) {
        b b = b.m(layoutInflater);
        a(b, j);
        paramh.addView(b.aQx);
      } 
    } else {
      paramTextView.setVisibility(8);
    } 
  }
  
  private void a(b paramb, j paramj) {
    paramb.ccm.setText(q(this, paramj.cJr));
    paramb.cJF.setText(String.valueOf(paramj.cCC));
    paramb.cJG.setOnClickListener(new n(this, paramj, paramb));
    paramb.cJE.setOnClickListener(new o(this, paramb, paramj));
    paramb.aQx.setTag(paramj);
  }
  
  private boolean a(j paramj) {
    byte b;
    String str = paramj.cJr;
    switch (str.hashCode()) {
      default:
        b = -1;
        break;
      case 1676462825:
        if (str.equals("kitchen_total")) {
          b = 1;
          break;
        } 
      case 608149564:
        if (str.equals("kitchen_port")) {
          b = 0;
          break;
        } 
      case 109407362:
        if (str.equals("shift")) {
          b = 5;
          break;
        } 
      case 3083674:
        if (str.equals("dish")) {
          b = 4;
          break;
        } 
      case 111267:
        if (str.equals("pre")) {
          b = 2;
          break;
        } 
      case -545214652:
        if (str.equals("settle_receipt")) {
          b = 3;
          break;
        } 
      case -1544791705:
        if (str.equals("takeout")) {
          b = 6;
          break;
        } 
    } 
    switch (b) {
      default:
        return false;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
        break;
    } 
    return true;
  }
  
  private void ahp() {
    Intent intent = new Intent();
    intent.putExtra("USAGE_ORDER_SELECTIONS", ahq());
    setResult(-1, intent);
    finish();
  }
  
  private HashMap<bm, ArrayList<j>> ahq() {
    HashMap hashMap = new HashMap();
    ArrayList arrayList = new ArrayList();
    byte b2 = 0;
    byte b1;
    for (b1 = 0; b1 < this.cJt.cJA.aqO(); b1++) {
      Object object = this.cJt.cJA.dp(b1).getTag();
      if (object instanceof j)
        arrayList.add((j)object); 
    } 
    if (arrayList.size() > 0)
      hashMap.put(bm.cEf, arrayList); 
    arrayList = new ArrayList();
    for (b1 = b2; b1 < this.cJt.cJD.aqO(); b1++) {
      Object object = this.cJt.cJD.dp(b1).getTag();
      if (object instanceof j)
        arrayList.add((j)object); 
    } 
    if (arrayList.size() > 0)
      hashMap.put(bm.cEh, arrayList); 
    return hashMap;
  }
  
  private void ahr() {
    aht();
    ahs();
  }
  
  private void ahs() {
    a(bm.cEf, this.cJt.cJy, this.cJt.cJA);
    a(bm.cEh, this.cJt.cJB, this.cJt.cJD);
  }
  
  private void aht() { this.cJs = (HashMap)getIntent().getSerializableExtra("USAGE_ORDER_SELECTIONS"); }
  
  private boolean b(HashMap<bm, ArrayList<j>> paramHashMap1, HashMap<bm, ArrayList<j>> paramHashMap2) {
    for (bm bm : paramHashMap2.keySet()) {
      if (!((ArrayList)paramHashMap2.get(bm)).equals(paramHashMap1.get(bm)))
        return true; 
    } 
    return false;
  }
  
  public static HashMap<bm, ArrayList<j>> o(Intent paramIntent) { return paramIntent.hasExtra("USAGE_ORDER_SELECTIONS") ? (HashMap)paramIntent.getSerializableExtra("USAGE_ORDER_SELECTIONS") : null; }
  
  public static String q(Context paramContext, String paramString) {
    byte b;
    StringBuilder stringBuilder;
    switch (paramString.hashCode()) {
      default:
        b = -1;
        break;
      case 1676462825:
        if (paramString.equals("kitchen_total")) {
          b = 2;
          break;
        } 
      case 1328327225:
        if (paramString.equals("delivery_not_specified")) {
          b = 10;
          break;
        } 
      case 608149564:
        if (paramString.equals("kitchen_port")) {
          b = 1;
          break;
        } 
      case 109407362:
        if (paramString.equals("shift")) {
          b = 7;
          break;
        } 
      case 3083674:
        if (paramString.equals("dish")) {
          b = 0;
          break;
        } 
      case 111267:
        if (paramString.equals("pre")) {
          b = 4;
          break;
        } 
      case -545214652:
        if (paramString.equals("settle_receipt")) {
          b = 6;
          break;
        } 
      case -934521548:
        if (paramString.equals("report")) {
          b = 5;
          break;
        } 
      case -1544791705:
        if (paramString.equals("takeout")) {
          b = 8;
          break;
        } 
      case -1846914055:
        if (paramString.equals("member_charge")) {
          b = 3;
          break;
        } 
      case -1979255969:
        if (paramString.equals("tag_not_specified")) {
          b = 9;
          break;
        } 
    } 
    switch (b) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("no such type: ");
        stringBuilder.append(paramString);
        throw new RuntimeException(stringBuilder.toString());
      case 10:
        return stringBuilder.getString(2131628853);
      case 9:
        return stringBuilder.getString(2131628862);
      case 8:
        return stringBuilder.getString(2131628863);
      case 7:
        return stringBuilder.getString(2131628861);
      case 6:
        return stringBuilder.getString(2131628859);
      case 5:
        return stringBuilder.getString(2131628858);
      case 4:
        return stringBuilder.getString(2131628860);
      case 3:
        return stringBuilder.getString(2131628857);
      case 2:
        return stringBuilder.getString(2131628856);
      case 1:
        return stringBuilder.getString(2131628855);
      case 0:
        break;
    } 
    return stringBuilder.getString(2131628854);
  }
  
  private void setupViews() {
    this.titleBar.tvTitle.setText(2131628934);
    this.titleBar.bri.setOnClickListener(new k(this));
    this.titleBar.brj.setText(2131629495);
    this.titleBar.brj.setOnClickListener(new l(this));
    this.titleBar.brk.setVisibility(8);
    this.cJt.cJy.setText(2131628996);
    this.cJt.cJB.setText(2131628982);
  }
  
  public void onBackPressed() {
    if (!b(this.cJs, ahq())) {
      finish();
      return;
    } 
    r r = new r(getActivity(), new m(this));
    r.setTitle(getString(2131627735));
    r.s(getString(2131627733));
    r.t(getString(2131627734));
    r.oZ(getString(2131627732));
    r.show();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.cJt = a.h(getWindow());
    this.titleBar = aa.M(getActivity());
    setupViews();
    ahr();
  }
  
  private static final class a {
    h cJA;
    
    TextView cJB;
    
    LinearLayout cJC;
    
    h cJD;
    
    ScrollView cJx;
    
    TextView cJy;
    
    LinearLayout cJz;
    
    a(View param1View) {
      this.cJx = (ScrollView)param1View;
      this.cJy = (TextView)param1View.findViewById(2131299670);
      this.cJz = (LinearLayout)param1View.findViewById(2131297651);
      this.cJB = (TextView)param1View.findViewById(2131299562);
      this.cJC = (LinearLayout)param1View.findViewById(2131297580);
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ae.b(param1View.getContext(), 56.0F));
      h.a a1 = (new h.a.a()).b(layoutParams).kE(2130772057).kG(2130772055).kF(2130772051).kD(2130772052).kH(-1).aqQ();
      this.cJA = new h(this.cJz, a1);
      this.cJD = new h(this.cJC, a1);
    }
    
    static a h(Window param1Window) {
      a a1 = l(LayoutInflater.from(param1Window.getContext()));
      param1Window.setContentView(a1.cJx);
      return a1;
    }
    
    static a l(LayoutInflater param1LayoutInflater) { return new a(param1LayoutInflater.inflate(2131427401, null)); }
  }
  
  public static final class b {
    LinearLayout aQx;
    
    ImageView cJE;
    
    TextView cJF;
    
    ImageView cJG;
    
    TextView ccm;
    
    b(View param1View) {
      this.aQx = (LinearLayout)param1View;
      this.ccm = (TextView)param1View.findViewById(2131299605);
      this.cJE = (ImageView)param1View.findViewById(2131296643);
      this.cJF = (TextView)param1View.findViewById(2131299515);
      this.cJG = (ImageView)param1View.findViewById(2131296636);
    }
    
    static b m(LayoutInflater param1LayoutInflater) { return new b(param1LayoutInflater.inflate(2131427668, null)); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\printtype\PrintTypeSelectionsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */