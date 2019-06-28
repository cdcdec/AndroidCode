package com.laiqian.print.cardreader;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
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
import com.laiqian.print.model.type.usb.a.a;
import com.laiqian.ui.a.w;
import com.laiqian.ui.container.AbstractActivity;
import com.laiqian.ui.container.ab;
import java.util.ArrayList;

public class CardReaderSearchActivity extends AbstractActivity implements al {
  private TextView cDa;
  
  private TextView cDb;
  
  private TableLayout cDc;
  
  private TableLayout cDd;
  
  private View cDe;
  
  private ArrayList<View> cDg = new ArrayList();
  
  private ArrayList<View> cDh = new ArrayList();
  
  private ArrayList<TableRow> cDi = new ArrayList();
  
  private ArrayList<TableRow> cDj = new ArrayList();
  
  private BroadcastReceiver cDk = new t(this);
  
  private View.OnClickListener cDl = new v(this);
  
  private View.OnClickListener cDm = new w(this);
  
  private View.OnClickListener cDo = new x(this);
  
  private ad cED;
  
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
  
  private void aeB() { this.cDe.setOnClickListener(new y(this)); }
  
  private void aeC() { this.cED.aeO(); }
  
  private void aeF() {
    ((TextView)findViewById(2131299889)).setText(getString(2131624584));
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
  }
  
  private TableRow aeH() {
    int j = this.cDj.size();
    int i = j;
    if (j == 0) {
      i(this.mInflater);
      i = this.cDj.size();
    } 
    TableRow tableRow = (TableRow)this.cDj.get(i - 1);
    while (tableRow.getChildCount() > 5) {
      i(this.mInflater);
      i = this.cDj.size();
      this.cDj.get(i - 1);
    } 
    return (TableRow)this.cDj.get(i - 1);
  }
  
  private TableRow aeI() {
    int i = this.cDi.size();
    for (TableRow tableRow = (TableRow)this.cDi.get(i - 1); tableRow.getChildCount() > 5; tableRow = (TableRow)this.cDi.get(i - 1)) {
      h(this.mInflater);
      i = this.cDi.size();
    } 
    return (TableRow)this.cDi.get(i - 1);
  }
  
  private View cG(View paramView) {
    aeI().addView(paramView);
    this.cDg.add(paramView);
    paramView.setTag(2131297320, Integer.valueOf(this.cDg.size() - 1));
    paramView.setOnClickListener(this.cDl);
    return paramView;
  }
  
  private View cH(View paramView) {
    aeH().addView(paramView);
    this.cDh.add(paramView);
    paramView.setTag(2131297320, Integer.valueOf(this.cDh.size() - 1));
    paramView.setOnClickListener(this.cDm);
    return paramView;
  }
  
  private TableRow h(LayoutInflater paramLayoutInflater) {
    TableRow tableRow = (TableRow)paramLayoutInflater.inflate(2131428101, null);
    this.cDc.addView(tableRow);
    this.cDi.add(tableRow);
    return tableRow;
  }
  
  private void hO(int paramInt) {
    ah ah = this.cED.hT(paramInt);
    Intent intent = new Intent();
    intent.putExtra("selection", ah);
    intent.setClass(this, CardReaderEditActivity.class);
    startActivity(intent);
  }
  
  private void hP(int paramInt) {
    w w = this.cED.hS(paramInt);
    if (w == null)
      return; 
    if (w.agF() == 0) {
      null = new z(this, paramInt);
      w = new w(this, new String[] { "IC" }, null);
      w.setTitle(getString(2131627443));
      w.show();
      return;
    } 
    if (w.agF() == 2) {
      this.cED.bk(paramInt, 2);
      return;
    } 
    if (w.agF() == 1)
      this.cED.bk(paramInt, 1); 
  }
  
  private String hQ(int paramInt) {
    String str = getString(2131624593);
    return (paramInt != 1) ? str : getString(2131624594);
  }
  
  private String hR(int paramInt) {
    switch (paramInt) {
      default:
        return "";
      case 2:
        return getString(2131624597);
      case 1:
        break;
    } 
    return getString(2131624596);
  }
  
  private TableRow i(LayoutInflater paramLayoutInflater) {
    TableRow tableRow = (TableRow)paramLayoutInflater.inflate(2131428101, null);
    this.cDd.addView(tableRow);
    this.cDj.add(tableRow);
    return tableRow;
  }
  
  private void wR() {
    this.cDa.setText(getString(2131624585));
    this.cDb.setText(getString(2131624586));
  }
  
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
  
  public void ael() {
    this.cDc.removeAllViews();
    this.cDi.clear();
    this.cDg.clear();
    aeG();
    aeB();
    for (a a : this.cED.afq()) {
      a a1 = new a(this, this.mInflater);
      a1.h(a);
      cG(a1.getView());
    } 
  }
  
  public void aem() { i(new ac(this)); }
  
  public void afo() { i(new u(this, getString(2131629005))); }
  
  public void b(ah paramah) { i(new ab(this, paramah)); }
  
  public void g(a parama) {
    if (aqS()) {
      a a1 = new a(this, this.mInflater);
      a1.h(parama);
      cG(a1.getView());
      return;
    } 
    this.mHandler.post(new aa(this, parama));
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131427403);
    getWindow().setFeatureInt(7, 2131428168);
    this.cED = new ad(this, this);
    aeF();
    wR();
    Kf();
  }
  
  protected void onDestroy() {
    s.aZ(this).a(null);
    super.onDestroy();
  }
  
  protected void onResume() {
    super.onResume();
    this.cED.init();
  }
  
  protected void onStart() {
    super.onStart();
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("com.laiqian.print.ACTION_USB_DEVICE_ATTACHED");
    intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
    intentFilter.addAction("com.laiqian.USB_PERMISSION");
    registerReceiver(this.cDk, intentFilter);
  }
  
  protected void onStop() {
    try {
      unregisterReceiver(this.cDk);
    } catch (IllegalArgumentException illegalArgumentException) {}
    super.onStop();
  }
  
  private class a {
    public final TextView cDy;
    
    public final TextView cDz;
    
    private final View mView;
    
    public a(CardReaderSearchActivity this$0, LayoutInflater param1LayoutInflater) {
      this.mView = param1LayoutInflater.inflate(2131427694, null);
      this.cDy = (TextView)this.mView.findViewById(2131297325);
      this.cDz = (TextView)this.mView.findViewById(2131297326);
    }
    
    public View getView() { return this.mView; }
    
    public void h(a param1a) {
      this.cDy.setText(param1a.getName());
      this.cDz.setText(CardReaderSearchActivity.a(this.cEE, param1a.getType()));
    }
  }
  
  private class b extends ab<RelativeLayout> {
    public ab<TextView> cDu = new ab(2131297325);
    
    public ab<TextView> cDv = new ab(2131297326);
    
    public ab<TextView> cDw = new ab(2131297327);
    
    public ab<TextView> cDx = new ab(2131297300);
    
    public b(CardReaderSearchActivity this$0, int param1Int) { super(param1Int); }
    
    public void c(ah param1ah) {
      String str;
      ((TextView)this.cDu.getView()).setText(CardReaderSearchActivity.b(this.cEE, param1ah.afl().getCode()));
      ((TextView)this.cDv.getView()).setText(param1ah.afr().getName());
      ((TextView)this.cDw.getView()).setText(CardReaderSearchActivity.a(this.cEE, param1ah.afr().getType()));
      ((TextView)this.cDx.getView()).setActivated(param1ah.afr().isConnected());
      TextView textView = (TextView)this.cDx.getView();
      if (param1ah.afr().isConnected()) {
        str = this.cEE.getString(2131628883);
      } else {
        str = this.cEE.getString(2131628888);
      } 
      textView.setText(str);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\cardreader\CardReaderSearchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */