package com.laiqian.util;

import com.laiqian.basic.RootApplication;
import com.laiqian.infrastructure.R;
import java.text.SimpleDateFormat;

final class y extends ThreadLocal<SimpleDateFormat> {
  protected SimpleDateFormat asM() { return new SimpleDateFormat(RootApplication.zv().getString(R.string.pos_simpledateformat_datetime_yyyyMMddhhmm)); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */