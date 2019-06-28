package com.laiqian.binding;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.laiqian.util.n;
import com.laiqian.wallet.R;
import kotlin.Metadata;
import kotlin.jvm.b.f;
import org.jetbrains.annotations.NotNull;

@Metadata
public final class h extends Handler {
  h(BindingWechatSelectActivity paramBindingWechatSelectActivity, Looper paramLooper) { super(paramLooper); }
  
  public void handleMessage(@NotNull Message paramMessage) {
    f.m(paramMessage, "msg");
    super.handleMessage(paramMessage);
    switch (paramMessage.what) {
      default:
        return;
      case 0:
        this.aJl.zM();
        n.eP(R.string.pos_wallet_show_network_not_smooth);
        BindingWechatSelectActivity.d(this.aJl);
        break;
      case 1:
        break;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\binding\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */