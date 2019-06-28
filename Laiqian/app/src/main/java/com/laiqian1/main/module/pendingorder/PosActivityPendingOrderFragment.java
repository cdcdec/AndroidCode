package com.laiqian.main.module.pendingorder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.laiqian.entity.aq;
import com.laiqian.main.dl;
import com.laiqian.main.module.productcart.am;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.pos.hold.ai;
import com.laiqian.pos.model.a;
import com.laiqian.util.ay;
import com.laiqian.util.logger.a;
import com.laiqian.util.n;
import io.reactivex.a.a;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class PosActivityPendingOrderFragment extends Fragment {
  public static String TAG = "PosActivityPendingOrderFragment";
  
  private a aOV;
  
  private dl bfr;
  
  private a biH;
  
  private a biI;
  
  private BroadcastReceiver biJ;
  
  private BroadcastReceiver biK;
  
  private ay<ai> biL;
  
  static  {
  
  }
  
  public PosActivityPendingOrderFragment(dl paramdl) {
    this.bfr = paramdl;
    this.aOV = new a(TAG);
  }
  
  private void NE() {
    this.biJ = new e(this);
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("pos_activity_change_data_takeorderscount");
    getActivity().registerReceiver(this.biJ, intentFilter);
    this.biK = new f(this);
    intentFilter = new IntentFilter();
    intentFilter.addAction("android.intent.action.TIME_TICK");
    intentFilter.addAction("android.intent.action.TIME_SET");
    intentFilter.addAction("android.intent.action.DATE_CHANGED");
    getActivity().registerReceiver(this.biK, intentFilter);
  }
  
  private void NF() {
    this.biL = null;
    this.biI.aQx.setVisibility(8);
    this.biI.aQx.setOnClickListener(null);
  }
  
  private void NG() {
    String str = new a(getContext());
    int i = str.kt(String.valueOf(0));
    str.close();
    if (i == 0) {
      this.biI.aQx.setVisibility(8);
      return;
    } 
    if (i > 99) {
      String str1 = "99+";
    } else {
      str = String.valueOf(i);
    } 
    this.biI.aQx.setVisibility(0);
    this.biI.biT.setText(str);
    this.biI.biT.setTag(Integer.valueOf(i));
  }
  
  private void NH() { this.bfr.bem.beC.accept(new Object()); }
  
  private void b(PendingFullOrderDetail paramPendingFullOrderDetail, boolean paramBoolean) {
    String str = String.valueOf(86003L);
    if (!str.equals(this.bfr.bea.beM.getValue()))
      this.bfr.bea.beM.accept(str); 
    d(paramPendingFullOrderDetail);
    if (paramBoolean) {
      if (this.bfr.bea.beO.aoL().isEmpty()) {
        n.eP(2131628174);
        return;
      } 
      NH();
    } 
  }
  
  private void d(PendingFullOrderDetail paramPendingFullOrderDetail) {
    if (paramPendingFullOrderDetail == null) {
      this.aOV.c("加载订单为 null", new Object[0]);
      return;
    } 
    if (paramPendingFullOrderDetail.bXb.bZF != 0) {
      this.aOV.c("加载订单类型不正确。期望的类型：$s，实际类型：$s", new Object[] { Integer.valueOf(0), Integer.valueOf(paramPendingFullOrderDetail.bXb.bZF) });
      return;
    } 
    e(paramPendingFullOrderDetail);
    this.bfr.bea.Mi();
    this.bfr.beb.accept(Integer.valueOf(15));
    this.bfr.a(paramPendingFullOrderDetail.bXb);
    this.bfr.LX();
    this.bfr.c(aq.aWG);
    ArrayList arrayList = new ArrayList();
    null = paramPendingFullOrderDetail.coy.iterator();
    byte b;
    for (b = 0; null.hasNext(); b++) {
      PendingFullOrderDetail.d d = (PendingFullOrderDetail.d)null.next();
      if (!b)
        arrayList.add(new am.a.b(new Date(d.bbX))); 
      arrayList.add(new am.a.a(d, (Boolean)this.bfr.bee.getValue()));
    } 
    for (PendingFullOrderDetail.c c : paramPendingFullOrderDetail.coz) {
      Iterator iterator = c.cpg.iterator();
      for (b = 0; iterator.hasNext(); b = b1) {
        PendingFullOrderDetail.d d = (PendingFullOrderDetail.d)iterator.next();
        byte b1 = b;
        if (b == 0) {
          arrayList.add(new am.a.b(c.cpi));
          b1 = 1;
        } 
        arrayList.add(new am.a.a(d, (Boolean)this.bfr.bee.getValue()));
      } 
    } 
    this.bfr.beh.accept(paramPendingFullOrderDetail.bXb.coJ);
    this.bfr.bea.i(arrayList);
  }
  
  private void e(PendingFullOrderDetail paramPendingFullOrderDetail) {
    for (byte b = 0; b < paramPendingFullOrderDetail.coy.size(); b++) {
      PendingFullOrderDetail.d d = (PendingFullOrderDetail.d)paramPendingFullOrderDetail.coy.get(b);
      if (d.cpo < 0.0D) {
        ((PendingFullOrderDetail.d)paramPendingFullOrderDetail.coy.get(b)).cpn = 0.0D;
        ((PendingFullOrderDetail.d)paramPendingFullOrderDetail.coy.get(b)).cps = (((PendingFullOrderDetail.d)paramPendingFullOrderDetail.coy.get(b)).cpt = Double.valueOf(0.0D)).valueOf(0.0D);
        ((PendingFullOrderDetail.d)paramPendingFullOrderDetail.coy.get(b)).cpu = 0.0D;
      } 
      if (d.cpx == 3L)
        d.cpu = 0.0D; 
    } 
    Iterator iterator = paramPendingFullOrderDetail.coz.iterator();
    while (iterator.hasNext()) {
      for (PendingFullOrderDetail.d d : ((PendingFullOrderDetail.c)iterator.next()).cpg) {
        if (d.cpo < 0.0D) {
          d.cpn = 0.0D;
          d.cps = (d.cpt = Double.valueOf(0.0D)).valueOf(0.0D);
          d.cpu = 0.0D;
        } 
        if (d.cpx == 3L)
          d.cpu = 0.0D; 
      } 
    } 
  }
  
  private void setupViews() {
    this.biL = new i(this, new h(this));
    this.biI.aQx.setOnClickListener(new d(this));
  }
  
  public void onAttach(Context paramContext) {
    super.onAttach(paramContext);
    if (paramContext instanceof AppCompatActivity) {
      this.biI = new a(((AppCompatActivity)paramContext).findViewById(2131299171));
      setupViews();
      NG();
      return;
    } 
    throw new RuntimeException("no idea how to continue");
  }
  
  public void onCreate(@Nullable Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.biH = new a();
    this.biH.b(this.bfr.bef.b(new b(this)));
    this.biH.b(this.bfr.bel.beI.b(new c(this)));
    NE();
  }
  
  public void onDestroy() {
    super.onDestroy();
    if (this.biH != null)
      this.biH.wK(); 
    if (this.biJ != null)
      getActivity().unregisterReceiver(this.biJ); 
    if (this.biK != null)
      getActivity().unregisterReceiver(this.biK); 
  }
  
  public void onDetach() {
    super.onDetach();
    NF();
  }
  
  static class a {
    LinearLayout aQx;
    
    TextView biT;
    
    a(View param1View) {
      this.aQx = (LinearLayout)param1View;
      this.biT = (TextView)param1View.findViewById(2131299172);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\pendingorder\PosActivityPendingOrderFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */