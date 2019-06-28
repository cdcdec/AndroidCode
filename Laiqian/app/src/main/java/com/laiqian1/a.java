package com.laiqian;

import android.content.Context;
import android.os.Message;
import android.util.Log;
import com.laiqian.alipay.b.b;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.n;
import com.laiqian.payment.R;
import com.laiqian.pos.bm;
import com.laiqian.pos.industry.a;
import com.laiqian.util.au;
import com.laiqian.util.av;
import com.laiqian.util.bb;
import com.laiqian.util.n;
import io.reactivex.g.a;
import java.io.PrintStream;
import java.util.HashMap;

public class a extends bj {
  private n azm;
  
  private b azn;
  
  private Context mContext;
  
  private n onlinePayEntity;
  
  public a(Context paramContext, n paramn, n paramn1) {
    super(paramContext, paramn, paramn1);
    this.azm = paramn;
    this.mContext = paramContext;
    this.azn = b.xA();
    this.onlinePayEntity = paramn1;
  }
  
  private void d(HashMap<String, Object> paramHashMap) {
    String str = (String)paramHashMap.get("qr_code");
    if ((String)paramHashMap.get("total_amount_pay") == null) {
      n.println("等待用户扫描二维码的时候，没有传入支付金额");
      return;
    } 
    paramHashMap = new HashMap<String, Object>();
    paramHashMap.put("out_trade_no", this.onlinePayEntity.xq());
    paramHashMap.put("total_amount", bm.o(this.onlinePayEntity.Fl(), 2));
    av av = new av(this.mContext);
    paramHashMap.put("shop_id", av.Tx());
    if (this.onlinePayEntity.Fn() == 1) {
      paramHashMap.put("business_type", "member");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(RootApplication.getLaiqianPreferenceManager().avs());
      stringBuilder.append("");
      paramHashMap.put("pay_mode", stringBuilder.toString());
    } else {
      paramHashMap.put("business_type", "reception");
    } 
    av.close();
    c(paramHashMap);
    this.azm.a(90000, str, null, 0);
  }
  
  public void a(String paramString, b paramb) {
    Log.e("startBarcodeQueryOrder", paramString);
    HashMap hashMap = new HashMap();
    hashMap.put("out_trade_no", paramString);
    av av = new av(this.mContext);
    hashMap.put("shop_id", av.Tx());
    hashMap.put("pay_type", "bar_code");
    av.close();
    if (this.onlinePayEntity.Fn() == 1) {
      hashMap.put("business_type", "member");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(RootApplication.getLaiqianPreferenceManager().avs());
      stringBuilder.append("");
      hashMap.put("pay_mode", stringBuilder.toString());
    } else {
      hashMap.put("business_type", "reception");
    } 
    f.e(hashMap);
    paramb.a(this.mContext, hashMap, this.aBN, a.cqJ);
    paramb.start();
  }
  
  public void b(Message paramMessage) {
    int i = paramMessage.what;
    if (i != -1) {
      if (i != 4) {
        if (i != 10000) {
          if (i != 40004)
            return; 
          g(-1, this.mContext.getString(R.string.pay_status_fail));
          this.azm.br(false);
          if (!this.azm.wX())
            this.azm.a(40004, null, null, 1); 
          stop();
          return;
        } 
        HashMap hashMap = (HashMap)paramMessage.obj;
        if ("WAIT_BUYER_PAY".equals(String.valueOf(hashMap.get("trade_status")))) {
          g(0, this.mContext.getString(R.string.pay_status_paying));
          return;
        } 
        if ("TRADE_CLOSED".equals(String.valueOf(hashMap.get("trade_status")))) {
          g(0, this.mContext.getString(R.string.pay_status_closed));
          stop();
          this.azm.br(false);
          this.azm.xk();
          return;
        } 
        if ("TRADE_SUCCESS".equals(String.valueOf(hashMap.get("trade_status"))) && !this.azm.wX() && hashMap.containsKey("out_trade_no")) {
          String str = String.valueOf(hashMap.get("out_trade_no"));
          if (this.onlinePayEntity.xq().equals(str)) {
            this.azm.a(10000, null, str, 1);
            this.azm.br(false);
            stop();
            return;
          } 
        } 
      } else {
        g(-4, this.mContext.getString(R.string.pay_status_lqk_server_error));
        if (!this.azm.wX())
          this.azm.a(4, null, null, 1); 
        this.azm.br(false);
        stop();
        return;
      } 
    } else {
      g(0, this.mContext.getString(R.string.pay_status_timeout));
      if (!this.azm.wX())
        this.azm.a(-1, null, null, 1); 
      this.azm.br(false);
      stop();
    } 
  }
  
  public void bc(String paramString) {
    Message message = this.aBR.obtainMessage();
    if ("".equals(paramString)) {
      message.what = 4;
      this.aBR.sendMessage(message);
      return;
    } 
    if ("-1".equals(paramString)) {
      message.what = -1;
      this.aBR.sendMessage(message);
      return;
    } 
    HashMap hashMap = au.qB(paramString);
    if (hashMap != null && hashMap.get("code") != null && "10000".equals(String.valueOf(hashMap.get("code")))) {
      message.what = 10000;
      message.obj = hashMap;
      this.aBR.sendMessage(message);
      return;
    } 
    if (hashMap != null && hashMap.get("code") != null && "40004".equals(String.valueOf(hashMap.get("code")))) {
      message.what = 40004;
      message.obj = hashMap;
      this.aBR.sendMessage(message);
      return;
    } 
    message.what = 4;
    this.aBR.sendMessage(message);
  }
  
  public void bd(String paramString) {
    StringBuilder stringBuilder1;
    Message message = this.aBP.obtainMessage();
    if ("".equals(paramString)) {
      this.azm.bg("P");
      message.what = 4;
      this.aBP.sendMessage(message);
      return;
    } 
    if ("-1".equals(paramString)) {
      this.azm.bg("X");
      message.what = 4;
      this.aBP.sendMessage(message);
      return;
    } 
    HashMap hashMap = au.qB(paramString);
    PrintStream printStream = System.out;
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("hm=");
    stringBuilder3.append(hashMap.toString());
    printStream.println(stringBuilder3.toString());
    if (hashMap != null && hashMap.get("code") != null && "10000".equals(String.valueOf(hashMap.get("code")))) {
      this.azm.bg("S");
      message.what = 10000;
      message.obj = hashMap;
      this.aBP.sendMessage(message);
      return;
    } 
    if (hashMap != null && hashMap.get("code") != null && "40004".equals(String.valueOf(hashMap.get("code")))) {
      this.azm.bg("F");
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("1");
      stringBuilder1.append(hashMap.toString());
      bb.e("alipay", stringBuilder1.toString());
      message.what = 40004;
      message.obj = hashMap;
      this.aBP.sendMessage(message);
      return;
    } 
    if (hashMap != null && hashMap.get("code") != null && "10003".equals(String.valueOf(hashMap.get("code")))) {
      this.azm.bg("I");
      message.what = 10003;
      message.obj = hashMap;
      this.aBP.sendMessage(message);
      return;
    } 
    if (hashMap != null && hashMap.get("code") != null && "20000".equals(String.valueOf(hashMap.get("code")))) {
      this.azm.bg("F");
      message.what = 6;
      message.obj = hashMap;
      this.aBP.sendMessage(message);
      return;
    } 
    if (hashMap != null && hashMap.get("code") != null && "40002".equals(String.valueOf(hashMap.get("code")))) {
      this.azm.bg("F");
      message.what = 40002;
      message.obj = hashMap;
      this.aBP.sendMessage(message);
      return;
    } 
    if (hashMap != null && hashMap.get("code") != null && "40001".equals(String.valueOf(hashMap.get("code")))) {
      this.azm.bg("F");
      message.what = 40001;
      message.obj = hashMap;
      this.aBP.sendMessage(message);
      return;
    } 
    if (hashMap != null && hashMap.get("code") != null && "20001".equals(String.valueOf(hashMap.get("code")))) {
      this.azm.bg("F");
      message.what = 20001;
      message.obj = hashMap;
      this.aBP.sendMessage(message);
      return;
    } 
    this.azm.bg("F");
    message.what = 4;
    this.aBP.sendMessage(message);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("2.");
    stringBuilder2.append(stringBuilder1);
    Log.e("nStatus", stringBuilder2.toString());
  }
  
  public void be(String paramString) {
    Message message = this.aBO.obtainMessage();
    if ("".equals(paramString)) {
      message.what = 4;
      this.aBO.sendMessage(message);
      return;
    } 
    if ("-1".equals(paramString)) {
      message.what = 4;
      this.aBO.sendMessage(message);
      return;
    } 
    HashMap hashMap = au.qB(paramString);
    if (hashMap != null && hashMap.get("code") != null && "10000".equals(String.valueOf(hashMap.get("code")))) {
      message.what = 10000;
      message.obj = hashMap;
      this.aBO.sendMessage(message);
      return;
    } 
    if (hashMap != null && hashMap.get("code") != null && "40004".equals(String.valueOf(hashMap.get("code")))) {
      message.what = 40004;
      message.obj = hashMap;
      this.aBO.sendMessage(message);
      return;
    } 
    message.what = 4;
    this.aBO.sendMessage(message);
  }
  
  public void c(Message paramMessage) {
    if (!this.azm.wX()) {
      if (this.azm.wY()) {
        this.azm.bs(false);
        return;
      } 
      int i = paramMessage.what;
      if (i != -1) {
        if (i != 4) {
          String str;
          if (i != 6) {
            if (i != 10000) {
              if (i != 10003) {
                String str1;
                if (i != 20001) {
                  if (i != 40004) {
                    switch (i) {
                      default:
                        return;
                      case 40002:
                        g(-1, this.mContext.getString(R.string.pay_status_invalid_arguments));
                        null = (HashMap)paramMessage.obj;
                        bb.e("alipay", null.toString());
                        null = String.valueOf(null.get("sub_msg"));
                        this.azm.br(false);
                        if (!this.azm.wX())
                          this.azm.a(40002, null, null, 1); 
                        stop();
                        xw();
                        return;
                      case 40001:
                        break;
                    } 
                    g(-1, this.mContext.getString(R.string.pay_status_miss_require_arguments));
                    null = (HashMap)null.obj;
                    bb.e("alipay", null.toString());
                    str = String.valueOf(null.get("sub_msg"));
                    this.azm.br(false);
                    if (!this.azm.wX())
                      this.azm.a(40001, str, null, 1); 
                    stop();
                    xw();
                    return;
                  } 
                } else {
                  g(-1, this.mContext.getString(R.string.pay_status_permission));
                  str = String.valueOf(((HashMap)str.obj).get("sub_msg"));
                  this.azm.a(20001, str, null, 1);
                  this.azm.br(false);
                  return;
                } 
              } else {
                g(0, this.mContext.getString(R.string.pay_status_paying));
                a(this.onlinePayEntity.xq(), this.azn);
                return;
              } 
            } else {
              HashMap hashMap1 = (HashMap)str.obj;
              if (hashMap1.containsKey("out_trade_no")) {
                str = String.valueOf(hashMap1.get("out_trade_no"));
                if (this.onlinePayEntity.xq().equals(str)) {
                  this.azm.br(false);
                  this.azm.a(10000, null, str, 1);
                  xw();
                  return;
                } 
              } 
              return;
            } 
          } else {
            g(-4, this.mContext.getString(R.string.pay_status_unknown_reason));
            a(this.onlinePayEntity.xq(), this.azn);
          } 
          g(-1, this.mContext.getString(R.string.pay_status_fail));
          HashMap hashMap = (HashMap)str.obj;
          this.azm.br(false);
          this.azm.a(40004, null, null, 1);
          if ("ILLEGAL_PARTNER".equals(String.valueOf(hashMap.get("error")))) {
            n.o("pid不正确,请联系客服");
            return;
          } 
          if ("ILLEGAL_SIGN".equals(String.valueOf(hashMap.get("error")))) {
            n.o("key不正确,请联系客服");
            return;
          } 
        } else {
          g(-4, this.mContext.getString(R.string.pay_status_lqk_server_error));
          this.azm.a(4, null, null, 1);
          this.azm.br(false);
          return;
        } 
      } else {
        g(0, this.mContext.getString(R.string.pay_status_timeout));
        this.azm.a(-1, null, null, 1);
        this.azm.br(false);
      } 
    } 
  }
  
  public void c(HashMap<String, String> paramHashMap) {
    f.e(paramHashMap);
    this.azn.a(this.mContext, paramHashMap, this.aBQ, a.cqF);
    this.azn.start();
  }
  
  public void d(Message paramMessage) {
    int i = paramMessage.what;
    if (i != -1) {
      if (i != 10000) {
        String str;
        if (i != 20001) {
          HashMap hashMap1;
          if (i != 40004) {
            switch (i) {
              default:
                return;
              case 5:
                g(-4, this.mContext.getString(R.string.pay_status_lqk_server_error));
                n.o(this.mContext.getString(R.string.pos_query_order_is_null));
                return;
              case 4:
                break;
            } 
            g(-4, this.mContext.getString(R.string.pay_status_lqk_server_error));
            n.o(this.mContext.getString(R.string.pos_query_server_is_error));
            return;
          } 
          hashMap1 = (HashMap)paramMessage.obj;
          if ("SYSTEM_ERROR".equals(hashMap1.get("detail_error_code")))
            return; 
          if ("TRADE_NOT_EXIST".equals(String.valueOf(hashMap1.get("detail_error_code"))))
            return; 
          if ("INVALID_PARAMETER".equals(String.valueOf(hashMap1.get("detail_error_code")))) {
            g(-1, this.mContext.getString(R.string.pay_status_fail));
            n.o(this.mContext.getString(R.string.pos_alipay_INVALID_PARAMETER));
            stop();
            this.azm.xk();
            return;
          } 
          g(-1, this.mContext.getString(R.string.pay_status_fail));
          n.o(this.mContext.getString(R.string.pos_query_server_is_error));
          stop();
          this.azm.xk();
          return;
        } 
        g(-1, this.mContext.getString(R.string.pay_status_permission));
        str = String.valueOf(((HashMap)hashMap1.obj).get("sub_msg"));
        this.azm.a(20001, str, null, 0);
        this.azm.br(false);
        return;
      } 
      HashMap hashMap = (HashMap)str.obj;
      if ("WAIT_BUYER_PAY".equals(String.valueOf(hashMap.get("trade_status")))) {
        g(0, this.mContext.getString(R.string.pay_status_paying));
        return;
      } 
      if ("TRADE_CLOSED".equals(String.valueOf(hashMap.get("trade_status")))) {
        g(0, this.mContext.getString(R.string.pay_status_closed));
        stop();
        this.azm.xk();
        n.o(this.mContext.getString(R.string.pos_alipay_TRADE_CLOSED));
        return;
      } 
      if ("TRADE_SUCCESS".equals(String.valueOf(hashMap.get("trade_status"))) && hashMap.containsKey("out_trade_no")) {
        String str = String.valueOf(hashMap.get("out_trade_no"));
        if (this.onlinePayEntity.xq().equals(str)) {
          stop();
          this.azm.xk();
          this.azm.confirm(str);
          return;
        } 
      } 
    } else {
      g(0, this.mContext.getString(R.string.pay_status_timeout));
      n.o(this.mContext.getString(R.string.pos_can_not_use_normally));
    } 
  }
  
  public void e(Message paramMessage) {
    this.aBL.set(false);
    int i = paramMessage.what;
    if (i != -1) {
      if (i != 4) {
        HashMap hashMap;
        if (i != 10000) {
          if (i != 10003) {
            if (i != 20001) {
              HashMap hashMap1;
              if (i != 40004) {
                switch (i) {
                  default:
                    return;
                  case 40002:
                    n.o(String.valueOf(((HashMap)paramMessage.obj).get("sub_msg")));
                    this.azm.a(90001, null, null, 0);
                    return;
                  case 40001:
                    break;
                } 
                n.o(String.valueOf(((HashMap)paramMessage.obj).get("sub_msg")));
                this.azm.a(90001, null, null, 0);
                return;
              } 
              hashMap = (HashMap)paramMessage.obj;
              if ("SYSTEM_ERROR".equals(hashMap.get("sub_code")) && hashMap.get("sub_code") != null) {
                d(hashMap);
                return;
              } 
              if (hashMap.get("sub_code") != null) {
                n.o(String.valueOf(hashMap.get("sub_msg")));
                this.azm.a(90001, null, null, 0);
                return;
              } 
              if ("ILLEGAL_PARTNER".equals(String.valueOf(hashMap.get("error")))) {
                n.o("pid不正确,请联系客服");
                this.azm.a(90001, null, null, 0);
                return;
              } 
              if ("ILLEGAL_SIGN".equals(String.valueOf(hashMap.get("error")))) {
                n.o("key不正确,请联系客服");
                this.azm.a(90001, null, null, 0);
                return;
              } 
            } else {
              String str;
              hashMap = String.valueOf(((HashMap)hashMap.obj).get("sub_msg"));
              this.azm.a(20001, hashMap, null, 0);
              this.azm.br(false);
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
          d((HashMap)hashMap.obj);
          return;
        } 
      } else {
        this.azm.a(90001, null, null, 0);
        return;
      } 
    } else {
      n.eP(R.string.pos_can_not_use_normally);
      this.azm.a(-1, null, null, 0);
    } 
  }
  
  public void wQ() {
    this.azm.dF(1);
    b b1 = new b(this);
    a.aKh().r(b1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */