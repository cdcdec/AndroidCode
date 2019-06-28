package com.laiqian.news;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.d.a;
import com.laiqian.entity.aa;
import com.laiqian.models.ba;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.product.a.a;
import com.laiqian.product.models.a;
import com.laiqian.product.models.h;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class x extends BaseAdapter {
  public LinkedHashMap<Integer, Long> bWW;
  
  private ba bWX;
  
  private ListView bWY;
  
  private ArrayList<Long> bWZ;
  
  private SimpleDateFormat bXa;
  
  private PendingFullOrderDetail.a bXb;
  
  private Context mContext;
  
  private String orderTypeID = "86003";
  
  private final ArrayList<aa> productData = new ArrayList();
  
  public x(ListView paramListView, Context paramContext) {
    this.bWY = paramListView;
    this.mContext = paramContext;
    this.bXa = new SimpleDateFormat(this.mContext.getString(2131627409));
    paramListView.setAdapter(this);
  }
  
  private void WW() { notifyDataSetChanged(); }
  
  private void a(double paramDouble1, double paramDouble2, boolean paramBoolean) {}
  
  private void a(View paramView, aa paramaa, int paramInt) {
    boolean bool;
    double d1;
    if (paramView == null) {
      notifyDataSetChanged();
      return;
    } 
    a a1 = (a)paramView.getTag();
    null = a1.bXi;
    if (!paramaa.GN() && !paramaa.akO()) {
      bool = true;
    } else {
      bool = false;
    } 
    null.setEnabled(bool);
    a1.bXc.setText(paramaa.cUM);
    stringBuilder2 = paramaa.GM();
    if (stringBuilder2.length() == 0) {
      a1.bXd.setVisibility(8);
    } else {
      a1.bXd.setVisibility(0);
      a1.bXd.setText(stringBuilder2);
    } 
    try {
      d1 = Double.valueOf(paramaa.Gx()).doubleValue();
    } catch (Exception stringBuilder2) {
      a.e(stringBuilder2);
      d1 = 0.0D;
    } 
    a1.bXf.setText(paramaa.GG());
    double d2 = d1;
    if (d1 < 0.0D) {
      d2 = -d1;
      a1.bXf.setText(this.mContext.getString(2131628116));
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("x");
    stringBuilder1.append(d2);
    String str = stringBuilder1.toString();
    a1.bXe.setText(str);
    if (WX()) {
      a1.bXi.setBackgroundResource(2131099980);
      if (this.bWW != null) {
        if (this.bWW.containsKey(Integer.valueOf(paramInt))) {
          if (((Integer)b(this.bWW).getKey()).intValue() == paramInt) {
            a1.bXh.setVisibility(8);
          } else {
            a1.bXh.setVisibility(0);
          } 
          a1.bXg.setVisibility(0);
          a1.bXj.setText(this.bXa.format(new Date(((Long)this.bWW.get(Integer.valueOf(paramInt))).longValue())));
          return;
        } 
        a1.bXg.setVisibility(8);
        return;
      } 
    } else {
      a1.bXi.setBackgroundResource(2131231367);
      a1.bXg.setVisibility(8);
    } 
  }
  
  private void b(aa paramaa) {
    if (this.mContext.getResources().getBoolean(2131034127)) {
      if (this.bWX == null)
        this.bWX = new ba(this.mContext); 
      paramaa.o(this.bWX.s(paramaa.aSW, this.orderTypeID));
      paramaa.GD();
    } 
  }
  
  public PendingFullOrderDetail.a WV() { return this.bXb; }
  
  public boolean WX() { return true; }
  
  public LinkedHashMap<Integer, Long> WY() { return this.bWW; }
  
  public void WZ() {
    if (getCount() > 0) {
      this.productData.clear();
      WW();
    } 
  }
  
  public ArrayList<aa> Xa() { return this.productData; }
  
  public void a(h paramh, boolean paramBoolean1, boolean paramBoolean2) {
    aa aa;
    if (paramh instanceof aa) {
      aa = (aa)paramh;
    } else {
      aa = new aa(paramh, new a(a.AZ().Cp()));
    } 
    if (paramBoolean1) {
      aa.r(paramh.akK());
      aa.GD();
    } 
    if (this.bWZ != null && this.bWZ.contains(Long.valueOf(aa.aJx))) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    } 
    aa.cT(paramBoolean1);
    b(aa);
    this.productData.add(aa);
    a(aa.GJ(), aa.GI(), false);
    if (paramh instanceof a) {
      ArrayList arrayList = ((a)paramh).akq();
      if (arrayList != null)
        for (h h1 : arrayList)
          this.productData.add(new aa(h1, new a(a.AZ().Cp())));  
    } 
    WW();
  }
  
  public void a(Collection<h> paramCollection, boolean paramBoolean) {
    Iterator iterator = paramCollection.iterator();
    while (iterator.hasNext())
      a((h)iterator.next(), paramBoolean, false); 
  }
  
  public Map.Entry<Integer, Long> b(LinkedHashMap<Integer, Long> paramLinkedHashMap) { return (Map.Entry)paramLinkedHashMap.entrySet().iterator().next(); }
  
  public void c(PendingFullOrderDetail.a parama) { this.bXb = parama; }
  
  public void c(LinkedHashMap<Integer, Long> paramLinkedHashMap) { this.bWW = paramLinkedHashMap; }
  
  public int getCount() { return this.productData.size(); }
  
  public long getItemId(int paramInt) { return 0L; }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    View view = paramView;
    if (paramView == null) {
      view = View.inflate(this.mContext, 2131427695, null);
      TextView textView1 = (TextView)view.findViewById(2131298563);
      TextView textView2 = (TextView)view.findViewById(2131296393);
      TextView textView3 = (TextView)view.findViewById(2131298578);
      TextView textView4 = (TextView)view.findViewById(2131298524);
      View view1 = view.findViewById(2131298987);
      View view2 = view.findViewById(2131297932);
      View view3 = view.findViewById(2131297976);
      view.setTag(new a(textView1, textView2, textView3, textView4, view1, (TextView)view.findViewById(2131298930), view2, view3));
    } 
    a(view, gs(paramInt), paramInt);
    return view;
  }
  
  public aa gs(int paramInt) { return (aa)this.productData.get(paramInt); }
  
  private static class a {
    TextView bXc;
    
    TextView bXd;
    
    TextView bXe;
    
    TextView bXf;
    
    View bXg;
    
    View bXh;
    
    View bXi;
    
    TextView bXj;
    
    public a(TextView param1TextView1, TextView param1TextView2, TextView param1TextView3, TextView param1TextView4, View param1View1, TextView param1TextView5, View param1View2, View param1View3) {
      this.bXc = param1TextView1;
      this.bXd = param1TextView2;
      this.bXe = param1TextView3;
      this.bXf = param1TextView4;
      this.bXg = param1View1;
      this.bXh = param1View2;
      this.bXi = param1View3;
      this.bXj = param1TextView5;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\news\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */