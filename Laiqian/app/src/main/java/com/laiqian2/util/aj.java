package com.laiqian.util;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

final class aj implements FileFilter {
  public boolean accept(File paramFile) { return Pattern.matches("cpu[0-9]+", paramFile.getName()); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */