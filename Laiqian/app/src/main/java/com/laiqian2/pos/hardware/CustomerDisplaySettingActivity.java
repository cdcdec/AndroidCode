package com.laiqian.pos.hardware;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;
import com.felhr.usbserial.g;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.r;
import com.laiqian.ui.a.w;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.container.w;
import com.laiqian.ui.layout.CheckBoxLayoutInMainSetting;
import com.laiqian.ui.s;
import java.util.ArrayList;
import java.util.HashMap;

public class CustomerDisplaySettingActivity extends ActivityRoot {
  private r aDx;
  
  private a ckm;
  
  private c ckn = null;
  
  private final ArrayList<Pair<Integer, Integer>> cko = new ArrayList();
  
  private aa titleBar;
  
  private boolean Az() { return b.ckg.aan().equals(this.ckn) ^ true; }
  
  private boolean Rq() {
    switch (this.ckn.getType()) {
      default:
        Toast.makeText(this, 2131624925, 0).show();
        return false;
      case 2:
        if (this.ckn.aap() == null) {
          Toast.makeText(this, 2131624921, 0).show();
          return false;
        } 
        return true;
      case 1:
        break;
    } 
    if (this.ckn.aaq() == null) {
      Toast.makeText(this, 2131624920, 0).show();
      return false;
    } 
    return true;
  }
  
  private void aar() {
    null = ((UsbManager)getSystemService("usb")).getDeviceList();
    this.cko.clear();
    ArrayList arrayList = new ArrayList();
    for (UsbDevice usbDevice : null.values()) {
      if (g.b(usbDevice)) {
        int i = usbDevice.getVendorId();
        int j = usbDevice.getProductId();
        Pair pair = new Pair(Integer.valueOf(i), Integer.valueOf(j));
        this.cko.add(pair);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append(",");
        stringBuilder.append(j);
        arrayList.add(stringBuilder.toString());
      } 
    } 
    (new w(getActivity(), (String[])arrayList.toArray(new String[0]), new o(this))).show();
  }
  
  private void aas() {
    if (this.aDx == null) {
      this.aDx = new r(this, null);
      this.aDx.setTitle(getString(2131629674));
      this.aDx.s(getString(2131626814));
      this.aDx.arm().setText(getString(2131627493));
      this.aDx.arn().setText(getString(2131626588));
      this.aDx.arm().setOnClickListener(new p(this));
      this.aDx.arn().setOnClickListener(new e(this));
    } 
    this.aDx.show();
  }
  
  private void e(c paramc) {
    boolean bool = paramc.isEnabled();
    this.ckm.cku.setChecked(bool);
    TextView textView = (TextView)this.ckm.cky.cAP.getView();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramc.getBaudrate());
    stringBuilder.append("");
    textView.setText(stringBuilder.toString());
    ((TextView)this.ckm.ckv.cAP.getView()).setText(gV(paramc.getType()));
    if (!paramc.enabled) {
      this.ckm.cku.setBackgroundResource(2130772035);
      ((ViewGroup)this.ckm.ckv.getView()).setVisibility(8);
      ((ViewGroup)this.ckm.ckx.getView()).setVisibility(8);
      ((ViewGroup)this.ckm.cky.getView()).setVisibility(8);
      ((ViewGroup)this.ckm.ckw.getView()).setVisibility(8);
      return;
    } 
    this.ckm.cku.setBackgroundResource(2130772043);
    ((ViewGroup)this.ckm.ckv.getView()).setVisibility(0);
    ((ViewGroup)this.ckm.ckv.getView()).setBackgroundResource(2130772055);
    ((ViewGroup)this.ckm.cky.getView()).setVisibility(0);
    ((ViewGroup)this.ckm.cky.getView()).setBackgroundResource(2130772051);
    switch (paramc.getType()) {
      default:
        return;
      case 2:
        if (paramc.aap() != null) {
          textView = (TextView)this.ckm.ckw.cAP.getView();
          stringBuilder = new StringBuilder();
          stringBuilder.append((paramc.aap()).first);
          stringBuilder.append(",");
          stringBuilder.append((paramc.aap()).second);
          textView.setText(stringBuilder.toString());
        } 
        ((ViewGroup)this.ckm.ckw.getView()).setVisibility(0);
        ((ViewGroup)this.ckm.ckw.getView()).setBackgroundResource(2130772055);
        ((ViewGroup)this.ckm.ckx.getView()).setVisibility(8);
        return;
      case 1:
        break;
    } 
    ((TextView)this.ckm.ckx.cAP.getView()).setText(paramc.aaq());
    ((ViewGroup)this.ckm.ckx.getView()).setVisibility(0);
    ((ViewGroup)this.ckm.ckx.getView()).setBackgroundResource(2130772055);
    ((ViewGroup)this.ckm.ckw.getView()).setVisibility(8);
  }
  
  private String gV(int paramInt) {
    switch (paramInt) {
      default:
        return getString(2131624923);
      case 2:
        return getString(2131624924);
      case 1:
        break;
    } 
    return getString(2131624922);
  }
  
  private void save() {
    if (!Rq())
      return; 
    b.ckg.c(this.ckn);
    b.ckg.b(this.ckn);
    Toast.makeText(this, 2131629874, 0).show();
    finish();
  }
  
  private void setupViews() {
    this.titleBar.tvTitle.setText(2131624926);
    this.titleBar.brj.setText(2131626588);
    this.titleBar.brj.setOnClickListener(new d(this));
    this.titleBar.bri.setOnClickListener(new f(this));
    ((TextView)this.ckm.ckv.cAO.getView()).setText(2131624919);
    ((TextView)this.ckm.ckw.cAO.getView()).setText(2131624924);
    ((TextView)this.ckm.ckx.cAO.getView()).setText(2131629591);
    ((TextView)this.ckm.cky.cAO.getView()).setText(2131629592);
    this.ckm.cku.a(new g(this));
    ((ViewGroup)this.ckm.ckv.getView()).setOnClickListener(new h(this));
    ((ViewGroup)this.ckm.ckw.getView()).setOnClickListener(new j(this));
    ((ViewGroup)this.ckm.ckx.getView()).setOnClickListener(new k(this));
    ((ViewGroup)this.ckm.cky.getView()).setOnClickListener(new m(this));
  }
  
  public void onBackPressed() {
    if (Az()) {
      aas();
      return;
    } 
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.ckm = a.e(getWindow());
    this.titleBar = aa.M(this);
    setupViews();
    this.ckn = b.ckg.aan();
    e(this.ckn);
  }
  
  private static class a {
    View aQG;
    
    CheckBoxLayoutInMainSetting cku;
    
    w ckv = new w(2131297713);
    
    w ckw = new w(2131297717);
    
    w ckx = new w(2131297664);
    
    w cky = new w(2131297516);
    
    public a(View param1View) {
      this.aQG = param1View;
      this.cku = (CheckBoxLayoutInMainSetting)s.z(param1View, 2131296726);
      a(this.ckv);
      a(this.ckw);
      a(this.ckx);
      a(this.cky);
    }
    
    private void a(ab param1ab) { param1ab.S(s.z(this.aQG, param1ab.getId())); }
    
    public static a e(Window param1Window) {
      View view = View.inflate(param1Window.getContext(), 2131428115, null);
      param1Window.setContentView(view);
      return new a(view);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\hardware\CustomerDisplaySettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */