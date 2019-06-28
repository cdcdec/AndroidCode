package com.laiqian.main.module.hardware.dualscreen;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.laiqian.print.dualscreen.DualScreenService;
import com.laiqian.util.av;

class o implements ServiceConnection {
  o(PosActivityDualscreenFragment paramPosActivityDualscreenFragment) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    PosActivityDualscreenFragment.a(this.bfC, ((DualScreenService.a)paramIBinder).afE());
    PosActivityDualscreenFragment.a(this.bfC, PosActivityDualscreenFragment.a(this.bfC).afD());
    PosActivityDualscreenFragment.a(this.bfC, this.bfC.a(PosActivityDualscreenFragment.b(this.bfC)));
    av av = new av(this.bfC.getActivity());
    String str = av.Tx();
    av.close();
    PosActivityDualscreenFragment.b(this.bfC).afP().afS();
    PosActivityDualscreenFragment.b(this.bfC).afP().lj(str);
    PosActivityDualscreenFragment.b(this.bfC).afN();
    PosActivityDualscreenFragment.b(this.bfC).afO();
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {
    PosActivityDualscreenFragment.c(this.bfC).wK();
    PosActivityDualscreenFragment.a(this.bfC, null);
    PosActivityDualscreenFragment.a(this.bfC, null);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\hardware\dualscreen\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */