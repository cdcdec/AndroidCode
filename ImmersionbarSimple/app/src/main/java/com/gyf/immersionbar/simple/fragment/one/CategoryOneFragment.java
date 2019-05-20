package com.gyf.immersionbar.simple.fragment.one;

import android.support.v7.widget.Toolbar;
import butterknife.BindView;
import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.simple.R;
import com.gyf.immersionbar.simple.fragment.BaseImmersionFragment;

/**
 * @author geyifeng
 * @date 2017/5/12
 */
public class CategoryOneFragment extends BaseImmersionFragment {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_one_category;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this)
                .titleBar(toolbar)
                .statusBarDarkFont(true, 0.2f)
                .navigationBarColor(R.color.btn3)
                .init();
    }
}
