package com.laiqian;

import android.content.Context;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.alipay.b.b;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.n;
import com.laiqian.payment.R;
import com.laiqian.pos.bm;
import com.laiqian.pos.industry.a;
import com.laiqian.ui.a.r;
import com.laiqian.util.au;
import com.laiqian.util.av;
import com.laiqian.util.by;
import com.laiqian.util.n;
import com.zhuge.analysis.b.a;
import io.reactivex.g.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class bt extends bj {
  @Nullable
  private String aBU;
  
  protected n azm;
  
  protected b azn;
  
  protected Context mContext;
  
  public bt(Context paramContext, n paramn, n paramn1) {
    super(paramContext, paramn, paramn1);
    this.azm = paramn;
    this.mContext = paramContext;
    this.azn = b.xA();
  }
  
  private void f(HashMap<String, Object> paramHashMap) {
    if (paramHashMap != null)
      try {
        if (paramHashMap.size() > 0) {
          String str = (String)paramHashMap.get("platform");
          if (!by.isNull(str) && "ms-weixin".equals(str)) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("支付的金额", 0);
            jSONObject.put("支付的时间", (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
            jSONObject.put("支付类型", "民生银行");
            a.aAU().a(this.mContext, "微信外卖成功率", jSONObject);
            return;
          } 
        } 
      } catch (Exception paramHashMap) {
        a.e(paramHashMap);
      }  
  }
  
  public void a(String paramString, b paramb) {
    HashMap hashMap = new HashMap();
    hashMap.put("out_trade_no", paramString);
    av av = new av(this.mContext);
    hashMap.put("shop_id", av.Tx());
    hashMap.put("pay_type", "bar_code");
    if (this.onlinePayEntity.Fn() == 1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(RootApplication.getLaiqianPreferenceManager().avs());
      stringBuilder.append("");
      hashMap.put("pay_mode", stringBuilder.toString());
      hashMap.put("business_type", "member");
    } else {
      hashMap.put("business_type", "reception");
    } 
    f.e(hashMap);
    av.close();
    paramb.a(this.mContext, hashMap, this.aBN, a.cqN);
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
          stop();
          this.azm.br(false);
          if (!this.azm.wX()) {
            this.azm.a(40004, null, null, 5);
            return;
          } 
        } else {
          HashMap hashMap = (HashMap)paramMessage.obj;
          if ("NOTPAY".equals(String.valueOf(hashMap.get("trade_state")))) {
            g(0, this.mContext.getString(R.string.pay_status_pending));
            return;
          } 
          if ("REFUND".equals(String.valueOf(hashMap.get("trade_state")))) {
            g(1, this.mContext.getString(R.string.pay_status_refund));
            stop();
            this.azm.br(false);
            this.azm.xk();
            return;
          } 
          if ("CLOSED".equals(String.valueOf(hashMap.get("trade_state")))) {
            g(-4, this.mContext.getString(R.string.pay_status_closed));
            stop();
            this.azm.br(false);
            this.azm.xk();
            return;
          } 
          if ("REVOKED".equals(String.valueOf(hashMap.get("trade_state")))) {
            g(1, this.mContext.getString(R.string.pay_status_revoked));
            stop();
            this.azm.br(false);
            this.azm.xk();
            return;
          } 
          if ("USERPAYING".equals(String.valueOf(hashMap.get("trade_state")))) {
            g(0, this.mContext.getString(R.string.pay_status_paying));
            return;
          } 
          if ("PAYERROR".equals(String.valueOf(hashMap.get("trade_state")))) {
            g(-1, this.mContext.getString(R.string.pay_status_fail));
            stop();
            this.azm.br(false);
            if (!this.azm.wX()) {
              this.azm.a(40004, null, null, 5);
              return;
            } 
          } else if ("SUCCESS".equals(String.valueOf(hashMap.get("trade_state"))) && hashMap.containsKey("out_trade_no")) {
            String str = String.valueOf(hashMap.get("out_trade_no"));
            if (this.onlinePayEntity.xq().equals(str)) {
              stop();
              this.azm.xk();
              this.azm.confirm(str);
              f(hashMap);
              return;
            } 
          } 
        } 
      } else {
        g(-4, this.mContext.getString(R.string.pay_status_lqk_server_error));
        if (!this.azm.wX())
          this.azm.a(4, null, null, 5); 
        this.azm.br(false);
        stop();
        return;
      } 
    } else {
      g(0, this.mContext.getString(R.string.pay_status_timeout));
      if (!this.azm.wX())
        this.azm.a(-1, null, null, 5); 
      this.azm.br(false);
      stop();
    } 
  }
  
  protected void b(String paramString, Message paramMessage, HashMap<String, Object> paramHashMap) {
    StringBuilder stringBuilder;
    Message message;
    if (paramHashMap != null && paramHashMap.get("result_code") != null && "SUCCESS".equals(String.valueOf(paramHashMap.get("result_code")))) {
      paramMessage.what = 10000;
      paramMessage.obj = paramHashMap;
      this.aBP.sendMessage(paramMessage);
      if (this.aBU != null) {
        double d = n.g(new Object[] { paramHashMap.get("total_fee"), Integer.valueOf(100) });
        if (d != 0.0D && n.e(new Object[] { this.aBU, Double.valueOf(d) }) != 0.0D) {
          message = new Message();
          message.what = 987654;
          stringBuilder = new StringBuilder();
          stringBuilder.append("微信支付异常。原本应支付 ");
          stringBuilder.append(this.aBU);
          stringBuilder.append("，但用户支付了 ");
          stringBuilder.append(d);
          stringBuilder.append("，请与用户协商。");
          message.obj = stringBuilder.toString();
          this.aBP.sendMessage(message);
          return;
        } 
      } 
    } else {
      if (paramHashMap != null && paramHashMap.get("result_code") != null && "FAIL".equals(String.valueOf(paramHashMap.get("result_code")))) {
        if (paramHashMap != null && paramHashMap.get("err_code") != null && ("SYSTEMERROR".equals(String.valueOf(paramHashMap.get("err_code"))) || "BANKERROR".equals(String.valueOf(paramHashMap.get("err_code"))) || "USERPAYING".equals(String.valueOf(paramHashMap.get("err_code"))))) {
          stringBuilder.what = 10003;
          stringBuilder.obj = paramHashMap;
          this.aBP.sendMessage(stringBuilder);
          return;
        } 
        stringBuilder.what = 40004;
        stringBuilder.obj = paramHashMap;
        this.aBP.sendMessage(stringBuilder);
        return;
      } 
      stringBuilder.what = 4;
      this.aBP.sendMessage(stringBuilder);
      stringBuilder = new StringBuilder();
      stringBuilder.append("2.");
      stringBuilder.append(message);
      Log.e("nStatus", stringBuilder.toString());
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
    if (hashMap != null && hashMap.get("result_code") != null && "SUCCESS".equals(String.valueOf(hashMap.get("result_code")))) {
      message.what = 10000;
      message.obj = hashMap;
      this.aBR.sendMessage(message);
      return;
    } 
    if (hashMap != null && hashMap.get("result_code") != null && "FAIL".equals(String.valueOf(hashMap.get("result_code")))) {
      message.what = 40004;
      message.obj = hashMap;
      this.aBR.sendMessage(message);
      return;
    } 
    message.what = 4;
    this.aBR.sendMessage(message);
  }
  
  public void bd(String paramString) {
    Message message = this.aBP.obtainMessage();
    if ("".equals(paramString)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("1.");
      stringBuilder.append(paramString);
      Log.e("nStatus", stringBuilder.toString());
      message.what = 4;
      this.aBP.sendMessage(message);
      return;
    } 
    if ("-1".equals(paramString)) {
      message.what = 4;
      this.aBP.sendMessage(message);
      return;
    } 
    b(paramString, message, au.qB(paramString));
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
    if (hashMap != null && hashMap.get("result_code") != null && "SUCCESS".equals(String.valueOf(hashMap.get("result_code")))) {
      message.what = 10000;
      message.obj = hashMap;
      this.aBO.sendMessage(message);
      return;
    } 
    if (hashMap != null && hashMap.get("result_code") != null && "FAIL".equals(String.valueOf(hashMap.get("result_code")))) {
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
          if (i != 6) {
            if (i != 10000) {
              if (i != 10003) {
                if (i != 40004) {
                  if (i != 987654)
                    return; 
                  g(-1, this.mContext.getString(R.string.pay_status_pay_amount_error));
                  null = new r(this.mContext, 3, null);
                  null.setTitle(this.mContext.getString(R.string.pos_dialog_title_error));
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append(paramMessage.obj);
                  stringBuilder.append("");
                  null.s(stringBuilder.toString());
                  null.pa(this.mContext.getString(R.string.pos_dialog_button_ok));
                  null.show();
                  JSONObject jSONObject = new JSONObject();
                  try {
                    jSONObject.put("type", "支付之后");
                    jSONObject.put("message", paramMessage.obj);
                  } catch (JSONException paramMessage) {
                    a.e(paramMessage);
                  } 
                  a.aAU().a(this.mContext, "扫码支付错误", jSONObject);
                  return;
                } 
              } else {
                g(0, this.mContext.getString(R.string.pay_status_paying));
                a(this.onlinePayEntity.xq(), this.azn);
                return;
              } 
            } else {
              hashMap = (HashMap)paramMessage.obj;
              if (hashMap.containsKey("out_trade_no")) {
                String str = String.valueOf(hashMap.get("out_trade_no"));
                if (this.onlinePayEntity.xq().equals(str)) {
                  this.azm.br(false);
                  this.azm.a(10000, null, str, 5);
                  xw();
                } 
              } 
              f(hashMap);
              return;
            } 
          } else {
            g(-4, this.mContext.getString(R.string.pay_status_unknown_reason));
            a(this.onlinePayEntity.xq(), this.azn);
          } 
          g(-1, this.mContext.getString(R.string.pay_status_fail));
          HashMap hashMap = (HashMap)hashMap.obj;
          this.azm.br(false);
          this.azm.a(40004, null, null, 5);
          return;
        } 
        g(-4, this.mContext.getString(R.string.pay_status_lqk_server_error));
        this.azm.a(4, null, null, 5);
        this.azm.br(false);
        return;
      } 
      g(0, this.mContext.getString(R.string.pay_status_timeout));
      this.azm.a(-1, null, null, 5);
      this.azm.br(false);
    } 
  }
  
  public void c(HashMap<String, String> paramHashMap) {
    if (this.onlinePayEntity.Fn() == 1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(RootApplication.getLaiqianPreferenceManager().avs());
      stringBuilder.append("");
      paramHashMap.put("pay_mode", stringBuilder.toString());
      paramHashMap.put("business_type", "member");
    } else {
      paramHashMap.put("business_type", "reception");
    } 
    f.e(paramHashMap);
    this.azn.a(this.mContext, paramHashMap, this.aBQ, a.cqN);
    this.azn.start();
  }
  
  public void d(Message paramMessage) {
    this.aBL.set(false);
    int i = paramMessage.what;
    if (i != -1) {
      if (i != 10000) {
        if (i != 40004) {
          switch (i) {
            default:
              return;
            case 5:
              g(-4, this.mContext.getString(R.string.pay_status_lqk_server_error));
              Toast.makeText(this.mContext, this.mContext.getString(R.string.pos_query_order_is_null), 1000).show();
              return;
            case 4:
              break;
          } 
          g(-4, this.mContext.getString(R.string.pay_status_lqk_server_error));
          Toast.makeText(this.mContext, this.mContext.getString(R.string.pos_query_server_is_error), 1000).show();
          return;
        } 
        g(-1, this.mContext.getString(R.string.pay_status_fail));
        hashMap = (HashMap)paramMessage.obj;
        Toast.makeText(this.mContext, hashMap.toString(), 1000).show();
        this.azm.a(40004, null, null, 8);
        return;
      } 
      HashMap hashMap = (HashMap)hashMap.obj;
      if ("NOTPAY".equals(String.valueOf(hashMap.get("trade_state")))) {
        g(0, this.mContext.getString(R.string.pay_status_wait_for_paying));
        return;
      } 
      if ("REFUND".equals(String.valueOf(hashMap.get("trade_state")))) {
        g(-1, this.mContext.getString(R.string.pay_status_refund));
        stop();
        this.azm.xk();
        return;
      } 
      if ("CLOSED".equals(String.valueOf(hashMap.get("trade_state")))) {
        g(-4, this.mContext.getString(R.string.pay_status_closed));
        stop();
        this.azm.xk();
        return;
      } 
      if ("REVOKED".equals(String.valueOf(hashMap.get("trade_state")))) {
        g(-1, this.mContext.getString(R.string.pay_status_revoked));
        stop();
        this.azm.xk();
        return;
      } 
      if ("USERPAYING".equals(String.valueOf(hashMap.get("trade_state")))) {
        g(0, this.mContext.getString(R.string.pay_status_paying));
        return;
      } 
      if ("PAYERROR".equals(String.valueOf(hashMap.get("trade_state")))) {
        g(-1, this.mContext.getString(R.string.pay_status_fail));
        return;
      } 
      if ("SUCCESS".equals(String.valueOf(hashMap.get("trade_state")))) {
        if (hashMap.containsKey("out_trade_no")) {
          String str = String.valueOf(hashMap.get("out_trade_no"));
          if (this.onlinePayEntity.xq().equals(str)) {
            stop();
            this.azm.xk();
            this.azm.confirm(str);
          } 
        } 
        f(hashMap);
        return;
      } 
    } else {
      g(0, this.mContext.getString(R.string.pay_status_timeout));
      Toast.makeText(this.mContext, this.mContext.getString(R.string.pos_can_not_use_normally), 1000).show();
    } 
  }
  
  public void e(Message paramMessage) {
    int i = paramMessage.what;
    if (i != -1) {
      if (i != 4) {
        if (i != 10000) {
          if (i != 10003) {
            if (i != 40004)
              return; 
            hashMap = (HashMap)paramMessage.obj;
            if ("SYSTEMERROR".equals(hashMap.get("err_code"))) {
              if ((String)hashMap.get("total_amount_pay") == null) {
                n.println("打印微信二维码之前，没有传需要支付的金额");
                return;
              } 
              this.azm.a(40004, null, null, 8);
              return;
            } 
            this.azm.a(40004, null, null, 8);
            return;
          } 
          hashMap = (HashMap)hashMap.obj;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(hashMap.get("sub_msg"));
          stringBuilder.append("");
          n.o(stringBuilder.toString());
          return;
        } 
        HashMap hashMap = (HashMap)hashMap.obj;
        String str = (String)hashMap.get("total_amount_pay");
        if ("SYSTEMERROR".equals(hashMap.get("err_code"))) {
          if (str == null) {
            n.println("打印微信二维码之前，没有传需要支付的金额");
            this.azm.a(90001, null, null, 8);
            return;
          } 
          this.azm.a(90001, null, null, 8);
          return;
        } 
        if (!hashMap.containsKey("err_code")) {
          String str1 = (String)hashMap.get("code_url");
          if (str == null) {
            n.println("打印微信二维码之前，没有传需要支付的金额");
            this.azm.a(90001, null, null, 8);
            return;
          } 
          HashMap hashMap1 = new HashMap();
          hashMap1.put("out_trade_no", this.onlinePayEntity.xq());
          hashMap1.put("total_amount", bm.o(this.onlinePayEntity.Fl(), 2));
          av av = RootApplication.getLaiqianPreferenceManager();
          hashMap1.put("shop_id", av.Tx());
          hashMap1.put("user_id", av.atm());
          hashMap1.put("pay_type", "qr_code");
          c(hashMap1);
          this.azm.a(90000, str1, null, 8);
          return;
        } 
      } else {
        this.azm.a(90001, null, null, 8);
        return;
      } 
    } else {
      n.eP(R.string.pos_can_not_use_normally);
      this.azm.a(-1, null, null, 8);
    } 
  }
  
  public void wQ() {
    this.azm.dF(1);
    bu bu = new bu(this);
    a.aKh().r(bu);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */