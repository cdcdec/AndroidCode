package com.laiqian.main.module.scanorder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.assistne.icondottextview.IconDotTextView;
import com.jakewharton.rxbinding2.a.a;
import com.laiqian.entity.z;
import com.laiqian.main.PhoneOrders;
import com.laiqian.main.module.opentable.PosActivityOpenTableFragment;
import com.laiqian.news.aa;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.util.n;
import io.reactivex.a.a;
import io.reactivex.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class PosActivityScanOrderFragment extends Fragment implements PosActivityOpenTableFragment.a, PosActivityOpenTableFragment.c {
  public static String TAG = "PosActivityScanOrderFragment";
  
  a bgv = new a();
  
  private b blt;
  
  private aa blu;
  
  BroadcastReceiver blv;
  
  a blw = new a(this);
  
  PosActivityOpenTableFragment.e blx;
  
  static  {
  
  }
  
  public PosActivityScanOrderFragment(PosActivityOpenTableFragment.e parame) { this.blx = parame; }
  
  private void NF() {
    this.blt.bix.setVisibility(8);
    this.blt.bix.setOnClickListener(null);
    this.bgv.wK();
  }
  
  private void fc(int paramInt) {
    if (paramInt != 0) {
      this.blt.bix.cQ(paramInt);
      this.blt.bix.aZ(true);
      return;
    } 
    this.blt.bix.aZ(false);
  }
  
  private void setupViews() {
    this.blt.bix.setOnClickListener(new a(this));
    this.blt.bix.setVisibility(0);
    this.blt.bhf.setSelected(true);
    a a1 = this.bgv;
    h h = a.bu(this.blt.bhf).i(1500L, TimeUnit.MILLISECONDS).d(new b(this));
    a a2 = this.blw;
    a2.getClass();
    a1.b(h.b(c.a(a2)));
  }
  
  public boolean NC() {
    PendingFullOrderDetail pendingFullOrderDetail = this.blw.Og();
    if (pendingFullOrderDetail != null && pendingFullOrderDetail.bXb.bZF == 3) {
      for (PendingFullOrderDetail.d d : pendingFullOrderDetail.coy) {
        if (d.aTU == 0 || d.aTU == -1) {
          n.eP(2131629927);
          return false;
        } 
      } 
      Iterator iterator = pendingFullOrderDetail.coz.iterator();
      while (iterator.hasNext()) {
        for (PendingFullOrderDetail.d d : ((PendingFullOrderDetail.c)iterator.next()).cpg) {
          if (d.aTU == 0 || d.aTU == -1) {
            n.eP(2131629927);
            return false;
          } 
        } 
      } 
    } 
    return true;
  }
  
  public void c(PendingFullOrderDetail paramPendingFullOrderDetail) { this.blw.f(paramPendingFullOrderDetail); }
  
  public void onAttach(Context paramContext) {
    super.onAttach(paramContext);
    this.blt = new b(((AppCompatActivity)paramContext).findViewById(2131298428));
    setupViews();
  }
  
  public void onCreate(@Nullable Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.blv = new d(this);
    getActivity().registerReceiver(this.blv, new IntentFilter(aa.bXp));
    this.blu = aa.Xb();
    this.blu.c(getContext().getApplicationContext(), 5000L);
    this.blu.start();
  }
  
  public void onDestroy() {
    super.onDestroy();
    this.blu.stop();
    getActivity().unregisterReceiver(this.blv);
  }
  
  public void onDetach() {
    super.onDetach();
    NF();
  }
  
  public class a implements View.OnClickListener {
    PendingFullOrderDetail blB;
    
    public a(PosActivityScanOrderFragment this$0) {}
    
    public PendingFullOrderDetail Og() { return this.blB; }
    
    public void f(PendingFullOrderDetail param1PendingFullOrderDetail) { this.blB = param1PendingFullOrderDetail; }
    
    public void onClick(View param1View) {
      PendingFullOrderDetail pendingFullOrderDetail = this.blB;
      ArrayList arrayList = new ArrayList();
      if (pendingFullOrderDetail.bXb.bfk != 0.0D) {
        if (pendingFullOrderDetail.bXb.bfj != 0.0D) {
          z z;
          if (pendingFullOrderDetail.bXb.aVS == 10007L) {
            z = new z('✗', pendingFullOrderDetail.bXb.bfj, "支付宝在线支付", 4L);
          } else if (pendingFullOrderDetail.bXb.btX == 10009) {
            z = new z('✙', pendingFullOrderDetail.bXb.bfj, "微信在线支付", 6L);
          } else {
            z = new z('✗', pendingFullOrderDetail.bXb.bfj, "支付宝在线支付", 4L);
          } 
          arrayList.add(z);
        } 
        arrayList.add(new z(Integer.parseInt(String.valueOf(pendingFullOrderDetail.bXb.aVU)), pendingFullOrderDetail.bXb.bfk, "会员支付", 9L));
      } else {
        z z;
        if (pendingFullOrderDetail.bXb.btX == 10007) {
          z = new z('✗', pendingFullOrderDetail.bXb.cpc.doubleValue(), "支付宝在线支付", 4L);
        } else if (pendingFullOrderDetail.bXb.btX == 10009) {
          z = new z('✙', pendingFullOrderDetail.bXb.cpc.doubleValue(), "微信在线支付", 6L);
        } else if (pendingFullOrderDetail.bXb.btX == 10006) {
          z = new z('✖', pendingFullOrderDetail.bXb.cpc.doubleValue(), "会员支付", 9L);
        } else {
          z = new z('✗', pendingFullOrderDetail.bXb.cpc.doubleValue(), "支付宝在线支付", 4L);
        } 
        arrayList.add(z);
      } 
      (new PhoneOrders(this.blA.getActivity(), pendingFullOrderDetail, 2, arrayList, new e(this, pendingFullOrderDetail))).setTableID(n.parseLong(pendingFullOrderDetail.bXb.coJ)).setActualPerson(pendingFullOrderDetail.bXb.bZM).setTotalAmount(pendingFullOrderDetail.bXb.cpc.doubleValue()).setOrderDateTime(pendingFullOrderDetail.bXb.coE.getTime()).startOrderAsyncTask();
    }
  }
  
  static class b {
    TextView bhf;
    
    IconDotTextView bix;
    
    b(View param1View) {
      this.bix = (IconDotTextView)param1View.findViewById(2131296279);
      this.bhf = (TextView)param1View.findViewById(2131296789);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\scanorder\PosActivityScanOrderFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */