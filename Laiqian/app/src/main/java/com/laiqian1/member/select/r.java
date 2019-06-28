package com.laiqian.member.select;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.d.a;
import com.laiqian.entity.aq;
import com.laiqian.member.setting.bc;
import com.laiqian.models.l;
import com.laiqian.pos.bl;
import com.laiqian.ui.listview.e;
import com.laiqian.util.n;
import com.laiqian.vip.R;
import io.reactivex.android.b.a;
import io.reactivex.g.a;
import io.reactivex.h;
import io.reactivex.i;
import java.util.Map;

public class r extends PosSelectVipDialog {
  private e adapter;
  
  public r(Context paramContext) { super(paramContext); }
  
  protected void Rj() {
    byte b;
    stringBuilder = new StringBuilder();
    stringBuilder.append(a.AZ().Bw());
    stringBuilder.append("");
    Log.e("isMemberOnlyReadCard", stringBuilder.toString());
    l l = new l(this.mContext);
    try {
      String str1 = this.bvf.Qy();
      if (a.AZ().Bw()) {
        b = 4;
      } else {
        byte b1;
        b = 2;
      } 
      str1 = l.b(str1, b, this.bvf.Qz());
    } catch (Exception stringBuilder) {
      a.e(stringBuilder);
      stringBuilder = null;
    } 
    String str = this.bvf.Qy();
    if (a.AZ().Bw()) {
      b = 4;
    } else {
      b = 2;
    } 
    String[] arrayOfString = l.h(str, b);
    this.bAq.initData();
    if (this.adapter == null) {
      this.adapter = new v(this, this.mContext, this.bAq.getList(), this.bAq);
    } else {
      this.adapter.m(this.bAq.getList());
    } 
    this.bAq.setPageSize(5);
    this.bAq.setAdapter(this.adapter);
    this.bAq.setData(this.mContext, stringBuilder, arrayOfString, new String[] { 
          "sNumber", "sContactMobilePhone", "fAmount", "sName", "fPoints", "nSpareField1", "sBPartnerTypeName", "nUpdateFlag", "sSpareField3", "sField1", 
          "nBPartnerType", "fSpareField3" });
    l.close();
  }
  
  protected void fE(int paramInt) {
    Long long = Long.valueOf((String)((Map)this.bAq.getList().get(paramInt - this.bAq.getHeaderViewsCount())).get("_id"));
    Context context = new l(this.mContext);
    StringBuilder stringBuilder = context.bk(long.longValue());
    if (Integer.valueOf((String)((Map)this.bAq.getList().get(paramInt - this.bAq.getHeaderViewsCount())).get("nSpareField1")).intValue() == 380003) {
      Toast.makeText(this.mContext, this.mContext.getString(R.string.pos_member_card_lock), 0).show();
      return;
    } 
    long l = Long.parseLong(n.B((String)((Map)this.bAq.getList().get(paramInt - this.bAq.getHeaderViewsCount())).get("fSpareField3"), false));
    if (!aq.j(System.currentTimeMillis(), l)) {
      context = this.mContext;
      stringBuilder = new StringBuilder();
      stringBuilder.append(this.mContext.getString(R.string.vip));
      stringBuilder.append(this.mContext.getString(R.string.member_expired));
      Toast.makeText(context, stringBuilder.toString(), 0).show();
      return;
    } 
    this.cgf = bl.a(stringBuilder);
    aq aq = bl.b(stringBuilder);
    stringBuilder.close();
    context.close();
    h.a(new s(aq)).d(a.aKh()).c(a.aJo()).b(new t(this, aq));
  }
  
  protected void fF(int paramInt) {
    this.bAh = paramInt;
    switch (paramInt) {
      default:
        return;
      case 3:
        this.bAj.setVisibility(0);
        this.bAi.setVisibility(8);
        this.bAz.setVisibility(8);
        this.bAq.setVisibility(8);
        this.bAm.setVisibility(8);
        return;
      case 2:
        this.bAj.setVisibility(8);
        this.bAi.setVisibility(8);
        this.bAz.setVisibility(8);
        this.bAq.setVisibility(0);
        this.bAm.setVisibility(8);
        return;
      case 1:
        this.bAj.setVisibility(8);
        this.bAi.setVisibility(0);
        this.bAz.setVisibility(8);
        this.bAq.setVisibility(8);
        this.bAm.setVisibility(8);
        return;
      case 0:
        break;
    } 
    this.bAj.setVisibility(8);
    this.bAi.setVisibility(8);
    this.bAz.setVisibility(8);
    this.bAq.setVisibility(8);
    this.bAm.setVisibility(0);
  }
  
  protected void xU() {
    super.xU();
    this.bAq.setOnAfterLoadListener(new u(this));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\select\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */