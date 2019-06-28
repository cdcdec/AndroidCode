package com.laiqian.main.b;

import android.view.View;
import android.widget.TextView;
import com.laiqian.entity.v;
import java.util.Iterator;
import java.util.List;

public class c {
  public static final c bpu = new c(null, null, null);
  
  public TextView aKu;
  
  public int aTc;
  
  public String aTd;
  
  public long aTe;
  
  public int aTv;
  
  public boolean bpq;
  
  public boolean bpr;
  
  public TextView bpt;
  
  View.OnClickListener clickPayTypeItem;
  
  a payItemViewSelected;
  
  public View view;
  
  public c(View paramView, TextView paramTextView1, TextView paramTextView2) {
    this.view = paramView;
    this.bpt = paramTextView1;
    this.aKu = paramTextView2;
  }
  
  public c(View paramView, TextView paramTextView1, TextView paramTextView2, View.OnClickListener paramOnClickListener) {
    this.view = paramView;
    this.bpt = paramTextView1;
    this.aKu = paramTextView2;
    this.clickPayTypeItem = paramOnClickListener;
    this.view.setOnClickListener(paramOnClickListener);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, a parama) {
    if (this.view.getVisibility() == 0 && !paramBoolean2) {
      this.view.setSelected(paramBoolean1);
      if (paramBoolean1)
        parama.a(this); 
    } 
  }
  
  private boolean a(int paramInt, List<v> paramList) {
    if (paramInt == 10013)
      return true; 
    Iterator iterator = paramList.iterator();
    while (iterator.hasNext()) {
      if (((v)iterator.next()).aSX == paramInt)
        return true; 
    } 
    return false;
  }
  
  public static final boolean f(c paramc) {
    boolean bool = true;
    if (paramc == null)
      return true; 
    if (paramc.aTc != 0) {
      if (paramc.view == null)
        return true; 
      bool = false;
    } 
    return bool;
  }
  
  public void Pm() { this.view.setOnClickListener(this.clickPayTypeItem); }
  
  public void a(int paramInt1, int paramInt2, String paramString1, long paramLong, int paramInt3, String paramString2) { // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: putfield aTv : I
    //   5: aload_0
    //   6: getfield bpt : Landroid/widget/TextView;
    //   9: iload_2
    //   10: invokevirtual setBackgroundResource : (I)V
    //   13: aload_0
    //   14: getfield bpt : Landroid/widget/TextView;
    //   17: invokevirtual getText : ()Ljava/lang/CharSequence;
    //   20: invokeinterface length : ()I
    //   25: ifle -> 37
    //   28: aload_0
    //   29: getfield bpt : Landroid/widget/TextView;
    //   32: ldc ''
    //   34: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   37: aload_0
    //   38: getfield aKu : Landroid/widget/TextView;
    //   41: aload_3
    //   42: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   45: aload_0
    //   46: lload #4
    //   48: putfield aTe : J
    //   51: aload_0
    //   52: iload #6
    //   54: putfield aTc : I
    //   57: aload_0
    //   58: aload #7
    //   60: putfield aTd : Ljava/lang/String;
    //   63: aload_0
    //   64: getfield view : Landroid/view/View;
    //   67: aload_0
    //   68: invokevirtual setTag : (Ljava/lang/Object;)V
    //   71: aload_0
    //   72: getfield view : Landroid/view/View;
    //   75: iconst_0
    //   76: invokevirtual setVisibility : (I)V
    //   79: iconst_1
    //   80: istore #9
    //   82: iload_1
    //   83: sipush #10007
    //   86: if_icmpne -> 96
    //   89: lload #4
    //   91: lconst_1
    //   92: lcmp
    //   93: ifeq -> 112
    //   96: iload_1
    //   97: sipush #10009
    //   100: if_icmpne -> 118
    //   103: lload #4
    //   105: ldc2_w 5
    //   108: lcmp
    //   109: ifne -> 118
    //   112: iconst_1
    //   113: istore #8
    //   115: goto -> 121
    //   118: iconst_0
    //   119: istore #8
    //   121: aload_0
    //   122: iload #8
    //   124: putfield bpq : Z
    //   127: iload_1
    //   128: sipush #10007
    //   131: if_icmpne -> 145
    //   134: iload #9
    //   136: istore #8
    //   138: lload #4
    //   140: lconst_0
    //   141: lcmp
    //   142: ifeq -> 171
    //   145: iload_1
    //   146: sipush #10009
    //   149: if_icmpne -> 168
    //   152: lload #4
    //   154: ldc2_w 8
    //   157: lcmp
    //   158: ifne -> 168
    //   161: iload #9
    //   163: istore #8
    //   165: goto -> 171
    //   168: iconst_0
    //   169: istore #8
    //   171: aload_0
    //   172: iload #8
    //   174: putfield bpr : Z
    //   177: return }
  
  public void a(int paramInt, String paramString, long paramLong) {
    this.aTv = 10013;
    this.bpt.setBackgroundResource(2131231523);
    this.bpt.setTextColor(paramInt);
    this.bpt.setText(String.valueOf(paramString.charAt(0)));
    this.aKu.setText(paramString);
    this.aTd = paramString;
    this.aTe = paramLong;
    this.aTc = 2131626884;
    this.view.setTag(this);
    this.view.setVisibility(0);
    this.bpq = false;
  }
  
  public void a(int paramInt, List<v> paramList, a parama) {
    if (this.view.getVisibility() == 0) {
      boolean bool;
      if (this.aTv == 10013) {
        bool = a(paramInt, paramList);
      } else if (this.aTv == paramInt) {
        bool = true;
      } else {
        bool = false;
      } 
      a(bool, false, parama);
    } 
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener) { this.view.setOnClickListener(paramOnClickListener); }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("PayTypeItemView{payTypeID=");
    stringBuilder.append(this.aTv);
    stringBuilder.append(", specificPayTypeID=");
    stringBuilder.append(this.aTe);
    stringBuilder.append(", paidString='");
    stringBuilder.append(this.aTd);
    stringBuilder.append('\'');
    stringBuilder.append(", submitButtonStringID=");
    stringBuilder.append(this.aTc);
    stringBuilder.append(", isBarcodePay=");
    stringBuilder.append(this.bpq);
    stringBuilder.append(", isQRCodePay=");
    stringBuilder.append(this.bpr);
    stringBuilder.append(", view=");
    stringBuilder.append(this.view);
    stringBuilder.append(", icon=");
    stringBuilder.append(this.bpt);
    stringBuilder.append(", name=");
    stringBuilder.append(this.aKu);
    stringBuilder.append(", clickPayTypeItem=");
    stringBuilder.append(this.clickPayTypeItem);
    stringBuilder.append(", payItemViewSelected=");
    stringBuilder.append(this.payItemViewSelected);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public static interface a {
    void a(c param1c);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */