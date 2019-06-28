package com.laiqian.member.select;

import android.content.Context;
import android.widget.Button;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.entity.aq;
import com.laiqian.entity.as;
import com.laiqian.member.c.a.a;
import com.laiqian.member.c.a.c;
import com.laiqian.member.c.a.g;
import com.laiqian.member.cb;
import com.laiqian.member.setting.bc;
import com.laiqian.models.l;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.ui.listview.e;
import com.laiqian.util.n;
import com.laiqian.vip.R;
import io.reactivex.android.b.a;
import io.reactivex.g.a;
import io.reactivex.h;
import io.reactivex.i;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class y extends PosSelectVipDialog implements c {
  private e adapter;
  
  private a bAR;
  
  public y(Context paramContext) {
    super(paramContext);
    this.bAR = new g(this, paramContext);
    if (RootApplication.getLaiqianPreferenceManager().avL() == 1) {
      this.bAn.setVisibility(8);
      findViewById(R.id.tv_charge_right_line).setVisibility(8);
    } 
  }
  
  protected void Rj() {
    dK(true);
    Exception exception2 = null;
    try {
      l l = new l(this.mContext);
      try {
        byte b;
        exception1 = this.bvf.Qy();
        if (a.AZ().Bw()) {
          b = 4;
        } else {
          b = 2;
        } 
        exception1 = l.b(exception1, b, this.bvf.Qz());
      } catch (Exception null) {}
    } catch (Exception exception1) {
      Object object = null;
    } 
    a.e(exception1);
    exception1 = exception2;
  }
  
  public void a(int paramInt1, int paramInt2, cb paramcb) { this.bAR.a(paramInt1, paramInt2, paramcb); }
  
  public void dK(boolean paramBoolean) {
    byte b1;
    ProgressBarCircularIndeterminate progressBarCircularIndeterminate = this.bAA;
    byte b2 = 8;
    if (paramBoolean) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    progressBarCircularIndeterminate.setVisibility(b1);
    Button button = this.bwy;
    if (paramBoolean) {
      b1 = b2;
    } else {
      b1 = 0;
    } 
    button.setVisibility(b1);
  }
  
  protected void fE(int paramInt) {
    Long.valueOf((String)((Map)this.bAq.getList().get(paramInt - this.bAq.getHeaderViewsCount())).get("_id"));
    if (Integer.valueOf((String)((Map)this.bAq.getList().get(paramInt - this.bAq.getHeaderViewsCount())).get("nSpareField1")).intValue() == 380003) {
      Toast.makeText(this.mContext, this.mContext.getString(R.string.pos_member_card_lock), 0).show();
      return;
    } 
    long l1 = System.currentTimeMillis();
    if (((Map)this.bAq.getList().get(paramInt - this.bAq.getHeaderViewsCount())).containsKey("fSpareField3"))
      l1 = Long.parseLong(n.B((String)((Map)this.bAq.getList().get(paramInt - this.bAq.getHeaderViewsCount())).get("fSpareField3"), false)); 
    long l2 = System.currentTimeMillis();
    if (((Map)this.bAq.getList().get(paramInt - this.bAq.getHeaderViewsCount())).containsKey("nowTime"))
      l2 = Long.parseLong((String)((Map)this.bAq.getList().get(paramInt - this.bAq.getHeaderViewsCount())).get("nowTime")); 
    if (!aq.j(l2, l1)) {
      Context context = this.mContext;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.mContext.getString(R.string.vip));
      stringBuilder.append(this.mContext.getString(R.string.member_expired));
      Toast.makeText(context, stringBuilder.toString(), 0).show();
      return;
    } 
    new HashMap();
    this.cgf.put("nBPartnerID", ((Map)this.bAq.getList().get(paramInt - this.bAq.getHeaderViewsCount())).get("_id"));
    this.cgf.put("sBPartnerContact", ((Map)this.bAq.getList().get(paramInt - this.bAq.getHeaderViewsCount())).get("sName"));
    this.cgf.put("sBPartnerMobile", ((Map)this.bAq.getList().get(paramInt - this.bAq.getHeaderViewsCount())).get("sContactMobilePhone"));
    this.cgf.put("fDiscount", ((Map)this.bAq.getList().get(paramInt - this.bAq.getHeaderViewsCount())).get("fDiscount"));
    this.cgf.put("fAmount", ((Map)this.bAq.getList().get(paramInt - this.bAq.getHeaderViewsCount())).get("fAmount"));
    this.cgf.put("sNumber", ((Map)this.bAq.getList().get(paramInt - this.bAq.getHeaderViewsCount())).get("sNumber"));
    this.cgf.put("fPoints", ((Map)this.bAq.getList().get(paramInt - this.bAq.getHeaderViewsCount())).get("fPoints"));
    this.cgf.put("nBPartnerType", ((Map)this.bAq.getList().get(paramInt - this.bAq.getHeaderViewsCount())).get("nBPartnerType"));
    this.cgf.put("passwordSetting", ((Map)this.bAq.getList().get(paramInt - this.bAq.getHeaderViewsCount())).get("sSpareField3"));
    this.cgf.put("nBelongShopID", ((Map)this.bAq.getList().get(paramInt - this.bAq.getHeaderViewsCount())).get("nBelongShopID"));
    this.cge.q(this.cgf);
    aq aq = new aq();
    aq.aSW = Long.parseLong((String)((Map)this.bAq.getList().get(paramInt - this.bAq.getHeaderViewsCount())).get("_id"));
    aq.name = (String)((Map)this.bAq.getList().get(paramInt - this.bAq.getHeaderViewsCount())).get("sName");
    aq.aTp = (String)((Map)this.bAq.getList().get(paramInt - this.bAq.getHeaderViewsCount())).get("sContactMobilePhone");
    aq.discount = Double.parseDouble((String)((Map)this.bAq.getList().get(paramInt - this.bAq.getHeaderViewsCount())).get("fDiscount"));
    aq.aWo = Double.parseDouble((String)((Map)this.bAq.getList().get(paramInt - this.bAq.getHeaderViewsCount())).get("fAmount"));
    aq.aWn = (String)((Map)this.bAq.getList().get(paramInt - this.bAq.getHeaderViewsCount())).get("sNumber");
    aq.aWp = n.parseInt((String)((Map)this.bAq.getList().get(paramInt - this.bAq.getHeaderViewsCount())).get("fPoints"));
    aq.aWw = n.parseLong((String)((Map)this.bAq.getList().get(paramInt - this.bAq.getHeaderViewsCount())).get("nBPartnerType"));
    aq.aWx = (String)((Map)this.bAq.getList().get(paramInt - this.bAq.getHeaderViewsCount())).get("sBPartnerTypeName");
    aq.aWH = new as((String)((Map)this.bAq.getList().get(paramInt - this.bAq.getHeaderViewsCount())).get("sSpareField3"));
    aq.aWC = n.parseInt((String)((Map)this.bAq.getList().get(paramInt - this.bAq.getHeaderViewsCount())).get("nBelongShopID"));
    aq.aJX = (String)((Map)this.bAq.getList().get(paramInt - this.bAq.getHeaderViewsCount())).get("sField1");
    h.a(new z(aq)).d(a.aKh()).c(a.aJo()).b(new aa(this, aq));
  }
  
  public void loadListDataAfter(List<Map<String, String>> paramList, int paramInt) { this.bAq.loadListDataAfter(paramList, paramInt); }
  
  protected void xU() {
    super.xU();
    this.bAq.setOnLoadListener(new ab(this));
    this.bAq.setOnAfterLoadListener(new ac(this));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\select\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */