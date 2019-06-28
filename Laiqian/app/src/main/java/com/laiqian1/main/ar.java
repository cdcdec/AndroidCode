package com.laiqian.main;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.laiqian.d.a;
import com.laiqian.product.fa;
import com.laiqian.product.models.ProductTypeEntity;
import com.laiqian.product.models.l;
import com.laiqian.ui.a.ax;
import com.laiqian.util.ay;
import com.laiqian.util.n;
import java.util.ArrayList;

public class ar {
  private ay<fa> bbA = new as(this);
  
  private View bbB;
  
  private View bbC;
  
  private ay<ax> bbD = new au(this);
  
  private long bbE;
  
  private boolean bbF;
  
  private boolean bbG;
  
  private final a bbH;
  
  private boolean bbI;
  
  private float bbJ;
  
  private View.OnClickListener bbK = new az(this);
  
  private View.OnLongClickListener bbL = new ba(this);
  
  private View bbq;
  
  private TextView[] bbr;
  
  private ViewGroup bbs;
  
  private ViewGroup bbt;
  
  private int bbu;
  
  private l bbv;
  
  private ArrayList<ProductTypeEntity> bbw;
  
  private int bbx;
  
  private int bby;
  
  private ProductTypeEntity bbz;
  
  private Activity mActivity;
  
  public ar(Activity paramActivity, View paramView, a parama) {
    this.mActivity = paramActivity;
    this.bbH = parama;
    this.bbv = new l(this.mActivity);
    this.bbv.akS();
    this.bbx = 1;
    this.bbq = View.inflate(this.mActivity, 2131427821, null);
    this.bbs = (ViewGroup)this.bbq.findViewById(2131298610);
    this.bbt = (ViewGroup)this.bbq.findViewById(2131298611);
    this.bbC = this.bbt.findViewById(2131298612);
    this.bbC.findViewById(2131298614).setOnClickListener(new aw(this));
    this.bbC.findViewById(2131298613).setOnClickListener(new ax(this));
    this.bbB = paramView;
    this.bbB.setOnClickListener(new ay(this));
  }
  
  private void Ls() {
    this.bbw = this.bbv.a(true, null);
    this.bbH.t(this.bbw);
    this.bbB.setVisibility(8);
    if (this.bbI && a.AZ().BN())
      if (this.bbw.isEmpty()) {
        this.bbF = true;
        if (!this.bbG)
          this.bbB.setVisibility(0); 
      } else {
        this.bbF = false;
        this.bbw.add(null);
      }  
    if (this.bbw.size() % this.bbr.length == 0) {
      this.bby = this.bbw.size() / this.bbr.length;
    } else {
      this.bby = this.bbw.size() / this.bbr.length + 1;
    } 
    if (this.bby > 1) {
      this.bbC.setVisibility(0);
    } else {
      this.bbC.setVisibility(4);
      if (this.bby == 0)
        this.bby = 1; 
    } 
    Lt();
  }
  
  private void Lt() {
    long l1;
    if (this.bbw == null)
      throw new RuntimeException("商品分类的数据集不能为null"); 
    if (this.bbz != null) {
      l1 = this.bbz.aSW;
    } else {
      l1 = -1L;
    } 
    this.bbz = null;
    if (this.bbx > this.bby) {
      this.bbx = 1;
      n.println("超过了最大页数，重置页数为0");
    } 
    int j = this.bbr.length;
    int k = this.bbx;
    for (int i = 0; i < this.bbr.length; i++) {
      TextView textView = this.bbr[i];
      int m = i + j * (k - 1);
      if (m < this.bbw.size()) {
        ProductTypeEntity productTypeEntity = (ProductTypeEntity)this.bbw.get(m);
        textView.setVisibility(0);
        textView.setTag(productTypeEntity);
        if (productTypeEntity == null) {
          textView.setTextSize(0, this.bbJ * 2.0F);
          textView.setText("+");
          textView.setSelected(false);
          textView.setActivated(false);
        } else {
          if (textView.getTextSize() != this.bbJ)
            textView.setTextSize(0, this.bbJ); 
          textView.setText(productTypeEntity.cUM);
          if (l1 == productTypeEntity.aSW) {
            textView.setSelected(true);
            this.bbz = productTypeEntity;
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
    if (this.bbz == null) {
      TextView textView = this.bbr[0];
      this.bbz = (ProductTypeEntity)textView.getTag();
      if (this.bbz != null)
        textView.setSelected(true); 
    } 
    if (this.bbz == null) {
      this.bbH.a(this.bbz);
      return;
    } 
    if (this.bbz.aSW == this.bbE) {
      n.println("没有查询商品数据，只是刷新了列表");
      this.bbH.b(this.bbz);
    } else {
      this.bbH.a(this.bbz);
    } 
    this.bbE = this.bbz.aSW;
  }
  
  public View Lq() { return this.bbq; }
  
  public void Lr() {
    int i = a.AZ().Bf();
    if (this.bbr == null || i != this.bbu) {
      ViewGroup viewGroup1;
      this.bbu = i;
      ArrayList arrayList = new ArrayList();
      if (this.bbu <= 1) {
        this.bbs.setVisibility(8);
        viewGroup1 = this.bbt;
      } else {
        this.bbs.setVisibility(0);
        viewGroup1 = this.bbs;
      } 
      i = 0;
      for (ViewGroup viewGroup2 = viewGroup1;; viewGroup2 = viewGroup1) {
        View view2 = viewGroup2.getChildAt(i);
        viewGroup1 = viewGroup2;
        View view1 = view2;
        if (view2 == null)
          if (viewGroup2 == this.bbs) {
            viewGroup1 = this.bbt;
            view1 = viewGroup1.getChildAt(0);
            i = 0;
          } else {
            this.bbr = new TextView[arrayList.size()];
            arrayList.toArray(this.bbr);
            this.bbE = -1L;
            Ls();
          }  
        if (view1 instanceof TextView) {
          if (Build.VERSION.SDK_INT < 15 || !view1.hasOnClickListeners()) {
            view1.setOnClickListener(this.bbK);
            view1.setOnLongClickListener(this.bbL);
          } 
          TextView textView = (TextView)view1;
          if (this.bbJ == 0.0F)
            this.bbJ = textView.getTextSize(); 
          arrayList.add(textView);
        } 
        i++;
      } 
    } 
    this.bbE = -1L;
    Ls();
  }
  
  public void closeModel() {
    if (this.bbv != null)
      this.bbv.close(); 
  }
  
  public void dg(boolean paramBoolean) { this.bbI = paramBoolean; }
  
  public void dh(boolean paramBoolean) {
    ViewGroup viewGroup = this.bbs;
    byte b = 0;
    while (true) {
      View view2 = viewGroup.getChildAt(b);
      ViewGroup viewGroup1 = viewGroup;
      View view1 = view2;
      if (view2 == null)
        if (viewGroup == this.bbs) {
          viewGroup1 = this.bbt;
          view1 = viewGroup1.getChildAt(0);
          b = 0;
        } else {
          return;
        }  
      if (view1 instanceof TextView)
        if (paramBoolean) {
          view1.setBackgroundResource(2131231365);
        } else {
          view1.setBackgroundResource(2131231366);
        }  
      b++;
      viewGroup = viewGroup1;
    } 
  }
  
  public void di(boolean paramBoolean) { this.bbG = paramBoolean; }
  
  public static interface a {
    void a(ProductTypeEntity param1ProductTypeEntity);
    
    void b(ProductTypeEntity param1ProductTypeEntity);
    
    void t(ArrayList<ProductTypeEntity> param1ArrayList);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */