package com.laiqian.report.onlinepay;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.entity.p;
import com.laiqian.entity.q;
import com.laiqian.main.bb;
import com.laiqian.main.di;
import com.laiqian.models.be;
import com.laiqian.models.o;
import com.laiqian.network.i;
import com.laiqian.report.models.z;
import com.laiqian.util.au;
import com.laiqian.util.n;

public class s {
  r ddu;
  
  public p ddv;
  
  private o ddw;
  
  Context mContext;
  
  @Nullable
  private di settlementRunnable;
  
  public s(Context paramContext, r paramr) {
    this.mContext = paramContext;
    this.ddu = paramr;
    this.ddv = new p();
    this.ddw = new o();
  }
  
  private void executeSettlementOfChainMember() { (new Thread(this.settlementRunnable)).start(); }
  
  public Integer[] Fv() { return this.ddv.Fv(); }
  
  public Integer[] Fw() { return this.ddv.Fw(); }
  
  public void a(q paramq) {
    a a = new a(this);
    a.ddy = paramq;
    a.aSz = this.ddv.Fx();
    a.execute(new Void[0]);
  }
  
  public void a(Integer[] paramArrayOfInteger) { this.ddv.a(paramArrayOfInteger); }
  
  public z anE() {
    try {
      return "0".equals(this.ddv.Fx()) ? this.ddw.a(this.ddv, "0") : this.ddw.b(this.ddv, "1");
    } catch (Exception exception) {
      a.e(exception);
      return new z();
    } 
  }
  
  public void b(Integer[] paramArrayOfInteger) { this.ddv.b(paramArrayOfInteger); }
  
  public void dd(String paramString) { this.ddv.dd(paramString); }
  
  public void de(String paramString) { this.ddv.de(paramString); }
  
  public void f(long[] paramArrayOfLong) { this.ddv.g(new String[] { null, (new String[2][0] = String.valueOf(paramArrayOfLong[0])).valueOf(paramArrayOfLong[1]) }); }
  
  public String getUserID() { return this.ddv.getUserID(); }
  
  public void init() {}
  
  public String jN(int paramInt) {
    if (paramInt != 5) {
      if (paramInt != 8) {
        switch (paramInt) {
          default:
            return "";
          case 1:
            return this.mContext.getString(2131626154);
          case 0:
            break;
        } 
        return this.mContext.getString(2131626155);
      } 
      return this.mContext.getString(2131626194);
    } 
    return this.mContext.getString(2131626193);
  }
  
  public String jO(int paramInt) {
    if (paramInt != -4) {
      switch (paramInt) {
        default:
          return "";
        case 1:
          return this.mContext.getString(2131626181);
        case 0:
          return this.mContext.getString(2131626177);
        case -1:
          return this.mContext.getString(2131626164);
        case -2:
          break;
      } 
      return this.mContext.getString(2131626183);
    } 
    return this.mContext.getString(2131626172);
  }
  
  public int jP(int paramInt) {
    int i = 2131099933;
    if (paramInt != -4) {
      switch (paramInt) {
        default:
          return 2131099782;
        case 1:
          i = 2131099768;
          break;
        case -2:
        case -1:
          break;
      } 
      return i;
    } 
  }
  
  public void p(String paramString, long paramLong) {
    bb bb = (new be(RootApplication.zv())).d(paramString, n.parseLong(this.ddv.Fu()[0]), n.parseLong(this.ddv.Fu()[1]));
    if (bb == null) {
      this.ddu.hideProgress();
      return;
    } 
    if (this.settlementRunnable != null)
      return; 
    this.settlementRunnable = new di(RootApplication.zv(), bb, false, new t(this));
    executeSettlementOfChainMember();
  }
  
  public class a extends AsyncTask<Void, Void, Boolean> {
    String aSz = "0";
    
    q ddy;
    
    public a(s this$0) {}
    
    private boolean anF() { // Byte code:
      //   0: aload_0
      //   1: getfield ddx : Lcom/laiqian/report/onlinepay/s;
      //   4: invokestatic a : (Lcom/laiqian/report/onlinepay/s;)Lcom/laiqian/models/o;
      //   7: aload_0
      //   8: getfield ddy : Lcom/laiqian/entity/q;
      //   11: invokevirtual xq : ()Ljava/lang/String;
      //   14: aload_0
      //   15: getfield ddy : Lcom/laiqian/entity/q;
      //   18: invokevirtual Fo : ()J
      //   21: invokevirtual e : (Ljava/lang/String;J)Ljava/lang/String;
      //   24: astore #5
      //   26: ldc ''
      //   28: aload #5
      //   30: invokevirtual equals : (Ljava/lang/Object;)Z
      //   33: istore #4
      //   35: iconst_1
      //   36: istore_2
      //   37: iconst_0
      //   38: istore_3
      //   39: iload_3
      //   40: istore_1
      //   41: iload #4
      //   43: ifne -> 248
      //   46: ldc '-1'
      //   48: aload #5
      //   50: invokevirtual equals : (Ljava/lang/Object;)Z
      //   53: ifeq -> 58
      //   56: iconst_0
      //   57: ireturn
      //   58: aload_0
      //   59: getfield ddy : Lcom/laiqian/entity/q;
      //   62: invokevirtual Fo : ()J
      //   65: lconst_1
      //   66: lcmp
      //   67: ifeq -> 183
      //   70: aload_0
      //   71: getfield ddy : Lcom/laiqian/entity/q;
      //   74: invokevirtual Fo : ()J
      //   77: lconst_0
      //   78: lcmp
      //   79: ifne -> 85
      //   82: goto -> 183
      //   85: aload_0
      //   86: getfield ddy : Lcom/laiqian/entity/q;
      //   89: invokevirtual Fo : ()J
      //   92: ldc2_w 5
      //   95: lcmp
      //   96: ifeq -> 115
      //   99: iload_3
      //   100: istore_1
      //   101: aload_0
      //   102: getfield ddy : Lcom/laiqian/entity/q;
      //   105: invokevirtual Fo : ()J
      //   108: ldc2_w 8
      //   111: lcmp
      //   112: ifne -> 248
      //   115: aload #5
      //   117: invokestatic qB : (Ljava/lang/String;)Ljava/util/HashMap;
      //   120: astore #5
      //   122: iload_3
      //   123: istore_1
      //   124: aload #5
      //   126: ifnull -> 248
      //   129: iload_3
      //   130: istore_1
      //   131: aload #5
      //   133: ldc 'result_code'
      //   135: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
      //   138: ifnull -> 248
      //   141: iload_3
      //   142: istore_1
      //   143: ldc 'SUCCESS'
      //   145: aload #5
      //   147: ldc 'result_code'
      //   149: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
      //   152: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
      //   155: invokevirtual equals : (Ljava/lang/Object;)Z
      //   158: ifeq -> 248
      //   161: iload_3
      //   162: istore_1
      //   163: ldc 'SUCCESS'
      //   165: aload #5
      //   167: ldc 'trade_state'
      //   169: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
      //   172: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
      //   175: invokevirtual equals : (Ljava/lang/Object;)Z
      //   178: ifeq -> 248
      //   181: iconst_1
      //   182: ireturn
      //   183: aload #5
      //   185: invokestatic qB : (Ljava/lang/String;)Ljava/util/HashMap;
      //   188: astore #5
      //   190: aload #5
      //   192: ifnull -> 246
      //   195: aload #5
      //   197: ldc 'code'
      //   199: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
      //   202: ifnull -> 246
      //   205: ldc '10000'
      //   207: aload #5
      //   209: ldc 'code'
      //   211: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
      //   214: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
      //   217: invokevirtual equals : (Ljava/lang/Object;)Z
      //   220: ifeq -> 246
      //   223: ldc 'TRADE_SUCCESS'
      //   225: aload #5
      //   227: ldc 'trade_status'
      //   229: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
      //   232: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
      //   235: invokevirtual equals : (Ljava/lang/Object;)Z
      //   238: ifeq -> 246
      //   241: iload_2
      //   242: istore_1
      //   243: goto -> 248
      //   246: iconst_0
      //   247: istore_1
      //   248: iload_1
      //   249: ireturn }
    
    private boolean anG() {
      i i = s.a(this.ddx).e(this.ddy.xq(), this.ddy.Fo());
      if ("".equals(i)) {
        i i1;
        i = new i(false, false, this.ddx.mContext.getString(2131626182));
      } else if ("-1".equals(i)) {
        i = new i(false, -1, this.ddx.mContext.getString(2131628540));
      } else {
        if (this.ddy.Fo() == 1L || this.ddy.Fo() == 0L) {
          i = au.qB(i);
          if (i != null && i.get("code") != null) {
            i i1;
            if ("10000".equals(String.valueOf(i.get("code"))) && "TRADE_SUCCESS".equals(String.valueOf(i.get("trade_status")))) {
              i1 = new i(true, true, this.ddx.mContext.getString(2131626181));
            } else if ("40004".equals(String.valueOf(i1.get("code")))) {
              if ("WAIT_BUYER_PAY".equals(String.valueOf(i1.get("trade_status")))) {
                i1 = new i(false, false, this.ddx.mContext.getString(2131626174));
              } else if ("TRADE_CLOSED".equals(String.valueOf(i1.get("trade_status")))) {
                i1 = new i(false, false, this.ddx.mContext.getString(2131626163));
              } else {
                i1 = new i(false, false, this.ddx.mContext.getString(2131626164));
              } 
            } else {
              i1 = new i(false, false, this.ddx.mContext.getString(2131626164));
            } 
          } else {
            i = new i(false, false, this.ddx.mContext.getString(2131626164));
          } 
          be be1 = new be(CrashApplication.zv());
          be1.b(this.ddy.xq(), String.valueOf(i.bUj), i.message, this.ddy.getTime() - 86400000L, System.currentTimeMillis());
          be1.close();
          return i.bUi;
        } 
        if (this.ddy.Fo() == 5L || this.ddy.Fo() == 8L) {
          i i1 = au.qB(i);
          if (i1 != null && i1.get("result_code") != null) {
            if ("SUCCESS".equals(String.valueOf(i1.get("result_code")))) {
              i i2;
              if ("SUCCESS".equals(String.valueOf(i1.get("trade_state")))) {
                i2 = new i(true, true, this.ddx.mContext.getString(2131626181));
              } else if ("CLOSED".equals(String.valueOf(i2.get("trade_state")))) {
                i2 = new i(false, -4, this.ddx.mContext.getString(2131626163));
              } else if ("REVOKED".equals(String.valueOf(i2.get("trade_state")))) {
                i2 = new i(false, -4, this.ddx.mContext.getString(2131626180));
              } else if ("USERPAYING".equals(String.valueOf(i2.get("trade_state")))) {
                i2 = new i(false, false, this.ddx.mContext.getString(2131626174));
              } else if ("PAYERROR".equals(String.valueOf(i2.get("trade_state")))) {
                i2 = new i(false, -1, this.ddx.mContext.getString(2131626164));
              } else if ("NOTPAY".equals(String.valueOf(i2.get("trade_state")))) {
                i2 = new i(false, -1, this.ddx.mContext.getString(2131626164));
              } else {
                i2 = new i(false, false, this.ddx.mContext.getString(2131626164));
              } 
            } else {
              i i2 = new i(false, false, this.ddx.mContext.getString(2131626166));
            } 
          } else {
            i1 = new i(false, false, this.ddx.mContext.getString(2131626166));
          } 
          be be1 = new be(CrashApplication.zv());
          be1.b(this.ddy.xq(), String.valueOf(i1.bUj), i1.message, this.ddy.getTime() - 86400000L, System.currentTimeMillis());
          be1.close();
          return i1.bUi;
        } 
        i = null;
      } 
      be be = new be(CrashApplication.zv());
      be.b(this.ddy.xq(), String.valueOf(i.bUj), i.message, this.ddy.getTime() - 86400000L, System.currentTimeMillis());
      be.close();
      return i.bUi;
    }
    
    protected void b(Boolean param1Boolean) {
      n.eP(2131624806);
      if ("0".equals(this.ddx.ddv.Fx())) {
        if (param1Boolean.booleanValue()) {
          this.ddx.p(this.ddy.xq(), this.ddy.getTime());
          return;
        } 
        this.ddx.ddu.hideProgress();
        return;
      } 
      if (param1Boolean.booleanValue())
        this.ddx.ddu.Py(); 
      this.ddx.ddu.hideProgress();
    }
    
    protected Boolean g(Void... param1VarArgs) { return "0".equals(this.aSz) ? Boolean.valueOf(anF()) : Boolean.valueOf(anG()); }
    
    protected void onPreExecute() { this.ddx.ddu.Em(); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\onlinepay\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */