package com.laiqian.ui.listview;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.db.multidatabase.c.a;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.infrastructure.R;
import com.laiqian.milestone.h;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.util.bb;
import com.laiqian.util.n;
import io.reactivex.g.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormListView extends ListView implements AbsListView.OnScrollListener {
  public static final int COMPLETE = 2;
  
  private static final String DOUBLETAB = "fAmount,fIncrementAmount,fReceived,fSalePrice,fChargeAmount,nStockQty,fStockPrice,fOldAmount,fNewAmount,fPoints";
  
  private static final int IS_FIRST_LOAD = 1;
  
  public static final int LOAD = 1;
  
  private static final int NONE = 0;
  
  private static final int NOT_FIRST_LOAD = 2;
  
  public static final int REFRESH = 0;
  
  public static final int START = -1;
  
  private static final String TAG = "FormListView";
  
  private e adapter;
  
  private List<Map<String, String>> allData = new ArrayList();
  
  private String[] arrFrom;
  
  public int currentScrollY = 0;
  
  private h db;
  
  private int firstVisibleItem;
  
  protected View footer;
  
  private boolean isLoadFull;
  
  private boolean isLoading;
  
  public boolean isNeedCopyParams = true;
  
  private boolean isTouch;
  
  public boolean isTransaction = false;
  
  private List<Map<String, String>> list = new ArrayList();
  
  private RelativeLayout lv_head;
  
  private Context mContext;
  
  private Thread mLoadThread;
  
  private e mOnPreLoadListener;
  
  private String[] mTime;
  
  private int nPage;
  
  private a onAfterLoadListener;
  
  AdapterView.OnItemClickListener onItemClickListener;
  
  private c onLoadListener;
  
  private d onRefreshListener;
  
  public int pageSize = 50;
  
  private String[] para;
  
  private boolean postNotifyData = false;
  
  protected ProgressBarCircularIndeterminate progressBar;
  
  protected RelativeLayout rlLoading;
  
  private String sSql;
  
  private int scrollState;
  
  Handler uiHandler = new d(this);
  
  protected View view_bottom;
  
  static  {
  
  }
  
  public FormListView(Context paramContext) {
    super(paramContext);
    this.mContext = paramContext;
    initView(paramContext);
  }
  
  public FormListView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MyAutoListView).recycle();
    initView(paramContext);
  }
  
  public FormListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext);
  }
  
  private List<Map<String, String>> getListAllData(long paramLong1, long paramLong2) {
    arrayList = new ArrayList();
    Cursor cursor3 = null;
    cursor2 = null;
    cursor1 = cursor2;
    try {
      sQLiteDatabase = (new a(paramLong1, paramLong2)).getDatabase();
      cursor1 = cursor2;
      List list1 = b.g(paramLong1, paramLong2);
      cursor1 = cursor2;
      cursor2 = sQLiteDatabase.rawQuery(this.sSql, (String[])b.c(this.para, list1.size()));
      label43: while (true)
        return arrayList; 
    } catch (Exception exception) {
      cursor2 = cursor3;
      cursor1 = cursor2;
    } finally {
      HashMap hashMap1;
      HashMap hashMap2 = null;
      cursor2 = cursor1;
    } 
    return arrayList;
  }
  
  private void getListData(int paramInt) {
    ArrayList arrayList = new ArrayList();
    boolean bool = isTransation();
    Exception exception = null;
    if (!bool) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("非会员交易-->");
      stringBuilder.append(this.sSql);
      b.ct(stringBuilder.toString());
      if (this.mTime == null) {
        if (this.db == null)
          this.db = new h(this.mContext); 
        Cursor cursor = this.db.a(this.sSql, this.para, this.pageSize, paramInt);
      } else {
        try {
          SQLiteDatabase sQLiteDatabase = (new a(Long.valueOf(this.mTime[0]).longValue(), Long.valueOf(this.mTime[1]).longValue())).getDatabase();
        } catch (Exception null) {
          a.e(stringBuilder);
          stringBuilder = null;
        } 
        Cursor cursor = getDataByPageSize(stringBuilder, this.sSql, this.para, this.pageSize, paramInt);
      } 
    } else {
      stringBuilder = new StringBuilder();
      stringBuilder.append("会员交易-->");
      stringBuilder.append(this.sSql);
      b.ct(stringBuilder.toString());
      long l1 = Long.valueOf(this.mTime[0]).longValue();
      long l2 = Long.valueOf(this.mTime[1]).longValue();
      stringBuilder = new StringBuilder();
      stringBuilder.append(getClass().getSimpleName());
      stringBuilder.append("会员交易---startTime---");
      stringBuilder.append(l1);
      stringBuilder.append("--endTime--");
      stringBuilder.append(l2);
      stringBuilder.append("--sql-->");
      stringBuilder.append(this.sSql);
      b.ct(stringBuilder.toString());
      try {
        SQLiteDatabase sQLiteDatabase = (new a(Math.min(l1, l2), Math.max(l1, l2))).getDatabase();
        try {
          exception1 = b.f(Math.min(l1, l2), Math.max(l1, l2));
        } catch (Exception null) {}
      } catch (Exception exception1) {
        stringBuilder = null;
      } 
      a.e(exception1);
      exception1 = exception;
    } 
    while (stringBuilder != null && stringBuilder.moveToNext()) {
      HashMap hashMap = new HashMap();
      hashMap.put("_id", stringBuilder.getString(stringBuilder.getColumnIndex("_id")));
      int i = RootApplication.aIS;
      hashMap.put("nDateTime", stringBuilder.getString(stringBuilder.getColumnIndex("nDateTime")));
      byte b = 0;
      boolean bool2 = false;
      boolean bool1 = false;
      while (b < this.arrFrom.length) {
        String str = TAG;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("getListData arr[i]-->");
        stringBuilder1.append(this.arrFrom[b]);
        Log.i(str, stringBuilder1.toString());
        str = Arrays.toString(this.arrFrom);
        if (str.contains("sSpareField5")) {
          i = stringBuilder.getInt(stringBuilder.getColumnIndex("sSpareField5"));
          bool2 = true;
        } 
        if (str.contains("nChargeType"))
          if (370005 == stringBuilder.getInt(stringBuilder.getColumnIndex("nChargeType"))) {
            bool1 = true;
          } else {
            bool1 = false;
          }  
        if ("fAmount,fIncrementAmount,fReceived,fSalePrice,fChargeAmount,nStockQty,fStockPrice,fOldAmount,fNewAmount,fPoints".contains(this.arrFrom[b])) {
          byte b1;
          str = this.arrFrom[b];
          double d1 = stringBuilder.getDouble(stringBuilder.getColumnIndex(this.arrFrom[b]));
          if (bool1) {
            b1 = i;
          } else {
            b1 = 2;
          } 
          hashMap.put(str, n.a(Double.valueOf(d1), true, false, b1));
        } else {
          hashMap.put(this.arrFrom[b], stringBuilder.getString(stringBuilder.getColumnIndex(this.arrFrom[b])));
        } 
        b++;
      } 
      if (bool2)
        hashMap.put("sSpareField5", String.valueOf(i)); 
      arrayList.add(hashMap);
    } 
    if (stringBuilder != null)
      stringBuilder.close(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("nPage->");
    stringBuilder.append(paramInt);
    stringBuilder.append("nDatalength->");
    stringBuilder.append(0);
    Log.e("nPage", stringBuilder.toString());
    loadListDataAfter(arrayList, paramInt);
  }
  
  private void getListMoreData() {
    if (this.onLoadListener != null) {
      this.onLoadListener.getListData(this.nPage);
      return;
    } 
    getListData(this.nPage);
  }
  
  private void ifNeedLoad(AbsListView paramAbsListView, int paramInt) {
    try {
      int i = this.list.size() + getHeaderViewsCount() + getFooterViewsCount() - 1;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt);
      stringBuilder.append("");
      Log.e("scrollState", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramAbsListView.getLastVisiblePosition());
      stringBuilder.append("");
      Log.e("getLastVisiblePosition", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(i);
      stringBuilder.append("");
      Log.e("count", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(this.isLoadFull);
      stringBuilder.append("");
      Log.e("isLoadFull", stringBuilder.toString());
      if (paramInt == 0 && paramAbsListView.getLastVisiblePosition() == i && !this.isLoadFull) {
        this.progressBar.setVisibility(0);
        onLoad();
        Log.e("scrollState", "下滑加载中");
      } 
      return;
    } catch (Exception paramAbsListView) {
      return;
    } 
  }
  
  private void initView(Context paramContext) {
    setOnScrollListener(this);
    this.footer = LayoutInflater.from(paramContext).inflate(R.layout.ui_loading, null);
    this.progressBar = (ProgressBarCircularIndeterminate)this.footer.findViewById(R.id.ivProgress);
    this.rlLoading = (RelativeLayout)this.footer.findViewById(R.id.rlLoading);
    this.view_bottom = this.footer.findViewById(R.id.view_bottom);
    if (getFooterViewsCount() == 0) {
      hideFooterView();
      addFooterView(this.footer);
    } 
  }
  
  private void loadListData() { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_1
    //   10: aload_1
    //   11: ldc_w 'page->'
    //   14: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload_1
    //   19: aload_0
    //   20: getfield nPage : I
    //   23: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: ldc_w 'onload'
    //   30: aload_1
    //   31: invokevirtual toString : ()Ljava/lang/String;
    //   34: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   37: pop
    //   38: aload_0
    //   39: aload_0
    //   40: getfield nPage : I
    //   43: iconst_1
    //   44: iadd
    //   45: putfield nPage : I
    //   48: new java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial <init> : ()V
    //   55: astore_1
    //   56: aload_1
    //   57: ldc_w '正在加载第'
    //   60: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload_1
    //   65: aload_0
    //   66: getfield nPage : I
    //   69: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload_1
    //   74: invokevirtual toString : ()Ljava/lang/String;
    //   77: astore_1
    //   78: new java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial <init> : ()V
    //   85: astore_2
    //   86: aload_2
    //   87: ldc_w 'isLoading'
    //   90: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_2
    //   95: aload_0
    //   96: getfield isLoading : Z
    //   99: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload_2
    //   104: ldc_w 'isLoadFull->'
    //   107: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_2
    //   112: aload_0
    //   113: getfield isLoadFull : Z
    //   116: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload_1
    //   121: aload_2
    //   122: invokevirtual toString : ()Ljava/lang/String;
    //   125: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   128: pop
    //   129: aload_0
    //   130: invokespecial getListMoreData : ()V
    //   133: aload_0
    //   134: monitorexit
    //   135: return
    //   136: astore_1
    //   137: aload_0
    //   138: monitorexit
    //   139: aload_1
    //   140: athrow
    // Exception table:
    //   from	to	target	type
    //   2	133	136	finally }
  
  private void onLoad() {
    if (this.mLoadThread == null || !this.mLoadThread.isAlive())
      a.aKh().r(new a(this)); 
  }
  
  public void clearList() {
    this.list.clear();
    notifyData();
  }
  
  public void close() {
    if (this.db != null) {
      this.db.close();
      this.db = null;
    } 
    if (this.list != null) {
      this.list.clear();
      notifyData();
      this.list = null;
    } 
  }
  
  public void closeDB() {
    if (this.db != null) {
      this.db.close();
      this.db = null;
    } 
  }
  
  public BaseAdapter getAdapter() { return this.adapter; }
  
  public List<Map<String, String>> getAllData(long paramLong1, long paramLong2) { return getListAllData(paramLong1, paramLong2); }
  
  public Cursor getDataByPageSize(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString, int paramInt1, int paramInt2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(" limit ");
    int i = paramInt2 * paramInt1;
    stringBuilder.append(i);
    stringBuilder.append(",");
    stringBuilder.append(paramInt1);
    Cursor cursor = stringBuilder.toString();
    System.out.println(cursor);
    bb.e("sql", cursor);
    for (paramInt2 = 0; paramInt2 < paramArrayOfString.length; paramInt2++)
      bb.e("para", paramArrayOfString[paramInt2]); 
    cursor = null;
    if (paramSQLiteDatabase != null) {
      null = new StringBuilder();
      null.append(paramString);
      null.append(" limit ");
      null.append(i);
      null.append(",");
      null.append(paramInt1);
      cursor = paramSQLiteDatabase.rawQuery(null.toString(), paramArrayOfString);
    } 
    return cursor;
  }
  
  public List<Map<String, String>> getList() { return this.list; }
  
  public int getPage() { return this.nPage; }
  
  public int getPageSize() { return this.pageSize; }
  
  public String[] getPara() { return this.para; }
  
  public String getsSql() { return this.sSql; }
  
  public void hideFooterView() {
    this.footer.setVisibility(8);
    this.view_bottom.setVisibility(8);
  }
  
  public void initData() {
    this.nPage = 0;
    if (this.list != null)
      this.list.clear(); 
    if (this.adapter != null)
      this.adapter.notifyDataSetChanged(); 
    this.scrollState = 0;
    this.firstVisibleItem = 0;
    this.isLoading = false;
    this.isLoadFull = false;
    this.isTouch = false;
  }
  
  protected boolean isHasProgressBar() { return (getFooterViewsCount() > 0); }
  
  public boolean isNeedCopyParams() { return this.isNeedCopyParams; }
  
  public boolean isTransation() { return this.isTransaction; }
  
  public void loadListDataAfter(List<Map<String, String>> paramList, int paramInt) {
    if (paramList != null)
      this.list.addAll(paramList); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.list.size());
    stringBuilder.append("");
    Log.e("loadListData_list", stringBuilder.toString());
    Message message = new Message();
    message.arg1 = paramList.size();
    message.arg2 = paramInt;
    this.uiHandler.sendMessage(message);
    if (paramInt != 0)
      this.isLoading = false; 
  }
  
  public void notifyData() {
    if (this.scrollState == 0) {
      this.postNotifyData = false;
      if (this.adapter != null) {
        this.adapter.m(this.list);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        onMeasure(layoutParams.width, layoutParams.height);
        return;
      } 
    } else {
      this.postNotifyData = true;
    } 
  }
  
  public void onLoadComplete() { this.isLoading = false; }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) { this.firstVisibleItem = paramInt1; }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {
    this.scrollState = paramInt;
    if (this.postNotifyData && paramInt == 0)
      notifyData(); 
    if (paramInt == 0)
      this.currentScrollY = paramAbsListView.getScrollY(); 
    ifNeedLoad(paramAbsListView, paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    this.isTouch = true;
    try {
      return super.onTouchEvent(paramMotionEvent);
    } catch (Exception paramMotionEvent) {
      a.e(paramMotionEvent);
      return false;
    } 
  }
  
  public void setAdapter(e parame) {
    setAdapter(parame);
    this.adapter = parame;
  }
  
  public void setData(Context paramContext, String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2) {
    this.mContext = paramContext;
    this.sSql = paramString;
    this.para = paramArrayOfString1;
    this.arrFrom = paramArrayOfString2;
    if (this.mLoadThread == null || !this.mLoadThread.isAlive()) {
      this.mLoadThread = new Thread(new b(this));
      this.mLoadThread.start();
    } 
  }
  
  public void setData(Context paramContext, String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3) {
    this.mContext = paramContext;
    this.sSql = paramString;
    this.para = paramArrayOfString1;
    this.arrFrom = paramArrayOfString2;
    this.mTime = paramArrayOfString3;
    if (this.mLoadThread == null || !this.mLoadThread.isAlive()) {
      this.mLoadThread = new Thread(new c(this));
      this.mLoadThread.start();
    } 
  }
  
  public void setHead(View paramView) {
    if (getHeaderViewsCount() == 0)
      addHeaderView(paramView, null, false); 
  }
  
  public void setIsTransaction(boolean paramBoolean) { this.isTransaction = paramBoolean; }
  
  public void setNeedCopyParams(boolean paramBoolean) { this.isNeedCopyParams = paramBoolean; }
  
  public void setOnAfterLoadListener(a parama) { this.onAfterLoadListener = parama; }
  
  public void setOnLoadListener(c paramc) { this.onLoadListener = paramc; }
  
  public void setOnPreLoadListener(e parame) { this.mOnPreLoadListener = parame; }
  
  public void setPage(int paramInt) { this.nPage = paramInt; }
  
  public void setPageSize(int paramInt) { this.pageSize = paramInt; }
  
  public void setPara(String[] paramArrayOfString) { this.para = paramArrayOfString; }
  
  public void setResultSize(int paramInt) {
    if (paramInt == 0) {
      this.progressBar.setVisibility(8);
      this.isLoadFull = true;
      return;
    } 
    if (paramInt > 0 && paramInt < this.pageSize) {
      this.progressBar.setVisibility(8);
      this.isLoadFull = true;
      return;
    } 
    if (paramInt == this.pageSize) {
      this.progressBar.setVisibility(8);
      this.isLoadFull = false;
    } 
  }
  
  public void setsSql(String paramString) { this.sSql = paramString; }
  
  public void showFooterView() {
    this.footer.setVisibility(0);
    this.view_bottom.setVisibility(0);
  }
  
  public static interface a {
    void aX(int param1Int1, int param1Int2);
  }
  
  public static interface b {}
  
  public static interface c {
    void getListData(int param1Int);
  }
  
  public static interface d {}
  
  public static interface e {
    void Rc();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\listview\FormListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */