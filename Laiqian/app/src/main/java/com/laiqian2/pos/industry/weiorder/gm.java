package com.laiqian.pos.industry.weiorder;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.Toast;
import com.laiqian.c.a;
import com.laiqian.entity.aw;
import com.laiqian.product.dq;
import com.laiqian.product.models.g;
import com.laiqian.product.models.o;
import com.laiqian.ui.a.r;
import com.laiqian.util.av;
import com.laiqian.util.bd;
import com.laiqian.util.n;
import java.util.ArrayList;

public class gm {
  private static ArrayList<o> cwz;
  
  private String aSQ = "";
  
  private boolean aSS = true;
  
  Context context;
  
  aw ctH;
  
  r ctb;
  
  gp ctu;
  
  gp ctw;
  
  go cwX;
  
  long[] cwY;
  
  public gm(Context paramContext, go paramgo) {
    this.context = paramContext;
    this.cwX = paramgo;
  }
  
  private void RY() {
    this.cwX.hj(this.cwY.length);
    this.cwX.az(this.ctu.ack());
    this.cwX.aD(this.ctu.aci());
    this.cwX.hi(this.ctu.acm());
    cwz = (new dq(this.context)).gp(true);
    String str = this.ctu.acn();
    this.cwX.kc(str);
    this.cwX.aE(this.ctu.acj());
    this.cwX.af(this.ctu.ach());
    this.cwX.p(this.ctu.FI());
    boolean bool = a.zR().Ab();
    boolean bool1 = false;
    if (!bool && !a.zR().Ad()) {
      go go1 = this.cwX;
      bool = bool1;
      if (this.ctu.FH()) {
        bool = bool1;
        if (!TextUtils.isEmpty(this.ctu.FD()))
          bool = true; 
      } 
      go1.cJ(bool);
      this.cwX.ft(this.ctu.acl());
      this.cwX.cE(this.ctu.aco());
      this.cwX.r(this.ctu.FD(), this.ctu.FA());
      this.cwX.fu(true);
      return;
    } 
    this.cwX.ft(this.ctu.acl());
    this.cwX.fu(false);
  }
  
  public boolean Az() { return (this.ctu != null) ? ((this.ctw == null) ? false : (!this.ctu.equals(this.ctw))) : false; }
  
  public void aD(double paramDouble) { this.ctu.aD(paramDouble); }
  
  public void aE(double paramDouble) { this.ctu.aE(paramDouble); }
  
  public String abf() { return this.ctu.FD(); }
  
  public void abh() {
    if (this.ctb == null) {
      this.ctb = new r(this.context, new gn(this));
      this.ctb.t(this.context.getString(2131624429));
      this.ctb.s(this.context.getString(2131630682));
      this.ctb.setTitle(this.context.getString(2131624145));
    } 
    this.ctb.show();
  }
  
  public long[] acg() { return this.cwY; }
  
  public void af(ArrayList<eh> paramArrayList) {
    this.ctu.af(paramArrayList);
    this.ctw.af(paramArrayList);
    this.cwX.af(paramArrayList);
  }
  
  public String ah(ArrayList<eh> paramArrayList) {
    StringBuffer stringBuffer = new StringBuffer();
    for (eh eh : paramArrayList) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(String.format(this.context.getString(2131630537), new Object[] { n.b(this.context, Double.valueOf(eh.abM()), false, false), n.b(this.context, Double.valueOf(eh.FI()), false, false) }));
      stringBuilder.append(",");
      stringBuffer.append(stringBuilder.toString());
    } 
    if (stringBuffer.length() > 0)
      stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length()); 
    return stringBuffer.toString();
  }
  
  public void az(double paramDouble) { this.ctu.az(paramDouble); }
  
  public void cE(boolean paramBoolean) { this.ctu.cE(paramBoolean); }
  
  public void cJ(boolean paramBoolean) { this.ctu.cJ(paramBoolean); }
  
  public void ft(boolean paramBoolean) { this.ctu.ft(paramBoolean); }
  
  public void h(long[] paramArrayOfLong) { this.cwY = paramArrayOfLong; }
  
  public void hi(int paramInt) { this.ctu.hi(paramInt); }
  
  public void init() { (new a(this, null)).execute(new Void[0]); }
  
  public void kc(String paramString) { this.ctu.kc(paramString); }
  
  public void p(double paramDouble) { this.ctu.p(paramDouble); }
  
  public void save() { (new b(this)).execute(new Void[0]); }
  
  private class a extends AsyncTask<Void, Void, Boolean> {
    private a(gm this$0) {}
    
    protected void b(Boolean param1Boolean) {
      if (!this.cwZ.cwX.zP())
        return; 
      try {
        this.cwZ.cwX.hideProgress();
      } catch (Exception exception) {}
      if (param1Boolean.booleanValue()) {
        this.cwZ.cwX.zO();
        gm.a(this.cwZ);
        return;
      } 
      this.cwZ.cwX.Sl();
      Toast.makeText(this.cwZ.context, this.cwZ.context.getString(2131630541), 0).show();
      av av = new av(this.cwZ.context);
      String str = av.Tx();
      av.close();
      this.cwZ.ctw = new gp(str);
      this.cwZ.ctu = this.cwZ.ctw.acp();
      gm.a(this.cwZ);
    }
    
    protected Boolean g(Void... param1VarArgs) {
      g g = new g(this.cwZ.context);
      this.cwZ.cwY = g.akA();
      g.close();
      fp fp = fp.aX(this.cwZ.context);
      this.cwZ.ctw = fp.abX();
      this.cwZ.ctH = fp.abV();
      if (this.cwZ.ctw == null)
        return Boolean.valueOf(false); 
      this.cwZ.ctu = this.cwZ.ctw.acp();
      return Boolean.valueOf(true);
    }
    
    protected void onPreExecute() { this.cwZ.cwX.Em(); }
  }
  
  public class b extends AsyncTask<Void, Void, Boolean> {
    boolean bBY = false;
    
    public b(gm this$0) {}
    
    private boolean SI() {
      if (!bd.bH(this.cwZ.context)) {
        Toast.makeText(this.cwZ.context, this.cwZ.context.getString(2131626280), 0).show();
        return false;
      } 
      return true;
    }
    
    protected void b(Boolean param1Boolean) {
      if (!this.cwZ.cwX.zP())
        return; 
      try {
        this.cwZ.cwX.RA();
      } catch (Exception exception) {}
      if (!this.bBY)
        return; 
      if (param1Boolean.booleanValue()) {
        this.cwZ.ctw = this.cwZ.ctu.acp();
        this.cwZ.cwX.showError(this.cwZ.context.getString(2131630560));
        return;
      } 
      this.cwZ.cwX.showError(this.cwZ.context.getString(2131630559));
      this.cwZ.ctu = this.cwZ.ctw.acp();
      gm.a(this.cwZ);
    }
    
    protected Boolean g(Void... param1VarArgs) { return this.bBY ? (fp.aX(this.cwZ.context).a(this.cwZ.ctu) ? Boolean.valueOf(true) : Boolean.valueOf(false)) : Boolean.valueOf(false); }
    
    protected void onPreExecute() {
      this.cwZ.cwX.Rz();
      this.bBY = SI();
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\gm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */