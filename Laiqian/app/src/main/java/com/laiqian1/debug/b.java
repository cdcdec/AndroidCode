package com.laiqian.debug;

import android.view.View;
import android.widget.AdapterView;
import java.io.File;

class b implements AdapterView.OnItemClickListener {
  b(BackupFileDebugFragment paramBackupFileDebugFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    if (paramInt >= 0 && paramInt < BackupFileDebugFragment.a(this.aQv).size())
      BackupFileDebugFragment.a(this.aQv, (File)BackupFileDebugFragment.a(this.aQv).get(paramInt)); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\debug\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */