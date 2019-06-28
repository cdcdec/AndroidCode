package com.laiqian.print.type;

import android.view.View;
import com.laiqian.print.bm;
import com.laiqian.ui.a.w;
import java.util.ArrayList;
import java.util.HashMap;

class ao implements View.OnClickListener {
  ao(PrinterEditActivity paramPrinterEditActivity) {}
  
  public void onClick(View paramView) {
    ArrayList arrayList = new ArrayList();
    for (byte b = 0; b < this.cKo.cKk.size(); b++)
      arrayList.add(PrinterEditActivity.a(this.cKo, (bm)this.cKo.cKk.get(b))); 
    HashMap hashMap = new HashMap();
    for (bm bm : this.cKo.cKk.awn())
      hashMap.put(PrinterEditActivity.a(this.cKo, bm), Integer.valueOf(1)); 
    w w = new w(this.cKo.getActivity(), (String[])arrayList.toArray(new String[0]), new ap(this), false, true, hashMap);
    w.setOnDismissListener(new aq(this));
    w.show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\type\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */