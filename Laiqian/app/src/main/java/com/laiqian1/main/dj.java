package com.laiqian.main;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.member.setting.bc;
import com.laiqian.online.h;
import com.laiqian.ui.a.r;
import com.laiqian.util.bd;
import com.laiqian.util.n;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;

class dj extends Handler {
  dj(di paramdi) {}
  
  private String a(@NonNull h paramh) {
    switch (paramh.bUj) {
      default:
        return paramh.message;
      case -1:
        return di.a(this.bdF).getString(2131625985);
      case -2:
        return di.a(this.bdF).getString(2131625987);
      case -3:
        return di.a(this.bdF).getString(2131625982);
      case -4:
        return di.a(this.bdF).getString(2131625986);
      case -5:
        return di.a(this.bdF).getString(2131625984);
      case -6:
        return di.a(this.bdF).getString(2131625981);
      case -7:
        return di.a(this.bdF).getString(2131625988);
      case -8:
        break;
    } 
    return di.a(this.bdF).getString(2131625983);
  }
  
  public void handleMessage(Message paramMessage) {
    di.a a;
    bb bb2;
    double d;
    bb bb1;
    super.handleMessage(paramMessage);
    int i = paramMessage.what;
    boolean bool = false;
    switch (i) {
      default:
        return;
      case 7:
        Toast.makeText(RootApplication.zv(), RootApplication.zv().getResources().getText(2131629623), 1).show();
        di.b(this.bdF).KK();
        return;
      case 6:
        di.b(this.bdF).KM();
        return;
      case 5:
        if (di.c(this.bdF) == null) {
          di.a(this.bdF, new r(di.a(this.bdF), new dk(this)));
          di.c(this.bdF).setCancelable(false);
          di.c(this.bdF).setTitle(di.a(this.bdF).getString(2131626349));
          di.c(this.bdF).s(di.a(this.bdF).getString(2131626350));
          str = paramMessage.getData();
          if (str != null) {
            str = str.getString("respond");
            if (str != null)
              try {
                h h = h.iO(str);
                di.c(this.bdF).s(a(h));
              } catch (JSONException str) {
                a.e(str);
              }  
          } 
          di.c(this.bdF).oZ(di.a(this.bdF).getString(2131626347));
          di.c(this.bdF).t(di.a(this.bdF).getString(2131626351));
        } 
        di.c(this.bdF).show();
        return;
      case 4:
        null = new StringBuilder();
        null.append(str.obj);
        null.append("");
        n.o(null.toString());
        di.b(this.bdF).KK();
        return;
      case 3:
        bb2 = (bb)str.obj;
        this.bdF.k(bb2);
        if (bb2.bbQ != null) {
          Matcher matcher = Pattern.compile("\\d+").matcher(bb2.bbQ);
          if (matcher.find()) {
            long l = Long.parseLong(matcher.group());
            if (bb2.isSaleOrder && bb2.bcf != 15L)
              RootApplication.zv().getLaiqianPreferenceManager().dy(l); 
          } else {
            String str = di.class.getSimpleName();
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("table number not found: ");
            stringBuilder1.append(bb2.bbQ);
            Log.e(str, stringBuilder1.toString());
          } 
        } 
        a = di.b(this.bdF);
        if (str.arg1 == 1)
          bool = true; 
        a.a(bb2, bool);
        return;
      case 2:
        bb1 = (bb)str.obj;
        bc.RH().fY("isOpenSMSNotice");
        bc.RH().fY("isMemberConsumeNoticed");
        d = bb1.bce;
        if (bc.RH().fY("isOpenSMSNotice") && bc.RH().fY("isMemberConsumeNoticed") && bb1.bce != 0.0D) {
          if (!bd.bH(di.a(this.bdF))) {
            n.eP(2131626280);
            return;
          } 
          if (bb1.vipEntity != null) {
            (new PosActivitySettlementModel.SendSmsTask(di.a(this.bdF), bb1)).forceLoad();
            return;
          } 
        } 
        return;
      case 1:
        break;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bb1.obj);
    stringBuilder.append("");
    (new a(this, stringBuilder.toString())).start();
  }
  
  class a extends Thread {
    private String orderNo;
    
    a(dj this$0, String param1String) { this.orderNo = param1String; }
    
    public void run() {
      super.run();
      PosActivitySettlementModel.eQ(this.orderNo);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\dj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */