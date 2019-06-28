package com.laiqian.main.module.productcart;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.laiqian.entity.aa;
import com.laiqian.product.models.c;
import com.laiqian.product.models.f;
import com.laiqian.ui.a.d;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class y extends d {
  private View bjn;
  
  protected aa bjo;
  
  private double bjp;
  
  private double bjq;
  
  protected final b bjr;
  
  protected final ArrayList<c> bjs;
  
  protected final AbsListView bjt;
  
  protected final a bju;
  
  private ArrayList<c> bjv;
  
  private boolean bjw;
  
  private f bjx;
  
  public y(Context paramContext, int paramInt, b paramb, ArrayList<c> paramArrayList) {
    super(paramContext, paramInt);
    this.bjr = paramb;
    this.bjs = paramArrayList;
    this.bjt = NK();
    this.bju = new a(this);
    this.bjt.setAdapter(this.bju);
    this.bjt.setOnItemClickListener(new z(this));
  }
  
  private void a(aa paramaa) {
    String str;
    this.bjs.clear();
    f f1 = this.bjx;
    if (paramaa == null) {
      str = "";
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str.aJx);
      stringBuilder.append("");
      str = stringBuilder.toString();
    } 
    this.bjv = f1.mB(str);
    this.bjs.addAll(this.bjv);
  }
  
  public abstract AbsListView NK();
  
  protected void NL() {}
  
  protected void NM() {
    this.bjo.GD();
    this.bjr.a(this.bjn, this.bjo, this.bjo.GJ() - this.bjp, this.bjo.GI() - this.bjq);
    dismiss();
  }
  
  protected void NN() {}
  
  public void a(View paramView, aa paramaa, String paramString) {
    if (paramaa == null) {
      n.a(this.mActivity, "编辑的商品时，商品传值为null");
      return;
    } 
    this.bjn = paramView;
    this.bjo = paramaa;
    this.bjp = paramaa.GJ();
    this.bjq = paramaa.GI();
    NL();
    this.bjx = new f(this.mActivity);
    a(paramaa);
    paramaa.m(this.bjs);
    a(paramaa, paramString);
    super.show();
  }
  
  protected void a(AdapterView<?> paramAdapterView, View paramView, int paramInt) {
    Iterator iterator;
    c c = (c)paramAdapterView.getItemAtPosition(paramInt);
    boolean bool = false;
    if (c == null) {
      if (paramInt == 0) {
        if (this.bjs.size() > 0) {
          iterator = this.bjs.iterator();
          while (iterator.hasNext())
            ((c)iterator.next()).qty = 0; 
          this.bju.notifyDataSetChanged();
          bool = true;
        } else {
          NN();
        } 
      } else {
        NN();
      } 
    } else {
      boolean bool1 = c.performClick();
      bool = bool1;
      if (bool1) {
        a.a(this.bju, (a.a)iterator.getTag(), c);
        bool = bool1;
      } 
    } 
    if (bool)
      a(c); 
  }
  
  protected abstract void a(aa paramaa, String paramString);
  
  protected void a(c paramc) {}
  
  public void dm(boolean paramBoolean) { this.bjw = paramBoolean; }
  
  @Deprecated
  public void show() { super.show(); }
  
  public class a extends BaseAdapter {
    private View bjA;
    
    private int bjB;
    
    private View bjz;
    
    a(y this$0) {
      if (y.a(this$0)) {
        this.bjA = View.inflate(y.b(this$0), 2131427825, null);
      } else {
        this.bjz = View.inflate(y.c(this$0), 2131427826, null);
      } 
      this.bjB = 1;
    }
    
    private void a(a param1a, c param1c) {
      param1a.aKu.setText(param1c.name);
      param1a.bjC.setText(param1c.cUx);
      int i = param1c.qty;
      if (i > 0) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("x");
        stringBuilder.append(i);
        String str = stringBuilder.toString();
        param1a.bjD.setText(str);
        return;
      } 
      param1a.bjD.setText("");
    }
    
    public c eY(int param1Int) { return y.a(this.bjy) ? ((param1Int >= this.bjy.bjs.size()) ? null : (c)this.bjy.bjs.get(param1Int)) : ((param1Int != 0) ? ((--param1Int >= this.bjy.bjs.size()) ? null : (c)this.bjy.bjs.get(param1Int)) : null); }
    
    public int getCount() { return this.bjy.bjs.size() + this.bjB; }
    
    public long getItemId(int param1Int) { return param1Int; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) { // Byte code:
      //   0: aload_0
      //   1: iload_1
      //   2: invokevirtual eY : (I)Lcom/laiqian/product/models/c;
      //   5: astore #5
      //   7: aload #5
      //   9: ifnonnull -> 41
      //   12: aload_0
      //   13: getfield bjy : Lcom/laiqian/main/module/productcart/y;
      //   16: invokestatic a : (Lcom/laiqian/main/module/productcart/y;)Z
      //   19: ifeq -> 27
      //   22: aload_0
      //   23: getfield bjA : Landroid/view/View;
      //   26: areturn
      //   27: iload_1
      //   28: ifne -> 36
      //   31: aload_0
      //   32: getfield bjz : Landroid/view/View;
      //   35: areturn
      //   36: aload_0
      //   37: getfield bjA : Landroid/view/View;
      //   40: areturn
      //   41: aload_2
      //   42: ifnull -> 62
      //   45: aload_2
      //   46: invokevirtual getTag : ()Ljava/lang/Object;
      //   49: checkcast com/laiqian/main/module/productcart/y$a$a
      //   52: astore #4
      //   54: aload #4
      //   56: astore_3
      //   57: aload #4
      //   59: ifnonnull -> 137
      //   62: aload_0
      //   63: getfield bjy : Lcom/laiqian/main/module/productcart/y;
      //   66: invokestatic d : (Lcom/laiqian/main/module/productcart/y;)Landroid/content/Context;
      //   69: astore_2
      //   70: aload_0
      //   71: getfield bjy : Lcom/laiqian/main/module/productcart/y;
      //   74: invokestatic a : (Lcom/laiqian/main/module/productcart/y;)Z
      //   77: ifeq -> 86
      //   80: ldc 2131427827
      //   82: istore_1
      //   83: goto -> 89
      //   86: ldc 2131427823
      //   88: istore_1
      //   89: aload_2
      //   90: iload_1
      //   91: aconst_null
      //   92: invokestatic inflate : (Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
      //   95: astore_2
      //   96: new com/laiqian/main/module/productcart/y$a$a
      //   99: dup
      //   100: aload_0
      //   101: aload_2
      //   102: ldc 2131298198
      //   104: invokevirtual findViewById : (I)Landroid/view/View;
      //   107: checkcast android/widget/TextView
      //   110: aload_2
      //   111: ldc 2131299967
      //   113: invokevirtual findViewById : (I)Landroid/view/View;
      //   116: checkcast android/widget/TextView
      //   119: aload_2
      //   120: ldc 2131298641
      //   122: invokevirtual findViewById : (I)Landroid/view/View;
      //   125: checkcast android/widget/TextView
      //   128: invokespecial <init> : (Lcom/laiqian/main/module/productcart/y$a;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;)V
      //   131: astore_3
      //   132: aload_2
      //   133: aload_3
      //   134: invokevirtual setTag : (Ljava/lang/Object;)V
      //   137: aload_0
      //   138: aload_3
      //   139: aload #5
      //   141: invokespecial a : (Lcom/laiqian/main/module/productcart/y$a$a;Lcom/laiqian/product/models/c;)V
      //   144: aload_2
      //   145: areturn }
    
    class a {
      TextView aKu;
      
      TextView bjC;
      
      TextView bjD;
      
      public a(y.a this$0, TextView param2TextView1, TextView param2TextView2, TextView param2TextView3) {
        this.aKu = param2TextView1;
        this.bjC = param2TextView2;
        this.bjD = param2TextView3;
      }
    }
  }
  
  class a {
    TextView aKu;
    
    TextView bjC;
    
    TextView bjD;
    
    public a(y this$0, TextView param1TextView1, TextView param1TextView2, TextView param1TextView3) {
      this.aKu = param1TextView1;
      this.bjC = param1TextView2;
      this.bjD = param1TextView3;
    }
  }
  
  public static interface b {
    void NJ();
    
    void a(View param1View, aa param1aa, double param1Double1, double param1Double2);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\productcart\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */