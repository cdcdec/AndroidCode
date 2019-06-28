package com.laiqian.main.module.productpool;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.laiqian.product.models.h;
import com.laiqian.rx.b.a;
import java.util.HashMap;
import java.util.Map;

public class v {
  public static final Map<Integer, Integer> bkc = new HashMap();
  
  static  {
    bkc.put(Integer.valueOf(0), Integer.valueOf(2131427818));
    bkc.put(Integer.valueOf(1), Integer.valueOf(2131427817));
    bkc.put(Integer.valueOf(2), Integer.valueOf(2131427819));
    bkc.put(Integer.valueOf(3), Integer.valueOf(2131427816));
  }
  
  public static a.d<a> NT() { return new w(); }
  
  public static class a {
    public static class a extends a {}
    
    public static class b extends a {}
    
    public static class c extends a {
      public final h blh;
      
      public c(h param2h) { this.blh = param2h; }
      
      public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ItemProduct{product=");
        stringBuilder.append(this.blh.name);
        stringBuilder.append('}');
        return stringBuilder.toString();
      }
    }
    
    public static class d extends a {}
  }
  
  public static class a extends a {}
  
  public static class b extends a {}
  
  public static class c extends a {
    public final h blh;
    
    public c(h param1h) { this.blh = param1h; }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ItemProduct{product=");
      stringBuilder.append(this.blh.name);
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
  }
  
  public static class d extends a {}
  
  public static final class b {
    public RelativeLayout aQo;
    
    public TextView bjG;
    
    public TextView blc;
    
    public TextView bli;
    
    public TextView blj;
    
    public ImageView blk;
    
    public b(View param1View) {
      this.aQo = (RelativeLayout)param1View;
      this.bjG = (TextView)param1View.findViewById(2131298563);
      this.bli = (TextView)param1View.findViewById(2131298595);
      this.blj = (TextView)param1View.findViewById(2131298576);
      this.blc = (TextView)param1View.findViewById(2131298571);
      this.blk = (ImageView)param1View.findViewById(2131300032);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\productpool\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */