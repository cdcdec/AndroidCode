package com.laiqian.pos;

import android.content.Context;
import android.widget.Toast;
import com.laiqian.infrastructure.R;

public class aa extends e {
  public aa(Context paramContext) {
    super(paramContext, 3, R.layout.dialog_download_vip_data);
    cm(0L);
    cl(System.currentTimeMillis());
  }
  
  public void Zs() { Toast.makeText(getContext(), getContext().getString(R.string.pos_vip_info_data_success), 1).show(); }
  
  public void gI(int paramInt) { Toast.makeText(getContext(), getContext().getString(R.string.pos_report_export_mail_no_network), 1).show(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */