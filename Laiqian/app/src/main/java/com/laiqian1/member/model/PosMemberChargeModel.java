package com.laiqian.member.model;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.content.AsyncTaskLoader;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.aq;
import com.laiqian.models.j;
import com.laiqian.models.l;
import com.laiqian.online.OnlineSyncRequest;
import com.laiqian.online.f;
import com.laiqian.util.av;
import com.laiqian.util.logger.d;
import com.laiqian.util.logger.h;
import com.laiqian.vip.R;
import com.orhanobut.logger.d;
import java.util.ArrayList;

public class PosMemberChargeModel extends j {
  public PosMemberChargeModel(Context paramContext) { super(paramContext); }
  
  public boolean QL() {
    try {
      beginTransaction();
      if (!super.QL()) {
        endTransaction();
        return false;
      } 
      hP(this.mContext.getString(R.string.pos_charge_success));
      l l = new l(this.mContext);
      String str = hQ("nBPartnerID");
      long l2 = 0L;
      long l1 = l2;
      if (str != null) {
        l1 = l2;
        if (!str.equals(""))
          l1 = Long.parseLong(str); 
      } 
      l.am("fAmount", hQ("fNewAmount"));
      l.am("nSpareField3", hQ("nDateTime"));
      boolean bool = l.bl(l1);
      l.close();
      if (!bool) {
        endTransaction();
        return false;
      } 
      setTransactionSuccessful();
      endTransaction();
      return bool;
    } catch (Exception exception) {
      endTransaction();
      a.e(exception);
      return false;
    } 
  }
  
  public Cursor fI(String paramString) {
    try {
      exception = new l(this.mContext);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    Cursor cursor = exception.fI(paramString);
    exception.close();
    return cursor;
  }
  
  public boolean q(aq paramaq) {
    am("_id", paramaq.aWr);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramaq.aSW);
    stringBuilder.append("");
    am("nBPartnerID", stringBuilder.toString());
    am("sBPartnerNumber", paramaq.aWn);
    am("sBPartnerMobile", paramaq.aTp);
    am("sBPartnerName", paramaq.name);
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramaq.aWD);
    stringBuilder.append("");
    am("nChargeType", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramaq.aWo);
    stringBuilder.append("");
    am("fOldAmount", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramaq.aWA);
    stringBuilder.append("");
    am("fChargeAmount", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramaq.aWy);
    stringBuilder.append("");
    am("fNewAmount", stringBuilder.toString());
    am("nDateTime", paramaq.aWr);
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramaq.aWA);
    stringBuilder.append("");
    am("fReceived", stringBuilder.toString());
    return QL();
  }
  
  public boolean r(aq paramaq) {
    am("_id", paramaq.aWr);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramaq.aSW);
    stringBuilder.append("");
    am("nBPartnerID", stringBuilder.toString());
    am("sBPartnerNumber", paramaq.aWn);
    am("sBPartnerMobile", paramaq.aTp);
    am("sBPartnerName", paramaq.name);
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramaq.aWD);
    stringBuilder.append("");
    am("nChargeType", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramaq.aWo);
    stringBuilder.append("");
    am("fOldAmount", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramaq.aWA);
    stringBuilder.append("");
    am("fChargeAmount", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramaq.aWy);
    stringBuilder.append("");
    am("fNewAmount", stringBuilder.toString());
    am("nDateTime", paramaq.aWr);
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramaq.aWA);
    stringBuilder.append("");
    am("fReceived", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramaq.aWE);
    stringBuilder.append("");
    am("nSpareField1", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramaq.aWp);
    stringBuilder.append("");
    am("fSpareField3", stringBuilder.toString());
    return QL();
  }
  
  public static class OnlineCancelChargeSyncTask extends AsyncTaskLoader<Boolean> {
    private String bya;
    
    private String byb;
    
    public Boolean LN() {
      a = new OnlineSyncRequest.a();
      try {
        exception = new j(getContext());
      } catch (Exception exception) {
        a.e(exception);
        exception = null;
      } 
      a.a(exception.hd(this.bya), 2);
      a.a(exception.hd(this.byb), 1);
      exception.close();
      null = new av(getContext());
      a.iM(null.Ea());
      a.iN(null.atr());
      a.bV(Long.parseLong(null.Tx()));
      null.close();
      f f = f.bXQ;
      try {
        f.a(a.Xj());
        return Boolean.valueOf(true);
      } catch (Exception a) {
        j j;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("实时同步失败");
        stringBuilder.append(a.getMessage());
        d.b(stringBuilder.toString(), new Object[0]);
        a.e(a);
        try {
          j j1 = new j(getContext());
          j = j1;
        } catch (Exception a) {
          a.e(a);
        } 
        j.d(Long.valueOf(this.bya).longValue(), false);
        j.he(this.byb);
        j.close();
        return Boolean.valueOf(false);
      } 
    }
  }
  
  public static class OnlineSyncTask extends AsyncTaskLoader<Boolean> {
    private String btA;
    
    public boolean bxY;
    
    public OnlineSyncTask(Context param1Context, String param1String) {
      super(param1Context);
      this.btA = param1String;
    }
    
    public Boolean LN() {
      byte b;
      a = new OnlineSyncRequest.a();
      try {
        exception = new j(getContext());
      } catch (Exception exception) {
        a.e(exception);
        exception = null;
      } 
      null = exception.hd(this.btA);
      if (!RootApplication.getLaiqianPreferenceManager().Wq()) {
        b = 1;
      } else {
        b = 2;
      } 
      a.a(null, b);
      null = new av(getContext());
      a.iM(null.Ea());
      a.iN(null.atr());
      a.bV(Long.parseLong(null.Tx()));
      null.close();
      f f = f.bXQ;
      try {
        boolean bool = (f.b(a.Xj())).bXV;
        return Boolean.valueOf(true);
      } catch (Exception a) {
        h.awP().a(new d(PosMemberChargeModel.class.getSimpleName(), "onlineSync", "请求实时同步失败--", a.getMessage()), h.a.dHw, h.b.dHD);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("实时同步失败");
        stringBuilder.append(a.getMessage());
        d.b(stringBuilder.toString(), new Object[0]);
        a.e(a);
        if (this.bxY)
          exception.he(this.btA); 
        exception.close();
        return Boolean.valueOf(false);
      } 
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\model\PosMemberChargeModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */