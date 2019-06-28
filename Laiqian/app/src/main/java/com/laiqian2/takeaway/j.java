package com.laiqian.takeaway;

import android.text.TextUtils;
import android.util.Log;
import com.laiqian.entity.TakeOrderEntity;
import com.laiqian.models.m;
import com.laiqian.util.bg;

class j implements al.a {
  j(AbstractPosMainTakeOut paramAbstractPosMainTakeOut, TakeOrderEntity paramTakeOrderEntity, String paramString) {}
  
  public void jI(String paramString) {
    StringBuilder stringBuilder;
    if (TextUtils.isEmpty(paramString)) {
      if (AbstractPosMainTakeOut.D(this.drG) != null)
        AbstractPosMainTakeOut.D(this.drG).dismiss(); 
      AbstractPosMainTakeOut.w(this.drG).ha(false);
      stringBuilder = new StringBuilder();
      stringBuilder.append("getTakeOutOrder .................");
      stringBuilder.append(this.drM.Io());
      Log.i("onClick", stringBuilder.toString());
      return;
    } 
    if (AbstractPosMainTakeOut.j(this.drG).oK(stringBuilder)) {
      if (AbstractPosMainTakeOut.j(this.drG).oM(this.drL)) {
        if (bg.equals(this.drM.getType(), "meituan") || bg.equals(this.drM.getType(), "eleme")) {
          this.drM.billNumber = "";
        } else {
          this.drM.billNumber = m.II();
        } 
        stringBuilder = new StringBuilder();
        stringBuilder.append("getTakeOutOrder success.................");
        stringBuilder.append(this.drM.Io());
        Log.i("onClick", stringBuilder.toString());
        AbstractPosMainTakeOut.j(this.drG).i(this.drM);
        AbstractPosMainTakeOut.j(this.drG).a(this.drM, true, this.drG.drF);
      } else if (AbstractPosMainTakeOut.j(this.drG).oL(this.drL)) {
        AbstractPosMainTakeOut.j(this.drG).a(this.drM, false, this.drG.drF);
      } 
    } else {
      AbstractPosMainTakeOut.j(this.drG).oN(stringBuilder);
      Log.i("onClick", "getTakeOutOrder fail ...........");
    } 
    AbstractPosMainTakeOut.a(this.drG, new int[] { -1 });
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */