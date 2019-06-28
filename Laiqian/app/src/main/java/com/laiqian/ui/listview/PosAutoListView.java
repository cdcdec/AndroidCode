package com.laiqian.diamond2.ui.listview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.ListView;
import com.laiqian.diamond2.R;

public class PosAutoListView extends ListView implements AbsListView.OnScrollListener {

    private  boolean isShowBottom;
    private  int nTopHeightDp;
    private  boolean isShowTop;
    private Context mContext;
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

    private void initView(Context paramContext) {
    }

    public PosAutoListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        initView(paramContext);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }
}
