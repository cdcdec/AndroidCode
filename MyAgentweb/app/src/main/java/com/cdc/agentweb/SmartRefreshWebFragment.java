package com.cdc.agentweb;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.just.agentweb.IWebLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

public class SmartRefreshWebFragment extends BounceWebFragment{
    public static SmartRefreshWebFragment getInstance(Bundle bundle) {
        SmartRefreshWebFragment mBounceWebFragment = new SmartRefreshWebFragment();
        if (mBounceWebFragment != null){
            mBounceWebFragment.setArguments(bundle);
        }
        return mBounceWebFragment;
    }

    private SmartRefreshWebLayout mSmartRefreshWebLayout = null;

    @Override
    public String getUrl() {
        return super.getUrl();
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final SmartRefreshLayout mSmartRefreshLayout = (SmartRefreshLayout) this.mSmartRefreshWebLayout.getLayout();

        final WebView mWebView = this.mSmartRefreshWebLayout.getWebView();
        mSmartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mAgentWeb.getUrlLoader().reload();

                mSmartRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSmartRefreshLayout.finishRefresh();
                    }
                }, 2000);
            }
        });
       // mSmartRefreshLayout.autoRefresh();

    }


    @Override
    protected IWebLayout getWebLayout() {
        //return new WebLayout(getActivity());
        return this.mSmartRefreshWebLayout = new SmartRefreshWebLayout(this.getActivity());
    }


    @Override
    protected void addBGChild(FrameLayout frameLayout) {
        frameLayout.setBackgroundColor(Color.TRANSPARENT);

    }


}
