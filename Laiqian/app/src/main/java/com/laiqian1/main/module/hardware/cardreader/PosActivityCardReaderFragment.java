package com.laiqian.main.module.hardware.cardreader;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.LinearLayout;
import com.google.a.a.a.a.a.a;
import com.laiqian.entity.aq;
import com.laiqian.main.dl;
import com.laiqian.member.bz;
import com.laiqian.models.l;
import com.laiqian.pos.bl;
import com.laiqian.print.cardreader.ah;
import com.laiqian.print.cardreader.am;
import com.laiqian.print.cardreader.s;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.Iterator;

public class PosActivityCardReaderFragment extends Fragment {
  @Deprecated
  private bz aDP;
  
  a bfq;
  
  dl bfr;
  
  BroadcastReceiver bfs = new a(this);
  
  public PosActivityCardReaderFragment(dl paramdl) { this.bfr = paramdl; }
  
  @Deprecated
  private void Mn() {
    byte b1;
    ArrayList arrayList = am.ba(getActivity()).afs();
    boolean bool = arrayList.isEmpty();
    View view = this.bfq.bfu.bfv;
    byte b2 = 0;
    if (bool ^ true) {
      s s = s.aZ(getActivity());
      view.setVisibility(0);
      Iterator iterator = arrayList.iterator();
      b1 = 1;
      while (iterator.hasNext()) {
        ah ah = (ah)iterator.next();
        if (!s.d(ah.afr())) {
          s.e(ah.afr());
          b1 = 0;
        } 
      } 
      if (b1) {
        view.setActivated(true);
        b1 = 1;
      } else {
        view.setActivated(false);
        b1 = b2;
      } 
    } else {
      view.setVisibility(8);
      b1 = b2;
    } 
    if (this.aDP == null)
      this.aDP = bz.Qw(); 
    this.aDP.a(getActivity(), 3000L, null);
    if (b1 != 0 && bz.aE(getActivity())) {
      this.aDP.Qx();
      return;
    } 
    this.aDP.stop();
  }
  
  @Deprecated
  private void Mo() {
    if (this.aDP != null)
      this.aDP.stop(); 
    try {
      getActivity().unregisterReceiver(this.bfs);
      return;
    } catch (Exception exception) {
      a.e(exception);
      return;
    } 
  }
  
  private void eY(String paramString) {
    null = new StringBuilder();
    null.append("读取到的卡号是：");
    null.append(paramString);
    n.println(null.toString());
    aq aq = (aq)this.bfr.bdM.getValue();
    if (!paramString.isEmpty()) {
      if (aq != null && paramString.equals(aq.aWn))
        return; 
      l l = new l(getActivity());
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("%");
      stringBuilder.append(paramString);
      stringBuilder.append("%");
      paramString = stringBuilder.toString();
      l.getClass();
      Cursor cursor = l.d(paramString, 2, 1);
      if (cursor.getCount() == 1) {
        cursor.moveToNext();
        if (cursor.getInt(cursor.getColumnIndex("nSpareField1")) == 380003) {
          n.eP(2131627002);
          cursor.close();
          l.close();
          return;
        } 
        StringBuilder stringBuilder1 = bl.b(cursor);
        long l1 = Long.parseLong(n.B(stringBuilder1.aWq, false));
        if (!aq.j(System.currentTimeMillis(), l1)) {
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append(getContext().getString(2131630376));
          stringBuilder1.append(getContext().getString(2131625730));
          n.o(stringBuilder1.toString());
          cursor.close();
          l.close();
          return;
        } 
        cursor.close();
        l.close();
        this.bfr.bdM.accept(stringBuilder1);
        return;
      } 
      cursor.close();
      l.close();
      this.bfr.bdV.accept(Boolean.TRUE);
      return;
    } 
  }
  
  public void onAttach(Activity paramActivity) {
    super.onAttach(paramActivity);
    this.bfq = new a(paramActivity);
  }
  
  public void onDetach() {
    super.onDetach();
    Mo();
  }
  
  public void onStart() {
    super.onStart();
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
    intentFilter.addAction("com.laiqian.print.ACTION_USB_DEVICE_ATTACHED");
    intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
    intentFilter.addAction("action_usb_card_read_once");
    intentFilter.addAction("com.laiqian.USB_PERMISSION");
    intentFilter.addAction("pos_activity_change_data_cardreader");
    getActivity().registerReceiver(this.bfs, intentFilter);
    Mn();
  }
  
  static class a {
    a bfu;
    
    public a(Activity param1Activity) { this.bfu = new a(param1Activity.findViewById(2131300001)); }
    
    static final class a {
      LinearLayout aQx;
      
      View bfv;
      
      a(View param2View) {
        this.aQx = (LinearLayout)param2View;
        this.bfv = param2View.findViewById(2131299989);
      }
    }
  }
  
  static final class a {
    LinearLayout aQx;
    
    View bfv;
    
    a(View param1View) {
      this.aQx = (LinearLayout)param1View;
      this.bfv = param1View.findViewById(2131299989);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\hardware\cardreader\PosActivityCardReaderFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */