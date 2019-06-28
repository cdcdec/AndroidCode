package com.laiqian.takeaway;

import android.view.View;
import android.widget.AdapterView;
import com.laiqian.entity.ap;
import java.io.PrintStream;

class o implements AdapterView.OnItemClickListener {
  o(AbstractPosMainTakeOut paramAbstractPosMainTakeOut) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    String str;
    AbstractPosMainTakeOut.c(this.drG).dismiss();
    AbstractPosMainTakeOut.b(this.drG).setText((CharSequence)AbstractPosMainTakeOut.d(this.drG).get(paramInt));
    paramLong = ((ap)AbstractPosMainTakeOut.e(this.drG).get(paramInt)).getID();
    AbstractPosMainTakeOut abstractPosMainTakeOut = this.drG;
    if (paramLong > 0L) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramLong);
      stringBuilder1.append("");
      str = stringBuilder1.toString();
    } else {
      str = "";
    } 
    AbstractPosMainTakeOut.a(abstractPosMainTakeOut, String.valueOf(str));
    PrintStream printStream = System.out;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("selected deliveryManID is:");
    stringBuilder.append(AbstractPosMainTakeOut.f(this.drG));
    printStream.println(stringBuilder.toString());
    AbstractPosMainTakeOut.a(this.drG, new int[0]);
    AbstractPosMainTakeOut.g(this.drG).smoothScrollToPosition(0);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */