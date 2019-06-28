package com.laiqian.pos.hold;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import com.laiqian.pos.settings.z;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class aw extends BaseAdapter {
  private static final SimpleDateFormat ciK = new SimpleDateFormat("HH:mm");
  
  private Comparator<PendingFullOrderDetail.a> awh = new ax(this);
  
  private int bAC;
  
  List<PendingFullOrderDetail.a> cqj;
  
  private int cqk;
  
  GridView cql = null;
  
  protected Context mContext = null;
  
  private LayoutInflater mInflater;
  
  public aw(Context paramContext, @NonNull ArrayList<PendingFullOrderDetail.a> paramArrayList, int paramInt) {
    this.mContext = paramContext;
    this.cqj = paramArrayList;
    this.cqk = paramInt;
    this.mInflater = (LayoutInflater)paramContext.getSystemService("layout_inflater");
    this.bAC = 0;
    Collections.sort(this.cqj, this.awh);
  }
  
  private void a(PendingFullOrderDetail.a parama, a parama1) {
    if (parama.coJ != null) {
      parama1.cqn.setVisibility(0);
      parama1.cqn.setText(z.kF(String.format("%s %s", new Object[] { this.mContext.getString(2131626872), parama.coJ })));
    } else {
      parama1.cqn.setVisibility(8);
    } 
    if (parama.coE.getDay() != (new Date(System.currentTimeMillis())).getDay()) {
      parama1.bqW.setText(ciK.format(parama.coE));
      parama1.cqo.setVisibility(0);
      return;
    } 
    parama1.bqW.setText(ciK.format(parama.coE));
    parama1.cqo.setVisibility(4);
  }
  
  private void a(a parama, View paramView) {
    parama.cqn = (TextView)paramView.findViewById(2131299321);
    parama.bqW = (TextView)paramView.findViewById(2131299444);
    parama.cqo = (TextView)paramView.findViewById(2131299458);
    parama.cqp = paramView.findViewById(2131297795);
  }
  
  public void a(GridView paramGridView) { this.cql = paramGridView; }
  
  public int aaL() { return this.bAC; }
  
  public void gB(int paramInt) {
    int i = this.bAC;
    int j = this.cql.getFirstVisiblePosition();
    int k = i - j;
    if (k >= 0 && i <= this.cql.getLastVisiblePosition()) {
      a a = (a)this.cql.getChildAt(k).getTag();
      if (a != null)
        a.cqp.setActivated(false); 
    } 
    this.bAC = paramInt;
    i = paramInt - j;
    if (i >= 0) {
      if (paramInt > this.cql.getLastVisiblePosition())
        return; 
      a a = (a)this.cql.getChildAt(i).getTag();
      if (a != null)
        a.cqp.setActivated(true); 
      return;
    } 
  }
  
  public int getCount() { return this.cqj.size(); }
  
  public long getItemId(int paramInt) { return paramInt; }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    a a;
    if (paramView == null) {
      a = new a();
      paramView = this.mInflater.inflate(this.cqk, null);
      a(a, paramView);
      paramView.setTag(a);
    } else {
      a = (a)paramView.getTag();
    } 
    if (this.bAC == paramInt) {
      a.cqp.setActivated(true);
    } else {
      a.cqp.setActivated(false);
    } 
    a((PendingFullOrderDetail.a)this.cqj.get(paramInt), a);
    return paramView;
  }
  
  public void hd(int paramInt) { this.bAC = paramInt; }
  
  public PendingFullOrderDetail.a he(int paramInt) { return (PendingFullOrderDetail.a)this.cqj.get(paramInt); }
  
  public void jH(String paramString) {
    int i = this.bAC;
    int j = i - this.cql.getFirstVisiblePosition();
    if (j >= 0) {
      if (i > this.cql.getLastVisiblePosition())
        return; 
      ((a)this.cql.getChildAt(j).getTag()).cqn.setText(String.format("%s %s", new Object[] { this.mContext.getString(2131626872), paramString }));
    } 
  }
  
  public void m(List<PendingFullOrderDetail.a> paramList) {
    List<PendingFullOrderDetail.a> list = paramList;
    if (paramList == null)
      list = new ArrayList<PendingFullOrderDetail.a>(); 
    this.cqj = list;
    notifyDataSetChanged();
  }
  
  public void notifyDataSetChanged() {
    Collections.sort(this.cqj, this.awh);
    super.notifyDataSetChanged();
  }
  
  static class a {
    TextView bqW;
    
    TextView cqn;
    
    TextView cqo;
    
    View cqp;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\hold\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */