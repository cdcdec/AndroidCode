package com.laiqian.opentable.pos;

import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.laiqian.d.a;
import com.laiqian.opentable.R;
import com.laiqian.opentable.a.b;
import com.laiqian.opentable.common.entity.a;
import com.laiqian.opentable.common.u;
import com.laiqian.ordertool.c.a;
import com.laiqian.ui.a.ax;
import com.laiqian.util.n;
import java.util.ArrayList;

public class ai {
  private a bMB;
  
  private int cbA;
  
  private ArrayList<a> cbB = new ArrayList();
  
  private int cbC;
  
  private int cbD;
  
  private b cbE;
  
  private View cbF;
  
  private View cbG;
  
  private ax cbH;
  
  private long cbI;
  
  private final a cbJ;
  
  private boolean cbK;
  
  private float cbL;
  
  private View.OnClickListener cbM = new ao(this);
  
  private View.OnLongClickListener cbN = new ap(this);
  
  private FragmentActivity cbv;
  
  private View cbw;
  
  private TextView[] cbx;
  
  private ViewGroup cby;
  
  private ViewGroup cbz;
  
  public ai(FragmentActivity paramFragmentActivity, View paramView, ArrayList<a> paramArrayList, a parama, a parama1) {
    this.cbv = paramFragmentActivity;
    this.cbJ = parama;
    this.cbB = paramArrayList;
    this.cbE = new b(this.cbv, parama1);
    this.cbE.a(new aj(this));
    this.cbC = 1;
    this.cbw = View.inflate(this.cbv, R.layout.pos_activity_producttype, null);
    this.cby = (ViewGroup)this.cbw.findViewById(R.id.producttype_body_1);
    this.cbz = (ViewGroup)this.cbw.findViewById(R.id.producttype_body_2);
    this.cbG = this.cbz.findViewById(R.id.producttype_body_change_page);
    this.cbG.findViewById(R.id.producttype_prev).setOnClickListener(new ak(this));
    this.cbG.findViewById(R.id.producttype_next).setOnClickListener(new al(this));
    this.cbF = paramView;
    this.cbF.setOnClickListener(new am(this));
    String str = this.cbv.getString(R.string.pos_takeaway_edit);
    FragmentActivity fragmentActivity = this.cbv;
    an an = new an(this);
    this.cbH = new ax(fragmentActivity, new CharSequence[] { str }, an);
  }
  
  private void YC() {
    long l;
    if (this.cbB == null)
      throw new RuntimeException("商品分类的数据集不能为null"); 
    if (this.bMB != null) {
      l = this.bMB.getId();
    } else {
      l = -1L;
    } 
    this.bMB = null;
    if (this.cbC > this.cbD) {
      this.cbC = 1;
      n.println("超过了最大页数，重置页数为0");
    } 
    int j = this.cbx.length;
    int k = this.cbC;
    for (int i = 0; i < this.cbx.length; i++) {
      TextView textView = this.cbx[i];
      int m = i + j * (k - 1);
      if (m < this.cbB.size()) {
        a a1 = (a)this.cbB.get(m);
        textView.setVisibility(0);
        textView.setTag(a1);
        if (a1 == null) {
          textView.setTextSize(0, this.cbL * 2.0F);
          textView.setText("+");
          textView.setSelected(false);
          textView.setActivated(false);
        } else {
          if (textView.getTextSize() != this.cbL)
            textView.setTextSize(0, this.cbL); 
          textView.setText(a1.XX());
          if (l == a1.getId()) {
            textView.setSelected(true);
            this.bMB = a1;
          } else {
            textView.setSelected(false);
          } 
          textView.setActivated(true);
        } 
      } else {
        textView.setTag(null);
        textView.setVisibility(4);
      } 
    } 
    if (this.bMB == null) {
      TextView textView = this.cbx[0];
      this.bMB = (a)textView.getTag();
      if (this.bMB != null)
        textView.setSelected(true); 
    } 
    if (this.bMB == null) {
      this.cbJ.a(this.bMB);
      return;
    } 
    if (this.bMB.getId() == this.cbI) {
      u.XP();
      n.println("没有查询桌号数据，只是刷新了列表");
      this.cbJ.b(this.bMB);
    } else {
      u.XP();
      this.cbJ.a(this.bMB);
    } 
    this.cbI = this.bMB.getId();
  }
  
  public void Y(ArrayList<a> paramArrayList) { this.cbB = paramArrayList; }
  
  public ArrayList<a> YA() { return this.cbB; }
  
  public void YB() {
    this.cbJ.w((ArrayList)this.cbB.clone());
    this.cbF.setVisibility(8);
    if (this.cbK)
      if (this.cbB.isEmpty()) {
        this.cbF.setVisibility(0);
      } else {
        this.cbB.add(null);
      }  
    if (this.cbB.size() % this.cbx.length == 0) {
      this.cbD = this.cbB.size() / this.cbx.length;
    } else {
      this.cbD = this.cbB.size() / this.cbx.length + 1;
    } 
    if (this.cbD > 1) {
      this.cbG.setVisibility(0);
    } else {
      this.cbG.setVisibility(4);
      if (this.cbD == 0)
        this.cbD = 1; 
    } 
    YC();
  }
  
  public View Yx() { return this.cbw; }
  
  public void Yy() {
    int i = a.AZ().Bf();
    if (this.cbx == null || i != this.cbA) {
      ViewGroup viewGroup1;
      this.cbA = i;
      ArrayList arrayList = new ArrayList();
      if (this.cbA <= 1) {
        this.cby.setVisibility(8);
        viewGroup1 = this.cbz;
      } else {
        this.cby.setVisibility(0);
        viewGroup1 = this.cby;
      } 
      i = 0;
      for (ViewGroup viewGroup2 = viewGroup1;; viewGroup2 = viewGroup1) {
        View view2 = viewGroup2.getChildAt(i);
        viewGroup1 = viewGroup2;
        View view1 = view2;
        if (view2 == null)
          if (viewGroup2 == this.cby) {
            viewGroup1 = this.cbz;
            view1 = viewGroup1.getChildAt(0);
            i = 0;
          } else {
            this.cbx = new TextView[arrayList.size()];
            arrayList.toArray(this.cbx);
            this.cbI = -1L;
            this.cbJ.Nk();
          }  
        if (view1 instanceof TextView) {
          if (Build.VERSION.SDK_INT < 15 || !view1.hasOnClickListeners()) {
            view1.setOnClickListener(this.cbM);
            view1.setOnLongClickListener(this.cbN);
          } 
          TextView textView = (TextView)view1;
          if (this.cbL == 0.0F)
            this.cbL = textView.getTextSize(); 
          arrayList.add(textView);
        } 
        i++;
      } 
    } 
    this.cbI = -1L;
    this.cbJ.Nk();
  }
  
  public boolean Yz() { return (this.cbF.getVisibility() == 0); }
  
  public void eJ(boolean paramBoolean) { this.cbK = paramBoolean; }
  
  public void g(a parama) {
    this.bMB = parama;
    YC();
  }
  
  public static interface a {
    void Nk();
    
    void a(a param1a);
    
    void b(a param1a);
    
    void w(ArrayList<a> param1ArrayList);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\pos\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */