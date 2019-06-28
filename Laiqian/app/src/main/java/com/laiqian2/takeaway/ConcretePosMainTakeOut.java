package com.laiqian.takeaway;

import com.laiqian.entity.TakeOrderEntity;
import com.laiqian.entity.z;
import com.laiqian.main.PhoneOrders;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.util.by;
import java.util.ArrayList;

public class ConcretePosMainTakeOut extends AbstractPosMainTakeOut {
  protected int apX() { return 90004; }
  
  protected Class<?> apY() { return com.laiqian.pos.industry.setting.MainSetting.class; }
  
  protected void b(TakeOrderEntity paramTakeOrderEntity, int paramInt, ArrayList<z> paramArrayList, boolean paramBoolean, String paramString, v paramv, double paramDouble, long paramLong) { (new PhoneOrders(this, paramTakeOrderEntity, paramInt, paramArrayList, paramBoolean, paramString, paramv)).setTotalAmount(paramTakeOrderEntity.Iv()).setTableID(by.parseLong(paramTakeOrderEntity.getAddress())).startOrderAsyncTask(); }
  
  protected void b(PendingFullOrderDetail paramPendingFullOrderDetail, int paramInt, ArrayList<z> paramArrayList, v paramv, double paramDouble) { (new PhoneOrders(this, paramPendingFullOrderDetail, false, paramArrayList, paramv)).setTotalAmount(paramDouble).startOrderAsyncTask(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\ConcretePosMainTakeOut.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */