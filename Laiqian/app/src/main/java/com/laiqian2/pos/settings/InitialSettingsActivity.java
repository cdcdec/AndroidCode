package com.laiqian.pos.settings;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import com.google.a.a.a.a.a.a;
import com.laiqian.c.a;
import com.laiqian.d.a;
import com.laiqian.models.an;
import com.laiqian.models.h;
import com.laiqian.network.o;
import com.laiqian.sync.a.g;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.a.r;
import com.laiqian.ui.a.w;
import com.laiqian.ui.container.ab;
import com.laiqian.util.by;
import com.laiqian.util.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.FutureTask;

public class InitialSettingsActivity extends ActivityRoot implements v {
  private r bCF;
  
  int cii = 0;
  
  HashMap<String, Integer> czo = new HashMap();
  
  StringBuffer czp;
  
  boolean czq;
  
  a czr = new a(16908290);
  
  u czs;
  
  ViewGroup czt;
  
  private Handler mHandler = new k(this);
  
  private bb mWaitingDialog;
  
  TextView tvTitle;
  
  private String[] G(HashMap<String, h.e> paramHashMap) {
    ArrayList arrayList = new ArrayList();
    Iterator iterator = paramHashMap.values().iterator();
    while (iterator.hasNext())
      arrayList.add(((h.e)iterator.next()).getName()); 
    return (String[])arrayList.toArray(new String[0]);
  }
  
  private String[] H(HashMap<String, h.a> paramHashMap) {
    ArrayList arrayList = new ArrayList();
    Iterator iterator = paramHashMap.values().iterator();
    while (iterator.hasNext())
      arrayList.add(((h.a)iterator.next()).getName()); 
    return (String[])arrayList.toArray(new String[0]);
  }
  
  private String[] I(HashMap<String, h.c> paramHashMap) {
    ArrayList arrayList = new ArrayList();
    Iterator iterator = paramHashMap.values().iterator();
    while (iterator.hasNext())
      arrayList.add(((h.c)iterator.next()).getName()); 
    return (String[])arrayList.toArray(new String[0]);
  }
  
  private void RD() {
    this.mHandler.obtainMessage(3).sendToTarget();
    try {
      g g = new g(getActivity());
      o.WQ().a(new FutureTask(new l(this, g), null));
      return;
    } catch (InterruptedException interruptedException) {
      a.e(interruptedException);
      return;
    } 
  }
  
  private void RE() {
    this.mWaitingDialog = new bb(getActivity());
    this.mWaitingDialog.setCancelable(false);
    this.bCF = new r(getActivity(), true, null);
    this.bCF.oZ(getString(2131624572));
    this.bCF.t(getString(2131628119));
    this.bCF.setTitle(getString(2131626722));
    this.bCF.s(getString(2131624852));
    r r1 = new r(getActivity(), true, null);
    r1.setTitle(getString(2131626722));
    r1.s(getString(2131625742));
    r1.arm().setText(getString(2131626715));
    r1.arn().setText(2131625741);
  }
  
  private void abQ() {
    ((Button)this.czr.czE.getView()).setBackgroundResource(2131231726);
    ((ViewGroup)this.czr.czB.cAJ.getView()).setBackgroundResource(2131231854);
    ((ViewGroup)this.czr.czB.cAK.getView()).setBackgroundResource(2131231853);
    ((ViewGroup)this.czr.czB.cAL.getView()).setBackgroundResource(2131231847);
    ((ViewGroup)this.czr.czC.cAm.getView()).setBackgroundResource(2131231846);
    ((RelativeLayout)this.czr.czD.cAk.getView()).setBackgroundResource(2131231847);
    ((RelativeLayout)this.czr.czD.cAj.getView()).setBackgroundResource(2131231855);
    ((Button)this.czr.czE.getView()).setText(getString(2131625885));
    if (a.zR().Ad()) {
      ((ImageView)this.czr.czz.czG.getView()).setVisibility(8);
      ((TextView)this.czr.czz.czJ.getView()).setVisibility(8);
    } 
  }
  
  private void acS() {
    View view4 = findViewById(2131297675);
    View view1 = view4.findViewById(2131297999);
    View view2 = view4.findViewById(2131297998);
    View view3 = view4.findViewById(2131296714);
    view4 = view4.findViewById(2131296713);
    if (a.AZ().By()) {
      view4.setSelected(true);
      a.AZ().bQ(true);
    } else {
      view3.setSelected(true);
      a.AZ().bQ(false);
    } 
    view1.setOnClickListener(new b(view3, view4));
    view2.setOnClickListener(new c(view4, view3));
  }
  
  private void acT() { this.czs.hs(2); }
  
  private void acU() { this.czs.hs(1); }
  
  private void acV() {
    h.a a1 = this.czs.adj();
    if (a1 == null) {
      Toast.makeText(this, 2131629658, 0).show();
      return;
    } 
    String[] arrayOfString = I(a1.UK());
    (new w(this, arrayOfString, new e(this, arrayOfString, a1))).show();
  }
  
  private void acW() {
    h.e e = this.czs.adi();
    if (e == null) {
      Toast.makeText(this, 2131629658, 0).show();
      return;
    } 
    String[] arrayOfString = H(e.UO());
    (new w(this, arrayOfString, new f(this, arrayOfString, e))).show();
  }
  
  private void acX() {
    h.b b = h.aM(this).UJ();
    String[] arrayOfString = G(b.UM());
    (new w(this, arrayOfString, new g(this, arrayOfString, b))).show();
  }
  
  private void acY() {
    String[] arrayOfString;
    this.czq = true;
    if (!getResources().getBoolean(2131034123)) {
      arrayOfString = new String[26];
      arrayOfString[0] = an.q(this, 160007);
      arrayOfString[1] = an.q(this, 160008);
      arrayOfString[2] = an.q(this, 160009);
      arrayOfString[3] = an.q(this, 160010);
      arrayOfString[4] = an.q(this, 1600011);
      arrayOfString[5] = an.q(this, 1600012);
      arrayOfString[6] = an.q(this, 1600013);
      arrayOfString[7] = an.q(this, 1600014);
      arrayOfString[8] = an.q(this, 1600015);
      arrayOfString[9] = an.q(this, 1600016);
      arrayOfString[10] = an.q(this, 1600017);
      arrayOfString[11] = an.q(this, 1600018);
      arrayOfString[12] = an.q(this, 1600019);
      arrayOfString[13] = an.q(this, 1600020);
      arrayOfString[14] = an.q(this, 1600021);
      arrayOfString[15] = an.q(this, 1600022);
      arrayOfString[16] = an.q(this, 1600023);
      arrayOfString[17] = an.q(this, 1600024);
      arrayOfString[18] = an.q(this, 1600025);
      arrayOfString[19] = an.q(this, 1600026);
      arrayOfString[20] = an.q(this, 1600027);
      arrayOfString[21] = an.q(this, 1600028);
      arrayOfString[22] = an.q(this, 1600029);
      arrayOfString[23] = an.q(this, 1600030);
      arrayOfString[24] = an.q(this, 1600031);
      arrayOfString[25] = an.q(this, 1600032);
    } else {
      arrayOfString = new String[5];
      arrayOfString[0] = an.q(this, 160001);
      arrayOfString[1] = an.q(this, 160003);
      arrayOfString[2] = an.q(this, 160002);
      arrayOfString[3] = an.q(this, 160004);
      arrayOfString[4] = an.q(this, 160006);
    } 
    (new w(this, arrayOfString, new h(this), true, getActivity().getResources().getBoolean(2131034123) ^ true, this.czo)).show();
  }
  
  private void acZ() {
    String str1 = an.p(this, 1);
    String str2 = an.p(this, 2);
    i i = new i(this);
    (new w(this, new String[] { str1, str2 }, i)).show();
  }
  
  private void ada() {
    if (this.cii == 0)
      return; 
    ((ViewFlipper)this.czr.czA.getView()).showPrevious();
    this.cii--;
    if (a.zR().Ad() && this.cii == 1) {
      ((ViewFlipper)this.czr.czA.getView()).showPrevious();
      this.cii = 0;
    } 
    hp(this.cii);
  }
  
  private void adb() {
    if (((ViewFlipper)this.czr.czA.getView()).getDisplayedChild() == ((ViewFlipper)this.czr.czA.getView()).getChildCount() - 1) {
      if (a.AZ().By()) {
        RD();
        return;
      } 
      adc();
      return;
    } 
    if (hq(this.cii)) {
      ((ViewFlipper)this.czr.czA.getView()).showNext();
      this.cii++;
      if (a.zR().Ad() && this.cii == 1) {
        ((ViewFlipper)this.czr.czA.getView()).showNext();
        this.cii = 2;
      } 
      hp(this.cii);
    } 
  }
  
  private void adc() {
    if (this.czs.save()) {
      (new cn(this)).adD();
    } else {
      Toast.makeText(this, 2131628396, 0).show();
    } 
    startActivity(new Intent(this, p.bP(this)));
    finish();
  }
  
  @NonNull
  private StringBuffer add() {
    ArrayList arrayList = new ArrayList(this.czo.entrySet());
    Collections.sort(arrayList, new j(this));
    StringBuffer stringBuffer = new StringBuffer();
    this.czp = new StringBuffer();
    for (byte b = 0; b < arrayList.size(); b++) {
      Map.Entry entry = (Map.Entry)arrayList.get(b);
      if (b != 0) {
        stringBuffer.append(",");
        this.czp.append(",");
      } 
      stringBuffer.append((String)entry.getKey());
      this.czp.append(entry.getValue());
    } 
    return stringBuffer;
  }
  
  private void hp(int paramInt) {
    switch (paramInt) {
      case 2:
        this.czr.czz.adg();
        break;
      case 1:
        this.czr.czz.adf();
        break;
      case 0:
        this.czr.czz.ade();
        break;
    } 
    if (paramInt == 0) {
      this.czt.setVisibility(8);
    } else {
      this.czt.setVisibility(0);
    } 
    if (paramInt == ((ViewFlipper)this.czr.czA.getView()).getChildCount() - 1) {
      ((Button)this.czr.czE.getView()).setText(getString(2131625389));
      return;
    } 
    ((Button)this.czr.czE.getView()).setText(getString(2131625885));
  }
  
  private boolean hq(int paramInt) {
    switch (paramInt) {
      case 2:
        if (this.czs.adn() == -1) {
          Toast.makeText(this, "请选择结算方式", 0).show();
          return false;
        } 
        break;
      case 1:
        if (this.czs.adi() == null) {
          Toast.makeText(this, 2131629658, 0).show();
          return false;
        } 
        if (this.czs.adj() == null) {
          Toast.makeText(this, 2131629645, 0).show();
          return false;
        } 
        if (this.czs.adk() == null) {
          Toast.makeText(this, 2131629649, 0).show();
          return false;
        } 
        if (!this.czs.jW(((EditText)this.czr.czC.cAm.dwQ.getView()).getText().toString())) {
          Toast.makeText(this, 2131629647, 0).show();
          return false;
        } 
        break;
      case 0:
        if (!this.czs.jV(((EditText)this.czr.czB.cAJ.dwQ.getView()).getText().toString())) {
          Toast.makeText(this, 2131629656, 0).show();
          return false;
        } 
        if (this.czs.adl() == 0) {
          Toast.makeText(this, 2131629660, 0).show();
          return false;
        } 
        if (by.isNull(this.czs.adm())) {
          Toast.makeText(this, 2131629660, 0).show();
          return false;
        } 
        break;
    } 
    return true;
  }
  
  private void setListeners() {
    this.czt.setOnClickListener(new d(this));
    ((Button)this.czr.czE.getView()).setOnClickListener(new m(this));
    ((ViewGroup)this.czr.czB.cAL.getView()).setOnClickListener(new n(this));
    ((ViewGroup)this.czr.czB.cAK.getView()).setOnClickListener(new o(this));
    ((TextView)this.czr.czC.cAl.dwH.getView()).setOnClickListener(new p(this));
    ((TextView)this.czr.czC.cAl.dwI.getView()).setOnClickListener(new q(this));
    ((TextView)this.czr.czC.cAl.dwJ.getView()).setOnClickListener(new r(this));
    ((RelativeLayout)this.czr.czD.cAj.getView()).setOnClickListener(new s(this));
    ((RelativeLayout)this.czr.czD.cAk.getView()).setOnClickListener(new t(this));
  }
  
  public void b(h.c paramc) { this.czr.czC.b(paramc); }
  
  public void d(h.a parama) { this.czr.czC.d(parama); }
  
  public void d(h.e parame) { this.czr.czC.d(parame); }
  
  public void dK(String paramString) { ((EditText)this.czr.czB.cAJ.dwQ.getView()).setText(paramString); }
  
  public String ho(int paramInt) {
    if (getResources().getBoolean(2131034123))
      this.czo = new HashMap(); 
    if (by.isNull(this.czp.toString())) {
      this.czo.put(an.q(this, paramInt), Integer.valueOf(paramInt));
      return an.q(this, paramInt);
    } 
    if (this.czo.containsKey(an.q(this, paramInt))) {
      this.czo.remove(an.q(this, paramInt));
    } else {
      this.czo.put(an.q(this, paramInt), Integer.valueOf(paramInt));
    } 
    add();
    return this.czp.toString();
  }
  
  public void hr(int paramInt) {
    if (paramInt == 1) {
      ((TextView)this.czr.czB.cAK.cAP.getView()).setText(2131629662);
      return;
    } 
    if (paramInt == 2)
      ((TextView)this.czr.czB.cAK.cAP.getView()).setText(2131629661); 
  }
  
  public void hs(int paramInt) {
    if (paramInt == 2) {
      ((ImageView)this.czr.czD.cAk.dwO.getView()).setVisibility(0);
      ((ImageView)this.czr.czD.cAj.dwO.getView()).setVisibility(4);
      return;
    } 
    if (paramInt == 1) {
      ((ImageView)this.czr.czD.cAk.dwO.getView()).setVisibility(4);
      ((ImageView)this.czr.czD.cAj.dwO.getView()).setVisibility(0);
    } 
  }
  
  public void jR(String paramString) { ((EditText)this.czr.czC.cAm.dwQ.getView()).setText(paramString); }
  
  public void kD(String paramString) {
    String[] arrayOfString = paramString.split(",");
    if (!this.czq)
      for (byte b = 0; b < arrayOfString.length; b++) {
        int i = Integer.parseInt(arrayOfString[b]);
        if (this.czo.containsKey(an.q(this, i))) {
          this.czo.remove(an.q(this, i));
        } else {
          this.czo.put(an.q(this, i), Integer.valueOf(i));
        } 
      }  
    StringBuffer stringBuffer = add();
    ((TextView)this.czr.czB.cAL.cAP.getView()).setText(stringBuffer.toString());
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131427376);
    getWindow().setFeatureInt(7, 2131428168);
    this.czr.S(findViewById(this.czr.getId()));
    this.czs = new u(this);
    this.czs.a(this);
    findViewById(2131299879).setVisibility(8);
    this.czt = (ViewGroup)findViewById(2131299878);
    this.tvTitle = (TextView)findViewById(2131299889);
    this.tvTitle.setText(getString(2131628671));
    acS();
    abQ();
    this.cii = 0;
    hp(this.cii);
    setListeners();
    RE();
  }
  
  static class a extends ab<ViewGroup> {
    public ab<ViewFlipper> czA = new ab(2131297058);
    
    public bd czB = new bd(2131297673);
    
    public an czC = new an(2131297669);
    
    public am czD = new am(2131297668);
    
    public ab<Button> czE = new ab(2131296639);
    
    public a czz = new a(2131297573);
    
    public a(int param1Int) { super(param1Int); }
    
    public static class a extends ab<ViewGroup> {
      public ab<ImageView> czF = new ab(2131297380);
      
      public ab<ImageView> czG = new ab(2131297378);
      
      public ab<ImageView> czH = new ab(2131297379);
      
      public ab<TextView> czI = new ab(2131299568);
      
      public ab<TextView> czJ = new ab(2131299564);
      
      public ab<TextView> czK = new ab(2131299567);
      
      public a(int param2Int) { super(param2Int); }
      
      public void S(View param2View) { super.S(param2View); }
      
      public void ade() {
        ((ImageView)this.czF.getView()).setEnabled(true);
        ((TextView)this.czI.getView()).setEnabled(true);
        ((ImageView)this.czG.getView()).setEnabled(false);
        ((TextView)this.czJ.getView()).setEnabled(false);
        ((ImageView)this.czH.getView()).setEnabled(false);
        ((TextView)this.czK.getView()).setEnabled(false);
      }
      
      public void adf() {
        ((ImageView)this.czG.getView()).setEnabled(true);
        ((TextView)this.czJ.getView()).setEnabled(true);
        ((ImageView)this.czF.getView()).setEnabled(false);
        ((TextView)this.czI.getView()).setEnabled(false);
        ((ImageView)this.czH.getView()).setEnabled(false);
        ((TextView)this.czK.getView()).setEnabled(false);
      }
      
      public void adg() {
        ((ImageView)this.czH.getView()).setEnabled(true);
        ((TextView)this.czK.getView()).setEnabled(true);
        ((ImageView)this.czG.getView()).setEnabled(false);
        ((TextView)this.czJ.getView()).setEnabled(false);
        ((ImageView)this.czF.getView()).setEnabled(false);
        ((TextView)this.czI.getView()).setEnabled(false);
      }
    }
  }
  
  public static class a extends ab<ViewGroup> {
    public ab<ImageView> czF = new ab(2131297380);
    
    public ab<ImageView> czG = new ab(2131297378);
    
    public ab<ImageView> czH = new ab(2131297379);
    
    public ab<TextView> czI = new ab(2131299568);
    
    public ab<TextView> czJ = new ab(2131299564);
    
    public ab<TextView> czK = new ab(2131299567);
    
    public a(int param1Int) { super(param1Int); }
    
    public void S(View param1View) { super.S(param1View); }
    
    public void ade() {
      ((ImageView)this.czF.getView()).setEnabled(true);
      ((TextView)this.czI.getView()).setEnabled(true);
      ((ImageView)this.czG.getView()).setEnabled(false);
      ((TextView)this.czJ.getView()).setEnabled(false);
      ((ImageView)this.czH.getView()).setEnabled(false);
      ((TextView)this.czK.getView()).setEnabled(false);
    }
    
    public void adf() {
      ((ImageView)this.czG.getView()).setEnabled(true);
      ((TextView)this.czJ.getView()).setEnabled(true);
      ((ImageView)this.czF.getView()).setEnabled(false);
      ((TextView)this.czI.getView()).setEnabled(false);
      ((ImageView)this.czH.getView()).setEnabled(false);
      ((TextView)this.czK.getView()).setEnabled(false);
    }
    
    public void adg() {
      ((ImageView)this.czH.getView()).setEnabled(true);
      ((TextView)this.czK.getView()).setEnabled(true);
      ((ImageView)this.czG.getView()).setEnabled(false);
      ((TextView)this.czJ.getView()).setEnabled(false);
      ((ImageView)this.czF.getView()).setEnabled(false);
      ((TextView)this.czI.getView()).setEnabled(false);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\InitialSettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */