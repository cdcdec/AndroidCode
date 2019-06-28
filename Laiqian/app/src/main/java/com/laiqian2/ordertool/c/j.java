package com.laiqian.ordertool.c;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import com.laiqian.dcb.api.a.b;
import com.laiqian.dcb.api.server.a.c;
import com.laiqian.opentable.c;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.entity.c;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.util.by;
import io.netty.channel.n;
import org.json.JSONException;

class j implements c.a {
  j(h paramh, n paramn, int paramInt, String paramString, Context paramContext) {}
  
  public void a(TableEntity paramTableEntity, PendingFullOrderDetail paramPendingFullOrderDetail) {
    try {
      paramTableEntity.c(new c(paramPendingFullOrderDetail.bXb.coM, paramPendingFullOrderDetail.bXb.orderNo, paramPendingFullOrderDetail.bXb.coE.getTime(), paramPendingFullOrderDetail.bXb.bZM, paramPendingFullOrderDetail.bXb.cpd, by.parseLong(paramPendingFullOrderDetail.bXb.coJ)));
      this.cep.a(context, b.a(paramTableEntity, paramPendingFullOrderDetail, null, "3"), null, this.cet, this.ceq);
      return;
    } catch (JSONException paramTableEntity) {
      a.e(paramTableEntity);
      return;
    } 
  }
  
  public void ew(boolean paramBoolean) {
    try {
      String str;
      byte b1;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("局域网处理提交订单的消息");
      if (paramBoolean) {
        str = "提交订单成功";
      } else {
        str = "提交订单失败";
      } 
      stringBuilder.append(str);
      b.au("主收银处理客户端完成订单数据", stringBuilder.toString());
      n n1 = this.ceq;
      int i = this.cer;
      if (paramBoolean) {
        b1 = -1;
      } else {
        b1 = -2;
      } 
      c.a(n1, i, b1, "", this.ces, "0");
      return;
    } catch (Exception exception) {
      a.e(exception);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\ordertool\c\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */