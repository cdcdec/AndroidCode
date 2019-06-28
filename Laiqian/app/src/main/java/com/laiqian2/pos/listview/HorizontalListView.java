package com.laiqian.pos.listview;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import com.laiqian.util.bb;
import java.util.LinkedList;
import java.util.Queue;

public class HorizontalListView extends AdapterView<ListAdapter> {
  public boolean cye = true;
  
  private int cyf = -1;
  
  private int cyg = 0;
  
  protected int cyh;
  
  protected int cyi;
  
  private int cyj = Integer.MAX_VALUE;
  
  private int cyk = 0;
  
  private GestureDetector cyl;
  
  private Queue<View> cym = new LinkedList();
  
  private AdapterView.OnItemSelectedListener cyn;
  
  private AdapterView.OnItemClickListener cyo;
  
  private AdapterView.OnItemLongClickListener cyp;
  
  private boolean cyq = false;
  
  private DataSetObserver cyr = new a(this);
  
  private GestureDetector.OnGestureListener cys = new c(this);
  
  int cyt = 0;
  
  int cyu = -1;
  
  protected ListAdapter mAdapter;
  
  protected Scroller mScroller;
  
  public HorizontalListView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  private void bh(int paramInt1, int paramInt2) {
    while (paramInt1 + paramInt2 < getWidth() && this.cyg < this.mAdapter.getCount()) {
      View view = this.mAdapter.getView(this.cyg, (View)this.cym.poll(), this);
      x(view, -1);
      paramInt1 += view.getMeasuredWidth();
      if (this.cyg == this.mAdapter.getCount() - 1)
        this.cyj = this.cyh + paramInt1 - getWidth(); 
      if (this.cyj < 0)
        this.cyj = 0; 
      this.cyg++;
      this.cyu++;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("fillListRight   nLastVisiblePosition   ");
      stringBuilder.append(this.cyu);
      bb.ao(stringBuilder.toString());
    } 
  }
  
  private void bi(int paramInt1, int paramInt2) {
    while (paramInt1 + paramInt2 > 0 && this.cyf >= 0) {
      View view = this.mAdapter.getView(this.cyf, (View)this.cym.poll(), this);
      x(view, 0);
      paramInt1 -= view.getMeasuredWidth();
      this.cyf--;
      this.cyk -= view.getMeasuredWidth();
      this.cyt--;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("fillListLeft   FirstVisiblePosition   ");
      stringBuilder.append(this.cyt);
      bb.ao(stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("fillListLeft   nLastVisiblePosition   ");
      stringBuilder.append(this.cyu);
      bb.ao(stringBuilder.toString());
    } 
  }
  
  private void hk(int paramInt) {
    View view = getChildAt(getChildCount() - 1);
    byte b = 0;
    if (view != null) {
      i = view.getRight();
    } else {
      i = 0;
    } 
    bh(i, paramInt);
    view = getChildAt(0);
    int i = b;
    if (view != null)
      i = view.getLeft(); 
    bi(i, paramInt);
  }
  
  private void hl(int paramInt) {
    View view = getChildAt(0);
    while (view != null && view.getRight() + paramInt <= 0) {
      this.cyk += view.getMeasuredWidth();
      this.cym.offer(view);
      removeViewInLayout(view);
      this.cyf++;
      view = getChildAt(0);
      this.cyt++;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("removeNonVisibleItems  FirstVisiblePosition   ");
      stringBuilder.append(this.cyt);
      bb.ao(stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("removeNonVisibleItems   nLastVisiblePosition   ");
      stringBuilder.append(this.cyu);
      bb.ao(stringBuilder.toString());
    } 
    view = getChildAt(getChildCount() - 1);
    while (view != null && view.getLeft() + paramInt >= getWidth()) {
      this.cym.offer(view);
      removeViewInLayout(view);
      this.cyg--;
      view = getChildAt(getChildCount() - 1);
      this.cyu--;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("removeNonVisibleItems   nLastVisiblePosition   ");
      stringBuilder.append(this.cyu);
      bb.ao(stringBuilder.toString());
    } 
  }
  
  private void hm(int paramInt) {
    if (getChildCount() > 0) {
      this.cyk += paramInt;
      int i = this.cyk;
      for (paramInt = 0; paramInt < getChildCount(); paramInt++) {
        View view = getChildAt(paramInt);
        int j = view.getMeasuredWidth();
        view.layout(i, 0, i + j, view.getMeasuredHeight());
        i += j + view.getPaddingRight();
      } 
    } 
  }
  
  private void initView() { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_m1
    //   4: putfield cyf : I
    //   7: aload_0
    //   8: iconst_0
    //   9: putfield cyg : I
    //   12: aload_0
    //   13: iconst_0
    //   14: putfield cyk : I
    //   17: aload_0
    //   18: iconst_0
    //   19: putfield cyh : I
    //   22: aload_0
    //   23: iconst_0
    //   24: putfield cyi : I
    //   27: aload_0
    //   28: ldc 2147483647
    //   30: putfield cyj : I
    //   33: aload_0
    //   34: new android/widget/Scroller
    //   37: dup
    //   38: aload_0
    //   39: invokevirtual getContext : ()Landroid/content/Context;
    //   42: invokespecial <init> : (Landroid/content/Context;)V
    //   45: putfield mScroller : Landroid/widget/Scroller;
    //   48: aload_0
    //   49: new android/view/GestureDetector
    //   52: dup
    //   53: aload_0
    //   54: invokevirtual getContext : ()Landroid/content/Context;
    //   57: aload_0
    //   58: getfield cys : Landroid/view/GestureDetector$OnGestureListener;
    //   61: invokespecial <init> : (Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;)V
    //   64: putfield cyl : Landroid/view/GestureDetector;
    //   67: aload_0
    //   68: monitorexit
    //   69: return
    //   70: astore_1
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    // Exception table:
    //   from	to	target	type
    //   2	67	70	finally }
  
  private void reset() { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial initView : ()V
    //   6: aload_0
    //   7: invokevirtual removeAllViewsInLayout : ()V
    //   10: aload_0
    //   11: invokevirtual requestLayout : ()V
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: astore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	17	finally }
  
  private void x(View paramView, int paramInt) {
    ViewGroup.LayoutParams layoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams layoutParams1 = layoutParams2;
    if (layoutParams2 == null)
      layoutParams1 = new ViewGroup.LayoutParams(-1, -1); 
    addViewInLayout(paramView, paramInt, layoutParams1, true);
    paramView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), -2147483648), View.MeasureSpec.makeMeasureSpec(getHeight(), -2147483648));
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    return this.cyl.onTouchEvent(paramMotionEvent) | bool;
  }
  
  public ListAdapter getAdapter() { return this.mAdapter; }
  
  public int getFirstVisiblePosition() { return this.cyt; }
  
  public int getLastVisiblePosition() { return this.cyu; }
  
  public View getSelectedView() { return null; }
  
  protected boolean onDown(MotionEvent paramMotionEvent) {
    this.mScroller.forceFinished(true);
    return true;
  }
  
  protected boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mScroller : Landroid/widget/Scroller;
    //   6: aload_0
    //   7: getfield cyi : I
    //   10: iconst_0
    //   11: fload_3
    //   12: fneg
    //   13: f2i
    //   14: iconst_0
    //   15: iconst_0
    //   16: aload_0
    //   17: getfield cyj : I
    //   20: iconst_0
    //   21: iconst_0
    //   22: invokevirtual fling : (IIIIIIII)V
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_0
    //   28: invokevirtual requestLayout : ()V
    //   31: iconst_1
    //   32: ireturn
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Exception table:
    //   from	to	target	type
    //   2	27	33	finally
    //   34	36	33	finally }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: iload_2
    //   5: iload_3
    //   6: iload #4
    //   8: iload #5
    //   10: invokespecial onLayout : (ZIIII)V
    //   13: aload_0
    //   14: getfield mAdapter : Landroid/widget/ListAdapter;
    //   17: astore #6
    //   19: aload #6
    //   21: ifnonnull -> 27
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_0
    //   28: getfield cyq : Z
    //   31: ifeq -> 57
    //   34: aload_0
    //   35: getfield cyh : I
    //   38: istore_2
    //   39: aload_0
    //   40: invokespecial initView : ()V
    //   43: aload_0
    //   44: invokevirtual removeAllViewsInLayout : ()V
    //   47: aload_0
    //   48: iload_2
    //   49: putfield cyi : I
    //   52: aload_0
    //   53: iconst_0
    //   54: putfield cyq : Z
    //   57: aload_0
    //   58: getfield mScroller : Landroid/widget/Scroller;
    //   61: invokevirtual computeScrollOffset : ()Z
    //   64: ifeq -> 78
    //   67: aload_0
    //   68: aload_0
    //   69: getfield mScroller : Landroid/widget/Scroller;
    //   72: invokevirtual getCurrX : ()I
    //   75: putfield cyi : I
    //   78: aload_0
    //   79: getfield cyi : I
    //   82: ifgt -> 98
    //   85: aload_0
    //   86: iconst_0
    //   87: putfield cyi : I
    //   90: aload_0
    //   91: getfield mScroller : Landroid/widget/Scroller;
    //   94: iconst_1
    //   95: invokevirtual forceFinished : (Z)V
    //   98: aload_0
    //   99: getfield cyi : I
    //   102: aload_0
    //   103: getfield cyj : I
    //   106: if_icmplt -> 125
    //   109: aload_0
    //   110: aload_0
    //   111: getfield cyj : I
    //   114: putfield cyi : I
    //   117: aload_0
    //   118: getfield mScroller : Landroid/widget/Scroller;
    //   121: iconst_1
    //   122: invokevirtual forceFinished : (Z)V
    //   125: aload_0
    //   126: getfield cyh : I
    //   129: aload_0
    //   130: getfield cyi : I
    //   133: isub
    //   134: istore_2
    //   135: aload_0
    //   136: iload_2
    //   137: invokespecial hl : (I)V
    //   140: aload_0
    //   141: iload_2
    //   142: invokespecial hk : (I)V
    //   145: aload_0
    //   146: iload_2
    //   147: invokespecial hm : (I)V
    //   150: aload_0
    //   151: aload_0
    //   152: getfield cyi : I
    //   155: putfield cyh : I
    //   158: aload_0
    //   159: getfield mScroller : Landroid/widget/Scroller;
    //   162: invokevirtual isFinished : ()Z
    //   165: ifne -> 181
    //   168: aload_0
    //   169: new com/laiqian/pos/listview/b
    //   172: dup
    //   173: aload_0
    //   174: invokespecial <init> : (Lcom/laiqian/pos/listview/HorizontalListView;)V
    //   177: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   180: pop
    //   181: aload_0
    //   182: monitorexit
    //   183: return
    //   184: astore #6
    //   186: aload_0
    //   187: monitorexit
    //   188: aload #6
    //   190: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	184	finally
    //   27	57	184	finally
    //   57	78	184	finally
    //   78	98	184	finally
    //   98	125	184	finally
    //   125	181	184	finally }
  
  public void setAdapter(ListAdapter paramListAdapter) {
    if (this.mAdapter != null)
      this.mAdapter.unregisterDataSetObserver(this.cyr); 
    this.mAdapter = paramListAdapter;
    this.mAdapter.registerDataSetObserver(this.cyr);
    reset();
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener) { this.cyo = paramOnItemClickListener; }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener) { this.cyp = paramOnItemLongClickListener; }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener) { this.cyn = paramOnItemSelectedListener; }
  
  public void setSelection(int paramInt) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\listview\HorizontalListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */