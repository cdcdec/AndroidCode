package com.laiqian.main.module.productcart;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.entity.aa;
import com.laiqian.main.ao;
import com.laiqian.main.module.hardware.weight.c;
import com.laiqian.main.module.hardware.weight.h;
import com.laiqian.models.ba;
import com.laiqian.product.models.c;
import com.laiqian.product.models.o;
import com.laiqian.scales.a;
import com.laiqian.scales.a.e;
import com.laiqian.scales.b.b;
import com.laiqian.scales.c.c;
import com.laiqian.ui.ImageCheckBox;
import com.laiqian.util.ar;
import com.laiqian.util.m;
import com.laiqian.util.n;
import java.io.File;
import java.util.ArrayList;

public class aa extends y {
  private static final String TAG = y.class.getSimpleName();
  
  a bgs;
  
  private int bjF = 1;
  
  private TextView bjG;
  
  private EditText bjH;
  
  private EditText bjI;
  
  private View bjJ;
  
  @Nullable
  private TextView bjK;
  
  private b bjL;
  
  private StringBuilder bjM;
  
  private TextView bjN;
  
  private StringBuilder bjO = new StringBuilder();
  
  private View bjP;
  
  private ViewGroup bjQ;
  
  boolean bjR;
  
  private int bjS = 50;
  
  a bjT;
  
  private ImageCheckBox bjU;
  
  private View bjV;
  
  private final Context mContext;
  
  View.OnFocusChangeListener onFocusChangeListener = new al(this);
  
  public aa(Context paramContext, y.b paramb, ArrayList<c> paramArrayList) {
    super(paramContext, 2131427828, paramb, paramArrayList);
    this.mContext = paramContext;
    setCanceledOnTouchOutside(false);
    this.bjG = (TextView)this.mView.findViewById(2131299242);
    View view = findViewById(2131296746);
    ci(view.findViewById(2131297735));
    cj(view.findViewById(2131298737));
    ck(findViewById(2131296483));
    NP();
  }
  
  private void NP() {
    this.bjH.setFilters(ar.bE(99, 3));
    this.bjI.setFilters(ar.lw(99));
  }
  
  private void NQ() {
    if (a.AZ().BE()) {
      Double double = c.MD().MJ();
      if (double != null && double.doubleValue() > 0.0D) {
        if (a.AZ().Cs()) {
          h h = new h(this.mContext);
          h.a(new ak(this, double));
          double d = h.MN();
          if (d < 0.0D) {
            h.cm(this.bjG.getText().toString());
            return;
          } 
          this.bjH.setText(n.a(String.valueOf(Math.ceil(double.doubleValue() / d)), false, false));
          return;
        } 
        this.bjH.setText(n.a(double, false, false));
        return;
      } 
    } else if (a.AZ().BF()) {
      this.bgs = new a(new b(new File("/dev/ttyS0"), '▀', false), new e());
      try {
        if (!this.bgs.isOpened())
          this.bgs.CV(); 
        this.bgs.write(new byte[] { 85, -86 });
        this.bjR = true;
        this.bjT = new a(this);
        this.bjT.start();
        return;
      } catch (Exception exception) {
        a.e(exception);
      } 
    } 
  }
  
  private void NR() {
    if (this.bjK == null)
      return; 
    if (this.bjM.length() == 0) {
      this.bjK.setText(2131627155);
      return;
    } 
    this.bjK.setText(this.bjM);
  }
  
  private void NS() {
    if (this.bjO.length() == 0) {
      this.bjN.setText(2131627155);
      return;
    } 
    this.bjN.setText(this.bjO);
  }
  
  private void b(aa paramaa, String paramString) {
    if (this.bjK == null) {
      this.bjJ.setVisibility(8);
      return;
    } 
    this.bjJ.setVisibility(0);
    this.bjM.setLength(0);
    b.a(this.bjL, paramString);
    if (paramaa.GP() != null)
      for (o o : paramaa.GP()) {
        this.bjM.append(o.akZ());
        this.bjM.append("/");
        for (o o1 : this.bjL.bka) {
          if (o.getId() == o1.getId())
            o1.cVs = true; 
        } 
      }  
    if (this.bjM.length() > 0)
      this.bjM.deleteCharAt(this.bjM.length() - 1); 
    NR();
  }
  
  private void ci(View paramView) {
    View view = paramView.findViewById(2131298645);
    this.bjH = (EditText)view.findViewById(2131298641);
    this.bjH.setOnFocusChangeListener(this.onFocusChangeListener);
    view.setOnClickListener(new m.b(this.mActivity, this.bjH, false));
    view = paramView.findViewById(2131298478);
    this.bjI = (EditText)view.findViewById(2131298473);
    this.bjI.setOnFocusChangeListener(this.onFocusChangeListener);
    view.setOnClickListener(new m.b(this.mActivity, this.bjI, false));
    ao.a(getWindow(), new EditText[] { this.bjH, this.bjI });
    this.bjJ = paramView.findViewById(2131299185);
    if (this.mActivity.getResources().getBoolean(2131034127)) {
      this.bjJ.setVisibility(0);
      this.bjK = (TextView)this.bjJ.findViewById(2131299183);
      this.bjM = new StringBuilder();
      this.bjL = new b(this);
      this.bjJ.setOnClickListener(new ab(this));
    } else {
      this.bjJ.setVisibility(8);
    } 
    paramView = paramView.findViewById(2131296392);
    this.bjN = (TextView)paramView.findViewById(2131296389);
    paramView.setOnClickListener(new ae(this));
    this.bjU = (ImageCheckBox)findViewById(2131298337);
    this.bjU.a(new af(this));
  }
  
  private void cj(View paramView) {
    this.bjQ = (ViewGroup)paramView.findViewById(2131297424);
    ao.a(this, this.bjQ);
  }
  
  private void ck(View paramView) {
    paramView.findViewById(2131296858).setOnClickListener(new ag(this));
    this.bjP = paramView.findViewById(2131300030);
    this.bjP.setOnClickListener(new ah(this));
    paramView.findViewById(2131296671).setOnClickListener(new ai(this));
    this.bjV = paramView.findViewById(2131299105);
    this.bjV.setOnClickListener(new aj(this));
  }
  
  private void dn(boolean paramBoolean) {
    if (paramBoolean) {
      this.bjQ.setVisibility(0);
      this.bjt.setVisibility(8);
      return;
    } 
    this.bjQ.setVisibility(8);
    this.bjt.setVisibility(0);
  }
  
  private void y(ArrayList<c> paramArrayList) {
    if (paramArrayList != null && paramArrayList.size() > 0) {
      Double double = Double.valueOf(((c)paramArrayList.get(0)).getWeight());
    } else {
      paramArrayList = null;
    } 
    if (paramArrayList != null) {
      RootApplication.runOnUiThread(new ac(this, paramArrayList));
      this.bjR = false;
    } 
  }
  
  public AbsListView NK() {
    dm(false);
    return (AbsListView)this.mView.findViewById(2131296390);
  }
  
  public void NO() {
    this.mView.clearFocus();
    if (this.bjF == 2) {
      this.bjI.requestFocus();
      return;
    } 
    this.bjH.requestFocus();
  }
  
  public void a(View paramView, aa paramaa, String paramString) { super.a(paramView, paramaa, paramString); }
  
  protected void a(AdapterView<?> paramAdapterView, View paramView, int paramInt) {
    BaseAdapter baseAdapter = n.b(paramAdapterView);
    if (baseAdapter == this.bju) {
      super.a(paramAdapterView, paramView, paramInt);
      return;
    } 
    if (baseAdapter == this.bjL) {
      null = (o)paramAdapterView.getItemAtPosition(paramInt);
      null.cVs ^= true;
      paramView.setActivated(null.cVs);
      this.bjM.setLength(0);
      for (o o : this.bjL.bka) {
        if (o.cVs) {
          this.bjM.append(o.akZ());
          this.bjM.append("/");
        } 
      } 
      if (this.bjM.length() > 0)
        this.bjM.deleteCharAt(this.bjM.length() - 1); 
      NR();
    } 
  }
  
  protected void a(aa paramaa, String paramString) {
    this.bjG.setText(paramaa.cUM);
    this.bjH.setText(n.a(Double.valueOf(paramaa.Gw()), false, false));
    n.j(this.bjH);
    String str = n.ba(paramaa.Gz());
    this.bjI.setText(str);
    this.bjU.setChecked(paramaa.Gp());
    StringBuilder stringBuilder = paramaa.GM();
    this.bjO.setLength(0);
    this.bjO.append(stringBuilder);
    NS();
    b(paramaa, paramString);
    if (a.AZ().BE() || a.AZ().BF()) {
      if (this.bjP.getVisibility() != 0)
        this.bjP.setVisibility(0); 
      return;
    } 
    if (this.bjP.getVisibility() == 0) {
      this.bjP.setVisibility(8);
      return;
    } 
  }
  
  protected void a(c paramc) {
    c.a(this.bjO, this.bjs);
    NS();
  }
  
  public boolean dispatchKeyEvent(@NonNull KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getKeyCode() == 160) {
      this.bjV.performClick();
      return true;
    } 
    if (paramKeyEvent.getKeyCode() == 131) {
      this.bjH.requestFocus();
      return true;
    } 
    if (paramKeyEvent.getKeyCode() == 132) {
      this.bjI.requestFocus();
      return true;
    } 
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public void do(boolean paramBoolean) {
    this.bjI.setEnabled(paramBoolean);
    if (paramBoolean) {
      this.bjI.setTextColor(getContext().getResources().getColor(2131099938));
      return;
    } 
    this.bjI.setTextColor(getContext().getResources().getColor(2131099997));
  }
  
  public void eZ(int paramInt) { this.bjF = paramInt; }
  
  public class a extends Thread {
    public a(aa this$0) {}
    
    public void run() {
      super.run();
      while (this.bjW.bjR) {
        try {
          ArrayList arrayList = this.bjW.bgs.aoN();
          aa.a(this.bjW, arrayList);
          Thread.sleep(aa.i(this.bjW));
        } catch (Exception exception) {
          a.e(exception);
          return;
        } 
      } 
    }
  }
  
  class b extends BaseAdapter {
    ArrayList<o> bka;
    
    b(aa this$0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(a.AZ().Co());
      stringBuilder.append("");
      fb(stringBuilder.toString());
    }
    
    private void a(View param1View, a param1a, o param1o) {
      param1View.setActivated(param1o.cVs);
      param1a.aKu.setText(param1o.akZ());
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(param1o.ala());
      stringBuilder.append("%");
      String str = stringBuilder.toString();
      param1a.bjC.setText(str);
    }
    
    private void fb(String param1String) {
      ba ba = new ba(aa.g(this.bjW));
      this.bka = ba.s(0L, param1String);
      ba.close();
    }
    
    public o fa(int param1Int) { return (o)this.bka.get(param1Int); }
    
    public int getCount() { return this.bka.size(); }
    
    public long getItemId(int param1Int) { return 0L; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      o o = fa(param1Int);
      if (param1View != null) {
        a a2 = (a)param1View.getTag();
        View view1 = param1View;
        a a1 = a2;
        if (a2 == null) {
          view1 = View.inflate(aa.h(this.bjW), 2131427829, null);
          a1 = new a(this, (TextView)view1.findViewById(2131298198), (TextView)view1.findViewById(2131299967));
          view1.setTag(a1);
          a(view1, a1, o);
          return view1;
        } 
        a(view1, a1, o);
        return view1;
      } 
      View view = View.inflate(aa.h(this.bjW), 2131427829, null);
      a a = new a(this, (TextView)view.findViewById(2131298198), (TextView)view.findViewById(2131299967));
      view.setTag(a);
      a(view, a, o);
      return view;
    }
    
    class a {
      TextView aKu;
      
      TextView bjC;
      
      public a(aa.b this$0, TextView param2TextView1, TextView param2TextView2) {
        this.aKu = param2TextView1;
        this.bjC = param2TextView2;
      }
    }
  }
  
  class a {
    TextView aKu;
    
    TextView bjC;
    
    public a(aa this$0, TextView param1TextView1, TextView param1TextView2) {
      this.aKu = param1TextView1;
      this.bjC = param1TextView2;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\productcart\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */