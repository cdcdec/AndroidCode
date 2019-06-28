package com.laiqian.pos.hold;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.d.a;
import com.laiqian.dcb.api.server.ServerService;
import com.laiqian.l.a;
import com.laiqian.models.ar;
import com.laiqian.models.at;
import com.laiqian.opentable.common.ag;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.m;
import com.laiqian.opentable.common.n;
import com.laiqian.setting.by;
import com.laiqian.ui.FragmentRoot;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.layout.CheckBoxLayoutInMainSetting;
import com.laiqian.ui.s;
import com.laiqian.util.av;
import com.laiqian.util.bd;
import com.laiqian.util.n;
import com.zhuge.analysis.b.a;

public class HolderOpenTableSettingFragment extends FragmentRoot {
  private boolean bBoss = true;
  
  private View cnA;
  
  private View cnB;
  
  private TextView cnC;
  
  private TextView cnD;
  
  private ImageView cnE;
  
  private ImageView cnF;
  
  private View cnG;
  
  private View cnH;
  
  private View cnI;
  
  private View cnJ;
  
  private boolean cnK = true;
  
  private boolean cnL;
  
  private boolean cnM;
  
  HoldSettingActivity cnN;
  
  private View cnO;
  
  private TextView cnP;
  
  private CheckBoxLayoutInMainSetting cnw;
  
  private CheckBoxLayoutInMainSetting cnx;
  
  private View cny;
  
  private CheckBoxLayoutInMainSetting cnz;
  
  private bb waitingDialog;
  
  private void aay() {
    if (!this.bBoss) {
      n.eP(2131624349);
      return;
    } 
    boolean bool = a.AZ().Bk() ^ true;
    this.cnB.setSelected(bool);
    a.AZ().bJ(bool);
    if (bool) {
      b.eA(false);
      if (b.XC()) {
        if (!a.AZ().Bd()) {
          a.AZ().bG(true);
          ServerService.aa(getActivity());
        } 
      } else if (a.AZ().Bd()) {
        a.AZ().bG(false);
        ServerService.ae(getActivity());
      } 
      this.cnA.setSelected(false);
      Nh();
    } else {
      hide();
    } 
    if (!this.cnK) {
      a.aAU().Q(getActivity(), a.dMB);
      aaB();
    } 
  }
  
  private void aaz() {
    boolean bool = this.cnA.isSelected() ^ true;
    if (!this.bBoss) {
      n.eP(2131624349);
      return;
    } 
    if (!bool && a.AZ().Bd()) {
      a.AZ().bG(false);
      ServerService.ae(getActivity());
    } 
    b.eA(bool);
    this.cnA.setSelected(bool);
    if (bool) {
      a.AZ().bF(true);
      a.AZ().bJ(false);
      this.cnB.setSelected(false);
      aaA();
    } else {
      hide();
    } 
    if (!this.cnK) {
      String str;
      a a = a.aAU();
      FragmentActivity fragmentActivity = getActivity();
      if (bool) {
        str = a.dMA;
      } else {
        str = a.dMB;
      } 
      a.Q(fragmentActivity, str);
      aaB();
    } 
  }
  
  private void setListeners() {
    this.cnw.a(new j(this));
    this.cnx.a(new k(this));
    this.cnz.a(new l(this));
  }
  
  private void setupViews() {
    at at = new at(getActivity());
    this.cnM = at.em(false);
    this.cnA.setSelected(this.cnM);
    at.close();
    this.cnL = a.AZ().Bk();
    this.cnB.setSelected(this.cnL);
    this.cnw.setChecked(a.AZ().Bi());
    this.cnx.setChecked(a.AZ().Bj());
    this.cny.setOnClickListener(new by(getActivity(), com.laiqian.opentable.ConcreteTableList.class));
    this.cnO.setOnClickListener(new by(getActivity(), com.laiqian.opentable.TableTimeCalculationActivity.class));
    this.cnz.setChecked(a.AZ().Bl());
    if (this.cnA.isSelected()) {
      aaA();
    } else if (this.cnB.isSelected()) {
      Nh();
    } else {
      hide();
    } 
    this.cnI.setOnClickListener(new h(this));
    this.cnJ.setOnClickListener(new i(this));
  }
  
  public void Nh() {
    this.cnN.showTitleSetting();
    this.cnH.setVisibility(8);
    this.cnG.setVisibility(0);
    if (!this.cnK && n.Xo().size() == 0)
      aaC(); 
    this.cnI.setActivated(false);
    this.cnJ.setActivated(true);
  }
  
  public void aaA() {
    this.cnN.hideTitleSetting();
    this.cnH.setVisibility(0);
    this.cnG.setVisibility(8);
    this.cnI.setActivated(true);
    this.cnJ.setActivated(false);
  }
  
  public void aaB() {
    if (bd.bH(getActivity())) {
      at at = new at(CrashApplication.zv());
      long l = at.Wi();
      at.close();
      RootApplication rootApplication = CrashApplication.zv();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(l);
      stringBuilder.append("");
      (new ar.a(rootApplication, stringBuilder.toString(), 2)).start();
      if (a.AZ().Bk() && b.XC()) {
        a.AZ().ce(bd.awo());
      } else {
        a.AZ().ce("");
      } 
      ag ag = new ag();
      ag.a(new m(this));
      ag.execute(new Void[0]);
    } 
  }
  
  public void aaC() {
    try {
      if (bd.bH(getActivity()) && b.XB()) {
        zL();
        n.a(true, new n(this));
        return;
      } 
    } catch (m m) {
      zM();
      a.e(m);
    } 
  }
  
  public void hide() {
    this.cnN.hideTitleSetting();
    this.cnH.setVisibility(8);
    this.cnG.setVisibility(8);
    this.cnI.setActivated(false);
    this.cnJ.setActivated(false);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = LayoutInflater.from(getActivity()).inflate(2131427375, null);
    av av = new av(getActivity());
    String str = av.atp();
    av.close();
    this.cnN = (HoldSettingActivity)getActivity();
    this.bBoss = "150001".equals(str);
    this.cnw = (CheckBoxLayoutInMainSetting)s.z(view, 2131296728);
    this.cnx = (CheckBoxLayoutInMainSetting)s.z(view, 2131296729);
    this.cnz = (CheckBoxLayoutInMainSetting)s.z(view, 2131296745);
    this.cny = s.z(view, 2131297947);
    this.cnO = s.z(view, 2131298011);
    this.cnP = (TextView)s.z(view, 2131297105);
    this.cnA = s.z(view, 2131297216);
    this.cnB = s.z(view, 2131299153);
    this.cnG = s.z(view, 2131297949);
    this.cnH = s.z(view, 2131297916);
    this.cnI = s.z(view, 2131298295);
    this.cnJ = s.z(view, 2131298296);
    this.cnC = (TextView)s.z(view, 2131299548);
    this.cnD = (TextView)s.z(view, 2131299622);
    this.cnE = (ImageView)s.z(view, 2131297373);
    this.cnF = (ImageView)s.z(view, 2131297392);
    setupViews();
    setListeners();
    this.cnK = false;
    return view;
  }
  
  public void onDestroy() {
    at at = new at(getActivity());
    if (this.cnL != a.AZ().Bk() || this.cnM != at.em(false))
      getActivity().sendBroadcast(new Intent("pos_activity_order_change")); 
    at.close();
    super.onDestroy();
  }
  
  public void onStart() {
    super.onStart();
    this.cnP.setVisibility(8);
  }
  
  public void zL() {
    if (this.waitingDialog == null) {
      this.waitingDialog = new bb(getActivity());
      this.waitingDialog.setCancelable(false);
    } 
    this.waitingDialog.show();
  }
  
  public void zM() {
    if (this.waitingDialog != null)
      this.waitingDialog.dismiss(); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\hold\HolderOpenTableSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */