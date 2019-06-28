package com.laiqian.opentable.pos;

import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.ui.a.aq;
import com.laiqian.ui.a.ax;

class au extends Object implements aq.a<CharSequence> {
  au(PosActivityTableAdapter paramPosActivityTableAdapter) {}
  
  public void a(aq paramaq, int paramInt, CharSequence paramCharSequence) {
    TableEntity tableEntity = (TableEntity)((ax)paramaq).getObject();
    if (PosActivityTableAdapter.a(this.ccg) != null) {
      if (tableEntity == null)
        return; 
      if (tableEntity.getState() == 0)
        return; 
      if (paramCharSequence.equals(this.ccg.cce)) {
        PosActivityTableAdapter.g(this.ccg).e(tableEntity);
        return;
      } 
      if (tableEntity.Yh().size() > 1) {
        this.ccg.a(paramCharSequence, tableEntity);
        return;
      } 
      if (paramCharSequence.equals(this.ccg.ccc)) {
        PosActivityTableAdapter.g(this.ccg).d(tableEntity);
        return;
      } 
      if (paramCharSequence.equals(this.ccg.ccd)) {
        PosActivityTableAdapter.a(this.ccg, tableEntity, -1);
        return;
      } 
      if (paramCharSequence.equals(this.ccg.ccf))
        PosActivityTableAdapter.g(this.ccg).d(tableEntity, -1); 
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\pos\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */