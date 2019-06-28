package com.laiqian.print.type;

import android.content.DialogInterface;
import com.laiqian.print.bm;
import com.laiqian.print.usage.e;
import com.laiqian.print.usage.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class aq implements DialogInterface.OnDismissListener {
  aq(ao paramao) {}
  
  public void onDismiss(DialogInterface paramDialogInterface) {
    null = this.cKC.cKo.cKk.awn();
    ArrayList arrayList = new ArrayList(PrinterEditActivity.f(this.cKC.cKo).aey());
    Iterator iterator = arrayList.iterator();
    while (iterator.hasNext()) {
      if (!null.contains(((e)iterator.next()).ahZ()))
        iterator.remove(); 
    } 
    for (bm bm : null) {
      if (!PrinterEditActivity.f(this.cKC.cKo).b(bm))
        arrayList.add(g.h(bm)); 
    } 
    PrinterEditActivity.f(this.cKC.cKo).aez();
    PrinterEditActivity.f(this.cKC.cKo).n(arrayList);
    if (PrinterEditActivity.f(this.cKC.cKo).b(bm.cEg)) {
      PrinterEditActivity.f(this.cKC.cKo).aew().ii(2);
    } else {
      PrinterEditActivity.f(this.cKC.cKo).aew().ii(1);
    } 
    PrinterEditActivity.a(this.cKC.cKo, PrinterEditActivity.f(this.cKC.cKo).aex());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\type\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */