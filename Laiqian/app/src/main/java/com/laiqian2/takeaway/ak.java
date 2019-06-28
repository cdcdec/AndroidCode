package com.laiqian.takeaway;

import com.laiqian.entity.TakeOrderEntity;
import com.laiqian.entity.ap;
import com.laiqian.ui.a.r;
import java.io.PrintStream;

class ak implements r.a {
  ak(aj paramaj, int paramInt) {}
  
  private TakeOrderEntity aqy() {
    if (this.dsl.dsj.getId().equals(y.i(this.dsl.dsf).getId())) {
      y.i(this.dsl.dsf).du(((ap)y.g(this.dsl.dsf).get(this.qI)).getName());
      y.i(this.dsl.dsf).dt(((ap)y.g(this.dsl.dsf).get(this.qI)).getPhone());
      return y.i(this.dsl.dsf);
    } 
    TakeOrderEntity takeOrderEntity = this.dsl.dsf.a(this.dsl.dsj);
    takeOrderEntity.du(((ap)y.g(this.dsl.dsf).get(this.qI)).getName());
    takeOrderEntity.dt(((ap)y.g(this.dsl.dsf).get(this.qI)).getPhone());
    return takeOrderEntity;
  }
  
  public void xD() { this.dsl.dsg.dismiss(); }
  
  public void xE() {
    TakeOrderEntity takeOrderEntity = aqy();
    y.a(this.dsl.dsf, this.dsl.dsj.getNumber(), ((ap)y.g(this.dsl.dsf).get(this.qI)).getID());
    PrintStream printStream = System.out;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("order deliveryName :");
    stringBuilder.append(this.dsl.dsj.IG());
    printStream.println(stringBuilder.toString());
    printStream = System.out;
    stringBuilder = new StringBuilder();
    stringBuilder.append("orderEntity deliveryName :");
    stringBuilder.append(y.i(this.dsl.dsf).IG());
    printStream.println(stringBuilder.toString());
    y.b(this.dsl.dsf, takeOrderEntity);
    this.dsl.dsg.dismiss();
    this.dsl.dsf.notifyDataSetChanged();
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */