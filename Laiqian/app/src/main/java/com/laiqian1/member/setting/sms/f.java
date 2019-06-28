package com.laiqian.member.setting.sms;

import android.os.Handler;
import android.os.Message;
import com.laiqian.payment.R;
import com.laiqian.util.n;
import java.util.HashMap;

class f extends Handler {
  f(c paramc) {}
  
  public void handleMessage(Message paramMessage) {
    int i = paramMessage.what;
    if (i != 4) {
      HashMap hashMap;
      if (i != 10000) {
        if (i != 10003) {
          if (i != 40004) {
            switch (i) {
              default:
                switch (i) {
                  default:
                    return;
                  case 40002:
                    n.o(String.valueOf(((HashMap)paramMessage.obj).get("sub_msg")));
                    return;
                  case 40001:
                    break;
                } 
                n.o(String.valueOf(((HashMap)paramMessage.obj).get("sub_msg")));
                return;
              case 2:
                n.o("请保证非折扣金额金额处于0.01~100000000之间");
                return;
              case 1:
                n.o("请保证折扣金额金额处于0.01~100000000之间");
                return;
              case 0:
                n.eP(R.string.pos_alipay_AMOUNT_IS_OUT_RANG);
                return;
              case -1:
                break;
            } 
            n.eP(R.string.pos_can_not_use_normally);
            return;
          } 
          hashMap = (HashMap)paramMessage.obj;
          if ("SYSTEM_ERROR".equals(hashMap.get("sub_code")) && hashMap.get("sub_code") != null) {
            n.eP(R.string.pos_upgrade_server_process_fail);
            return;
          } 
          if (hashMap.get("sub_code") != null) {
            n.o(String.valueOf(hashMap.get("sub_msg")));
            return;
          } 
          if ("ILLEGAL_PARTNER".equals(String.valueOf(hashMap.get("error")))) {
            n.o("pid不正确,请联系客服");
            return;
          } 
          if ("ILLEGAL_SIGN".equals(String.valueOf(hashMap.get("error")))) {
            n.o("key不正确,请联系客服");
            return;
          } 
        } else {
          hashMap = (HashMap)hashMap.obj;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(hashMap.get("sub_msg"));
          stringBuilder.append("");
          n.o(stringBuilder.toString());
          return;
        } 
      } else {
        c.a(this.bGy).setVisibility(8);
        c.b(this.bGy).setVisibility(0);
        String str = (String)((HashMap)hashMap.obj).get("qr_code");
        c.a(this.bGy, str);
        return;
      } 
    } else {
      n.eP(R.string.pos_query_server_is_error);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\sms\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */