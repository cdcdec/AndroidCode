package com.laiqian.news;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.util.z;
import java.util.ArrayList;
import java.util.List;

public class o extends RecyclerView.a<o.a> {
  private RecyclerView Lj;
  
  ArrayList<PendingFullOrderDetail> bWG;
  
  private int bWH;
  
  private b bWI;
  
  Context mContext;
  
  private int qL = -1;
  
  public o(Context paramContext, ArrayList<PendingFullOrderDetail> paramArrayList, RecyclerView paramRecyclerView) {
    this.mContext = paramContext;
    this.bWG = paramArrayList;
    this.Lj = paramRecyclerView;
  }
  
  public void O(ArrayList<PendingFullOrderDetail> paramArrayList) {
    if (paramArrayList != null) {
      this.bWG.clear();
      this.bWG.addAll(paramArrayList);
    } 
  }
  
  public PendingFullOrderDetail WU() { return (this.bWG == null || this.bWG.size() == 0 || this.qL == -1) ? null : (PendingFullOrderDetail)this.bWG.get(this.qL); }
  
  public void a(a parama, int paramInt) {
    TextView textView = parama.bWK;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(((PendingFullOrderDetail)this.bWG.get(paramInt)).bXb.coE.getTime());
    stringBuilder.append("");
    textView.setText(z.e(stringBuilder.toString(), this.mContext));
    textView = parama.bWM;
    stringBuilder = new StringBuilder();
    stringBuilder.append(((PendingFullOrderDetail)this.bWG.get(paramInt)).bXb.bZc);
    stringBuilder.append(((PendingFullOrderDetail)this.bWG.get(paramInt)).bXb.bTe);
    textView.setText(stringBuilder.toString());
    if (((PendingFullOrderDetail)this.bWG.get(paramInt)).bXb.cpd == 5 || ((PendingFullOrderDetail)this.bWG.get(paramInt)).bXb.cpd == 4) {
      parama.bWN.setImageResource(2131231114);
      parama.bWL.setText(2131626130);
      parama.bWO.setBackgroundResource(2131231050);
    } else if (((PendingFullOrderDetail)this.bWG.get(paramInt)).bXb.cpd == 0 || ((PendingFullOrderDetail)this.bWG.get(paramInt)).bXb.cpd == 1) {
      parama.bWN.setImageResource(2131231118);
      parama.bWL.setText(2131629995);
      parama.bWO.setBackgroundResource(2131231728);
    } else if (((PendingFullOrderDetail)this.bWG.get(paramInt)).bXb.cpd == 2 || ((PendingFullOrderDetail)this.bWG.get(paramInt)).bXb.cpd == 3) {
      if (this.bWH == 0) {
        parama.bWN.setImageResource(2131231118);
        parama.bWL.setText(2131629995);
        parama.bWO.setBackgroundResource(2131231728);
      } else if (this.bWH == 1) {
        parama.bWN.setImageResource(2131231096);
        parama.bWL.setText(2131629260);
        parama.bWO.setBackgroundResource(2131231728);
      } 
    } 
    parama.bWA.setOnClickListener(new p(this, paramInt));
    if (this.qL == paramInt) {
      parama.bWA.performClick();
      parama.bWA.setBackground(parama.SE.getContext().getResources().getDrawable(2131231166));
      return;
    } 
    parama.bWA.setBackground(parama.SE.getContext().getResources().getDrawable(2131231169));
  }
  
  public void a(a parama, int paramInt, List<Object> paramList) {
    Log.e("onBindViewHolder", "3个参数的方法");
    if (!paramList.isEmpty()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt);
      stringBuilder.append("");
      Log.e("performClick", stringBuilder.toString());
      setPosition(paramInt);
      parama.bWA.setBackground(parama.SE.getContext().getResources().getDrawable(2131231166));
      parama.bWA.performClick();
      return;
    } 
    a(parama, paramInt);
  }
  
  public void a(b paramb) { this.bWI = paramb; }
  
  public void g(RecyclerView paramRecyclerView) { super.g(paramRecyclerView); }
  
  public int getItemCount() { return this.bWG.size(); }
  
  public int getPosition() { return this.qL; }
  
  public void gq(int paramInt) { this.bWH = paramInt; }
  
  public a h(ViewGroup paramViewGroup, int paramInt) { return new a(this, LayoutInflater.from(this.mContext).inflate(2131427685, paramViewGroup, false)); }
  
  public void setPosition(int paramInt) { this.qL = paramInt; }
  
  public class a extends RecyclerView.s {
    LinearLayout bWA;
    
    TextView bWK;
    
    TextView bWL;
    
    TextView bWM;
    
    ImageView bWN;
    
    View bWO;
    
    public a(o this$0, View param1View) {
      super(param1View);
      this.bWK = (TextView)param1View.findViewById(2131299800);
      this.bWO = param1View.findViewById(2131299960);
      this.bWM = (TextView)param1View.findViewById(2131299478);
      this.bWN = (ImageView)param1View.findViewById(2131297375);
      this.bWA = (LinearLayout)param1View.findViewById(2131297905);
      this.bWL = (TextView)param1View.findViewById(2131299550);
    }
  }
  
  public static interface b {
    void w(View param1View, int param1Int);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\news\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */