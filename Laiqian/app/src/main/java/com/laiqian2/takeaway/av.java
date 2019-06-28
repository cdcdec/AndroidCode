package com.laiqian.takeaway;

import com.google.a.a.a.a.a.a;
import com.laiqian.entity.TakeOrderEntity;
import com.laiqian.entity.z;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.util.by;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

class av implements am.a {
  av(ar paramar) {}
  
  public void a(TakeOrderEntity paramTakeOrderEntity, int paramInt, ArrayList<z> paramArrayList, boolean paramBoolean, String paramString, v paramv, double paramDouble, long paramLong) {
    try {
      Constructor constructor = Class.forName("com.laiqian.main.PhoneOrders").getConstructor(new Class[] { android.content.Context.class, TakeOrderEntity.class, int.class, ArrayList.class, boolean.class, String.class, v.class });
      try {
        Object object2 = constructor.newInstance(new Object[] { aq.a(this.dtK.dtJ), paramTakeOrderEntity, Integer.valueOf(paramInt), paramArrayList, Boolean.valueOf(paramBoolean), paramString, paramv });
        Class clazz = object2.getClass();
        object2 = clazz.getMethod("setTotalAmount", new Class[] { double.class }).invoke(object2, new Object[] { Double.valueOf(paramTakeOrderEntity.Iv()) });
        Object object1 = clazz.getMethod("setTableID", new Class[] { long.class }).invoke(object2, new Object[] { Long.valueOf(by.parseLong(paramTakeOrderEntity.getSerialNumber())) });
        clazz.getMethod("startOrderAsyncTask", new Class[0]).invoke(object1, new Object[0]);
        return;
      } catch (Exception paramTakeOrderEntity) {}
    } catch (Exception paramTakeOrderEntity) {}
    a.e(paramTakeOrderEntity);
  }
  
  public void a(PendingFullOrderDetail paramPendingFullOrderDetail, int paramInt, ArrayList<z> paramArrayList, v paramv, double paramDouble) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */