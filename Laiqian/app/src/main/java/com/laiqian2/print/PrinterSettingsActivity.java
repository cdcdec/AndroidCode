package com.laiqian.print;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.c.a;
import com.laiqian.print.model.g;
import com.laiqian.print.model.q;
import com.laiqian.print.type.PrinterEditActivity;
import com.laiqian.print.usage.g;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.ui.a.w;
import com.laiqian.ui.container.AbstractActivity;
import com.laiqian.ui.container.ab;
import com.laiqian.util.by;
import hugo.weaving.DebugLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class PrinterSettingsActivity extends AbstractActivity implements e {
  private be cCZ;
  
  private TextView cDa;
  
  private TextView cDb;
  
  private TableLayout cDc;
  
  private TableLayout cDd;
  
  private View cDe;
  
  private View cDf;
  
  private ArrayList<View> cDg = new ArrayList();
  
  private ArrayList<View> cDh = new ArrayList();
  
  private ArrayList<TableRow> cDi = new ArrayList();
  
  private ArrayList<TableRow> cDj = new ArrayList();
  
  private BroadcastReceiver cDk = new ah(this);
  
  private View.OnClickListener cDl = new ar(this);
  
  private View.OnClickListener cDm = new ax(this);
  
  private int cDn = -1;
  
  private View.OnClickListener cDo = new ay(this);
  
  int cDp = -1;
  
  private LayoutInflater mInflater;
  
  private void Kf() { aeB(); }
  
  private View a(LayoutInflater paramLayoutInflater, TableRow paramTableRow) {
    ViewGroup viewGroup = (ViewGroup)paramLayoutInflater.inflate(2131427692, null);
    ((TextView)viewGroup.findViewById(2131297325)).setText(getString(2131628866));
    viewGroup.setTag(2131297320, Integer.valueOf(0));
    paramTableRow.addView(viewGroup);
    this.cDg.add(0, viewGroup);
    return viewGroup;
  }
  
  private void a(int paramInt, bm parambm) {
    if (paramInt >= 0) {
      if (paramInt >= this.cCZ.aeR().size())
        return; 
      q q = (q)this.cCZ.aeR().get(paramInt);
      q.agE().setConnected(g.cGS.isConnected(q.agE()));
      if (q.agE().agF() == 0 && parambm == bm.cEg)
        q.ii(2); 
      if (q.getType() != 3) {
        this.cCZ.hJ(paramInt);
        ac = new ac(q.agE(), g.h(parambm));
        this.cCZ.e(ac);
        return;
      } 
      this.cDp = paramInt;
      ac ac = new ac(q.agE(), g.h(ac));
      this.cDn = -1;
      startActivityForResult(PrinterEditActivity.a(getActivity(), ac, 1), 2);
      return;
    } 
  }
  
  private void aeB() {
    this.cDe.setOnClickListener(new az(this));
    this.cDf.setOnClickListener(new ba(this));
    this.cDf.setOnLongClickListener(new bb(this));
  }
  
  private void aeC() {
    try {
      this.cCZ.aeO();
      return;
    } catch (Exception exception) {
      a.e(exception);
      return;
    } 
  }
  
  private void aeD() {
    null = getString(2131628961);
    String str1 = getString(2131628963);
    String str2 = getString(2131628960);
    bc bc = new bc(this);
    w = new w(this, new String[] { null, str1, str2 }, bc);
    w.setTitle(getString(2131628958));
    try {
      w.show();
      return;
    } catch (Exception w) {
      return;
    } 
  }
  
  private void aeE() {
    null = getString(2131628963);
    String str1 = getString(2131628960);
    String str2 = getString(2131628961);
    bd bd = new bd(this);
    w = new w(this, new String[] { null, str1, str2 }, bd);
    w.setTitle(getString(2131627442));
    try {
      w.show();
      return;
    } catch (Exception w) {
      return;
    } 
  }
  
  private void aeF() {
    ((TextView)findViewById(2131299889)).setText(2131625597);
    findViewById(2131299879).setVisibility(8);
    findViewById(2131299878).setOnClickListener(this.cDo);
    this.cDa = (TextView)findViewById(2131299811);
    this.cDb = (TextView)findViewById(2131299580);
    this.cDc = (TableLayout)findViewById(2131299166);
    this.cDd = (TableLayout)findViewById(2131299155);
    this.mInflater = LayoutInflater.from(this);
    aeG();
  }
  
  private void aeG() {
    TableRow tableRow = h(this.mInflater);
    this.cDe = a(this.mInflater, tableRow);
    this.cDf = b(this.mInflater, tableRow);
  }
  
  @DebugLog
  private TableRow aeH() {
    int j = this.cDj.size();
    int i = j;
    if (j == 0) {
      i(this.mInflater);
      i = this.cDj.size();
    } 
    for (TableRow tableRow = (TableRow)this.cDj.get(i - 1); tableRow.getChildCount() > 4; tableRow = (TableRow)this.cDj.get(i - 1)) {
      Log.i("tag", "no sufficient rows, adding new row");
      i(this.mInflater);
      i = this.cDj.size();
    } 
    return (TableRow)this.cDj.get(i - 1);
  }
  
  private TableRow aeI() {
    int i = this.cDi.size();
    for (TableRow tableRow = (TableRow)this.cDi.get(i - 1); tableRow.getChildCount() >= 4; tableRow = (TableRow)this.cDi.get(i - 1)) {
      h(this.mInflater);
      i = this.cDi.size();
    } 
    return (TableRow)this.cDi.get(i - 1);
  }
  
  private View b(LayoutInflater paramLayoutInflater, TableRow paramTableRow) {
    ViewGroup viewGroup = (ViewGroup)this.mInflater.inflate(2131427691, null);
    ((TextView)viewGroup.findViewById(2131297325)).setText(getString(2131628904));
    viewGroup.setTag(2131297320, Integer.valueOf(1));
    paramTableRow.addView(viewGroup);
    this.cDg.add(1, viewGroup);
    return viewGroup;
  }
  
  private View cG(View paramView) {
    aeI().addView(paramView);
    this.cDg.add(paramView);
    paramView.setTag(2131297320, Integer.valueOf(this.cDg.size() - 1));
    paramView.setOnClickListener(this.cDl);
    return paramView;
  }
  
  @DebugLog
  private View cH(View paramView) {
    aeH().addView(paramView);
    this.cDh.add(paramView);
    paramView.setTag(2131297320, Integer.valueOf(this.cDh.size() - 1));
    paramView.setOnClickListener(this.cDm);
    return paramView;
  }
  
  private String d(bm parambm) {
    switch (aw.bgg[parambm.ordinal()]) {
      default:
        return "";
      case 4:
        return getString(2131628972);
      case 3:
        return getString(2131628996);
      case 2:
        return getString(2131629000);
      case 1:
        break;
    } 
    return getString(2131628982);
  }
  
  private void f(q paramq) {
    c c = kW(paramq.getIdentifier());
    if (c != null) {
      c.fw(true);
      c.cDA.setText(2131628900);
    } 
  }
  
  private void g(q paramq) {
    c c = kW(paramq.getIdentifier());
    if (c != null) {
      c.j(paramq);
      c.cDA.setText(2131628951);
      c.fw(false);
      c.getView().setTag(2131297290, Boolean.valueOf(false));
    } 
  }
  
  private TableRow h(LayoutInflater paramLayoutInflater) {
    TableRow tableRow = (TableRow)paramLayoutInflater.inflate(2131428101, null);
    this.cDc.addView(tableRow);
    this.cDi.add(tableRow);
    return tableRow;
  }
  
  private void h(q paramq) {
    c c = kW(paramq.getIdentifier());
    if (c != null) {
      c.fw(false);
      c.cDz.setText(2131628948);
      c.cDA.setText(2131628950);
    } 
  }
  
  private void hB(int paramInt) {
    ac ac = this.cCZ.hL(paramInt);
    Intent intent = PrinterEditActivity.a(getActivity(), ac);
    this.cDn = paramInt;
    startActivityForResult(intent, 2);
  }
  
  private void hC(int paramInt) {
    q q = this.cCZ.hK(paramInt);
    if (q == null)
      return; 
    this.cCZ.k(q);
  }
  
  private void hD(int paramInt) {
    w w = this.cCZ.hK(paramInt);
    if (w == null)
      return; 
    if (w.agF() == 0) {
      if (!a.zR().Ab()) {
        String str1 = getString(2131628996);
        String str2 = getString(2131629000);
        String str3 = getString(2131628982);
        ai ai = new ai(this, paramInt);
        w = new w(this, new String[] { str1, str2, str3 }, ai);
      } else {
        null = getString(2131628996);
        String str1 = getString(2131629000);
        String str2 = getString(2131628982);
        String str3 = getString(2131628972);
        aj aj = new aj(this, paramInt);
        w = new w(this, new String[] { null, str1, str2, str3 }, aj);
      } 
      w.setTitle(getString(2131627443));
      try {
        w.show();
        return;
      } catch (Exception w1) {
        return;
      } 
    } 
    if (w.agF() == 1) {
      if (!a.zR().Ab()) {
        String str1 = getString(2131628996);
        String str2 = getString(2131628982);
        ak ak = new ak(this, paramInt);
        w = new w(this, new String[] { str1, str2 }, ak);
      } else {
        null = getString(2131628996);
        String str1 = getString(2131628982);
        String str2 = getString(2131628972);
        al al = new al(this, paramInt);
        w = new w(this, new String[] { null, str1, str2 }, al);
      } 
      w.setTitle(getString(2131627443));
      w.show();
      return;
    } 
    if (w.agF() == 2)
      a(paramInt, bm.cEg); 
  }
  
  private String hE(int paramInt) { return s(this, paramInt); }
  
  private TableRow i(LayoutInflater paramLayoutInflater) {
    TableRow tableRow = (TableRow)paramLayoutInflater.inflate(2131428101, null);
    this.cDd.addView(tableRow);
    this.cDj.add(tableRow);
    return tableRow;
  }
  
  private void i(q paramq) {
    c c = c.j(this.mInflater);
    c.j(paramq);
    c.getView().setTag(2131297290, Boolean.valueOf(true));
    c.fw(true);
    cG(c.getView());
  }
  
  private int kV(String paramString) {
    ArrayList arrayList = this.cCZ.aeR();
    for (byte b = 0; b < arrayList.size(); b++) {
      if (((q)arrayList.get(b)).getIdentifier().equals(paramString))
        return b; 
    } 
    return -1;
  }
  
  private c kW(String paramString) {
    int i = kV(paramString);
    return (i >= 0) ? new c((View)this.cDg.get(i + 2)) : null;
  }
  
  private static String s(Context paramContext, int paramInt) {
    String str = paramContext.getString(2131628962);
    switch (paramInt) {
      default:
        return str;
      case 4:
        return paramContext.getString(2131628961);
      case 3:
        return paramContext.getString(2131628959);
      case 2:
        return paramContext.getString(2131628960);
      case 1:
        break;
    } 
    return paramContext.getString(2131628963);
  }
  
  private void wR() {}
  
  public void a(q paramq) {
    if (aqS()) {
      b b = new b(this, this.mInflater);
      b.cDy.setText(paramq.agE().getName());
      b.cDz.setText(hE(paramq.getType()));
      cG(b.getView());
      return;
    } 
    this.mHandler.post(new am(this, paramq));
  }
  
  public void a(q paramq, Collection<bm> paramCollection) { i(new an(this, paramq, paramCollection)); }
  
  public void aei() {
    ImageView imageView = (ImageView)this.cDe.findViewById(2131297301);
    Animation animation = AnimationUtils.loadAnimation(this, 2130772030);
    animation.setInterpolator(new LinearInterpolator());
    imageView.startAnimation(animation);
    ((TextView)this.cDe.findViewById(2131297325)).setText(getString(2131628940));
  }
  
  public void aej() {
    a((TextView)this.cDe.findViewById(2131297325), getString(2131628938));
    ((ImageView)this.cDe.findViewById(2131297301)).clearAnimation();
  }
  
  public void aek() { i(new ap(this)); }
  
  public void ael() {
    this.cDc.removeAllViews();
    this.cDi.clear();
    this.cDg.clear();
    aeG();
    aeB();
    for (q q : this.cCZ.aeR()) {
      b b = new b(this, this.mInflater);
      b.j(q);
      cG(b.getView());
    } 
  }
  
  public void aem() { i(new ao(this)); }
  
  public void b(q paramq) {
    if (aqS()) {
      f(paramq);
      return;
    } 
    i(new as(this, paramq));
  }
  
  public void c(q paramq) {
    if (aqS()) {
      g(paramq);
      return;
    } 
    i(new at(this, paramq));
  }
  
  public void d(q paramq) {
    if (aqS()) {
      h(paramq);
      return;
    } 
    i(new au(this, paramq));
  }
  
  public void e(q paramq) {
    if (aqS()) {
      i(paramq);
      return;
    } 
    i(new av(this, paramq));
  }
  
  public void hx(int paramInt) {
    String str = "";
    switch (paramInt) {
      case 4:
        str = getString(2131628941);
        break;
      case 3:
        str = getString(2131628868);
        break;
      case 2:
        str = getString(2131628908);
        break;
      case 1:
        str = getString(2131629005);
        break;
    } 
    i(new aq(this, str));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1) {
      default:
        return;
      case 2:
        if (paramInt2 != 3) {
          Serializable serializable;
          switch (paramInt2) {
            default:
              return;
            case -1:
              serializable = paramIntent.getSerializableExtra("selection");
              if (serializable != null) {
                serializable = (ac)serializable;
                if (this.cDn != -1) {
                  this.cCZ.a(this.cDn, serializable);
                  return;
                } 
                this.cCZ.e(serializable);
                if (this.cDp != -1) {
                  this.cCZ.hJ(this.cDp);
                  return;
                } 
              } 
              break;
            case 0:
              break;
          } 
        } else if (this.cDn != -1) {
          this.cCZ.hI(this.cDn);
          return;
        } 
        return;
      case 1:
        break;
    } 
    if (paramInt2 == -1 && this.cDp != -1)
      this.cCZ.hJ(this.cDp); 
  }
  
  @DebugLog
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.cCZ = new be(this, this);
    requestWindowFeature(7);
    setContentView(2131427403);
    getWindow().setFeatureInt(7, 2131428168);
    aeF();
    wR();
    Kf();
  }
  
  protected void onPause() {
    try {
      unregisterReceiver(this.cDk);
    } catch (IllegalArgumentException illegalArgumentException) {}
    this.cCZ.aeT();
    onStop();
  }
  
  @DebugLog
  protected void onResume() {
    super.onResume();
    this.cCZ.init();
  }
  
  @DebugLog
  protected void onStart() {
    super.onStart();
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("com.laiqian.print.ACTION_USB_DEVICE_ATTACHED");
    intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
    intentFilter.addAction("com.laiqian.USB_PERMISSION");
    registerReceiver(this.cDk, intentFilter);
  }
  
  private class a extends ab<RelativeLayout> {
    public ab<TextView> cDu = new ab(2131297325);
    
    public ab<TextView> cDv = new ab(2131297326);
    
    public ab<TextView> cDw = new ab(2131297327);
    
    public ab<TextView> cDx = new ab(2131297300);
    
    public a(PrinterSettingsActivity this$0, int param1Int) { super(param1Int); }
    
    @SuppressLint({"NewApi"})
    public void d(ac param1ac) {
      String str;
      null = param1ac.aex();
      ArrayList arrayList = new ArrayList();
      for (bm bm : null)
        arrayList.add(PrinterSettingsActivity.a(this.cDq, bm)); 
      ((TextView)this.cDu.getView()).setText(by.a("/", arrayList));
      ((TextView)this.cDv.getView()).setText(param1ac.aew().getName());
      ((TextView)this.cDw.getView()).setText(PrinterSettingsActivity.a(this.cDq, param1ac.aew().getType()));
      ((TextView)this.cDx.getView()).setActivated(param1ac.aew().isConnected());
      TextView textView = (TextView)this.cDx.getView();
      if (param1ac.aew().isConnected()) {
        str = this.cDq.getString(2131628883);
      } else {
        str = this.cDq.getString(2131628888);
      } 
      textView.setText(str);
    }
  }
  
  private class b {
    public final TextView cDy;
    
    public final TextView cDz;
    
    private final View mView;
    
    public b(PrinterSettingsActivity this$0, LayoutInflater param1LayoutInflater) {
      this.mView = param1LayoutInflater.inflate(2131427694, null);
      this.cDy = (TextView)this.mView.findViewById(2131297325);
      this.cDz = (TextView)this.mView.findViewById(2131297326);
    }
    
    public View getView() { return this.mView; }
    
    public void j(q param1q) {
      this.cDy.setText(param1q.agE().getName());
      this.cDz.setText(PrinterSettingsActivity.a(this.cDq, param1q.getType()));
    }
  }
  
  private static class c {
    public TextView cDA;
    
    public ProgressBarCircularIndeterminate cDB;
    
    public TextView cDy;
    
    public TextView cDz;
    
    private final View mView;
    
    public c(View param1View) {
      this.mView = param1View;
      this.cDy = (TextView)this.mView.findViewById(2131297325);
      this.cDz = (TextView)this.mView.findViewById(2131297326);
      this.cDA = (TextView)this.mView.findViewById(2131297327);
      this.cDB = (ProgressBarCircularIndeterminate)this.mView.findViewById(2131297346);
    }
    
    public static c j(LayoutInflater param1LayoutInflater) { return new c(param1LayoutInflater.inflate(2131427694, null)); }
    
    public void fw(boolean param1Boolean) {
      if (param1Boolean) {
        this.cDB.setVisibility(0);
        this.cDy.setVisibility(8);
        this.cDz.setVisibility(8);
        return;
      } 
      this.cDB.setVisibility(8);
      this.cDy.setVisibility(0);
      this.cDz.setVisibility(0);
    }
    
    public View getView() { return this.mView; }
    
    public void j(q param1q) {
      this.cDy.setText(param1q.agE().getName());
      this.cDz.setText(PrinterSettingsActivity.t(this.mView.getContext(), param1q.getType()));
      this.cDA.setText(2131628964);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\PrinterSettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */