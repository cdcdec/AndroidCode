package com.laiqian.message;

import android.util.Log;
import com.alibaba.a.a.d.a.a;
import com.alibaba.a.a.d.b;
import com.alibaba.a.a.d.d.d;
import com.alibaba.a.a.d.d.e;
import com.alibaba.a.a.d.d.l;
import com.alibaba.a.a.d.d.m;
import com.alibaba.a.a.d.e;

class c extends Object implements a<d, e> {
  c(a parama, String paramString1, String paramString2) {}
  
  public void a(d paramd, b paramb, e parame) { Log.d("删除失败", "delete object failed. Need to save the messageID,and try again."); }
  
  public void a(d paramd, e parame) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("delete object Success. object key is: ");
    stringBuilder.append(paramd.pE());
    Log.d("删除成功", stringBuilder.toString());
    a.a(this.bIn, this.bIl, this.bIo);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\message\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */