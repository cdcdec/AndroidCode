package com.laiqian.ui.listview;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.laiqian.infrastructure.R;
import com.laiqian.milestone.h;
import com.laiqian.ui.s;
import com.laiqian.util.ae;
import com.laiqian.util.bb;
import com.laiqian.util.by;
import com.laiqian.util.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PosAutoListView extends ListView implements AbsListView.OnScrollListener {
  public static final int COMPLETE = 2;
  
  public static final int LOAD = 1;
  
  private static final int NONE = 0;
  
  private static final int PULL = 1;
  
  public static final int REFRESH = 0;
  
  private static final int REFRESHING = 3;
  
  private static final int RELEASE = 2;
  
  private static final int SPACE = 20;
  
  public static final int START = -1;
  
  private l adapter;
  
  private RotateAnimation animation;
  
  private String[] arrFrom;
  
  private ImageView arrow;
  
  private boolean bIsAddBlankFooter = false;
  
  private View blank_view1;
  
  private View blank_view2;
  
  private h db;
  
  private int firstVisibleItem;
  
  private View footer;
  
  private View header;
  
  private int headerContentHeight;
  
  private int headerContentInitialHeight;
  
  private LinearLayout header_wrap;
  
  private LayoutInflater inflater;
  
  private boolean isLoadFull;
  
  private boolean isLoading;
  
  private boolean isRecorded;
  
  private boolean isShowBottom;
  
  private boolean isShowFootView = true;
  
  private boolean isShowTop;
  
  private TextView lastUpdate;
  
  private List<Map<String, ?>> list = new ArrayList();
  
  private LinearLayout ll_blank_footer;
  
  private TextView loadFull;
  
  private ProgressBar loading;
  
  private Context mContext;
  
  private TextView more;
  
  Handler myLoadDataHandler;
  
  private int nPage = -1;
  
  private int nTopHeightDp;
  
  private TextView noData;
  
  AdapterView.OnItemClickListener onItemClickListener;
  
  private a onLoadListener;
  
  private b onRefreshListener;
  
  public int pageSize = 20;
  
  private String[] para;
  
  private ProgressBar refreshing;
  
  private RotateAnimation reverseAnimation;
  
  private RelativeLayout rlFooter;
  
  private String sSql;
  
  private int scrollState;
  
  private int startY;
  
  private int state;
  
  private TextView tip;
  
  public PosAutoListView(Context paramContext) {
    super(paramContext);
    this.mContext = paramContext;
    initView(paramContext);
  }
  
  public PosAutoListView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MyAutoListView);
    this.isShowTop = typedArray.getBoolean(R.styleable.MyAutoListView_showTop, false);
    this.nTopHeightDp = typedArray.getInt(R.styleable.MyAutoListView_paddingTopHeight, 0);
    this.isShowBottom = typedArray.getBoolean(R.styleable.MyAutoListView_showBottom, true);
    typedArray.recycle();
    initView(paramContext);
  }
  
  public PosAutoListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext);
  }
  
  private Object[] getListData(int paramInt) {
    if (this.db == null)
      this.db = new h(this.mContext); 
    ArrayList arrayList = new ArrayList();
    Cursor cursor = this.db.a(this.sSql, this.para, this.pageSize, paramInt);
    int i = cursor.getCount();
    while (true) {
      boolean bool = cursor.moveToNext();
      byte b1 = 0;
      if (bool) {
        HashMap hashMap = new HashMap();
        hashMap.put("_id", Long.valueOf(cursor.getLong(cursor.getColumnIndex("_id"))));
        while (b1 < this.arrFrom.length) {
          if ("fAmount".equals(this.arrFrom[b1]) || "fIncrementAmount".equals(this.arrFrom[b1]) || "fReceived".equals(this.arrFrom[b1]) || "fChargeAmount".equals(this.arrFrom[b1])) {
            hashMap.put(this.arrFrom[b1], by.k(Double.valueOf(cursor.getDouble(cursor.getColumnIndex(this.arrFrom[b1])))));
          } else {
            hashMap.put(this.arrFrom[b1], cursor.getString(cursor.getColumnIndex(this.arrFrom[b1])));
          } 
          b1++;
        } 
        arrayList.add(hashMap);
        continue;
      } 
      break;
    } 
    cursor.close();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("nPage->");
    stringBuilder.append(paramInt);
    stringBuilder.append("nDatalength->");
    stringBuilder.append(i);
    bb.e("nPage", stringBuilder.toString());
    return new Object[] { Integer.valueOf(i), arrayList };
  }
  
  private void ifNeedLoad(AbsListView paramAbsListView, int paramInt) {
    if (!this.isShowBottom)
      return; 
    if (paramInt == 0)
      try {
        if (!this.isLoading && paramAbsListView.getLastVisiblePosition() == paramAbsListView.getPositionForView(this.footer) && !this.isLoadFull)
          onLoad(); 
        return;
      } catch (Exception paramAbsListView) {
        return;
      }  
  }
  
  private void initView(Context paramContext) {
    this.animation = new RotateAnimation(0.0F, -180.0F, true, 0.5F, true, 0.5F);
    this.animation.setInterpolator(new LinearInterpolator());
    this.animation.setDuration(100L);
    this.animation.setFillAfter(true);
    this.reverseAnimation = new RotateAnimation(-180.0F, 0.0F, true, 0.5F, true, 0.5F);
    this.reverseAnimation.setInterpolator(new LinearInterpolator());
    this.reverseAnimation.setDuration(100L);
    this.reverseAnimation.setFillAfter(true);
    this.inflater = LayoutInflater.from(paramContext);
    this.footer = this.inflater.inflate(R.layout.auto_listview_footer, null);
    this.ll_blank_footer = (LinearLayout)LayoutInflater.from(paramContext).inflate(R.layout.pos_blank_footer_view, null);
    this.blank_view1 = this.ll_blank_footer.findViewById(R.id.blank_view1);
    this.blank_view2 = this.ll_blank_footer.findViewById(R.id.blank_view2);
    addFooterView(this.ll_blank_footer, null, false);
    this.loadFull = (TextView)this.footer.findViewById(R.id.loadFull);
    this.noData = (TextView)this.footer.findViewById(R.id.noData);
    this.more = (TextView)this.footer.findViewById(R.id.more);
    this.loading = (ProgressBar)this.footer.findViewById(R.id.loading);
    this.nTopHeightDp = ae.b(paramContext, this.nTopHeightDp);
    if (this.header == null)
      this.header = this.inflater.inflate(R.layout.auto_pull_to_refresh_header, null); 
    if (this.header != null) {
      this.header.findViewById(R.id.header_padding).setLayoutParams(new LinearLayout.LayoutParams(-1, this.nTopHeightDp));
      this.arrow = (ImageView)this.header.findViewById(R.id.arrow);
      this.tip = (TextView)this.header.findViewById(R.id.tip);
      this.header_wrap = (LinearLayout)this.header.findViewById(R.id.header_wrap);
      this.lastUpdate = (TextView)this.header.findViewById(R.id.lastUpdate);
      this.refreshing = (ProgressBar)this.header.findViewById(R.id.refreshing);
      this.headerContentInitialHeight = this.header.getPaddingTop();
      (new s()).dq(this.header);
      this.headerContentHeight = this.header.getMeasuredHeight();
      this.header.setClickable(false);
      addHeaderView(this.header, null, false);
    } 
    this.footer.setClickable(false);
    addFooterView(this.footer, null, false);
    setOnScrollListener(this);
    topPadding(this.nTopHeightDp - this.headerContentHeight);
  }
  
  private void refreshHeaderViewByState() {
    switch (this.state) {
      default:
        return;
      case 3:
        topPadding(this.headerContentInitialHeight);
        this.refreshing.setVisibility(0);
        this.arrow.clearAnimation();
        this.arrow.setVisibility(8);
        this.tip.setVisibility(8);
        this.lastUpdate.setVisibility(8);
        return;
      case 2:
        this.arrow.setVisibility(0);
        this.tip.setVisibility(0);
        this.lastUpdate.setVisibility(0);
        this.refreshing.setVisibility(8);
        this.tip.setText(R.string.pull_to_refresh);
        this.tip.setText(R.string.release_to_refresh);
        this.arrow.clearAnimation();
        this.arrow.setAnimation(this.animation);
        return;
      case 1:
        this.arrow.setVisibility(0);
        this.tip.setVisibility(0);
        this.lastUpdate.setVisibility(0);
        this.refreshing.setVisibility(8);
        this.tip.setText(R.string.pull_to_refresh);
        this.arrow.clearAnimation();
        this.arrow.setAnimation(this.reverseAnimation);
        return;
      case 0:
        break;
    } 
    topPadding(-this.headerContentHeight);
    this.tip.setText(R.string.pull_to_refresh);
    this.refreshing.setVisibility(8);
    this.arrow.clearAnimation();
    this.arrow.setImageResource(R.drawable.pull_to_refresh_arrow);
  }
  
  private void setList(List<Map<String, ?>> paramList) { this.list = paramList; }
  
  private void topPadding(int paramInt) {
    if (this.header != null) {
      this.header.setPadding(this.header.getPaddingLeft(), paramInt, this.header.getPaddingRight(), this.header.getPaddingBottom());
      this.header.invalidate();
    } 
  }
  
  private void whenMove(MotionEvent paramMotionEvent) {
    if (this.isRecorded) {
      if (!this.isShowTop)
        return; 
      int i = (int)paramMotionEvent.getY() - this.startY;
      int j = i - this.headerContentHeight;
      switch (this.state) {
        default:
          return;
        case 2:
          topPadding(j);
          if (i > 0 && i < this.headerContentHeight + 20) {
            this.state = 1;
            refreshHeaderViewByState();
            return;
          } 
          if (i <= 0) {
            this.state = 0;
            refreshHeaderViewByState();
            return;
          } 
          return;
        case 1:
          topPadding(j);
          if (this.scrollState == 1 && i > this.headerContentHeight + 20) {
            this.state = 2;
            refreshHeaderViewByState();
            return;
          } 
          return;
        case 0:
          break;
      } 
      if (i > 0) {
        this.state = 1;
        refreshHeaderViewByState();
      } 
      return;
    } 
  }
  
  public void addBlankFootView() { this.bIsAddBlankFooter = true; }
  
  public void addExtraHeader(int paramInt) {
    View view = this.inflater.inflate(paramInt, null);
    this.header_wrap.addView(view);
  }
  
  public void addList(int paramInt, List<Map<String, ?>> paramList) {
    if (this.list != null) {
      this.list.addAll(paramList);
    } else {
      setList(paramList);
    } 
    setResultSize(paramInt);
    onLoadComplete();
  }
  
  public void clearList() {
    if (this.list != null)
      this.list.clear(); 
    if (this.adapter != null)
      this.adapter.notifyDataSetChanged(); 
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
  
  public l getAdapter() { return this.adapter; }
  
  public List<Map<String, ?>> getList() { return this.list; }
  
  public int getPage() { return this.nPage; }
  
  public int getPageSize() { return this.pageSize; }
  
  public void hideFootView() { this.isShowFootView = false; }
  
  public void initData() {
    this.nPage = -1;
    if (this.list != null)
      this.list.clear(); 
    if (this.adapter != null)
      this.adapter.notifyDataSetChanged(); 
    this.state = 0;
    this.scrollState = 0;
    this.firstVisibleItem = 0;
    this.isRecorded = false;
    this.isLoading = false;
    this.isLoadFull = false;
    this.startY = 0;
  }
  
  public boolean isLoadEnable() { return this.isShowBottom; }
  
  public void notifyData() {
    if (this.adapter != null)
      this.adapter.notifyDataSetChanged(); 
  }
  
  public void onLoad() {
    if (this.isLoading)
      return; 
    this.isLoading = true;
    null = new StringBuilder();
    null.append("page->");
    null.append(this.nPage);
    Log.e("onload", null.toString());
    this.nPage++;
    null = new StringBuilder();
    null.append("正在加载第");
    null.append(this.nPage);
    null = null.toString();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("isLoading");
    stringBuilder.append(this.isLoading);
    stringBuilder.append("isLoadFull->");
    stringBuilder.append(this.isLoadFull);
    Log.e(null, stringBuilder.toString());
    Object[] arrayOfObject = getListData(this.nPage);
    if (this.onLoadListener != null)
      this.onLoadListener.a(this, this.adapter, ((Integer)arrayOfObject[0]).intValue(), (List)arrayOfObject[1]); 
  }
  
  public void onLoadComplete() { this.isLoading = false; }
  
  public void onRefresh() {
    if (this.onRefreshListener != null)
      this.onRefreshListener.onRefresh(); 
  }
  
  public void onRefreshComplete() { onRefreshComplete(z.pz("yyyy-MM-dd  HH:mm:ss")); }
  
  public void onRefreshComplete(String paramString) {
    this.lastUpdate.setText(getContext().getString(R.string.lastUpdateTime, new Object[] { z.pz("yyyy-MM-dd  HH:mm:ss") }));
    this.state = 0;
    refreshHeaderViewByState();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) { this.firstVisibleItem = paramInt1; }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {
    this.scrollState = paramInt;
    ifNeedLoad(paramAbsListView, paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    switch (paramMotionEvent.getAction()) {
      case 2:
        whenMove(paramMotionEvent);
        break;
      case 1:
      case 3:
        if (this.state == 1) {
          this.state = 0;
          refreshHeaderViewByState();
        } else if (this.state == 2) {
          this.state = 3;
          refreshHeaderViewByState();
          onRefresh();
        } 
        this.isRecorded = false;
        break;
      case 0:
        if (this.firstVisibleItem == 0) {
          this.isRecorded = true;
          this.startY = (int)paramMotionEvent.getY();
        } 
        break;
    } 
    try {
      return super.onTouchEvent(paramMotionEvent);
    } catch (Exception paramMotionEvent) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onTouchEvent");
      stringBuilder.append(paramMotionEvent.toString());
      bb.e("onTouchEvent", stringBuilder.toString());
      return false;
    } 
  }
  
  public boolean performItemClick(View paramView, int paramInt, long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("点击了");
    stringBuilder.append(paramInt);
    bb.e("事件", stringBuilder.toString());
    if (this.onItemClickListener != null) {
      playSoundEffect(0);
      this.onItemClickListener.onItemClick(this, paramView, paramInt - 1, paramLong);
      return true;
    } 
    return false;
  }
  
  public boolean performItemClickNoSound(View paramView, int paramInt, long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("点击了");
    stringBuilder.append(paramInt);
    bb.e("事件", stringBuilder.toString());
    if (this.onItemClickListener != null) {
      this.onItemClickListener.onItemClick(this, paramView, paramInt - 1, paramLong);
      return true;
    } 
    return false;
  }
  
  public void setAdapter(l paraml) {
    setAdapter(paraml);
    this.adapter = paraml;
  }
  
  public void setData(Context paramContext, a parama, String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2) {
    this.mContext = paramContext;
    this.sSql = paramString;
    this.para = paramArrayOfString1;
    this.arrFrom = paramArrayOfString2;
    this.onLoadListener = parama;
    initData();
    onLoad();
  }
  
  public void setListViewPos(int paramInt) {
    if (Build.VERSION.SDK_INT >= 8) {
      smoothScrollToPosition(paramInt);
      return;
    } 
    setSelection(paramInt);
  }
  
  public void setLoadEnable(boolean paramBoolean) {
    this.isShowBottom = paramBoolean;
    removeFooterView(this.footer);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener) { this.onItemClickListener = paramOnItemClickListener; }
  
  public void setOnRefreshListener(b paramb) { this.onRefreshListener = paramb; }
  
  public void setPage(int paramInt) { this.nPage = paramInt; }
  
  public void setPageSize(int paramInt) { this.pageSize = paramInt; }
  
  public void setResultSize(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("resultSize=");
    stringBuilder.append(paramInt);
    bb.ao(stringBuilder.toString());
    if (paramInt == 0) {
      this.ll_blank_footer.setVisibility(8);
      this.blank_view1.setVisibility(8);
      this.blank_view2.setVisibility(8);
      this.isLoadFull = true;
      this.loading.setVisibility(8);
      this.more.setVisibility(8);
      if (this.nPage == 0) {
        if (this.isShowFootView)
          this.noData.setVisibility(0); 
        this.loadFull.setVisibility(8);
        return;
      } 
      this.noData.setVisibility(8);
      this.loadFull.setVisibility(0);
      return;
    } 
    if (paramInt > 0 && paramInt < this.pageSize) {
      if (this.bIsAddBlankFooter && paramInt == 1) {
        this.blank_view1.setVisibility(0);
        this.blank_view2.setVisibility(0);
        this.ll_blank_footer.setVisibility(0);
      } else if (this.bIsAddBlankFooter && paramInt == 2) {
        this.blank_view1.setVisibility(8);
        this.blank_view2.setVisibility(0);
        this.ll_blank_footer.setVisibility(0);
      } else {
        this.ll_blank_footer.setVisibility(8);
        this.blank_view1.setVisibility(8);
        this.blank_view2.setVisibility(8);
      } 
      this.isLoadFull = true;
      this.loading.setVisibility(8);
      this.more.setVisibility(8);
      this.noData.setVisibility(8);
      if (this.nPage == 0) {
        this.loadFull.setVisibility(8);
        return;
      } 
      this.loadFull.setVisibility(0);
      return;
    } 
    if (paramInt == this.pageSize) {
      this.ll_blank_footer.setVisibility(8);
      this.blank_view1.setVisibility(8);
      this.blank_view2.setVisibility(8);
      this.isLoadFull = false;
      this.loadFull.setVisibility(8);
      this.loading.setVisibility(0);
      this.more.setVisibility(0);
      this.noData.setVisibility(8);
    } 
  }
  
  public static interface a {
    void a(PosAutoListView param1PosAutoListView, l param1l, int param1Int, List<Map<String, ?>> param1List);
  }
  
  public static interface b {
    void onRefresh();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\listview\PosAutoListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */