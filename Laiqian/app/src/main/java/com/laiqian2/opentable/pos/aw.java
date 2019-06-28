package com.laiqian.opentable.pos;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.b.c;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.laiqian.basic.RootApplication;
import com.laiqian.opentable.R;
import com.laiqian.opentable.common.entity.c;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import kotlin.jvm.a.a;
import kotlin.jvm.a.b;
import kotlin.k;

public class aw extends RecyclerView.a {
  final int ccA;
  
  final int ccB = 0;
  
  final int ccC = 1;
  
  c<c> cct = new c(c.class, new ax(this));
  
  int ccu = -1;
  
  a<k> ccv;
  
  b<Integer, k> ccw;
  
  final int ccx;
  
  final int ccy;
  
  final int ccz;
  
  public aw(@NonNull a<k> parama, @NonNull b<Integer, k> paramb) {
    Resources resources = RootApplication.zv().getResources();
    this.ccx = resources.getColor(R.color.text_color_grey);
    this.ccy = resources.getColor(R.color.label_text_color);
    this.ccz = Color.parseColor("#F8F8F8");
    this.ccA = resources.getColor(R.color.viewgroup_pressed);
    this.ccv = parama;
    this.ccw = paramb;
  }
  
  public RecyclerView.s b(ViewGroup paramViewGroup, int paramInt) {
    LayoutInflater layoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    return (paramInt == 0) ? new b(this, layoutInflater.inflate(R.layout.pos_activity_table_number_item_normal, paramViewGroup, false)) : ((paramInt == 1) ? new a(this, layoutInflater.inflate(R.layout.pos_activity_table_number_item_new, paramViewGroup, false)) : null);
  }
  
  public void b(RecyclerView.s params, int paramInt) {
    TextView textView;
    if (getItemViewType(paramInt) == 0) {
      c c1 = (c)this.cct.get(paramInt);
      b b1 = (b)params;
      if (this.ccu == paramInt) {
        b1.tvTableNumber.setTextColor(this.ccy);
        b1.tvTableNumber.setBackgroundColor(this.ccA);
      } else {
        b1.tvTableNumber.setTextColor(this.ccx);
        b1.tvTableNumber.setBackgroundColor(this.ccz);
      } 
      Resources resources = RootApplication.zw();
      if (c1.Yl() == 0) {
        str = resources.getString(R.string.open_table_number_none);
      } else {
        String str;
        null = new StringBuilder();
        null.append(resources.getString(R.string.open_table_number));
        null.append(c1.Yl());
        str = null.toString();
      } 
      b1.tvTableNumber.setText(str);
      b1.bqW.setText((new SimpleDateFormat("HH:mm")).format(new Date(c1.DP())));
      textView = b1.ccF;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(c1.Ym());
      stringBuilder.append(resources.getString(R.string.person_unit));
      textView.setText(stringBuilder.toString());
      b1.SE.setOnClickListener(new ay(this, b1));
      return;
    } 
    textView.SE.setOnClickListener(new az(this));
  }
  
  public void f(c paramc) {
    StringBuilder stringBuilder;
    int m = paramc.Yl();
    c c1 = this.cct;
    int i = 0;
    int j = 0;
    int k = ((c)c1.get(0)).Yl();
    if (m < k) {
      j = i;
    } else {
      for (i = 1; i < this.cct.size(); i++) {
        int n = ((c)this.cct.get(i)).Yl();
        if (m == n) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("Table Number 的重复: ");
          stringBuilder.append(m);
          throw new IllegalStateException(stringBuilder.toString());
        } 
        if (k < m && m < n) {
          j = i;
        } else {
          k = n;
        } 
      } 
      if (m > k)
        j = this.cct.size(); 
    } 
    i = this.ccu;
    this.ccu = j;
    bK(i);
    this.cct.p(stringBuilder);
  }
  
  public int getItemCount() { return this.cct.size() + 1; }
  
  public int getItemViewType(int paramInt) { return (paramInt < this.cct.size()) ? 0 : 1; }
  
  public void l(Collection<c> paramCollection) {
    this.cct.fj();
    this.cct.clear();
    this.cct.addAll(paramCollection);
    if (this.cct.size() > 0) {
      this.ccu = 0;
    } else {
      this.ccu = -1;
    } 
    this.cct.fk();
  }
  
  private class a extends RecyclerView.s {
    public a(aw this$0, View param1View) { super(param1View); }
  }
  
  private class b extends RecyclerView.s {
    TextView bqW = (TextView)this.SE.findViewById(R.id.tvTime);
    
    TextView ccF = (TextView)this.SE.findViewById(R.id.tvNumOfPeople);
    
    TextView tvTableNumber = (TextView)this.SE.findViewById(R.id.tvTableNumber);
    
    public b(aw this$0, View param1View) { super(param1View); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\pos\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */