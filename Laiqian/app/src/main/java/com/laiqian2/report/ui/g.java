package com.laiqian.report.ui;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import com.laiqian.report.models.a;
import com.laiqian.report.models.b;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.CylindricalSummaryView;
import com.laiqian.ui.a.d;
import java.util.ArrayList;

public class g extends BaseAdapter {
  private ActivityRoot activity;
  
  private GridView bDj;
  
  private ArrayList<a> bjv;
  
  private a ddW;
  
  View.OnClickListener ddX = new h(this);
  
  public g(ActivityRoot paramActivityRoot, GridView paramGridView) {
    this.activity = paramActivityRoot;
    this.bDj = paramGridView;
    this.bjv = new ArrayList();
    this.ddW = new a(this, paramActivityRoot);
  }
  
  public void ay(ArrayList<a> paramArrayList) {
    this.bjv = paramArrayList;
    int i = getCount();
    if (i != 4) {
      switch (i) {
        default:
          this.bDj.setNumColumns(3);
          i = this.activity.getResources().getDimensionPixelOffset(2131165376);
          break;
        case 1:
          this.bDj.setNumColumns(1);
          i = this.activity.getResources().getDimensionPixelOffset(2131165374);
          break;
        case 2:
          this.bDj.setNumColumns(2);
          i = this.activity.getResources().getDimensionPixelOffset(2131165375);
          break;
      } 
      this.bDj.setPadding(i, 0, i, 0);
      notifyDataSetChanged();
      return;
    } 
  }
  
  public int getCount() { return (this.bjv == null) ? 0 : this.bjv.size(); }
  
  public long getItemId(int paramInt) { return 0L; }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    b b;
    if (paramView == null) {
      paramView = View.inflate(this.activity, 2131427977, null);
      View view1 = paramView.findViewById(2131297260);
      View view2 = paramView.findViewById(2131296798);
      b = new b(this, view1, view2, (TextView)view2.findViewById(2131296351), (TextView)view2.findViewById(2131299826), view2.findViewById(2131297257), paramView.findViewById(2131296763));
      paramView.setTag(b);
      paramView.setOnClickListener(this.ddX);
    } else {
      b = (b)paramView.getTag();
    } 
    a a1 = jQ(paramInt);
    if (getCount() == 1) {
      paramInt = this.activity.getResources().getDimensionPixelOffset(2131165372);
    } else {
      paramInt = this.activity.getResources().getDimensionPixelOffset(2131165373);
    } 
    (b.deg.getLayoutParams()).height = paramInt;
    Drawable drawable = b.def.getBackground();
    if (drawable != null && drawable instanceof GradientDrawable) {
      ((GradientDrawable)drawable).setColor(a1.cZm);
    } else {
      b.def.setBackgroundColor(a1.cZm);
    } 
    b.deh.setText(a1.cZl);
    b.dei.setText(a1.Yx);
    b.cdt.setBackgroundResource(a1.aTb);
    if (a1.amo()) {
      paramView.setEnabled(true);
      b.dej.setVisibility(0);
    } else {
      paramView.setEnabled(false);
      b.dej.setVisibility(4);
    } 
    b.dee = a1;
    return paramView;
  }
  
  public a jQ(int paramInt) { return (a)this.bjv.get(paramInt); }
  
  public ArrayList<a> zJ() { return this.bjv; }
  
  class a extends d {
    TextView ddZ;
    
    TextView dea;
    
    ViewGroup deb;
    
    public a(g this$0, ActivityRoot param1ActivityRoot) {
      super(param1ActivityRoot, 2131427974);
      this.mView.findViewById(2131296783).setOnClickListener(new i(this, this$0));
      this.ddZ = (TextView)this.mView.findViewById(2131296362);
      this.dea = (TextView)this.mView.findViewById(2131296363);
      this.deb = (ViewGroup)this.mView.findViewById(2131296366);
    }
    
    public void b(a param1a) {
      this.ddZ.setText(param1a.cZl);
      this.dea.setText(param1a.Yx);
      this.deb.removeAllViews();
      ArrayList arrayList = param1a.amq();
      double[] arrayOfDouble = new double[arrayList.size()];
      a a1 = null;
      byte b = 0;
      while (b < arrayList.size()) {
        String str1;
        a a2 = (a)arrayList.get(b);
        arrayOfDouble[b] = a2.cZk;
        View view2 = View.inflate(g.b(this.ddY), 2131427975, null);
        View view3 = view2.findViewById(2131296358);
        param1a = a1;
        null = view2;
        View view1 = view3;
        if (a2.cZj != null) {
          param1a = a1;
          null = view2;
          view1 = view3;
          if (!a2.cZj.equals(a1)) {
            str1 = a2.cZj;
            null = (TextView)view2.findViewById(2131299826);
            null.setVisibility(0);
            view3.setVisibility(8);
            null.setText(a2.cZj);
            this.deb.addView(view2);
            null = View.inflate(g.b(this.ddY), 2131427975, null);
            view1 = null.findViewById(2131296358);
          } 
        } 
        ((TextView)view1.findViewById(2131296359)).setText(a2.Yx);
        ((TextView)view1.findViewById(2131296365)).setText(a2.cZl);
        Drawable drawable = view1.findViewById(2131297257).getBackground();
        if (drawable != null && drawable instanceof GradientDrawable)
          ((GradientDrawable)drawable).setColor(a2.cZm); 
        this.deb.addView(null);
        ArrayList arrayList1 = a2.amq();
        if (!arrayList1.isEmpty()) {
          ViewGroup viewGroup = (ViewGroup)view1.findViewById(2131296769);
          for (a a3 : arrayList1) {
            view2 = View.inflate(g.b(this.ddY), 2131427976, null);
            ((TextView)view2.findViewById(2131296359)).setText(a3.Yx);
            ((TextView)view2.findViewById(2131296365)).setText(a3.cZl);
            viewGroup.addView(view2);
          } 
        } 
        b++;
        String str2 = str1;
      } 
      ((CylindricalSummaryView)this.mView.findViewById(2131299979)).a(arrayOfDouble, b.bOf, this.mActivity.getResources().getColor(2131099743));
      super.show();
    }
    
    @Deprecated
    public void show() { super.show(); }
  }
  
  class b {
    View cdt;
    
    a dee;
    
    View def;
    
    View deg;
    
    TextView deh;
    
    TextView dei;
    
    View dej;
    
    public b(g this$0, View param1View1, View param1View2, TextView param1TextView1, TextView param1TextView2, View param1View3, View param1View4) {
      this.def = param1View1;
      this.deg = param1View2;
      this.deh = param1TextView1;
      this.dei = param1TextView2;
      this.cdt = param1View3;
      this.dej = param1View4;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */