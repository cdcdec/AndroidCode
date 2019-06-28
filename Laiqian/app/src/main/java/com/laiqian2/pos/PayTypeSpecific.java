package com.laiqian.pos;

import com.laiqian.infrastructure.R;

public class PayTypeSpecific {
  public static int cn(long paramLong) { return (paramLong == 5L || paramLong == 7L || paramLong == 8L) ? R.string.pos_paytype_wechat : ((paramLong == 0L || paramLong == 1L || paramLong == 2L) ? R.string.pos_paytype_alipay : R.string.pos_paytype_other); }
  
  public static int co(long paramLong) { return (paramLong == 5L || paramLong == 7L || paramLong == 8L) ? 10009 : ((paramLong == 0L || paramLong == 1L || paramLong == 2L) ? 10007 : 0); }
  
  class PayTypeSpecific {}
  
  class PayTypeSpecific {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\PayTypeSpecific.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */