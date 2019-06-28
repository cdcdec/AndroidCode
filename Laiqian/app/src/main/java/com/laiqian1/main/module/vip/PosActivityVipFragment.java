package com.laiqian.main.module.vip;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.laiqian.basic.RootApplication;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.entity.aq;
import com.laiqian.entity.g;
import com.laiqian.main.dl;
import com.laiqian.member.select.PosSelectVipDialog;
import com.laiqian.member.select.r;
import com.laiqian.member.select.y;
import com.laiqian.models.at;
import com.laiqian.models.l;
import com.laiqian.pos.bl;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.util.ay;
import com.laiqian.util.by;
import com.laiqian.util.n;
import io.reactivex.a.a;

public class PosActivityVipFragment extends Fragment {
  public static String TAG = "PosActivityVipFragment";
  
  private BroadcastReceiver aqG;
  
  private dl bfr;
  
  private a bgv = new a();
  
  private a bph;
  
  private ay<PosSelectVipDialog> bpi = new d(this);
  
  private boolean bpj;
  
  private boolean bpk;
  
  static  {
  
  }
  
  public PosActivityVipFragment(dl paramdl) { this.bfr = paramdl; }
  
  private void Mq() {
    this.bgv.b(this.bfr.bdM.b(new a(this)));
    this.bgv.b(this.bfr.bem.bez.b(new b(this)));
    this.bgv.b(this.bfr.bel.beI.b(new c(this)));
  }
  
  private void Na() {
    this.aqG = new g(this);
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("pos_activity_change_data_vip");
    intentFilter.addAction("pos_activity_change_data_vip_online");
    getActivity().registerReceiver(this.aqG, intentFilter);
  }
  
  private void Pe() {
    if (this.aqG != null) {
      getActivity().unregisterReceiver(this.aqG);
      this.aqG = null;
    } 
  }
  
  private void Pg() {
    aq aq;
    if ((aq = (aq)this.bfr.bdM.getValue()).a(aq)) {
      this.bph.bpo.aQx.setVisibility(0);
      return;
    } 
    this.bph.bpo.aQx.setVisibility(8);
    this.bph.bpn.bhW.setText(by.G(aq.aTp, 999));
    this.bph.bpn.bhY.setText(n.b(null, Double.valueOf(aq.aWo), true, true));
    this.bph.bpn.bia.setText(n.b(null, Long.valueOf(aq.aWp), false, true));
  }
  
  @Deprecated
  private void Ph() {
    aq aq = (aq)this.bfr.bdM.getValue();
    PosSelectVipDialog posSelectVipDialog = Pj();
    if (aq != null) {
      posSelectVipDialog.fT(aq.aWn);
    } else {
      posSelectVipDialog.fT("");
    } 
    posSelectVipDialog.show();
  }
  
  @Deprecated
  private void Pi() {
    aq aq = (aq)this.bfr.bdM.getValue();
    if (aq != null) {
      Cursor cursor;
      if (!CrashApplication.getLaiqianPreferenceManager().Wq()) {
        l l = new l(getActivity());
        cursor = l.bk(aq.aSW);
        if (cursor.moveToFirst()) {
          aq aq1 = bl.b(cursor);
          this.bfr.c(aq1);
        } else {
          this.bfr.c(aq.aWG);
        } 
        cursor.close();
        l.close();
        return;
      } 
      this.bfr.c(cursor);
    } 
  }
  
  private PosSelectVipDialog Pj() {
    r r;
    if (CrashApplication.getLaiqianPreferenceManager().Wq()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(CrashApplication.getLaiqianPreferenceManager().Wq());
      stringBuilder.append("");
      Log.e("getBusinessMode", stringBuilder.toString());
      r = new y((ActivityRoot)getActivity());
    } else {
      null = new StringBuilder();
      null.append(CrashApplication.getLaiqianPreferenceManager().Wq());
      null.append("");
      Log.e("getBusinessMode", null.toString());
      r = new r((ActivityRoot)getActivity());
    } 
    r.a(new h(this));
    return r;
  }
  
  private g aA(long paramLong) {
    at at = new at(getActivity());
    g g = at.bH(paramLong);
    at.close();
    return g;
  }
  
  private void setupViews() {
    this.bph.aQo.setOnClickListener(new e(this));
    this.bph.bhR.setOnClickListener(new f(this));
    this.bpi.set(Pj());
  }
  
  private void wK() { this.bgv.wK(); }
  
  public void onAttach(Context paramContext) {
    super.onAttach(paramContext);
    this.bph = new a(getActivity().findViewById(2131299994));
    setupViews();
  }
  
  public void onCreate(@Nullable Bundle paramBundle) {
    super.onCreate(paramBundle);
    Na();
    Mq();
  }
  
  public void onDestroy() {
    super.onDestroy();
    wK();
    Pe();
  }
  
  public void onStart() {
    super.onStart();
    if (((Boolean)this.bfr.bef.getValue()).booleanValue() || this.bpk) {
      this.bpk = false;
      this.bfr.c(aq.aWG);
    } 
    if (((Boolean)this.bfr.bef.getValue()).booleanValue() || this.bpj) {
      this.bpj = false;
      Pi();
    } 
  }
  
  static final class a {
    RelativeLayout aQo;
    
    ImageView bhR;
    
    View bhS;
    
    a bpn;
    
    b bpo;
    
    a(View param1View) {
      this.aQo = (RelativeLayout)param1View;
      this.bhR = (ImageView)param1View.findViewById(2131299990);
      this.bhS = param1View.findViewById(2131299995);
      this.bpn = new a(param1View.findViewById(2131299991));
      this.bpo = new b(param1View.findViewById(2131300001));
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
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\vip\PosActivityVipFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */