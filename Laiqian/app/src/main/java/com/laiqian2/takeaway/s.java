package com.laiqian.takeaway;

import android.view.View;
import android.widget.AdapterView;
import java.io.PrintStream;

class s implements AdapterView.OnItemClickListener {
  s(AbstractPosMainTakeOut paramAbstractPosMainTakeOut) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    AbstractPosMainTakeOut.l(this.drG).dismiss();
    this.drG.drq = AbstractPosMainTakeOut.m(this.drG)[paramInt];
    PrintStream printStream = System.out;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("AbstractPosMainTakeOut. 订单列表选项点击后,sOrderStatus is: ");
    stringBuilder.append(this.drG.drq);
    printStream.println(stringBuilder.toString());
    AbstractPosMainTakeOut.k(this.drG).setText(AbstractPosMainTakeOut.n(this.drG)[paramInt]);
    AbstractPosMainTakeOut.a(this.drG, new int[0]);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */