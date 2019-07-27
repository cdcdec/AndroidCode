package com.gyf.immersionbar.simple.fragment.one;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.gyf.immersionbar.ImmersionBar;
import com.gyf.immersionbar.simple.R;
import com.gyf.immersionbar.simple.fragment.BaseImmersionFragment;

/**
 * @author geyifeng
 * @date 2017/5/12
 */
public class MineOneFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_one_mine,container, false);
       // return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImmersionBar.with(this)
                .titleBar(R.id.toolbar)
                .statusBarDarkFont(true)
                .navigationBarColor(R.color.btn1)
                .navigationBarDarkIcon(true)
                .init();

    }

    //    @Override
//    protected int getLayoutId() {
//        return R.layout.fragment_one_mine;
//    }
//
//    @Override
//    public void initImmersionBar() {
//        super.initImmersionBar();
//        ImmersionBar.with(this)
//                .statusBarDarkFont(true)
//                .navigationBarColor(R.color.btn1)
//                .navigationBarDarkIcon(true)
//                .init();
//    }
}
