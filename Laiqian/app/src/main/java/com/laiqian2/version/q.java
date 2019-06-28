package com.laiqian.version;

import android.app.DownloadManager;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import com.laiqian.basic.RootApplication;
import com.laiqian.infrastructure.R;
import com.laiqian.util.bd;
import com.laiqian.util.ch;
import com.laiqian.util.n;
import java.io.File;

class q implements View.OnClickListener {
  q(o.a parama) {}
  
  public void onClick(View paramView) {
    if (!bd.bH(this.dIw.dIv.mActivity)) {
      n.eP(R.string.pos_upgrade_network_err);
      return;
    } 
    o.a(this.dIw.dIv).dismiss();
    DownloadManager downloadManager = (DownloadManager)this.dIw.dIv.mActivity.getSystemService("download");
    Cursor cursor = downloadManager.query((new DownloadManager.Query()).setFilterByStatus(3));
    while (cursor.moveToNext()) {
      if (cursor.getString(cursor.getColumnIndex("uri")).equals(o.a.a(this.dIw))) {
        n.eP(R.string.pos_upgrade_network_exists);
        return;
      } 
    } 
    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(o.a.a(this.dIw)));
    request.setNotificationVisibility(1);
    File file = new File(ch.awE());
    if (file.exists())
      file.delete(); 
    request.setDestinationUri(Uri.fromFile(file));
    downloadManager.enqueue(request);
    RootApplication.getLaiqianPreferenceManager().rm(o.a.b(this.dIw));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */