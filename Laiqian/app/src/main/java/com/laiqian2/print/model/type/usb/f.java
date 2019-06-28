package com.laiqian.print.model.type.usb;

import com.laiqian.print.model.a;
import com.laiqian.print.model.g;
import com.laiqian.print.model.q;
import com.laiqian.print.model.s;
import java.util.HashMap;

public class f extends a {
  private g cHj;
  
  public f(g paramg) {
    this.cHj = paramg;
    setStatus(1);
  }
  
  private HashMap<String, s> agX() {
    HashMap hashMap = new HashMap();
    for (g g1 : UsbPrintManager.INSTANCE.getPrinterList())
      hashMap.put(g1.getPath(), g1); 
    return hashMap;
  }
  
  public void cancel() {}
  
  protected void m(q paramq) {
    g g1 = (g)paramq.agE();
    d d = UsbPrintManager.INSTANCE.findPrinterProperty(g1);
    if (d != null) {
      d = (d)d;
      g1.ii(d.agF());
      g1.setName(d.getName());
      g1.fT(d.agW());
      if (d.getHeight() != 0)
        g1.setHeight(d.getHeight()); 
      if (d.getWidth() != 0)
        g1.setWidth(d.getWidth()); 
      g1.fP(d.agH());
    } 
    super.m(paramq);
  }
  
  public void start() { // Byte code:
    //   0: aload_0
    //   1: invokevirtual onStarted : ()V
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: invokespecial agX : ()Ljava/util/HashMap;
    //   10: invokevirtual entrySet : ()Ljava/util/Set;
    //   13: invokeinterface iterator : ()Ljava/util/Iterator;
    //   18: astore_1
    //   19: aload_1
    //   20: invokeinterface hasNext : ()Z
    //   25: ifeq -> 61
    //   28: aload_1
    //   29: invokeinterface next : ()Ljava/lang/Object;
    //   34: checkcast java/util/Map$Entry
    //   37: astore_2
    //   38: aload_0
    //   39: aload_0
    //   40: getfield cHj : Lcom/laiqian/print/model/g;
    //   43: aload_2
    //   44: invokeinterface getValue : ()Ljava/lang/Object;
    //   49: checkcast com/laiqian/print/model/s
    //   52: invokevirtual f : (Lcom/laiqian/print/model/s;)Lcom/laiqian/print/model/q;
    //   55: invokevirtual m : (Lcom/laiqian/print/model/q;)V
    //   58: goto -> 19
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_0
    //   64: invokevirtual afa : ()V
    //   67: return
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Exception table:
    //   from	to	target	type
    //   6	19	68	finally
    //   19	58	68	finally
    //   61	63	68	finally
    //   69	71	68	finally }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\typ\\usb\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */