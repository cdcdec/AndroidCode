package com.cdc.okhttp3;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.*;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BottomDialog extends Dialog {

    private BottomDialog bottomDialog;
    public BottomDialog(@NonNull Context context) {
        super(context);
    }

    public BottomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected BottomDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);

    }

    private String title;
    private String content;

    private TextView tvTitle;
    private TextView tvContent;
    private ImageView ivClose;

    private Window window;


    /**
     * 初始化界面控件的显示数据
     */
    private void initData() {
        //如果用户自定了title和message
        if (title != null) {
            tvTitle.setText(title);
        }
        if (content != null) {
            tvContent.setText(content);
        }
    }



    public void setTitle(String title) {
        this.title = title;
    }




    public void setContent(String content) {
        this.content = content;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_dialog);
        setCanceledOnTouchOutside(false);
        bottomDialog=this;
        setWindowConstraints();

        initView();

        initData();

    }

    private void setWindowConstraints(){
        window=this.getWindow();
        //设置window背景，默认的背景会有Padding值，不能全屏。当然不一定要是透明，你可以设置其他背景，替换默认的背景即可。
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        WindowManager windowManager=window.getWindowManager();
        Display display=windowManager.getDefaultDisplay();
        Point size=new Point();
        display.getSize(size);

        int windowWidth = size.x;
        int windowHeight = size.y;

        WindowManager.LayoutParams params = window.getAttributes();

        //params.width = WindowManager.LayoutParams.MATCH_PARENT; 此时:WindowManager.LayoutParams.MATCH_PARENT=windowWidth
        params.width = windowWidth;
        params.height = windowHeight-200;
       params.gravity= Gravity.BOTTOM |Gravity.CENTER_HORIZONTAL;
        params.dimAmount = 0;
        params.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        window.setAttributes(params);

    }

    private void initView(){
        ivClose=window.findViewById(R.id.closeIv);
        tvTitle=window.findViewById(R.id.tvUrl);
        tvContent=window.findViewById(R.id.tvContent);

        ivClose.setOnClickListener(v -> {
            bottomDialog.hide();
            bottomDialog.dismiss();
        });
    }
}
