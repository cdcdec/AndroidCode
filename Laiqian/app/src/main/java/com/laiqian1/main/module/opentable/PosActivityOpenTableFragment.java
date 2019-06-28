package com.laiqian.main.module.opentable;

import android.arch.lifecycle.g;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.assistne.icondottextview.IconDotTextView;
import com.google.a.a.a.a.a.a;
import com.jakewharton.b.b;
import com.jakewharton.b.c;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.entity.aa;
import com.laiqian.entity.aq;
import com.laiqian.entity.s;
import com.laiqian.entity.u;
import com.laiqian.entity.z;
import com.laiqian.main.PosActivity;
import com.laiqian.main.bb;
import com.laiqian.main.dl;
import com.laiqian.main.module.hardware.weight.c;
import com.laiqian.main.module.productcart.am;
import com.laiqian.main.module.scanorder.PosActivityScanOrderFragment;
import com.laiqian.message.m;
import com.laiqian.models.bh;
import com.laiqian.opentable.a;
import com.laiqian.opentable.common.ag;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.b.c;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.entity.a;
import com.laiqian.opentable.common.entity.c;
import com.laiqian.opentable.common.u;
import com.laiqian.opentable.m;
import com.laiqian.opentable.pos.PosActivityTableAdapter;
import com.laiqian.opentable.pos.ai;
import com.laiqian.opentable.pos.aw;
import com.laiqian.opentable.pos.b;
import com.laiqian.opentable.pos.c;
import com.laiqian.opentable.pos.j;
import com.laiqian.ordertool.c.c;
import com.laiqian.pos.hardware.b;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.print.dualscreen.o;
import com.laiqian.print.j;
import com.laiqian.print.model.e;
import com.laiqian.print.model.g;
import com.laiqian.print.usage.receipt.model.a;
import com.laiqian.product.eo;
import com.laiqian.product.models.a;
import com.laiqian.product.models.g;
import com.laiqian.product.models.h;
import com.laiqian.rx.util.LifecycleAwareObserver;
import com.laiqian.ui.a.r;
import com.laiqian.util.av;
import com.laiqian.util.ay;
import com.laiqian.util.bd;
import com.laiqian.util.by;
import com.laiqian.util.n;
import io.reactivex.a.a;
import io.reactivex.h;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.k;

public class PosActivityOpenTableFragment extends Fragment implements PosActivity.a, PosActivity.c, b {
  public static String TAG = "PosActivityOpenTableFragment";
  
  private BroadcastReceiver aqG;
  
  private dl bfr;
  
  private e bgS;
  
  private a bgT = new a();
  
  private b bgU;
  
  private ai bgV;
  
  private ay<c> bgW = new p(this);
  
  private aw bgX;
  
  private RecyclerView.f bgY;
  
  private j bgZ;
  
  private d bha;
  
  private a bhb;
  
  private PosActivityTableAdapter bhc;
  
  private PendingFullOrderDetail bhd;
  
  private TableEntity bhe;
  
  private TextView bhf;
  
  private boolean bhg;
  
  private boolean bhh;
  
  List<aa> bhi;
  
  private ay<c> bhj = new u(this);
  
  private ay<eo> bhk = new v(this);
  
  private PendingFullOrderDetail bhl;
  
  PosActivityScanOrderFragment bhm;
  
  private List<c> bhn = new ArrayList();
  
  private a bho = null;
  
  static  {
  
  }
  
  public PosActivityOpenTableFragment(dl paramdl) {
    this.bfr = paramdl;
    this.bgS = new e(paramdl);
  }
  
  private void Li() {
    av av = new av(getContext());
    String str1 = av.atR();
    String str2 = av.atp();
    av.close();
    if ("150001".equals(str2) || "".equals(str1)) {
      getActivity().sendBroadcast(new Intent("android.intent.money_test.action"));
      runtime = Runtime.getRuntime();
      try {
        runtime.exec("echo 0 > /sys/devices/platform/att_test/test");
      } catch (IOException runtime) {
        a.e(runtime);
      } 
      try {
        List list = j.cCx.a(new Object(), new String[] { "cash_drawer" });
        g.cGS.o(list);
        return;
      } catch (Exception runtime) {
        a.e(runtime);
      } 
    } 
  }
  
  private void MR() {
    this.bfr.bea.Mi();
    this.bfr.bea.beM.accept("86003");
    this.bfr.a(dl.ben);
  }
  
  private void MS() {
    this.bgU.bhE.bhQ.setVisibility(0);
    this.bgU.bhE.bbd.setVisibility(8);
    this.bgU.bhE.bhQ.setSelected(true);
    this.bgU.bhw.aQx.setVisibility(8);
    Nh();
    eW(1);
  }
  
  private void MT() {
    this.bgU.bhu.aQo.setOnClickListener(new a(this));
    this.bgU.bhD.bie.aQo.setOnClickListener(new b(this));
    this.bgU.bhE.bhQ.setOnClickListener(this.bha);
    this.bgU.bhz.bhF.bhJ.setOnClickListener(new h(this));
    this.bgU.bhz.bhF.bhI.setOnClickListener(new i(this));
  }
  
  private void MU() {
    c c1 = new c(b.Xy());
    this.bgV = new ai(getActivity(), this.bgU.bhC, new ArrayList(), new x(this), c1);
    this.bgV.eJ(true);
    this.bgU.bhB.addView(this.bgV.Yx());
  }
  
  private void MV() {
    c c1 = new c(b.Xy());
    this.bhc = new PosActivityTableAdapter(getActivity(), this.bgU.bhD.bid.big, new ArrayList(), new y(this), c1, com.laiqian.opentable.ConcreteTableList.class, this.bgS.biD, this.bgS.biE);
    this.bhc.eK(true);
  }
  
  private void MW() {
    this.bgX = new aw(new j(this), new k(this));
    this.bgU.bhw.biw.a(this.bgX);
    this.bgU.bhw.biw.a(null);
    this.bgU.bhw.biw.c(new LinearLayoutManager(getActivity(), false, false));
    this.bgY = new z(this);
    this.bgU.bhw.biw.a(this.bgY);
  }
  
  private void MX() { ((c)this.bgW.get()).a(new aa(this)); }
  
  private void MY() { this.bgT.b(this.bfr.bed.d(l.beq).b(new m(this)).b(new n(this))); }
  
  private void MZ() { m.b(a.Xk()); }
  
  private void Na() {
    this.aqG = new ab(this);
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("pos_activity_change_data_area");
    intentFilter.addAction("android.net.wifi.STATE_CHANGE");
    intentFilter.addAction("pos_activity_network_disconnection");
    intentFilter.addAction("pos_activity_network_resume");
    getActivity().registerReceiver(this.aqG, intentFilter);
  }
  
  private void Nb() { m.f(a.Xk()); }
  
  private void Nc() {
    getActivity().unregisterReceiver(this.aqG);
    this.aqG = null;
  }
  
  private void Nd() {
    this.bgW = null;
    this.bgU.bhw.biw.a(null);
    this.bgU.bhw.biw.b(this.bgY);
    this.bgX = null;
    this.bgU.bhD.bid.big.setAdapter(null);
    this.bhc = null;
    this.bgU.bhB.removeAllViews();
    this.bgV = null;
    this.bgU.bht.bix.setOnClickListener(null);
    this.bgU.bhu.aQo.setOnClickListener(null);
    this.bgU.bhD.bie.aQo.setOnClickListener(null);
    this.bgU.bhE.bhQ.setOnClickListener(null);
    this.bgU.bhz.bhF.bhJ.setOnClickListener(null);
    this.bgU.bhz.bhF.bhI.setOnClickListener(null);
  }
  
  private void Ne() {
    this.bgU.bhE.bhQ.setVisibility(8);
    this.bgU.bhE.bbd.setVisibility(8);
    this.bgU.bhw.aQx.setVisibility(8);
    this.bgU.bht.bix.setVisibility(8);
    Ni();
    eW(5);
  }
  
  private void Nf() { this.bhn.clear(); }
  
  private void Ng() {
    this.bfr.bea.Mi();
    this.bfr.bea.beM.accept(u.an(a.AZ().Co()));
    this.bfr.a(dl.ben);
  }
  
  private void Nn() {
    r r = new r(getActivity(), new q(this));
    r.setTitle(getString(2131627735));
    r.s(getString(2131627733));
    r.t(getString(2131627734));
    r.oZ(getString(2131627732));
    r.show();
  }
  
  private void No() {
    this.bhh = false;
    Nh();
    this.bfr.bea.Mj();
    eW(5);
    if (this.bfr.beg.getValue() != null)
      a(((TableEntity)this.bfr.beg.getValue()).Yg()); 
  }
  
  private void Np() {
    this.bhg = false;
    eW(1);
    this.bgU.bhu.aQo.setVisibility(8);
    this.bgU.bht.aQo.setVisibility(0);
    if (this.bfr.beg.getValue() != null)
      ((TableEntity)this.bfr.beg.getValue()).cf(0L); 
    Nr();
    Nh();
    eW(1);
    this.bgV.g(this.bhb);
  }
  
  private void Nq() {
    a.bo(getActivity());
    if (this.bhd == null)
      return; 
    if (this.bhd.bXb.aTU == 3)
      this.bhd.bXb.cpb = 0; 
    pendingFullOrderDetail = new PendingFullOrderDetail(this.bhd);
    if (pendingFullOrderDetail.bXb.bZF == 2 && this.bfr.beg.getValue() != null) {
      pendingFullOrderDetail.bXb.coM = ((TableEntity)this.bfr.beg.getValue()).Yg().Yl();
      pendingFullOrderDetail.bXb.bZM = ((TableEntity)this.bfr.beg.getValue()).Yg().Ym();
      pendingFullOrderDetail.bXb.coE = new Date(((TableEntity)this.bfr.beg.getValue()).Yg().DP());
    } 
    try {
      List list = j.cCx.a(pendingFullOrderDetail, new String[] { "dish_reprint" });
      Iterator iterator = list.iterator();
      while (iterator.hasNext())
        ((e)iterator.next()).a(new r(this)); 
      g.cGS.o(list);
      return;
    } catch (Exception pendingFullOrderDetail) {
      a.e(pendingFullOrderDetail);
      return;
    } 
  }
  
  private void Nr() {
    Ns();
    this.bfr.bea.Mi();
    this.bgU.bhw.aQx.setVisibility(8);
  }
  
  private void Ns() {
    this.bfr.beg.accept(TableEntity.bZK);
    this.bhe = null;
  }
  
  private void Nt() {
    String str3;
    String str1;
    c c1 = ((TableEntity)this.bfr.beg.getValue()).Yg();
    if (c1.Yl() == 0) {
      str1 = "";
    } else {
      null = new StringBuilder();
      null.append(".");
      null.append(getResources().getString(2131626009));
      null.append(String.valueOf(c1.Yl()));
      str1 = null.toString();
    } 
    bh bh = new bh(getActivity());
    if (this.bhd == null) {
      str3 = bh.getUserID();
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.bhd.bXb.aEI);
      stringBuilder.append("");
      str3 = stringBuilder.toString();
    } 
    String str4 = bh.iB(str3);
    String str2 = str4;
    if (TextUtils.isEmpty(str4))
      str2 = bh.iD(str3); 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(getResources().getString(2131628744));
    stringBuilder2.append("：");
    stringBuilder2.append(str2);
    str2 = stringBuilder2.toString();
    TextView textView2 = this.bgU.bhu.bim;
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(this.bhb.XX());
    stringBuilder3.append(((TableEntity)this.bfr.beg.getValue()).Vz());
    stringBuilder3.append(str1);
    textView2.setText(stringBuilder3.toString());
    this.bgU.bhu.bio.setText(str2);
    TextView textView1 = this.bgU.bhu.bip;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(c1.Ym());
    stringBuilder1.append("");
    textView1.setText(stringBuilder1.toString());
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(getString(2131627411));
    this.bgU.bhu.bir.setText(simpleDateFormat.format(new Date()));
  }
  
  private void Nu() {
    if (b.XC()) {
      a.AZ().ce(bd.awo());
    } else {
      a.AZ().ce("");
    } 
    ag ag = new ag();
    ag.a(new t(this));
    ag.execute(new Void[0]);
  }
  
  private void addProductToSelectedList(h paramh) {
    if (paramh.cUN) {
      if (paramh instanceof a) {
        a a1 = (a)paramh;
        ArrayList arrayList = a1.b(new g(getActivity()));
        if (arrayList == null) {
          this.bfr.bea.c(paramh);
          return;
        } 
        if (arrayList.isEmpty()) {
          Toast.makeText(getActivity(), getString(2131627530), 0);
          return;
        } 
        if (getLifecycle().L().equals(g.a.ON_RESUME)) {
          ((eo)this.bhk.get()).a(a1, arrayList);
          return;
        } 
      } else {
        this.bfr.bea.c(paramh);
        return;
      } 
    } else {
      Toast.makeText(getActivity(), getString(2131628180), 0).show();
    } 
  }
  
  private void b(TableEntity paramTableEntity) {
    this.bha.eX(1);
    c c1 = new c(b.ca(paramTableEntity.getID()), "0", 0L, false, false, paramTableEntity.getID());
    ((c)this.bgW.get()).a(paramTableEntity, this.bhb, true, this.bgV.YA(), true, c1);
  }
  
  private void b(PendingFullOrderDetail paramPendingFullOrderDetail) {
    null = this.bhn.iterator();
    while (null.hasNext())
      ((c)null.next()).c(paramPendingFullOrderDetail); 
    this.bfr.bea.Mi();
    if (paramPendingFullOrderDetail != null) {
      for (byte b2 = 0; b2 < paramPendingFullOrderDetail.coy.size(); b2++) {
        PendingFullOrderDetail.d d1 = (PendingFullOrderDetail.d)paramPendingFullOrderDetail.coy.get(b2);
        if (d1.cpo < 0.0D) {
          ((PendingFullOrderDetail.d)paramPendingFullOrderDetail.coy.get(b2)).cpn = 0.0D;
          ((PendingFullOrderDetail.d)paramPendingFullOrderDetail.coy.get(b2)).cps = (((PendingFullOrderDetail.d)paramPendingFullOrderDetail.coy.get(b2)).cpt = Double.valueOf(0.0D)).valueOf(0.0D);
          ((PendingFullOrderDetail.d)paramPendingFullOrderDetail.coy.get(b2)).cpu = 0.0D;
        } 
        if (d1.cpx == 3L)
          d1.cpu = 0.0D; 
      } 
      null = paramPendingFullOrderDetail.coz.iterator();
      while (null.hasNext()) {
        for (PendingFullOrderDetail.d d1 : ((PendingFullOrderDetail.c)null.next()).cpg) {
          if (d1.cpo < 0.0D) {
            d1.cpn = 0.0D;
            d1.cps = (d1.cpt = Double.valueOf(0.0D)).valueOf(0.0D);
            d1.cpu = 0.0D;
          } 
          if (d1.cpx == 3L)
            d1.cpu = 0.0D; 
        } 
      } 
    } 
    if (paramPendingFullOrderDetail.bXb.bZF == 2 || paramPendingFullOrderDetail.bXb.bZF == 3) {
      String str;
      av av = new av(getActivity());
      TableEntity tableEntity = (TableEntity)this.bfr.beg.getValue();
      if (by.isNull(paramPendingFullOrderDetail.bXb.coK)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramPendingFullOrderDetail.bXb.aEI);
        stringBuilder.append("");
        str = stringBuilder.toString();
      } else {
        str = paramPendingFullOrderDetail.bXb.coK;
      } 
      tableEntity.jj(str);
      ((TableEntity)this.bfr.beg.getValue()).jk(av.atm());
      if (paramPendingFullOrderDetail.bXb.bZF == 2) {
        this.bfr.beb.accept(Integer.valueOf(7));
      } else if (paramPendingFullOrderDetail.bXb.bZF == 3) {
        this.bfr.beb.accept(Integer.valueOf(14));
      } 
    } else {
      this.bfr.beb.accept(Integer.valueOf(0));
    } 
    this.bfr.a(paramPendingFullOrderDetail.bXb);
    this.bfr.c(aq.aWG);
    ArrayList arrayList1 = new ArrayList();
    ArrayList arrayList2 = new ArrayList();
    null = paramPendingFullOrderDetail.coy.iterator();
    byte b1;
    for (b1 = 0; null.hasNext(); b1++) {
      PendingFullOrderDetail.d d1 = (PendingFullOrderDetail.d)null.next();
      if (paramPendingFullOrderDetail.bXb.bZF == 3 && paramPendingFullOrderDetail.bXb.cpd != 5 && (d1.aTU == 0 || d1.aTU == -1))
        continue; 
      if (!b1)
        arrayList2.add(new am.a.b(new Date(d1.bbX))); 
      if (d1.cpx == 4L) {
        arrayList1.add(new am.a.a(d1, Boolean.valueOf(true)));
        continue;
      } 
      arrayList2.add(new am.a.a(d1, Boolean.valueOf(true)));
    } 
    for (PendingFullOrderDetail.c c1 : paramPendingFullOrderDetail.coz) {
      Iterator iterator = c1.cpg.iterator();
      b1 = 0;
      while (iterator.hasNext()) {
        PendingFullOrderDetail.d d1 = (PendingFullOrderDetail.d)iterator.next();
        if (paramPendingFullOrderDetail.bXb.bZF == 3 && paramPendingFullOrderDetail.bXb.cpd != 5 && (d1.aTU == 0 || d1.aTU == -1))
          break; 
        if (b1 == 0) {
          arrayList2.add(new am.a.b(c1.cpi));
          b1 = 1;
        } 
        if (d1.cpx == 4L) {
          arrayList1.add(new am.a.a(d1, Boolean.valueOf(true)));
          continue;
        } 
        arrayList2.add(new am.a.a(d1, Boolean.valueOf(true)));
      } 
    } 
    this.bfr.bea.i(arrayList2);
    if (arrayList1 != null)
      this.bfr.bea.h(arrayList1); 
    this.bfr.bea.beY.accept(Integer.valueOf(((TableEntity)this.bfr.beg.getValue()).Yb()));
  }
  
  private void c(TableEntity paramTableEntity, int paramInt) {
    this.bhe = paramTableEntity;
    for (c c1 : this.bhe.Yh()) {
      if (c1.Yl() == paramInt) {
        this.bhe.c(c1);
        break;
      } 
    } 
    Intent intent = new Intent(getActivity(), com.laiqian.opentable.ConcreteTableList.class);
    intent.putExtra("tableID", Long.valueOf(paramTableEntity.getID()));
    intent.putExtra("tableNumberID", paramInt);
    intent.putExtra("machineType", 1);
    startActivityForResult(intent, 102);
  }
  
  private void d(bb parambb, boolean paramBoolean) {
    boolean bool;
    this.bfr.bea.beM.accept("86003");
    this.bfr.beb.accept(Integer.valueOf(0));
    this.bfr.bem.beA.accept(new Object());
    Iterator iterator = parambb.bbS.iterator();
    double d1;
    for (d1 = 0.0D; iterator.hasNext(); d1 += ((z)iterator.next()).aTw);
    if (((Integer)this.bfr.bdS.getValue()).intValue() == 5) {
      bool = true;
    } else {
      bool = false;
    } 
    this.bfr.bea.ae(d1);
    if (parambb.bbY != ((Double)this.bfr.bea.beU.getValue()).doubleValue())
      this.bfr.bea.beU.accept(Double.valueOf(parambb.bbY)); 
    if (paramBoolean)
      Li(); 
    if (!bool) {
      Nr();
      Nh();
      eW(1);
      Nk();
    } 
    if (parambb.vipEntity != null) {
      o o = o.afM();
      if (o != null)
        o.b(parambb.vipEntity, Double.valueOf(parambb.bco)); 
    } 
    b.ckg.aaj().c(Double.valueOf(Double.parseDouble(n.ba(d1))));
    if (a.AZ().BE())
      c.MD().ag(d1); 
    this.bgU.bbc.setVisibility(0);
    this.bfr.bem.bex.accept(new Object());
    this.bfr.bel.beH.accept(new Object());
  }
  
  public void Lp() {
    if (this.bfr.bea.getCount() == 0) {
      n.eP(2131628174);
      return;
    } 
    if (this.bho != null && !this.bho.NC())
      return; 
    if (!((PendingFullOrderDetail.a)this.bfr.bdQ.getValue()).equals(dl.ben)) {
      PendingFullOrderDetail pendingFullOrderDetail = PendingFullOrderDetail.d(new ArrayList(this.bfr.bea.beP.aoL()), this.bhd.bXb.bZF);
      this.bfr.bej.accept(pendingFullOrderDetail);
    } else {
      this.bfr.beb.accept(Integer.valueOf((int)u.am(by.parseLong((String)this.bfr.bea.beM.getValue()))));
      this.bfr.bej.accept(PendingFullOrderDetail.coB);
    } 
    this.bfr.bem.beC.accept(new Object());
  }
  
  public void Nh() {
    if (((TableEntity)this.bfr.beg.getValue()).getState() == 2) {
      this.bgU.bhz.bhF.aQx.setVisibility(0);
    } else {
      this.bgU.bhz.bhF.aQx.setVisibility(8);
    } 
    this.bgU.bhz.bhG.aQx.setVisibility(8);
    this.bgU.bhB.setVisibility(0);
    this.bgU.bhA.setVisibility(4);
    this.bgU.bhD.bic.aQo.setVisibility(8);
    this.bgU.bhD.bid.aQo.setVisibility(0);
    this.bgU.bhD.bie.aQo.setVisibility(0);
    this.bgU.bba.setVisibility(8);
    this.bgU.bhy.setIcon(2131231315);
    this.bgU.bhy.setText(2131626013);
    this.bfr.bec.accept(dl.b.beF);
  }
  
  public void Ni() {
    this.bgU.bhz.bhG.aQx.setVisibility(0);
    this.bgU.bhC.setVisibility(8);
    this.bgU.bhz.bhF.aQx.setVisibility(8);
    this.bgU.bhB.setVisibility(4);
    this.bgU.bhA.setVisibility(0);
    this.bgU.bhD.bid.aQo.setVisibility(8);
    this.bgU.bhD.bie.aQo.setVisibility(8);
    this.bgU.bba.setVisibility(8);
    this.bgU.bhy.setIcon(2131231211);
    this.bgU.bhy.setText("");
    this.bgU.bhD.bic.aQo.setVisibility(0);
    this.bfr.bec.accept(dl.b.beE);
  }
  
  public void Nj() { this.bgZ.Yt(); }
  
  public void Nk() { this.bgZ.Yu(); }
  
  public void Nl() {
    if (a((TableEntity)this.bfr.beg.getValue())) {
      int i;
      if (this.bfr.bea.beO.aoL().size() <= 0) {
        n.eP(2131627602);
        return;
      } 
      this.bhg = false;
      ArrayList arrayList = this.bfr.bea.g(this.bfr.bea.beO.aoL());
      if (this.bhd == null) {
        i = -1;
      } else {
        i = this.bhd.bXb.bZF;
      } 
      PendingFullOrderDetail pendingFullOrderDetail = PendingFullOrderDetail.d(arrayList, i);
      long l = System.currentTimeMillis();
      this.bgU.bhE.bhQ.setEnabled(false);
      this.bgZ.c((TableEntity)this.bfr.beg.getValue(), pendingFullOrderDetail, l);
      return;
    } 
    this.bhg = true;
    Np();
    n.eP(2131625867);
  }
  
  public void Nm() {
    if (a((TableEntity)this.bfr.beg.getValue())) {
      if (this.bfr.bea.beO.aoL().size() <= 0) {
        n.eP(2131627602);
        return;
      } 
      if (this.bhi != null && !this.bhi.isEmpty()) {
        List list = this.bfr.bea.beO.aoL();
        list.addAll(this.bhi);
        this.bfr.bea.beO.r(list);
      } 
      double d1 = 0.0D;
      int i = 0;
      while (i < this.bfr.bea.beO.aoL().size()) {
        double d3 = ((aa)this.bfr.bea.beO.aoL().get(i)).Gw();
        double d2 = d1;
        if (d3 > 0.0D)
          d2 = d1 + d3; 
        i++;
        d1 = d2;
      } 
      if (d1 <= 0.0D) {
        n.eP(2131627602);
        return;
      } 
      this.bhh = false;
      ArrayList arrayList1 = this.bfr.bea.g(this.bfr.bea.beO.aoL());
      PendingFullOrderDetail pendingFullOrderDetail3 = this.bhd;
      int k = -1;
      if (pendingFullOrderDetail3 == null) {
        i = -1;
      } else {
        i = this.bhd.bXb.bZF;
      } 
      PendingFullOrderDetail pendingFullOrderDetail1 = PendingFullOrderDetail.d(arrayList1, i);
      pendingFullOrderDetail1.bXb = (PendingFullOrderDetail.a)this.bfr.bdQ.getValue();
      pendingFullOrderDetail1.bXb.coE = new Date(System.currentTimeMillis());
      PendingFullOrderDetail.a a1 = pendingFullOrderDetail1.bXb;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(((TableEntity)this.bfr.beg.getValue()).Yg().xq());
      stringBuilder.append("");
      a1.orderNo = stringBuilder.toString();
      a1 = pendingFullOrderDetail1.bXb;
      stringBuilder = new StringBuilder();
      stringBuilder.append(((TableEntity)this.bfr.beg.getValue()).getID());
      stringBuilder.append("");
      a1.coJ = stringBuilder.toString();
      ArrayList arrayList2 = new ArrayList(this.bfr.bea.beP.aoL());
      if (this.bhd == null) {
        i = k;
      } else {
        i = this.bhd.bXb.bZF;
      } 
      PendingFullOrderDetail pendingFullOrderDetail2 = PendingFullOrderDetail.d(arrayList2, i);
      this.bgZ.b((TableEntity)this.bfr.beg.getValue(), pendingFullOrderDetail1, this.bhl, pendingFullOrderDetail2);
      return;
    } 
    this.bhh = false;
    Nh();
    eW(1);
    Nr();
    Nk();
    n.eP(2131625867);
  }
  
  public void a(a parama) { this.bho = parama; }
  
  public void a(c paramc) { this.bhn.add(paramc); }
  
  public void a(TableEntity paramTableEntity, int paramInt) {
    if (a(paramTableEntity)) {
      this.bgZ.a(this.bhb, paramTableEntity, paramInt);
      return;
    } 
    n.eP(2131625867);
  }
  
  public void a(TableEntity paramTableEntity, ArrayList<PendingFullOrderDetail> paramArrayList, boolean paramBoolean1, boolean paramBoolean2) {
    if (paramBoolean1) {
      Nr();
      this.bgU.bhz.bhF.aQx.setVisibility(8);
      eW(1);
      this.bgV.g(this.bhb);
      if (paramArrayList != null) {
        Iterator iterator = paramArrayList.iterator();
        while (iterator.hasNext())
          m.m((PendingFullOrderDetail)iterator.next()); 
      } 
      this.bgU.bhw.aQx.setVisibility(8);
      return;
    } 
    n.eP(2131625021);
  }
  
  public void a(a parama, TableEntity paramTableEntity1, TableEntity paramTableEntity2, int paramInt) {
    if (a(paramTableEntity2)) {
      this.bgZ.a(parama, paramTableEntity1, paramTableEntity2, paramInt);
      return;
    } 
    n.eP(2131625867);
    this.bhe = null;
  }
  
  public void a(a parama, boolean paramBoolean) {
    long l2 = 0L;
    if (parama == null) {
      this.bgZ.t(0L, 0L);
      return;
    } 
    this.bhb = parama;
    long l1 = l2;
    if (paramBoolean) {
      l1 = l2;
      if (this.bfr.beg.getValue() != null)
        l1 = ((TableEntity)this.bfr.beg.getValue()).getID(); 
    } 
    this.bgZ.t(parama.getId(), l1);
  }
  
  public void a(c paramc) {
    String str;
    if (b.XB()) {
      str = String.valueOf(paramc.Yo());
    } else {
      str = paramc.xq();
    } 
    this.bgZ.n(str, paramc.Yl());
  }
  
  public void a(PendingFullOrderDetail paramPendingFullOrderDetail, TableEntity paramTableEntity, boolean paramBoolean1, boolean paramBoolean2) {
    this.bgU.bhE.bhQ.setEnabled(true);
    if (paramBoolean1) {
      this.bhg = false;
      Nr();
      this.bgU.bhu.aQo.setVisibility(8);
      this.bgU.bht.aQo.setVisibility(0);
      Nh();
      eW(1);
      this.bgU.bba.setVisibility(0);
      if (!paramBoolean2) {
        n.eP(2131626884);
        m.a(getActivity(), paramPendingFullOrderDetail, ((Boolean)this.bfr.bee.getValue()).booleanValue());
      } 
      this.bfr.c(aq.aWG);
      this.bgV.g(this.bhb);
      if (paramTableEntity != null)
        this.bfr.bea.beY.accept(Integer.valueOf(paramTableEntity.Yb())); 
      this.bgU.bhw.aQx.setVisibility(8);
      return;
    } 
    this.bhg = true;
    n.eP(2131625021);
  }
  
  public void a(PendingFullOrderDetail paramPendingFullOrderDetail, String paramString) {
    if (paramPendingFullOrderDetail != null && this.bfr.beg.getValue() != null) {
      if (((TableEntity)this.bfr.beg.getValue()).Yh().size() > 1) {
        this.bgU.bhw.aQx.setVisibility(0);
      } else {
        this.bgU.bhw.aQx.setVisibility(8);
      } 
      this.bhd = paramPendingFullOrderDetail;
      this.bhl = paramPendingFullOrderDetail;
      b(paramPendingFullOrderDetail);
      return;
    } 
    this.bgU.bhw.aQx.setVisibility(8);
    this.bfr.bea.Mi();
  }
  
  public void a(boolean paramBoolean1, int paramInt, a parama, TableEntity paramTableEntity, boolean paramBoolean2) {
    if (paramBoolean1) {
      Nr();
      if (paramInt != 1)
        if (paramInt == 2) {
          this.bgV.g(this.bhb);
          Nh();
          eW(1);
        } else if (paramInt == 3) {
          this.bhb = parama;
          this.bgV.g(this.bhb);
          eW(1);
          Nh();
          eW(1);
        } else if (paramInt == 4) {
          this.bgV.g(this.bhb);
          this.bfr.bea.beY.accept(Integer.valueOf(paramTableEntity.Yb()));
          Nh();
          eW(1);
        }  
    } 
    if (paramBoolean2) {
      Nh();
      eW(1);
    } 
  }
  
  public void a(boolean paramBoolean1, bb parambb, boolean paramBoolean2, boolean paramBoolean3) {
    if (paramBoolean1) {
      Ns();
      eW(1);
      Nk();
      if (!paramBoolean3) {
        d(parambb, paramBoolean2);
        return;
      } 
    } else {
      n.eP(2131625021);
    } 
  }
  
  public void a(boolean paramBoolean1, TableEntity paramTableEntity, PendingFullOrderDetail.c paramc, PendingFullOrderDetail paramPendingFullOrderDetail, boolean paramBoolean2) {
    if (paramBoolean1) {
      this.bhh = false;
      this.bfr.a(dl.ben);
      this.bgU.bhu.aQo.setVisibility(8);
      this.bgU.bht.aQo.setVisibility(0);
      Nh();
      eW(5);
      if (paramc != null && !paramBoolean2) {
        this.bfr.bea.Mi();
        this.bfr.bea.Mj();
        paramPendingFullOrderDetail.bXb.coM = paramTableEntity.Yg().Yl();
        m.a(getActivity(), paramPendingFullOrderDetail, paramc, ((Boolean)this.bfr.bee.getValue()).booleanValue());
        TableEntity tableEntity = (TableEntity)this.bfr.beg.getValue();
        if (paramTableEntity.getID() == tableEntity.getID()) {
          if (tableEntity.Yi() || paramBoolean2) {
            this.bgV.g(this.bhb);
            return;
          } 
          a(tableEntity.Yg());
          return;
        } 
      } else {
        this.bfr.bea.Mi();
        this.bfr.bea.Mj();
        this.bgV.g(this.bhb);
        return;
      } 
    } else {
      this.bhh = true;
      if (this.bhd != null) {
        this.bhd.bXb.orderNo = "";
        this.bhd.bXb.coJ = "0";
      } 
      n.eP(2131625021);
    } 
  }
  
  public void a(boolean paramBoolean1, a parama, TableEntity paramTableEntity1, TableEntity paramTableEntity2, int paramInt, boolean paramBoolean2) {
    if (paramBoolean1) {
      av av = new av(getActivity());
      String str = av.atm();
      av.close();
      this.bfr.beg.accept(paramTableEntity2);
      this.bgX.l(((TableEntity)this.bfr.beg.getValue()).Yh());
      this.bgU.bhw.aQx.setVisibility(8);
      if (this.bhd != null) {
        PendingFullOrderDetail.a a1 = this.bhd.bXb;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((TableEntity)this.bfr.beg.getValue()).getID());
        stringBuilder.append("");
        a1.coJ = stringBuilder.toString();
      } 
      m.a(getActivity(), paramTableEntity1, paramTableEntity2, str, paramInt);
      this.bgV.g(this.bhb);
      this.bfr.bea.beY.accept(Integer.valueOf(paramTableEntity2.Yb()));
      this.bfr.bea.Mi();
    } 
    this.bhe = null;
  }
  
  public boolean a(TableEntity paramTableEntity) { return (paramTableEntity.Yd() != bd.bH(getActivity()) || !b.XB()); }
  
  public void b(c paramc) { this.bhn.remove(paramc); }
  
  public void b(TableEntity paramTableEntity, int paramInt) {
    if (a(paramTableEntity)) {
      this.bgZ.b(paramTableEntity, paramInt);
      return;
    } 
    n.eP(2131625867);
  }
  
  public boolean beforeCloseActivity() {
    if (this.bhg) {
      if (this.bfr.bea.beO.aoL().isEmpty()) {
        Np();
        return true;
      } 
      Nn();
      return true;
    } 
    if (this.bhh) {
      int i = this.bfr.bea.beO.aoL().size();
      if (i == 0 || (i > 0 && !((aa)this.bfr.bea.beO.aoL().get(i - 1)).GN()) || !this.bfr.bea.beP.aoL().isEmpty()) {
        Nn();
        return true;
      } 
      No();
      return true;
    } 
    return false;
  }
  
  public void c(bb parambb, boolean paramBoolean) {
    if (this.bfr.beg.getValue() != null && a((TableEntity)this.bfr.beg.getValue())) {
      this.bgZ.a((TableEntity)this.bfr.beg.getValue(), this.bhd, parambb, paramBoolean);
      return;
    } 
    Ns();
    eW(1);
    Nk();
    d(parambb, paramBoolean);
  }
  
  public void dl(boolean paramBoolean) {
    if (!getLifecycle().L().a(g.b.br))
      return; 
    if (paramBoolean)
      this.bgV.Yy(); 
  }
  
  public void eW(int paramInt) {
    TextView textView = this.bgU.bhE.bhQ;
    switch (paramInt) {
      default:
        return;
      case 7:
        this.bhf.setActivated(true);
        this.bhf.setVisibility(0);
        this.bgU.bhE.bbd.setVisibility(8);
        this.bgU.bhu.aQo.setVisibility(8);
        this.bgU.bht.aQo.setVisibility(0);
        this.bgU.bba.setVisibility(8);
        textView.setVisibility(8);
        return;
      case 6:
        this.bgU.bhE.bhQ.setActivated(true);
        this.bgU.bhE.bhQ.setText(2131627188);
        this.bgU.bhE.bhQ.setVisibility(0);
        this.bgU.bhE.bbd.setVisibility(8);
        this.bgU.bhu.aQo.setVisibility(8);
        this.bgU.bht.aQo.setVisibility(0);
        this.bgU.bba.setVisibility(8);
        this.bha.eX(3);
        this.bhf.setVisibility(8);
        return;
      case 5:
        textView.setActivated(true);
        textView.setVisibility(8);
        this.bgU.bhE.bbd.setVisibility(0);
        this.bgU.bhu.aQo.setVisibility(8);
        this.bgU.bht.aQo.setVisibility(0);
        this.bgU.bba.setVisibility(8);
        this.bhf.setVisibility(8);
        return;
      case 4:
        textView.setActivated(true);
        textView.setText(2131626884);
        textView.setVisibility(0);
        this.bgU.bhE.bbd.setVisibility(8);
        this.bgU.bhu.aQo.setVisibility(8);
        this.bgU.bht.aQo.setVisibility(0);
        this.bhf.setVisibility(8);
        return;
      case 3:
        textView.setActivated(true);
        textView.setText(2131627188);
        textView.setVisibility(0);
        this.bgU.bhE.bbd.setVisibility(8);
        this.bgU.bhu.aQo.setVisibility(0);
        this.bgU.bht.aQo.setVisibility(4);
        this.bgU.bba.setVisibility(8);
        this.bha.eX(2);
        this.bhf.setVisibility(8);
        return;
      case 2:
        textView.setActivated(true);
        textView.setText(2131627187);
        textView.setVisibility(0);
        this.bgU.bhE.bbd.setVisibility(8);
        this.bgU.bhu.aQo.setVisibility(8);
        this.bgU.bht.aQo.setVisibility(0);
        this.bha.eX(1);
        this.bhf.setVisibility(8);
        this.bgU.bba.setVisibility(0);
        return;
      case 1:
        break;
    } 
    textView.setActivated(false);
    textView.setText(2131627187);
    textView.setVisibility(0);
    this.bgU.bhE.bbd.setVisibility(8);
    this.bgU.bhu.aQo.setVisibility(8);
    this.bgU.bht.aQo.setVisibility(0);
    this.bha.eX(1);
    this.bhf.setVisibility(8);
    this.bgU.bba.setVisibility(8);
  }
  
  public void fa(String paramString) { n.o(paramString); }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    getLifecycle().L();
    if (paramInt1 != 102)
      return; 
    if (paramInt2 == -1) {
      TableEntity tableEntity1 = this.bhe;
      TableEntity tableEntity2 = (TableEntity)paramIntent.getSerializableExtra("tableEntity");
      a a1 = (a)paramIntent.getSerializableExtra("areaEntity");
      tableEntity2.Yg().gy(tableEntity1.Yg().Ym());
      a(a1, tableEntity1, tableEntity2, paramIntent.getIntExtra("tableNumberID", 0));
    } 
  }
  
  public void onAttach(Context paramContext) {
    super.onAttach(paramContext);
    this.bgU = new b(getActivity().findViewById(2131298428));
    this.bhf = (TextView)getActivity().findViewById(2131296789);
    this.bgZ = new j(getActivity(), this, new c(b.Xy()));
    this.bgZ.a(this.bgS.biC);
    this.bgZ.a(this.bgS.biE);
    this.bha = new d(this);
    MR();
    MS();
    MT();
    MU();
    MV();
    MW();
    MX();
    MY();
  }
  
  public void onCreate(@Nullable Bundle paramBundle) {
    super.onCreate(paramBundle);
    Na();
    MZ();
    this.bgT.b(this.bfr.bel.beI.b(new o(this)));
    this.bgT.b(this.bgS.biD.b(new c(this)));
    this.bgT.b(this.bfr.bdS.b(new d(this)));
    if (bd.bH(getContext()) && b.XB()) {
      Nj();
    } else {
      this.bgV.Yy();
    } 
    this.bgT.b(this.bgS.biF.b(new e(this)));
  }
  
  public void onDestroy() {
    super.onDestroy();
    if (this.bgT != null)
      this.bgT.wK(); 
    if (this.bgS != null)
      this.bgS.wK(); 
    Nb();
    Nc();
  }
  
  public void onDetach() {
    super.onDetach();
    this.bgZ.zM();
    Nd();
    Ne();
    Nf();
    Ng();
  }
  
  public void onResume() {
    super.onResume();
    h.a(this.bfr.bec, this.bgS.biB, this.bfr.bdW, this.bgS.biC, new ac(this)).c(LifecycleAwareObserver.a(getLifecycle(), g.a.ON_PAUSE, new f(this)));
  }
  
  public void onStart() {
    super.onStart();
    if (b.XC() || (b.XB() && bd.bH(RootApplication.zv())))
      ((c)this.bhj.get()).dismiss(); 
  }
  
  public void u(ArrayList<a> paramArrayList) {
    if (!getLifecycle().L().a(g.b.br))
      return; 
    this.bgV.Y(paramArrayList);
    this.bgV.YB();
  }
  
  public void v(ArrayList<TableEntity> paramArrayList) {
    if (!getLifecycle().L().a(g.b.br))
      return; 
    this.bhc.A(paramArrayList);
    this.bhc.Oc();
  }
  
  public static interface a {
    boolean NC();
  }
  
  public static final class b {
    View bba;
    
    RelativeLayout bbc;
    
    FrameLayout bhA;
    
    FrameLayout bhB;
    
    IconDotTextView bhC;
    
    c bhD;
    
    b bhE;
    
    g bht;
    
    d bhu;
    
    e bhv;
    
    f bhw;
    
    ListView bhx;
    
    IconDotTextView bhy;
    
    a bhz;
    
    b(View param1View) {
      this.bht = new g(param1View.findViewById(2131299275));
      this.bhu = new d(param1View.findViewById(2131298790));
      this.bhv = new e(param1View.findViewById(2131298825));
      this.bhw = new f(param1View.findViewById(2131297862));
      this.bhx = (ListView)param1View.findViewById(2131298532);
      this.bhy = (IconDotTextView)param1View.findViewById(2131296482);
      this.bhz = new a(param1View.findViewById(2131296485));
      this.bba = param1View.findViewById(2131298292);
      this.bhA = (FrameLayout)param1View.findViewById(2131298609);
      this.bhB = (FrameLayout)param1View.findViewById(2131296383);
      this.bhC = (IconDotTextView)param1View.findViewById(2131298525);
      this.bhD = new c(param1View.findViewById(2131298529));
      this.bhE = new b(param1View.findViewById(2131296486));
      this.bbc = (RelativeLayout)param1View.findViewById(2131298949);
    }
    
    static final class a {
      LinearLayout aQx;
      
      a bhF;
      
      b bhG;
      
      c bhH;
      
      a(View param2View) {
        this.aQx = (LinearLayout)param2View;
        this.bhF = new a(param2View.findViewById(2131298312));
        this.bhG = new b(param2View.findViewById(2131298314));
        this.bhH = new c(param2View.findViewById(2131299440));
      }
      
      static final class a {
        LinearLayout aQx;
        
        IconDotTextView bhI;
        
        IconDotTextView bhJ;
        
        a(View param3View) {
          this.aQx = (LinearLayout)param3View;
          this.bhI = (IconDotTextView)param3View.findViewById(2131298527);
          this.bhJ = (IconDotTextView)param3View.findViewById(2131296333);
        }
      }
      
      static final class b {
        LinearLayout aQx;
        
        IconDotTextView bgq;
        
        IconDotTextView bhK;
        
        IconDotTextView bhL;
        
        b(View param3View) {
          this.aQx = (LinearLayout)param3View;
          this.bhK = (IconDotTextView)param3View.findViewById(2131298543);
          this.bhL = (IconDotTextView)param3View.findViewById(2131296391);
          this.bgq = (IconDotTextView)param3View.findViewById(2131300030);
        }
      }
      
      static final class c {
        LinearLayout aQx;
        
        TextView bhM;
        
        TextView bhN;
        
        c(View param3View) {
          this.aQx = (LinearLayout)param3View;
          this.bhM = (TextView)param3View.findViewById(2131299439);
          this.bhN = (TextView)param3View.findViewById(2131299436);
        }
      }
    }
    
    static final class a {
      LinearLayout aQx;
      
      IconDotTextView bhI;
      
      IconDotTextView bhJ;
      
      a(View param2View) {
        this.aQx = (LinearLayout)param2View;
        this.bhI = (IconDotTextView)param2View.findViewById(2131298527);
        this.bhJ = (IconDotTextView)param2View.findViewById(2131296333);
      }
    }
    
    static final class b {
      LinearLayout aQx;
      
      IconDotTextView bgq;
      
      IconDotTextView bhK;
      
      IconDotTextView bhL;
      
      b(View param2View) {
        this.aQx = (LinearLayout)param2View;
        this.bhK = (IconDotTextView)param2View.findViewById(2131298543);
        this.bhL = (IconDotTextView)param2View.findViewById(2131296391);
        this.bgq = (IconDotTextView)param2View.findViewById(2131300030);
      }
    }
    
    static final class c {
      LinearLayout aQx;
      
      TextView bhM;
      
      TextView bhN;
      
      c(View param2View) {
        this.aQx = (LinearLayout)param2View;
        this.bhM = (TextView)param2View.findViewById(2131299439);
        this.bhN = (TextView)param2View.findViewById(2131299436);
      }
    }
    
    static final class b {
      LinearLayout aQx;
      
      TextView bbd;
      
      a bhO;
      
      b bhP;
      
      TextView bhQ;
      
      b(View param2View) {
        this.aQx = (LinearLayout)param2View;
        this.bhO = new a(param2View.findViewById(2131298485));
        this.bhP = new b(param2View.findViewById(2131299994));
        this.bbd = (TextView)param2View.findViewById(2131298948);
        this.bhQ = (TextView)param2View.findViewById(2131299181);
      }
      
      static final class a {
        LinearLayout aQx;
        
        TextView bgh;
        
        TextView bgi;
        
        TextView bgj;
        
        TextView bgk;
        
        TextView bgl;
        
        a(View param3View) {
          this.aQx = (LinearLayout)param3View;
          this.bgh = (TextView)param3View.findViewById(2131298486);
          this.bgi = (TextView)param3View.findViewById(2131298491);
          this.bgj = (TextView)param3View.findViewById(2131298492);
          this.bgk = (TextView)param3View.findViewById(2131298493);
          this.bgl = (TextView)param3View.findViewById(2131298494);
        }
      }
      
      static final class b {
        RelativeLayout aQo;
        
        ImageView bhR;
        
        View bhS;
        
        a bhT;
        
        b bhU;
        
        b(View param3View) {
          this.aQo = (RelativeLayout)param3View;
          this.bhR = (ImageView)param3View.findViewById(2131299990);
          this.bhS = param3View.findViewById(2131299995);
          this.bhT = new a(param3View.findViewById(2131299991));
          this.bhU = new b(param3View.findViewById(2131300001));
        }
        
        static final class a {
          RelativeLayout aQo;
          
          TextView bhV;
          
          TextView bhW;
          
          TextView bhX;
          
          TextView bhY;
          
          TextView bhZ;
          
          TextView bia;
          
          a(View param4View) {
            this.aQo = (RelativeLayout)param4View;
            this.bhV = (TextView)param4View.findViewById(2131300003);
            this.bhW = (TextView)param4View.findViewById(2131300004);
            this.bhX = (TextView)param4View.findViewById(2131299984);
            this.bhY = (TextView)param4View.findViewById(2131299985);
            this.bhZ = (TextView)param4View.findViewById(2131300006);
            this.bia = (TextView)param4View.findViewById(2131300007);
          }
        }
        
        static final class b {
          LinearLayout aQx;
          
          View bfv;
          
          b(View param4View) {
            this.aQx = (LinearLayout)param4View;
            this.bfv = param4View.findViewById(2131299989);
          }
        }
      }
      
      static final class a {
        RelativeLayout aQo;
        
        TextView bhV;
        
        TextView bhW;
        
        TextView bhX;
        
        TextView bhY;
        
        TextView bhZ;
        
        TextView bia;
        
        a(View param3View) {
          this.aQo = (RelativeLayout)param3View;
          this.bhV = (TextView)param3View.findViewById(2131300003);
          this.bhW = (TextView)param3View.findViewById(2131300004);
          this.bhX = (TextView)param3View.findViewById(2131299984);
          this.bhY = (TextView)param3View.findViewById(2131299985);
          this.bhZ = (TextView)param3View.findViewById(2131300006);
          this.bia = (TextView)param3View.findViewById(2131300007);
        }
      }
      
      static final class b {
        LinearLayout aQx;
        
        View bfv;
        
        b(View param3View) {
          this.aQx = (LinearLayout)param3View;
          this.bfv = param3View.findViewById(2131299989);
        }
      }
    }
    
    static final class a {
      LinearLayout aQx;
      
      TextView bgh;
      
      TextView bgi;
      
      TextView bgj;
      
      TextView bgk;
      
      TextView bgl;
      
      a(View param2View) {
        this.aQx = (LinearLayout)param2View;
        this.bgh = (TextView)param2View.findViewById(2131298486);
        this.bgi = (TextView)param2View.findViewById(2131298491);
        this.bgj = (TextView)param2View.findViewById(2131298492);
        this.bgk = (TextView)param2View.findViewById(2131298493);
        this.bgl = (TextView)param2View.findViewById(2131298494);
      }
    }
    
    static final class b {
      RelativeLayout aQo;
      
      ImageView bhR;
      
      View bhS;
      
      a bhT;
      
      b bhU;
      
      b(View param2View) {
        this.aQo = (RelativeLayout)param2View;
        this.bhR = (ImageView)param2View.findViewById(2131299990);
        this.bhS = param2View.findViewById(2131299995);
        this.bhT = new a(param2View.findViewById(2131299991));
        this.bhU = new b(param2View.findViewById(2131300001));
      }
      
      static final class a {
        RelativeLayout aQo;
        
        TextView bhV;
        
        TextView bhW;
        
        TextView bhX;
        
        TextView bhY;
        
        TextView bhZ;
        
        TextView bia;
        
        a(View param4View) {
          this.aQo = (RelativeLayout)param4View;
          this.bhV = (TextView)param4View.findViewById(2131300003);
          this.bhW = (TextView)param4View.findViewById(2131300004);
          this.bhX = (TextView)param4View.findViewById(2131299984);
          this.bhY = (TextView)param4View.findViewById(2131299985);
          this.bhZ = (TextView)param4View.findViewById(2131300006);
          this.bia = (TextView)param4View.findViewById(2131300007);
        }
      }
      
      static final class b {
        LinearLayout aQx;
        
        View bfv;
        
        b(View param4View) {
          this.aQx = (LinearLayout)param4View;
          this.bfv = param4View.findViewById(2131299989);
        }
      }
    }
    
    static final class a {
      RelativeLayout aQo;
      
      TextView bhV;
      
      TextView bhW;
      
      TextView bhX;
      
      TextView bhY;
      
      TextView bhZ;
      
      TextView bia;
      
      a(View param2View) {
        this.aQo = (RelativeLayout)param2View;
        this.bhV = (TextView)param2View.findViewById(2131300003);
        this.bhW = (TextView)param2View.findViewById(2131300004);
        this.bhX = (TextView)param2View.findViewById(2131299984);
        this.bhY = (TextView)param2View.findViewById(2131299985);
        this.bhZ = (TextView)param2View.findViewById(2131300006);
        this.bia = (TextView)param2View.findViewById(2131300007);
      }
    }
    
    static final class b {
      LinearLayout aQx;
      
      View bfv;
      
      b(View param2View) {
        this.aQx = (LinearLayout)param2View;
        this.bfv = param2View.findViewById(2131299989);
      }
    }
    
    static final class c {
      TextView bfZ;
      
      CoordinatorLayout bib;
      
      c bic;
      
      b bid;
      
      a bie;
      
      c(View param2View) {
        this.bib = (CoordinatorLayout)param2View;
        this.bic = new c(param2View.findViewById(2131298530));
        this.bid = new b(param2View.findViewById(2131296384));
        this.bie = new a(param2View.findViewById(2131298800));
        this.bfZ = (TextView)param2View.findViewById(2131296435);
      }
      
      static final class a {
        RelativeLayout aQo;
        
        View bif;
        
        a(View param3View) {
          this.aQo = (RelativeLayout)param3View;
          this.bif = param3View.findViewById(2131297411);
        }
      }
      
      static final class b {
        RelativeLayout aQo;
        
        GridView big;
        
        TextView bih;
        
        b(View param3View) {
          this.aQo = (RelativeLayout)param3View;
          this.big = (GridView)param3View.findViewById(2131299146);
          this.bih = (TextView)param3View.findViewById(2131298526);
        }
      }
      
      static final class c {
        RelativeLayout aQo;
        
        GridView bii;
        
        TextView bij;
        
        c(View param3View) {
          this.aQo = (RelativeLayout)param3View;
          this.bii = (GridView)param3View.findViewById(2131298528);
          this.bij = (TextView)param3View.findViewById(2131298531);
        }
      }
    }
    
    static final class a {
      RelativeLayout aQo;
      
      View bif;
      
      a(View param2View) {
        this.aQo = (RelativeLayout)param2View;
        this.bif = param2View.findViewById(2131297411);
      }
    }
    
    static final class b {
      RelativeLayout aQo;
      
      GridView big;
      
      TextView bih;
      
      b(View param2View) {
        this.aQo = (RelativeLayout)param2View;
        this.big = (GridView)param2View.findViewById(2131299146);
        this.bih = (TextView)param2View.findViewById(2131298526);
      }
    }
    
    static final class c {
      RelativeLayout aQo;
      
      GridView bii;
      
      TextView bij;
      
      c(View param2View) {
        this.aQo = (RelativeLayout)param2View;
        this.bii = (GridView)param2View.findViewById(2131298528);
        this.bij = (TextView)param2View.findViewById(2131298531);
      }
    }
    
    static final class d {
      RelativeLayout aQo;
      
      View bik;
      
      View bil;
      
      TextView bim;
      
      TextView bio;
      
      TextView bip;
      
      TextView biq;
      
      TextView bir;
      
      View view;
      
      d(View param2View) {
        this.aQo = (RelativeLayout)param2View;
        this.bik = param2View.findViewById(2131299955);
        this.bil = param2View.findViewById(2131299954);
        this.bim = (TextView)param2View.findViewById(2131296381);
        this.bio = (TextView)param2View.findViewById(2131296902);
        this.bip = (TextView)param2View.findViewById(2131298404);
        this.biq = (TextView)param2View.findViewById(2131298405);
        this.bir = (TextView)param2View.findViewById(2131299232);
        this.view = param2View.findViewById(2131299975);
      }
    }
    
    static final class e {
      RelativeLayout aQo;
      
      View bis;
      
      TextView biu;
      
      TextView biv;
      
      e(View param2View) {
        this.aQo = (RelativeLayout)param2View;
        this.bis = param2View.findViewById(2131298407);
        this.biu = (TextView)param2View.findViewById(2131298827);
        this.biv = (TextView)param2View.findViewById(2131298824);
      }
    }
    
    private static final class f {
      LinearLayout aQx;
      
      RecyclerView biw;
      
      f(View param2View) {
        this.aQx = (LinearLayout)param2View;
        this.biw = (RecyclerView)param2View.findViewById(2131298818);
      }
    }
    
    static final class g {
      RelativeLayout aQo;
      
      IconDotTextView bbf;
      
      IconDotTextView bbg;
      
      IconDotTextView bbh;
      
      IconDotTextView bgR;
      
      IconDotTextView bix;
      
      IconDotTextView biy;
      
      IconDotTextView biz;
      
      View view;
      
      g(View param2View) {
        this.aQo = (RelativeLayout)param2View;
        this.bbf = (IconDotTextView)param2View.findViewById(2131299250);
        this.bix = (IconDotTextView)param2View.findViewById(2131296279);
        this.biy = (IconDotTextView)param2View.findViewById(2131296290);
        this.biz = (IconDotTextView)param2View.findViewById(2131298946);
        this.bgR = (IconDotTextView)param2View.findViewById(2131298188);
        this.view = param2View.findViewById(2131299975);
        this.bbg = (IconDotTextView)param2View.findViewById(2131299195);
        this.bbh = (IconDotTextView)param2View.findViewById(2131298655);
      }
    }
  }
  
  static final class a {
    LinearLayout aQx;
    
    a bhF;
    
    b bhG;
    
    c bhH;
    
    a(View param1View) {
      this.aQx = (LinearLayout)param1View;
      this.bhF = new a(param1View.findViewById(2131298312));
      this.bhG = new b(param1View.findViewById(2131298314));
      this.bhH = new c(param1View.findViewById(2131299440));
    }
    
    static final class a {
      LinearLayout aQx;
      
      IconDotTextView bhI;
      
      IconDotTextView bhJ;
      
      a(View param3View) {
        this.aQx = (LinearLayout)param3View;
        this.bhI = (IconDotTextView)param3View.findViewById(2131298527);
        this.bhJ = (IconDotTextView)param3View.findViewById(2131296333);
      }
    }
    
    static final class b {
      LinearLayout aQx;
      
      IconDotTextView bgq;
      
      IconDotTextView bhK;
      
      IconDotTextView bhL;
      
      b(View param3View) {
        this.aQx = (LinearLayout)param3View;
        this.bhK = (IconDotTextView)param3View.findViewById(2131298543);
        this.bhL = (IconDotTextView)param3View.findViewById(2131296391);
        this.bgq = (IconDotTextView)param3View.findViewById(2131300030);
      }
    }
    
    static final class c {
      LinearLayout aQx;
      
      TextView bhM;
      
      TextView bhN;
      
      c(View param3View) {
        this.aQx = (LinearLayout)param3View;
        this.bhM = (TextView)param3View.findViewById(2131299439);
        this.bhN = (TextView)param3View.findViewById(2131299436);
      }
    }
  }
  
  static final class a {
    LinearLayout aQx;
    
    IconDotTextView bhI;
    
    IconDotTextView bhJ;
    
    a(View param1View) {
      this.aQx = (LinearLayout)param1View;
      this.bhI = (IconDotTextView)param1View.findViewById(2131298527);
      this.bhJ = (IconDotTextView)param1View.findViewById(2131296333);
    }
  }
  
  static final class b {
    LinearLayout aQx;
    
    IconDotTextView bgq;
    
    IconDotTextView bhK;
    
    IconDotTextView bhL;
    
    b(View param1View) {
      this.aQx = (LinearLayout)param1View;
      this.bhK = (IconDotTextView)param1View.findViewById(2131298543);
      this.bhL = (IconDotTextView)param1View.findViewById(2131296391);
      this.bgq = (IconDotTextView)param1View.findViewById(2131300030);
    }
  }
  
  static final class c {
    LinearLayout aQx;
    
    TextView bhM;
    
    TextView bhN;
    
    c(View param1View) {
      this.aQx = (LinearLayout)param1View;
      this.bhM = (TextView)param1View.findViewById(2131299439);
      this.bhN = (TextView)param1View.findViewById(2131299436);
    }
  }
  
  static final class b {
    LinearLayout aQx;
    
    TextView bbd;
    
    a bhO;
    
    b bhP;
    
    TextView bhQ;
    
    b(View param1View) {
      this.aQx = (LinearLayout)param1View;
      this.bhO = new a(param1View.findViewById(2131298485));
      this.bhP = new b(param1View.findViewById(2131299994));
      this.bbd = (TextView)param1View.findViewById(2131298948);
      this.bhQ = (TextView)param1View.findViewById(2131299181);
    }
    
    static final class a {
      LinearLayout aQx;
      
      TextView bgh;
      
      TextView bgi;
      
      TextView bgj;
      
      TextView bgk;
      
      TextView bgl;
      
      a(View param3View) {
        this.aQx = (LinearLayout)param3View;
        this.bgh = (TextView)param3View.findViewById(2131298486);
        this.bgi = (TextView)param3View.findViewById(2131298491);
        this.bgj = (TextView)param3View.findViewById(2131298492);
        this.bgk = (TextView)param3View.findViewById(2131298493);
        this.bgl = (TextView)param3View.findViewById(2131298494);
      }
    }
    
    static final class b {
      RelativeLayout aQo;
      
      ImageView bhR;
      
      View bhS;
      
      a bhT;
      
      b bhU;
      
      b(View param3View) {
        this.aQo = (RelativeLayout)param3View;
        this.bhR = (ImageView)param3View.findViewById(2131299990);
        this.bhS = param3View.findViewById(2131299995);
        this.bhT = new a(param3View.findViewById(2131299991));
        this.bhU = new b(param3View.findViewById(2131300001));
      }
      
      static final class a {
        RelativeLayout aQo;
        
        TextView bhV;
        
        TextView bhW;
        
        TextView bhX;
        
        TextView bhY;
        
        TextView bhZ;
        
        TextView bia;
        
        a(View param4View) {
          this.aQo = (RelativeLayout)param4View;
          this.bhV = (TextView)param4View.findViewById(2131300003);
          this.bhW = (TextView)param4View.findViewById(2131300004);
          this.bhX = (TextView)param4View.findViewById(2131299984);
          this.bhY = (TextView)param4View.findViewById(2131299985);
          this.bhZ = (TextView)param4View.findViewById(2131300006);
          this.bia = (TextView)param4View.findViewById(2131300007);
        }
      }
      
      static final class b {
        LinearLayout aQx;
        
        View bfv;
        
        b(View param4View) {
          this.aQx = (LinearLayout)param4View;
          this.bfv = param4View.findViewById(2131299989);
        }
      }
    }
    
    static final class a {
      RelativeLayout aQo;
      
      TextView bhV;
      
      TextView bhW;
      
      TextView bhX;
      
      TextView bhY;
      
      TextView bhZ;
      
      TextView bia;
      
      a(View param3View) {
        this.aQo = (RelativeLayout)param3View;
        this.bhV = (TextView)param3View.findViewById(2131300003);
        this.bhW = (TextView)param3View.findViewById(2131300004);
        this.bhX = (TextView)param3View.findViewById(2131299984);
        this.bhY = (TextView)param3View.findViewById(2131299985);
        this.bhZ = (TextView)param3View.findViewById(2131300006);
        this.bia = (TextView)param3View.findViewById(2131300007);
      }
    }
    
    static final class b {
      LinearLayout aQx;
      
      View bfv;
      
      b(View param3View) {
        this.aQx = (LinearLayout)param3View;
        this.bfv = param3View.findViewById(2131299989);
      }
    }
  }
  
  static final class a {
    LinearLayout aQx;
    
    TextView bgh;
    
    TextView bgi;
    
    TextView bgj;
    
    TextView bgk;
    
    TextView bgl;
    
    a(View param1View) {
      this.aQx = (LinearLayout)param1View;
      this.bgh = (TextView)param1View.findViewById(2131298486);
      this.bgi = (TextView)param1View.findViewById(2131298491);
      this.bgj = (TextView)param1View.findViewById(2131298492);
      this.bgk = (TextView)param1View.findViewById(2131298493);
      this.bgl = (TextView)param1View.findViewById(2131298494);
    }
  }
  
  static final class b {
    RelativeLayout aQo;
    
    ImageView bhR;
    
    View bhS;
    
    a bhT;
    
    b bhU;
    
    b(View param1View) {
      this.aQo = (RelativeLayout)param1View;
      this.bhR = (ImageView)param1View.findViewById(2131299990);
      this.bhS = param1View.findViewById(2131299995);
      this.bhT = new a(param1View.findViewById(2131299991));
      this.bhU = new b(param1View.findViewById(2131300001));
    }
    
    static final class a {
      RelativeLayout aQo;
      
      TextView bhV;
      
      TextView bhW;
      
      TextView bhX;
      
      TextView bhY;
      
      TextView bhZ;
      
      TextView bia;
      
      a(View param4View) {
        this.aQo = (RelativeLayout)param4View;
        this.bhV = (TextView)param4View.findViewById(2131300003);
        this.bhW = (TextView)param4View.findViewById(2131300004);
        this.bhX = (TextView)param4View.findViewById(2131299984);
        this.bhY = (TextView)param4View.findViewById(2131299985);
        this.bhZ = (TextView)param4View.findViewById(2131300006);
        this.bia = (TextView)param4View.findViewById(2131300007);
      }
    }
    
    static final class b {
      LinearLayout aQx;
      
      View bfv;
      
      b(View param4View) {
        this.aQx = (LinearLayout)param4View;
        this.bfv = param4View.findViewById(2131299989);
      }
    }
  }
  
  static final class a {
    RelativeLayout aQo;
    
    TextView bhV;
    
    TextView bhW;
    
    TextView bhX;
    
    TextView bhY;
    
    TextView bhZ;
    
    TextView bia;
    
    a(View param1View) {
      this.aQo = (RelativeLayout)param1View;
      this.bhV = (TextView)param1View.findViewById(2131300003);
      this.bhW = (TextView)param1View.findViewById(2131300004);
      this.bhX = (TextView)param1View.findViewById(2131299984);
      this.bhY = (TextView)param1View.findViewById(2131299985);
      this.bhZ = (TextView)param1View.findViewById(2131300006);
      this.bia = (TextView)param1View.findViewById(2131300007);
    }
  }
  
  static final class b {
    LinearLayout aQx;
    
    View bfv;
    
    b(View param1View) {
      this.aQx = (LinearLayout)param1View;
      this.bfv = param1View.findViewById(2131299989);
    }
  }
  
  static final class c {
    TextView bfZ;
    
    CoordinatorLayout bib;
    
    c bic;
    
    b bid;
    
    a bie;
    
    c(View param1View) {
      this.bib = (CoordinatorLayout)param1View;
      this.bic = new c(param1View.findViewById(2131298530));
      this.bid = new b(param1View.findViewById(2131296384));
      this.bie = new a(param1View.findViewById(2131298800));
      this.bfZ = (TextView)param1View.findViewById(2131296435);
    }
    
    static final class a {
      RelativeLayout aQo;
      
      View bif;
      
      a(View param3View) {
        this.aQo = (RelativeLayout)param3View;
        this.bif = param3View.findViewById(2131297411);
      }
    }
    
    static final class b {
      RelativeLayout aQo;
      
      GridView big;
      
      TextView bih;
      
      b(View param3View) {
        this.aQo = (RelativeLayout)param3View;
        this.big = (GridView)param3View.findViewById(2131299146);
        this.bih = (TextView)param3View.findViewById(2131298526);
      }
    }
    
    static final class c {
      RelativeLayout aQo;
      
      GridView bii;
      
      TextView bij;
      
      c(View param3View) {
        this.aQo = (RelativeLayout)param3View;
        this.bii = (GridView)param3View.findViewById(2131298528);
        this.bij = (TextView)param3View.findViewById(2131298531);
      }
    }
  }
  
  static final class a {
    RelativeLayout aQo;
    
    View bif;
    
    a(View param1View) {
      this.aQo = (RelativeLayout)param1View;
      this.bif = param1View.findViewById(2131297411);
    }
  }
  
  static final class b {
    RelativeLayout aQo;
    
    GridView big;
    
    TextView bih;
    
    b(View param1View) {
      this.aQo = (RelativeLayout)param1View;
      this.big = (GridView)param1View.findViewById(2131299146);
      this.bih = (TextView)param1View.findViewById(2131298526);
    }
  }
  
  static final class c {
    RelativeLayout aQo;
    
    GridView bii;
    
    TextView bij;
    
    c(View param1View) {
      this.aQo = (RelativeLayout)param1View;
      this.bii = (GridView)param1View.findViewById(2131298528);
      this.bij = (TextView)param1View.findViewById(2131298531);
    }
  }
  
  static final class d {
    RelativeLayout aQo;
    
    View bik;
    
    View bil;
    
    TextView bim;
    
    TextView bio;
    
    TextView bip;
    
    TextView biq;
    
    TextView bir;
    
    View view;
    
    d(View param1View) {
      this.aQo = (RelativeLayout)param1View;
      this.bik = param1View.findViewById(2131299955);
      this.bil = param1View.findViewById(2131299954);
      this.bim = (TextView)param1View.findViewById(2131296381);
      this.bio = (TextView)param1View.findViewById(2131296902);
      this.bip = (TextView)param1View.findViewById(2131298404);
      this.biq = (TextView)param1View.findViewById(2131298405);
      this.bir = (TextView)param1View.findViewById(2131299232);
      this.view = param1View.findViewById(2131299975);
    }
  }
  
  static final class e {
    RelativeLayout aQo;
    
    View bis;
    
    TextView biu;
    
    TextView biv;
    
    e(View param1View) {
      this.aQo = (RelativeLayout)param1View;
      this.bis = param1View.findViewById(2131298407);
      this.biu = (TextView)param1View.findViewById(2131298827);
      this.biv = (TextView)param1View.findViewById(2131298824);
    }
  }
  
  private static final class f {
    LinearLayout aQx;
    
    RecyclerView biw;
    
    f(View param1View) {
      this.aQx = (LinearLayout)param1View;
      this.biw = (RecyclerView)param1View.findViewById(2131298818);
    }
  }
  
  static final class g {
    RelativeLayout aQo;
    
    IconDotTextView bbf;
    
    IconDotTextView bbg;
    
    IconDotTextView bbh;
    
    IconDotTextView bgR;
    
    IconDotTextView bix;
    
    IconDotTextView biy;
    
    IconDotTextView biz;
    
    View view;
    
    g(View param1View) {
      this.aQo = (RelativeLayout)param1View;
      this.bbf = (IconDotTextView)param1View.findViewById(2131299250);
      this.bix = (IconDotTextView)param1View.findViewById(2131296279);
      this.biy = (IconDotTextView)param1View.findViewById(2131296290);
      this.biz = (IconDotTextView)param1View.findViewById(2131298946);
      this.bgR = (IconDotTextView)param1View.findViewById(2131298188);
      this.view = param1View.findViewById(2131299975);
      this.bbg = (IconDotTextView)param1View.findViewById(2131299195);
      this.bbh = (IconDotTextView)param1View.findViewById(2131298655);
    }
  }
  
  public static interface c {
    void c(PendingFullOrderDetail param1PendingFullOrderDetail);
  }
  
  class d implements View.OnClickListener {
    private int biA = 1;
    
    d(PosActivityOpenTableFragment this$0) {}
    
    void eX(int param1Int) { this.biA = param1Int; }
    
    public void onClick(View param1View) {
      switch (this.biA) {
        default:
          return;
        case 3:
          this.bhq.Nm();
          return;
        case 2:
          this.bhq.Nl();
          return;
        case 1:
          break;
      } 
      if ((PosActivityOpenTableFragment.a(this.bhq)).beg.getValue() != TableEntity.bZK && PosActivityOpenTableFragment.g(this.bhq) != null && !((TableEntity)(PosActivityOpenTableFragment.a(this.bhq)).beg.getValue()).Yi()) {
        (PosActivityOpenTableFragment.a(this.bhq)).bea.Mi();
        ((c)PosActivityOpenTableFragment.h(this.bhq).get()).a((TableEntity)(PosActivityOpenTableFragment.a(this.bhq)).beg.getValue(), PosActivityOpenTableFragment.g(this.bhq), true, PosActivityOpenTableFragment.f(this.bhq).YA(), true, null);
        return;
      } 
      n.eP(2131627191);
    }
  }
  
  public static class e {
    a bgv = new a();
    
    b<Boolean> biB = b.ak(Boolean.valueOf(false));
    
    b<Boolean> biC = b.ak(Boolean.valueOf(false));
    
    c<s> biD;
    
    c<Boolean> biE;
    
    public c<bb> biF = (this.biE = (this.biD = c.wO()).wO()).wO();
    
    e(dl param1dl) { this.bgv.b(param1dl.bef.b(new ad(this))); }
    
    void wK() {
      if (this.bgv != null) {
        this.bgv.wK();
        this.bgv = null;
      } 
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\opentable\PosActivityOpenTableFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */