package com.laiqian.pos.hold;

public class ah {
  public final PendingFullOrderDetail.a bXb;
  
  public final PendingFullOrderDetail.c cdy;
  
  public ah(PendingFullOrderDetail.a parama, PendingFullOrderDetail.c paramc) {
    this.bXb = parama;
    this.cdy = paramc;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("PendingOrderModifyDetail{header=");
    stringBuilder.append(this.bXb);
    stringBuilder.append(", modifyEntry=");
    stringBuilder.append(this.cdy);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\hold\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */