package com.laiqian.main.module.productcart;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.laiqian.entity.aa;
import com.laiqian.main.dl;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.product.a.a;
import com.laiqian.product.a.d;
import com.laiqian.product.models.h;
import com.laiqian.rx.b.a;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class am {
  public static final Map<Integer, Integer> bkc = new HashMap();
  
  static  {
    bkc.put(Integer.valueOf(0), Integer.valueOf(2131427831));
    bkc.put(Integer.valueOf(1), Integer.valueOf(2131427673));
  }
  
  public static a.d<a> NT() { return new ap(); }
  
  public static a<a> a(Context paramContext, dl paramdl) { return new ao(bkc, NT(), new an(paramContext, paramdl)); }
  
  public static abstract class a {
    aa a(PendingFullOrderDetail.d param1d, Boolean param1Boolean) {
      null = (new d()).a(new d.a()).akm();
      aa aa = new aa(new h(param1d.id, param1d.name, param1d.cpm, param1d.cpn, 0.0D, 600001, param1d.cpq, "", param1d.cpu, "", (int)param1d.cpx, 0.0D), null);
      if (param1d.cpl != null)
        aa.aq(param1d.cpl.longValue()); 
      aa.as(param1d.cpz);
      aa.ev(param1d.aTU);
      aa.az(param1d.bbX);
      aa.ar(param1d.aTO);
      aa.cS(param1d.aTP);
      aa.q(param1d.cpo);
      aa.cV(true);
      aa.cW(param1Boolean.booleanValue());
      aa.GD();
      aa.o(param1d.aTR);
      return aa;
    }
    
    public static class a extends a {
      public final aa bjo;
      
      public a(aa param2aa) { this.bjo = param2aa; }
      
      public a(PendingFullOrderDetail.d param2d, Boolean param2Boolean) { this.bjo = a(param2d, param2Boolean); }
      
      public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ItemProduct{product=");
        stringBuilder.append(this.bjo.name);
        stringBuilder.append('}');
        return stringBuilder.toString();
      }
    }
    
    public static class b extends a {
      public final Date bkf;
      
      public b(Date param2Date) { this.bkf = param2Date; }
    }
  }
  
  public static class a extends a {
    public final aa bjo;
    
    public a(aa param1aa) { this.bjo = param1aa; }
    
    public a(PendingFullOrderDetail.d param1d, Boolean param1Boolean) { this.bjo = a(param1d, param1Boolean); }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ItemProduct{product=");
      stringBuilder.append(this.bjo.name);
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
  }
  
  public static class b extends a {
    public final Date bkf;
    
    public b(Date param1Date) { this.bkf = param1Date; }
  }
  
  public static final class b {
    public LinearLayout aQx;
    
    public a bkg;
    
    public b(View param1View) {
      this.aQx = (LinearLayout)param1View;
      this.bkg = new a(param1View.findViewById(2131297976));
    }
    
    public static final class a {
      public LinearLayout aQx;
      
      public TextView bjG;
      
      public TextView bkh;
      
      public TextView bki;
      
      public TextView bkj;
      
      public a(View param2View) {
        this.aQx = (LinearLayout)param2View;
        this.bjG = (TextView)param2View.findViewById(2131298563);
        this.bkh = (TextView)param2View.findViewById(2131296393);
        this.bki = (TextView)param2View.findViewById(2131298578);
        this.bkj = (TextView)param2View.findViewById(2131298524);
      }
    }
  }
  
  public static final class a {
    public LinearLayout aQx;
    
    public TextView bjG;
    
    public TextView bkh;
    
    public TextView bki;
    
    public TextView bkj;
    
    public a(View param1View) {
      this.aQx = (LinearLayout)param1View;
      this.bjG = (TextView)param1View.findViewById(2131298563);
      this.bkh = (TextView)param1View.findViewById(2131296393);
      this.bki = (TextView)param1View.findViewById(2131298578);
      this.bkj = (TextView)param1View.findViewById(2131298524);
    }
  }
  
  public static final class c {
    public LinearLayout aQx;
    
    public TextView bkk;
    
    public View bkl;
    
    public TextView bkm;
    
    public c(View param1View) {
      this.aQx = (LinearLayout)param1View;
      this.bkk = (TextView)this.aQx.findViewById(2131298930);
      this.bkl = this.aQx.findViewById(2131297932);
      this.bkm = (TextView)this.aQx.findViewById(2131299684);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\productcart\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */