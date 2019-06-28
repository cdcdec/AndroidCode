package com.laiqian.takeaway;

import android.view.View;
import android.widget.AdapterView;
import java.io.PrintStream;

class b implements AdapterView.OnItemClickListener {
  b(AbstractPosMainTakeOut paramAbstractPosMainTakeOut) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    AbstractPosMainTakeOut.p(this.drG).dismiss();
    AbstractPosMainTakeOut.b(this.drG, AbstractPosMainTakeOut.q(this.drG)[paramInt]);
    PrintStream printStream = System.out;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("AbstractPosMainTakeOut. 订单来源点击,type is: ");
    stringBuilder.append(AbstractPosMainTakeOut.r(this.drG));
    printStream.println(stringBuilder.toString());
    AbstractPosMainTakeOut.o(this.drG).setText(AbstractPosMainTakeOut.s(this.drG)[paramInt]);
    AbstractPosMainTakeOut.a(this.drG, new int[0]);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */