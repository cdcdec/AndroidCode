package com.laiqian.ui.stickylistheaders;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;

@SuppressLint({"NewApi"})
public class StickyListHeadersListView extends ListView implements View.OnClickListener, AbsListView.OnScrollListener {
  private b adapter;
  
  private boolean areHeadersSticky = true;
  
  private boolean clipToPaddingHasBeenSet;
  
  private boolean clippingToPadding;
  
  private Long currentHeaderId = null;
  
  private boolean dataChanged = false;
  
  private DataSetObserver dataSetChangedObserver = new d(this);
  
  private Drawable divider;
  
  private int dividerHeight;
  
  private boolean drawSelectorOnTop;
  
  private boolean drawingListUnderStickyHeader = true;
  
  private ArrayList<View> footerViews;
  
  private StickyListHeadersListViewWrapper frame;
  
  private int headerPosition;
  
  private AbsListView.MultiChoiceModeListener multiChoiceModeListenerDelegate;
  
  private AbsListView.MultiChoiceModeListener multiChoiceModeListenerWrapper;
  
  private int offsetToSetWhenAdapterIsReady = 0;
  
  private a onHeaderClickListener;
  
  private AdapterView.OnItemLongClickListener onItemLongClickListenerDelegate;
  
  private AdapterView.OnItemLongClickListener onItemLongClickListenerWrapper = new e(this);
  
  private int positionToSetWhenAdapterIsReady = 0;
  
  private AbsListView.OnScrollListener scrollListener;
  
  public StickyListHeadersListView(Context paramContext) { this(paramContext, null); }
  
  public StickyListHeadersListView(Context paramContext, AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, 16842868); }
  
  public StickyListHeadersListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    super.setOnScrollListener(this);
    super.setDivider(null);
    super.setDividerHeight(0);
    setVerticalFadingEdgeEnabled(false);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16843004 }, paramInt, 0);
    this.drawSelectorOnTop = typedArray.getBoolean(0, false);
    typedArray.recycle();
    if (Build.VERSION.SDK_INT >= 11)
      setMultiChoiceModeListenerWrapper(); 
  }
  
  private int getFixedFirstVisibleItem(int paramInt) {
    int i;
    if (Build.VERSION.SDK_INT >= 11)
      return paramInt; 
    int j = 0;
    while (true) {
      i = paramInt;
      if (j < getChildCount()) {
        if (getChildAt(j).getBottom() >= 0) {
          i = paramInt + j;
          break;
        } 
        j++;
        continue;
      } 
      break;
    } 
    paramInt = i;
    if (!this.clippingToPadding) {
      paramInt = i;
      if (getPaddingTop() > 0) {
        paramInt = i;
        if (getChildAt(0).getTop() > 0) {
          paramInt = i;
          if (i > 0)
            paramInt = i - 1; 
        } 
      } 
    } 
    return paramInt;
  }
  
  private boolean isCalledFromSuper() {
    StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[5];
    return (stackTraceElement.getClassName().contains("android.widget.AbsListView") || stackTraceElement.getClassName().contains("android.widget.ListView") || stackTraceElement.getClassName().contains("android.widget.FastScroller"));
  }
  
  private void scrollChanged(int paramInt) { // Byte code:
    //   0: aload_0
    //   1: getfield adapter : Lcom/laiqian/ui/stickylistheaders/b;
    //   4: ifnull -> 607
    //   7: aload_0
    //   8: getfield frame : Lcom/laiqian/ui/stickylistheaders/StickyListHeadersListViewWrapper;
    //   11: ifnonnull -> 15
    //   14: return
    //   15: aload_0
    //   16: getfield adapter : Lcom/laiqian/ui/stickylistheaders/b;
    //   19: invokevirtual getCount : ()I
    //   22: istore_2
    //   23: iload_2
    //   24: ifeq -> 598
    //   27: aload_0
    //   28: getfield areHeadersSticky : Z
    //   31: ifne -> 37
    //   34: goto -> 598
    //   37: aload_0
    //   38: invokevirtual getHeaderViewsCount : ()I
    //   41: istore #10
    //   43: aload_0
    //   44: iload_1
    //   45: invokespecial getFixedFirstVisibleItem : (I)I
    //   48: iload #10
    //   50: isub
    //   51: istore #11
    //   53: iconst_0
    //   54: istore #9
    //   56: iload #11
    //   58: iflt -> 557
    //   61: iload #11
    //   63: iload_2
    //   64: iconst_1
    //   65: isub
    //   66: if_icmple -> 72
    //   69: goto -> 557
    //   72: aload_0
    //   73: getfield adapter : Lcom/laiqian/ui/stickylistheaders/b;
    //   76: iload #11
    //   78: invokevirtual gZ : (I)J
    //   81: lstore #13
    //   83: aload_0
    //   84: getfield currentHeaderId : Ljava/lang/Long;
    //   87: ifnull -> 111
    //   90: aload_0
    //   91: getfield currentHeaderId : Ljava/lang/Long;
    //   94: invokevirtual longValue : ()J
    //   97: lload #13
    //   99: lcmp
    //   100: ifeq -> 106
    //   103: goto -> 111
    //   106: iconst_0
    //   107: istore_3
    //   108: goto -> 158
    //   111: aload_0
    //   112: iload #11
    //   114: putfield headerPosition : I
    //   117: aload_0
    //   118: getfield adapter : Lcom/laiqian/ui/stickylistheaders/b;
    //   121: aload_0
    //   122: getfield headerPosition : I
    //   125: aload_0
    //   126: getfield frame : Lcom/laiqian/ui/stickylistheaders/StickyListHeadersListViewWrapper;
    //   129: invokevirtual asl : ()Landroid/view/View;
    //   132: aload_0
    //   133: getfield frame : Lcom/laiqian/ui/stickylistheaders/StickyListHeadersListViewWrapper;
    //   136: invokevirtual a : (ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    //   139: astore #15
    //   141: aload #15
    //   143: aload_0
    //   144: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   147: aload_0
    //   148: getfield frame : Lcom/laiqian/ui/stickylistheaders/StickyListHeadersListViewWrapper;
    //   151: aload #15
    //   153: invokevirtual dw : (Landroid/view/View;)V
    //   156: iconst_1
    //   157: istore_3
    //   158: aload_0
    //   159: lload #13
    //   161: invokestatic valueOf : (J)Ljava/lang/Long;
    //   164: putfield currentHeaderId : Ljava/lang/Long;
    //   167: aload_0
    //   168: invokevirtual getChildCount : ()I
    //   171: istore #12
    //   173: iload #12
    //   175: ifle -> 556
    //   178: aconst_null
    //   179: astore #15
    //   181: iconst_0
    //   182: istore #4
    //   184: iconst_0
    //   185: istore #5
    //   187: ldc 2147483647
    //   189: istore #6
    //   191: iload #4
    //   193: iload #12
    //   195: if_icmpge -> 377
    //   198: aload_0
    //   199: iload #4
    //   201: invokevirtual getChildAt : (I)Landroid/view/View;
    //   204: astore #17
    //   206: aload_0
    //   207: getfield footerViews : Ljava/util/ArrayList;
    //   210: ifnull -> 230
    //   213: aload_0
    //   214: getfield footerViews : Ljava/util/ArrayList;
    //   217: aload #17
    //   219: invokevirtual contains : (Ljava/lang/Object;)Z
    //   222: ifeq -> 230
    //   225: iconst_1
    //   226: istore_1
    //   227: goto -> 232
    //   230: iconst_0
    //   231: istore_1
    //   232: aload_0
    //   233: getfield clippingToPadding : Z
    //   236: ifeq -> 253
    //   239: aload #17
    //   241: invokevirtual getTop : ()I
    //   244: aload_0
    //   245: invokevirtual getPaddingTop : ()I
    //   248: isub
    //   249: istore_2
    //   250: goto -> 259
    //   253: aload #17
    //   255: invokevirtual getTop : ()I
    //   258: istore_2
    //   259: iload_2
    //   260: ifge -> 278
    //   263: aload #15
    //   265: astore #16
    //   267: iload #5
    //   269: istore #8
    //   271: iload #6
    //   273: istore #7
    //   275: goto -> 356
    //   278: aload #15
    //   280: ifnull -> 346
    //   283: iload #5
    //   285: ifne -> 300
    //   288: aload_0
    //   289: getfield adapter : Lcom/laiqian/ui/stickylistheaders/b;
    //   292: aload #15
    //   294: invokevirtual dv : (Landroid/view/View;)Z
    //   297: ifeq -> 346
    //   300: iload_1
    //   301: ifne -> 328
    //   304: aload #15
    //   306: astore #16
    //   308: iload #5
    //   310: istore #8
    //   312: iload #6
    //   314: istore #7
    //   316: aload_0
    //   317: getfield adapter : Lcom/laiqian/ui/stickylistheaders/b;
    //   320: aload #17
    //   322: invokevirtual dv : (Landroid/view/View;)Z
    //   325: ifeq -> 356
    //   328: aload #15
    //   330: astore #16
    //   332: iload #5
    //   334: istore #8
    //   336: iload #6
    //   338: istore #7
    //   340: iload_2
    //   341: iload #6
    //   343: if_icmpge -> 356
    //   346: aload #17
    //   348: astore #16
    //   350: iload_2
    //   351: istore #7
    //   353: iload_1
    //   354: istore #8
    //   356: iload #4
    //   358: iconst_1
    //   359: iadd
    //   360: istore #4
    //   362: aload #16
    //   364: astore #15
    //   366: iload #8
    //   368: istore #5
    //   370: iload #7
    //   372: istore #6
    //   374: goto -> 191
    //   377: aload_0
    //   378: getfield frame : Lcom/laiqian/ui/stickylistheaders/StickyListHeadersListViewWrapper;
    //   381: invokevirtual asn : ()I
    //   384: istore_2
    //   385: aload #15
    //   387: ifnull -> 510
    //   390: iload #5
    //   392: ifne -> 407
    //   395: aload_0
    //   396: getfield adapter : Lcom/laiqian/ui/stickylistheaders/b;
    //   399: aload #15
    //   401: invokevirtual dv : (Landroid/view/View;)Z
    //   404: ifeq -> 510
    //   407: iload #11
    //   409: iload #10
    //   411: if_icmpne -> 438
    //   414: aload_0
    //   415: iconst_0
    //   416: invokevirtual getChildAt : (I)Landroid/view/View;
    //   419: invokevirtual getTop : ()I
    //   422: ifle -> 438
    //   425: aload_0
    //   426: getfield clippingToPadding : Z
    //   429: ifne -> 438
    //   432: iload #9
    //   434: istore_1
    //   435: goto -> 529
    //   438: aload_0
    //   439: getfield clippingToPadding : Z
    //   442: ifeq -> 486
    //   445: aload #15
    //   447: invokevirtual getTop : ()I
    //   450: aload_0
    //   451: invokevirtual getPaddingTop : ()I
    //   454: iload_2
    //   455: iadd
    //   456: invokestatic min : (II)I
    //   459: istore #4
    //   461: iload #4
    //   463: istore_1
    //   464: iload #4
    //   466: aload_0
    //   467: invokevirtual getPaddingTop : ()I
    //   470: if_icmpge -> 483
    //   473: iload_2
    //   474: aload_0
    //   475: invokevirtual getPaddingTop : ()I
    //   478: iadd
    //   479: istore_1
    //   480: goto -> 529
    //   483: goto -> 529
    //   486: aload #15
    //   488: invokevirtual getTop : ()I
    //   491: iload_2
    //   492: invokestatic min : (II)I
    //   495: istore #4
    //   497: iload #4
    //   499: istore_1
    //   500: iload #4
    //   502: ifge -> 483
    //   505: iload_2
    //   506: istore_1
    //   507: goto -> 529
    //   510: iload_2
    //   511: istore_1
    //   512: aload_0
    //   513: getfield clippingToPadding : Z
    //   516: ifeq -> 529
    //   519: iload_2
    //   520: aload_0
    //   521: invokevirtual getPaddingTop : ()I
    //   524: iadd
    //   525: istore_1
    //   526: goto -> 529
    //   529: aload_0
    //   530: getfield frame : Lcom/laiqian/ui/stickylistheaders/StickyListHeadersListViewWrapper;
    //   533: invokevirtual aso : ()I
    //   536: iload_1
    //   537: if_icmpne -> 544
    //   540: iload_3
    //   541: ifeq -> 552
    //   544: aload_0
    //   545: getfield frame : Lcom/laiqian/ui/stickylistheaders/StickyListHeadersListViewWrapper;
    //   548: iload_1
    //   549: invokevirtual lq : (I)V
    //   552: aload_0
    //   553: invokespecial updateHeaderVisibilities : ()V
    //   556: return
    //   557: aload_0
    //   558: getfield currentHeaderId : Ljava/lang/Long;
    //   561: ifnonnull -> 571
    //   564: aload_0
    //   565: getfield dataChanged : Z
    //   568: ifeq -> 597
    //   571: aload_0
    //   572: aconst_null
    //   573: putfield currentHeaderId : Ljava/lang/Long;
    //   576: aload_0
    //   577: getfield frame : Lcom/laiqian/ui/stickylistheaders/StickyListHeadersListViewWrapper;
    //   580: invokevirtual asl : ()Landroid/view/View;
    //   583: pop
    //   584: aload_0
    //   585: invokespecial updateHeaderVisibilities : ()V
    //   588: aload_0
    //   589: invokevirtual invalidate : ()V
    //   592: aload_0
    //   593: iconst_0
    //   594: putfield dataChanged : Z
    //   597: return
    //   598: aload_0
    //   599: getfield frame : Lcom/laiqian/ui/stickylistheaders/StickyListHeadersListViewWrapper;
    //   602: invokevirtual asl : ()Landroid/view/View;
    //   605: pop
    //   606: return
    //   607: return }
  
  private void setMultiChoiceModeListenerWrapper() { this.multiChoiceModeListenerWrapper = new g(this); }
  
  private void updateHeaderVisibilities() {
    boolean bool;
    if (this.clippingToPadding) {
      bool = getPaddingTop();
    } else {
      bool = false;
    } 
    int i = getChildCount();
    for (byte b1 = 0; b1 < i; b1++) {
      View view = getChildAt(b1);
      if (this.adapter.dv(view))
        if (view.getTop() < bool) {
          if (view.getVisibility() != 4)
            view.setVisibility(4); 
        } else if (view.getVisibility() != 0) {
          view.setVisibility(0);
        }  
    } 
  }
  
  public void addFooterView(View paramView) {
    super.addFooterView(paramView);
    if (this.footerViews == null)
      this.footerViews = new ArrayList(); 
    this.footerViews.add(paramView);
  }
  
  protected void dispatchDraw(Canvas paramCanvas) {
    if (Build.VERSION.SDK_INT < 8)
      post(new f(this)); 
    if (!this.drawingListUnderStickyHeader)
      paramCanvas.clipRect(0, Math.max(this.frame.aso(), 0), paramCanvas.getWidth(), paramCanvas.getHeight()); 
    super.dispatchDraw(paramCanvas);
  }
  
  public boolean getAreHeadersSticky() { return this.areHeadersSticky; }
  
  public int getCheckedItemPosition() {
    int j = super.getCheckedItemPosition();
    int i = j;
    if (this.adapter != null) {
      i = j;
      if (!isCalledFromSuper()) {
        i = j;
        if (j != -1)
          i = this.adapter.lo(j); 
      } 
    } 
    return i;
  }
  
  public SparseBooleanArray getCheckedItemPositions() {
    SparseBooleanArray sparseBooleanArray = super.getCheckedItemPositions();
    if (this.adapter != null && !isCalledFromSuper() && sparseBooleanArray != null) {
      SparseBooleanArray sparseBooleanArray1 = new SparseBooleanArray(sparseBooleanArray.size());
      for (byte b1 = 0; b1 < sparseBooleanArray.size(); b1++)
        sparseBooleanArray1.put(this.adapter.lp(sparseBooleanArray.keyAt(b1)), sparseBooleanArray.valueAt(b1)); 
      return sparseBooleanArray1;
    } 
    return sparseBooleanArray;
  }
  
  protected ContextMenu.ContextMenuInfo getContextMenuInfo() {
    AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo)super.getContextMenuInfo();
    adapterContextMenuInfo.position = this.adapter.lp(adapterContextMenuInfo.position - getHeaderViewsCount());
    adapterContextMenuInfo.position += getHeaderViewsCount();
    return adapterContextMenuInfo;
  }
  
  public int getFirstVisiblePosition() { return (this.adapter != null && !isCalledFromSuper()) ? this.adapter.lo(super.getFirstVisiblePosition()) : super.getFirstVisiblePosition(); }
  
  public Object getItemAtPosition(int paramInt) { return isCalledFromSuper() ? super.getItemAtPosition(paramInt) : ((this.adapter == null || paramInt < 0) ? null : this.adapter.dDw.getItem(paramInt)); }
  
  public long getItemIdAtPosition(int paramInt) { return isCalledFromSuper() ? super.getItemIdAtPosition(paramInt) : ((this.adapter == null || paramInt < 0) ? Float.MIN_VALUE : this.adapter.dDw.getItemId(paramInt)); }
  
  public int getLastVisiblePosition() { return (this.adapter != null && !isCalledFromSuper()) ? this.adapter.lo(super.getLastVisiblePosition()) : super.getLastVisiblePosition(); }
  
  public a getWrappedAdapter() { return (this.adapter != null) ? this.adapter.ask() : null; }
  
  public boolean isDrawingListUnderStickyHeader() { return this.drawingListUnderStickyHeader; }
  
  public boolean isItemChecked(int paramInt) {
    int i = paramInt;
    if (!isCalledFromSuper())
      i = this.adapter.lo(paramInt); 
    return super.isItemChecked(i);
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    if (this.frame == null) {
      ViewGroup viewGroup = (ViewGroup)getParent();
      int i = viewGroup.indexOfChild(this);
      viewGroup.removeView(this);
      int j = getVisibility();
      setVisibility(0);
      this.frame = new StickyListHeadersListViewWrapper(getContext());
      this.frame.setSelector(getSelector());
      this.frame.setDrawSelectorOnTop(this.drawSelectorOnTop);
      this.frame.setVisibility(j);
      ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)getLayoutParams();
      if (this.clippingToPadding) {
        this.frame.setPadding(0, getPaddingTop(), 0, getPaddingBottom());
        setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
      } 
      setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.frame.addView(this);
      this.frame.setBackgroundDrawable(getBackground());
      super.setBackgroundDrawable(null);
      this.frame.setLayoutParams(marginLayoutParams);
      viewGroup.addView(this.frame, i);
    } 
  }
  
  public void onClick(View paramView) {
    if (this.frame.dv(paramView) && this.onHeaderClickListener != null)
      this.onHeaderClickListener.a(this, paramView, this.headerPosition, this.currentHeaderId.longValue(), true); 
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {
    if (this.scrollListener != null)
      this.scrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3); 
    if (Build.VERSION.SDK_INT >= 8)
      scrollChanged(paramInt1); 
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {
    if (this.scrollListener != null)
      this.scrollListener.onScrollStateChanged(paramAbsListView, paramInt); 
  }
  
  public boolean performItemClick(View paramView, int paramInt, long paramLong) {
    AdapterView.OnItemClickListener onItemClickListener = getOnItemClickListener();
    int i = getHeaderViewsCount();
    b b1 = this.adapter;
    int j = paramInt - i;
    int k = b1.getItemViewType(j);
    if (k == this.adapter.dDA) {
      if (this.onHeaderClickListener != null) {
        paramInt = this.adapter.lp(j);
        this.onHeaderClickListener.a(this, paramView, paramInt, paramLong, false);
        return true;
      } 
      return false;
    } 
    if (k == this.adapter.dDz)
      return false; 
    if (onItemClickListener != null) {
      if (paramInt >= this.adapter.getCount()) {
        paramInt -= this.adapter.asi();
      } else if (paramInt >= i) {
        paramInt = this.adapter.lp(j) + i;
      } 
      onItemClickListener.onItemClick(this, paramView, paramInt, paramLong);
      return true;
    } 
    return false;
  }
  
  public boolean removeFooterView(View paramView) {
    boolean bool = super.removeFooterView(paramView);
    if (bool)
      this.footerViews.remove(paramView); 
    return bool;
  }
  
  public void setAdapter(ListAdapter paramListAdapter) {
    if (isInEditMode()) {
      super.setAdapter(paramListAdapter);
      return;
    } 
    if (!this.clipToPaddingHasBeenSet)
      this.clippingToPadding = true; 
    if (paramListAdapter != null && !(paramListAdapter instanceof a))
      throw new IllegalArgumentException("Adapter must implement StickyListHeadersAdapter"); 
    if (this.adapter != null) {
      this.adapter.b(this.dataSetChangedObserver);
      this.adapter = null;
    } 
    if (paramListAdapter != null) {
      if (paramListAdapter instanceof android.widget.SectionIndexer) {
        this.adapter = new j(getContext(), (a)paramListAdapter);
      } else {
        this.adapter = new b(getContext(), (a)paramListAdapter);
      } 
      this.adapter.setDivider(this.divider);
      this.adapter.setDividerHeight(this.dividerHeight);
      this.adapter.a(this.dataSetChangedObserver);
      setSelectionFromTop(this.positionToSetWhenAdapterIsReady, this.offsetToSetWhenAdapterIsReady);
    } 
    this.currentHeaderId = null;
    if (this.frame != null)
      this.frame.asl(); 
    updateHeaderVisibilities();
    invalidate();
    super.setAdapter(this.adapter);
  }
  
  public void setAreHeadersSticky(boolean paramBoolean) {
    if (this.areHeadersSticky != paramBoolean) {
      if (paramBoolean)
        super.setVerticalFadingEdgeEnabled(false); 
      requestLayout();
      this.areHeadersSticky = paramBoolean;
    } 
  }
  
  @Deprecated
  public void setBackgroundDrawable(Drawable paramDrawable) {
    if (this.frame != null) {
      this.frame.setBackgroundDrawable(paramDrawable);
      return;
    } 
    super.setBackgroundDrawable(paramDrawable);
  }
  
  public void setClipToPadding(boolean paramBoolean) {
    super.setClipToPadding(paramBoolean);
    this.clippingToPadding = paramBoolean;
    this.clipToPaddingHasBeenSet = true;
  }
  
  public void setDivider(Drawable paramDrawable) {
    this.divider = paramDrawable;
    if (paramDrawable != null) {
      int i = paramDrawable.getIntrinsicHeight();
      if (i >= 0)
        setDividerHeight(i); 
    } 
    if (this.adapter != null) {
      this.adapter.setDivider(paramDrawable);
      requestLayout();
      invalidate();
    } 
  }
  
  public void setDividerHeight(int paramInt) {
    this.dividerHeight = paramInt;
    if (this.adapter != null) {
      this.adapter.setDividerHeight(paramInt);
      requestLayout();
      invalidate();
    } 
  }
  
  public void setDrawSelectorOnTop(boolean paramBoolean) {
    super.setDrawSelectorOnTop(paramBoolean);
    this.drawSelectorOnTop = paramBoolean;
    if (this.frame != null)
      this.frame.setDrawSelectorOnTop(this.drawSelectorOnTop); 
  }
  
  public void setDrawingListUnderStickyHeader(boolean paramBoolean) { this.drawingListUnderStickyHeader = paramBoolean; }
  
  public void setItemChecked(int paramInt, boolean paramBoolean) {
    int i = paramInt;
    if (!isCalledFromSuper())
      i = this.adapter.lo(paramInt); 
    paramInt = this.adapter.getItemViewType(i);
    if (paramInt != this.adapter.dDz && paramInt != this.adapter.dDA)
      super.setItemChecked(i, paramBoolean); 
  }
  
  public void setMultiChoiceModeListener(AbsListView.MultiChoiceModeListener paramMultiChoiceModeListener) {
    this.multiChoiceModeListenerDelegate = paramMultiChoiceModeListener;
    if (paramMultiChoiceModeListener == null) {
      super.setMultiChoiceModeListener(null);
      return;
    } 
    super.setMultiChoiceModeListener(this.multiChoiceModeListenerWrapper);
  }
  
  public void setOnHeaderClickListener(a parama) { this.onHeaderClickListener = parama; }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener) {
    this.onItemLongClickListenerDelegate = paramOnItemLongClickListener;
    if (paramOnItemLongClickListener == null) {
      super.setOnItemLongClickListener(null);
      return;
    } 
    super.setOnItemLongClickListener(this.onItemLongClickListenerWrapper);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener) { this.scrollListener = paramOnScrollListener; }
  
  public void setSelection(int paramInt) { setSelectionFromTop(paramInt, 0); }
  
  public void setSelectionFromTop(int paramInt1, int paramInt2) {
    int j = paramInt1;
    int i = paramInt2;
    if (!isCalledFromSuper()) {
      if (this.adapter == null) {
        this.positionToSetWhenAdapterIsReady = paramInt1;
        this.offsetToSetWhenAdapterIsReady = paramInt2;
        return;
      } 
      i = paramInt2;
      if (this.areHeadersSticky) {
        i = paramInt2;
        if (this.frame != null) {
          i = paramInt2;
          if (this.frame.asm())
            i = paramInt2 + this.frame.asn(); 
        } 
      } 
      j = this.adapter.lo(paramInt1);
    } 
    super.setSelectionFromTop(j, i);
  }
  
  public void setSelector(Drawable paramDrawable) {
    super.setSelector(paramDrawable);
    if (this.frame != null)
      this.frame.setSelector(paramDrawable); 
  }
  
  public void setVerticalFadingEdgeEnabled(boolean paramBoolean) {
    if (this.areHeadersSticky) {
      super.setVerticalFadingEdgeEnabled(false);
      return;
    } 
    super.setVerticalFadingEdgeEnabled(paramBoolean);
  }
  
  public void setVisibility(int paramInt) {
    if (this.frame != null)
      this.frame.setVisibility(paramInt); 
    super.setVisibility(paramInt);
  }
  
  public void smoothScrollToPosition(int paramInt) { smoothScrollToPositionFromTop(paramInt, 0); }
  
  public void smoothScrollToPosition(int paramInt1, int paramInt2) { smoothScrollToPositionFromTop(paramInt1, 0); }
  
  public void smoothScrollToPositionFromTop(int paramInt1, int paramInt2) { smoothScrollToPositionFromTop(paramInt1, paramInt2, 500); }
  
  public void smoothScrollToPositionFromTop(int paramInt1, int paramInt2, int paramInt3) {
    int j = paramInt1;
    int i = paramInt2;
    if (!isCalledFromSuper()) {
      if (this.adapter == null) {
        this.positionToSetWhenAdapterIsReady = paramInt1;
        this.offsetToSetWhenAdapterIsReady = paramInt2;
        return;
      } 
      i = paramInt2;
      if (this.areHeadersSticky) {
        i = paramInt2;
        if (this.frame != null) {
          i = paramInt2;
          if (this.frame.asm())
            i = paramInt2 + this.frame.asn(); 
        } 
      } 
      j = this.adapter.lo(paramInt1);
    } 
    super.smoothScrollToPositionFromTop(j, i, paramInt3);
  }
  
  public static interface a {
    void a(StickyListHeadersListView param1StickyListHeadersListView, View param1View, int param1Int, long param1Long, boolean param1Boolean);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\stickylistheaders\StickyListHeadersListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */