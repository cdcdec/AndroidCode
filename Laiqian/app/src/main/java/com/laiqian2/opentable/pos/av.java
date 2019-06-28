package com.laiqian.opentable.pos;

import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.entity.c;
import com.laiqian.ui.a.aq;
import java.util.ArrayList;

class av extends Object implements aq.a<CharSequence> {
  av(PosActivityTableAdapter paramPosActivityTableAdapter, CharSequence paramCharSequence1, CharSequence paramCharSequence2, TableEntity paramTableEntity, CharSequence paramCharSequence3, CharSequence paramCharSequence4) {}
  
  public void a(aq paramaq, int paramInt, CharSequence paramCharSequence) {
    if (this.cci.equals(this.ccj)) {
      this.bMz.c((c)this.bMz.Yh().get(paramInt));
      PosActivityTableAdapter.g(this.ccg).d(this.bMz);
      return;
    } 
    if (paramInt == 0) {
      paramInt = -1;
    } else {
      ArrayList arrayList = this.bMz.Yh();
      int i = paramInt - 1;
      paramInt = ((c)arrayList.get(i)).Yl();
      this.bMz.c((c)this.bMz.Yh().get(i));
    } 
    if (this.cci.equals(this.cck)) {
      PosActivityTableAdapter.a(this.ccg, this.bMz, paramInt);
      return;
    } 
    if (this.cci.equals(this.ccl))
      PosActivityTableAdapter.g(this.ccg).d(this.bMz, paramInt); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\pos\av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */