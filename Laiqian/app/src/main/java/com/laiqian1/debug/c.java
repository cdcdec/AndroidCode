package com.laiqian.debug;

import java.io.File;
import java.io.FileFilter;

class c implements FileFilter {
  c(BackupFileDebugFragment paramBackupFileDebugFragment) {}
  
  public boolean accept(File paramFile) { return paramFile.getName().endsWith("lq205"); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\debug\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */