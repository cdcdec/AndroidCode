package com.laiqian.ui.listview;

import android.os.Handler;
import android.os.Message;

class d extends Handler {
  d(FormListView paramFormListView) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    if (paramMessage.what == -1 && FormListView.access$100(this.dBV) != null)
      FormListView.access$100(this.dBV).Rc(); 
    this.dBV.setResultSize(paramMessage.arg1);
    if (paramMessage.arg2 == 0) {
      this.dBV.notifyData();
      if (FormListView.access$200(this.dBV) != null) {
        FormListView.access$200(this.dBV).aX(paramMessage.arg1, paramMessage.arg2);
        return;
      } 
    } else if (paramMessage.arg2 > 0) {
      this.dBV.notifyData();
      if (FormListView.access$200(this.dBV) != null)
        FormListView.access$200(this.dBV).aX(paramMessage.arg1, paramMessage.arg2); 
      FormListView.access$302(this.dBV, false);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\listview\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */