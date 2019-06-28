package com.laiqian.backup;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import com.laiqian.db.a;
import java.io.File;

class aj implements AdapterView.OnItemClickListener {
  aj(UpgradeFromFileList paramUpgradeFromFileList) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    a.Dh();
    String str = UpgradeFromFileList.zd()[paramInt];
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UpgradeFromFileList.a(this.aIK));
    stringBuilder.append("/");
    stringBuilder.append(str);
    Uri uri = Uri.fromFile(new File(stringBuilder.toString()));
    Intent intent = new Intent("android.intent.action.VIEW");
    intent.setDataAndType(uri, "application/vnd.android.package-archive");
    intent.addFlags(268435456);
    this.aIK.startActivity(intent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\backup\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */