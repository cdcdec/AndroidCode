package com.laiqian.news;

import android.view.View;
import com.laiqian.entity.z;
import com.laiqian.main.PhoneOrders;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.util.n;
import java.util.ArrayList;

class j implements View.OnClickListener {
  j(NewsActivity paramNewsActivity) {}
  
  public void onClick(View paramView) {
    NewsActivity.c(this.bWC).setEnabled(false);
    PendingFullOrderDetail pendingFullOrderDetail = NewsActivity.g(this.bWC).WU();
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
    (new PhoneOrders(this.bWC, pendingFullOrderDetail, 2, arrayList, new k(this, pendingFullOrderDetail))).setTableID(n.parseLong(pendingFullOrderDetail.bXb.coJ)).setActualPerson(pendingFullOrderDetail.bXb.bZM).setTotalAmount(pendingFullOrderDetail.bXb.cpc.doubleValue()).setOrderDateTime(pendingFullOrderDetail.bXb.coE.getTime()).startOrderAsyncTask();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\news\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */