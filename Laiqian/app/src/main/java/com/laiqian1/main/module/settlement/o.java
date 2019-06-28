package com.laiqian.main.module.settlement;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.laiqian.main.b.c;

class o implements DialogInterface.OnKeyListener {
  o(PosActivitySettlementDialogFragment paramPosActivitySettlementDialogFragment) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getAction() == 0)
      return true; 
    if (paramKeyEvent.getAction() == 1) {
      if (paramKeyEvent.getKeyCode() == 4) {
        if (((Boolean)(PosActivitySettlementDialogFragment.b(this.blV)).bmJ.getValue()).booleanValue())
          return true; 
        (PosActivitySettlementDialogFragment.b(this.blV)).bnf.accept(Boolean.valueOf(true));
        return false;
      } 
      if (paramKeyEvent.getKeyCode() == 137) {
        c c = (c)(PosActivitySettlementDialogFragment.b(this.blV)).bmT.bnw.get(Integer.valueOf(10007));
        (PosActivitySettlementDialogFragment.b(this.blV)).bmT.bnn.accept(c);
        return true;
      } 
      if (paramKeyEvent.getKeyCode() == 138) {
        c c = (c)(PosActivitySettlementDialogFragment.b(this.blV)).bmT.bnw.get(Integer.valueOf(10009));
        (PosActivitySettlementDialogFragment.b(this.blV)).bmT.bnn.accept(c);
        return true;
      } 
      PosActivitySettlementDialogFragment.a(this.blV).dispatchKeyEvent(paramKeyEvent);
    } 
    return false;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */