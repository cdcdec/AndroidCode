package com.laiqian;

import android.content.Context;
import android.os.Message;
import android.util.Log;
import com.laiqian.entity.n;
import com.laiqian.util.au;
import com.laiqian.util.bb;
import java.io.PrintStream;
import java.util.HashMap;

public class bs extends bt {
  public bs(Context paramContext, n paramn, n paramn1) { super(paramContext, paramn, paramn1); }
  
  private void a(String paramString, Message paramMessage, HashMap<String, Object> paramHashMap) {
    StringBuilder stringBuilder1;
    PrintStream printStream = System.out;
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("hm=");
    stringBuilder3.append(paramHashMap.toString());
    printStream.println(stringBuilder3.toString());
    if (paramHashMap != null && paramHashMap.get("code") != null && "10000".equals(String.valueOf(paramHashMap.get("code")))) {
      this.azm.bg("S");
      paramMessage.what = 10000;
      paramMessage.obj = paramHashMap;
      this.aBP.sendMessage(paramMessage);
      return;
    } 
    if (paramHashMap != null && paramHashMap.get("code") != null && "40004".equals(String.valueOf(paramHashMap.get("code")))) {
      this.azm.bg("F");
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("1");
      stringBuilder1.append(paramHashMap.toString());
      bb.e("alipay", stringBuilder1.toString());
      paramMessage.what = 40004;
      paramMessage.obj = paramHashMap;
      this.aBP.sendMessage(paramMessage);
      return;
    } 
    if (paramHashMap != null && paramHashMap.get("code") != null && "10003".equals(String.valueOf(paramHashMap.get("code")))) {
      this.azm.bg("I");
      paramMessage.what = 10003;
      paramMessage.obj = paramHashMap;
      this.aBP.sendMessage(paramMessage);
      return;
    } 
    if (paramHashMap != null && paramHashMap.get("code") != null && "20000".equals(String.valueOf(paramHashMap.get("code")))) {
      this.azm.bg("F");
      paramMessage.what = 6;
      paramMessage.obj = paramHashMap;
      this.aBP.sendMessage(paramMessage);
      return;
    } 
    if (paramHashMap != null && paramHashMap.get("code") != null && "40002".equals(String.valueOf(paramHashMap.get("code")))) {
      this.azm.bg("F");
      paramMessage.what = 40002;
      paramMessage.obj = paramHashMap;
      this.aBP.sendMessage(paramMessage);
      return;
    } 
    if (paramHashMap != null && paramHashMap.get("code") != null && "40001".equals(String.valueOf(paramHashMap.get("code")))) {
      this.azm.bg("F");
      paramMessage.what = 40001;
      paramMessage.obj = paramHashMap;
      this.aBP.sendMessage(paramMessage);
      return;
    } 
    if (paramHashMap != null && paramHashMap.get("code") != null && "20001".equals(String.valueOf(paramHashMap.get("code")))) {
      this.azm.bg("F");
      paramMessage.what = 20001;
      paramMessage.obj = paramHashMap;
      this.aBP.sendMessage(paramMessage);
      return;
    } 
    this.azm.bg("F");
    paramMessage.what = 4;
    this.aBP.sendMessage(paramMessage);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("2.");
    stringBuilder2.append(stringBuilder1);
    Log.e("nStatus", stringBuilder2.toString());
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
    HashMap hashMap = au.qB(paramString);
    if ("fubei-alipay".equals(hashMap.get("platform"))) {
      a(paramString, message, hashMap);
      return;
    } 
    b(paramString, message, hashMap);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */