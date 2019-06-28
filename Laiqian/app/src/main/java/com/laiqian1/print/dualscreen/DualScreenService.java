package com.laiqian.print.dualscreen;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaRouter;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.Display;
import com.laiqian.util.r;
import hugo.weaving.DebugLog;

public class DualScreenService extends Service {
  o aZm = null;
  
  private final IBinder cFj = new a(this);
  
  @TargetApi(17)
  @Nullable
  private static Display bb(Context paramContext) {
    if (Build.VERSION.SDK_INT >= 17) {
      MediaRouter.RouteInfo routeInfo = ((MediaRouter)r.E(paramContext, "media_router")).getSelectedRoute(2);
      if (routeInfo != null) {
        Display display = routeInfo.getPresentationDisplay();
        if (display != null)
          return display; 
      } 
    } 
    return null;
  }
  
  public static boolean bc(Context paramContext) { return (bb(paramContext) != null); }
  
  public void afC() {
    if (this.aZm != null && this.aZm.isShowing())
      return; 
    Display display = bb(this);
    if (display != null && display.isValid()) {
      this.aZm = new o(this, display);
      this.aZm.getWindow().setType(2003);
      this.aZm.show();
    } 
  }
  
  public o afD() { return this.aZm; }
  
  @Nullable
  public IBinder onBind(Intent paramIntent) { return this.cFj; }
  
  @DebugLog
  public void onDestroy() {
    if (this.aZm != null)
      this.aZm.dismiss(); 
    super.onDestroy();
  }
  
  @DebugLog
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
    afC();
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  class DualScreenService {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\print\dualscreen\DualScreenService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */