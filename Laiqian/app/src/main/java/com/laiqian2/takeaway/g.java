package com.laiqian.takeaway;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.util.ArrayList;

class g extends Handler {
  g(AbstractPosMainTakeOut paramAbstractPosMainTakeOut) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    switch (paramMessage.what) {
      default:
        return;
      case 8:
        AbstractPosMainTakeOut.w(this.drG).notifyDataSetChanged();
        AbstractPosMainTakeOut.h(this.drG).setRefreshing(false);
        return;
      case 7:
        AbstractPosMainTakeOut.w(this.drG).aaQ();
        AbstractPosMainTakeOut.w(this.drG).notifyDataSetChanged();
        AbstractPosMainTakeOut.y(this.drG);
        AbstractPosMainTakeOut.h(this.drG).setRefreshing(false);
        return;
      case 6:
        AbstractPosMainTakeOut.g(this.drG).setOnScrollListener(AbstractPosMainTakeOut.v(this.drG));
        AbstractPosMainTakeOut.g(this.drG).removeFooterView(AbstractPosMainTakeOut.x(this.drG));
        AbstractPosMainTakeOut.a(this.drG, false);
        Toast.makeText(this.drG, R.string.pos_no_more, 0).show();
        return;
      case 4:
        AbstractPosMainTakeOut.g(this.drG).setOnScrollListener(AbstractPosMainTakeOut.v(this.drG));
        AbstractPosMainTakeOut.w(this.drG).notifyDataSetChanged();
        AbstractPosMainTakeOut.b(this.drG, (ArrayList)paramMessage.obj);
        AbstractPosMainTakeOut.g(this.drG).removeFooterView(AbstractPosMainTakeOut.x(this.drG));
        AbstractPosMainTakeOut.a(this.drG, false);
        return;
      case 1:
        AbstractPosMainTakeOut.c(this.drG, paramMessage.arg1);
        return;
      case 0:
        break;
    } 
    AbstractPosMainTakeOut.b(this.drG, paramMessage.arg1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */