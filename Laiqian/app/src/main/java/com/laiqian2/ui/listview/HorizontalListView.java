package com.laiqian.ui.listview;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HorizontalListView extends AdapterView<ListAdapter> {
  private Drawable KK = null;
  
  private int Ol = 0;
  
  protected int cyh;
  
  protected int cyi;
  
  public int cyj = Integer.MAX_VALUE;
  
  private int cyk;
  
  private boolean cyq = false;
  
  protected Scroller dBX = new Scroller(getContext());
  
  private final a dBY = new a(this, null);
  
  private GestureDetector dBZ;
  
  private List<Queue<View>> dCa = new ArrayList();
  
  private View dCb = null;
  
  private Integer dCc = null;
  
  private int dCd;
  
  private int dCe;
  
  private int dCf;
  
  private c dCg = null;
  
  private int dCh = 0;
  
  private boolean dCi = false;
  
  private b dCj = null;
  
  private b.a dCk = b.a.dCt;
  
  private EdgeEffectCompat dCl;
  
  private EdgeEffectCompat dCm;
  
  private int dCn;
  
  private boolean dCo = false;
  
  private boolean dCp = false;
  
  private DataSetObserver dCq = new g(this);
  
  private Runnable dCr = new h(this);
  
  private View.OnClickListener jE;
  
  private Rect lK = new Rect();
  
  protected ListAdapter mAdapter;
  
  public HorizontalListView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.dCl = new EdgeEffectCompat(paramContext);
    this.dCm = new EdgeEffectCompat(paramContext);
    this.dBZ = new GestureDetector(paramContext, this.dBY);
    arL();
    initView();
    setWillNotDraw(false);
  }
  
  private void L(Boolean paramBoolean) {
    if (this.dCp != paramBoolean.booleanValue()) {
      HorizontalListView horizontalListView = this;
      while (horizontalListView.getParent() instanceof View) {
        if (horizontalListView.getParent() instanceof android.widget.ListView || horizontalListView.getParent() instanceof android.widget.ScrollView) {
          horizontalListView.getParent().requestDisallowInterceptTouchEvent(paramBoolean.booleanValue());
          this.dCp = paramBoolean.booleanValue();
          return;
        } 
        View view = (View)horizontalListView.getParent();
      } 
    } 
  }
  
  private void a(b.a parama) {
    if (this.dCk != parama && this.dCj != null)
      this.dCj.b(parama); 
    this.dCk = parama;
  }
  
  private void arL() { setOnTouchListener(new f(this)); }
  
  private float arM() { return 30.0F; }
  
  private boolean arN() {
    if (lf(this.dCe)) {
      View view = arP();
      if (view != null) {
        int i = this.cyj;
        this.cyj = this.cyh + view.getRight() - getPaddingLeft() - arR();
        if (this.cyj < 0)
          this.cyj = 0; 
        if (this.cyj != i)
          return true; 
      } 
    } 
    return false;
  }
  
  private View arO() { return getChildAt(0); }
  
  private View arP() { return getChildAt(getChildCount() - 1); }
  
  private int arQ() { return getHeight() - getPaddingTop() - getPaddingBottom(); }
  
  private int arR() { return getWidth() - getPaddingLeft() - getPaddingRight(); }
  
  private void arS() {
    if (this.dCb != null) {
      this.dCb.setPressed(false);
      refreshDrawableState();
      this.dCb = null;
    } 
  }
  
  private void arT() {
    if (this.dCl != null)
      this.dCl.onRelease(); 
    if (this.dCm != null)
      this.dCm.onRelease(); 
  }
  
  private void arU() {
    if (this.dCg != null && this.mAdapter != null && this.mAdapter.getCount() - this.dCe + 1 < this.dCh && !this.dCi) {
      this.dCi = true;
      this.dCg.arX();
    } 
  }
  
  private boolean arW() {
    ListAdapter listAdapter = this.mAdapter;
    boolean bool = false;
    if (listAdapter != null) {
      if (this.mAdapter.isEmpty())
        return false; 
      if (this.cyj > 0)
        bool = true; 
      return bool;
    } 
    return false;
  }
  
  private void b(Canvas paramCanvas, Rect paramRect) {
    if (this.KK != null) {
      this.KK.setBounds(paramRect);
      this.KK.draw(paramCanvas);
    } 
  }
  
  private void bh(int paramInt1, int paramInt2) {
    while (paramInt1 + paramInt2 + this.Ol < getWidth() && this.dCe + 1 < this.mAdapter.getCount()) {
      int i;
      this.dCe++;
      if (this.dCd < 0)
        this.dCd = this.dCe; 
      View view = this.mAdapter.getView(this.dCe, la(this.dCe), this);
      x(view, -1);
      if (this.dCe == 0) {
        i = 0;
      } else {
        i = this.Ol;
      } 
      paramInt1 += i + view.getMeasuredWidth();
      arU();
    } 
  }
  
  private void bi(int paramInt1, int paramInt2) {
    while (paramInt1 + paramInt2 - this.Ol > 0 && this.dCd >= 1) {
      this.dCd--;
      View view = this.mAdapter.getView(this.dCd, la(this.dCd), this);
      x(view, 0);
      if (this.dCd == 0) {
        i = view.getMeasuredWidth();
      } else {
        i = this.Ol + view.getMeasuredWidth();
      } 
      int i = paramInt1 - i;
      int j = this.cyk;
      if (i + paramInt2 == 0) {
        paramInt1 = view.getMeasuredWidth();
      } else {
        paramInt1 = this.Ol;
        paramInt1 = view.getMeasuredWidth() + paramInt1;
      } 
      this.cyk = j - paramInt1;
      paramInt1 = i;
    } 
  }
  
  private int bz(int paramInt1, int paramInt2) {
    int i = getChildCount();
    for (byte b1 = 0; b1 < i; b1++) {
      getChildAt(b1).getHitRect(this.lK);
      if (this.lK.contains(paramInt1, paramInt2))
        return b1; 
    } 
    return -1;
  }
  
  private void dr(View paramView) {
    int i;
    ViewGroup.LayoutParams layoutParams = ds(paramView);
    int j = ViewGroup.getChildMeasureSpec(this.dCn, getPaddingTop() + getPaddingBottom(), layoutParams.height);
    if (layoutParams.width > 0) {
      i = View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
    } else {
      i = View.MeasureSpec.makeMeasureSpec(0, 0);
    } 
    paramView.measure(i, j);
  }
  
  private ViewGroup.LayoutParams ds(View paramView) {
    ViewGroup.LayoutParams layoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams layoutParams1 = layoutParams2;
    if (layoutParams2 == null)
      layoutParams1 = new ViewGroup.LayoutParams(-2, -1); 
    return layoutParams1;
  }
  
  private void h(int paramInt, View paramView) {
    paramInt = this.mAdapter.getItemViewType(paramInt);
    if (lb(paramInt))
      ((Queue)this.dCa.get(paramInt)).offer(paramView); 
  }
  
  private void hk(int paramInt) {
    View view = arP();
    byte b1 = 0;
    if (view != null) {
      i = view.getRight();
    } else {
      i = 0;
    } 
    bh(i, paramInt);
    view = arO();
    int i = b1;
    if (view != null)
      i = view.getLeft(); 
    bi(i, paramInt);
  }
  
  private void initView() {
    this.dCd = -1;
    this.dCe = -1;
    this.cyk = 0;
    this.cyh = 0;
    this.cyi = 0;
    this.cyj = Integer.MAX_VALUE;
    a(b.a.dCt);
  }
  
  private void kZ(int paramInt) {
    this.dCa.clear();
    for (byte b1 = 0; b1 < paramInt; b1++)
      this.dCa.add(new LinkedList()); 
  }
  
  private View la(int paramInt) {
    paramInt = this.mAdapter.getItemViewType(paramInt);
    return lb(paramInt) ? (View)((Queue)this.dCa.get(paramInt)).poll() : null;
  }
  
  private boolean lb(int paramInt) { return (paramInt < this.dCa.size()); }
  
  private void lc(int paramInt) {
    View view;
    for (view = arO(); view != null && view.getRight() + paramInt <= 0; view = arO()) {
      int i;
      int j = this.cyk;
      if (lf(this.dCd)) {
        i = view.getMeasuredWidth();
      } else {
        i = this.Ol + view.getMeasuredWidth();
      } 
      this.cyk = j + i;
      h(this.dCd, view);
      removeViewInLayout(view);
      this.dCd++;
    } 
    for (view = arP(); view != null && view.getLeft() + paramInt >= getWidth(); view = arP()) {
      h(this.dCe, view);
      removeViewInLayout(view);
      this.dCe--;
    } 
  }
  
  private void ld(int paramInt) {
    int i = getChildCount();
    if (i > 0) {
      this.cyk += paramInt;
      int j = this.cyk;
      for (paramInt = 0; paramInt < i; paramInt++) {
        View view = getChildAt(paramInt);
        int k = getPaddingLeft() + j;
        int m = getPaddingTop();
        view.layout(k, m, view.getMeasuredWidth() + k, view.getMeasuredHeight() + m);
        j += view.getMeasuredWidth() + this.Ol;
      } 
    } 
  }
  
  private View le(int paramInt) { return (paramInt >= this.dCd && paramInt <= this.dCe) ? getChildAt(paramInt - this.dCd) : null; }
  
  private boolean lf(int paramInt) { return (paramInt == this.mAdapter.getCount() - 1); }
  
  private void lh(int paramInt) {
    if (this.dCl != null) {
      if (this.dCm == null)
        return; 
      int i = this.cyh + paramInt;
      if (this.dBX == null || this.dBX.isFinished())
        if (i < 0) {
          paramInt = Math.abs(paramInt);
          this.dCl.onPull(paramInt / arR());
          if (!this.dCm.isFinished()) {
            this.dCm.onRelease();
            return;
          } 
        } else if (i > this.cyj) {
          paramInt = Math.abs(paramInt);
          this.dCm.onPull(paramInt / arR());
          if (!this.dCl.isFinished())
            this.dCl.onRelease(); 
        }  
      return;
    } 
  }
  
  private void o(Canvas paramCanvas) {
    if (this.dCl != null && !this.dCl.isFinished() && arW()) {
      int i = paramCanvas.save();
      int j = getHeight();
      paramCanvas.rotate(-90.0F, 0.0F, 0.0F);
      paramCanvas.translate((-j + getPaddingBottom()), 0.0F);
      this.dCl.setSize(arQ(), arR());
      if (this.dCl.draw(paramCanvas))
        invalidate(); 
      paramCanvas.restoreToCount(i);
      return;
    } 
    if (this.dCm != null && !this.dCm.isFinished() && arW()) {
      int i = paramCanvas.save();
      int j = getWidth();
      paramCanvas.rotate(90.0F, 0.0F, 0.0F);
      paramCanvas.translate(getPaddingTop(), -j);
      this.dCm.setSize(arQ(), arR());
      if (this.dCm.draw(paramCanvas))
        invalidate(); 
      paramCanvas.restoreToCount(i);
    } 
  }
  
  private void p(Canvas paramCanvas) {
    int i = getChildCount();
    Rect rect = this.lK;
    this.lK.top = getPaddingTop();
    this.lK.bottom = this.lK.top + arQ();
    for (byte b1 = 0; b1 < i; b1++) {
      if (b1 != i - 1 || !lf(this.dCe)) {
        View view = getChildAt(b1);
        rect.left = view.getRight();
        rect.right = view.getRight() + this.Ol;
        if (rect.left < getPaddingLeft())
          rect.left = getPaddingLeft(); 
        if (rect.right > getWidth() - getPaddingRight())
          rect.right = getWidth() - getPaddingRight(); 
        b(paramCanvas, rect);
        if (b1 == 0 && view.getLeft() > getPaddingLeft()) {
          rect.left = getPaddingLeft();
          rect.right = view.getLeft();
          b(paramCanvas, rect);
        } 
      } 
    } 
  }
  
  private void reset() {
    initView();
    removeAllViewsInLayout();
    requestLayout();
  }
  
  private void x(View paramView, int paramInt) {
    addViewInLayout(paramView, paramInt, ds(paramView), true);
    dr(paramView);
  }
  
  public int arV() { return this.cyh; }
  
  protected void dispatchDraw(Canvas paramCanvas) {
    super.dispatchDraw(paramCanvas);
    o(paramCanvas);
  }
  
  protected void dispatchSetPressed(boolean paramBoolean) {}
  
  public ListAdapter getAdapter() { return this.mAdapter; }
  
  public int getFirstVisiblePosition() { return this.dCd; }
  
  public int getLastVisiblePosition() { return this.dCe; }
  
  protected float getLeftFadingEdgeStrength() {
    int i = getHorizontalFadingEdgeLength();
    return (this.cyh == 0) ? 0.0F : ((this.cyh < i) ? (this.cyh / i) : 1.0F);
  }
  
  protected float getRightFadingEdgeStrength() {
    int i = getHorizontalFadingEdgeLength();
    return (this.cyh == this.cyj) ? 0.0F : ((this.cyj - this.cyh < i) ? ((this.cyj - this.cyh) / i) : 1.0F);
  }
  
  public View getSelectedView() { return le(this.dCf); }
  
  public void lg(int paramInt) {
    this.dBX.startScroll(this.cyi, 0, paramInt - this.cyi, 0);
    a(b.a.dCv);
    requestLayout();
  }
  
  protected boolean onDown(MotionEvent paramMotionEvent) {
    this.dCo = this.dBX.isFinished() ^ true;
    this.dBX.forceFinished(true);
    a(b.a.dCt);
    arS();
    if (!this.dCo) {
      int i = bz((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      if (i >= 0) {
        this.dCb = getChildAt(i);
        if (this.dCb != null) {
          this.dCb.setPressed(true);
          refreshDrawableState();
        } 
      } 
    } 
    return true;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    p(paramCanvas);
  }
  
  protected boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2) {
    this.dBX.fling(this.cyi, 0, (int)-paramFloat1, 0, 0, this.cyj, 0, 0);
    a(b.a.dCv);
    requestLayout();
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mAdapter == null)
      return; 
    invalidate();
    if (this.cyq) {
      int j = this.cyh;
      initView();
      removeAllViewsInLayout();
      this.cyi = j;
      this.cyq = false;
    } 
    if (this.dCc != null) {
      this.cyi = this.dCc.intValue();
      this.dCc = null;
    } 
    if (this.dBX.computeScrollOffset())
      this.cyi = this.dBX.getCurrX(); 
    if (this.cyi < 0) {
      this.cyi = 0;
      if (this.dCl.isFinished())
        this.dCl.onAbsorb((int)arM()); 
      this.dBX.forceFinished(true);
      a(b.a.dCt);
    } else if (this.cyi > this.cyj) {
      this.cyi = this.cyj;
      if (this.dCm.isFinished())
        this.dCm.onAbsorb((int)arM()); 
      this.dBX.forceFinished(true);
      a(b.a.dCt);
    } 
    int i = this.cyh - this.cyi;
    lc(i);
    hk(i);
    ld(i);
    this.cyh = this.cyi;
    if (arN()) {
      onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    } 
    if (this.dBX.isFinished()) {
      if (this.dCk == b.a.dCv) {
        a(b.a.dCt);
        return;
      } 
    } else {
      ViewCompat.postOnAnimation(this, this.dCr);
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    this.dCn = paramInt2;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    if (paramParcelable instanceof Bundle) {
      Bundle bundle = (Bundle)paramParcelable;
      this.dCc = Integer.valueOf(bundle.getInt("BUNDLE_ID_CURRENT_X"));
      super.onRestoreInstanceState(bundle.getParcelable("BUNDLE_ID_PARENT_STATE"));
    } 
  }
  
  public Parcelable onSaveInstanceState() {
    Bundle bundle = new Bundle();
    bundle.putParcelable("BUNDLE_ID_PARENT_STATE", super.onSaveInstanceState());
    bundle.putInt("BUNDLE_ID_CURRENT_X", this.cyh);
    return bundle;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (paramMotionEvent.getAction() == 1) {
      if (this.dBX == null || this.dBX.isFinished())
        a(b.a.dCt); 
      L(Boolean.valueOf(false));
      arT();
    } else if (paramMotionEvent.getAction() == 3) {
      arS();
      arT();
      L(Boolean.valueOf(false));
    } 
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAdapter(ListAdapter paramListAdapter) {
    if (this.mAdapter != null)
      this.mAdapter.unregisterDataSetObserver(this.dCq); 
    if (paramListAdapter != null) {
      this.dCi = false;
      this.mAdapter = paramListAdapter;
      this.mAdapter.registerDataSetObserver(this.dCq);
    } 
    kZ(this.mAdapter.getViewTypeCount());
    reset();
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener) { this.jE = paramOnClickListener; }
  
  public void setSelection(int paramInt) { this.dCf = paramInt; }
  
  private class a extends GestureDetector.SimpleOnGestureListener {
    private a(HorizontalListView this$0) {}
    
    public boolean onDown(MotionEvent param1MotionEvent) { return this.dCs.onDown(param1MotionEvent); }
    
    public boolean onFling(MotionEvent param1MotionEvent1, MotionEvent param1MotionEvent2, float param1Float1, float param1Float2) { return this.dCs.onFling(param1MotionEvent1, param1MotionEvent2, param1Float1, param1Float2); }
    
    public void onLongPress(MotionEvent param1MotionEvent) {
      HorizontalListView.b(this.dCs);
      int i = HorizontalListView.a(this.dCs, (int)param1MotionEvent.getX(), (int)param1MotionEvent.getY());
      if (i >= 0 && !HorizontalListView.d(this.dCs)) {
        View view = this.dCs.getChildAt(i);
        AdapterView.OnItemLongClickListener onItemLongClickListener = this.dCs.getOnItemLongClickListener();
        if (onItemLongClickListener != null) {
          i = HorizontalListView.e(this.dCs) + i;
          if (onItemLongClickListener.onItemLongClick(this.dCs, view, i, this.dCs.mAdapter.getItemId(i)))
            this.dCs.performHapticFeedback(0); 
        } 
      } 
    }
    
    public boolean onScroll(MotionEvent param1MotionEvent1, MotionEvent param1MotionEvent2, float param1Float1, float param1Float2) {
      HorizontalListView.a(this.dCs, Boolean.valueOf(true));
      HorizontalListView.a(this.dCs, HorizontalListView.b.a.dCu);
      HorizontalListView.b(this.dCs);
      HorizontalListView horizontalListView = this.dCs;
      horizontalListView.cyi += (int)param1Float1;
      HorizontalListView.a(this.dCs, Math.round(param1Float1));
      this.dCs.requestLayout();
      return true;
    }
    
    public boolean onSingleTapConfirmed(MotionEvent param1MotionEvent) {
      HorizontalListView.b(this.dCs);
      AdapterView.OnItemClickListener onItemClickListener = this.dCs.getOnItemClickListener();
      int i = HorizontalListView.a(this.dCs, (int)param1MotionEvent.getX(), (int)param1MotionEvent.getY());
      if (i >= 0 && !HorizontalListView.d(this.dCs)) {
        View view = this.dCs.getChildAt(i);
        i = HorizontalListView.e(this.dCs) + i;
        if (onItemClickListener != null) {
          onItemClickListener.onItemClick(this.dCs, view, i, this.dCs.mAdapter.getItemId(i));
          return true;
        } 
      } 
      if (HorizontalListView.f(this.dCs) != null && !HorizontalListView.d(this.dCs))
        HorizontalListView.f(this.dCs).onClick(this.dCs); 
      return false;
    }
  }
  
  public static interface b {
    void b(a param1a);
    
    public enum a {
      dCt, dCu, dCv;
    }
  }
  
  public enum a {
    dCt, dCu, dCv;
  }
  
  public static interface c {
    void arX();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\listview\HorizontalListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */