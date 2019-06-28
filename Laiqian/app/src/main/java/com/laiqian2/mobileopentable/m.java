package com.laiqian.mobileopentable;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.laiqian.opentable.R;
import com.laiqian.opentable.common.entity.a;
import java.util.List;

public class m extends RecyclerView.a<m.b> {
  private List<a> bMA;
  
  private a bMB;
  
  private int bMC;
  
  private RecyclerView bMD;
  
  private a bME;
  
  private LayoutInflater mInflater;
  
  public m(Context paramContext, List<a> paramList, RecyclerView paramRecyclerView, a parama) {
    this.mInflater = LayoutInflater.from(paramContext);
    this.bMA = paramList;
    this.bMD = paramRecyclerView;
    this.bME = parama;
    paramRecyclerView.a(this);
  }
  
  public void A(List<a> paramList) {
    this.bMA = paramList;
    e(null);
    notifyDataSetChanged();
  }
  
  public void a(b paramb, int paramInt) {
    if (paramInt > this.bMA.size())
      return; 
    if (this.bMB == null) {
      this.bMC = paramInt;
      this.bMB = (a)this.bMA.get(paramInt);
      paramb.bMI.setActivated(true);
      this.bME.d(this.bMB);
    } else if (this.bMB.getId() == ((a)this.bMA.get(paramInt)).getId()) {
      paramb.bMI.setActivated(true);
    } else {
      paramb.bMI.setActivated(false);
    } 
    paramb.bMH.setText(((a)this.bMA.get(paramInt)).XX());
    if (this.bME != null)
      paramb.bMH.setOnClickListener(new n(this, paramInt, paramb)); 
  }
  
  public void e(a parama) { this.bMB = parama; }
  
  public b g(ViewGroup paramViewGroup, int paramInt) { return new b(this.mInflater.inflate(R.layout.order_region_item, paramViewGroup, false)); }
  
  public int getItemCount() { return (this.bMA != null) ? this.bMA.size() : 0; }
  
  public static interface a {
    void d(a param1a);
  }
  
  public static class b extends RecyclerView.s {
    TextView bMH;
    
    View bMI;
    
    public b(View param1View) {
      super(param1View);
      this.bMH = (TextView)param1View.findViewById(R.id.region_name);
      this.bMI = param1View.findViewById(R.id.rl_item);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\mobileopentable\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */