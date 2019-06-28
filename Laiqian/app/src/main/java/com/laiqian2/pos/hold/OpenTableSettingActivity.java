package com.laiqian.pos.hold;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.laiqian.d.a;
import com.laiqian.dcb.api.server.ServerService;
import com.laiqian.network.i;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.n;
import com.laiqian.opentable.common.v;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.print.util.e;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.ax;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.a.r;
import com.laiqian.util.bd;
import com.laiqian.util.n;

public class OpenTableSettingActivity extends ActivityRoot {
  public View cnR;
  
  private View cnS;
  
  private View cnT;
  
  private View cnU;
  
  private int cnV = 0;
  
  private int cnW;
  
  private View cnX;
  
  private ax cnY;
  
  private String[] cnZ;
  
  private TextView coa;
  
  private TextView cob;
  
  private View coc;
  
  r cod;
  
  private bb waitingDialog;
  
  private boolean Az() { return (this.cnV != a.AZ().Ca()); }
  
  private void JZ() {
    this.cob.setText(getString(2131625134));
    this.coa.setText(eS(a.AZ().BZ()));
    switch (this.cnV) {
      case 2:
        this.cnT.setActivated(true);
        break;
      case 1:
        this.cnT.setActivated(true);
        break;
      case 0:
        this.cnS.setActivated(true);
        break;
    } 
    setTitleTextViewRight(2131624290, new o(this));
    View view = this.coc;
    boolean bool = this.cnS.isActivated();
    byte b2 = 8;
    if (bool) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    view.setVisibility(b1);
    view = this.cnX;
    byte b1 = b2;
    if (this.cnS.isActivated())
      b1 = 0; 
    view.setVisibility(b1);
    this.cnY = new ax(getActivity(), this.cnZ, new t(this));
    this.cnX.setOnClickListener(new u(this));
  }
  
  private void dT(boolean paramBoolean) {
    if (bd.bH(getActivity())) {
      b.gv(-1);
      if (b.XB() && this.cnV != 0) {
        a(new i(true, false, ""), paramBoolean);
        return;
      } 
      if (b.XC() && this.cnV == 0) {
        i i = v.eB(false);
        if (i.bUi) {
          v.a(new v(this, paramBoolean));
          return;
        } 
        a(i, paramBoolean);
        return;
      } 
      zL();
      a(new i(true, false, ""), paramBoolean);
      return;
    } 
    if (b.XB() && this.cnV != 0) {
      a(new i(true, false, ""), paramBoolean);
      return;
    } 
    n.o(getString(2131626838));
  }
  
  private String eS(boolean paramBoolean) { return this.cnZ[0]; }
  
  private void eT(boolean paramBoolean) {
    if (bd.bH(getActivity())) {
      n.a(b.Xu(), RootUrlParameter.clV, new p(this, paramBoolean));
      return;
    } 
    n.o(getString(2131626838));
    zM();
  }
  
  private void gX(int paramInt) {
    boolean bool;
    this.cnW = paramInt;
    TextView textView = this.coa;
    if (this.cnW == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    textView.setText(eS(bool));
  }
  
  private void initView() {
    this.cnR = findViewById(2131298293);
    this.cnS = findViewById(2131298283);
    this.cnT = findViewById(2131297454);
    this.cnU = findViewById(2131299064);
    this.cnX = findViewById(2131297608);
    this.coc = findViewById(2131298285);
    this.coa = (TextView)findViewById(2131297317);
    this.cob = (TextView)findViewById(2131297314);
    this.cnZ = new String[] { getString(2131624973) };
    this.cnV = a.AZ().Ca();
    this.cnW = true ^ a.AZ().BZ();
  }
  
  private void q(boolean paramBoolean1, boolean paramBoolean2) {
    byte b = 1;
    if (paramBoolean1) {
      zM();
      Log.d("模式设置", "上传成功");
      if (TextUtils.isEmpty(a.AZ().Ck())) {
        Log.d("LanServerIP", "互联网模式或者挂单，清空IP");
      } else {
        Log.d("LanServerIP", "上传IP成功");
      } 
      if (1 == this.cnV) {
        ServerService.aa(getActivity());
      } else {
        ServerService.ae(getActivity());
      } 
      b.gv(a.AZ().Ca());
      e.i(new y(this, paramBoolean2));
      return;
    } 
    Log.d("LanServerIP", "上传IP失败");
    Log.d("模式设置", "上传失败");
    String str = a.AZ();
    if (this.cnV == 1)
      b = 0; 
    str.dZ(b);
    a a = a.AZ();
    if (b.XC()) {
      String str1 = bd.awo();
    } else {
      str = "";
    } 
    a.ce(str);
    eT(paramBoolean2);
  }
  
  public void ZA() {
    r r1 = new r(this, new x(this));
    r1.setTitle(getString(2131627735));
    r1.s(getString(2131627733));
    r1.t(getString(2131627734));
    r1.oZ(getString(2131627732));
    r1.show();
  }
  
  public void a(i parami, boolean paramBoolean) {
    if (parami.bUi) {
      eU(paramBoolean);
      return;
    } 
    n.o(parami.message);
  }
  
  public void eU(boolean paramBoolean) {
    if (this.cod == null) {
      this.cod = new r(this, new q(this, paramBoolean));
      this.cod.setTitle(getString(2131626722));
      this.cod.s(getString(2131628274));
      this.cod.t(getString(2131627734));
      this.cod.oZ(getString(2131627732));
    } 
    if (!this.cod.isShowing())
      this.cod.show(); 
  }
  
  public void onBackPressed() {
    if (Az()) {
      ZA();
      return;
    } 
    finish();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(2131427785);
    setTitleTextView(2131627192);
    initView();
    JZ();
  }
  
  public void selectConnection(View paramView) {
    int i = paramView.getId();
    if (i != 2131297454) {
      if (i != 2131298283) {
        if (i == 2131299064) {
          this.cnT.setActivated(true);
          this.cnS.setActivated(false);
          this.cnU.setActivated(false);
          this.cnV = 1;
        } 
      } else {
        this.cnS.setActivated(true);
        this.cnT.setActivated(false);
        this.cnU.setActivated(false);
        this.cnV = 0;
      } 
    } else {
      this.cnT.setActivated(true);
      this.cnS.setActivated(false);
      this.cnU.setActivated(false);
      this.cnV = 1;
    } 
    paramView = this.coc;
    boolean bool = this.cnS.isActivated();
    int j = 8;
    if (bool) {
      i = 0;
    } else {
      i = 8;
    } 
    paramView.setVisibility(i);
    paramView = this.cnX;
    i = j;
    if (this.cnS.isActivated())
      i = 0; 
    paramView.setVisibility(i);
  }
  
  public void zL() {
    if (this.waitingDialog == null) {
      this.waitingDialog = new bb(getActivity());
      this.waitingDialog.setCancelable(false);
    } 
    if (!this.waitingDialog.isShowing())
      this.waitingDialog.show(); 
  }
  
  public void zM() {
    if (!isFinishing() && this.waitingDialog != null)
      this.waitingDialog.dismiss(); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\hold\OpenTableSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */